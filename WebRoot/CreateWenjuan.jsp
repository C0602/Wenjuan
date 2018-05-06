<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>创建问卷</title>
    <script type="text/javascript" src="JS/addradio.js"></script>
    <script type="text/javascript" src="JS/js.js"></script>
  </head>
  <div class="d1"><h2>预览界面</h2>
    <table border="1" width="60%"  border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
		<tr>
			<th>问题类型</th>
			<th>问题标题</th>
			<th>问题答案</th>
			<th>操作</th>
		</tr>
	    <s:iterator value="ls" status="stat" var="l">
	    	<tr align="center" >
	    		<td><s:property value="#l.type" /></td>
	    		<td><s:property value="#l.title" /></td>
	    		<td>
				   	<s:iterator value="#l.valueList" var="value">
				   		<s:property value="#value"/><br>
				   	</s:iterator>
		   		</td>
	    		<td><a href="javascript:queryQuestionByIdAction('<s:property value="id"/>')"">修改 | 
				<a href="javascript:deleteQuestionByIDAction('<s:property value="id"/>')"">删除</a></td>			    		
			</tr>
    	</s:iterator>
    	</table>
    	[<a href="queryAction?pageNo=1">首页</a>]
			<c:choose>
				<c:when test="${currentPage>1}">
					[<a href="queryAction?pageNo=${currentPage-1}">上一页</a>]
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${currentPage<totalPage}">
					[<a href="queryAction?pageNo=${currentPage+1}">下一页</a>]
				</c:when>
			</c:choose>
			[<a href="queryAction?pageNo=${totalPage}">尾页</a>]
    </div>
  <body onLoad="addradio()">
    <form method="post" action="saveAction">   
    <h2>请选择添加的类型：</h2>
		<s:radio list="%{#{'单选':'单选','多选':'多选','文本':'文本'}}" name="question.type" value="'单选'"></s:radio>   
    <div class="d2" id="d2">
    	<h2>请添加你的问题和问题的回答</h2>
    </div>
    <input type="submit" value="提交"/>
    <a href="JumptoFinish.jsp">保存</a>
    </form>
  </body>
</html>
