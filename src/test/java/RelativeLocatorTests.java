import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class RelativeLocatorTests extends BaseTest{

    @Test
    public void relativeLocator()
    {
        driver.navigate().to("https://automationbookstore.dev/");

        //Find book 5 which is left of book 6
        String id = driver.findElement(RelativeLocator.with(By.tagName("li")).toLeftOf(By.id("pid6"))).getAttribute("id");
        System.out.println("Id of book 5 is "+ id);

        //Find book 2 which is right of book 1
         id = driver.findElement(RelativeLocator.with(By.tagName("li")).toRightOf(By.id("pid1"))).getAttribute("id");
        System.out.println("Id of book 2 is "+ id);

        //Find book 3 which is above of book 7
        id = driver.findElement(RelativeLocator.with(By.tagName("li")).above(By.id("pid7"))).getAttribute("id");
        System.out.println("Id of book 3 is "+ id);

        //Find book 8 which is below of book 4
        id = driver.findElement(RelativeLocator.with(By.tagName("li")).below(By.id("pid4"))).getAttribute("id");
        System.out.println("Id of book 8 is "+ id);

        //Find books which are near book 6
        System.out.println("Books ids near book 6 are - ");
        driver.findElements(RelativeLocator.with(By.tagName("li")).near(By.id("pid6"))).stream().forEach(e->{
            System.out.println(e.getAttribute("id"));
        });
    }
}
