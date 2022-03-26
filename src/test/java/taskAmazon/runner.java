package taskAmazon;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin={"html:target\\cucumber-reports.html",
                    "json:target/json-reports/cucumber.json",
                    "junit:target/xml-report/cucumber.xml"},
            features = "src/test/resources/taskAmazon.feature",
            glue = "src/test/java/taskAmazon/stepDef",
            tags = "",

            dryRun=false
            //dryrun=true dedigimizde testi calistirmadan bize eksik adimi verir
            //dryrun=false dersek testi calistirir, eksik bir adimla calisirsa test fail olur , bize eksik adimi raporlar
    )



    public class runner {

    }

