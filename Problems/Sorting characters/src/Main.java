import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static final char[] alphabets = new char[26];
    static {
        int index = 0;
        for( char letter ='a'; letter <= 'z'; letter++ ) {
            alphabets[index++] = letter;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charArray = new char[scanner.nextInt()];
        int index = 0;
        do {
            charArray[index++] = scanner.next().charAt(0);
        } while( index < charArray.length );
        int[] counts = new int[26];
        for( char c : charArray ) {
            counts[c-'a']++;
        }
        index = 0;
        for( int i = 0; i < counts.length; i++ ) {
            while( counts[i] > 0 ) {
                charArray[index++] = alphabets[i];
                counts[i]--;
            }

        }
        for( char c : charArray ) {
            System.out.print(c+" ");
        }
    }
}