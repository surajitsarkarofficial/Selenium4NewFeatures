import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class OpenNewTabTests extends  BaseTest{

    @Test
    public void openNewTab() throws InterruptedException {
        driver.navigate().to("https://askomdch.com/");
        String parentWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.orangehrm.com/");
        System.out.println("Switched to Tab with URL "+ driver.getCurrentUrl());
        String childWindow = driver.getWindowHandle();
        driver.switchTo().window(parentWindow);
        System.out.println("Switched to Previous Tab and its URL is "+ driver.getCurrentUrl());
        driver.switchTo().window(childWindow);
        System.out.println("Again Switched to the Tab whose URL is "+ driver.getCurrentUrl());
        System.out.println("Closing Tab with URL "+ driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(parentWindow);
        System.out.println("Closing Window with URL "+ driver.getCurrentUrl());
        driver.close();
    }
    @Test
    public void openNewWindow() throws InterruptedException {
        driver.navigate().to("https://askomdch.com/");
        String parentWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.orangehrm.com/");
        System.out.println("Switched to Window with URL "+ driver.getCurrentUrl());
        String childWindow = driver.getWindowHandle();
        driver.switchTo().window(parentWindow);
        System.out.println("Switched to Previous Window and its URL is "+ driver.getCurrentUrl());
        driver.switchTo().window(childWindow);
        System.out.println("Again Switched to the Window whose URL is "+ driver.getCurrentUrl());
        System.out.println("Closing Window with URL "+ driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(parentWindow);
        System.out.println("Closing Window with URL "+ driver.getCurrentUrl());
        driver.close();
    }
}
