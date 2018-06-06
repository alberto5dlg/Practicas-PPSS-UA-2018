//src/test/java

public class TestConanPage {
	WebDriver driver; 
	ComicPage poComic;
	ConanPage poConan; 

	@Before
	public void setup(){
		driver = new FirefoxDriver(); 
		poComic = PageFactory.initElements(driver, ComicPage.class); 
	}

	@Test
	public void test_Like_check(){
		String comicTitle = poComic.getTitlePage(); 
		Assert.assertTrue(comicTitle.toLowerCase().equals("sección de comics")); 

		poConan = poComic.clickConan();
		String conanTitle = poConan.getTitlePage(); 
		Assert.assertTrue(conanTitle.toLowerCase().equals("conan. último número"));

		poConan.clickLike(); 
		String numberLike = poConan.getNumberOfLikes();
		Assert.assertTrue(numeberLike.toLowerCase().equals("427 usuarios"));
	}
}