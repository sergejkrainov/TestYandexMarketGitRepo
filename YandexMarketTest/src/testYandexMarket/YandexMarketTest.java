package testYandexMarket;



import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import BrowserActions.YandexMarket;
import jUnitTests.TestYandexMarket;
import libs.InitTest;

/**
 * ������ ��� �����������, ����� ������� ������
 * @author ������
 *
 */
public class YandexMarketTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//������������� �����
		InitTest.initBrowser();
		
		//���������� �������� � ��������
		YandexMarket.searchMobilePhone();
		
		//���������� ������ � junit
		Result result = JUnitCore.runClasses(TestYandexMarket.class);
		
		System.out.println("Total number of tests " + result.getRunCount());
		System.out.println("Total number of tests failed " + result.getFailureCount());
	}

}
