package EstructurasLineales;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Queue {
    
    Node head = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void printQueue() {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;

        try {
            bw.write("Nodos: \n\n");
            while (temp != null) {
                bw.write(temp.toString() + "\n");
                temp = temp.next;
            }
            bw.flush();
        } catch (IOException e) {}
    }
    
    public void enqueue(Node newNode) {
        if (isEmpty())
            head = newNode;
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }
    
    public Node dequeue() {
        Node temp = head;
        head = head.next;
        return temp;
    }
    
    public Node front() {
        return head;
    }
    
    public int length() {
        if (isEmpty())
            return 0;
        Node temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }
}
