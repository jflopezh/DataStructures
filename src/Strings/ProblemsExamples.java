package Strings;

import java.io.*;

public class ProblemsExamples {

    public static String itsConfidencial(String input) {
        if (input.length() > 1) {
            int middle = (int) (Math.ceil(input.length() / 2.0) - 1);
            return input.substring(middle, middle + 1)
                    + itsConfidencial(input.substring(0, middle))
                    + itsConfidencial(input.substring(middle + 1));
        } else {
            return input;
        }
    }

    public static String dna_pride(int length, String input) {
        String output = "";
        if (!input.contains("U")) {
            for (int i = 0; i < length; i++) {
                switch (input.charAt(i)) {
                    case 'A':
                        output += "T";
                        break;
                    case 'C':
                        output += "G";
                        break;
                    case 'G':
                        output += "C";
                        break;
                    default:
                        output += "A";
                        break;
                }
            }
        } else {
            output = "Error RNA nucleobases found!";
        }

        return output;
    }

    public static int bin2dec(String input) {
        int number = 0;
        int length = input.length();
        for (int i = 0; i < input.length(); i++) {

            int index = length - 1 - i;
            number += ((Integer.parseInt(input.substring(index, index + 1)) * (int) (Math.pow(2, i)))) % 1000000000;
        }

        return number;
    }

    public static String gcd_string(int a, int b) {
        String number_binary = "";

        if (a % b == 0) {
            number_binary = "1";
            for (int i = 0; i < a - 1; i++) {
                number_binary += "0";
            }
        } else {
            String pattern = gcd_string(b, (a % b));
            while (number_binary.length() < a) {
                number_binary += pattern;
            }

            number_binary = number_binary.substring(0, a);
        }
        return number_binary;
    }

    public static int anagrams(String a, String b) {
        int counter = 0, i, j;
        boolean found;

        for (i = 0; i < a.length(); i++) {
            found = false;

            for (j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                counter += 1;
            } else {
                b = b.substring(0, j) + b.substring(j + 1);
            }
        }

        return counter;
    }
    
    public static String palindromic_string(String input) {
        boolean response = true;
        int size = input.length();
        int middle = size / 2;

        for (int i = 0; i < middle; i++) {
            if (input.charAt(i) != input.charAt(size - 1 - i)) {
                response = false;
                break;
            }
        }

        if (response) {
            return "YES\n";
        } else {
            return "NO\n";
        }
    }

    public static String print_first_occurence(String input) {
        String response = "";
        boolean found;

        for (int i = 0; i < input.length(); i++) {
            found = false;

            for (int j = 0; j < response.length(); j++) {
                if (input.charAt(i) == response.charAt(j)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                response += input.substring(i, i + 1);
            }
        }

        return response;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int cases = Integer.parseInt(br.readLine());

            for (int i = 0; i < cases; i++) {
                bw.write((palindromic_string(br.readLine())));
            }

            bw.flush();
        } catch (Exception ex) {
        }
    }
}
