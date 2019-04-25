package list;

/**
 * 数组实现栈
 * @author Jin Xiaofeng
 */
public class ArrayStack<E> implements Stack<E>{

    //堆栈存储的数据
    private Object[] data;
    //栈顶位置
    private int top;
    //堆栈大小
    private int maxSize;

    public ArrayStack(int size){
        data = new Object[size];
        maxSize=size;
        top=-1;
    }

    public boolean push(E e) {
        if (top == maxSize - 1) {
            System.out.println("栈满了！！！");
            return false;
        }else{
            data[++top]=e;
            return true;
        }
    }

    public E pop() {
        if(top==-1){
            System.out.println("栈空的！！！");
            return null;
        }else{
            return (E)data[top--];
        }
    }

    @Override
    public boolean isEmpty() {
        return top==-1;
    }

    public static void main(String[] args) {
        ArrayStack<String> as = new ArrayStack<>(5);
        as.push("1");
        as.push("2");
        as.push("3");
        as.push("4");
        as.push("5");
        as.push("6");
        as.pop();
        as.pop();
        as.pop();
        as.push("aa");
        as.push("bb");
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
    }
}
