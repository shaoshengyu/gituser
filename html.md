java前端
web网站即文件夹，page网页即文件。
前端网页由三部分决定。html决定页面结构，css决定页面样式，javascript决定页面上的行为。
HTML：超文本标记语言，构建网页结构，定义网页内容。
CSS：层叠样式表，构建网页布局、外观，美化页面。
JS：JavaScript，脚本语言，构建网页行为，与用户进行交互，是用户更好体验。

HTML
文件结构:
<head>
    <title>XXX</title> 浏览器搜索引擎所需信息,出现在网页标题栏。
</head>
<body>
body标签中间显示网站具体内容
</body>

字符集与编码:
ASCII:对数字、英文字母、符号进行编码
GB2312:简体中文
UNicode；所有语言


标签：


元数据标签<meta>
<head>
<meta charset="UTF-8">
</head>


标题标签
<h1></h1>从 一个页面只会有一个<h1>
<h2></h2>上
<h3></h3>往
<h4></h4>下
<h5></h5>变
<h6></h6>小
这里是正文文字
标题大小可用css样式规定


段落标签           显示
<p>XXX</p>       XXX
<p>XXX   X,      XXX X, XXXXXX。

XXXXXX。</p>
每个段落自动换行，忽略段落内部连续空格，不显示空行，标签内部不自动换行。


段内换行标签
<br/>


空格字符
&nbsp;

生成角标标签<sup>
<p>XXX<sup>1</sup>XXX</p>
可用于书本上的注解


预留格式            
<pre>               显示
XXX    XXX       XXX    XXX  
    xxx              xxx
</pre>
标签之间空格和换行符会被保留。


行内组合元素标签
<p>XXX<span>YYY</span>XXX</p>
<span>标签组合行内元素YYY,以便通过CSS样式来格式化。
css:
<style type="text/css">
span{
    color: blue;(字体蓝色)
	font-weight:blod;(字体加粗)
}
</style>
显示：YYY部分蓝色加粗


水平线(分割线)
<hr/>


注释内容
<!--   -->
自动注释选中段落，按ctrl+shift+?


超链接标签
<a href="网址(比如https://www.baidu.com)" >文字或图片</a>连接到其他站点
<a href="xxx.html/jsp" >文字或图片</a>连接到本站其他网页
<a href="#">文字或图片</a>虚拟超链接，当前并未设定好，暂不设定url


图像标签<image />
图像格式:
JPG:有损压缩,色彩丰富图片
GIF:简单动、背景透明(适合图标logo）
PNG:无损压缩、透明、交错、动画
插入图像：<image src="路径+文件名" alt="找不到图片时显示的文字" />
绝对路径：src="详细地址"，以根目录为基准
相对路径(推荐)：以该文档所在位置为基准
../表示向上一级文件夹
(1)C:/site/index.html,C:/site/logo.gif  图片与文档在同一文件夹，<image src="logo.gif" />
(2)C:/index.html,C:/site/logo.gif       图片在文档下一文件夹，<image src="site/logo.gif" />
(3)C:/site/index.html,C:/logo.gif       图片在文档上一文件夹，<image src="../logo.gif" />
(4)C:/site/index.html,C:/images/logo.gif 图片与文档份属两文件夹,<image src="../images/logo.gif" />(先向上一级，再向下一级)


区域标签<div>
确定一个单独的却与，如页面一部分或一个栏目板块，可规整网页布局。
<div id="contanier" align="center"(设置被包括部分格式居中)>
    <div id="nav">
      <p>XXX | YYY</p>
	</div>  
	<hr />
	<div id="content">
	  <p>MMMMMM</p>
	</div>
<div>
除了外层板块，内部生成两个板块，每个版块可进行单独的css样式设置。


无序列表<ul> 列表项<li>
常用于超链接组合
<ul>
   <li>XXX</li>
   <li>YYY</li>
</ul>
显示时列表项前为小黑点(可通过css设置)


有序列表<ol> 列表项<li>
<ol>
   <li>XXX</li>
   <li>YYY</li>
</ol>
显示时列表项前为有序数列+.(可通过css设置)


表格<table>
<th>表头(加粗) <tr>行 <td>单元格
<table border="1">
      <tr>
              <td></td>  
              <th>语文</th>  
              <th>数学</th>
      </tr> 
      <tr>
              <th>一班</th>   
              <td>80</td>  
              <td>40</td>
      </tr> 
      <tr>
              <th>二班</th>  
              <td>70</td>  
              <td>60</td>
      </tr> 
</table>





