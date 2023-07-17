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
        <c:url var="edt_ordem_url" value="/usuario/principal/editarOrdem"/>
        <form:form action="${edt_ordem_url}" method="post" modelAttribute="ordem">
            <form:input type="hidden" path="idMec" value="${ordem.idMec}"/>
            <form:input type="hidden" path="idMaquina" value="${ordem.idMaquina}"/>
            <form:label path="nomeMec">Nome Mecanico:</form:label>
            <form:input type="text" path="nomeMec" value="${ordem.nomeMec}"/><br>
            <form:label path="nomeMaq">Nome Mecanico:</form:label>
            <form:input type="text" path="nomeMaq" value="${ordem.nomeMaq}"/><br>
            <form:label path="dataRecebimento">Data Recebimento:</form:label>
        <form:input type="text" path="dataRecebimento" value="${ordem.dataRecebimento}"/><br>
        <form:label path="dataConclusao">Data Final:</form:label>
        <form:input type="text" path="dataConclusao" value="${ordem.dataConclusao}"/><br>
        <form:label path="precoFinal">Preco:</form:label>
        <form:input type="text" path="precoFinal"/><br>
            <form:label path="idOrdem"></form:label>
            <form:input type="hidden" path="idOrdem" value="${param.idOrdem}"/><br>
        <input type="submit" class="btn btn-success" value="Editar">
    </form:form>
    </div>
    <a href="/appmaven/usuario/principal" class="btn btn-primary">Voltar a Pagina Inicial</a>

</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
