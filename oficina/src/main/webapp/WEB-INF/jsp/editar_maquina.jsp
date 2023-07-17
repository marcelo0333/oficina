<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Editar</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Alterar maquina</h2>
    <div>
        <c:url var="edt_maquina_url" value="/usuario/principal/editarMaquina"/>
            <c:if test="${not empty maquina.idMaquina}">
            <form:form action="${edt_maquina_url}" method="post" modelAttribute="maquina">
                <form:label path="idMaquina"></form:label> <form:input type="hidden" value="${param.idMaquina}" path="idMaquina"/>
                <form:label path="nomeMaquina">Nome:</form:label> <form:input type="text" path="nomeMaquina"/>
                <form:label path="descMaquina">Descrição:</form:label> <form:input type="text" path="descMaquina"/>
                <input type="submit" class="btn btn-success" value="Editar">
            </form:form>

        </c:if>
    </div>
    <a href="/appmaven/usuario/principal" class="btn btn-primary">Voltar a Pagina Inicial</a>

</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
