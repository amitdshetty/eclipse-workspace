package com.amit.self;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	
	private static final Logger LOG = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		LOG.info("Starting Application: PokemonCSV Loader");
		PokemonCSVProcessorService pokemonCSVProcessorService = new PokemonCSVProcessorService();
		pokemonCSVProcessorService.validateCsvFile();
		//List<PokemonBean> pokemonBeanList = pokemonCSVProcessorService.readCsvFile();
		//PokemonService pokemonService = new PokemonService();
		//pokemonService.insertDataIntoDB(pokemonBeanList);
		LOG.info("Ending Application: PokemonCSV Loader");
	}
}
