<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <title>Game</title>
</head>
<body>

<p>Question: <c:out value="${question.text}"/></p>

<form method="post" action="/game">
    <label>
        <input type="radio" name="answer" value="1" required>
        <c:out value="${question.option1}"/>
    </label>
    <br>
    <label>
        <input type="radio" name="answer" value="2" required>
        <c:out value="${question.option2}"/>
    </label>
    <br>
    <button type="submit">Submit</button>
</form>

</body>
