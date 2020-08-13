package com.tony.algorithms.sort;

import java.util.Arrays;

/**
 * Auther: tony
 * Date: 2020/8/13 17:21
 * Description:
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 9, 3, 5, 7, 0};
        System.out.println("排序前:" + Arrays.toString(arr));
        sort(arr);//归并排序
        System.out.println("排序后:" + Arrays.toString(arr));
    }

    /**
     * 归并排序
     * @param arr 数组
     */
    private static void sort(int[] arr) {
        //创建一个和原数组相同大小的临时数组
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    /**
     * 递归排序
     * @param arr 数组
     * @param left 开始指针
     * @param right 结束指针
     * @param temp 临时数组
     */
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            //取中间值
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);//左边
            mergeSort(arr, mid + 1, right, temp);//右边
            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并
     * @param arr 数组
     * @param left 左序列开始指针
     * @param mid 中间指针
     * @param right 右序列结束指针
     * @param temp 临时数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //左序列开始指针
        int i = left;
        //右序列开始指针
        int j = mid + 1;
        //临时指针
        int k = 0;
        //如果左序列开始指针不大于中间指针(也就是左序列最右边指针)
        //并且
        //右序列开始指针不大于右侧指针(也就是数组最后一个元素指针)时
        while (i <= mid && j <= right) {
            //如果左边开始指针元素小于右边
            if (arr[i]<arr[j]){
                //将左变指针元素赋值给临时数组最开始位置
                //然后把临时数组角标和左序列开始指针右移
                temp[k++] = arr[i++];
            }else{
                //否则将右序列指针元素赋值给临时数组最开始位置
                //然后把临时数组角标和右序列开始指针右移
                temp[k++] = arr[j++];
            }
        }
        while (i<=mid){//如果右序列没有值的话,将左序列全部一道临时数组中
            temp[k++] = arr[i++];
        }
        while (j<=right){//如果左序列没有值得话,将右序列全部移到临时数组中
            temp[k++] = arr[j++];
        }
        //将k置零,用来把临时数组元素拷贝到原数组
        k = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[k++];
        }
    }
}
