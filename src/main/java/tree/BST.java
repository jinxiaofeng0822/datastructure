package tree;

import java.util.ArrayList;

/**
 *
 * @author Jin Xiaofeng
 */
public class BST {
    private Integer val;
    private BST left;
    private BST right;

    public BST(Integer val, BST left, BST right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public BST(ArrayList<Integer> data) {
        if (data == null || data.size() == 0) {
            return;
        }
        if (data.size() == 1) {
            this.val = data.get(0);
            return;
        }

        ArrayList<BST> node = new ArrayList<>();
        node.add(null);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) != null) {
                BST tree = new BST(data.get(i), null, null);
                node.add(tree);
            } else {
                node.add(null);
            }

        }

        int size = node.size();
        for (int i = 1; i < size; i++) {
            BST tree = node.get(i);
            if (tree != null) {
                if (2 * i < size) {
                    tree.left = node.get(2 * i);
                }
                if (2 * i + 1 < size) {
                    tree.right = node.get(2 * i + 1);
                }
            }
        }

        this.val = node.get(1).getVal();
        this.left = node.get(1).left;
        this.right = node.get(1).right;
    }

    public Integer getVal() {
        return val;
    }

    public BST getLeft() {
        return left;
    }

    public BST getRight() {
        return right;
    }

    /**
     * 二叉查找树
     * @param x 需要查找的树
     * @return 找到返回x，没找到返回null
     */
    public Integer find(int x){
        return interFind(this,x);
    }
    private Integer interFind(BST bst,int x){
        while (bst != null) {
            if(x>bst.getVal()){
                return interFind(bst.right,x);
            }else if(x<bst.getVal()){
                return interFind(bst.left,x);
            }else{
                return x;
            }
        }
        return null;
    }
}
