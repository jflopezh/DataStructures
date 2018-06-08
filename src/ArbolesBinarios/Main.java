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
public class Main {
    
    Node root = null;
    
    public Main() {}
    
    public void insert(char value)
    {
        Node node = new Node(value);
        
        if (root == null) 
            root = node;
        else
        {
            Node temp = root;
            Node parent = null;
            boolean left = false;
            
            while (temp != null)
            {
                parent = temp;
                if(value < temp.value)
                {
                    temp = temp.left;
                    left = true;
                }
                else
                {
                    temp = temp.right;
                    left = false;
                }
            }
            temp = node;
            if (left)
                parent.left = temp;                
            else
                parent.right = temp;
        }
    }
    
    public Node search(int value)
    {
        Node temp = root;
        while(temp!=null)
        {
            if(temp.value==value)
                return temp;
            else
                if(value < temp.value)
                    temp = temp.left;
                else
                    temp = temp.right;
        }
        return null;
    }
    
    public void preorder_print(Node node)
    {
        if(node != null)
        {
        System.out.print(node.toString());
        preorder_print(node.left);
        preorder_print(node.right);
        }
    }
    
    public void posorder_print(Node node)
    {
        if(node != null)
        {
        posorder_print(node.left);
        posorder_print(node.right);
        System.out.print(node.toString());
        }
    }
    
    public void inorder_print(Node node)
    {
        if(node != null)
        {
        inorder_print(node.left);
        System.out.print(node.toString());
        inorder_print(node.right);
        }
    }
    
    public static void main(String[] args) 
    {
        Main bt = new Main();    
        bt.insert('D');
        bt.insert('B');
        bt.insert('A');
        bt.insert('C');
        bt.insert('E');
        bt.insert('G');
        bt.insert('F');
        
        bt.preorder_print(bt.root);
        System.out.println("");
        bt.inorder_print(bt.root);
        System.out.println("");
        
    }
    
}
