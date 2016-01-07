package cn.edu.graph;

/**
 * @Description:
 * @Author:Hey
 * @Date:2016/1/4
 */
public class Queue<AnyType> {
    private Link front;
    private Link fear;
    int size = 0;

    /**
     * 入队，由于是使用单向链表实现，所以在队尾入队，在队首插队
     *
     * @param value
     */
    public void enQueue(AnyType value) {

        Link link = new Link(value);
        if (isEmpty()) {
            front = link;
        } else
            fear.next = link;
        size++;
        fear = link;
    }

    public AnyType deQueue() {

        Link temp = front;
        //System.out.println(front.next);
        if (front.next == null)
            fear = null;

        front = front.next;

        return (AnyType) temp.value;
    }

    public AnyType peek() {
        return (AnyType) front.value;
    }

    public boolean isEmpty() {
        return fear == null ? true : false;
    }

    private class Link<AnyType> {
        protected AnyType value;

        protected Link next;

        public Link(AnyType value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Link{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enQueue(10);
        queue.enQueue(144);
        queue.enQueue(105);
        queue.enQueue(14);
        queue.enQueue(12);

        int i = 0;

        while (!queue.isEmpty()) {
            i++;
            System.out.println(queue.deQueue());
        }
        System.out.println(queue.size);
        System.out.println(i);

    }

}
