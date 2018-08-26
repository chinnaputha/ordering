package com.chinna.objectmap;


public enum IPizzaObjectMap {
	
	
	PIZZA_LOGIN_FRAME_CSS("iframe[class='login-iframe']"),
	PIZZA_LOGIN_USER_CSS("input#username"),
	PIZZA_LOGIN_PWD_CSS("input#password"),
	PIZZA_LOGIN_SUBMIT_LINK("Sign On"),
	PIZZA_LOGOUT_CSS("button[title='Logout']");
	
	
	
	private String locator;

	IPizzaObjectMap(String locator) {
		this.locator = locator;
	}

	public String toString() {
		return this.locator;
	}
}
