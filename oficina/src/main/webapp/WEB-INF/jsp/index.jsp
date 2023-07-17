<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>LOGAR</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>LOGAR</h2>
        <c:url var="login_usuario_url" value="/usuario/login"/>
        <form:form action="${login_usuario_url}" method="post" modelAttribute="usuario">
            <form:label path="login">Login:</form:label> <form:input type="text" path="login"/>
            <form:label path="senha">Senha:</form:label> <form:input type="text" path="senha"/>
            <input type="submit" class="btn btn-success" value="Entrar">
        </form:form>
        <c:if test="${not empty msgServidor}">
            <h2>User invalido</h2>
        </c:if>
    </form>
    <a href="/appmaven/usuario/cadastrarUsuario" class="btn btn-primary">Se cadastrar</a>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
