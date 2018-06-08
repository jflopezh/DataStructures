package EstructurasLineales;

public class NodeInt extends Node{

    public int value;

    public NodeInt(int value){
        this.value = value;
    }
    
    @Override
    public NodeInt clone() {
        return new NodeInt(value);
    }
}
