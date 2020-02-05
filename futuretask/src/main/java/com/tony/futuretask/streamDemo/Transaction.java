package com.tony.futuretask.streamDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2020/1/29 13:40.
 *
 * @author Tony
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Trader trader;
    private int year;
    private int value;
}
