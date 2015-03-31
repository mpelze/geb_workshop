import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver

// Default driver if now environment is given.
driver = { new FirefoxDriver() }

waiting {
    timeout = 10
    retryInterval = 0.5
}

environments {

    "firefox" {
        driver = {
            driver = new FirefoxDriver()
            return driver
        }
    }

    "chrome" {
        driver = {
            driver = new ChromeDriver()
            return driver
        }
    }

}