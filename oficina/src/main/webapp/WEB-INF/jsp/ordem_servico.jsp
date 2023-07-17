<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Listagem de Ordens de Serviço</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Listagem de Ordens de Serviço</h2>
    <form:form action="${ordemServico}" method="post" modelAttribute="ordem">

        <form:label path="idMec">Mecanico:</form:label>
        <form:select path="idMec">

            <c:forEach var="mecanicos" items="${mecanicos}">
                <form:option value="${mecanicos.idMec}">${mecanicos.nomeMec}</form:option>
            </c:forEach>

        </form:select>

        <form:label path="idMaquina">Maquina:</form:label>
        <form:select path="idMaquina">

            <c:forEach var="maquinas" items="${maquinas}">
                <form:option value="${maquinas.idMaquina}">${maquinas.nomeMaquina}</form:option>
            </c:forEach>

        </form:select>

        <form:label path="dataRecebimento">Data Recebimento:</form:label>
        <form:input type="text" path="dataRecebimento"/><br>
        <form:label path="dataConclusao">Data Final:</form:label>
        <form:input type="text" path="dataConclusao"/><br>
        <form:label path="precoFinal">Preco:</form:label>
        <form:input type="text" path="precoFinal"/><br>
        <input type="submit" class="btn btn-success" value="Cadastrar">


    </form:form>
        </tbody>
    </table>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Máquina</th>
            <th>Mecânico</th>
            <th>Data de Recebimento</th>
            <th>Data de Conclusão</th>
            <th>Preço Final</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ordens" items="${ordens}">
            <tr>
                <td>${ordens.idOrdem}</td>
                <td>${ordens.nomeMaq}</td>
                <td>${ordens.nomeMec}</td>
                <td>${ordens.dataRecebimento}</td>
                <td>${ordens.dataConclusao}</td>
                <td>${ordens.precoFinal}</td>
                <td> <a href="/appmaven/usuario/principal/editarOrdem?idOrdem=${ordens.idOrdem}" class="btn btn-primary">Editar</a>
                    <c:url var="exc_ordem_url" value="/usuario/principal/excluirOrdem"/>
                    <form:form action="${exc_ordem_url}" method="post" modelAttribute="ordem">
                        <form:label path="idOrdem"></form:label> <form:input type="hidden" value="${ordens.idOrdem}" path="idOrdem"/>
                        <input type="submit" class="btn btn-danger" value="Excluir">
                    </form:form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/appmaven/usuario/principal" class="btn btn-primary">Voltar a Pagina Inicial</a>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
