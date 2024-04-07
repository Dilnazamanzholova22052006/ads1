import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            //Show list of methods, and ask to input option.
            System.out.print(Methods.LIST_OF_METHODS);
            //If number 0 break loop,or if number from 1-10 its handle chosen method calling.
            int option = scanner.nextInt();
            if (option == 0) break;
            else if (option >= 1 && option <= 10) chooseMethod(option, scanner);
        }
    }

    /**
     * This method is used for inputting required variables, by calling
     * required method, and output result, depending on user choice
     * Code uses switch-case for call and output chosen method
     * Variables are created at the beginning of the method and then
     * getting values in 'case' blocks. User input is handled by the Utils
     * class methods. 'default' not necessary because chooseMethod other cases
     * are excluded in the main method.
     * @param option The method, chosen by user in main method.
     * @param scanner The Scanner object, used for reading System.in stream.
     */
    static void chooseMethod(int option, Scanner scanner){
        int n, k, a, b;
        String s;
        int[] arr;
        double startTime,endTime,duration;
        switch (option){ //Depending on user number, prepare and call method.
            //Firstly, program asks users for input required variables.
            //Then, using formatted strings from Constants, calling required method and outputting it.
            case 1:
                n = inputNumber('n', scanner);//this machinations is for evaluating time complexity of every task
                arr = inputArr(n, scanner);
                System.out.printf(Methods.MIN_ELEMENT, minElement(arr));
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 2:
                n = inputNumber('n', scanner);
                arr = inputArr(n, scanner);
                System.out.printf(Methods.AVERAGE, average(n, arr));
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 3:
                n = inputNumber('n', scanner);
                System.out.printf(Methods.IS_PRIME, n, (isPrime(n) ? "prime" : "composite"));
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 4:
                n = inputNumber('n', scanner);
                System.out.printf(Methods.FACTORIAL, n, factorial(n));
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 5:
                n = inputNumber('n', scanner);
                System.out.printf(Methods.FIBONACCI, n, fibonacci(n));
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 6:
                a = inputNumber('a', scanner);
                n = inputNumber('n', scanner);
                System.out.printf(Methods.POWER, a, n, power(a, n));
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 7:
                n = inputNumber('n', scanner);
                arr = inputArr(n, scanner);
                int start = 0;
                int end=0;
                System.out.printf(Methods.REVERSE,arrToString(reverseArray(n, arr,start,end)));
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 8:
                s=inputString(scanner);
                System.out.printf(Methods.IS_DIGIT, s, (isDigit(s) ? "is" : "is not"));
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 9:
                n = inputNumber('n', scanner);
                k = inputNumber('k', scanner);
                System.out.printf(Methods.BINOMIAL, n, k, binomial(n, k));
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;

            case 10:
                a = inputNumber('a', scanner);
                b = inputNumber('b', scanner);
                System.out.printf(Methods.GCD, a, b, gcd(a, b));
            startTime = System.nanoTime();
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
            System.out.println("Time taken: " + duration + " milliseconds");
            break;
        }
    }


    /**
     * This method finds minimum element of given array,by using "for" loop
     * Time complexity: O(n), where n is the length of the array.
     * For loop iterates through all elements of array,and gives result.
     * @param arr The given array of integer numbers of size n.
     * @return The minimum element of array.
     */
    static int minElement(int[] arr){
        int min = arr[0];
        //Iterating through all numbers from arr, comparing with variable 'min'.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];  // Update min if a smaller element is found
            }
        }
        return min;
    }


static int inputNumber(char c, Scanner scanner){
        System.out.printf("Enter number %c: ", c);
            return scanner.nextInt();

        }
static int[] inputArr(int n, Scanner scanner){
    int[] input = new int[n]; //Initializing integer array of size n.
        for(int i = 0; i < n; i++){
                System.out.printf("Enter %d-th number: ", i);
                input[i] = scanner.nextInt();
        }
        return input;
}

    public static String inputString(Scanner scanner){
        scanner.nextLine(); //Skip first, empty, string.
        while(true) {
            System.out.print("Enter string: ");
            try{
                String input = scanner.nextLine();
                if(!input.isEmpty()) return input;
                throw new InputMismatchException();
            }catch (InputMismatchException e){ //User inputted empty string.
                System.out.println(Methods.WRONG_INPUT);
            }
        }
    }
 static String arrToString(int[] arr){
        StringBuilder res = new StringBuilder();
        res.append("[");
        for(int i = 0; i < arr.length; i++){
            res.append(arr[i]);
            res.append(((i + 1) % arr.length == 0) ? "]" : ", "); //If i = index of last element in array =>
            //close brackets. Put comma otherwise.
        }
        return res.toString(); //StringBuilder != String, we need to convert it.
    }}
