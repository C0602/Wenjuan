<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'Formation.jsp' starting page</title>
  </head>
  
  <body>
    <form action="saveresultAction" method="post">
    	<s:iterator value="lq" var="l" status="s">
						<s:property value="#l.title"/>
						<s:hidden name="questionResult.resulttitle" value="%{#l.title}"></s:hidden>
						<s:hidden name="questionResult.resulttype" value="%{#l.type}"></s:hidden>
						<s:hidden name="title[%{#s.index}]" value="%{#l.title}"></s:hidden>
						<s:hidden name="type[%{#s.index}]" value="%{#l.type}"></s:hidden>
						<br>
			   			<s:iterator value="#l.valueList" var="value" status="st">
			   				<s:if test="#l.type=='单选'">								
									<s:radio name="choose[%{#s.index}]" list="#value"/>
							</s:if>
							<s:elseif test="#l.type=='多选'">	
									<s:checkboxlist name="choose[%{#s.index}]" list="#value"/>
							</s:elseif>
							<s:else>
									<s:textfield name="choose[%{#s.index}]"></s:textfield>
							</s:else>		   				
			   			</s:iterator>
			   			<br>
			</s:iterator>
			<input type="submit" value="提交"/>
    </form>
  </body>
</html>
