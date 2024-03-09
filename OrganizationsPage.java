package object_repository_pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationsPage {
	//identify + icon to create new organization
	@FindBy(css = "img[alt='Create Organization...']")
	private WebElement createOrganization;

	
	public WebElement getCreateOrganization() {
		return createOrganization;
	}
}
