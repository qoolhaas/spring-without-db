<%--
  Created by IntelliJ IDEA.
  car: Augustin
  Date: 17.03.2020
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--<c:if test="${not empty param.locale}">
    <c:set var="locale" value="${locale}" scope="session"/>
</c:if>
<fmt:setLocale value="${param.locale}" scope="session"/>
<fmt:setBundle basename="src.main.resources" var = "locale"/>--%>
<%--<%@ page isELIgnored="false" %>--%>
<%--<fmt:setLocale value="en" scope="session"/>
<fmt:setBundle basename="src.com.isuru.test.i18N.resources">--%>
<%--<c:if test="${not empty param.locale}">
    <c:set var="locale" value="${locale}" scope="session"/>
</c:if>--%>
<fmt:requestEncoding value = "UTF-8" />
<fmt:setLocale value="${locale}" scope="session"></fmt:setLocale>
<fmt:setBundle basename="template" scope="session" var="myBundle"></fmt:setBundle>
<html>
<head>
    <title><fmt:message bundle="${myBundle}" key="title"></fmt:message></title>
</head>
<style>
    #grid {
        display: grid;
        grid-template-rows: repeat(8, 1fr);
        grid-template-columns: repeat(8, 1fr);
        grid-gap: 5px;
    }

    .car {
        font-family: Arial;
        font-size: 18px;
        padding: .5em;
        background: gold;
        text-align: center;
    }
</style>
<body>
<%--<p><spring:message code="title"/></p>--%>
Current Locale : ${pageContext.response.locale}
<fmt:message bundle="${myBundle}" key="title"></fmt:message>
<div id="grid">
    <c:forEach var="car" items="${cars}">
            <span class="car">
                <p>Brand: ${car.getBrand()}</p>
                <p>Model: ${car.getModel()}</p>
                <p>Plate: ${car.getPlate()}</p>
            </span>
    </c:forEach>
</div>
</body>
</html>
