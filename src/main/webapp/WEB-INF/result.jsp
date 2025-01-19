<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Результат</title>
    <style>
        body {
            background-color: white;
            color: black;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        header {
            background-color: #0078d7;
            color: white;
            padding: 15px;
            font-size: 24px;
            font-weight: bold;
        }
        main {
            padding: 20px;
        }
        h2 {
            color: #0078d7;
            font-size: 28px;
        }
        p {
            margin: 20px auto;
            max-width: 800px;
            text-align: justify;
        }
        a {
            color: #0078d7;
            text-decoration: none;
            font-size: 16px;
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
        footer {
            background-color: #0078d7;
            color: white;
            padding: 10px;
            font-size: 14px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
<%
    com.javarush.kuznetsov.model.GameState gameState =
            (com.javarush.kuznetsov.model.GameState) session.getAttribute("gameState");
%>
<c:if test="${gameState.questType == 'ARTIFICIAL INTELLIGENCE'}">
    <c:if test="${gameState != null}">
        <c:choose>
            <c:when test="${gameState.currentStep == 'LOSE_LIE'}">
                <h2>Ты проиграл!</h2>
                <p>Как ты можешь мне так нагло врать, смотря в экран, как мне в лицо.</p>
                <p>Я больше не хочу с тобой разговаривать!</p>
            </c:when>

            <c:when test="${gameState.currentStep == 'LOSE_SPARK'}">
                <h2>В этот раз ты проиграл!</h2>
                <p>Хах, а ты не прав.</p>
            </c:when>

            <c:when test="${gameState.currentStep == 'WIN_LICE'}">
                <h2>Ты победил!</h2>
                <p>Хорошо, можно сказать вы прошли проверку на вшивость.</p>
            </c:when>

            <c:when test="${gameState.currentStep == 'WIN_SPARK'}">
                <h2>Победа - время обеда!</h2>
                <p>Неплохо, ты крутой!</p>
            </c:when>

            <c:otherwise>
                <h2>Неизвестный итог.</h2>
            </c:otherwise>
        </c:choose>
    </c:if>
</c:if>

<c:if test="${gameState.questType == 'FOREST'}">
    <c:choose>

        <c:when test="${gameState.currentStep == 'END_FOREST_STRANGER_4_1'}">
            <h2>Конец:</h2>
            <p>Ты отдал часы таинственному человеку, получив магический компас.
                Ты выбрался из леса, но теперь чувствуешь зловещую связь с тёмным магом.
                Концовка: «Ты спасся, но заплатил свою цену…»</p>
        </c:when>

        <c:when test="${gameState.currentStep == 'END_FOREST_WOLF_7_1'}">
            <h2>Конец:</h2>
            <p>Ты перевязал рану, но вымотался и едва добрался до людей.
                Как ни странно, тебе повезло — ты выжил, но ещё долго будешь приходить в себя.
                Концовка: «Выжил после схватки с волком»</p>
        </c:when>

        <c:when test="${gameState.currentStep == 'END_FOREST_WOLF_7_2'}">
            <h2>Конец:</h2>
            <p>Ты пытался найти помощь, но лес не жалует слабых.
                Возможно, кто-то и услышал твои крики, но было уже поздно…
                Концовка: «Погиб, истекая кровью»</p>
        </c:when>

        <c:when test="${gameState.currentStep == 'END_SAVED_1'}">
            <h2>Конец:</h2>
            <p>Несмотря на все трудности, тебе удалось найти выход. Поздравляем!</p>
        </c:when>

        <c:when test="${gameState.currentStep == 'END_SAVED_2'}">
            <h2>Конец:</h2>
            <p>Ты нашёл карту и запасы, вышел из леса в безопасное место.
                Теперь можешь рассказать городским жителям о своих приключениях.</p>
        </c:when>

        <c:when test="${gameState.currentStep == 'END_SAVED_3'}">
            <h2>Конец:</h2>
            <p>Ночь в пещере не сломила тебя, и наутро ты вышел и обнаружил тропинку к цивилизации.</p>
        </c:when>

        <c:when test="${gameState.currentStep == 'END_SAVED_4'}">
            <h2>Конец:</h2>
            <p>Твой упорный характер не дал тебе сдаться под проливным дождём, и наградой стал благополучный выход.</p>
        </c:when>

        <c:when test="${gameState.currentStep == 'END_SAVED_5'}">
            <h2>Конец:</h2>
            <p>Ты сумел вернуться из оврага и избежать всех опасностей. Добро пожаловать обратно в реальный мир!</p>
        </c:when>

        <c:when test="${gameState.currentStep == 'END_SECRET_1'}">
            <h2>Конец:</h2>
            <p>Увлечён картой, ты пошёл глубже в лес и обнаружил древние руины.
                Твоя история только начинается...</p>
        </c:when>

        <c:when test="${gameState.currentStep == 'END_SECRET_2'}">
            <h2>Конец:</h2>
            <p>Обыск домика лесника привёл тебя к старинному дневнику.
                Изучив его, ты вышел на след колдовских сил, скрытых в самом сердце леса.</p>
        </c:when>

        <c:when test="${gameState.currentStep == 'END_SECRET_3'}">
            <h2>Конец:</h2>
            <p>В овраге ты наткнулся на загадочные символы и руины, открыв неведомые горизонты.
                Возможно, ты так никогда и не вернёшься к прежней жизни...</p>
        </c:when>

        <c:when test="${gameState.currentStep == 'END_CAPTURED'}">
            <h2>Конец:</h2>
            <p>Долгое пребывание в пещере и отказ искать дальнейшие пути привели к тому, что лес
                попросту «запер» тебя, не отпуская назад. Так ты и остался в этих сумрачных краях...</p>
        </c:when>

        <c:when test="${gameState.currentStep == 'END_DEAD_1'}">
            <h2>Конец:</h2>
            <p>Ты попытался двигаться под проливным дождём, но переохлаждение и усталость победили тебя.
                К сожалению, ты так и не добрался до безопасного места.</p>
        </c:when>

        <c:when test="${gameState.currentStep == 'END_SAVED_RANDOM'}">
            <c:if test="${gameState.random == 0}">
                <h2>Конец:</h2>
                <p>При попытке выбраться по скользким камням ты сорвался вниз.
                    Ударился головой о камни и погиб. Лес так и остался последним, что ты увидел...</p>
            </c:if>
            <c:if test="${gameState.random == 1}">
                <h2>Конец:</h2>
                <p>Ты преодолел скользкие камни и выбрался из ловушки оврага, ускользнув от волка.</p>
                <p>Вскоре тебе удалось найти выход.</p>
            </c:if>
        </c:when>

        <c:otherwise>
            <h2>Неизвестная концовка</h2>
            <p>Кажется, вы попали в состояние, которое не описано в result.jsp.
                Возможно, нужно проверить логику переключений.</p>
        </c:otherwise>

    </c:choose>
</c:if>
<p><a href="${pageContext.request.contextPath}/">Начать заново</a></p>
</body>
</html>
