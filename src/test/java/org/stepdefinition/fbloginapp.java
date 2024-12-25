package org.stepdefinition;

import org.base.baseclass;

import FbPojo.FbLoginPojo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class fbloginapp extends baseclass {
	@Given("User has to launch the browser and maximize the window")
	public void user_has_to_launch_the_browser_and_maximize_the_window() {
                launchBrowser();
                WindowMaximize();

	}

	@Given("User has to hit the Gmail Url")
	public void user_has_to_hit_the_Gmail_Url() {
                launchUrl("https://mail.google.com/mail/");
     }

	@Given("User has to pass the data{string} in email field")
	public void user_has_to_pass_the_data_in_email_field(String em) {
		FbLoginPojo f=new FbLoginPojo();
		PassText(em, f.getEmail());


	}

	@Given("User has to click the nxtBtn")
	public void user_has_to_click_the_nxtBtn() {
		FbLoginPojo f=new FbLoginPojo();
		clickBtn(f.getNxtBtnclick());


	}

	@Given("User has to pass the data{string} in password field")
	public void user_has_to_pass_the_data_in_password_field(String pass) {
		FbLoginPojo f=new FbLoginPojo();
		PassText(pass, f.getPassword());


	}

	@Given("User has to click the nextLoginBtn")
	public void user_has_to_click_the_nextLoginBtn() {
		FbLoginPojo f=new FbLoginPojo();
		clickBtn(f.getNextLoginBtn());


	}

	@Then("User has to close the browser")
	public void user_has_to_close_the_browser() {
		closeEntireBrowse();


	}



}
