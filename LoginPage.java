package object_repository_pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	//identify user name text field
	@FindBy(name="user_name")
	private WebElement usernameTf;
	
	//identify password text field
	@FindBy(name="user_password")
	private WebElement passwordTf;
	
	//identify login button
	@FindBy(id="submitButton")
	private WebElement loginButton;

	
	public WebElement getUsernameTf() {
		return usernameTf;
	}

	public WebElement getPasswordTf() {
		return passwordTf;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
}
