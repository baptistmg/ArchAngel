package test2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class Launchbrowser {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://mercy-qa.hclvoltmx.net/apps/Archangel/");
		Locator ClinicalandSupply = page.locator("//div[normalize-space(text())='Clinical and Supply']");
		ClinicalandSupply.hover();
		page.locator("(//span[@id='flxLogoptn_imgChkbx_span']//img)[1]").click();
		page.locator("(//div[@class='kcell sknbtnlogingreen']//input)[2]").click();
		assertThat(page).hasTitle("ArchAngel");
		page.getByPlaceholder("Username").type("unitedcare");
		page.getByPlaceholder("Password").type("Welcome@03");
		page.click("(//div[@class='kcell sknbtnlogingreen']//input)[2]");
		assertThat(page).hasTitle("ArchAngel");
	}

}
