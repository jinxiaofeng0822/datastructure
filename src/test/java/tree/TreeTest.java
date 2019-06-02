package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Jin Xiaofeng
 */
public class TreeTest {

    @Test
    void initTreeTest(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("F");
        arrayList.add("G");
        arrayList.add("I");
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add("E");
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add("H");

        ListTree<String> tree = new ListTree<>(arrayList);
        tree.preOrderTraversal();
        tree.preOrderTraversalByStack();

        tree.inOrderTraversal();
        tree.inOrderTraversalByStack();

        tree.postOrderTraversal();

    }
}
