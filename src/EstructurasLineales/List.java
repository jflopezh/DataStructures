package EstructurasLineales;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class List {

    public Node head = null;

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
        if (isEmpty() || position > this.length() - 1) {
            return;
        } else if (this.length() == 1)
            head = null;
        else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            Node temp2 = temp.next;
            temp.next = temp.next.next;
            temp2 = null;
            System.gc();
        }
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
    
    public List cloneList() {
        List clone = new List();
        clone.head = head.clone();
        Node temp = clone.head;
        while (temp != null) {
            temp.next = temp.next.clone();
            temp = temp.next;
        }
        return clone;
    }
    
    public List reverse() {
        List reverse = new List();
        Node temp = head;
        while (temp != null) {
            reverse.insertAtBegin(temp.clone());
            temp = temp.next;
        }
        return reverse;
    }
    
    public Node binarySearch(int id) {
        int lowerBound = 0, upperBound = length() - 1, index = -1, middlePoint;
        
        while (lowerBound < upperBound) {
            middlePoint = (upperBound + lowerBound) / 2;
            if (id == ((NodeInt) get(middlePoint)).value) {
                index = middlePoint;
                break;
            } else if (id < ((NodeInt) get(middlePoint)).value)
                upperBound = middlePoint - 1;
            else
                lowerBound = middlePoint + 1;
        }
        
        if (lowerBound == upperBound && ((NodeInt) get(lowerBound)).value == id)
            index = lowerBound;
        
        return get(index);
    }
    
    public Node binarySearchRecursive(int id, int lB, int uB) {
        int middlePoint = (lB + uB) / 2;
        int tempId = ((NodeInt) get(middlePoint)).value;
        if (lB == uB)
            if (id == tempId)
                return get(middlePoint);
            else
                return null;
        else
            if (id == tempId)
                return get(middlePoint);
            else
                if (id < tempId)
                    return binarySearchRecursive(id, lB, middlePoint - 1);
                else
                    return binarySearchRecursive(id, middlePoint + 1, uB);
    }
    
    public List quickSort(List unsorted) {
        if (unsorted.length() <= 1) {
            return unsorted;
        } else {
            Node pivot = unsorted.head;
            List lessSubArray = new List();
            List greaterSubArray = new List();
            Node temp = unsorted.head.next;
            
            while (temp != null) {
                if (((NodeInt) temp).value < ((NodeInt) pivot).value)
                    lessSubArray.insertAtEnd(temp.clone());
                else
                    greaterSubArray.insertAtEnd(temp.clone());
                
                temp = temp.next;
            }
            
            lessSubArray = quickSort(lessSubArray);
            greaterSubArray = quickSort(greaterSubArray);
            
            lessSubArray.insertAtEnd(pivot.clone());
            lessSubArray.insertAtEnd(greaterSubArray.head);
            
            return lessSubArray;
        }
    }

    public int indexOf(NodeInt node) {
        if (isEmpty()) {
            return -1;
        } else {
            Node temp = head;
            int pos = 0;
            while (temp.next != null) {
                if (((NodeInt) temp).value == node.value) return pos; else pos ++;
                temp = temp.next;
            }
            return -1;
        }
    }
    
    public List sublist(int beginIndex, int endIndex) {
        if (endIndex > length() - 1 && beginIndex < 0) {
            return null;
        }
        List sublist = new List();
        Node temp = this.get(beginIndex);
        for (int i = 0; i < endIndex - beginIndex; i++) {
            sublist.insertAtEnd(temp);
            temp = temp.next;
        }
        return sublist;
    }
    
    public List sublist(int beginIndex) {
        if (beginIndex < 0) {
            return null;
        }
        List sublist = new List();
        Node temp = this.get(beginIndex);
        while (temp != null) {
            sublist.insertAtEnd(temp);
            temp = temp.next;
        }
        return sublist;
    }
}
