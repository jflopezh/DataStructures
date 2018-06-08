package Strings;

import EstructurasLineales.Node;

public class StringNode extends Node {

    char character;
    Node next = null;

    public StringNode(char character) {
        this.character = character;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public Node getNext() {
        return this.next;
    }

    @Override
    public Node clone() {
        StringNode clone = new StringNode(this.character);
        return clone;
    }

    public boolean isEqual(Node node) {
        StringNode temp = (StringNode) node;
        return temp.character == this.character;
    }

    public boolean isLessThan(Node node) {
        StringNode temp = (StringNode) node;
        return (int) this.character < (int) temp.character;
    }
}
