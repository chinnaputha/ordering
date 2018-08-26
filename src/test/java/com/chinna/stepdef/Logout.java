package com.chinna.stepdef;

import com.chinna.pages.LoginPage;
import com.chinna.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Logout  extends TestBase{
	
	@Given("^click logout button$")
	public void click_logout_button() throws Throwable {
		System.out.println("object value-->"+driver);
		new LoginPage(driver).clickLogout();
	}

	@When("^app should comeout from home page$")
	public void app_should_comeout_from_home_page() throws Throwable {
		new LoginPage(driver).waitForComeOutHomePage();
	}

	@Then("^login page should display$")
	public void login_page_should_display() throws Throwable {
		new LoginPage(driver).waitForLoginPage();
		closeBrowser();
	}
	
	/*@After
	public void killBrowser(){
		new TestBase().closeBrowser();
	}*/
	
}
