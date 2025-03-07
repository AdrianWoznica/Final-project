package com.course.selenium.finalProject.Task2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/Task2.feature", plugin = {"pretty", "html:out.html"})
public class Task2Test {
}
