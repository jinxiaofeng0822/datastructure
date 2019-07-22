package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Jin Xiaofeng
 */
public class BST extends ListTree<Integer>{

    public BST(ArrayList<Integer> data) {
        super(data);
        if(!checkBST()){
            throw new IllegalArgumentException("当前该树不是二叉搜索树");
        }
    }

    private boolean checkBST(){
        if (val!=null) {
            Stack<ListTree> stackTree = new Stack<>();
            Stack<Integer> stackVal = new Stack<>();
            ListTree<Integer> t = this;
            while (t!=null||!stackTree.isEmpty()){
                while (t!=null) {
                    stackTree.push(t);
                    //一直向左，并将沿途节点压入堆栈
                    t=t.left;
                }

                if (!stackTree.isEmpty()) {
                    t=stackTree.pop();//节点弹出堆栈
                    stackVal.push(t.val);
                    if(t.right!=null){
                        t=t.right;
                    }else{
                        t=null;
                    }
                }
            }

            int lastInt=stackVal.pop();
            while (!stackVal.isEmpty()){
                int now = stackVal.pop();
                if (lastInt > now) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * 二叉查找树
     * @param x 需要查找的树
     * @return 找到返回x，没找到返回null
     */
    public Integer find(int x){
        return interFind(this,x);
    }
    private Integer interFind(ListTree<Integer> bst,int x){
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

    public static void main(String[] args) {
        ArrayList<Integer> data=new ArrayList<>();
        data.add(50);
        data.add(40);
        data.add(60);
        data.add(35);
        data.add(41);
        data.add(55);
        data.add(61);
        data.add(34);
        data.add(36);
        BST bst=new BST(data);
        bst.preOrderTraversal();
        bst.inOrderTraversal();
        bst.postOrderTraversal();
    }
}
