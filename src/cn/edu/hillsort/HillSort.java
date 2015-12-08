package cn.edu.hillsort;

import java.util.Arrays;

/**
 * Description:希尔排序,希尔排序的之间的间隔是使用3h+1（运行个数）来定义的。
 * h代表间隔(由于排序算法是基于插入算法的，当数组大小至少为3时，插入排序才比较有效)
 * Author: Hey
 * Date: 2015/12/7
 */
public class HillSort {

    public static void main(String[]args){
        int[] data = {11, 66, 33, 44, 77, 55};

        //计算间隔
        int length=data.length;
        int h=1;
        while(h<=length/3)
            h=3*h+1;

        while(h>0){
            for(int i=h;i<length;i++){
                int temp=data[i];
                int j=i;
                while(j>h-1&&data[j-h]>temp){
                    data[j]=data[j-h];
                    j-=h;
                }
                data[j]=temp;
            }
            h=(h-1)/3;
        }

        System.out.print(Arrays.toString(data));
    }

}
