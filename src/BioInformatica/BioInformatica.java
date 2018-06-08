package BioInformatica;

import java.io.*;
import java.util.Random;

public class BioInformatica {

    public static String nucleotide() {
        Random rd = new Random();
        switch (rd.nextInt(4)) {
            case 0:
                return "A";
            case 1:
                return "C";
            case 2:
                return "G";
            case 3:
                return "T";
            default:
                return "";
        }
    }

    public static String chromosome() {
        Random rd = new Random();
        return "chr" + (rd.nextInt(23) + 1);
    }

    public static String sequence(int lenght) {
        if (lenght == 1)
            return nucleotide();
        else
            return nucleotide() + sequence(lenght - 1);
    }

    public static void saveSequences() {
        try {
            FileWriter file = new FileWriter("sequences.txt");
            BufferedWriter bw = new BufferedWriter(file);
            
            Random rd = new Random();
            int lenght, start, datasize = 1000;
            
            for (int i = 0; i < datasize; i++) {
                lenght = rd.nextInt(46) + 5;
                start = rd.nextInt(1000 + 1);
                String experimental_read = sequence(lenght) + "," + chromosome() + "," + start + "," + (start + (lenght - 1));
                bw.write(experimental_read + "\n");
            }
            
            bw.flush();
        } catch (IOException e) {}
    }

    public static void main(String[] args) {
        saveSequences();
    }

}
