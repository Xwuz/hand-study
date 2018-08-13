<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="exam.dao.*"%>
<%@ page import="exam.bean.*"%>
<%@ page import="exam.bean.Film" %>
<%@ page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<center><a href="add_film.jsp">新增</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/CustomerServlet">注销</a></center>
<table style="position: absolute;width: 60%;left: 20%;top: 100px;" border="1px" >
    <thead>
    <tr>
        <th>编号</th>
        <th>标题</th>
        <th>描述</th>
        <th>语种</th>
        <th>删除</th>
        <th>编辑</th>
    </tr>
    </thead>
    <tbody>
    <%List<Film> films = new CustomerDao().getFilm();
        System.out.println(films.size()+"大小");
        for (int i = 0;i < films.size();i++){

    %>
        <tr>
            <td><%=films.get(i).getFilmId()%></td>
            <td><%=films.get(i).getTitle()%></td>
            <td><%=films.get(i).getDescription()%></td>
            <td><%=films.get(i).getLanguageName()%></td>
            <td><a href="/DeleteFilmServlet?filmId=<%=films.get(i).getFilmId()%>">删除</a></td>
            <td><a href="edit_film.jsp?filmId=<%=films.get(i).getFilmId()%>">编辑</a></td>
        </tr>
    <%

        }%>
    </tbody>
</table>
</body>
</html>
