import java.util.Random;

public class MathProgram {
    public static void main(String[] args) {
        long[] z = new long[16];

        for (int i = 3; i <= 18; i++) {
            z[i - 3] = i;
        }

        Random random = new Random();
        float[] x = new float[20];
        float min = -8, max = 10;

        for (int i = 0; i < x.length; i ++) {
            x[i] = min + random.nextFloat() * (max - min);
        }

        double z1[][] = new double[16][20];

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 20; j++) {
                if (z[i] == 4) {
                    z1[i][j] = Calculation1(x[j]);
                } else if ((int) z[i] == 3 || (int) z[i] == 5 || (int) z[i] == 6 || (int) z[i] == 7 ||
                           (int) z[i] == 12 || (int) z[i] == 13 || (int) z[i] == 14 || (int) z[i] == 17) {
                    z1[i][j] = Calculation2(x[j]);
                } else {
                    z1[i][j] = Calculation3(x[j]);
                }
            }
        }
        PrintArray(z1);
    }
    public static double Calculation1(float x) {
        double arg = (x + 1) / 18;

        if (Math.abs(arg) > 1) {
            return Double.NaN;
        }

        return Math.exp(Math.pow(2 * Math.asin(arg), 2));
    }
    public static double Calculation2(float x) {
        double base = (Math.PI + x) / Math.PI;
        double powBase = Math.pow(base, x);

        return Math.pow((Math.pow((powBase / 2), 2) / 2), 3); 
    }    
    public static double Calculation3(float x) {
        double ratio = (x + 1) / 18;
        
        if (Math.abs(ratio) > 1) {
            return Double.NaN; 
        }
        
        double asinValue = Math.asin(Math.pow(ratio, 2));
        
        return Math.pow(Math.cbrt(asinValue), 1.0 / 4 / (2.0 / 3 - Math.asin(1.0 / Math.exp((4 + Math.acos(ratio)) / Math.acos(ratio)))));       
    }
    public static void PrintArray(double arr[][]) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 20; j++) {           
                System.out.printf("%35.3f", arr[i][j]);  
            }
            System.out.println();
        }
    }
}