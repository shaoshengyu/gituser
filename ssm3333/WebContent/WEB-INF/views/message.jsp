<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		getByPageBean(1);
	});
	
	function getByPageBean(currentPage){
		var url="${pageContext.request.contextPath }/user/list"
		$.getJSON(url,{currentPage:currentPage},function(json){
			//删除表格之前数据(标题栏除外)--->防止出现几页的数据叠加的情况
            $("#infotable tr").not(":first").remove();
            //设置上一页 下一页连接
            if(json.currPage<1){
            	json.currPage=1;
            }
            if(json.cuurPage>json.totalPage){
            	json.cuurPage=json.totalPage;
            }
            $("a:eq(1)").attr("href","javascript:getByPageBean(1)");
            $("a:eq(2)").attr("href","javascript:getByPageBean("+(json.currPage==1?1:(json.currPage-1))+")");
            $("a:eq(3)").attr("href","javascript:getByPageBean("+(json.currPage==json.totalPage?json.currPage:(json.currPage+1))+")");
            $("a:eq(4)").attr("href","javascript:getByPageBean("+json.totalPage+")");
            //设置显示信息(当前页号,总页号,总条数)
            $("#pageNo").html(json.currPage);
            $("#totalPage").html(json.totalPage);
            $("#totalCount").html(json.totalCount);
            //在表格添加数据 使用each方法遍历 控制器传回的数据中的list集合
            $.each(json.lists,function(){
                var tr="<tr>"+
                            "<td>"+this.userName+"</td>"+
                            "<td>"+this.userEmail+"</td>"+
                            "<td><img src='/a/"+this.userPicture+"' height='100px' width='100px'></td>"+
                        "</tr>";
                        //把每次遍历的一行数据 添加到 表格中
                        $("#infotable").append(tr);
		});
	});
}
</script>

</head>
<body>
    <a href="${pageContext.request.contextPath}/user/tofunction">返回</a>
	<table id="infotable">
		<tr>
			<th>用户名</th>
			<th>邮箱</th>
			<th>图片</th>
		</tr>
	</table>
	<a href="">首页</a>
    <a href="">上一页</a>
    <a href="">下一页</a>
    <a href="">末页</a>
            当前第<span id="pageNo"></span> 页 ,
            总页数:<span id="totalPage"> </span>,
            总条数:<span id="totalCount"></span>
</body>
</html>