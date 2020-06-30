import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] u = new double[2];
        double[] v = new double[2];
        int count = 0, index = 0;
        do {
            if( count < 2 ) {
                u[index] = scanner.nextInt();
                index++;
            } else {
                if( count == 2 ) index = 0;
                v[index] = scanner.nextInt();
                index++;
            }
            count++;            
        } while( count < 4 );
        double modU = Math.hypot(u[0], u[1]);
        double modV = Math.hypot(v[0], v[1]);
        double prodUV = u[0]*v[0] + u[1]*v[1];
        double cosineValue = prodUV/(modU*modV);
        double angleInRadians = Math.acos(cosineValue);
        System.out.println(Math.toDegrees(angleInRadians));
    }
}
