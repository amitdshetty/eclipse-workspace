package com.amit.practice;

public class WebScapeDataModel {
	
	private String webScrapeTicker;
	private String webScrapeName;
	private double webScrapePrice;
	
	public WebScapeDataModel(String webScrapeTicker, String webScrapeName, double webScrapePrice) {
		super();
		this.webScrapeTicker = webScrapeTicker;
		this.webScrapeName = webScrapeName;
		this.webScrapePrice = webScrapePrice;
	}

	public String getWebScrapeTicker() {
		return webScrapeTicker;
	}

	public void setWebScrapeTicker(String webScrapeTicker) {
		this.webScrapeTicker = webScrapeTicker;
	}

	public String getWebScrapeName() {
		return webScrapeName;
	}

	public void setWebScrapeName(String webScrapeName) {
		this.webScrapeName = webScrapeName;
	}

	public double getWebScrapePrice() {
		return webScrapePrice;
	}

	public void setWebScrapePrice(double webScrapePrice) {
		this.webScrapePrice = webScrapePrice;
	}
	
	
}
