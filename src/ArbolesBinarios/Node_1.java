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
public class Node_1 {
    
    char value;
    Node_1 right = null;
    Node_1 left = null;

    public Node_1(char value) {
        this.value = value;
    }
    
    public String toString()
    {
        return this.value + "";
    }
    
    public Node_1 clone()
    {
        return new Node_1(this.value);
    }
}
