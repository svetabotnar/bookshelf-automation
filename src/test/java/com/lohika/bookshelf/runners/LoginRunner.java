package com.lohika.bookshelf.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(format = {"pretty", "html:target/cucumberLogin", "json:target/cucumberLogin.json"},
        features = "src/test/resources/features/Login.feature",
        dryRun = false,
        glue = "com/lohika/bookshelf/steps",
        tags = "@ready")
public class LoginRunner extends AbstractTestNGCucumberTests {
}

