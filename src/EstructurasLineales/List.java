package EstructurasLineales;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class List {

    Node head = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
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

    public void insertAtBegin(Node newNode) {
        newNode.next = head;
        head = newNode;
    }

    public void insertAtPosition(Node newNode, int position) {
        Node prev = head;
        for (int i = 0; i < position - 1; i++)
            prev = prev.next;
        newNode.next = prev.next;
        prev.next = newNode;
    }
    
    public void insertAtEnd(Node newNode) {
        if (isEmpty())
            head = newNode;
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    public void deleteAtBegin() {
        Node temp = head;
        head = head.next;
        temp = null;
        System.gc();
    }
    
    public void deleteAtPosition(int position) {
        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        Node temp2 = temp.next;
        temp.next = temp.next.next;
        temp2 = null;
        System.gc();
    }

    public void deleteAtEnd() {
        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        temp.next = null;
        System.gc();
    }
    
    public Node get(int x) {
        try {
            Node temp = head;
            for (int i = 0; i < x; i++) {
                temp = temp.next;
            }
            return temp;
        } catch (NullPointerException ex) {
            return null;
        }       
    }
    
    public int length() {
        Node temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        return isEmpty() ? 0 : length;
    }

}
