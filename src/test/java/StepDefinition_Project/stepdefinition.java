package StepDefinition_Project;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Util.basetest;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepdefinition

{
	
	public WebDriver driver =basetest.driver;
	@Given("^User is on the Login Page and clicks on SignUp$")
	
	public void user_is_on_the_Login_Page_and_clicks_on_SignUp() 
	
	
	{
		try {
		
        driver = new ChromeDriver();
        driver.get("http://elearningm1.upskills.in/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(text(),'Sign up!')]")).click();
		Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                    
	}

	@When("^User navigate to registration page and Enter all the mandatory fields \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_navigate_to_registration_page_and_Enter_all_the_mandatory_fields(String firstname, String lastname, String email, String Username, String password, String Cpassword) 
	{
        driver.findElement(By.name("firstname")).sendKeys(firstname);
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("username")).sendKeys(Username);
        driver.findElement(By.name("pass1")).sendKeys(password);
        driver.findElement(By.name("pass2")).sendKeys(Cpassword);
        
	}

	@When("^Click on Register button$")
	public void click_on_Register_button() 
	{
		driver.findElement(By.xpath("//button[@id='registration_submit']")).click();
	}

	@Then("verify the username{string}")
	public void verify_the_username(String userregistered) {
		String message =driver.findElement(By.xpath("//h2[contains(text(),'Registration')]//following::div[1]")).getText();
		assertEquals(message, userregistered);
	}

	@Then("User Click on home icon")
	public void user_Click_on_home_icon() 
	{
		driver.findElement(By.xpath("//a[contains(text(),'Homepage')]")).click();
	}

	@Then("user enter the required fields {string},{string}")
	public void user_enter_the_required_fields(String Username, String password) 
	{
		try {
			Thread.sleep(500);
			driver.findElement(By.id("login")).sendKeys(Username);
			Thread.sleep(500);
			driver.findElement(By.id("password")).sendKeys(password);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Then("click on submit button")
	public void click_on_submit_button() {
		driver.findElement(By.xpath("//button[@id='form-login_submitAuth']")).click();
	}

	@Then("user verify that Register is completed sucessfull {string}")
	public void user_verify_that_Register_is_completed_sucessfull(String registered) 
	{
		String message1=driver.findElement(By.xpath("//ul[@class='breadcrumb']//following::p[1]")).getText();
		System.out.println(message1.substring(6, 25));
		assertEquals(message1.substring(6, 25), registered);  
		
	}

	@When("^Clicks on Compose$")
	public void clicks_on_Compose() 
	{
		driver.findElement(By.xpath("//a[contains(text(),'Compose')]")).click();
	}

	@Then("Enter Send to,Subject,Message {string},{string},{string}")
	public void enter_Send_to_Subject_Message(String sentto, String subject, String message)
	{try {
		String format = "//li[contains(text(),'%s')]";
		driver.findElement(By.xpath("//*[@class='select2-search__field']")).sendKeys(sentto);
		
			Thread.sleep(2000);
		
		driver.findElement(By.xpath(String.format(format,"s f (test)"))).click();
		 driver.findElement(By.id("compose_message_title")).sendKeys(subject);
		  Thread.sleep(2500);
		  driver.findElement(By.xpath("//label[contains(text(),'Message')]//following::iframe[1]")).sendKeys(message);	
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	}

	@When("^Clicks on Send Message$")
	public void clicks_on_Send_Message() 
	{
	    
		  driver.findElement(By.name("compose")).click();

	}

	@Then("^Validate the success message$")
	public void validate_the_success_message() throws Throwable {
	    String message =driver.findElement(By.xpath("//div[contains(text(),'The message has been sent to')]")).getText();
	    System.out.println(message);
	   assertEquals(message, "The message has been sent to s f (test)");
	}
	
}
