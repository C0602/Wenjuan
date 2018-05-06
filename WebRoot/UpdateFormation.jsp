<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'UpdateFormation.jsp' starting page</title>
    <script type="text/javascript" src="JS/addselect.js"></script>
  </head>
  <body>
    <h2 align="center">修改用户</h2>   
    <s:form action="updateAction"  method="post" id="f1">    
		<s:hidden name="id"/>
		<s:textfield name="question.title" label="问题"/>
		<s:radio name="question.type" list="%{#{'单选':'单选','多选':'多选','文本':'文本'}}" value="question.type"/>
		<s:iterator value="question.valueList"  var="st">
			<s:textfield name="question.valueList" label="单选问题" value="%{#st}"/>
		</s:iterator>
		<s:submit value="确认修改"/>		
		</s:form>
  </body>
</html>
