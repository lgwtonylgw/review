package com.tony.futuretask.linux;

/**
 * Created on 2020/2/3 15:11.
 *
 * @author Tony
 * @description:    重启:reboot     关机:shutdown
 *            -n    显示行号
 *            -i     忽略大小写
 *            -f     强制
 *            -r `  递归
 *            -a    全部
 *            -p    parent
 *            -m   more
 *            -h   大小
 *            -d   指定文件夹
 */
public class LinuxDemo {
    /**
     * 1. useradd 添加用户    -d   指定目录   -g  指定组    passwd tony   指定密码      userdel  用户名   删除用户    -r   home下目录一块删除
     * 2.查询用户信息  ：   id 用户名   id root
     * 3.切换用户：   su - 用户名      su root     退出：exit    logout
     *4.查看当前用户：   whoami
     * 5.增加组：  groupadd   删除组 groupdel  组名   useradd -g  组名  用户名       修改组    usermod -g  组名  用户名
     * 6.用户和组的相关文件：   /etc/passwd   /etc/shadow    /etc/group
     *  7.帮助指令：  man   ex: man ls   查看ls的用法
     *  8.常用指令：      cp:    -r  递归复制     \cp   强制覆盖原文件
     *                    mv:     mv oldFileName   neFileName  重命名
     *                            mv /temp/moveFile    /targetFolger   移动文件
     *                    cat :    -n 显示行号        cat -n /etc/profile  | more    more是分页显示   然后空格键显示下一页   q  退出
     *                    more   /etc/profile       空格键一页  ctrl+F向下滚动一夜   crtl+B向上滚动一页    q  退出
     *                    less    -mN  /etc/profile      q推退出
     *                    > 和 >>  输出重定向和追加
     *                              ll > a.txt   会覆盖a.txt内容
     *                              ls -al >> a.txt    追加到a.txt后面
     *                              cat 文件1 >  文件2
     *                              echo  "内容"  >> a.txt
     *                    cal    日历
     *                    echo   ；输出环境变量   echo $PATH      echo  "hello"
     *                    head:   head文件   默认查看该文件前十行内容      head -n 5 文件   查看前五行内容
     *                    tailf   tail 文件  后几行    -n   后几行   -f   刷新
     *                    ln 软连接     ln -s /root linkToRoot   删除软连接  rm -rf linkToRoot
     *                    find / -name 文件名        find   / -user   用户名
     *                    find /  -size  +20M  按照文件大小来查找  大于20M  +大于  等于   -小于
     *                    locate    先updatedb 然后locate   文件名
     *                    cat hello.txt | grep -n -i yes
     *
     *                    zip/unzip:   压缩指令    -r  递归压缩   -d    解压指定文件夹   zip -r mypackage.zip /home/tony/*
     *                    tar    tar -zcvf a.tar.gz  a.txt b.txt    压缩   tar -zxvf   a.tar.gz    -C   解压到指定目录
     *
     *
     *                    权限：
     *                              chown  用户名 文件名   -R  递归
     *                              chgrp   组名  文件名
     *                              usermod   -g   组名  用户名
     *
     *                              chmod   u=rwx,g=rx,o=x  文件目录
     *                              chmod o+w  文件目录
     *                              chmod o-x  文件目录
     *                              chmod a+r  文件目录     a 是所有用户
     *                              chown -R  newowner:newgroup  文件/文件目录
     * 9.crond  任务调度：    crontab    -e   创建定时任务
     *                       *\1  * * * *   ls -l /etc/ > /tmp/o.txt     每分钟输出到o.txt
     *                       备份数据库：
     *                                先编写一个脚本文件   /home/mytask.sh
     */
}
