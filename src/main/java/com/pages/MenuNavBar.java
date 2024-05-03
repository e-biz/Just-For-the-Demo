package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuNavBar {
	WebDriver driver;

	public MenuNavBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, MenuNavBar.this);
	}

	@FindBy(id = "menu")
	WebElement Menu;

	@FindBy(xpath = "//div[@class='menu']//ul//li//a[text() = 'Home']")
	WebElement Home;

	@FindBy(xpath = "//div[@class='menu']//ul//li[2]//a[text() = 'New Requisition']")
	WebElement NewRequision;

	@FindBy(xpath = "//div[@class='menu']//ul//li[3]//a[text() = 'History']")
	WebElement History;

	@FindBy(xpath = "//div[@class='menu']//li[2]//a[text() = 'History']")
	WebElement HistoryHide;

	@FindBy(xpath = "//div[@class='menu']//ul//li[4]//a[text() = 'Admin & Settings']")
	WebElement Setting;

	@FindBy(xpath = "//div[@class='menu']//li[3]//a[text() = 'Settings']")
	WebElement SettingHide;

	@FindBy(xpath = "//div[@class='menu']//ul//li[5]//a[text() = 'Import Data']")
	WebElement ImportData;

	@FindBy(xpath = "//div[@id='Sub_1']//li[1]//a[text() = 'User Management']")
	WebElement UserManagment;

	@FindBy(xpath = "//div[@id='Sub_1']//li[2]//a[text() = 'Workflow']")
	WebElement WorkFlow;

	@FindBy(xpath = "//div[@id='Sub_1']//li[3]//a[text() = 'Subscription']") // Subscription //Subscription
	WebElement Subscription;

	@FindBy(xpath = "//div[@id='Sub_1']//li[4]//a[text() = 'Company Settings']")
	WebElement CompanySetting;

	@FindBy(xpath = "//div[@class='menu']//ul//li[5]//a[text() = 'Change Password']")
	WebElement PasswordChange;

	@FindBy(xpath = "//div[@id='Sub_2']//input[@id = 'txtCurrentPswd']")
	WebElement Currentpassword;

	@FindBy(xpath = "//input[@id = 'txtNewPswd']")
	WebElement Newpassword;

	@FindBy(xpath = "//input[@id = 'txtConfNewPswd']")
	WebElement Confirmpassword;

	@FindBy(id = "btn_SavePswd")
	WebElement Save;

	@FindBy(id = "btnLogout")
	WebElement ClickLogout;

	@FindBy(id = "Logout")
	WebElement ClickLogoutfromReqPage;
	
	@FindBy(id = "ImgYes")
	List<WebElement> LeaveReqPageYesBtn;

	public void Menu() throws InterruptedException {
		WebElement menu = driver.findElement(By.id("menuimage")); // Replace with the actual ID of the menu element
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", menu);
		Thread.sleep(1000);
	}

	public void HomeMenu() throws InterruptedException {
		Menu();
		Home.click();
	}

	public void NewReqMenu() throws InterruptedException {
		Menu();
		NewRequision.click();
		Thread.sleep(15000);
	}

	public void RefreshPage() {
		driver.navigate().refresh();
	}

	public void HistoryMenu() throws InterruptedException {
		Menu();
		History.click();
		Thread.sleep(10000);
	}
	
	public void LeaveReqPage() throws InterruptedException {
		Thread.sleep(2000);
		LeaveReqPageYesBtn.get(1).click();
	}
	
	public void NewReqPage_fromReqPage() throws InterruptedException {
		Menu();
		NewRequision.click();
		System.out.print("1");
		LeaveReqPage();
		Thread.sleep(15000);
	}

	public void Setting_UserManagementMenu() throws InterruptedException {
		Menu();
		Setting.click();
		Thread.sleep(1000);
		UserManagment.click();
	}

	public void Setting_WorkflowMenu() throws InterruptedException {
		Menu();
		Setting.click();
		Thread.sleep(2000);
		WorkFlow.click();
	}

	public void Setting_SubscriptionMenu() throws InterruptedException {
		Menu();
		Setting.click();
		Thread.sleep(1000);
		Subscription.click();
		Thread.sleep(10000);
	}

	public void Setting_CompanySettingMenu() throws InterruptedException {
		Menu();
		Setting.click();
		Thread.sleep(1000);
		CompanySetting.click();
		Thread.sleep(5000);
	}

	public void ImportDataMenu() throws InterruptedException {
		Menu();
		ImportData.click();
		Thread.sleep(2000);
	}

	public void Logout() throws InterruptedException {
		Menu();
		ClickLogout.click();
	}

}
