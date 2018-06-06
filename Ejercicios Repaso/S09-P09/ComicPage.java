//src/main/java

public class ComicPage {
	WebDriver driver; 
	@FindBy(linkText = "Conan") WebElement linkConan; 
	@FindBy(name = "titlePage") WebElement titlePage;

	public ComicPage(WebDriver driver) {
		this.driver = driver; 
		this.driver.get("http://book_live.es/comics");
	}

	public ConanPage clickConan(){
		linkConan.click(); 
		return PageFactory.initElements(driver, ConanPage.class); 
	}

	public String getTitlePage(){
		return titlePage.getText(); 
	}
}