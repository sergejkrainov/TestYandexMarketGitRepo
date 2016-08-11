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
 * Класс для инициализации тестовых данных
 * @author Сергей
 *
 */
public class InitTest {
	public static void initBrowser(){
		String browserName = YandexMarketConfig.browserName;
		if(browserName.equals("firefox")){
			YandexMarketCalcVariables.driver = new FirefoxDriver();
		}
		if(browserName.equals("ie")){//Путь необходимо переделать на относительный(из-за ограниченности времени пока так оставил), тут лежит драйвер для работы с ИЕ
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Сергей\\JavaProjects\\TestYandexMarket\\YandexMarketTest\\libs\\IEDriverServer.exe");
			YandexMarketCalcVariables.driver = new InternetExplorerDriver();
		}
		
		YandexMarketCalcVariables.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
	}

}
