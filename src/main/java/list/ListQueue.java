package list;

/**
 * 单向链表实现队列
 * @author Jin Xiaofeng
 */
public class ListQueue<E> implements Stack<E>{
    private int size=0;
    private Node<E> front;
    private Node<E> rear;

    @Override
    public boolean push(E e) {
        Node<E> node = new Node<>(e,null);
        if (size==0) {
            front=node;
            rear=node;
        }else{
            rear.next=node;
            rear=node;
        }
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (size == 0) {
            System.out.println("队列是空的！！！");
            return null;
        }else{
            Node<E> node = front;
            front=front.next;
            size--;
            return node.item;
        }
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    private static class Node<E>{
        E item;
        Node<E> next;

        Node(E item,Node<E> next){
            this.item=item;
            this.next=next;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new ListQueue<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.pop();
        stack.push("e");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
