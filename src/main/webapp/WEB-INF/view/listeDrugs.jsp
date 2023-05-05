<%@ page language="java" contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
      href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
        src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>List of Drugs</title>
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            List of drugs
        </div>
        <div class="card-body">

            <table class="table table-striped">
                <tr>
                    <th>ID</th><th>Name</th><th>dosage</th><th>Date
                    Creation</th><th>Delete<th>Edit</th>
                </tr>
                <c:forEach items="${drugs}" var="d">
                    <tr>
                        <td>${d.idDrug }</td>
                        <td>${d.name }</td>
                        <td>${d.dosage }</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy"
                                            value="${d.dateCreation}" /></td>
                        <td><a onclick="return confirm('are you sure ?')"
                               href="supprimerDrug?id=${d.idDrug }">Delete</a></td>
                        <td><a href="modifierDrug?id=${d.idDrug }">Edit</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
