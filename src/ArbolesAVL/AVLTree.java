package ArbolesAVL;


/**
 *
 * @author ADMIN
 */
public class AVLTree 
{
    private Node root;
    
    public AVLTree(){
        root=null;
        
    }
    public Node getRoot(){
        return root;
    }
    
    public Node search(int value, Node node)
    {
       if(root==null)
           return null;
       else if(node.value == value)
           return node; 
       else if(node.value > value)
           return search(value,node.left);
       else
           return search(value,node.right); 
    }
    
    public int getFactor_equilibrio(Node node)
    {
        if(node == null)
            return -1;
        else
        return node.factor_equilibrio;
    }
    
    public Node rotacionIzquierda(Node node)
    {        
        Node newNode = node.left;        
        node.left = newNode.right;
        newNode.right = node;
        
        node.factor_equilibrio = Math.max(getFactor_equilibrio(node.left),getFactor_equilibrio(node.right))+1;
        newNode.factor_equilibrio = Math.max(getFactor_equilibrio(newNode.left), getFactor_equilibrio(newNode.right))+1;
        
        return newNode;
    }
    
    public Node rotacionDerecha(Node node)
    {
        Node newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;
        
        node.factor_equilibrio = Math.max(getFactor_equilibrio(node.left),getFactor_equilibrio(node.right))+1;
        newNode.factor_equilibrio = Math.max(getFactor_equilibrio(newNode.left), getFactor_equilibrio(newNode.right))+1;
        
        return newNode;
    }
    
    public Node rotacionDobleIzquierda(Node node)
    {
        Node newNode;
        
        node.left = rotacionDerecha(node.left);
        newNode = rotacionIzquierda(node);
        
        return newNode;
    }
    
    public Node rotacionDobleDerecha(Node node){
        Node newNode;
        
        node.right = rotacionIzquierda(node.right);
        newNode = rotacionDerecha(node);
        
        return newNode;
    }
    
    public Node insertarAVLTree(Node newNode,Node subAr)
    {
        Node Padre = subAr;
        if(newNode.value < subAr.value)
        {
            if(subAr.left == null)
                subAr.left = newNode;
            else
            {
                subAr.left = insertarAVLTree(newNode,subAr.left);
                if((getFactor_equilibrio(subAr.left) - getFactor_equilibrio(subAr.right) == 2))
                {
                    if(newNode.value < subAr.left.value)
                        Padre = rotacionIzquierda(subAr);
                    else
                        Padre = rotacionDobleIzquierda(subAr);
                }
            }
        }
        else if(newNode.value > subAr.value)
        {
            if(subAr.right == null)
                subAr.right = newNode;
            else
            {
                subAr.right = insertarAVLTree(newNode,subAr.right);
                if((getFactor_equilibrio(subAr.right) - getFactor_equilibrio(subAr.left) == 2))
                {
                    if(newNode.value>subAr.right.value)
                        Padre=rotacionDerecha(subAr);
                    else
                        Padre=rotacionDobleDerecha(subAr);
                }
            }
        }
        else
            System.out.println("El nodo de valor " + newNode + " ya existe");
        
        if((subAr.left == null) && (subAr.right != null))
            subAr.factor_equilibrio = subAr.right.factor_equilibrio + 1;
        else if((subAr.right == null) && (subAr.left != null))
            subAr.factor_equilibrio = subAr.left.factor_equilibrio + 1;
        else
            subAr.factor_equilibrio = Math.max(getFactor_equilibrio(subAr.left),getFactor_equilibrio(subAr.right)) + 1;
        
        return Padre;
    }

    public void insertar(int value)
    {
        Node newNode = new Node(value);
        if(root == null)
            root = newNode;
        else
            root = insertarAVLTree(newNode,root);
    }
    public void preorder(Node node)
	{
		if(node != null)
		{
			System.out.print(node.toString() + ",");
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}
	
	public void postorder(Node node)
	{
		if(node != null)
		{
			postorder(node.getLeft());
			postorder(node.getRight());
			System.out.print(node.toString() + ",");
		}
	}
	
	public void inorder(Node node)
	{
		if(node != null)
		{
			inorder(node.getLeft());
			System.out.print (node.toString() + ",");
			inorder(node.getRight());
		}	
	}
        
}

