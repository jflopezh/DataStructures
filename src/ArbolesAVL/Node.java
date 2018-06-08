package ArbolesAVL;


/**
 *
 * @author ADMIN
 */
public class Node {
    
    int value,factor_equilibrio;
    Node left;
    Node right;
    
    
    public Node(int value)
    {
        this.value = value;
        this.factor_equilibrio = 0;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getFactor_equilibrio() {
        return factor_equilibrio;
    }

    public void setFactor_equilibrio(int equilibrio) {
        this.factor_equilibrio = equilibrio;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return " " + value;
    }
    
    
}
