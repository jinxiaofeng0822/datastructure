package list;

/**
 * @author Jin Xiaofeng
 */
public class ArrayQueue<E> implements Queue<E>{
    //队列头
    private int front;
    //队列尾
    private int rear;

    //队列当前元素个数
    private int size;

    //最大个数
    private final int maxSize;

    //队列存储的数据
    private Object[] data;

    public ArrayQueue(int size){
        data = new Object[size];
        front=-1;
        rear=-1;
        this.size=0;
        maxSize=size;
    }

    @Override
    public boolean enQueue(E e) {
        if(size<maxSize){
            rear++;
            if(rear>=maxSize){
                rear=0;
            }
            data[rear]=e;
            size++;
            return true;
        }else{
            System.out.println("队列满了");
            return false;
        }

    }

    @Override
    public E deQueue() {
        if(size==0){
            System.out.println("队列空了");
            return null;
        }else{
            size--;
            front++;
            if(front>=maxSize){
                front=0;
            }
            return (E)data[front];
        }
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public static void main(String[] args) {
        ArrayQueue<String> aq = new ArrayQueue<>(5);

        aq.enQueue("a");
        aq.enQueue("b");
        aq.enQueue("c");
        aq.enQueue("d");
        System.out.println(aq.deQueue());
        System.out.println(aq.deQueue());
        aq.enQueue("e");
        aq.enQueue("f");
        aq.enQueue("g");
        System.out.println(aq.deQueue());
        System.out.println(aq.deQueue());
        System.out.println(aq.deQueue());
        System.out.println(aq.deQueue());
        System.out.println(aq.deQueue());
    }
}
