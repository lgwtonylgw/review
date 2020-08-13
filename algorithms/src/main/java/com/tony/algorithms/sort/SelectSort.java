package com.tony.algorithms.sort;

/**
 * Auther: tony
 * Date: 2020/8/13 17:18
 * Description:
 */
public class SelectSort {
    public static void main(String[] args) {

    }
    /**
     * 简单选择排序
     * @param arr 数组
     */
    private static void easyChooseSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[k]>arr[j]){
                    k = j;//记录最小值
                }
            }
            if (k != i){//如果有比i元素更小的值时,和i交换位置
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
            }
        }
    }

}
