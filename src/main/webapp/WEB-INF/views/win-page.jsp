<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <title>Win Page</title>
</head>
<body>
<h1>Congratulations!</h1>
<p>Your score: <c:out value="${score}"/></p>
<p>Games played: <c:out value="${countGamePlayed}"/></p>
<p>Your IP: <c:out value="${clientIp}"/></p>
<p>Your server name: <c:out value="${serverName}"/></p>
<a href="/game?action=reset">Play again</a>
</body>
