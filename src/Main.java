import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
                //Show list of methods, and ask to input option.
                System.out.print(Constants.LIST_OF_METHODS);
                //If number 0 break loop,or if number from 1-10 its handle chosen method calling.
                int option = scanner.nextInt();
                if(option == 0) break;
                else if(option >= 1 && option <= 10) chooseMethod(option, scanner);
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
        switch (option){ //Depending on user number, prepare and call method.
            //Firstly, program asks users for input required variables.
            //Then, using formatted strings from Constants, calling required method and outputting it.
            case 1:
                n = inputNumber('n', scanner);
                arr = inputArr(n, scanner);
                System.out.printf(Constants.MIN_ELEMENT, minElement(arr));
                break;
            case 2:
                n = inputNumber('n', scanner);
                arr = inputArr(n, scanner);
                System.out.printf(Constants.AVERAGE, average(n, arr));
                break;
            case 3:
                n = inputNumber('n', scanner);
                System.out.printf(Constants.IS_PRIME, n, (isPrime(n) ? "prime" : "composite"));
                break;
            case 4:
                n = inputNumber('n', scanner);
                System.out.printf(Constants.FACTORIAL, n, factorial(n));
                break;
            case 5:
                n = inputNumber('n', scanner);
                System.out.printf(Constants.FIBONACCI, n, fibonacci(n));
                break;
            case 6:
                a = inputNumber('a', scanner);
                n = inputNumber('n', scanner);
                System.out.printf(Constants.POWER, a, n, power(a, n));
                break;
            case 7:
                n = inputNumber('n', scanner);
                arr = inputArr(n, scanner);
                int start = 0;
                int end=0;
                System.out.printf(Constants.REVERSE,arrToString(reverseArray(n, arr,start,end)));
                break;
            case 8:
                s = inputString(scanner);
                System.out.printf(Constants.IS_DIGIT, s, (isDigit(s) ? "is" : "is not"));
                break;
            case 9:
                n = inputNumber('n', scanner);
                k = inputNumber('k', scanner);
                System.out.printf(Constants.BINOMIAL, n, k, binomial(n, k));
                break;
            case 10:
                a = inputNumber('a', scanner);
                b = inputNumber('b', scanner);
                System.out.printf(Constants.GCD, a, b, gcd(a, b));
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
        //for which n/x = is any integer except 0 = n not prime.
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
     * @param n   The given number of elements in array.
     * @param arr The given array of integer numbers.
     * @return The given array in reverse order.
     */
    static int[] reverseArray(int n, int[] arr, int start, int end) {
        // Base condition: if start index is greater than or equal to end index, return

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        // Recursive call to reverse the remaining sub-array
        return reverseArray(n, arr, start + 1, end - 1);
    }

    /**
     * This method swaps i-th and j-th elements of array.
     * It operates with constants.
     * Time complexity: O(1), resulting in constant time complexity.
     *
     * @param i The index of first element to be swapped.
     * @param j The index of second element to be swapped.
     * @param arr The array, which elements will be swapped.
     */
    static void swapElements(int i, int j, int[] arr){
        //Swap i-th and j-th element.
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        //Pointless to return array, because arr is pointer to outer array.
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
     * This method calculates the binomial coefficient C(n, k).
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

static String inputString(Scanner scanner) {
        System.out.print("Enter string: ");
            String input = scanner.nextLine();
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