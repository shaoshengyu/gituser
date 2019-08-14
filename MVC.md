# MVC
MVC框架

#MVC框架
MVC全名是Model View Controller，是模型(model)－视图(view)－控制器(controller)的缩写。
MVC的最主要精神之一就是Model与View的分离。

MVC 是一种使用 MVC（Model View Controller 模型-视图-控制器）设计创建 Web 应用程序的模式：
（1）Model（模型）表示应用程序核心（比如数据库记录列表）。
（2）View（视图）显示数据（数据库记录）。
（3）Controller（控制器）处理输入（写入数据库记录）。

MVC指MVC模式的某种框架，它强制性的使应用程序的输入、处理和输出分开。
使用MVC应用程序被分成三个核心部件：模型、视图、控制器。它们各自处理自己的任务。最典型的MVC就是JSP + servlet + javabean的模式。

Java Web开发模式在发展中经历了Model 1模式和Model 2模式。
Model 1模式是以JSP为主的开发模式，分为完全用JSP开发和使用JSP+JavaBean来设计。
完全使用JSP开发，开发时间较短，但程序可读性较低，程序重复利用率较低，维护成本大。
使用JSP+JavaBean开发，程序可读性与重复利用率提高，但流程控制不清晰，仍然不易维护。
Model 2模式即Java Web应用的MVC模式，通过JavaBean、EJB等组件来实现MVC的模型层，通过JSP实现MVC的视图层，通过Servlet实现MVC的控制层。
Model 2模式的组件可以交互与重用弥补了Model 1的不足，开发流程明确，核心程序管控，更易维护。但Model2 的开发时间较长，在系统设计上花费更多时间。


