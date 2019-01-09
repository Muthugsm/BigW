package com.TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\JB JK\\Pictures\\eclipsss\\BigW_Test\\src\\resource\\java\\AutomationSuite\\BigB_scenario.feature",
glue= {"com.qa.TestCases"},plugin= {"pretty","html:test","json:json_Output/cucumber.json","junit:junit_xml/cucumber.xml"},
strict=true,monochrome=true
,dryRun=false)
public class TestRunner {

}
