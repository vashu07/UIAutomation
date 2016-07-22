package Automation.FB;

import java.io.IOException;

import junit.framework.TestCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class AppTest extends App {

	App pageObject = new App();
	
		//@SuppressWarnings("static-access")
	@BeforeClass
	public void initialsetUp() {
		
		pageObject.browserSetUp();
		pageObject.preLogin();
		pageObject.login();
	}

//	/@SuppressWarnings("static-access")
	@Test
	public void testcases() throws InterruptedException, IOException {
		pageObject.homeLink();
		/*pageObject.seeAll();
		pageObject.allLike();
		pageObject.BackToHome();
		pageObject.joinButton();
		pageObject.deleteAllGroups();
		pageObject.settingToDeleteGroup();
		pageObject.leaveTheGroup();
		pageObject.ConfirmLeavingGroup();*/
		//pageObject.clickOnHomeLinkFromLeaveGroup();
		//pageObject.BackToHome();
		/*pageObject.clickOnYourPosts();
		pageObject.BackToHome();
		pageObject.clickOnNewsFeed();
		pageObject.dropDownButton();
		pageObject.topStories();
		pageObject.dropDownButton();
		pageObject.clickOnMostRecent();
		pageObject.scrollMouse();*/
		pageObject.uploadAPic();
		pageObject.clickOnSaveButton();
		pageObject.clickOnProfile();
		pageObject.clickOnOptions();
		pageObject.deleteProfliePicture();
		pageObject.BackToHome();
		pageObject.searchForFriends();
		pageObject.clickOnSeeAllResults();
		pageObject.clickOnSearchButton();
		pageObject.clickOnMidDiv();
		pageObject.clickOnRandomProfile();

	}

	@SuppressWarnings("static-access")
	@AfterClass
	private void closeDriver() throws InterruptedException {
		pageObject.logout();

	}

}
