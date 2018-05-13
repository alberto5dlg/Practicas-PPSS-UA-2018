/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author ppss
 */
public class NewCustomerPage {
    
    WebDriver driver; 
    @FindBy(name="name") WebElement username; 
    @FindBy(name="rad1") WebElement gender; 
    @FindBy(name="dob") WebElement dateBirthday; 
    @FindBy(name="addr") WebElement address; 
    @FindBy(name="city") WebElement city; 
    @FindBy(name="state") WebElement state; 
    @FindBy(name="pinno") WebElement pin; 
    @FindBy(name="telephoneno") WebElement telephone; 
    @FindBy(name="emailid") WebElement email; 
    @FindBy(name="password") WebElement password; 
    @FindBy(name="sub") WebElement btnSubmit; 
    @FindBy(className="heading3") WebElement pageTitle; 
    @FindBy(linkText="Delete Customer") WebElement deleteCustomer; 
    
    public NewCustomerPage(WebDriver driver){
        this.driver = driver; 
    }
    
    public String getTitlePage() {
        return pageTitle.getText();
    }
    
    public ManagerPage addNewClient(String pusername, String pgender, String pdate, String paddr, String pcity, String pstate, 
                                String ppin, String ptelephone, String pemail, String ppassword){
        username.sendKeys(pusername);
        gender.sendKeys(pgender);
        dateBirthday.click();
        dateBirthday.sendKeys(pdate);
        address.sendKeys(paddr);
        city.sendKeys(pcity);
        state.sendKeys(pstate);
        pin.sendKeys(ppin); 
        telephone.sendKeys(ptelephone);
        email.sendKeys(pemail);
        password.sendKeys(ppassword);
        btnSubmit.click();
        
        return PageFactory.initElements(driver, ManagerPage.class);
    }
    
    public DeleteCustomerPage deleteCustomer() {
        deleteCustomer.click();
        return PageFactory.initElements(driver, DeleteCustomerPage.class);
    }
}
