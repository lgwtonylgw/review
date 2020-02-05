package com.tony.futuretask.streamDemo;

import java.security.PublicKey;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 2020/1/29 11:54.
 *
 * @author Tony
 * @description:
 */
public class demo01 {
    static List<Employe> employes= Arrays.asList(
            new Employe("张三", 18,9999.99),
            new Employe("李四", 38,5555.99),
            new Employe("王五", 50,6666.66),
            new Employe("赵六", 16,3333.33),
            new Employe("田七", 10,7777.77),
            new Employe("田七", 10,7777.77),
            new Employe("啊七", 10,7777.77)
    );
    static List<String> list=Arrays.asList("aaa","bbb","ccc","ddd");
    public static void distinct() {
        employes.stream().distinct().forEach(System.out::println);
    }

    /**
     * map  接受一个lambda   将元素转换成其他形式或提取信息。接受一份函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     * flatmap:   接受一个参函数为一个参数，将流中的每个值都转换成另外一个流，然后把所有流连接成一个流
     * maoToint
     * @param args
     */
    public static void mapDemo(String[] args) {


        list.stream().map(String::toUpperCase).forEach(System.out::println);

        employes.stream().map(Employe::getName).forEach(System.out::println);

        list.stream().flatMap(demo01::filterCharacter).forEach(System.out::println);
    }
    public static Stream<Character> filterCharacter(String str){
        List<Character> liat=new ArrayList<>();
        for(Character c:str.toCharArray()){
            liat.add(c);
        }
        return liat.stream();
    }
    /**
     *    sorted()   自然排序（Comparable)
     *    sorted(Comparator com)   定制排序(Comparator)
     */
    public static void sortedDemo(String[] args) {
        list.stream().sorted().forEach(System.out::println);
        employes.stream().sorted((a,b)->{
            if(a.getAge()==b.getAge()){
                return a.getName().compareTo(b.getName());
            }else{
                return a.getAge()-b.getAge();
            }
        }).forEach(System.out::println);
    }

    /**
     * 终止操作
     * allmatch   检查是否匹配所有元素
     * anyMatch
     * noeMatch
     * findFirst
     * findAny
     * count
     * max
     * min
     */
    public static void maxDemo(String[] args) {
        List<Employe> emps = Arrays.asList(
                new Employe("张三", 18,9999.99, Status.FREE),
                new Employe("李四", 38,5555.99, Status.BUSY),
                new Employe("王五", 50,6666.66, Status.VOCATION),
                new Employe("赵六", 16,3333.33, Status.FREE),
                new Employe("田七", 10,7777.77, Status.BUSY),
                new Employe("李八", 16,8888.88, Status.FREE)
        );
       boolean boolean1 = emps.stream().allMatch(e->e.getStatus().equalsIgnoreCase(Status.FREE));
        System.out.println(boolean1);
        boolean boolean2=emps.stream().anyMatch(e->e.getStatus().equalsIgnoreCase(Status.FREE));
        System.out.println(boolean2);
        boolean boolean3=emps.stream().noneMatch(e->e.getStatus().equalsIgnoreCase(Status.FREE));
        System.out.println(boolean3);
        Optional<Employe> first = emps.stream()
//                .sorted((a,b)->Double.compare(a.getSalary(),b.getSalary()))
                .sorted(Comparator.comparingDouble(Employe::getSalary))
                .findFirst();
        System.out.println(first.get());

        Optional<Employe> any = emps.stream().filter(e -> e.getStatus().equalsIgnoreCase(Status.FREE)).findAny();
        System.out.println(any.get());


        long count = emps.stream().count();
        System.out.println(count);

        Optional<Employe> max = emps.stream().max(Comparator.comparingDouble(Employe::getSalary));
        System.out.println(max.get());

        Optional<Employe> min = emps.stream().min(Comparator.comparingInt(Employe::getAge));
        System.out.println(min.get());

        Optional<Double> min1 = emps.stream().map(Employe::getSalary).min(Double::compareTo);
        System.out.println(min1.get());


    }


    /**
     * 归约与收集
     * reduce  可以将流中的元素反复结合起来，得到一个值         map和reduce连接通常称为map-reduce模式，因为Google用它来进行网络搜索而出名
     *
     * collect    将流转化为其他形式，接受一个Collector接口的实现，用于给Stream中的元素做汇总的方法
     */

