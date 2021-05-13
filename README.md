
请 fork 本项目，并设为 private。然后实现`AnalyticDB`接口，并提交自己的代码地址来完成比赛。


# 测试环境说明
选手代码运行在容器内，容器 CPU 限制 **4核**。每台物理机上同时只会跑一个选手程序，避免互相干扰。
容器内存容量确保容器内系统能正常运行，选手使用内存受 JVM 配置限制。测试数据放在 pmem 上，同时
选手还有一块 pmem 可以用来存储选手生成的数据文件。

### JVM 版本
```
openjdk version "1.8.0_292"
OpenJDK Runtime Environment (build 1.8.0_292-b10)
OpenJDK 64-Bit Server VM (build 25.292-b10, mixed mode)
```

### JVM 参数
```
 -Xmx4g -Xms4g -XX:MaxDirectMemorySize=256m -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled
```

### 磁盘性能(测试数据和提供给选手使用的磁盘规格一致)

随机读
```
fio --name=rand_read_test -filename=**** -ioengine=sync -iodepth=1 -thread -numjobs=8 direct=1 -rw=randread -bs=64k -size=32g -runtime=60

Run status group 0 (all jobs):
   READ: bw=17.0GiB/s (18.3GB/s), 2179MiB/s-2291MiB/s (2285MB/s-2403MB/s), io=256GiB (275GB), run=14301-15036msec
```

顺序写
```
fio --name=write_test -filename=**** -ioengine=sync -iodepth=1 -thread -numjobs=8 -direct=1 -rw=write -bs=64k -size=32g -runtime=60

Run status group 0 (all jobs):
  WRITE: bw=2025MiB/s (2123MB/s), 200MiB/s-356MiB/s (209MB/s-373MB/s), io=119GiB (127GB), run=60001-60001msec

```

测试数据不是极限性能

# 测试数据说明
初赛只有一张表 lineitem，只有两列 L_ORDERKEY 和 L_PARTKEY，类型均为 bigint， 数据量3亿行。 格式如下：
```
L_ORDERKEY,L_PARTKEY
2876385239627262908,3426163450417145920
5164669269206349835,310661817109752352
4036124977818879891,1783468637370676778
```

为了避免精度问题导致答案错误，我们会保证所求的百分位的位点恰好是整数。
换句话说，假设有 N 行数据，求百分位 P(0<=P<=1.0)，我们保证`N * P`是个整数。 
具体可以参考`SimpleAnalyticDB` 实现

# 测试规则说明
- 任何原因导致测评没有通过，不会消耗提交次数
- 选手总耗时是启动进程到执行结束，所以是包括数据加载和查询到总耗时，按耗时排名
- 选手程序最多运行10分钟

# 依赖 & 编译说明
- 目前只允许使用标准库，不能引入外部依赖，pom文件测评程序编译时会强制覆盖
- 不要修改 maven 的`pom.xml`文件，可能会导致编译失败
- 不要修改`AnalyticDB`接口文件，可能会导致编译失败  
- 提交代码前请运行`mvn clean package -DskipTests`，确保能编译通过
- 在`META-INFO/services/com.aliyun.adb.contest.spi.AnalyticDB`中配置你的实现类

# 参赛注意事项
- 不要将自己生成的测试数据文件，提交到自己的代码库，可能会因为拉取代码时间过久而超时
- 不要打印过多日志，否则可能因为打过多日志而超时，日志只会截取10M上传
- 添加`analyticdb_support`为你项目的 reporter，确保测评程序有权限拉你的取代码。
- 直接复制`analyticdb_support`账号名，可能不会弹出账号搜索结果，可以尝试手动输入。
- 不要将自己的项目设置为 public 在比赛期间
- 提交代码路径格式，必须是git格式地址，形如：git@code.aliyun.com:xxx/xxx.git  
- 任何恶意或者作弊行为会被永久禁赛

