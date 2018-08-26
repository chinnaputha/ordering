package com.chinna.pages;

import org.openqa.selenium.WebDriver;

import com.chinna.objectmap.IPizzaObjectMap;
import com.chinna.util.BrowserAction;
import com.chinna.util.BrowserWaits;

public class LoginPage {
	
	WebDriver driver;
	BrowserAction action;
	BrowserWaits wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		action = new BrowserAction(driver);
		wait = new BrowserWaits(driver);
	}
	 
	public void loginToDominos() throws Exception{
		action.swithToFrame(IPizzaObjectMap.PIZZA_LOGIN_FRAME_CSS);
		action.enterFieldValue(IPizzaObjectMap.PIZZA_LOGIN_USER_CSS, "mvelass");
		action.enterFieldValue(IPizzaObjectMap.PIZZA_LOGIN_PWD_CSS, "SellMorePizza1!");
		action.click(IPizzaObjectMap.PIZZA_LOGIN_SUBMIT_LINK);
	}
	
	public void waitForLoginPageToLoad() throws Exception{
		wait.waitTime(4);
		driver.navigate().refresh();
		wait.waitTime(4);
		wait.waitUntilElementIsClickable(IPizzaObjectMap.PIZZA_LOGOUT_CSS, 10);
	    wait.waitUntilText("Order Entry Application", "Carryout","Delivery","Now","Later");
	}
	
	public void clickLogout() throws Exception{
		wait.waitTime(4);
		action.jsClick(IPizzaObjectMap.PIZZA_LOGOUT_CSS);
	}
	
	public void waitForComeOutHomePage() throws Exception{
		//wait.waitUntilText("Success");
	}
	
	public void waitForLoginPage() throws Exception{
		wait.waitTime(6);
		action.swithToFrame(IPizzaObjectMap.PIZZA_LOGIN_FRAME_CSS);
		wait.waitUntilElementIsClickable(IPizzaObjectMap.PIZZA_LOGIN_USER_CSS);
		wait.waitUntilElementIsClickable(IPizzaObjectMap.PIZZA_LOGIN_PWD_CSS);
		wait.waitUntilElementIsDisplayed(IPizzaObjectMap.PIZZA_LOGIN_SUBMIT_LINK);
	}
}
