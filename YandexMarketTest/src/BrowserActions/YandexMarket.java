package BrowserActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import Config.YandexMarketConfig;
import variables.YandexMarketCalcVariables;

/**
 * ����� ��� ���������� �������� � ��������
 * @author ������
 *
 */
public class YandexMarket {
	public static void searchMobilePhone() throws InterruptedException {

		WebDriver driver = YandexMarketCalcVariables.driver;
		driver.get(YandexMarketConfig.baseUrl);
		
		driver.manage().window().maximize();

		//��������� � �������
		driver.findElement(By.xpath("//span[@class='main-tabs__text' and text()='�������']")).click();
		
		
		YandexMarketCalcVariables.searchMobilePhoneResults.put("isCatalogPresent", String.valueOf(
				driver.findElement(By.xpath("//span[@class='main-tabs__text' and text()='�������']")).isDisplayed()));
		
		YandexMarketCalcVariables.searchMobilePhoneResults.put("isElectronicaPresent", String.valueOf(
				driver.findElement(By.xpath("//h2[@class='title title_size_18' and text()='�����������']")).isDisplayed()));
		
		YandexMarketCalcVariables.searchMobilePhoneResults.put("isPopularPresent", String.valueOf(
				driver.findElement(By.xpath("//h1[@class='title title_size_22 title_indent_bottom  ']/text[text()='���������� ������']")).isDisplayed()));
		
		//��������� ����
		driver.findElement(By.xpath("/html/body/div[1]")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.xpath("/html/body/div[1]")).sendKeys(Keys.PAGE_DOWN);
		
		
		YandexMarketCalcVariables.searchMobilePhoneResults.put("isInterestingPresent", String.valueOf(
				driver.findElement(By.xpath("//h1[@class='title title_size_22  box__title  ']/a[text()='��� ����� ����� ��������������']")).isDisplayed()));
		
		YandexMarketCalcVariables.searchMobilePhoneResults.put("isArticlesPresent", String.valueOf(
				driver.findElement(By.xpath("//h1[@class='title title_size_22 title_indent_bottom  ']/text[text()='������ � ��������']")).isDisplayed()));
		
		//��������� �����
		driver.findElement(By.xpath("/html/body/div[1]")).sendKeys(Keys.PAGE_UP);
		driver.findElement(By.xpath("/html/body/div[1]")).sendKeys(Keys.PAGE_UP);
		
		//��������� � ������ �����������
		driver.findElement(By.xpath("//h2[@class='title title_size_18' and text()='�����������']")).click();
		//��������� � ������ ��������� ��������
		driver.findElement(By.xpath("//div[@class='catalog-menu__list']/a[text()='��������� ��������']")).click();
		
		int sizeLiPopulars = driver.findElements(By.xpath("//div[@class='top-3-models' and h2[@class='top-3-models__title']"
				+ "/a[text()='����������']]/ul[@class='top-3-models__list']/li")).size();
		
		YandexMarketCalcVariables.searchMobilePhoneResults.put("popularCount", String.valueOf(sizeLiPopulars));

		//�������� �� ����������� �����
		driver.findElement(By.partialLinkText("����������� �����")).click();
		
		//���� ��
		driver.findElement(By.xpath("//input[@id='gf-pricefrom-var']")).sendKeys("5125");
		//���� ��
		driver.findElement(By.xpath("//input[@id='gf-priceto-var']")).sendKeys("10123");
		
		if(driver.findElement(By.xpath("//input[@id='glf-in-stock-select']")).getAttribute("checked").equals("false")){
			driver.findElement(By.xpath("//input[@id='glf-in-stock-select']")).click();
		}
		
		//�������� ���
		driver.findElement(By.xpath("//span[@class='title__content' and text()='���']")).click();
		
		//�������� ��������
		driver.findElement(By.xpath("//label[@class='checkbox__label' and text()='��������']")).click();
		
		//�������� Android
		driver.findElement(By.xpath("//label[@class='checkbox__label' and text()='Android']")).click();
		
		Thread.sleep(5000);
		
		//��������� �����
		driver.findElement(By.xpath("/html/body/div[1]")).sendKeys(Keys.PAGE_UP);
		
		driver.navigate().refresh();

		List<WebElement> resultPhonesAll = driver.findElements(By.xpath("//div[@class='filter-applied-results i-bem filter-applied-results_js_inited']"
				+ "/div[@class='snippet-list snippet-list_type_vertical island']"
				+ "/div[@class='snippet-card clearfix  i-bem snippet-card_js_inited']"));// �������� ��� �����, � ������� ���������� ��� ���������� �� ���������

		
		List<WebElement> resultPhonesDiv = new ArrayList<WebElement>();
		
		Random rnd = new Random();
		//��� ���� ����� �������� �������� �� ������ ���������
		resultPhonesDiv.add(resultPhonesAll.get(rnd.nextInt(resultPhonesAll.size())));
		resultPhonesDiv.add(resultPhonesAll.get(rnd.nextInt(resultPhonesAll.size())));
		resultPhonesDiv.add(resultPhonesAll.get(rnd.nextInt(resultPhonesAll.size())));
		
		String deviceName = "";
		String costFrom = "";
		String costTo = "";
		String raiting = "";
		List<String> deviceNameList = new ArrayList<String>();
		List<String> costFromList = new ArrayList<String>();
		List<String> costToList = new ArrayList<String>();
		
		for(WebElement list : resultPhonesAll){//����������� �� ��������������� ������ ��������� � ������� ������ ����������
			deviceName = list.findElement(By.xpath(".//a/span[@class='snippet-card__header-text']")).getText();
			costFrom = list.findElement(By.xpath(".//a/div[@class='snippet-card__price i-bem snippet-card__price_js_inited']/span")).getText();
			//costTo = list.findElement(By.xpath(".//div[@class='snippet-card__info']/a/div[@class='snippet-card__subprice']/span")).getText();
			//������� ������� � �������� �� ����� ����� ��� ���� �� � xpath ".//div[@class='snippet-card__info']/a/div[@class='snippet-card__subprice']/span"
			//�������� ������ ��� ������� �������� "//div[@class='snippet-card__info']/a/div[@class='snippet-card__subprice']/span" ��� �����.
			//������� ���� �� ����� ��������� �� ���������� ���� ����� �������
			costTo = "�� " + list.getText().split("��")[1].split("���.")[0] + " ���.";
			raiting = list.findElement(By.xpath(".//div[@class='rating rating_outline_yes hint i-bem hint_js_inited']")).getText();//������� ���������
			if(raiting.equals("3.5") || raiting.equals("4.0") || raiting.equals("4.5")){//����� ������ ���� ��������� �������� �������� � ������ ���������
				deviceNameList.add(deviceName);
				costFromList.add("�� " + costFrom.replaceAll("\\W", "") + " ���.");//������� ? �� ������
				costToList.add("�� " + costTo.replaceAll("\\W", "") + " ���.");//������� ? �� ������
			}

		}
		
		
		List<String> deviceNameListResult = new ArrayList<String>();
		List<String> costFromListResult = new ArrayList<String>();
		List<String> costToListResult = new ArrayList<String>();
		int rndSelected = 0;
		while(deviceNameListResult.size() != 3){//���� �� �������� 3 ��������
			
			rndSelected = rnd.nextInt(deviceNameList.size());
			deviceName = deviceNameList.get(rndSelected);
			if(deviceNameListResult.contains(deviceName)){//�������� ������ ��������� ��������
				continue;
			}else{
				deviceNameListResult.add(deviceNameList.get(rndSelected));
				costFromListResult.add(costFromList.get(rndSelected));
				costToListResult.add(costToList.get(rndSelected));
			}
			
		}
		
		for(int i = 0; i < deviceNameListResult.size(); i++){//������� ���������� �� ������������ ���������
			System.out.println(deviceNameListResult.get(i) + "  " + costFromListResult.get(i) + "  " + costToListResult.get(i));
		}
		
		

	}

}
