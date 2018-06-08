package ArbolesBinarios;

public class Complete {

    public Node recovery_subtree() {
        return null;
    }

    public String in_pre2post(String preorder, String inorder) {
        BinaryTree recovery = recovery_subtree_inpre(inorder, preorder);
        recovery.posorder_print(recovery.root);
        return null;
    }

    public BinaryTree recovery_subtree_inpre(String sub_inorder, String preorder) {

        if (sub_inorder.length() == 0) {
            return new BinaryTree();
        } else {
            BinaryTree temp = new BinaryTree();
            if (sub_inorder.length() == 1) {
                temp.root = new Node(sub_inorder);
            } else {
                int[] indexes = new int[sub_inorder.length()];
                for (int i = 0; i < indexes.length; i++) {
                    indexes[i] = preorder.indexOf(sub_inorder.substring(i, i + 1));
                }

                int less = Integer.MAX_VALUE, index = -1;
                for (int i = 0; i < indexes.length; i++) {
                    if (indexes[i] < less) {
                        index = i;
                        less = indexes[i];
                    }
                }
                temp.root = new Node(sub_inorder.substring(index, index + 1));
                temp.root.left = recovery_subtree_inpre(sub_inorder.substring(0, index), preorder).root;
                temp.root.right = recovery_subtree_inpre(sub_inorder.substring(index + 1), preorder).root;

            }
            return temp;
        }

    }

    public static void main(String[] args) {
        Complete com = new Complete();
        BinaryTree a = com.recovery_subtree_inpre("DBACEFG", "ABCDEFG");
        a.posorder_print(a.root);
    }
}
