package cn.edu.heapsort;

import java.util.Arrays;

/**
 * Description:������
 * Author: Hey
 * Date: 2015/12/7
 */
public class HeapSort {

    private Node[] nodes;
    private int elms;

    public HeapSort(int size) {
        elms = 0;
        this.nodes = new Node[size];
    }

    public boolean insert(int value) {
        if (elms >= value)
            return false;
        Node node = new Node(value);
        nodes[elms] = node;
        trickUp(elms++);

        return true;
    }

    public Node remove() {
        Node temp = nodes[0];
        nodes[0] = nodes[--elms];
        trickDown(0);
        return temp;
    }

    private void trickUp(int index) {

        int parent = (index - 1) / 2;
        Node temp = nodes[index];
        while (index > 0 && nodes[parent].value < temp.value) {
            nodes[index] = nodes[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        nodes[index] = temp;
    }

    private void trickDown(int index) {

        Node temp = nodes[0];
        int largeChild = 0;

        while (index < elms / 2) {
            largeChild = maxNode(index);
            if (temp.value > nodes[largeChild].value)
                break;
            else {
                nodes[index] = nodes[largeChild];
                index = largeChild;
            }
        }
        nodes[index] = temp;
    }

    public static void main(String[] args) {

        HeapSort heap = new HeapSort(10);
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(25);
        heap.insert(15);
        heap.insert(5);
        heap.insert(3);
        System.out.println(heap.elms);

        heap.print();
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());

    }

    private void print() {
        System.out.println(Arrays.toString(nodes));
    }

    private int maxNode(int parent) {
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;

        if (right < elms && nodes[left].value < nodes[right].value)
            return right;
        else
            return left;
    }

    private class Node {
        public int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "HeapSort{" +
                    "value=" + value +
                    '}';
        }
    }

}
