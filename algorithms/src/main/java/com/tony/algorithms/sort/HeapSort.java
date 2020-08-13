package com.tony.algorithms.sort;

/**
 * Auther: tony
 * Date: 2020/8/13 17:22
 * Description:
 */
public class HeapSort {
    /**
     * 堆排序
     * @param arr 数组
     */
    private static void dumpSort(int[] arr){
        // 循环建立初始堆
        for (int i = arr.length / 2; i >= 0; i--) {
            HeapAdjust(arr, i, arr.length);
        }
        System.out.print("初始堆 : \t");
        printPart(arr, 0, arr.length - 1);

        for (int i = arr.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // 筛选 R[0] 结点，得到i-1个结点的堆
            HeapAdjust(arr, 0, i);

            System.out.format("第 %d 趟: \t", arr.length - i);
            printPart(arr, 0, arr.length - 1);
        }

    }

    /**
     * 打印
     * @param list 数组
     * @param begin 开始角标
     * @param end 结束角标
     */
    private static void printPart(int[] list, int begin, int end) {
        for (int i = 0; i < begin; i++) {
            System.out.print("\t");
        }
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
    }


    /**
     * 循环建立初始小根堆
     * @param array 数组
     * @param parent 父节点
     * @param length 数组长度
     */
    private static void HeapAdjust(int[] array, int parent, int length) {
        int temp = array[parent]; // temp保存当前父节点
        int child = 2 * parent + 1; // 先获得左孩子
        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值小于左孩子结点，则选取右孩子结点
            if (child + 1 < length && array[child] > array[child + 1]) {
                child ++;
            }
            // 如果父结点的值已经小于孩子结点的值，则直接结束
            if (temp <= array[child])
                break;
            // 否则把孩子结点的值赋给父结点
            array[parent] = array[child];
            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }
        array[parent] = temp;
    }


}
