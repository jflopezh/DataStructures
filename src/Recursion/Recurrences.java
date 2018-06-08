package Recursion;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Recurrences {

    public int mcd_euclides(int a, int b) {
        if (b == 0)
            return a;
        return mcd_euclides(b, a % b);
    }

    public int factorial(int x) {
        if (x == 1) {
            return 1;
        }
        return x * factorial(x - 1);
    }

    public int fibonacci(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        return fibonacci(x - 1) + fibonacci(x - 2);
    }

    public int pascal(int n, int k) {
        if (k == 0 || k == n)
            return 1;
        return pascal(n-1, k-1) + pascal(n-1, k);
    }

    public String print_pascal() {
        String pascal_matrix = "";

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                pascal_matrix += pascal(i, j) + "\t";
            }

            pascal_matrix += "\n";
        }

        return pascal_matrix;
    }

    public int multiplicacion(int n, int x) {
        if (n == 0 || x == 0)
            return 0;
        return n + multiplicacion(n, x - 1);
    }

    public String inversa_cadena(String cadena) {
        if (cadena.length() == 1) {
            return cadena;
        }
        return cadena.substring(cadena.length() - 1) + inversa_cadena(cadena.substring(0, cadena.length() - 1));
    }

    public boolean isPalindrome(String cadena) {
        return cadena.equals(inversa_cadena(cadena));
    }

    public static void main(String[] args) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Recurrences recurrencias = new Recurrences();

        try {
            bw.write(recurrencias.factorial(15) + "\n"); // output: 2004310016

            bw.write(recurrencias.fibonacci(25) + "\n"); // output: 75025

            bw.write(recurrencias.multiplicacion(654, 97) + "\n"); // output: 63438

            bw.write(recurrencias.mcd_euclides(369, 1218) + "\n"); // output: 3

            bw.write(recurrencias.inversa_cadena("asdfghjkl") + "\n"); // output: lkjhgfdsa

            bw.write(recurrencias.print_pascal() + "\n");
            /*
			 * 1	
			 * 1	1	
			 * 1	2	1	
			 * 1	3	3	1	
			 * 1	4	6	4	1	
			 * 1	5	10	10	5	1	
			 * 1	6	15	20	15	6	1	
			 * 1	7	21	35	35	21	7	1	
			 * 1	8	28	56	70	56	28	8	1	
			 * 1	9	36	84	126	126	84	36	9	1
             */

            bw.flush();
        } catch (IOException ex) {
        }
    }
}
