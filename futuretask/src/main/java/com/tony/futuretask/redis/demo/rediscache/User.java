package com.tony.futuretask.redis.demo.rediscache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created on 2020/3/1 22:10.
 *
 * @author Tony
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 292623596127111257L;
    private Integer id;
    private String name;
    private Integer age;

}
