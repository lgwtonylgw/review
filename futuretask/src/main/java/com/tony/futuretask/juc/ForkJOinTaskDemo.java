package com.tony.futuretask.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created on 2020/1/28 19:45.
 *
 * @author Tony
 * @description:    分支合并框架
 */
class MyTask extends RecursiveTask<Integer> {
    private static final int ADJUST_INT=10;
    private int start;
    private int end;
    private int result;

    public MyTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end-start<=ADJUST_INT){
            for(int i=start;i<=end;i++){
                result+=i;
            }
        }else{
            int middle=(end+start)/2;
            MyTask myTask1=new MyTask(start,middle);
            MyTask myTask2=new MyTask(middle+1,end);
            myTask1.fork();
            myTask2.fork();
            result= myTask1.join()+myTask2.join();
        }
        return result;
    }
}
public class ForkJOinTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask=new MyTask(1,100);
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask= forkJoinPool.submit(myTask);
        System.out.println(forkJoinTask.get());
        forkJoinPool.shutdown();

    }
}
