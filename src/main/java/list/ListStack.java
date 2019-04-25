package list;

/**
 * 单向链表实现栈
 * @author Jin Xiaofeng
 */
public class ListStack<E> implements Stack<E> {
    Node<E> top;

    @Override
    public boolean push(E e) {
        Node<E> newNode = new Node<>(e, top);
        top = newNode;
        return true;
    }

    @Override
    public E pop() {
        if (top == null) {
            return null;
        } else {
            E e = top.item;
            top = top.next;
            return e;
        }
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListStack<String> ls = new ListStack<>();
        System.out.println(ls.isEmpty());
        ls.push("a");
        ls.push("b");
        ls.push("c");
        System.out.println(ls.isEmpty());
        System.out.println(ls.pop());
        System.out.println(ls.pop());
        System.out.println(ls.pop());
        System.out.println(ls.pop());
        System.out.println(ls.isEmpty());
    }
}
