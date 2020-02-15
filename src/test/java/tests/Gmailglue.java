package tests;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;
import utility.TestUtility;

public class Gmailglue 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public TestUtility tu;
	public LoginPage lp;
	public HomePage hp;
	public ComposePage cp;
	public Scenario s;
	public Properties p;
	
	@Before
	public void method1(Scenario s) throws Exception
	{
		//define scenario class object
		this.s=s;
		//load properties file
		File f=new File("E:\\Testingtools\\bddfrmwkgmail\\src\\test\\resources\\gmailproperties\\gmailproperties.properties");
		FileReader fr=new FileReader(f);
		p=new Properties();
		p.load(fr);
		//define utility class object
		tu=new TestUtility();
	}
	
	@Given("^launch site using \"(.*)\"$")
	public void method2(String bn)
	{
		driver=tu.openBrowser(bn);
		tu.launchsite(driver,p.getProperty("url"));
		hp=new HomePage(driver);
		lp=new LoginPage(driver);
		cp=new ComposePage(driver);
		//create wait object
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(hp.uid));
	}
	
	@Then("^title should be \"(.*)\"$")
	public void method3(String et)
	{
		String at=driver.getTitle();
		if(at.equals(et))
		{
			s.write("Gmail title test passed");
		}
		else
		{
			byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(b,"Gmail title test failed");
			Assert.fail();
		}		
	}
	
	@When("^close site$")
	public void method4()
	{
		tu.closesite(driver);
	}
	
	@When("^enter \"(.*)\" as userid$")
	public void method5(String x)
	{
		hp.uidfill(x);
		wait.until(ExpectedConditions.elementToBeClickable(hp.uidnext));
	}
	
	@And("^click uid next$")
	public void method6() throws Exception
	{
		hp.uidnextclick();
		Thread.sleep(5000);
	}
	
	@Then("^validate output for \"(.*)\" as uid criteria$")
	public void method7(String c)
	{
		try
		{
			if(c.equalsIgnoreCase("blank") && hp.blankuiderr.isDisplayed())
			{
				s.write("uid test passed for blank uid");
			}
			else if(c.equalsIgnoreCase("invalid") && hp.invaliduiderr.isDisplayed())
			{
				s.write("uid test passed for invalid uid");
			}
			else if(c.equalsIgnoreCase("valid") && lp.pwd.isDisplayed())
			{
				s.write("uid test passed for valid uid");
			}
			else
			{
				byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				s.embed(b,"UID test failed");
				Assert.fail();
			}
		}
		catch(Exception ex)
		{
			byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(b,ex.getMessage());
			Assert.fail();
		}
	}
	
	@And("^enter \"(.*)\" as password$")
	public void method8(String x)
	{
		lp.pwdfill(x);
		wait.until(ExpectedConditions.elementToBeClickable(lp.pwdnext));
	}
	
	@And("^click pwd next$")
	public void method9() throws Exception
	{
		lp.pwdnextclick();
		Thread.sleep(5000);
	}
	
	@Then("^validate output for \"(.*)\" as pwd criteria$")
	public void method10(String c)
	{
		try
		{
			if(c.equalsIgnoreCase("blank") && lp.blankpwderr.isDisplayed())
			{
				s.write("pwd test passed for blank password");
			}
			else if(c.equalsIgnoreCase("invalid") && lp.invalidpwderr.isDisplayed())
			{
				s.write("pwd test passed for invalid password");
			}
			else if(c.equalsIgnoreCase("valid") && cp.comp.isDisplayed())
			{
				s.write("pwd test passed for valid password");
				//do logout
				cp.profilepicclick();
				wait.until(ExpectedConditions.elementToBeClickable(cp.signout));
				cp.signoutclick();
			}
			else
			{
				byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				s.embed(b,"PWD test failed");
				Assert.fail();
			}
		}
		catch(Exception ex)
		{
			byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(b,ex.getMessage());
			Assert.fail();
		}		
	}
	
	@Then("^validate compose operation$")
	public void method11(DataTable dt) throws Exception
	{
		List<List<String>> data=dt.asLists();
		for(int i=1;i<data.size();i++)
		{
			Thread.sleep(5000);
			try
			{
				cp.composeclick();
				cp.to(data.get(i).get(0));
				cp.sub(data.get(i).get(1));
				cp.messageBody(data.get(i).get(2));
				cp.clicksend();
				Thread.sleep(5000);
				String txt=cp.validatemsgsend.getText();
				if(txt.contains("Message sent"))
				{
					s.write("Mail sent successfull");
				}
				else
				{
					byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
					s.embed(b,"Mail sent test failed");
					Assert.fail();
				}
			}
			catch(Exception ex)
			{
				byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				s.embed(b,ex.getMessage());
				Assert.fail();
			}
		}
		//do logout
		cp.profilepicclick();
		wait.until(ExpectedConditions.elementToBeClickable(cp.signout));
		cp.signoutclick();
	}	
}
