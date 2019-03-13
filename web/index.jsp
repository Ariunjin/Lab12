<%--
  Created by IntelliJ IDEA.
  User: ariun
  Date: 3/8/2019
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>WAP Lab12</title>
  </head>
  <body>
    <h1>Please, insert your login information.</h1>
    <form action="login" method="post">
      <p>UserName: <input name="username" value=${cookie.Username.value}></p>
      <p>Password: <input type="password" name="password"></p>
      <br>Remember me. <input type="checkbox"
                              name="remember" value="yes"/>
      <p><input type="submit" value="Login"></p>
      <p>${err_msg}</p>
    </form>
  </body>
</html>
