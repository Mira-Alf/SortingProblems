import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static void swap( int[] numbers, int i, int j ) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    public static int sortBySelection( int[] numbers ) {
        int numOperations = 0;
        for( int i = 0; i < numbers.length; i++ ) {
            int index = i;
            for( int j = i+1; j< numbers.length; j++ ) {
                if( numbers[j] < numbers[index] ) {
                    index = j;
                    numOperations++;
                }
            }
            swap(numbers,index,i);
            numOperations++;
        }
        return numOperations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] numbers = new int[scanner.nextInt()][scanner.nextInt()];
        for( int i = 0; i < numbers.length; i++ ) {
            for( int j = 0; j < numbers[i].length; j++ ) {
                numbers[i][j] = scanner.nextInt();
            }
        }
        int[] numOperations = new int[numbers.length];
        int index = 0;
        for( int[] row : numbers ) {
            numOperations[index++] = sortBySelection(row);
        }
        index = 0;
        for( int i = 1; i < numOperations.length; i++ ) {
            if( numOperations[i] > numOperations[index] ) {
                index = i;
            }
        }
        System.out.println(index+1);

    }
}