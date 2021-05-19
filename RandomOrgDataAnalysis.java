import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class RandomOrgDataAnalysis {
    public static void randomAnalysis(int n) {
        //Define Variables and Store
        List<Integer> dataRandomOrg = new ArrayList<Integer>();

        //Get to random.org
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.random.org/integers/?mode=advanced");
        driver.navigate().to("https://www.random.org/integers/?mode=advanced");

        //Identify Elements that will be interacted with
        WebElement totalGenerated = driver.findElement(By.name("num"));
        WebElement minValue = driver.findElement(By.name("min"));
        WebElement maxValue = driver.findElement(By.name("max"));
        WebElement formatValue = driver.findElement(By.name("col"));
        WebElement bareBonesSelect = driver.findElement(By.xpath("//*[@id=\"invisible\"]/form/p[5]/input[2]"));
        WebElement getNumbersButton = driver.findElement(By.xpath("//*[@id=\"invisible\"]/form/p[9]/input[1]"));

        //Set random.org and generate values
        totalGenerated.click();
        totalGenerated.sendKeys(Keys.BACK_SPACE);
        totalGenerated.sendKeys(Keys.BACK_SPACE);
        totalGenerated.sendKeys(Keys.BACK_SPACE);
        totalGenerated.sendKeys(Integer.toString(n));
        minValue.click();
        minValue.sendKeys(Keys.BACK_SPACE);
        minValue.sendKeys("0");
        maxValue.click();
        maxValue.sendKeys(Keys.BACK_SPACE);
        maxValue.sendKeys(Keys.BACK_SPACE);
        maxValue.sendKeys(Keys.BACK_SPACE);
        maxValue.sendKeys("9");
        formatValue.click();
        formatValue.sendKeys(Keys.BACK_SPACE);
        formatValue.sendKeys(Integer.toString(n));
        bareBonesSelect.click();
        getNumbersButton.click();

        //Collect Values
        WebElement generatedList = driver.findElement(By.xpath("/html/body/pre"));
        String generatedValuesRaw = generatedList.getText();
        for (int i = 0; i < generatedValuesRaw.length(); i++) {
            if (((generatedValuesRaw.charAt(i))%1 == 0) && ((generatedValuesRaw.charAt(i)) != ' ')) {
                dataRandomOrg.add(Character.getNumericValue(generatedValuesRaw.charAt(i)));
            }
        }
        driver.quit();

        //Sort Numbers
        List<Integer> numbersTotal = new ArrayList<Integer>();
        for (int k = 0; k < 10; k++) {
            numbersTotal.add(0);
        }

        for (int j = 0; j < dataRandomOrg.size(); j++) {
            int currentTestInt = dataRandomOrg.get(j);
            numbersTotal.set(currentTestInt, numbersTotal.get(currentTestInt)+1);
        }

        //List Out Results
        int sum = 0;
        System.out.println("Results for random.org");
        for (int m = 0; m < 10; m++) {
            System.out.println(m + "'s: " + numbersTotal.get(m));
            sum = sum + numbersTotal.get(m);
        }
        System.out.println("Sum: " + sum);

    }
}
