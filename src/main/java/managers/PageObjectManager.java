//package managers;
//
//import org.openqa.selenium.WebDriver;
//import pageObjects.CartPage;
//import pageObjects.HomePage;
//import pageObjects.LoginPage;
//import pageObjects.SearchPage;
//
//public class PageObjectManager {
//
//    private final WebDriver webDriver;
//    private HomePage homePage;
//    private LoginPage loginPage;
//    private SearchPage searchPage;
//    private CartPage cartPage;
//
//
//    public PageObjectManager(WebDriver webDriver) {
//        this.webDriver = webDriver;
//    }
//
//
//    public HomePage getHomePage() {
//        return (homePage == null) ? homePage = new HomePage(webDriver) : homePage;
//    }
//
//    public LoginPage getLoginPage() {
//
//        if (loginPage == null) {
//            loginPage = new LoginPage(webDriver);
//        }
//        return loginPage;
//    }
//    public SearchPage getSearchPage() {
//
//        if (searchPage == null) {
//            searchPage = new SearchPage(webDriver);
//        }
//        return searchPage;
//    }
//
//    public CartPage getCartPagePage() {
//
//        if (cartPage == null) {
//            cartPage = new CartPage(webDriver);
//        }
//        return cartPage;
//    }
//}
