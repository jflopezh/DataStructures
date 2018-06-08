package BioInformatica;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class List {

    Sequence head = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Sequence temp = head;

        try {
            bw.write("Secuencias: \n\n");
            while (temp != null) {
                bw.write(temp.toString() + "\n");
                temp = temp.next;
            }
            bw.flush();
        } catch (IOException e) {}
    }

    public void insertAtBegin(Sequence newSequence) {
        newSequence.next = head;
        head = newSequence;
    }

    public void insertAtPosition(Sequence newSequence, int position) {
        Sequence prev = head;
        for (int i = 0; i < position - 1; i++)
            prev = prev.next;
        newSequence.next = prev.next;
        prev.next = newSequence;
    }
    
    public void insertAtEnd(Sequence newSequence) {
        if (isEmpty())
            head = newSequence;
        else {
            Sequence temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newSequence;
        }
    }

    public void deleteAtBegin() {
        Sequence temp = head;
        head = head.next;
        temp = null;
        System.gc();
    }
    
    public void deleteAtPosition(int position) {
        Sequence temp = head;
        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }
        Sequence temp2 = temp.next;
        temp.next = temp.next.next;
        temp2 = null;
        System.gc();
    }

    public void deleteAtEnd() {
        Sequence temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        temp.next = null;
        System.gc();
    }

}
