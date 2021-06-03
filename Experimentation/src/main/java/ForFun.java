import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ForFun {


    public int[] createRandomArray() {
        int[] arr = new int[101];
        for (int i = 1; i < 101; i++) {
            arr[i] = (int) Math.floor(Math.random() * (100 + 1) + 1);
            //System.out.println(arr[i]);
        }
        return arr;
    }

    public Integer findInArray(int[] array, int findValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == findValue) {
                return i;
            }
        }
        return null;
    }

    public void calculateFibonacci(int endNumber) {
        List<Integer> list = new ArrayList<>();
        int firstNo = 1;
        int nextNo = 1;
        int newNextNo;
        list.add(firstNo);
        list.add(nextNo);
        for (int i = 1; i <= 100; i++) {
            newNextNo = firstNo + nextNo;
            firstNo = nextNo;
            nextNo = newNextNo;
            if (newNextNo > endNumber) {
                break;
            }
            list.add(nextNo);
        }
        System.out.println(list);
    }

    public void primeCheck(double number) {
        for (int i = 2; i <= number; i++) {
            double divided = number / i;
            if (divided % 1 == 0 && i < number) { //%=remainder of division
                System.out.println("Not a prime number.");
                break;
            } else if (i == number) {
                System.out.println("A prime number.");
            }
        }

    }
}
