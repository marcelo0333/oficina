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
    <h2>Cadastro Mecânico</h2>
    <div>
        <c:url var="add_mecanico_url" value="/usuario/principal/registroMecanico"/>
        <form:form action="${add_mecanico_url}" method="post" modelAttribute="mecanico">
            <form:label path="nomeMec">Nome:</form:label> <form:input type="text" path="nomeMec"/>
            <form:label path="cpfMec">Cpf:</form:label> <form:input type="text" path="cpfMec"/>
            <input type="submit" class="btn btn-success" value="Cadastrar">
        </form:form>
        <h2>Listagem de Mecânicos</h2>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>Ações</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="mecanicos" items="${mecanicos}">
                <tr>
                    <td>${mecanicos.idMec}</td>
                    <td>${mecanicos.nomeMec}</td>
                    <td>${mecanicos.cpfMec}</td>
                    <td>
                        <a href="/appmaven/usuario/principal/editarMecanico?idMec=${mecanicos.idMec}" class="btn btn-primary">Editar</a>
                        <c:url var="exc_mecanico_url" value="/usuario/principal/excluirMecanico"/>
                        <form:form action="${exc_mecanico_url}" method="post" modelAttribute="mecanico">
                            <form:label path="idMec"></form:label> <form:input type="hidden" value="${mecanicos.idMec}" path="idMec"/>
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
