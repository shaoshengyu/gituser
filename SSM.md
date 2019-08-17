SSM框架（Spring+SpringMVC+MyBatis）框架集由Spring、MyBatis两个开源框架整合而成（SpringMVC是Spring中的部分内容）。<br />
SSM框架通常使用 springMVC为控制器(controller) ，spring 为事务层(service)， MyBatis 负责持久层（dao）。<br />
SSM框架中pojo类可以与数据库表进行映射，是实体层。<br />
Spring是一个轻量级的控制反转(IoC)和面向切面(AOP)的容器框架。通过使用注解依赖注入来管理各层的组件，使用AOP切面编程来管理事务，日志，权限等。<br />
springMVC为控制器，使用Servlet嵌入，分离了控制器、模型对象、分派器以及处理程序对象的角色，让它们更容易进行定制。<br />
MyBatis持久化dao层，对jdbc的封装。它消除了几乎所有的JDBC代码和参数的手工设置以及结果集的检索，使用简单的 XML或注解用于配置和原始映射将接口和 Java 的POJO层对象映射成数据库中的记录。
