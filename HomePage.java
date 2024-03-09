package object_repository_pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	//identify Organization
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement organization;
	
	//identify Contacts
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contacts;
	
	//identify Leads
	@FindBy(xpath = "//a[text()='Leads']")
	private WebElement leads;
	
	//identify image
	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement image;
	
	//identify sign out
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutButton;

	
	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getLeads() {
		return leads;
	}

	public WebElement getImage() {
		return image;
	}

	public WebElement getSignOutButton() {
		return signOutButton;
	}
	
	
}
