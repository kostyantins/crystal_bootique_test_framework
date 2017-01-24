
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContentLoader {

    private static WebDriver driver;

    public static void main(String[] args)  {
        System.out.print("Test Started");

        driver = new FirefoxDriver();

        driver.get("http://oll.tv/tv-channels");

        if (driver != null) {
            driver.close();
            driver.quit();
        }
        System.out.print("Test Completed");
    }

}
