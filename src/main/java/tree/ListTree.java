package tree;

import list.ListQueue;

import java.util.*;

/**
 * @author Jin Xiaofeng
 */
public class ListTree<T> {
    protected T val;
    protected ListTree left;
    protected ListTree right;

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

    public void preOrderTraversalByStack(){
        Stack<ListTree> stack = new Stack<>();
        ListTree<T> t = this;
        while (t!=null||!stack.isEmpty()){
            while (t!=null) {
                System.out.print(t.val);//访问
                System.out.print(",");
                stack.push(t);
                //一直向左，并将沿途节点压入堆栈
                t=t.left;
            }

            if (!stack.isEmpty()) {
                t=stack.pop();//节点弹出堆栈
                if(t.right!=null){
                    t=t.right;
                }else{
                    t=null;
                }
            }
        }
        System.out.println();
    }

    public void inOrderTraversalByStack(){
        Stack<ListTree> stack = new Stack<>();
        ListTree<T> t = this;
        while (t!=null||!stack.isEmpty()){
            while (t!=null) {
                stack.push(t);
                //一直向左，并将沿途节点压入堆栈
                t=t.left;
            }

            if (!stack.isEmpty()) {
                t=stack.pop();//节点弹出堆栈
                System.out.print(t.val);//访问
                System.out.print(",");
                if(t.right!=null){
                    t=t.right;
                }else{
                    t=null;
                }
            }
        }
        System.out.println();
    }

    public void levelOrderTraversal(){
        ListQueue<ListTree> queue = new ListQueue<>();
        ListTree<T> t;
        queue.push(this);
        while (!queue.isEmpty()){
            t=queue.pop();
            System.out.print(t.val);
            System.out.print(",");

            if(t.left!=null){
                queue.push(t.left);
            }
            if(t.right!=null){
                queue.push(t.right);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<String> ll=new LinkedList<>();
    }

}
