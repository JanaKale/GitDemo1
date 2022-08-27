package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParameterzationSteps {
	int x, y, result = 0;
	String fruitName;
	public static Workbook book;

	@Given("I have two numbers {int} and {int}")
	public void acceptTwoNum(int num1, int num2) {
		x = num1;
		y = num2;
	}

	@When("I add them")
	public void addNum() {
		result = x + y;
	}

	@Then("Print the result")
	public void showResult() {
		System.out.println("Result of addition:" + result);
	}

	@Given("I have a fruite {string}")
	public void acceptFruite(String fruit) {
		fruitName = fruit;
	}

	@Then("Display its {string}")
	public void displayColor(String color) {
		System.out.println(fruitName + " is " + color);
	}

	@Given("I have following <states>")
	/*
	 * public void acceptStates(Map<String,String>states) {
	 * System.out.println("==========States========="); Set<Entry<String,
	 * String>>entries=states.entrySet(); for(Entry<String, String> entry:entries) {
	 * System.out.println(entry.getKey()+"\t"+entry.getValue()); } }
	 */
	public void acceptAndPrintStates(DataTable states) {
		System.out.println("==========States=========");
		Map<String, List> stateDetail = states.asMap(String.class, List.class);
		Set<Entry<String, List>> entry = stateDetail.entrySet();
		for (Entry<String, List> ent : entry) {
			List<String> data = ent.getValue();
			System.out.println(ent.getKey() + "\t" + data.get(0) + "\t" + data.get(1));
		}
	}

	@Then("Display all states")
	public void displayStates() {
		System.out.println("========================");
	}

	@Given("I have {int}")
	public void acceptData(int rownum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Shree\\Desktop\\TestData.xlsx");
		book = WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet("data");
		//int rownum=sheet.getLastRowNum();
	}

	@Then("print if there addition is prime")
	public void checkPrime() {
		int count = 0;
		for (int i = 2; i <= result / 2; i++) {
			if (result % i == 0) {
				count++;
				break;
			}
		}
		if (count < 1) {
			System.out.println("num is prime:" + result);

		} else {
			System.out.println("num is not prime:" + result);
		}
	}

}
