import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static void swap( int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    public static int getMaxIndex( int[] numbers, int startIndex ) {
        int maxIndex = startIndex;
        for( int i = startIndex+1; i < numbers.length; i++ ) {
            if (numbers[i] > numbers[maxIndex] )
                maxIndex = i;
        }
        return maxIndex;
    }

    public static int[] performModifiedSelectionSort(int[] numbers, int k) {
        int startIndex = 0;
        for( int i = 0; i < k; i++ ) {
            int maxIndex = getMaxIndex(numbers, startIndex);
            if( startIndex != maxIndex )
                swap(numbers, startIndex, maxIndex);
            startIndex++;
        }
        return Arrays.copyOf(numbers, k);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[scanner.nextInt()];
        int index = 0;
        do {
            numbers[index++] = Integer.parseInt(scanner.next());
        } while( index < numbers.length );
        int k = scanner.nextInt();
        numbers = performModifiedSelectionSort(numbers, k);
        for( int i = 0; i < numbers.length; i++ ) {
            System.out.print( numbers[i] +" ");
        }
    }
}