import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.math.RoundingMode;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        int errorCount = 0;
        int count = 0;
        ArrayList<Integer> validInputArray = new ArrayList<Integer>();

        System.out.println("Welcome to the program. You will be asked to enter as many positive " +
                "integer values as you'd like. Only positive integers will be used for the calculations.");


        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to enter a value? Enter 'y' to submit a value." +
                    " Enter 'n' to start calculations");
            String userInput = scanner.nextLine();
            if (userInput.equals("y")){
                System.out.println("Please enter a positive integer");
                boolean hasNextInt = scanner.hasNextInt();
                if (hasNextInt ) {
                    int userInt = scanner.nextInt();
                    if (userInt > 0){
                        count++;
                        validInputArray.add(userInt);
                    } else {
                        errorCount++;
                    }

                } else {
                    errorCount++;
                }

            } else if (userInput.equals("n")){

                break;
            } else {
                System.out.println("Invlaid input. Enter y or n");
            }

        }

        int[] calculationArray = new int[validInputArray.size()];
        for (int i = 0; i < validInputArray.size(); i++){
            calculationArray[i] = validInputArray.get(i);
        }

        if (calculationArray.length > 0){
            System.out.println("Count: " + calculationArray.length);
            System.out.println("Minimum: " + findMin(calculationArray));
            System.out.println("Maximum: " + findMax(calculationArray));
            System.out.println("Mean: " + mean(calculationArray) );
            System.out.println("Median: " + median(calculationArray) );
            System.out.println("Errors: " + errorCount);
        } else {
            System.out.println("Count: " + calculationArray.length);
            System.out.println("Minimum: n/a");
            System.out.println("Maximum: n/a");
            System.out.println("Mean: n/a");
            System.out.println("Median: n/a");
            System.out.println("Errors: " + errorCount);
        }





    }

    public static int findMin(int[] Array){
        int Min = Array[0];
        for (int i =1; i < Array.length; i++){
            if(Array[i] < Min){
                Min = Array[i];
            }
        }
        return Min;
    }

    public static int findMax(int[] Array){
        int Max = Array[0];
        for (int i =1; i < Array.length; i++){
            if(Array[i] > Max){
                Max = Array[i];
            }
        }
        return Max;
    }

    public static BigDecimal median(int[] Array){
        Arrays.sort(Array);
        if (Array.length%2 == 0 ){
            int middlePosition = Array.length/2;
            int nextPosition = middlePosition - 1;
            double averageValue = (Array[middlePosition] + Array[nextPosition])/2;
            BigDecimal medianBigDecimal = new BigDecimal(averageValue).setScale(2, RoundingMode.HALF_UP);
            return medianBigDecimal;

        } else {
            int middlePosition = Array.length/2;
            BigDecimal medianBigDecimal = new BigDecimal(Array[middlePosition]).setScale(2, RoundingMode.HALF_UP);
            return medianBigDecimal;
        }
    }



    public static BigDecimal mean(int[] Array){
        double mean = (sum(Array) / Array.length);
        BigDecimal meanBigDecimal = new BigDecimal(mean).setScale(2, RoundingMode.HALF_UP);
        return meanBigDecimal;


    }

    public static double sum(int[] sumArray){
        int sum = 0;
        for(int i : sumArray){
            sum += i;
        }
        return sum;
    }
}
