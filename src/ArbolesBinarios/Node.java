package ArbolesBinarios;

public class Node {

    int value;
    String letter;
    Node right = null;
    Node left = null;

    public Node(String letter) {
        this.letter = letter;
    }

    public Node(int value) {
        this.value = value;
    }

    public String toString() {
        return "Value: " + this.value + "\n";
    }

    public String toString_letter() {
        return "Value: " + this.letter + "\n";
    }

    public Node clone() {
        return new Node(this.value);
    }
}
