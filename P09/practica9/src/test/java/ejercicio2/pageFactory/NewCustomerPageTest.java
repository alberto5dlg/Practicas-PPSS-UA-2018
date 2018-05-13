/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2.pageFactory;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author ppss
 */
public class NewCustomerPageTest {
    
    WebDriver driver; 
    NewCustomerPage poNewCustomer; 
    LoginPage poLogin; 
    ManagerPage poManager;
    DeleteCustomerPage poDeleteCustomer; 
    String userID; 
    
    public NewCustomerPageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        driver = new FirefoxDriver(); 
        poLogin = PageFactory.initElements(driver, LoginPage.class);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testAddNewCustomer() {
        String loginTitle = poLogin.getLoginTitle();
        Assert.assertTrue(loginTitle.toLowerCase().contains("guru99 bank"));
        
        poManager = poLogin.login("mngr128897", "aqAzatu");
        Assert.assertTrue(poManager.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr128897"));
        
        poNewCustomer = poManager.newCustomer();
        String newCustomerTitle = poNewCustomer.getTitlePage().toLowerCase(); 
        Assert.assertTrue(newCustomerTitle.contains("add new customer"));
        poManager = poNewCustomer.addNewClient("alberto", "m", "1994-12-05", "mi casa", "Benidorm", "Alicante", "123456", "666999888", "al@al.com", "1234abcd");
        String customerRegTitle = poManager.getRegisterUserTitle().toLowerCase(); 
        Assert.assertTrue(customerRegTitle.contains("customer registered successfully!!!"));
        userID = poManager.getUserID();
        System.out.println(userID);
        
        poDeleteCustomer = poManager.deleteCustomer();
        String titleDelete = poDeleteCustomer.getTitlePage();
        Assert.assertTrue(titleDelete.toLowerCase().contains("delete customer form"));
        poManager = poDeleteCustomer.deleteCustomer(userID);
        
        Alert alert = driver.switchTo().alert(); 
        String mensaje = alert.getText(); 
        Assert.assertTrue(mensaje.toLowerCase().contains("do you really want to delete this customer?"));
        alert.accept(); 
        
        WebDriverWait wait = new WebDriverWait(driver, 10); 
        wait.until(ExpectedConditions.alertIsPresent());
        
        alert = driver.switchTo().alert(); 
        mensaje = alert.getText(); 
        Assert.assertTrue(mensaje.toLowerCase().contains("customer deleted successfully"));
        alert.accept();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        Assert.assertTrue(poManager.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr128897"));
        
        driver.close(); 
    }
    
    @Test
    public void testAddRepeatCustomer() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String loginTitle = poLogin.getLoginTitle();
        Assert.assertTrue(loginTitle.toLowerCase().contains("guru99 bank"));
        
        poManager = poLogin.login("mngr128897", "aqAzatu");
        Assert.assertTrue(poManager.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr128897"));
        
        poNewCustomer = poManager.newCustomer();
        String newCustomerTitle = poNewCustomer.getTitlePage().toLowerCase(); 
        Assert.assertTrue(newCustomerTitle.contains("add new customer"));
        poManager = poNewCustomer.addNewClient("alberto", "m", "1994-12-05", "mi casa", "Benidorm", "Alicante", "123456", "666999888", "alu@al.com", "1234abcd");
        String customerRegTitle = poManager.getRegisterUserTitle().toLowerCase(); 
        Assert.assertTrue(customerRegTitle.contains("customer registered successfully!!!"));
        userID = poManager.getUserID();
        System.out.println(userID);
        
        poNewCustomer = poManager.newCustomer();
        Assert.assertTrue(newCustomerTitle.contains("add new customer"));
        poManager = poNewCustomer.addNewClient("alberto", "m", "1994-12-05", "mi casa", "Benidorm", "Alicante", "123456", "666999888", "alu@al.com", "1234abcd");
        
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert(); 
        String mensaje = alert.getText(); 
        Assert.assertTrue(mensaje.toLowerCase().contains("email address already exist !!"));
        alert.accept(); 
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        poDeleteCustomer = poNewCustomer.deleteCustomer();
        String titleDelete = poDeleteCustomer.getTitlePage();
        Assert.assertTrue(titleDelete.toLowerCase().contains("delete customer form"));
        poManager = poDeleteCustomer.deleteCustomer(userID);
        
        alert = driver.switchTo().alert(); 
        mensaje = alert.getText(); 
        Assert.assertTrue(mensaje.toLowerCase().contains("do you really want to delete this customer?"));
        alert.accept(); 
        
        wait.until(ExpectedConditions.alertIsPresent());
        
        alert = driver.switchTo().alert(); 
        mensaje = alert.getText(); 
        Assert.assertTrue(mensaje.toLowerCase().contains("customer deleted successfully"));
        alert.accept();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        Assert.assertTrue(poManager.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr128897"));
        
        driver.close(); 
    }
}
