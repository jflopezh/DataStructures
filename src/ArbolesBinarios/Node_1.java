package ArbolesBinarios;

public class Node_1 {

    char value;
    Node_1 right = null;
    Node_1 left = null;

    public Node_1(char value) {
        this.value = value;
    }

    public String toString() {
        return this.value + "";
    }

    public Node_1 clone() {
        return new Node_1(this.value);
    }
}
