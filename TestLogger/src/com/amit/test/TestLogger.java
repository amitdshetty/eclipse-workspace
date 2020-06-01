package com.amit.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class TestLogger {

	public static final Logger LOG = Logger.getLogger(TestLogger.class.getName());
	public static final String dir_name = "logs";
	public static final String file_name = "test";
	public static final String dir_structure = dir_name + "/" + file_name;

	public static void main(String[] args) {
		String sdf = new SimpleDateFormat("ddMMyyyy").format(new Date());
		try {
			File f = new File(dir_name);
			String file_prefix = "";
			if (!f.exists())
				file_prefix = f.mkdir() ? dir_structure : file_name;
			else 
				file_prefix = dir_structure;
			FileHandler localFileHandler = new FileHandler(file_prefix + sdf + ".%g.log", 1*1024*1024, 10, true);
			localFileHandler.setFormatter(new MyFormatter());
			LOG.addHandler(localFileHandler);
			LOG.setLevel(Level.ALL);
			LOG.config("Configuration Done");
		} catch (SecurityException | IOException e) {
			LOG.severe("Error in application " + e.getMessage());
		}

	}

	private static class MyFormatter extends Formatter {
		
		@Override
		public String format(LogRecord record) {
			return record.getSourceClassName() + "::" + record.getSourceMethodName()
					+ "::" + new Date(record.getMillis()) + "::" + record.getMessage() + "\n";
		}

	}
}
