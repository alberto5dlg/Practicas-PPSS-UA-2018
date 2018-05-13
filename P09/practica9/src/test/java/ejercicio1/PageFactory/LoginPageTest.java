package ejercicio1.PageFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageTest {

    WebDriver driver;
    LoginPage poLogin;
    ManagerPage poManagerPage;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        poLogin = PageFactory.initElements(driver, LoginPage.class);
    }
    
    /*@Test
    public void test_Login_Correct(){
        String loginPageTitle = poLogin.getLoginTitle();
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        poLogin.login("mngr128897", "aqAzatu");
        poManagerPage = PageFactory.initElements(driver, ManagerPage.class);
        Assert.assertTrue(poManagerPage.getHomePageDashboardUserName()
        .toLowerCase().contains("manger id : mngr128897"));
        driver.close();
    }*/
    
    @Test
    public void test_Login_Incorrect(){
        String loginPageTitle = poLogin.getLoginTitle();
        String resultEsperado = "User or Password is not valid"; 
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
        poLogin.login("alberto", "123456");
        
        Alert alert = driver.switchTo().alert(); 
        String mensaje = alert.getText();
        Assert.assertEquals(resultEsperado, mensaje); 
        alert.accept();
        
        driver.close();
    }
    
}