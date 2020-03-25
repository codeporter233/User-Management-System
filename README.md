# User-Management-System
----
写的比较简陋，暂时没有发现bug，也没有什么好说的

-------

## 版本日志

### Version2.2
1. 又修复了不能登录的bug

### Version2.1
1. 修复了不能登录的bug
2. 上一条md写错了

### Version2.0
1. 增加过滤器，防止直接访问到list

### Version1.0

1. 登录：目前只有一个管理员用户
2. 删除：单个删除或批量删除
3. 修改：单个修改
4. 查找：性别+姓名+籍贯组合查找
5. 添加：逐个添加

-------

## 关于jsp，el，jstl

- jsp,el,jstl与html,css这些典型的前端代码放在一起，显得比较混乱，但是开发还算快速简单

## 关于Dao层

- 先接口，在实现
- 将Dao层对数据库连接做了较为底层的封装，供Service调用
- 写了部分@Test，用于测试，后期的测试比较麻烦，直接运行项目来观察数据，所以只为Dao的部分方法提供测试
## 关于service层
- 调用Dao层，对数据进一步处理，供servlet层使用
- 由于项目较为简单，相当一部分service没有对Dao数据进行处理，相当于简单地进行转发
## 关于Servlet
- 处理Http请求，使用Service
- 用BeanUtils简化编程
## JDBC工具类
- 使用Druid连接池
## Domain
- 三个类，Admin管理员类，User用户类，PageBean页面信息封装类
