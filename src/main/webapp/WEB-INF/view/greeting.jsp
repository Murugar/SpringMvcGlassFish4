<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <jsp:body>
        <h1>Welcome!</h1>
        ${name}
        <hr/>
        Spring MVC http://localhost:8080/SpringMvcGlassFish4/admin/springmvc/greeting/on<br>
        <code>com.iqmsoft.glassfish4.spring.admin.controllers.SpringmvcController</code><br>
        Jax-rs http://localhost:8080/SpringMvcGlassFish4/api/jaxrs (curl -i -H "Accept: application/json" "http://localhost:8080/springmvcrest/api/springrest/users")<br>
        <code>com.iqmsoft.glassfish4.spring.resources.SpringrestController</code>
        <hr/> 
       
        <hr/>
        <br><br>
        <a href="<c:url value='/j_spring_security_logout' />">Logout</a>
    </jsp:body>
</t:layout>