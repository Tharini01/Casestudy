package case_study;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\training_c2a.05.01\\eclipse-workspace\\Cucumber01\\src\\resources\\java\\feature.feature",
tags="@Add_to_Cart",
plugin= {"html:target/Reports"} 
)
public class TestRunner {

}
