package com.eldorado.authservice.stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/features/AuthServer.feature"},glue= {"com.eldorado.authservice.stepdefinitions"},
monochrome=true,
plugin = {"pretty","junit:target/JUnitReports/report.xml",
		  "pretty","html:target/HtmlReports/index.html",
		  "pretty","json:target/JsonReports/report.json"
		}
)

public class TestRunner {
	

}

