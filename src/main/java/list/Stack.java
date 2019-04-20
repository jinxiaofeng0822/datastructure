package list;

/**
 * @author Jin Xiaofeng
 */
public interface Stack<E> {
    /**
     * 入栈操作
     * @param e 将要入栈的元素
     * @return true成功放入
     */
    boolean push(E e);

    /**
     * 出栈
     * @return 弹出的元素
     */
    E pop();

    /**
     * 栈是否为空
     * @return true空
     */
    boolean isEmpty();
}
