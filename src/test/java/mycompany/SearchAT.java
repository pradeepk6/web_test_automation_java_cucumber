package mycompany;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = {},
        glue = "mycompany.steps",
        features={"src/test/resources/features/buy/buy_a_product.feature"}
        )
public class SearchAT {
}
