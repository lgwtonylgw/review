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
 *            yy p  拷贝一行    dd 删除一行
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
     *                    zip  unzip  .zip文件    gzip  gunzip  .gz文件
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
     *                                /usr/local/myqsl/bin/mysqldump -u root -proot testdb > /tmp/mydb.bak
     *                                chmod u+x mydb.bak
     *                                crontab -e
     *                                *\1 * * * * /home/mytask.sh
     *10.磁盘分区             lsblk -f    查看磁盘分区
     *                       分区： fdisk /dev/sdb
     *                       格式化：  mkfs -t ext4 /dev/sdb1
     *                       挂载： mkdir /home/newdisk        mount /dev/sdb1 /home/newdisk
     *                       设置可以自动挂载：  vim /etc/fstab   增加一行/dev/sdb1     /home/newdisk  ext4   defaults      0 0
     *                                  然后  mount -a 立即生效
     *                       卸载分区：  umount    /dev/sdb1
     *11 .磁盘情况查询      df -h   --human-readable 使用人类可读的格式(预设值是不加这个选项的...)
     *                        -l   --local 限制列出的文件结构
     *                     查询指定目录的磁盘占用情况：
     *                      du -ach --max-depth=1 /opt    -a 含文件   --max-depth子目录深度  -c 增加汇总值
     *                     ls -l /home | grep "^-" | wc -l  统计/home下文件的个数
     *                     ls -l /home | grep "^d" | wc -l  统计/home下文件夹的个数
     *                     ls -lR /home | grep "^-" | wc -l  统计/home下所有文件的个数
     *                     ls -lR /home | grep "^d" | wc -l  统计/home下所有文件夹的个数
     *
     *
     *                     tree  以树状图的方式查看磁盘使用情况
     * 12.网络配置：
     * 13：显示进程：       ps -a  -u  -x
     *                     ps -aux | more
     *                     ps -aux | grep ....
     *                     ps -ef | more 查看父进程
     *                     kill -9  pid
     *                     killall  服务名
     *                     telnet   ip   端口号   测试端口号
     *
     *
     *                     top：   见图片   load average  :加起来除以3超过0.7  就不行了
     *                     监控网络状态：
     *                              netstat   -an  按一定顺序排列输出
     *                                        -p  显示哪个进程在调用
     * 14.                 yum -y  安装软件
     *                    rpm   -e 普通卸载软件
     *                    rpm -e --nodeps mysql  强制删除模式
     *                    rpm -qa | grep mysql  查找软件
     * 15 安装程序         java   解压之后
     *                            vim /etc/profile
     *                            JAVA_HOME=/opt/jdk1.7.0_79
     *                            PATH=/opt/jdk1.7.0_79/bin:$PATH   (将原来的path添加到末尾）
     *                            export JAVA_HOME PATH
     *                            source /etc/profile
     *                     mysql :rpm -qa | grep mysql
     *                            rpm -e --nodeps mysql
     *                            yum -y install make gcc-c++ cmake bison-devel ncurses-devel
     *                            tar -zxvf
     *                            cmake -DCMAKE_INSTALL_PREFIX=/usr/local/mysql
     *                            -DMYSQL_DATADIR=/usr/local/mysql/data -DSYSCONFDIR=/etc
     *                            -DWITH_MYISAM_STORAGE_ENGINE=1 -DWITH_INNOBASE_STORAGE_ENGINE=1
     *                            -DWITH_MEMORY_STORAGE_ENGINE=1 -DWITH_READLINE=1
     *                            -DMYSQL_UNIX_ADDR=/var/lib/mysql/mysql.sock -DMYSQL_TCP_PORT=3306
     *                            -DENABLED_LOCAL_INFILE=1 -DWITH_PARTITION_STORAGE_ENHINE=1
     *                            -DEXTRA_CHARSETS=all -DDEFAULT_CHARSET=utf8
     *                            -DDEFAULT_COLLATION=utf8_general_ci
     *                            make  && make install
     *                            groupadd mysql
     *                            useradd -g mysql mysql
     *                            chown -R mysql:mysql /usr/local/mysql/
     *
     * 16shell脚本           变量名大写  等号两边不能有空格    变量名不能以数字开头
     *                       RESULT=`ls -l /etc`
     *                       echo "RESULT=$RESULT"
     *                       DATE=$(date)
     *                       echo $DATE
     *                       :<<!     !    多行注释
     *                       位置参数变量    ./myshell.sh 100 200
     *                              $n    $0   $1-$9    ${10}
     *                              $*所有参数  当作整体
     *                              $@  所有参数   每个参数区别对待
     *                              $#  所有参数的个数
     *                       预定义变量：   $$ 当前进程的进程号pid
     *                                     $!  后台运行的最后一个进程的进程号
     *                                     $?  最后一次执行命令的返回状态   0正确执行   非0  没有正确执行
     *
     *                       运算符的使用：  $((运算式))  $[运算式]
     *                                      expr m + n
     *                                      \*  /   %
     *                                      $(((2+3)*4))
     *                      条件判断：L    [ 条件判断 }  前后要有空格
     *                                      =  字符串比较等于
     *                                      -lt 小于
     *                                      -le 小于等于
     *                                      -eq  等于
     *                                      -gt 大于
     *                                      -ge  大于等于
     *                                      -ne 不等于
     *                                       -r 有读的权限
     *                                       -w
     *                                       -x
     *                                       -f 文件存在并且是一个常规的文件
     *                                       -e 文件存在
     *                                       -d  文件存在并且是一个目录
     *                     流程控制 ：    if [ 判断 ]
     *                                   then
     *                                   elif [ 判断 ]
     *                                   then
     *                                   fi
     *
     *                                   case
     *
     *                     数据库备份脚本：
     *                              mysql_db_backup.sh
     *                                      cd /usr/sbin
     *                                      vim mysql_db_backup.sh
     *
     *                                      #!/bin/bash
     *                                      #备份的路径
     *                                      BACKUP=/data/backup/db
     *                                      DATETIME=$(date +%Y_%m_%d_%H%M%S)
     *                                      echo "=======开始备份======="
     *                                      echo "======备份的路径是  $BACKUP/$DATETIME.tar.gz"
     *                                      #主机
     *                                      HOST=localhost
     *                                      DB_USER=root
     *                                      DB_PWD=root
     *                                      DATABASE=test
     *                                      #判断备份路径是否存在，否则创建
     *                                      [ ! -d "$BACKUP/$DATETIME" ] && mkdir -p "$BACKUP/$DATETIME"
     *                                      mysqldump -u${DB_USER} -p${DB_PWD} --host=${HOST} $DATABASE | gzip > $BACKUP/$DATETIME/$DATETIME.sql.gz
     *                                      #打包
     *                                      cd $BACKUP
     *                                      tar -zcvf $DATETIME.tar.gz  $DATETIME
     *                                      #删除临时目录
     *                                      rm -rf $BACKUP/$DATETIME
     *                                      #检查是否有十天前的文件，并删除
     *                                      find $BACKUP -mtime  +10 -name "*.tar.gz" -exec rm -rf {} \;
     *                                      echo "=====备份文件成功==========="
     *
     *
     *                                      crontab -e
     *                                      10 2 * * * /usr/sbin/mysql_db_backup.sh
     *
     *                                      crontab  -r  删除定时任务
     *
     *
     *
     *
      */
}
