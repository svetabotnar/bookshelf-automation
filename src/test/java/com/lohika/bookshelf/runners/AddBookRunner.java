package com.lohika.bookshelf.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(format = {"pretty", "html:target/cucumberAddBook", "json:target/cucumberAddBook.json"},
        features = "src/test/resources/features/AddBook.feature",
        dryRun = false,
        glue = "com/lohika/bookshelf/steps",
        tags = "@ready")
public class AddBookRunner extends AbstractTestNGCucumberTests {
}
