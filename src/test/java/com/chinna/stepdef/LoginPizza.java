package com.chinna.stepdef;

import com.chinna.pages.LoginPage;
import com.chinna.util.TestBase;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPizza  extends TestBase{
	
	@Given("^open pizza app$")
	public void open_pizza_app() throws Throwable {
		openBrowser("Chrome");
	}

	@When("^enter valid username and password$")
	public void enter_valid_username_and_password() throws Throwable {
		new LoginPage(driver).loginToDominos();
	}

	@Then("^user should able to login$")
	public void user_should_able_to_login() throws Throwable {
	    Thread.sleep(10000);
	    driver.navigate().refresh();
	    Thread.sleep(10000);
	}
	
	@After
	public void killBrowser(){
		closeBrowser();
	}

}
