package ArbolesAVL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class main {
    
    public static void main(String[] args)
    {
        AVLTree arbol = new AVLTree();
        arbol.insertar(30);
        arbol.insertar(5);
        arbol.insertar(16);
        arbol.insertar(54);
        arbol.insertar(10);
        arbol.insertar(60);
        arbol.insertar(59);
        arbol.insertar(13);
        arbol.insertar(10);
        arbol.insertar(1);
        arbol.insertar(31);
        arbol.insertar(2);
        
        arbol.inorder(arbol.getRoot());
        
    }
    
}
