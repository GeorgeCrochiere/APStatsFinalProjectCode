import java.util.ArrayList;
import java.util.List;

public class JavaRNGCollection {
    public static void javaGenerationAnalysis(int n) {
        //Repeat n times, generate a random number between 0-9 and store it in an array

        List<Integer> javaGeneratedNumbers = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int randomNumber = (int) (Math.random() * 10);
            javaGeneratedNumbers.add(randomNumber);
        }

        //Sort Numbers into categories
        List<Integer> numbersTotal = new ArrayList<Integer>();
        for (int k = 0; k < 10; k++) {
            numbersTotal.add(0);
        }

        for (int j = 0; j < javaGeneratedNumbers.size(); j++) {
            int currentTestInt = javaGeneratedNumbers.get(j);
            numbersTotal.set(currentTestInt, numbersTotal.get(currentTestInt)+1);
        }

        //List Out Results
        int sum = 0;
        System.out.println("Results for Java RNG");
        for (int m = 0; m < 10; m++) {
            System.out.println(m + "'s: " + numbersTotal.get(m));
            sum = sum + numbersTotal.get(m);
        }
        System.out.println("Sum: " + sum);

    }
}
