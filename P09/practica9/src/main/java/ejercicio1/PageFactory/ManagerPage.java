/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author ppss
 */
public class ManagerPage {
    WebDriver driver;
    @FindBy(xpath="//table//tr[@class='heading3']") WebElement homePageUserName;
    @FindBy(linkText="New Customer") WebElement newCustomer;
    @FindBy(linkText="Log out") WebElement logOut;
    
    public ManagerPage(WebDriver driver){
        this.driver = driver;
    }
    
    public String getHomePageDashboardUserName(){
        return homePageUserName.getText();
    }
}
