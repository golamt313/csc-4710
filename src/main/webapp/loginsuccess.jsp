<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("username");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:6000/";
String database = "ppsdb";
String userid = "GolamT313";
String password = "Gmaster123!";
String username = session.getAttribute("username").toString();
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>

<h1>Logged in as: ${username}</h1>
<button><a href="login.jsp">Logout</a></button>
<table border="1">
<tr>
<td>User Name</td>
<td>First Name</td>
<td>Last Name</td>
<td>Birthday</td>
<td>Address</td>
<td>PPS Balance</td>
<td>Bank Balance</td>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql = String.format("select * from users WHERE username=\"%s\"", username);
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("username") %></td>
<td><%=resultSet.getString("firstname") %></td>
<td><%=resultSet.getString("lastname") %></td>
<td><%=resultSet.getString("birthday") %></td>
<td><%=resultSet.getString("streetnumber") + " " + resultSet.getString("street") + " " + resultSet.getString("city") + ", " + resultSet.getString("state") + " " + resultSet.getString("zipcode") %></td>
<td><%=resultSet.getString("ppsbalance") %></td>
<td><%=resultSet.getString("bankbalance") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>