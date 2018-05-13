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
public class DeleteCustomerPage {
    
    WebDriver driver; 
    @FindBy(name="cusid") WebElement customerID; 
    @FindBy(name="AccSubmit") WebElement btnSubmit;
    @FindBy(className="heading3") WebElement titlePage; 
    
    public DeleteCustomerPage(WebDriver driver) {
        this.driver = driver; 
    }
    
    public String getTitlePage() {
        return titlePage.getText(); 
    }
    
    public ManagerPage deleteCustomer(String id) {
        customerID.sendKeys(id); 
        btnSubmit.click(); 
        return PageFactory.initElements(driver, ManagerPage.class);
    }
}
