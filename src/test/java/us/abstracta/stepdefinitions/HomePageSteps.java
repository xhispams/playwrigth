// src/test/java/stepdefinitions/HomePageSteps.java
package us.abstracta.stepdefinitions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.HomePage;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class HomePageSteps {
    private Playwright playwright;
    private Page page;
    private HomePage homePage;
    @Before
    public void setUp() {
        playwright = Playwright.create();
        page = playwright.chromium().launch().newPage();
        homePage = new HomePage(page);
    }
    @After
    public void tearDown() {
        page.close();
        playwright.close();
    }
    @Given("I am on the Blazedemo homepage")
    public void i_am_on_the_blazedemo_homepage() {
        homePage.navigateTo();
    }
    @When("I select {string} as the departure city")
    public void i_select_as_the_departure_city(String departureCity) {
        homePage.selectDepartureCity(departureCity);
    }
    @When("I select {string} as the destination city")
    public void i_select_as_the_destination_city(String destinationCity) {
        homePage.selectDestinationCity(destinationCity);
    }
    @When("I click on find flights")
    public void i_click_on_find_flights() {
        homePage.findFlights();
    }
    @Then("I should see a list of available flights")
    public void i_should_see_a_list_of_available_flights() {
        assertTrue(page.title().contains("BlazeDemo - reserve"));
    }
}