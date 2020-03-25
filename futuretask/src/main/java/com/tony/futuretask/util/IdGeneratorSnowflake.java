package com.tony.futuretask.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 2020/3/25 22:30.
 *
 * @author Tony
 * @description:
 */
@Component
public class IdGeneratorSnowflake {
    private long workId=0L;
    private long datacenterId=1L;
    private Snowflake snowflake= IdUtil.createSnowflake(workId,datacenterId);
    @PostConstruct
    public void init(){
        try {
            workId= NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            e.printStackTrace();
            workId=NetUtil.getLocalhostStr().hashCode();
        }

    }
    public synchronized long snowflakeId(){
        return snowflake.nextId();
    }
    public synchronized long snowflakeId(long workId,long datacenterId){
        snowflake=IdUtil.createSnowflake(workId,datacenterId);
        return snowflake.nextId();
    }
}
