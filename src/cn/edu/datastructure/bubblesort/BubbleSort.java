package cn.edu.datastructure.bubblesort;

import java.util.Arrays;

/**
 * Description:冒泡排序
 * Author: Hey
 * Date: 2015/12/7
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] data = {11, 66, 33, 44, 77, 55};

        for (int i = 0; i < data.length-1; i++) {
            for (int j = data.length - i; j > 0; j--) {
                if (data[i] > data[i + 1]) {
                    data[i] = data[i] ^ data[i + 1];
                    data[i + 1] = data[i + 1] ^ data[i];
                    data[i] = data[i] ^ data[i + 1];
                }
            }
        }
//        for(int i=0;i<data.length;i++){
//        	System.out.println(data[i]);
//        }
        System.out.println(Arrays.toString(data));
    }
}