package com.tony.futuretask.designpattern;

import java.time.LocalDate;

/**
 * Created on 2020/2/26 17:29.
 *
 * @author Tony
 * @description:
 */
public class LocalTimeDamo {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();

        LocalDate date2 = LocalDate.of(2020,2,26);

        if(date1.equals(date2)){
            System.out.println("时间相等");
        }else{
            System.out.println("时间不等");
        }
    }
}
