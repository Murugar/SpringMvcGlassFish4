<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <jsp:body>
        <h1>Greetings!</h1>
        ${name}
        <br/>
        <h1>Org : ${company}</h1>
        <hr/>
        Spring MVC https://localhost:8181/SpringMvcGlassFish4/admin/springmvc/greeting/on<br>
        <code>com.iqmsoft.glassfish4.spring.admin.controllers.SpringmvcController</code><br>
        Jax-rs https://localhost:8181/SpringMvcGlassFish4/api/jaxrs (curl -i -H "Accept: application/json" "https://localhost:8181/SpringMvcGlassFish4/api/springrest/users")<br>
        <code>com.iqmsoft.glassfish4.spring.resources.SpringrestController</code>
        <hr/> 
       
        <hr/>
        <br><br>
        <a href="<c:url value='/j_spring_security_logout' />">Logout</a>
    </jsp:body>
</t:layout>