package tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"E:\\Testingtools\\bddfrmwkgmailDataTable\\src\\test\\resources\\gmailfeature\\feature1.feature",
		                   "E:\\Testingtools\\bddfrmwkgmailDataTable\\src\\test\\resources\\gmailfeature\\feature2.feature",
		                   "E:\\Testingtools\\bddfrmwkgmailDataTable\\src\\test\\resources\\gmailfeature\\feature3.feature"
		                  },
                 monochrome=true,
                 //tags= {"@tag"},
                 glue= {"classpath:tests"},
                 plugin= {"pretty","html:target\\gmailresults","json:target\\gmailresults1"}
                 )
public class RunnerGmail 
{
	

}
