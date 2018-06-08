package ProblemasHackerEarth;

import EstructurasLineales.NodeInt;
import EstructurasLineales.Stack;
import java.util.Scanner;

public class MonkAndPhilosophersStone {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        Stack harryBag = new Stack();
        
        for (int i = 0; i < N; i++)
            harryBag.push(new NodeInt(s.nextInt()));
        
        int Q = s.nextInt();
        int X = s.nextInt();
        
        Stack monkBag = new Stack();
        int worthMonkBag = 0;
        
        String instruction;
        NodeInt coin;
        
        for (int i = 0; i < Q; i++) {
            instruction = s.next();
            if (instruction.equals("Harry")) {
                coin = (NodeInt) harryBag.pop();
                monkBag.push(coin);
                worthMonkBag += coin.value;
            } else if (instruction.equals("Remove")) {
                monkBag.pop();
            }
            
            if (worthMonkBag == X) {
                
            }
        }
    }
    
}
