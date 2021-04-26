import org.testng.annotations.Test;

public class test {

    public int[] createArray() {
        int[] arr = new int[101];
        for (int i = 1; i < 101; i++) {
            arr[i] = (int) Math.floor(Math.random() * (100 + 1) + 1);
            //System.out.println(arr[i]);
        }
        return arr;
    }

    private Integer findArray(int[] array, int findValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == findValue) {
                return i;
            }
        }
        return null;
    }

    @Test
    public void findValueInArray() {
        int[] array = createArray();
        int findValue = 4;
        System.out.println("Found place in array: " + findArray(array, findValue));
    }

}
