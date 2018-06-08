/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolesBinarios;

/**
 *
 * @author Estudiante
 */
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
    
    public String toString()
    {
        return "Value: " + this.value + "\n";
    }
    public String toString_letter()
    {
        return "Value: " + this.letter + "\n";
    }
    
    public Node clone()
    {
        return new Node(this.value);
    }
}
