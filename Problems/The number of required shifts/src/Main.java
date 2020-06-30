import java.util.Arrays;
import java.util.Scanner;

class Main {

    private static void shiftArray( int[] array, int startIndex, int endIndex ) {
        for( int j = endIndex; j > startIndex; j-- ) {
            array[j] = array[j-1];
        }
    }

    public static int sort( int[] array ) {
        int numShifts = 0;
        for( int i = 1; i < array.length; i++ ) {
            for( int j = 0; j < i; j++ ) {
                if( array[i] > array[j] ) {
                    int numberToShift = array[i];
                    shiftArray(array,j,i);
                    array[j] = numberToShift;
                    numShifts++;
                }
            }
        }
        return numShifts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];

        int counter = 0;
        do {
            array[counter] = scanner.nextInt();
            counter++;
        } while( counter < array.length );
        System.out.println(sort(array));
    }
}