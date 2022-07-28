package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Serachsteps {
	
	@Given("ब्राउज़र खोलें")
	public void openBrowzer() {
		System.out.println("Hi");
	}

	@And("url लाँच करा")
	public void launchUrl() {
		System.out.println("Hello");
	}

	@When("enter laptop in search box")
	public void sendkeys() {
		System.out.println("how r u");
	}

	@Then("resulting products should be laptops only")
	public void result() {
		System.out.println("fine");
	}
}
