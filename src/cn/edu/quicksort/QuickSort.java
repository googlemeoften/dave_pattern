package cn.edu.quicksort;

import java.util.Arrays;

/**
 * Description:øÏÀŸ≈≈–Ú
 * Author: Hey
 * Date: 2015/12/7
 */
public class QuickSort {

    int[] data = {11, 66, 33, 44, 77, 55};

    public void quickSort(int left, int right) {
        if ((right - left) <= 0)
            return;
        else {
            int pivot = data[right];

            int parttion=recQuickSort(left,right,pivot);
            quickSort(left, parttion-1);
            quickSort(parttion + 1, right);
        }
    }

    public int recQuickSort(int left, int right, int pivot) {
        int leftPtr=left-1;
        int rightPtr=right;
        while (true) {
            while (data[++leftPtr] < pivot) ;
            while (data[--rightPtr] > pivot) ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right);
        return leftPtr;
    }

    public void swap(int i, int j) {
        data[i] = data[i] ^ data[j];
        data[j] = data[j] ^ data[i];
        data[i] = data[i] ^ data[j];
    }

    public static void main(String[] args) {
        QuickSort  q=new QuickSort();

        q.quickSort(0,q.data.length-1);

        System.out.print(Arrays.toString(q.data));
    }
}
