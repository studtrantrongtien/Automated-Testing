package lab2.driverutils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class WaitAction{

    private WebDriverWait webDriverWait;

    public WaitAction(WebDriver webDriver) {
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    public Boolean waitUntilCondition(Function<WebDriver, Boolean> p) {
        return webDriverWait.ignoring(NoSuchElementException.class).until(p);
    }
}
