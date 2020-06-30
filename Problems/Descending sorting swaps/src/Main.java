import java.util.*;

public class Main {

    public static int[] getArray(String input) {
        String[] tokens = input.split("\\s+");
        int[] array = new int[tokens.length];
        int counter = 0;
        for( String s : tokens ) {
            array[counter++] = Integer.valueOf(s);
        }
        return array;
    }

    public static void swap( int[] array, int i, int j ) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        int[] array = getArray(inputLine);
        int numSwaps = 0;
        for( int i = array.length-1; i>0; i-- ) {
            for( int j = 1; j <=i; j++ ) {
                if( array[j] > array[j-1] ){
                    swap(array, j, j-1);
                    numSwaps++;
                }
            }
        }
        System.out.println(numSwaps);
    }
}