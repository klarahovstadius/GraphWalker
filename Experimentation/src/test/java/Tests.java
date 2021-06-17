import org.testng.annotations.Test;


import java.time.LocalDate;

public class Tests {

    ForFun forFun = new ForFun();
    int number;
    double prime;

    /**
     * Determine the position of a random number in an array
     */
    @Test
    public void findValueInArray() {
        int[] array = forFun.createRandomArray();
        int findValue = 4;
        System.out.println("Found place in array: " + forFun.findInArray(array, findValue));
    }

    /**
     * Write a simple Java program which will print Fibonacci series, e.g. 1 1 2 3 5 8 13 ... . up to a given number.
     */
    @Test
    public void Fibonacci() {
        number = 13;
        forFun.calculateFibonacci(number);
    }

    /**
     * Write a Java program to check if a given number is prime or not.
     * Remember, a prime number is a number which is not divisible by any other number, e.g. 3, 5, 7, 11, 13, 17, etc.
     */
    @Test
    public void prime() {
        prime = 7919;
        forFun.primeCheck(prime);
    }

    @Test
    public void firstTest() {
        String s1 = "Hej";
        int x = 20;

        for (int i = 0; i < 3; i++) {
            String y = Integer.toString(x);
            int length = y.length();
            int lengthString = s1.length();
            int minLength = 3;
            int minLengthString = 15;

            while (length < minLength) {
                y = "0" + y;
                length = y.length();
            }
            while (lengthString < minLengthString) {
                s1 = s1 + " ";
                lengthString = s1.length();
            }
            System.out.println(s1 + y);
        }
        System.out.println("================================");
    }

    @Test
    public void secondTest(){

    }


    @Test
    public void findDay() {
        int year = 2021;
        int month = 5;
        int day = 7;
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println(date.getDayOfWeek().toString());
    }

}