package com.course.selenium.finalProject.Task1;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/Task1.feature", plugin = {"pretty", "html:out.html"})
public class Task1Test {
}
