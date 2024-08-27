import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import io.cucumber.junit.platform.engine.Cucumber;

@Cucumber
@ExtendWith(SerenityJUnit5Extension.class)
@io.cucumber.junit.CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        features = "src/test/resources/features"
)
public class CucumberTestSuite {
}
