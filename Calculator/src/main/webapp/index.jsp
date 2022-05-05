<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<div class="content">
    <form method="post" action="auth">
        Login:
        <br/>
        <input class="input" type="text" name="login" value="${login}" placeholder="Enter your login"><br/><br/>
        Password:
        <br/>
        <input class="input" type="text" name="password" value="${password}" placeholder="Enter your password"><br/><br/>
        <input id="submit" type="submit" value="Log in">
    </form>
    <a href="reg">Зарегистрироваться</a>
</div>
</body>
</html>