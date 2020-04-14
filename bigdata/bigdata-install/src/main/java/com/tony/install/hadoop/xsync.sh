#!/bin/bash
# 1 获取输入参数个数，如果个数为0直接退出
pcount=$#
if ((pcount==0)); then
echo no args;
exit;
fi

#2  获取文件名称
p1=$1
fname=`basename $p1`
echo basename=$fname

# 3 获取上级目录的绝对路径
pdir=`cd -P $(dirname $p1); pwd`
echo pdir=$pdir

# 4 获取当前用户名称
user=`whoami`

# 5 循环
for ((host=100; host<103; host++)); do
    echo ==============hadoop$host============
    rsync -av $pdir/$fname $user@hadoop$host:$pdir
done