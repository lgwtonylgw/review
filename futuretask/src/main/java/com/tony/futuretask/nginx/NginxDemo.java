package com.tony.futuretask.nginx;

/**
 * Created on 2020/1/26 9:17.
 *
 * @author Tony
 * @description:
 */
public class NginxDemo {
    /**   yum -y install gcc zlib zlib-devel  pcre-devel openssl openssl-devel
     * nginx官网下载安装包  解压    ./configure   make && make install
     * 在/usr/local/nginx/sbin   下  ./nginx   可以启动nginx    通过ps -ef | grep nginx来查看nginx进程
     * 在   nginx/conf/ngingx.conf   就是nginx的配置文件
     *          查看开放的端口号  ：firewall-cmd --list-all
     *          设置开放端口号：   firewall-cmd --add-service=http --permanent
     *                              sudo firewall-cmd --add-port=80/tcp --permanent
     *                              firewall-cmd --remove-port=80/tcp --permanent
     *           重启防火墙  ：firewalll-cmd --reload
     * nginx常用操作   进入/usr/local/nginx/sbin
     *             查看版本号：  ./nginx -v
     *             启动：。/nginx
     *             关闭：./nginx -s stop
     *             重启：./nginx -s reload
     * nginx配置文件:    /usr/local/nginx/conf/nginx.conf
     *                 1.由三部分组成：
     *                 2.正则表达式   反向代理   proxy_pass
     *                                负载均衡  :upstream   myserver{
     *                                    ip_hash;
     *                                    server  127.0.0.1:8080  weight=1;
     *                                    server  127.0.0.1:8081   weight=1;
     *                                    fair;
     *                                }
     *                                location / {
     *                                    proxy_pass   http://myserver；
     *                                    proxy_connect_timeout  10;
     *                                }
     *                   3.分配服务器方式：
     *                          （1）轮询（默认）
     *                          （2）权重  weight
     *                          （3）ip_hash   给每个请求按ip分配
     *                          （4）fair  按照服务器的响应时间来分配，时间与短的分配的越多
     *nginx 高可用   先在两台服务器上面安装两个nginx  然后安装  keepAlived  :yum install keepalived -y
     *              查看是否安装上：   rpm -q -a keepalived
     *              安装位置  /etc/keepalived/   配置文件   keepalived.conf主从的配置在这里
     *
     * worker数和服务器的CPU数量一致最为适宜
     * 连接数   最大并发数   =    work_process*work_connection/2（普通静态访问）  或者   work_process*work_connection/4（HTTP访问 ）
     *
     */
}
