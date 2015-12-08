package cn.edu.selectionsort;

import java.util.Arrays;

/**
 * Description:选择排序
 * Author: Hey
 * Date: 2015/12/7
 */
public class SelectionSort {

    public static void main(String [] args){
        int[] data = {11, 66, 33, 44, 77, 55};

        int minData=0;
        for(int i=0;i<data.length;i++){
            minData=data[i];
            for(int j=i+1;j<data.length;j++){
                if(data[j]<minData){
                    data[j]=data[j]^minData;
                    minData=minData^data[j];
                    data[j]=data[j]^minData;
                }
                data[i]=minData;
            }
        }
        System.out.print(Arrays.toString(data));
    }
}
