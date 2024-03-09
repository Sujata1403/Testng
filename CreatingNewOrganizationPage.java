package object_repository_pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatingNewOrganizationPage {
	//identify the Organization name text field
	@FindBy(name = "accountname")
	private WebElement organizationNametf;

	
	//identify the radio button of Group
	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement groupButton;
	
	//identify the dropdown
	@FindBy(name = "assigned_group_id")
	private WebElement dropdown;
	
	//identify save button
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement saveButton;
	
	
	public WebElement getOrganizationNametf() {
		return organizationNametf;
	}


	public WebElement getGroupButton() {
		return groupButton;
	}


	public WebElement getDropdown() {
		return dropdown;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
}
