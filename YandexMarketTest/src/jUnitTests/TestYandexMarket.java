package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import variables.YandexMarketCalcVariables;

/**
 * ����� ��� ���������� ������
 * @author ������
 *
 */
public class TestYandexMarket {

	
	@Test
    public void testYandexMarket() {		
		
        assertEquals("isCatalogPresent","true", YandexMarketCalcVariables.searchMobilePhoneResults.get("isCatalogPresent"));
        assertEquals("isElectronicaPresent","true", YandexMarketCalcVariables.searchMobilePhoneResults.get("isElectronicaPresent"));
        assertEquals("isPopularPresent","true", YandexMarketCalcVariables.searchMobilePhoneResults.get("isPopularPresent"));
        assertEquals("isInterestingPresent","true", YandexMarketCalcVariables.searchMobilePhoneResults.get("isInterestingPresent"));
        assertEquals("isArticlesPresent","true", YandexMarketCalcVariables.searchMobilePhoneResults.get("isArticlesPresent"));
        assertEquals("popularCount","3", YandexMarketCalcVariables.searchMobilePhoneResults.get("popularCount"));
        assertEquals("isCatalogPresent","true", YandexMarketCalcVariables.searchMobilePhoneResults.get("isCatalogPresent"));
        assertEquals("isCatalogPresent","true", YandexMarketCalcVariables.searchMobilePhoneResults.get("isCatalogPresent"));
        assertEquals("isCatalogPresent","true", YandexMarketCalcVariables.searchMobilePhoneResults.get("isCatalogPresent"));

    }
}
