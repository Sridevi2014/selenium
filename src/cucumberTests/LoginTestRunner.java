package cucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//Test runner
@RunWith(Cucumber.class)
@CucumberOptions(features="features", glue="stepImplementations")
public class LoginTestRunner {

}
