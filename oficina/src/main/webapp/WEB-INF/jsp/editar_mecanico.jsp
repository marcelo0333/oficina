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
    <h2>Alterar mecanico</h2>
    <div>
        <c:url var="edt_mecanico_url" value="/usuario/principal/editarMecanico"/>
            <c:if test="${not empty mecanico.idMec}">
            <form:form action="${edt_mecanico_url}" method="post" modelAttribute="mecanico">
                <form:label path="idMec"></form:label> <form:input type="hidden" value="${param.idMec}" path="idMec"/>
                <form:label path="nomeMec">Nome:</form:label> <form:input type="text" path="nomeMec"/>
                <form:label path="cpfMec">Cpf:</form:label> <form:input type="text" path="cpfMec"/>
                <input type="submit" class="btn btn-success" value="Editar">
            </form:form>

        </c:if>
    </div>
    <a href="/appmaven/usuario/principal" class="btn btn-primary">Voltar a Pagina Inicial</a>

</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
