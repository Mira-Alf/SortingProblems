package encryptdecrypt;

import java.util.Scanner;

public class Main {

    private static final char[] LOWER_CASE = new char[26];
    static {
        int index = 0;
        for( char ch = 'a'; ch <= 'z'; ch++ ) {
            LOWER_CASE[index] =ch;
            index++;
        }
    }

    public static Operation getOperation( String operation ) {
        for( Operation op : Operation.values() ) {
            if( op.getName().equals(operation) )
                return op;
        }
        return null;
    }

    public static String transform( String originalText, int shiftKey, Operation op ) {
        char[] transformedChars = new char[originalText.length()];
        int index = 0;
        for( char ch : originalText.toCharArray() ) {
            int codeUnit = op == Operation.ENC ? ch + shiftKey : ch - shiftKey;
            transformedChars[index] = (char) codeUnit;
            index++;
        }
        return String.valueOf(transformedChars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operation op = getOperation(scanner.nextLine());
        if( op != null ) {
            String originalText = scanner.nextLine();
            int shiftKey = scanner.nextInt();
            String transformedText = transform( originalText, shiftKey, op );
            System.out.println(transformedText);
        }
    }
}
enum Operation {
    ENC("enc"), DEC("dec");
    private String name;
    Operation(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
