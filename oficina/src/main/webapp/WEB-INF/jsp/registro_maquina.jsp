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
    <h2>Cadastro Máquina</h2>
    <div>
        <c:url var="add_maquina_url" value="/usuario/principal/registroMaquina"/>
        <form:form action="${add_maquina_url}" method="post" modelAttribute="maquina">
            <form:label path="nomeMaquina">Nome:</form:label> <form:input type="text" path="nomeMaquina"/>
            <form:label path="descMaquina">Descrição:</form:label> <form:input type="text" path="descMaquina"/>
            <input type="submit" class="btn btn-success" value="Cadastrar">
        </form:form>
        <h2>Listagem de Máquinas</h2>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Ações</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="maquinas" items="${maquinas}">
                <tr>
                    <td>${maquinas.idMaquina}</td>
                    <td>${maquinas.nomeMaquina}</td>
                    <td>${maquinas.descMaquina}</td>
                    <td>
                      <a href="/appmaven/usuario/principal/editarMaquina?idMaquina=${maquinas.idMaquina}" class="btn btn-primary">Editar</a>
                        <c:url var="exc_maquina_url" value="/usuario/principal/excluirMaquina"/>
                        <form:form action="${exc_maquina_url}" method="post" modelAttribute="maquina">
                            <form:label path="idMaquina"></form:label> <form:input type="hidden" value="${maquinas.idMaquina}" path="idMaquina"/>
                            <input type="submit" class="btn btn-danger" value="Excluir">
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="/appmaven/usuario/principal" class="btn btn-primary">Voltar a Pagina Inicial</a>

</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
