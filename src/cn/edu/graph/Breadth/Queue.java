package cn.edu.graph.Breadth;

/**
 * Description:循环队列
 * Author: Hey
 * Date: 2015/12/12
 */
public class Queue {

    private int[] vertexs;
    private int front;
    private int fear;
    private int maxSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        vertexs = new int[maxSize];
        front = 0;
        fear = 0;
    }

    public void enQueue(int value) {
        if(isFull())
            return;
        vertexs[(fear++% maxSize)] = value;
    }

    public int deQueue() {
        if (isEmpty())
            return -1;
        return vertexs[front++];
    }

    public int peek(){
        if(isEmpty())
            return -1;
        return vertexs[front];
    }

    /**
     * 队列是否
     * @return
     */
    public boolean isFull(){
        //System.out.println(fear);
        return ((fear+1)%maxSize==front);
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return (front == fear);
    }

    public void print() {
        while (!isEmpty())
            System.out.println(deQueue());
    }

}
