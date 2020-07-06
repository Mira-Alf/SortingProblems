package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
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

    public static Operation getOperation( String[] args ) throws RuntimeException{
        int mode = getIndexOfArgument(args, "-mode");
        String operation = mode == -1 ? "enc" : args[mode];

        for( Operation op : Operation.values() ) {
            if( op.getName().equals(operation) )
                return op;
        }
        throw new RuntimeException("Invalid parameter for mode:"+operation);
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
    
    public static int getIndexOfArgument( String[] args, String key ) {
        for( int i = 0; i < args.length; i++ ) {
            if( args[i].equals(key) )
                return i+1;
        }
        return -1;
    }

    private static String getDataFromFile( String[] args, int fileIndex ) throws RuntimeException, IOException {
        String fileName = args[fileIndex];
        if( fileName.indexOf(".") == -1 )
            throw new RuntimeException("Invalid file name: "+fileName);
        return new String(Files.readAllBytes(Path.of(fileName)));
    }

    public static String getData(String[] args) throws RuntimeException, IOException {
        String originalText = "";
        int data = getIndexOfArgument(args, "-data");
        if( data == -1 ) {
            data = getIndexOfArgument(args, "-in");
            if( data != -1 )
                return getDataFromFile(args, data);
        } else
            originalText = args[data];
        return originalText;
    }

    public static void writeData(String[] args, String transformedText) throws RuntimeException, FileNotFoundException {
        int outFileIndex = getIndexOfArgument(args, "-out");
        if( outFileIndex == -1 )
            System.out.println(transformedText);
        else {
            String outFile = args[outFileIndex];
            if( outFile.indexOf(".") == -1 )
                throw new RuntimeException("Invalid file name: "+outFile);
            File file = new File(outFile);
            PrintWriter pw = new PrintWriter(file);
            pw.println(transformedText);
            pw.close();
        }
    }

    public static int getKey(String[] args) {
        int key = getIndexOfArgument(args, "-key");
        return key == -1 ? 0 : Integer.parseInt(args[key]);
    }


    public static void main(String[] args) {
        try {
            Operation op = getOperation(args);
            String originalText = getData(args);
            int shiftKey = getKey(args);
            String transformedText = transform(originalText, shiftKey, op);
            writeData(args, transformedText);
        } catch( FileNotFoundException | ArithmeticException ae ) {
            System.out.println("Error:"+ae.toString());
        } catch( IOException io ) {
            System.out.println("Error:"+io.toString());
        } catch(RuntimeException re) {
            System.out.println("Error:"+re.getMessage());
        } catch( Exception e ) {
            System.out.println("Error:"+e.getMessage());
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
