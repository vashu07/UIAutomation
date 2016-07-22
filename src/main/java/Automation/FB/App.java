package Automation.FB;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.sql.rowset.WebRowSet;

import locators.locatorsRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Hello world!
 *
 */

public class App extends locatorsRepository {
	static WebDriver driver;
	FileInputStream datasheet;
	Properties config = new Properties();
	String browser;

	public void browserSetUp() {

		try {
			datasheet = new FileInputStream(
					"./src/test/resources/config/browser.properties");
			config.load(datasheet);
			browser = config.getProperty("browser");
			System.out.println(browser);
			if (datasheet != null) {
				if (browser.equals("chrome")) {
					System.setProperty("webdriver.chrome.driver",
							"E:\\Selenium\\chromedriver.exe");
					System.out.println("Start");
					String userProfile = "C:\\Users\\Varsha.Prabhakar\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
					ChromeOptions options = new ChromeOptions();
					options.addArguments("user-data-dir=" + userProfile);
					System.out.println(options);
					driver = new ChromeDriver(options);
					System.out.println("chrome");
				} else if (browser.equals("firefox")) {
					driver = new FirefoxDriver();
					System.out.println("firefox");

				} else {
					System.out.println("Nothing seleted");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("no browser selected");

		}
	}

	public void preLogin() {

		String url = "https://www.facebook.com/";
		driver.get(url);
		System.out.println("url entered");
		// driver.manage().window().maximize();
	}

	public void login() {
		// username
		WebElement findemail = driver.findElement(By.name(email));
		System.out.println(email);
		findemail.clear();
		findemail.sendKeys("cadecain12@gmail.com");

		// password
		WebElement password = driver.findElement(By.name(elementOfPassword));
		password.sendKeys("testqwerty");

		// login
		WebElement login = driver.findElement(By.id(elementofLoginButton));
		login.click();
	}

	public void homeLink() {
		// click on home link : working
		WebElement homeLink = driver.findElement(By.xpath(elementOfHomeLink));
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(elementOfHomeLink)));
		if (homeLink.isDisplayed()) {
			homeLink.click();
			System.out.println("home clicked");
		}
	}

	public void seeAll() {
		// Click on See all
		driver.findElement(By.linkText("See All")).click();
		System.out.println("see all clicked");
	}

	public void allLikeButton() throws InterruptedException {

		List<WebElement> LikeElements = driver.findElements(By
				.xpath("//div/span/button"));
		for (WebElement element : LikeElements) {
			Thread.sleep(1000);
			element.click();
			System.out.println("all like");
		}
	}

	public void continuingWithExecution() {
		System.out.println("continumg method is called");
		return;

	}

	public void allLike() throws InterruptedException {
		try {
			allLikeButton();
		} catch (Exception e) {
			driver.navigate().refresh();
			System.out.println("error caught");
			continuingWithExecution();
		}
	}

	public void BackToHome() {
		System.out.println("enetered back to home");
		WebElement backToHome = driver.findElement(By
				.xpath(elementOfBackToHome));
		backToHome.click();
		System.out.println("backToHome clicked");

	}

	public void joinButton() throws InterruptedException {
		// click on join button
		List<WebElement> joinElements = driver.findElements(By
				.cssSelector(elementOfjoin));
		for (WebElement element : joinElements) {
			element.click();
			Thread.sleep(1000);
			System.out.println("clicked on join button");
		}
	}

	public void deleteAllGroups() {
		// delete all the groups
		WebElement clickOnGroups = driver.findElement(By
				.xpath(elementOfClickOnGroups));
		clickOnGroups.click();
		System.out.println("deleted groups");

	}

	public void settingToDeleteGroup() {
		// click on settings button to delete group
		WebElement clickOnSettingButton = driver.findElement(By
				.xpath(elementsOfClickOnSettingButton));
		clickOnSettingButton.click();
		System.out.println("settings clicked");
	}

