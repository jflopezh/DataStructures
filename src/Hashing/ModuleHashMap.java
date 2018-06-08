package Hashing;

import EstructurasLineales.List;
import EstructurasLineales.NodeInt;

public class ModuleHashMap {
    private final int divider;
    public List[] modules;

    public ModuleHashMap(int divider) {
        this.divider = divider;
        this.modules = new List[divider];
        for (int i = 0; i < divider; i++) {
            modules[i] = new List();
        }
    }
    
    public void printModuleHashMap() {
        for (int i = 0; i < divider; i++) {
            System.out.print("Module " + i + ":");
            for (int j = 0; j < modules[i].length(); j++)
                System.out.print(" " + ((NodeInt) modules[i].get(j)).value);
            System.out.print("\n");
        }
    }
    
    public void insert(int x) {
        modules[x % divider].insertAtEnd(new NodeInt(x));
    }
    
    public int search(int x) {
        int i = x % divider;
        for (int j = 0; j < modules[i].length(); j++)
            if (((NodeInt) modules[i].get(j)).value == x)
                return i;
        return -1;
    }
    
    public void remove(int x) {
        int i = x % divider;
        for (int j = 0; j < modules[i].length(); j++)
            if (((NodeInt) modules[i].get(j)).value == x)
                modules[i].deleteAtPosition(j);
    }
    
    public static void main(String[] args) {
        ModuleHashMap mhm = new ModuleHashMap(7);
        
        mhm.insert(4);
        mhm.insert(25);
        mhm.insert(81);
        mhm.insert(126);
        mhm.insert(24);
        mhm.insert(83);
        mhm.insert(39);
        
        mhm.printModuleHashMap();
        
        mhm.remove(126);
        mhm.remove(25);
        
        mhm.printModuleHashMap();
        
        System.out.println("Numero 81 encontrado en el indice " + mhm.search(81));
    }
}
