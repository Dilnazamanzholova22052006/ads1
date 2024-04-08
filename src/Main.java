import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            //Show list of methods, and ask to input option.
            System.out.println("""
                Enter 0 if you want to quit the program
                Programs:
                1: Find the min value of the array
                2: Find the average value of the array
                3: Check whether number prime or nor
                4: Find factorial of n
                5: Find n-th number of the Fibonacci sequence
                6: a^n
                7: Reverse the sequence
                8: Check whether string is all consist of digits or not
                9: Find binomial coefficient for certain numbers
                10: Find GCD for numbers
                """);
            //If number 0 break loop,or if number from 1-10 its handle chosen method calling.
            int option = scanner.nextInt();
            if (option == 0) break;
            else if (option >= 1 && option <= 10) chooseMethod(option, scanner);
        }
    }

    /**
     *This method promotes the input of input variables
     * and outputs the result based on the user's selection.
     * It employs a switch-case structure to invoke and display the chosen method.
     * Variables are initialized at the method's outset and then
     * assigned values within the 'case' blocks.
     * The 'default' case is omitted.
     *The method takes two parameters: 'option',
     *  representing the user's choice of method in the main method,
     *  and 'scanner', a Scanner object utilized for reading from the System.in stream.
     */
    static void chooseMethod(int option, Scanner scanner){
        Scanner sc =new Scanner(System.in);
        int size,n, k, a, b;
        String s;
        int[] arr;
        double startTime,endTime,duration;
        switch (option){ //Depending on user number, prepare and call method.
            //Firstly, program asks users for input required variables.
            //Then, using formatted strings from Constants, calling required method and outputting it.
            case 1:
                System.out.println("Enter length of the array: ");
                size = sc.nextInt();
                System.out.println("Enter " + size + " numbers: ");
                arr = new int[size];
                for(int i = 0; i < size; i++) {
                    arr[i] = sc.nextInt();
                }
                int min=minElement(arr);
                System.out.println("The minimum value is: " + min);
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 2:
                System.out.println("Enter the length of sequence and sequence to evaluate average of sequence ");
                n=sc.nextInt();
                arr= new int[]{sc.nextInt()};
                double aver=average(n,arr);
                System.out.printf("Average number is: " + aver);
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 3:
                System.out.println("Enter the number to check if it is prime: ");
                n = sc.nextInt();
                if(isPrime(n)) {
                    System.out.println(n + " is prime.");
                } else {
                    System.out.println(n + " is composite.");
                }
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 4:
                System.out.println("Enter the number to evaluate its factorial: ");
                n = sc.nextInt();
                int f=factorial(n);
                System.out.printf("Factorial of the number " + n + " = " + f);
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 5:
                System.out.println("Enter the number to evaluate Fibonacci sequence: ");
                n = sc.nextInt();
                int fibo=fibonacci(n);
                System.out.println("n-th number in Fibonacci sequence is " + fibo );
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 6:
                System.out.println("Enter the numbers to evaluate a to the power n: ");
                a = sc.nextInt();
                n = sc.nextInt();
                int pow=power(a,n);
                System.out.printf(a + " to the power " + n + " = " + pow);
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 7:
                System.out.println("Enter the length of sequence,and sequence to reverse it: ");
                n = sc.nextInt();
                arr = new int[n];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = sc.nextInt();
                }
                startTime = System.nanoTime();
                reverseArray(arr, n);
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 8:
                System.out.println("Enter the string to checking if its consist of all digits: ");
                s=sc.nextLine();
                if(isDigit(s)) {
                    System.out.println("String is all consist of digits.");
                } else {
                    System.out.println("String is not all consist of digits.");
                }
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;
            case 9:
                System.out.println("Enter the numbers to evaluate Binomial coefficient: ");
                n = sc.nextInt();
                k = sc.nextInt();
                int binom=binomial(n,k);
                System.out.println("Binomial coefficient for the given numbers " + binom);
                startTime = System.nanoTime();
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds
                System.out.println("Time taken: " + duration + " milliseconds");
                break;

            case 10:
                System.out.println("Enter the numbers to find their GCD: ");
                a = sc.nextInt();
                b = sc.nextInt();
                System.out.println("gcd of 2 numbers is"+ gcd(a, b));
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

    /**
     * This method calculates the average of the elements of a given
     * array.
     * It uses a for loop.
     * Time complexity: O(n), where n is the length of the array.
     * For loop iterates through all elements of array, resulting
     * in linear time complexity.
     *
     * @param n The given number of elements in array.
     * @param arr The given array of integer numbers of size n.
     * @return The average of numbers of array.
     */
    static float average(int n, int[] arr){
        int sum = 0;
        //Adding all numbers from array, getting total of that numbers.
        for(int i=1;i<arr.length;i++){
            sum+=i;
        }
        //Average = is a dividing sum of all given numbers by the amount of numbers
        return (float) sum / n;
    }
    /**
     * This method checks if given number is prime or composite.
     * It uses a for loop.
     * Time complexity: O(sqrt(n)), where n is the given number.
     * For loop iterates through numbers from 2 to sqrt(n),
     * resulting in square root time complexity.
     *
     * @param n The given number n, for which the method checks if
     *          it is prime.
     * @return true if given number is prime, or false if given
     * number is composite.
     */
    static boolean isPrime(int n){
        if(n == 0 || n == 1){
            return false; //because 0 and 1 neither prime nor composite.
        }
        //If there exists a positive int x
        //for which n/x = is any integer except 0: = n not prime.
        for(int i = 2; i < Math.sqrt(n); i++){
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method calculates the factorial of a given number.
     * It uses a recursive approach.
     * Time complexity: O(n), where n is the given number.
     * The recursive algorithm iterates through all numbers from n
     * to 1, resulting in linear time complexity.
     *
     * @param n The number for which the factorial is to be calculated.
     * @return The factorial of the given number.
     */
    static int factorial(int n){
        if(n == 0 || n==1 ) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * This method calculates n-th element in the Fibonacci sequence.
     * It uses a recursive approach.
     * Time complexity: O(2^n), where n is the given number.
     * The recursive algorithm calls itself for each non-base case,
     * resulting in exponential time complexity.
     *
     * @param n The index of the number in the Fibonacci sequence
     *          to be calculated.
     * @return The n-th element in the Fibonacci sequence.
     */
    static int fibonacci(int n){
        //fibonacci(1) = 1, fibonacci(0) = 0
        if(n == 1) {
            return 1;
        }
        else if (n == 0) {
            return 0;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * This method calculates the power n of a number.
     * It uses a recursive approach.
     * Time complexity: O(n), where n is the exponent.
     * The recursive algorithm multiplies the base 'a' by itself
     * 'n' times, resulting in linear time complexity.
     *
     * @param a The given base number.
     * @param n The given exponent.
     * @return The number a^n.
     */
    static int power(int a, int n){
        if(n == 1) {
            return a;
        }
        return a * power(a, n - 1);
    }

    /**
     * This method reverses a given array.
     * It uses a recursive approach.
     * Time complexity: O(n), where n is the length of the array.
     * The recursive algorithm swaps the elements at the beginning
     * and end of the array, and then recursively calls itself on
     * the rest of the array. This results in linear time complexity.
     *
     * @param arr The given array of integer numbers.
     * @param n The current index.
     * @return The given array in reverse order.
     */
    static void reverseArray(int[] arr, int n) {
        if (n== 0){
            System.out.println();
            return;
        }
        System.out.print(arr[n-1] + " ");
        reverseArray(arr, n - 1);
    }
    /**
     * This method checks if a given string contains only digits.
     * It uses a recursive approach.
     * Time complexity: O(n), where n is the length of the string.
     * The recursive algorithm checks if first character is digit,
     * and then calls itself for rest of characters in the string.
     * This results in linear time complexity.
     *
     * @param s The given string to be checked.
     * @return true if the given string contains only numeric
     * characters, or false otherwise.
     */
    static boolean isDigit(String s){
        // Check if each character in the string is a digit,by using charAt which checks if whether s in characters
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false; // If any character is not a digit, return false
            }
        }
        return true; // If all characters are digits, return true
    }
    /**
     *This method calculates the binomial coefficient C(n, k).
     * It uses a recursive approach based on the identity
     * C(n, k) = C(n - 1, k - 1) + C(n - 1, k).
     * Time complexity: O(2^n), where n is the first parameter.
     * This is because each call to this method results in two
     * recursive calls unless it falls into the base case.
     * The recursive algorithm calculates the binomial coefficient
     * by breaking it down into two smaller coefficients, resulting
     * in the exponential time complexity.
     *
     * @param n The n number of binomial coefficient to be calculated.
     * @param k The k number of binomial coefficient to be calculated.
     * @return The binomial coefficient of numbers n and k.
     */
    static int binomial(int n,int k){
        if(k == 0 || k == n){
            return 1;
        }
        return binomial(n - 1, k - 1) + binomial(n - 1, k);
    }
    /**
     * This method calculates the greatest common divisor
     * (GCD) of two numbers.
     * It uses a recursive approach.
     * Time complexity: O(log(min(a,b)), where 'a' and 'b'
     * are the input number. With each recursive call, the
     * problem size decreases geometrically.
     *
     * @param a The 1st number of GCD.
     * @param b The 2nd number of GCD.
     * @return The greatest common divisor (GCD) of 'a' and 'b'.
     */
    static int gcd(int a, int b){
        //GCD rules.
        if(a == 0) return b;
        if(b == 0) return a;
        return gcd(b, a % b);
    }


}