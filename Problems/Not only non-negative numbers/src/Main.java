import java.util.Scanner;
import java.util.Arrays;

public class Main {

    private static int[] getMinAndMax(int[] numbers) {
        int[] minAndMax = new int[2];
        minAndMax[0] = numbers[0];
        minAndMax[1] = numbers[1];
        for( int i = 1; i < numbers.length; i++ ) {
            if( numbers[i] < minAndMax[0] )
                minAndMax[0] = numbers[i];
            if( numbers[i] > minAndMax[1] )
                minAndMax[1] = numbers[i];
        }
        return minAndMax;
    }
    public static void countingSort(int[] numbers) {
        int[] minMaxArray = getMinAndMax(numbers);
        int minimum = -minMaxArray[0];
        int maximum = minMaxArray[1];
        int[] counts = new int[maximum+1+minimum];
        for( int i = 0; i < numbers.length; i++ ) {
            counts[numbers[i]+minimum]++; 
        }
        int index = 0;
        for( int i = 0; i < counts.length; i++ ) { 
            while( counts[i] > 0 ) {
                numbers[index++] = i-minimum;
                counts[i]--;
            }
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String elements = scanner.nextLine();
        final int[] array = Arrays.stream(elements.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        countingSort(array);
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
    }
}