	public void leaveTheGroup() throws InterruptedException {
		// click on leave this group link
		Thread.sleep(1000);
		WebElement clickOnLeaveGroup = driver.findElement(By
				.xpath(elementOfClickOnLeaveGroup));
		clickOnLeaveGroup.click();
		System.out.println("Leave group clicked");
	}

	public void ConfirmLeavingGroup() throws InterruptedException {
		// confirm leaving the group
		Thread.sleep(2000);
		WebElement confirmLeaveGroup = driver.findElement(By
				.xpath(elementOfConfirmLeave));
		if (confirmLeaveGroup.isDisplayed()) {
			confirmLeaveGroup.click();
			System.out.println("Left group");

		}
		
		Thread.sleep(2000);

	}

	// ///////////////////////////////////////////////////////////////
	
	public void clickOnHomeLinkFromLeaveGroup() throws InterruptedException{
		driver.navigate().refresh();
		WebElement homeLinkLeaveGroup = driver.findElement(By.xpath(elementOfClickOnGroups));
		homeLinkLeaveGroup.click();
		System.out.println("Home link clickd");
	}
	

	public void clickOnYourPosts() {
		// click on your posts : working
		WebElement yourPosts = driver.findElement(By.xpath(elementOfYourPosts));
		yourPosts.click();
		System.out.println("post clicked");
	}

	public void clickOnNewsFeed() throws InterruptedException {
		// news feed:working
		WebElement newsFeed = driver.findElement(By.xpath(elementOfNewsFeeds));
		newsFeed.click();
		System.out.println("news feed clicked");
		Thread.sleep(2000);
	}

	public void dropDownButton() {
		// drop down button: working
		WebElement dropDownButton_newsFeed = driver.findElement(By
				.xpath(elementOfNewsFeedsDropDownButton));
		if (dropDownButton_newsFeed.isDisplayed()) {
			dropDownButton_newsFeed.click();
			System.out.println("dropdown clicked");
		}
	}

	public void topStories() throws InterruptedException {
		// Top stories:working
		WebElement newsFeed_TopStories = driver.findElement(By
				.xpath(elementOfNFTopStories));
		newsFeed_TopStories.click();
		System.out.println("top stories clicked");
		Thread.sleep(2000);
	}

	public void clickOnMostRecent() throws InterruptedException {
		// mostrecent
		WebElement newsFeed_MostRecent = driver.findElement(By
				.xpath(elementOfNTMostRecent));
		newsFeed_MostRecent.click();
		System.out.println("most recent clicked from drop down");
		Thread.sleep(2000);
	}

