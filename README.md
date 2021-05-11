
请 fork 本项目，并设为 private。然后实现`AnalyticDB`接口，并提交自己的代码地址来完成比赛。


# 测试环境说明
选手代码运行在 docker 内，docker CPU 限制4核。每台物理机上同时只会跑一个选手 docker，避免互相干扰。
docker 内存容量确保 docker 内系统能正常运行，选手使用内存受 JVM 配置限制。测试数据放在 SSD 上，
选手还有一块 SSD 可以用来存储自己生成的数据文件。

JVM 版本
```
openjdk version "1.8.0_292"
OpenJDK Runtime Environment (build 1.8.0_292-b10)
OpenJDK 64-Bit Server VM (build 25.292-b10, mixed mode)
```

JVM 参数
```
 -Xmx4g -Xms4g -XX:MaxDirectMemorySize=256m -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled
```

# 测试数据说明
测试数据放在 SSD 磁盘上。初赛只有一张表 lineitem，只有两列 L_ORDERKEY 和 L_PARTKEY，类型均为 bigint，
数据量3亿行。 格式如下：
```
L_ORDERKEY,L_PARTKEY
2876385239627262908,3426163450417145920
5164669269206349835,310661817109752352
4036124977818879891,1783468637370676778
```

为了避免精度问题导致答案错误，我们会保证所求的百分位的位点恰好是整数。
换句话说，假设有 N 行数据，求百分位 P(0<=P<=1.0)，我们保证`N * P`是个整数。 
具体可以参考`SimpleAnalyticDB` 实现

选手总耗时 = 数据载入耗时 + 查询耗时，按耗时排名

# 依赖 & 编译说明
- 目前只允许使用标准库，不能引入外部依赖
- 不要修改 maven 的`pom.xml`文件，可能会导致编译失败
- 不要修改`AnalyticDB`接口文件，可能会导致编译失败  
- 提交代码前请运行`mvn clean package -DskipTests`，确保能编译通过

# 参赛注意事项
- 不要将自己生成的测试数据文件，提交到自己的代码库，可能会因为拉取代码时间过久而超时
- 不要打印过多日志，否则可能因为打过多日志而超时，日志只会截取10M上传
- 添加`analyticdb_support`为你项目的 reporter，确保测评程序有权限拉你的取代码
- 不要将自己的项目设置为 public 在比赛期间
- 提交代码路径格式，必须是git格式地址，形如：git@code.aliyun.com:xxx/xxx.git  
- 任何恶意或者作弊行为会被永久禁赛

