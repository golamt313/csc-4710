<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Employee Register Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
   <tr>
     <td>UserName</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>First Name</td>
     <td><input type="text" name="firstname" /></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="lastname" /></td>
    </tr>
    <tr>
     <td>Birthday</td>
     <td><input type="text" name="birthday" /></td>
    </tr>
    <tr>
     <td>Street Number</td>
     <td><input type="text" name="streetnumber" /></td>
    </tr>    
    <tr>
     <td>Street</td>
     <td><input type="text" name="street" /></td>
    </tr>
    <tr>
     <td>City</td>
     <td><input type="text" name="city" /></td>
    </tr>
    <tr>
     <td>State</td>
     <td><input type="text" name="state" /></td>
    </tr>
    <tr>
     <td>Zip Code</td>
     <td><input type="text" name="zipcode" /></td>
    </tr>
   </table>
   <button><a href="login.jsp">Login</a></button>
   <input type="submit" value="Register" />
  </form>
 </div>
</body>
</html>