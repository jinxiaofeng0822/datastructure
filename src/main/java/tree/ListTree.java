package tree;

import java.util.ArrayList;

/**
 * @author Jin Xiaofeng
 */
public class ListTree<T> {
    private T val;
    private ListTree left;
    private ListTree right;

    public ListTree(T val, ListTree left, ListTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public ListTree(ArrayList<T> data) {
        if (data == null || data.size() == 0) {
            return;
        }
        if (data.size() == 1) {
            this.val = data.get(0);
            return;
        }

        ArrayList<ListTree> node = new ArrayList<>();
        node.add(null);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) != null) {
                ListTree<T> tree = new ListTree<>(data.get(i), null, null);
                node.add(tree);
            } else {
                node.add(null);
            }

        }

        int size = node.size();
        for (int i = 1; i < size; i++) {
            ListTree<T> tree = node.get(i);
            if (tree != null) {
                if (2 * i < size) {
                    tree.left = node.get(2 * i);
                }
                if (2 * i + 1 < size) {
                    tree.right = node.get(2 * i + 1);
                }
            }
        }

        this.val = (T) node.get(1).getVal();
        this.left = node.get(1).left;
        this.right = node.get(1).right;
    }

    public T getVal() {
        return val;
    }

    public ListTree getLeft() {
        return left;
    }

    public ListTree getRight() {
        return right;
    }

    /**
     * 前序遍历
     */
    public void preOrderTraversal() {
        preOrderTraversal(this);
        System.out.println();
    }

    /**
     * 前序遍历
     */
    private void preOrderTraversal(ListTree<T> tree) {
        if (tree != null) {
            System.out.print(tree.val);
            System.out.print(",");
            preOrderTraversal(tree.left);
            preOrderTraversal(tree.right);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrderTraversal() {
        inOrderTraversal(this);
        System.out.println();
    }

    /**
     * 中序遍历
     */
    private void inOrderTraversal(ListTree<T> tree) {
        if (tree != null) {
            inOrderTraversal(tree.left);
            System.out.print(tree.val);
            System.out.print(",");
            inOrderTraversal(tree.right);
        }
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal() {
        postOrderTraversal(this);
        System.out.println();
    }

    /**
     * 后序遍历
     */
    private void postOrderTraversal(ListTree<T> tree) {
        if (tree != null) {
            postOrderTraversal(tree.left);
            postOrderTraversal(tree.right);
            System.out.print(tree.val);
            System.out.print(",");
        }
    }

}
