package com.tony.algorithms.sort;

/**
 * Auther: tony
 * Date: 2020/8/13 17:19
 * Description:
 */
public class InsertionSort {
    public static void main(String[] args) {

    }
    /**
     * 直接插入排序
     * @param arr
     */
    private static void directInsertSort(int[] arr) {
        //遍历数组,从角标为1开始遍历带插入元素
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];//将带插入元素赋值给临时变量temp
            int j;//定义比较元素,比较元素从i-1,每次和
            //循环,j>=0 并且j对应元素笔i对应元素大,那么将较大元素后移,
            for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;//将temp插入正确位置
        }
    }

}
