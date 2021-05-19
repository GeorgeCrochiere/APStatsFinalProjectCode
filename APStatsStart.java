public class APStatsStart {
    public static void main(String[] args) {
        //Define System ChromeDriver Location
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver_win32/chromedriver.exe");

        //Set Sample Size
        int n = 10000;

        //Run Generators
        RandomOrgDataAnalysis.randomAnalysis(n);
        GoogleDataCollection.googleGenerationAnalysis(n);
        JavaRNGCollection.javaGenerationAnalysis(n);

    }
}
