// src/test/java/pages/HomePage.java
package pages;
import com.microsoft.playwright.Page;
public class HomePage {
    private final Page page;
    public HomePage(Page page) {
        this.page = page;
    }
    public void navigateTo() {
        page.navigate("https://www.blazedemo.com");
    }
    public void selectDepartureCity(String city) {
        page.selectOption("select[name='fromPort']", city);
    }
    public void selectDestinationCity(String city) {
        page.selectOption("select[name='toPort']", city);
    }
    public void findFlights() {
        page.click("input[type='submit']");
    }
}