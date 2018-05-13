/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.pageFactory;

import ejercicio1.PageFactory.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author ppss
 */
public class ManagerPage {
    WebDriver driver;
    @FindBy(xpath="//table//tr[@class='heading3']") WebElement homePageUserName;
    @FindBy(linkText="New Customer") WebElement newCustomer;
    @FindBy(linkText="Delete Customer") WebElement deleteCustomer; 
    @FindBy(linkText="Log out") WebElement logOut;
    @FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]") WebElement userID;
    @FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p") WebElement UserReg; 
    
    public ManagerPage(WebDriver driver){
        this.driver = driver;
    }
    
    public String getHomePageDashboardUserName(){
        return homePageUserName.getText();
    }
    
    public NewCustomerPage newCustomer() {
        newCustomer.click();
        return PageFactory.initElements(driver, NewCustomerPage.class);
    }
    
    public String getRegisterUserTitle(){
        return UserReg.getText();
    }
    
    public String getUserID(){
        return userID.getText(); 
    }
    
    public DeleteCustomerPage deleteCustomer() {
        deleteCustomer.click();
        return PageFactory.initElements(driver, DeleteCustomerPage.class);
    }
}
