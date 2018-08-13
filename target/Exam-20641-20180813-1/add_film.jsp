<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="exam.service.*"%>
<%@ page import="exam.bean.*"%>
<%@ page import="exam.bean.Film" %>
<%@ page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>

    <table style="position: absolute;width: 60%;left: 20%;top: 100px;">
        <form action="/FilmServlet" method="post">
        <thead>
            <tr>
                <th>标题</th>
                <th>描述</th>
                <th>语种</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><input type="text" name="title"></td>
                <td><input type="text" name="description"></td>
                <td><select name="languageName">
                    <%List<Language> list = new FilmService().getLanguage();
                        if (list != null){
                            for (int i = 0; i < list.size(); i++){
                    %><option value="<%=list.get(i).getLanguageId()%>"><%=list.get(i).getName()%></option><%
                    }
                    }
                    %>

                </select></td>
            </tr>
            <tr>
                <td><input type="submit" value="添加"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </tbody>

        </form>
    </table>

</body>
</html>
