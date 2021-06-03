import org.testng.annotations.Test;

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
     *
     */
    @Test
    public void prime(){
        prime = 7919;
        forFun.primeCheck(prime);
    }
}
