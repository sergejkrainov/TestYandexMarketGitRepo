package variables;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

/**
 * Глобальные переменные, где храним разную информацию
 * @author Сергей
 *
 */
public class YandexMarketCalcVariables {
	
	public static WebDriver driver;
	public static HashMap<String,String> searchMobilePhoneResults = new HashMap<String,String>();

}
