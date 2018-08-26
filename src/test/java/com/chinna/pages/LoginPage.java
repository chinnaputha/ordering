package com.chinna.pages;

import org.openqa.selenium.WebDriver;

import com.chinna.objectmap.IPizzaObjectMap;
import com.chinna.util.BrowserAction;

public class LoginPage {
	
	WebDriver driver;
	BrowserAction action;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	 
	public void loginToDominos() throws Exception{
		action = new BrowserAction(driver);
		action.swithToFrame(IPizzaObjectMap.PIZZA_LOGIN_FRAME_CSS);
		action.enterFieldValue(IPizzaObjectMap.PIZZA_LOGIN_USER_CSS, "mvelass");
		action.enterFieldValue(IPizzaObjectMap.PIZZA_LOGIN_USER_CSS, "SellMorePizza1");
		action.click(IPizzaObjectMap.PIZZA_LOGIN_SUBMIT_LINK);
		
	
	}
}
