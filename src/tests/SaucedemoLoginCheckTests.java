package tests;

import org.junit.Test;
import org.openqa.selenium.Keys;

import junit.framework.Assert;
import testdata.URL;
import testmessages.Messages;

@SuppressWarnings("deprecation")
public class SaucedemoLoginCheckTests extends SaucedemoBaseTest{

	@Test
	public void startPageChecks() {
		// CURRENT URL, TITLE, PAGE SOURCE, WINDOW HANDLE
		startPage.generalInfos();
		
		// Start page checks before login!
		
		Assert.assertEquals(Messages.LOGIN_LOGO, startPage.getHeaderClassName());
		Assert.assertEquals(Messages.LOGIN_BUTTON_COLOR, startPage.loginButtonColorCheck());
		startPage.loginButtonXYLocationCheck();
		Assert.assertTrue(startPage.getRobotSeen());
		// RIGHT PAGE IMAGE LOCATION
		startPage.robotLocationCheck();
		
		// GET ALL THE USERNAMES TEXTS
		Assert.assertTrue(startPage.getLoginCredentialsUser().contains(Messages.ACCEPTED_USERS));
		Assert.assertTrue(startPage.getLoginCredentialsUser().contains(Messages.USERNAME));
		Assert.assertTrue(startPage.getLoginCredentialsUser().contains(Messages.USERNAME_PROBLEM_USER));
		// CHECK USERNAME PRESENCE ON THE PAGE
		Assert.assertTrue(startPage.getUserCheck());
		Assert.assertEquals(Messages.ACCEPTED_USERS, startPage.geth4User());
		
		// GET THE PASSWORDS TEXT
		Assert.assertTrue(startPage.getLoginCredentialsPassword().contains(Messages.ACCEPTED_PASSWORD));
		Assert.assertTrue(startPage.getLoginCredentialsPassword().contains(Messages.PASSWORD));

		// CHECK PASSWORDS PRESENCE ON THE PAGE
		Assert.assertTrue(startPage.getPasswordCheck());
		Assert.assertEquals(Messages.ACCEPTED_PASSWORD, startPage.geth4Password());	
		Assert.assertEquals(Messages.STARTPAGE_PROPERTIES, startPage.chenarUpper());
		Assert.assertEquals(Messages.STARTPAGE_PROPERTIES, startPage.getLoginCredentialsBox());
		Assert.assertEquals(startPage.chenarUpper(), startPage.getLoginCredentialsBox());
		Assert.assertTrue(startPage.credentialsTextStyle().contains(Messages.ARIAL));
		Assert.assertTrue(startPage.getBottomBoxUserPass());
	}
	
	@Test
	public void elementNotOnPage() {
		Assert.assertEquals(URL.BASE_URL, driver.getCurrentUrl());
		try {
			header.peekPicture();
		}catch (Exception e) {
			loginValidInvalidDataPage.authenticate(userloginTD.getUserName(), userloginTD.getPassword());
			Assert.assertTrue(header.peekPicture());
//			System.out.println("Picture catched!");
		}finally {
			System.out.println("Picture found after login on another page 	" + URL.INV_URL);
		}
	}
	
	@Test
	public void loginLogoutValidDataKeyboardActions() {
		loginValidInvalidDataPage.usernameInput(userloginTD.getUserName());
		loginValidInvalidDataPage.usernameInput(Keys.CONTROL+"A");
		loginValidInvalidDataPage.usernameInput(Keys.CONTROL+"C");		
		loginValidInvalidDataPage.usernameInput(Keys.TAB);		
		loginValidInvalidDataPage.passwordInput(Keys.CONTROL+"V");		
		for (int i = 0; i <= 13;i++) {
			loginValidInvalidDataPage.passwordInput(Keys.BACK_SPACE);
		}		
		loginValidInvalidDataPage.passwordInput(userloginTD.getPassword());		
		loginValidInvalidDataPage.loginClick();		
		header.burgerButtonClick();
//		header.logoutClick();
		logoutPage.logOutClick();
	}
	
	@Test
	public void loginLogoutValidData() {
		loginValidInvalidDataPage.authenticate(userloginTD.getUserName(), userloginTD.getPassword());
		Assert.assertEquals(Messages.USERNAME, userloginTD.getUserName());
		Assert.assertEquals(Messages.PASSWORD, userloginTD.getPassword());
		header.burgerButtonClick();
//		header.logoutClick();
		logoutPage.logOutClick();
	}
	
	@Test
	public void loginInvalidData() {
		userloginTD.setUserName(Messages.WRONG_USERNAME_USERNAME);
		userloginTD.setPassword(Messages.WRONG_PASSWORD_PASS123);
		loginValidInvalidDataPage.authenticate(userloginTD.getUserName(), userloginTD.getPassword());	
		Assert.assertEquals(Messages.ERROR_MSG_1, loginValidInvalidDataPage.getErrorMsgText());		
	}
	
	@Test
	public void loginInvalidDataNewJson() {
		loginValidInvalidDataPage.authenticate(userinvalidloginTD.getUserName(), userinvalidloginTD.getPassword());	
		Assert.assertEquals(Messages.ERROR_MSG_1, loginValidInvalidDataPage.getErrorMsgText());		
	}
	
	@Test
	public void loginInvalidDataBlank() {
		userloginTD.setUserName(Messages.WRONG_USERNAME_BLANK);
		userloginTD.setPassword(Messages.WRONG_PASSWORD_BLANK);
		loginValidInvalidDataPage.authenticate(userloginTD.getUserName(), userloginTD.getPassword());	
		Assert.assertEquals(Messages.ERROR_MSG_2, loginValidInvalidDataPage.getErrorMsgText());
	}
	
	@Test
	public void loginInvalidDataBlankPassword() {
		userloginTD.setUserName(Messages.USERNAME_PROBLEM_USER);
		userloginTD.setPassword(Messages.WRONG_PASSWORD_BLANK);
		loginValidInvalidDataPage.authenticate(userloginTD.getUserName(), userloginTD.getPassword());	
		Assert.assertEquals(Messages.ERROR_MSG_3, loginValidInvalidDataPage.getErrorMsgText());
	}
	
	@Test
	public void loginInvalidDataBlankPassword2() {
		userloginTD.setUserName(Messages.WRONG_USERNAME_D1655);
		userloginTD.setPassword(Messages.WRONG_PASSWORD_BLANK);
		loginValidInvalidDataPage.authenticate(userloginTD.getUserName(), userloginTD.getPassword());	
		Assert.assertEquals(Messages.ERROR_MSG_3, loginValidInvalidDataPage.getErrorMsgText());
	}
	
}