    public static void reduce(String[] args) {
        List<Employe> emps = Arrays.asList(
                new Employe("张三", 18,9999.99, Status.FREE),
                new Employe("李四", 38,5555.99, Status.BUSY),
                new Employe("王五", 50,6666.66, Status.VOCATION),
                new Employe("赵六", 16,3333.33, Status.FREE),
                new Employe("田七", 10,7777.77, Status.BUSY),
                new Employe("田七", 16,8888.88, Status.VOCATION)
        );
        List<Integer> listss=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = listss.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Double> reduce = emps.stream().map(Employe::getSalary).reduce(Double::sum);
        System.out.println(reduce.get());

        List<String>  listt=emps.stream().map(Employe::getName).collect(Collectors.toList());
        listt.forEach(x-> System.out.println(x));

        Set<String> set=emps.stream().map(Employe::getName).collect(Collectors.toSet());
        set.forEach(x-> System.out.println(x));

        Double collect = emps.stream().collect(Collectors.averagingDouble(Employe::getSalary));
        System.out.println(collect);

        double sum1 = emps.stream().mapToDouble(Employe::getSalary).sum();
        Double collect1 = emps.stream().collect(Collectors.summingDouble(Employe::getSalary));
        System.out.println(sum1);
        System.out.println(collect1);


    }

    public static void excesize1(String[] args) {
        List<Employe> emps = Arrays.asList(
                new Employe("张三", 18,9999.99, Status.FREE),
                new Employe("李四", 38,5555.99, Status.BUSY),
                new Employe("王五", 50,6666.66, Status.VOCATION),
                new Employe("赵六", 16,3333.33, Status.FREE),
                new Employe("田七", 10,7777.77, Status.BUSY),
                new Employe("田七", 16,8888.88, Status.VOCATION)
        );
        List<Integer> listq=Arrays.asList(1,2,3,4,5);
        List<Integer> collect = listq.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(collect);

        Integer[] ints=new Integer[]{1,2,3,4,5};
        List<Integer> collect1 = Arrays.stream(ints).map(e -> e * e).collect(Collectors.toList());

        Optional<Integer> reduce = emps.stream().map(x -> 1).reduce(Integer::sum);
        Optional<Integer> reduce1 = emps.stream().map(x -> 1).reduce((x, y) -> Integer.sum(x, y));
        Integer reduce2 = emps.stream().map(x -> 1).reduce(0, (x, y) -> x + y);
        System.out.println(reduce.get()+""+reduce1.get()+""+reduce2);


    }

    public static void main(String[] args) {
        /**
         * 1.找出2011年发生的所有交易，并按交易额排序（从高到底）
         * 2.交易员都在哪些不同的城市工作过？
         * 3.查找来自剑桥的交易员，并按姓名排序
         * 4.返回所有交易员的姓名字符串，并按字母顺序排序
         * 5.有没有交易员是在米兰工作的？
         * 6.打印生活在剑桥的交易员的所有交易额
         * 7.所有交易中，最高的交易额是多少？
         * 8.找到交易额最小的交易
         */
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );
        List<Transaction> collect1 = transactions.stream().filter(e -> e.getYear() == 2011).sorted(Comparator.comparingInt(Transaction::getValue)).collect(Collectors.toList());

        List<String> collect = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println(collect);
        List<Trader> collect2 = transactions.stream().filter(e -> "Cambridge".equalsIgnoreCase(e.getTrader().getCity()))
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(collect2);
        boolean milan = transactions.stream().anyMatch(e -> e.getTrader().getCity().equalsIgnoreCase("Milan"));
        System.out.println(milan);
        int sum = transactions.stream().filter(e -> "Cambridge".equalsIgnoreCase(e.getTrader().getCity())).mapToInt(Transaction::getValue).sum();
        System.out.println(sum);
        Optional<Integer> max = transactions.stream().map(Transaction::getValue).max(Integer::compare);
        System.out.println(max.get());

        Optional<Transaction> min = transactions.stream().min(Comparator.comparingInt(Transaction::getValue));
        System.out.println(min.get());

    }

}
