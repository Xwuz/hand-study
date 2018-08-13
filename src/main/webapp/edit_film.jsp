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
        <form action="/UpdateFilmServlet" method="post">
        <thead>
            <tr>
                <th>标题</th>
                <th>描述</th>
                <th>语种</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <%
                    String id = request.getParameter("filmId");
                    System.out.println(id);
                    Film film = new FilmService().getFilmById(Integer.valueOf(id));
                    if (film != null){
                        %>
                <td><input type="text" name="title" value="<%=film.getTitle()%>"></td>
                <td><input type="hidden" name="filmId" value="<%=film.getFilmId()%>"></td>
                <td><input type="text" name="description" value="<%=film.getDescription()%>"></td>
                <td><select name="languageName">
                    <%List<Language> list = new FilmService().getLanguage();
                        if (list != null){
                            for (int i = 0; i < list.size(); i++){
//                                System.out.println(list.get(i).equals(film.getLanguageName()));
//                                System.out.println(list.get(i).getName().equals(film.getLanguageName()));
                                if (list.get(i).getName().equals(film.getLanguageName())){
                    %><option selected="selected" value="<%=list.get(i).getLanguageId()%>"><%=list.get(i).getName()%></option><%
                                }else {
                %><option value="<%=list.get(i).getLanguageId()%>"><%=list.get(i).getName()%></option><%
                                }
                        }
                    }
                %>

                </select></td>
                <%
                    }
                %>

            </tr>
            <tr>
                <td><input type="submit" value="保存"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </tbody>

        </form>
    </table>

</body>
</html>
