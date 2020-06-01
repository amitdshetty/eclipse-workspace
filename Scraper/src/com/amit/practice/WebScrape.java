package com.amit.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.opencsv.CSVWriter;

public class WebScrape {
	public static void main(String[] args) {
		String url = "https://shares.telegraph.co.uk/indices/summary/index/MCX";
		WebScrape webScrape = new WebScrape();
		List<WebScapeDataModel> webScrapeList = new ArrayList<>();
		
		webScrapeList = webScrape.crawlAndExtractData(url, webScrapeList);
		
		webScrape.writeToFile(webScrapeList);
		
		webScrape.writeToCSV(webScrapeList);
		
	}

	public void writeToCSV(List<WebScapeDataModel> webScrapeList) {
		File f = new File("/Users/amitshetty/eclipse_workspace/Scraper/temp.csv");
		try {
			if(!f.exists() && !f.isDirectory()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f, true);
			CSVWriter csvWriter = new CSVWriter(fw, ',');
			String[] header = {"Ticker", "Ticker Name", "Price"};
			csvWriter.writeNext(header);
			for (WebScapeDataModel wsdm : webScrapeList) {
				String[] temp  = {wsdm.getWebScrapeTicker(),wsdm.getWebScrapeName(), String.valueOf(wsdm.getWebScrapePrice())};
				csvWriter.writeNext(temp);
			}
			csvWriter.close();
		}catch (IOException ex){
			
		}
	}

	public void writeToFile(List<WebScapeDataModel> webScrapeList) {
		try {
			File f = new File("/Users/amitshetty/eclipse_workspace/Scraper/temp.txt");
			if(!f.exists() && !f.isDirectory()) {
				f.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
			System.out.println("Writing to file ..... ");
			bw.write("======> Start of file <====== \n");
			for(WebScapeDataModel wsdm : webScrapeList) {
				//bw.write(wsdm.getWebScrapeTicker() + " , " + wsdm.getWebScrapeName() + " , " + wsdm.getWebScrapePrice() + "\n");
				bw.write(String.format("%s , %s , %.2f\n",wsdm.getWebScrapeTicker(),wsdm.getWebScrapeName(),wsdm.getWebScrapePrice()));
			}
			bw.write("======> End of file <====== \n");
			bw.close();
			System.out.println("Done writing to file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<WebScapeDataModel> crawlAndExtractData(String url, List<WebScapeDataModel> webList) {
		double totalPrice = 0;
		String ticker;
		String tickerName;
		String price;
		String tempPrice;
		Double modifiedPrice;
		
		
		try {
			Document document = Jsoup.connect(url).get();
			//Prints the entire HTML content. Good for checking elements
			//System.out.println(document.outerHtml());
			/*
			 * Use inspect element to see which element to consider correctly
			 */
			for(Element row : document.select("table.tablesorter.full tr")) {
				if(row.select("td:nth-of-type(1)").text().equals("")) {
					continue;
				} else {
					//Use ublock "block element" for finding which element to calculate 
					ticker = row.select("td:nth-of-type(1)").text();
					tickerName = row.select("td:nth-of-type(2)").text();
					price  = row.select("td.right:nth-of-type(3)").text();
					tempPrice = price.replace(",", "");
					modifiedPrice = Double.parseDouble(tempPrice);
					System.out.println(ticker + " | " + tickerName + " | " + modifiedPrice);
					totalPrice += modifiedPrice;
					webList.add(new WebScapeDataModel(ticker, tickerName, totalPrice));
				}
			}
			System.out.println(String.format("The total price for no apparent reaosn is %.2f", totalPrice));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return webList;
	}
}
