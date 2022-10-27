<%-- 
    Document   : header
    Created on : Oct 18, 2022, 8:43:13 AM
    Author     : Chold
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            String path = request.getContextPath();
        %>
        <c:set var="path" scope="application" value="${pageContext.request.contextPath}"/>
        <link href="${path}/css/style.css" rel="stylesheet"/>
    </head>


    <body>

        <div id="container">
            <div id="header">
                <div id="logo">
                    <a href="${path}/home"><img src="${path}/img/logo.png"/></a>
                </div>
                <div id="banner">
                    <ul>
                        <li><a href="cart.html">Cart: 0</a></li>
                            <%
                        if(session.getAttribute("AccSession")==null){
                            %>
                        <li><a href="<%=path%>/account/signin">SignIn</a></li>
                        <li><a href="<%=path%>/account/signup">SignUp</a></li>
                            <%
                                }else{
                            %>
                        <li><a href="<%=path%>/account/profile">Profile</a></li>
                        <li><a href="<%=path%>/account/signin">SignOut</a></li>
                            <%
                                }
                            %>
                    </ul>
                </div>
            </div>
            <div id="content">