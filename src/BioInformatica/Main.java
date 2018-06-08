package BioInformatica;

import java.io.*;

public class Main {

    List sequencesList = new List();
    int max_ocurrences = Integer.MIN_VALUE;
    String motif_winner = "";
    
    public void compareMotif(String motif_candidate) {
        int counter = counterOcurrences(motif_candidate);
        if (counter > max_ocurrences) {
            max_ocurrences = counter;
            motif_winner = motif_candidate;
        }
    }
    
    public int counterOcurrences(String motif_candidate) {
        int counter = 0;
        String gen_sequence;
        
        Sequence temp = sequencesList.head; 
        while (temp != null) {
            gen_sequence = temp.sequence;
            for (int i = 0; i < (gen_sequence.length() - motif_candidate.length()); i++)
                if (gen_sequence.substring(i, i + motif_candidate.length()).equals(motif_candidate)) {
                    counter++;
                    i += motif_candidate.length() - 1;
                }
            temp = temp.next;
        }
        
        return counter;
    }
    
    public void generateCombinations(String subsequence, int size) {
        if (size == 1) {
            compareMotif(subsequence + "A");
            compareMotif(subsequence + "C");
            compareMotif(subsequence + "G");
            compareMotif(subsequence + "T");
        } else {
            generateCombinations(subsequence + "A", size - 1);
            generateCombinations(subsequence + "C", size - 1);
            generateCombinations(subsequence + "G", size - 1);
            generateCombinations(subsequence + "T", size - 1);
        }
    }
    
    public void countChromosomes() throws IOException {
        int[]  chromosomes = new int[23];
        String cromosoma;
        int index;
        Sequence temp = sequencesList.head;
        while (temp != null) {
            if (temp.sequence.contains(motif_winner)) {
                cromosoma = temp.chromosome;
                cromosoma = cromosoma.replace("chr", "");
                index = Integer.parseInt(cromosoma) - 1;
                chromosomes[index]++;
            }
            temp = temp.next;
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 23; i++)
            bw.write("Cromosoma " + (i + 1) + ": " + chromosomes[i] + "\n");
        bw.flush();
    }

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("sequences.txt");
            BufferedReader br = new BufferedReader(fr);

            String input = br.readLine();
            Main run = new Main();
            
            while (input != null) {
                String[] data = input.split(",");
                run.sequencesList.insertAtEnd(new Sequence(data[0], data[1], 
                        Integer.parseInt(data[2]), Integer.parseInt(data[3])));
                input = br.readLine();
            }
            
            run.generateCombinations("", 4);
            System.out.println("Motif ganador: " + run.motif_winner + 
                            "\t Ocurrencias: " + run.max_ocurrences);
            run.countChromosomes();
        } catch (IOException e) {}
    }

}