import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class GoogleDataCollection {
    public static void googleGenerationAnalysis(int n) {
        //Establish total collection of data
        List<Integer> dataResultList = new ArrayList<Integer>();
        int currentDataResult;
        int fails = 0;

        //Start Web Page
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.navigate().to("https://www.google.com/");

        //Get to RNG
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.click();
        searchBar.sendKeys("random number generator");
        searchBar.sendKeys(Keys.RETURN);

        //Set Up RNG
        WebElement lowerBound = driver.findElement(By.id("UMy8j"));
        WebElement upperBound = driver.findElement(By.id("nU5Yvb"));
        lowerBound.click();
        lowerBound.sendKeys(Keys.BACK_SPACE);
        lowerBound.sendKeys("0");
        upperBound.click();
        upperBound.sendKeys(Keys.BACK_SPACE);
        upperBound.sendKeys(Keys.BACK_SPACE);
        upperBound.sendKeys("9");

        //Generate Number and Store
        WebElement generateButton = driver.findElement(By.id("ZdzlKb"));
        WebElement generateResult = driver.findElement(By.xpath("//*[@id=\"Zv1Nfb\"]/div[1]"));

        for (int i = 0; i < n; i++) {
            generateButton.click();
            try {
                Thread.sleep(800);
            } catch (Exception e) {
                fails++;
                System.out.println("Fails: " + fails);
            }
            currentDataResult = Integer.parseInt(generateResult.getText());
            dataResultList.add(currentDataResult);
        }
        driver.quit();

        //Sort Numbers
        List<Integer> numbersTotal = new ArrayList<Integer>();
        for (int k = 0; k < 10; k++) {
            numbersTotal.add(0);
        }

        for (int j = 0; j < dataResultList.size(); j++) {
            int currentTestInt = dataResultList.get(j);
            numbersTotal.set(currentTestInt, numbersTotal.get(currentTestInt)+1);
        }

        //List Out Results
        int sum = 0;
        System.out.println("Results for Google");
        for (int m = 0; m < 10; m++) {
            System.out.println(m + "'s: " + numbersTotal.get(m));
            sum = sum + numbersTotal.get(m);
        }
        System.out.println("Sum: " + sum);

    }
}
