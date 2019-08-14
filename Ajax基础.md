#Ajax基础

Ajax是一种对传统Web应用模式加以扩展的技术，可以在不重新加载网页的情况下通过异步请求方式对网页进行局部刷新，是非阻塞的。
基于Ajax的关键技术有：
（1）使用XHTML（HTML）和CSS构建标准化的展示层。
（2）使用DOM进行动态交互和显示。
（3）使用XML或JSON等进行数据交换和操纵。
（4）使用XMLHttpRequest来和服务器进行异步通信。
（5）使用JavaScript将所有元素绑定在一起。
XMLHttpRequest是Ajax技术得以实现的一个重要JavaScript对象。

Ajax实例实现一般需要几个步骤：
（1）在页面中定义Ajax请求的触发事件。
（2）创建XMLHttpRequest对象。
（3）确定请求地址和请求参数。
（4）通过XMLHttpRequest对象的open()方法建立对服务器的调用。
（5）通过XMLHttpRequest对象的onreadystatechange属性指定响应事件处理函数。
（6）在函数中根据响应状态进行数据获取和数处理工作。
（7）调用XMLHttpRequest对象的send()方法向服务器发出请求。

其中open()方法必须包含mthod(特定请求方法)，url(所调用资源的url)这两个参数，其他参数可选(asynch一般不写默认为true，表示异步,可设为false表示同步)。
onreadystatechange属性中主要有readyState和status两个属性。readyState可设为0,1,2,3,4这五个值。0表示XMLHttpRequest对象已创建但未初始化，
1表示请求准备发送到服务器，2表示请求已发送到服务器但未响应，3表示正在接收但只接收到HTTP响应头部信息，4表示响应已完全被接收。所以readyState常设为4表示已
接收完成信息。status描述了HTTP状态码，包括200（请求成功），202请求未接收但处理未完成，400（错误请求），404（请求资源未找到），500（内部服务器错误）。
通常status设为200。

JSON是基于JavaScript的一种轻量级数据格式，易于阅读和编写，也易于机器解析和生成，是理想的数据交换语言。
JSON有两种结构：（1）"名/值"对的集合 （2）值得有序列表
JSON格式相比XML格式在可读性，可扩展性，编码难度，解码难度，流行度等方面都更具有优势。
我个人的体会来说，JSON格式在编码时代码量大大减少，不需要XML格式使用时的关于XMLHttpRequest对象的操作。
使用插件后前后端发送接收信息都使用JSON格式，无需复杂的编码解码过程。

JQuery是一种免费开源兼多浏览器的JavaScript库其核心理念是：write less,do more。
JQuery的语法设计可以使开发者更加便捷操作，例如操作文档对象，选择DOM元素，事件处理以及Ajax以及其他功能。
我认为jQuery就是一种简洁的语言，在Ajax中使用JQuery，可以使代码变得简介而且可以更容易实现一些操作。
