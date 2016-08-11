package libs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Config.YandexMarketConfig;
import variables.YandexMarketCalcVariables;
import org.openqa.selenium.WebDriver.Timeouts;

/**
 * ����� ��� ������������� �������� ������
 * @author ������
 *
 */
public class InitTest {
	public static void initBrowser(){
		String browserName = YandexMarketConfig.browserName;
		if(browserName.equals("firefox")){
			YandexMarketCalcVariables.driver = new FirefoxDriver();
		}
		if(browserName.equals("ie")){//���� ���������� ���������� �� �������������(��-�� �������������� ������� ���� ��� �������), ��� ����� ������� ��� ������ � ��
			System.setProperty("webdriver.ie.driver", "C:\\Users\\������\\JavaProjects\\TestYandexMarket\\YandexMarketTest\\libs\\IEDriverServer.exe");
			YandexMarketCalcVariables.driver = new InternetExplorerDriver();
		}
		
		YandexMarketCalcVariables.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
	}

}
