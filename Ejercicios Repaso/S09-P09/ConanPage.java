//src/main/java

public class ConanPage {
	WebDriver driver; 
	@FindBy(name = "titlePage") WebElement titlePage;
	@FindBy(name = "checkLike") WebElement checkLike; 
	//Consideramos que el texto donde ponen el numero de me gusta es un label
	@FindBy(name = "numberLikes") WebElement numberLikes; 

	public ConanPage(WebDriver driver) {
		this.driver = driver; 
	}

	public void clickLike(){
		checkLike.click(); 
	}

	public String getNumberOfLikes(){
		return numberLikes.getText(); 
	}

	public String getTitlePage(){
		return titlePage.getText(); 
	}
}