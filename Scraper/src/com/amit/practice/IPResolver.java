package com.amit.practice;

public class IPResolver {
	/**
	 * @param ipAddress
	 *            the IPv4 address to be resolved to location
	 * @param ipInfo
	 *            plaintext location or other information that is returned
	 */
	String ipAddress;
	String ipInfo;

	public IPResolver(String declaredAddress) {
		ipAddress = declaredAddress;
		Webpage ipInfoObj = new Webpage("http://freegeoip.net/xml/" + ipAddress);
		ipInfo = ipInfoObj.getString();
	}

	public String getCountry() {
		int startCtry = ipInfo.indexOf("<CountryName>") + 13;
		int endCtry = ipInfo.indexOf("</CountryName>");
		return ipInfo.substring(startCtry, endCtry);
	}
}