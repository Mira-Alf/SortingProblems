import java.util.Scanner;

public class Main {
    public static int getMaxOrMinIndex( int[] numbers, boolean isAscending, int startIndex ) {
        int minOrMax = numbers[startIndex];
        int position = startIndex;
        for( int i = startIndex+1; i < numbers.length; i++ ) {
            if( (isAscending && numbers[i] < minOrMax) || (!isAscending && numbers[i] > minOrMax) ) {
                minOrMax = numbers[i];
                position = i;
            }
        }
        return position;
    }

    private static void swap( int[] numbers, int i, int j ) {
        if( i != j ) {
            int tmp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = tmp;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[scanner.nextInt()];
        int index = 0;
        do {
            numbers[index++] = scanner.nextInt();
        } while( index < numbers.length );
        boolean isAscending = false;
        for( int i = 0; i < numbers.length-1; i++ ) {
            index = getMaxOrMinIndex(numbers, isAscending, i);
            swap(numbers,i,index);
            isAscending = !isAscending;
        }
        for( int a : numbers )
            System.out.print(a+" ");
    }
}