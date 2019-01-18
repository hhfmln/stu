<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: hhf
  Date: 18-12-20
  Time: 下午8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
    <title>更新学生页面</title>
</head>
<body>

<h3>更新学生界面</h3>

<form method="post" action="UpdateServlet">
    <input type="hidden" name="sid" value="${stu.sid}">
    <table border="1" width="600">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="sname" value="${stu.sname}"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="男"<c:if test="${stu.gender == '男'}">checked</c:if>>男
                <input type="radio" name="gender" value="女"<c:if test="${stu.gender == '女'}">checked</c:if>>女
            </td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="phone" value="${stu.phone}"></td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="text" name="birthday" value="${stu.birthday}"></td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <input type="checkbox" name="hobby" value="游泳"<c:if test="${fn:contains(stu.hobby,'游泳' )}">checked</c:if>>游泳
                <input type="checkbox" name="hobby" value="篮球"<c:if test="${fn:contains(stu.hobby,'篮球' )}">checked</c:if>>篮球
                <input type="checkbox" name="hobby" value="网球"<c:if test="${fn:contains(stu.hobby,'网球' )}">checked</c:if>>网球
                <input type="checkbox" name="hobby" value="打游戏"<c:if test="${fn:contains(stu.hobby,'打游戏' )}">checked</c:if>>打游戏
                <input type="checkbox" name="hobby" value="写字"<c:if test="${fn:contains(stu.hobby,'写字' )}">checked</c:if>>写字
            </td>
        </tr>
        <tr>
            <td>简介</td>
            <td><textarea name="info" rows="3" cols="20">${stu.info}</textarea></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="更新"></td>
        </tr>
    </table>
</form>

</body>
</html>