package cn.edu.Huffman;

import java.util.Arrays;

/**
 * @Description:优先队列的堆
 * @Author:Hey
 * @Date:2016/1/2
 */
public class Heap {

    private HuffmanTree[] heap;
    private int theSize;

    public Heap(int size) {
        theSize = 0;
        this.heap = new HuffmanTree[size];
    }

    public boolean insert(char ch, int value) {

        HuffmanTree tree = new HuffmanTree(ch, value);
        return insert(tree);
    }

    public boolean insert(HuffmanTree tree) {
        if (theSize >= heap.length)
            return false;

        heap[theSize] = tree;
        trickUp(theSize++);
        return true;
    }

    public HuffmanTree remove() {

        if (theSize <= 0)
            return null;

        HuffmanTree temp = heap[0];
        heap[0] = heap[--theSize];
        trickDown(0);
        return temp;
    }

    public void trickUp(int index) {
        HuffmanTree temp = heap[index];

        int parent = (index - 1) >> 1;
        while (index > 0 && temp.compareTo(heap[parent]) <= 0) {
            heap[index] = heap[parent];
            index = parent;
            parent = (index - 1) >> 1;
        }
        heap[index] = temp;
    }

    public void trickDown(int index) {
        HuffmanTree temp = heap[index];
        int smallerChild = 0;

        while (index < (theSize >> 1)) {
            smallerChild = minChild(index);
            if (temp.compareTo(heap[smallerChild]) > 0) {
                heap[index] = heap[smallerChild];
                index = smallerChild;
            } else {
                break;
            }
        }
        heap[index] = temp;
    }

    public boolean isEmpty() {
        return theSize == 0 ? true : false;
    }

    public int getTheSize() {
        return theSize;
    }

    public int minChild(int index) {
        int leftChild = (index << 1) + 1;
        int rightChild = (index << 1) + 2;

        return heap[leftChild].compareTo(heap[rightChild]) <= 0 ? leftChild : rightChild;
    }

}
