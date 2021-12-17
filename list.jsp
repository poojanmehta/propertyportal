
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="mypack.propertyBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<% User pb = (User)request.getAttribute("user");
%>
<!-- 
<body>
    <h1> Marksheet </h1>
    <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
       url = "jdbc:mysql://localhost:3306/practice?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
       user = "root" password = ""/>

    <sql:query dataSource = "${snapshot}" var = "result">
        SELECT * FROM students WHERE rollno = ?;
        <sql:param value = "${pb.getRollno()}" />
    </sql:query>

    <table border = "1" width = "100%">
        <tr>
           <th>Roll No</th>
           <th>Name</th>
           <th>sub 1</th>
           <th>sub 2</th>
           <th>sub 3</th>
        </tr>
        <c:forEach var = "row" items = "${result.rows}">
           <tr>
              <td><c:out value = "${row.rollno}"/></td>
              <td><c:out value = "${row.name}"/></td>
              <td><c:out value = "${row.sub1}"/></td>
              <td><c:out value = "${row.sub2}"/></td>
              <td><c:out value = "${row.sub3}"/></td>
              <c:set var="per" value="${(row.sub1 + row.sub2 + row.sub3)/300*100}" />
            </tr>
        </c:forEach>
     </table>
     Percentage : <c:out value="${per}" />
</body> -->

<body>
   <p><% out.print(user.Firstname;) %></p>
   <p><% out.print(user.Firstname;) %></p>
   <p><% out.print(user.Firstname;) %></p>
   <p><% out.print(user.Firstname;) %></p>
   <p><% out.print(user.Firstname;) %></p>
   <p><% out.print(user.Firstname;) %></p>
   <p><% out.print(user.Firstname;) %></p>
   <p><% out.print(user.Firstname;) %></p>
</body>
