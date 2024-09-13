import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CaptureScreenshotTests extends BaseTest{

    @Test
    public void captureElementScreenshot() throws IOException {

        driver.navigate().to("https://askomdch.com/");
        By SHOP_NOW_BTN = By.xpath("//div[@class='wp-block-button']/a[text()='Shop Now']");

        FluentWait wait = new FluentWait(driver);
        wait
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(SHOP_NOW_BTN));

        File eleScreenShot = driver.findElement(SHOP_NOW_BTN).getScreenshotAs(OutputType.FILE);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyy_hh_mm_ss");
        File destinationFile = new File(System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"ElementScrrenShot_"+now.format(format)+".png");
        FileUtils.copyFile(eleScreenShot,destinationFile);
        System.out.println("Screenshot captured at location " + destinationFile.getPath());

    }
    @Test
    public void highlightElement() throws IOException, InterruptedException {

        driver.navigate().to("https://askomdch.com/");
        By SHOP_NOW_BTN = By.xpath("//div[@class='wp-block-button']/a[text()='Shop Now']");

        FluentWait wait = new FluentWait(driver);
        wait
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.presenceOfElementLocated(SHOP_NOW_BTN));
        WebElement element = driver.findElement(SHOP_NOW_BTN);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].style.border='2px solid red'",element);

        Thread.sleep(1000);
        File eleScreenShot = element.getScreenshotAs(OutputType.FILE);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyy_hh_mm_ss");
        File destinationFile = new File(System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"ElementScrrenShot_"+now.format(format)+".png");
        FileUtils.copyFile(eleScreenShot,destinationFile);
        System.out.println("Screenshot captured at location " + destinationFile.getPath());

    }


}
