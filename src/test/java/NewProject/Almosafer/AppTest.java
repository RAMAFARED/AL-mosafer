package NewProject.Almosafer;

import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class AppTest extends TestData {

	WebDriver driver = new ChromeDriver();
	String URL = "https://www.almosafer.com/en?ncr=1";

	Random rand = new Random();

	@BeforeTest
	public void mysetup() {
		driver.get(URL);

		driver.manage().window().maximize();

	}

	@Test(priority = 1, enabled = false)
	public void Language() {
		@SuppressWarnings("deprecation")
		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		// System.out.println(Language_Element);

		Assert.assertEquals(ActualLanguage, ExpectedLanguage);

	}

	@Test(priority = 2, enabled = false)
	public void Sar() throws InterruptedException {

		WebElement sar = driver.findElement(By.cssSelector(".sc-hUfwpO.kAhsZG"));
		String Lan = sar.getText();

		Assert.assertEquals(Lan, ExpectedSar);

	}

	@Test(priority = 3, enabled = false)
	public void Number() {

		WebElement Number_con = driver.findElement(By.tagName("strong"));
		// Number_con.click();
		String Num = Number_con.getText();

		Assert.assertEquals(Num, ExpectedNumber);

	}

	@Test(priority = 4, enabled = false)
	public void Logo() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 8000)");

		WebElement logoElement = driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR"));

		Assert.assertTrue(logoElement.isDisplayed(), "Logo is visible after scrolling");
	}

	@SuppressWarnings("deprecation")
	@Test(priority = 5, enabled = false)
	public void Search_Tab() throws InterruptedException {

		WebElement FlightTab = driver.findElement(By.id("uncontrolled-tab-example-tab-flights"));

		String tabClass =FlightTab.getAttribute("class");
		Assert.assertTrue(tabClass.contains("active"),ExpectedActionTab);
		
		
		

	}

	@Test(priority = 6, enabled = false)
	public void Flight_departure() {
		WebElement dateButton = driver.findElement(By.className("sc-dXfzlN"));
		String ActualDate = dateButton.getText();

		Assert.assertEquals(ActualDate, tomorrow);

	}

	@Test(priority = 7, enabled = false)
	public void Flight_return() throws InterruptedException {
		WebElement datereturn = driver.findElement(By.xpath("//span[text()='04']"));
		String ActualDate = datereturn.getText();
		Thread.sleep(3000);
		Assert.assertEquals(ActualDate, aftertoday);

	}

	@Test(priority = 8, enabled = false)
	public void RLanguage() {

		Random random = new Random();
		int randomLang = random.nextInt(2);

		String lang;

		if (randomLang == 0) {
			lang = "ar";
		}

		else {
			lang = "en";
		}

		String url = "https://www.almosafer.com/" + lang + "?ncr=1";

		driver.get(url);

		@SuppressWarnings("deprecation")
		String actualLang = driver.findElement(By.tagName("html")).getAttribute("lang");

		Assert.assertTrue(actualLang.startsWith(lang), actualLang);

	}

	@Test(priority = 9, enabled = false)
	public void Random_Hotel() throws InterruptedException {

		Random random = new Random();
		int randomLang = random.nextInt(2);

		String lang;
		if (randomLang == 0) {
			lang = "ar";
		} else {
			lang = "en";
		}

		String url = "https://www.almosafer.com/" + lang + "?ncr=1";
		driver.get(url);

		Thread.sleep(2000);

		driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).click();
		Thread.sleep(2000);

		// عرّفي المدينة حسب اللغة
		String selectedCity = "";
		if (lang.equals("ar")) {
			String[] arabicCities = { "دبي", "جدة", "رياض" };
			selectedCity = arabicCities[random.nextInt(arabicCities.length)];
		} else {
			String[] englishCities = { "Dubai", "Jeddah", "Riyadh" };
			selectedCity = englishCities[random.nextInt(englishCities.length)];
		}

		Thread.sleep(2000);

		WebElement cityy = driver.findElement(By.xpath("//*[@data-testid='AutoCompleteInput']"));
		cityy.click();
		cityy.clear();
		cityy.sendKeys(selectedCity);

	}

	@Test(priority = 10, enabled = false)
	public void Randomly_Select() throws InterruptedException {

		driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).click();
		Thread.sleep(2000);

		WebElement StaticDropdown = driver.findElement(By.className("sc-tln3e3-1"));

		Thread.sleep(1000);
		int Randomselect = rand.nextInt(OPTION_1.length);
		Select Dropdown = new Select(StaticDropdown);
		Thread.sleep(1000);

		Dropdown.selectByVisibleText(OPTION_1[Randomselect]);

		String selectedOption = Dropdown.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedOption, OPTION_1[Randomselect]);

	}

	@Test(priority = 11, enabled = false)
	public void Hotelsbtn() throws InterruptedException {

		WebElement hotelsTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		hotelsTab.click();
		Thread.sleep(2000);

		@SuppressWarnings("deprecation")
		String classAttr = hotelsTab.getAttribute("class");
		Assert.assertTrue(classAttr.contains("active"));

	}

	@Test(priority = 12, enabled = true)
	  public void NewPage() throws InterruptedException {
		  
		  
			WebElement hotelsTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
			hotelsTab.click();
			Thread.sleep(2000);

			WebElement cityy = driver.findElement(By.xpath("//*[@data-testid='AutoCompleteInput']"));
			int random_city = rand.nextInt(englishCities.length);

			cityy.sendKeys(englishCities[random_city]);
			Thread.sleep(2000);

			cityy.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
			
			

			WebElement StaticDropdown = driver.findElement(By.className("sc-tln3e3-1"));

			Thread.sleep(1000);
			int Randomselect = rand.nextInt(OPTION_1.length);
			Select Dropdown = new Select(StaticDropdown);
			//Thread.sleep(1000);

			Dropdown.selectByVisibleText(OPTION_1[Randomselect]);

			Thread.sleep(3000);
			WebElement Departure_Date = driver.findElement(By.id("js-hotelsSearchBoxDatePickerCheckInDate"));
			Departure_Date.click();
			Thread.sleep(3000);
			WebElement dateElement1 = driver.findElement(By.xpath("//span[@data-testid='HotelsSearchCalendar__2025-05-14']"));
			dateElement1.click();

			Thread.sleep(2000);
			WebElement Return_Date= driver.findElement(By.className("sc-5uo3xu-2"));
			Return_Date.click();
			Thread.sleep(2000);
			WebElement dateElement2 = driver.findElement(By.xpath("//span[@data-testid='HotelsSearchCalendar__2025-06-10']"));
			dateElement2.click();

			WebElement Searchbtn = driver.findElement(By.className("sc-1vkdpp9-5"));
			Searchbtn.click();

			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement firstHotelName = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-testid='hotel_card_hotelName']"))
			);

			Assert.assertTrue(firstHotelName.isDisplayed(), "First hotel name is not displayed after search.");
			System.out.println("Hotel Name Found: " + firstHotelName.getText());

			
		  
		  
	  }

	
	
	
	
	
	
	
	
	
	
	
}
