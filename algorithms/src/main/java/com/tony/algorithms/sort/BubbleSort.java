package com.tony.algorithms.sort;

/**
 * Auther: tony
 * Date: 2020/8/13 17:14
 * Description:
 */
public class BubbleSort {
    public static void main(String[] args) {

    }
    /**
     * 冒泡排序
     * @param arr 数组
     */
    private static void bubbleSort(int[] arr) {
        int m, n, temp;

        n = arr.length;//n=6  m = 5
        int compareCount = 0;//改进[如果中途已经排序完成,直接跳出] 记录比较次数
        int swapCount = 0;//改进[如果中途已经排序完成,直接跳出] 记录交换次数
        for (m = 1; m <= n - 1; m++) { //比较趟数为 n-1
            boolean flag = false;//改进[如果中途已经排序完成,直接跳出] 是否排序完成标识
            for (int j = 0; j < n - m; j++) {//每趟比较次数为 n-m 次
                swapCount++;
                if (arr[j] > arr[j + 1]) {
                    flag = true; //改进 如果arr[j] 总是小于 arr[j + 1] 这行就不会走到
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    compareCount++;
                }
            }
            if (!flag) { //改进 falg==false (即没有数据交换了) 就跳出循环
                break;
            }
        }
        System.out.println("交换次数：" + compareCount);
        System.out.println("比较次数：" + swapCount);
    }

}
