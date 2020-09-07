<%--
  Created by IntelliJ IDEA.
  initions.User: 1
  Date: 07.09.2020
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
</head>
<body>
    <form name="logIn" method="post">
        <label>Registration
            <input type="radio" name="inputType" value="reg">
        </label>
        <label>LogIn
            <input type="radio" name="inputType" value="log">
        </label>
        <br>
        <br>
        <label title="xxx">Login:
            <input type="text" name="login" placeholder="Enter Your Login: " required>
        </label>
        <br>
        <br>
        <label>Password:
            <input type="text" name="password" placeholder="Enter Your password: ">
        </label>
        <br>
        <button type="submit" >Send</button>

    </form>

    <button onclick="location.href='/'">Home</button>

</body>
</html>
