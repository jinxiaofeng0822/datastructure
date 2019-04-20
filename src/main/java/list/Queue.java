package list;

/**
 * @author Jin Xiaofeng
 */
public interface Queue<E> {
    /**
     * 入队
     * @return true入队成功
     */
    boolean enQueue(E e);

    /**
     * 出队
     * @return 出队的元素
     */
    E deQueue();

    /**
     * 队列是否为空
     * @return true为空
     */
    boolean isEmpty();
}
