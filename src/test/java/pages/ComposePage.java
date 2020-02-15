package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ComposePage 
{
    public WebDriver driver;
    
    @FindBy(how=How.XPATH,using="//*[text()='Compose']")
    public WebElement comp;
    
    @FindBy(how=How.XPATH,using="//*[@name='to']")
    public WebElement to;
    
    @FindBy(how=How.XPATH,using="//*[@name='subjectbox']")
    public WebElement sub;
    
    @FindBy(how=How.XPATH,using="//div[@aria-label='Message Body']")
    public WebElement msgBody;
    
    @FindBy(how=How.XPATH,using="//*[text()='Send']")
    public WebElement send;
    
    @FindBy(how=How.XPATH,using="(//*[@class='vh'])[1]")
    public WebElement validatemsgsend;
    
    @FindBy(how=How.XPATH,using="//*[contains(@aria-label,'Google Account')]/span")
    public WebElement profilepic;
    
    @FindBy(how=How.XPATH,using="//*[text()='Sign out']")
    public WebElement signout;
    
    public ComposePage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void composeclick()
    {
        comp.click();
    }
    
    public void to(String x)
    {
        to.sendKeys(x);
    }
    
    public void sub(String y)
    {
        sub.sendKeys(y);
    }
    
    public void messageBody(String z)
    {
        msgBody.sendKeys(z);
    }
    
    public void clicksend()
    {
        send.click();
    }
    
    public void profilepicclick()
    {
    	profilepic.click();
    }
    
    public void signoutclick()
    {
    	signout.click();
    }       

}