	public void scrollMouse() throws InterruptedException {
		// scroll mouse: working
		((JavascriptExecutor) driver).executeScript("scroll(0,250);"); //
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,-250);");
		System.out.println("scrolling the mouse"); // Thread.sleep(2000);

	}

	public void uploadAPic() throws InterruptedException, IOException {
		// upload a pic using autoit
		WebElement userProflie = driver.findElement(By
				.xpath(elementOfUserProfile));
		userProflie.click();
		System.out.println("click on user profile");

		Thread.sleep(2000);
		
		// click on upload picture
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		System.out.println("cursor coming here");
		WebElement we = driver.findElement(By.xpath(elementOfUploadPicIsDisplayed));
		
		System.out.println("curson coming her 2");
		if (we.isDisplayed()) {
			action.moveToElement(we)
					.moveToElement(
							driver.findElement(By.xpath(elementOfUploadPic)))
					.click().build().perform();
		}

		// using autoit
		String autoIt = "E:\\autoItSamples\\pictureuploadFacebook.exe";
		Runtime.getRuntime().exec(autoIt);
		Thread.sleep(13000);

		// change the position of the pic
		String autoIt1 = "E:\\autoItSamples\\mousePosition.exe";
		Runtime.getRuntime().exec(autoIt1);
		Thread.sleep(8000);
	}

	public void clickOnSaveButton() throws InterruptedException {
		// click on Save button
		WebElement saveButton = driver.findElement(By
				.xpath(elementOfUploadPicSaveButton));
		Thread.sleep(3000);
		saveButton.click();
		System.out.println("save button");
		Thread.sleep(3000);
	}

	public void clickOnProfile() throws InterruptedException {
		// click oncade profile picture
		WebElement profilePicture = driver.findElement(By
				.xpath(elementOfProfilePic));
		if (profilePicture.isDisplayed()) {
			profilePicture.click();
			System.out.println("profile picture cliceked");
		}
		Thread.sleep(1000);
	}

	public void clickOnOptions() throws InterruptedException {
		// click onoptions in profile picture
		WebElement clickoptions = driver.findElement(By
				.xpath(elementOfOptionButton));
		clickoptions.click();
		System.out.println("Clicked on options");
		Thread.sleep(1000);

	}

	public void deleteProfliePicture() throws InterruptedException {

		// click on delete this photo
		WebElement deleteProfilePicture = driver.findElement(By
				.xpath(elementOfDeleteButton));
		deleteProfilePicture.click();
		System.out.println("click on delete");
		Thread.sleep(1000);
		// click on confirm
		WebElement confirmButton = driver.findElement(By
				.xpath(elementofConfirmDelete));
		confirmButton.click();
		System.out.println("click on confirm");
		Thread.sleep(1000);
		// close the pop up
		WebElement closePopup = driver.findElement(By
				.xpath(elementOfClosePopUp));
		closePopup.click();
		System.out.println("close pop up");
		driver.navigate().refresh();
	}

	public void searchForFriends() throws InterruptedException {
		// searchfor friends
		WebElement searchFriends = driver.findElement(By
				.xpath(elementOfSearchFriendsTextBox));
		searchFriends.clear();
		searchFriends.sendKeys("varsha");
		System.out.println("searching friends");
		Thread.sleep(2000);
	}

	public void clickOnSeeAllResults() {
		// select see all results from dropdown
		driver.findElement(By.xpath(elementOfSeeAllLink)).click();
		System.out.println("selecting see all results from drop down");
	}

	public void clickOnSearchButton() {
		// select search button
		driver.findElement(By.xpath(elementOfSearchButton)).click();
		System.out.println("click on search button");

	}

	public void clickOnMidDiv() {
		// select mid div
		ArrayList<WebElement> listOfNames = new ArrayList<WebElement>();
		WebElement midDiv = driver.findElement(By
				.xpath(elementOfSearchFriendsProfile));
		listOfNames.add(midDiv);
		System.out.println(listOfNames);

	}

	public void clickOnRandomProfile() {
		// Click on random profile
		List<WebElement> allElements = driver.findElements(By
				.xpath(elementOfRandomFriends));
		for (WebElement element : allElements) {
			System.out.println(element.getText());
		}
		int i = allElements.size();
		System.out.println("size of the list" + i);
		Random random = new Random();
		int a = random.nextInt(i - 0) + 0;
		System.out.println("random number" + a);
		String s = "//div[@class='_50c9']/div/div/div[2]/div[2]/div/ul/li";
		String s3 = "[" + a;
		String s1 = "]";
		String s2 = elementOfRandomFriends.toString().concat(s3).concat(s1);
		System.out.println("xpath:" + s2);
		WebElement clickRandomName = driver.findElement(By.xpath(s2));
		clickRandomName.click();
		System.out.println("click on a random profile");
	}

	public void logout() throws InterruptedException {
		// navigate to log out button: working
		WebElement logOut_dropDown = driver.findElement(By
				.id(elementOfLogoutDropDown));
		logOut_dropDown.click();
		System.out.println("click logout button");
		Thread.sleep(2000);
		// logout: working
		WebElement logoutButton = driver.findElement(By
				.xpath(elementofLogoutButton));
		if (logoutButton.isDisplayed()) {
			logoutButton.click();
			System.out.println("logged out");
		}

		// close the browser
		driver.close();
		System.out.println("closed the driver");
	}

}
