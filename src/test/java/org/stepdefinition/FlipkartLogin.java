package org.stepdefinition;

import org.base.baseclass;
import org.sam.PojoProject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlipkartLogin extends baseclass{
	@Given("To launch the chrome browser and maximize the window")
	public void to_launch_the_chrome_browser_and_maximize_the_window() {
	    launchBrowser();
	    WindowMaximize();
	}

	@When("To launch the url of the flipkart application")
	public void to_launch_the_url_of_the_flipkart_application() {
		launchUrl("https://www.flipkart.com/");
	    
	}

	@When("To click the login button")
	public void to_click_the_login_button() {
		PojoProject p=new PojoProject();
		clickBtn(p.getclickBtn());
	    
	}

	@When("To pass valid username in email field")
	public void to_pass_valid_username_in_email_field() {
		PojoProject p=new PojoProject();
		PassText("SeleniumInmakes@gmail.com", p.getEmail());
	   
	}

	@When("To check whether navigate to home page or not")
	public void to_check_whether_navigate_to_home_page_or_not() {
		System.out.println("Check your credenials");
	    
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
		closeEntireBrowse();
	    
	}



}
