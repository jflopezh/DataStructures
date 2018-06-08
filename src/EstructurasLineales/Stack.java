package EstructurasLineales;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Stack {
    
    Node head = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void printStack() {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;
        
	try {
            bw.write("Nodos: \n\n");
            while(!isEmpty())
                bw.write(pop().toString() + "\n");
        
            bw.flush();
	} catch(IOException ex) {}
    }
    
    public void push(Node newNode) {
        newNode.next = head;
        head = newNode;
    }
    
    public Node pop() {
        Node temp = head;
        head = head.next;
        return temp;
    }
    
    public Node peek() {
        return head;
    }
    
}
