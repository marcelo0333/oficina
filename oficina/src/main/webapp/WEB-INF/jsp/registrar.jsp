
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Cadastrar</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Cadastrar</h2>
    <div>
        <c:url var="add_usuario_url" value="/usuario/cadastrarUsuario"/>
        <form:form action="${add_usuario_url}" method="post" modelAttribute="usuario">
            <form:label path="nome">Nome:</form:label> <form:input type="text" path="nome"/>
            <form:label path="cpf">Cpf:</form:label> <form:input type="text" path="cpf"/>
            <form:label path="login">Login:</form:label> <form:input type="text" path="login"/>
            <form:label path="senha">Senha::</form:label> <form:input type="text" path="senha"/>
            <input type="submit" class="btn btn-success" value="Cadastrar">
        </form:form>
            <c:if test="${not empty cadatroFeito}">
                <h2>Cadastro efetuado ${cadatroFeito.nome}</h2>
            </c:if>
        </form>

    </div>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
