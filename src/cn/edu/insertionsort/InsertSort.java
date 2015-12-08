package cn.edu.insertionsort;

import java.util.Arrays;

/**
 * Description:插入排序
 * Author: Hey
 * Date: 2015/12/7
 */
public class InsertSort {

    public static void main(String[]args){
        int[] data = {11, 66, 33, 44, 77, 55};

        int i;
       // int j;

        for(i=1;i<data.length;i++){
            /*int temp=data[i];
            for(j=i-1;j>0;j--){
                if(data[i]<data[j]){
                    if(data[j]>data[i]);
                    data[i]=data[j];
                    data[j]=temp;
                }else{
                    break;
                }
            }*/


            if(data[i-1]>data[i]){
                int temp=data[i];
                int j=i;
                while(j>0&&data[i]<data[j-1]){
                    data[j]=data[j-1];
                    j--;
                }
                data[j]=temp;
            }

        }
    System.out.print(Arrays.toString(data));
    }

}
