package org.sam;

import org.base.baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoProject extends baseclass{
	public PojoProject() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//span[text()='Login']") 
	private WebElement clickBtn;
	
	@FindBy(xpath = "//input[@class='r4vIwl BV+Dqf']")
	private WebElement email;

	public WebElement getclickBtn() {
		return clickBtn;
	}

	public WebElement getEmail() {
		return email;
	}

	
		

		
		
		
		
		
		
		
	}


