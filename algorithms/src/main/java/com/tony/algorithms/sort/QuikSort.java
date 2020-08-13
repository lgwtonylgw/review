package com.tony.algorithms.sort;

import java.util.Arrays;

/**
 * Auther: tony
 * Date: 2020/8/13 17:22
 * Description:
 */
public class QuikSort {
    public static void main(String[] args) {
        int[] arr = {14, 3, 8, 54, 11, 56, 2, 70, 71, 72,0,1};
        System.out.println("排序前: " + Arrays.toString(arr));
        quickSortMain(arr);//快速排序
        System.out.println("排序后: " + Arrays.toString(arr));
    }

    /**
     * 快速排序
     * @param arr 数组
     */
    private static void quickSortMain(int[] arr) {
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 1, arr.length);
        quickSort(newArr, 1, newArr.length-1);
        System.arraycopy(newArr, 1, arr, 0, arr.length);
    }

    /**
     * 快速排序
     * @param newArr 临时数组(带哨兵,开始角标是哨兵)
     * @param low 原数组开始指针(即临时数组1下标)
     * @param high 数组做右侧指针
     */
    private static void quickSort(int[] newArr, int low, int high) {
        int pivotal;
        if (low < high) {
            pivotal = getPivotal(newArr, low, high);
            quickSort(newArr, low, pivotal - 1);
            quickSort(newArr, pivotal + 1, high);
        }
    }

    /**
     * 寻找中心点位置
     * @param newArr 临时数组(带哨兵,开始角标是哨兵)
     * @param low 原数组开始指针(即临时数组1下标)
     * @param high 数组做右侧指针
     * @return int
     */
    private static int getPivotal(int[] newArr, int low, int high) {
        newArr[0] = newArr[low];//将第一个元素赋值给哨兵
        int pivotalValue = newArr[low];//去第一个元素为中间点
        //如果最前面位置小于最后面位置时进入循环
        while (low < high) {
            //当最高位大于等于中间点时
            while (low < high && newArr[high] >= pivotalValue) {
                //最高位--,继续比较
                --high;
            }
            //当最高位小于中间点时将最高位赋值给最低位(最低位已存入哨兵)
            newArr[low] = newArr[high];
            //当最低位小于等于中间点时
            while (low < high && newArr[low] <= pivotalValue) {
                //最低位++,继续循环
                ++low;
            }
            //当最低位大于中间点时将最低位复制给最高位(最高位在上边已赋值给最低位) 然后继续循环,知道最高位和最低位重合
            newArr[high] = newArr[low];
        }
        //最后将中间点赋值给最低位或者最高位
        newArr[high] = newArr[0];
        return high;
    }

}
