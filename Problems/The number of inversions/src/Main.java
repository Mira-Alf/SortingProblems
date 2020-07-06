import java.util.Scanner;

class Main {

    public static void sort(int[] numbers) {
        long[] numInversions = new long[]{0};
        mergeSort(numbers, 0, numbers.length, numInversions);
        System.out.println(numInversions[0]);
    }

    public static void mergeSort(int[] numbers, int startIndex, int endIndex, long[] numInversions) {
        if( endIndex <= startIndex+1) {
            return;
        }
        int middle = (endIndex-startIndex)/2 + startIndex;
        mergeSort(numbers,startIndex,middle,numInversions);
        mergeSort(numbers,middle,endIndex,numInversions);

        merge(numbers,startIndex,middle,endIndex,numInversions);

    }

    public static void merge(int[] numbers, int startIndex, int middle, int endIndex, long[] numInversions) {
        int index1 = startIndex, index2 = middle, index3 = 0;
        int[] tmp = new int[endIndex-startIndex];
        while(index1 < middle && index2 < endIndex) {
            if( numbers[index1] <= numbers[index2] ) {
                tmp[index3] = numbers[index1];
                index1++;
            } else {
                tmp[index3] = numbers[index2];
                numInversions[0] += middle-index1;
                index2++;
            }
            index3++;
        }
        for(;index1 < middle; index1++)
            tmp[index3++] = numbers[index1];
        for(;index2 < endIndex; index2++)
            tmp[index3++] = numbers[index2];
        System.arraycopy(tmp,0,numbers, startIndex,tmp.length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[scanner.nextInt()];
        int index = 0;
        do {
            numbers[index++] = scanner.nextInt();
        } while(index<numbers.length);
        sort(numbers);
    }
}