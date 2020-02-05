package com.tony.futuretask.streamDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2020/1/29 11:54.
 *
 * @author Tony
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employe {
    private String name;
    private int age;
    private double salary;
    private String status;

    public Employe(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
