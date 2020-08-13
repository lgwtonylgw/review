package com.tony.algorithms.sort;

/**
 * Auther: tony
 * Date: 2020/8/13 17:21
 * Description:
 */
public class ShellSort {
    public static void main(String[] args) {

    }
    /**
     * 希尔排序
     * @param arr 数组
     */
    private static void shellInsertSort(int[] arr) {
        int[] dk = {5, 3, 1};//递减的增量序列
        for (int i = 0; i < dk.length; i++) {
            shellSort(arr, dk[i]);//一趟增量为dk[i]的排序
        }
    }

    /**
     * 一趟增量为dk[i]的排序
     * @param arr
     * @param dk
     */
    private static void shellSort(int[] arr, int dk) {
        //将原数组放到一个带哨兵的数组中
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 1, arr.length);
        //增量为dk的循环
        int i, j;
        for (i = dk + 1; i < newArr.length; i++) {
            //对比相邻两个增量对应元素的大小
            if (newArr[i] < newArr[i - dk]) {
                //前一个增量元素大于后一个,那么记录后一个增量元素到哨兵
                newArr[0] = newArr[i];
                //循环遍历每个增量位置,并和哨兵比较,如果大于哨兵,那么将增量后移以此类推
                for (j = i - dk; j > 0 && newArr[0] < newArr[j]; j = j - dk) {
                    newArr[j+dk] = newArr[j];
                }
                //最后酱烧饼赋值给当前增量
                newArr[j+dk] = newArr[0];
            }
        }
        System.arraycopy(newArr, 1, arr, 0, arr.length);
    }


}
