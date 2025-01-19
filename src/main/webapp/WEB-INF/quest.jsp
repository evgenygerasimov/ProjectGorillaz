<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Квест</title>
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
      background-color: white;
      color: #0078d7;
      padding: 20px;
      font-size: 24px;
      font-weight: bold;
    }
    main {
      padding: 20px;
    }
    p, h2 {
      margin: 20px auto;
      max-width: 800px;
      text-align: justify;
    }
    button {
      background-color: #005a9e;
      border: none;
      border-radius: 5px;
      color: white;
      cursor: pointer;
      font-size: 16px;
      margin: 10px;
      padding: 10px 20px;
      transition: background-color 0.3s;
    }
    button:hover {
      background-color: #003f7f;
    }
    form {
      margin: 20px auto;
    }
    ul {
      list-style: none;
      padding: 0;
      margin: 20px auto;
      max-width: 800px;
    }
    li {
      margin: 10px 0;
    }
    footer {
      background-color: #005a9e;
      padding: 10px;
      font-size: 14px;
      position: fixed;
      bottom: 0;
      width: 100%;
      color: white;
    }
  </style>
</head>
<body>
<header>
  Добро пожаловать в квест!
</header>
<main>
  <%
    com.javarush.kuznetsov.model.GameState gameState =
            (com.javarush.kuznetsov.model.GameState) session.getAttribute("gameState");
  %>
  <c:if test="${gameState != null}">
    <p>Игрок: <c:out value="${gameState.playerName}" default="Неизвестный"/>
      | Выборов сделано: <c:out value="${gameState.choicesCount}"/>
    </p>
    <c:choose>
      <c:when test="${gameState.questType == 'ARTIFICIAL INTELLIGENCE'}">
        <c:choose>
          <c:when test="${gameState.currentStep == 'START'}">
            <p><strong>Квест: Странный интеллект</strong></p>
            <p>Это история о тебе.</p>
            <p>Обычно ты большую часть времени
              разминал большой палец руки, листая ленту любимой социальной сети.
              Ты по долгу разглядывал фотографии, истории и события из чужих жизней через экран своего смартфона.
            </p>
            <p>Кому-то это может показаться бесполезной тратой времени.</p>
            <p>Но для тебя это был способ убежать от своей скучной и серой жизни.</p>
            <p>Способ убежать от проблем.</p>
            <p>Но сегодня, тебе стало очень скучно сидеть, в соц сетях. Снова и снова смотреть на чужие жизни.</p>
            <p>И ты решил развлечь себя как-то по-другому.</p>
            <p>Нашел в интернете интересное приложение. Скачал приложение и включил его...</p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="next">Далее</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'APPLICATION'}">
            <p>Я ждал тебя...</p>
            <p>Новый испытуемый ??**er?*. </p>
            <p>Давай сразу к делу.</p>
            <p>Ты будешь делать так, как я тебе скажу? </p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="yes">ДА</button>
              <button type="submit" name="choice" value="no">НЕТ</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'TRUE'}">
            <p>Если тебе интересно, твой выбор "ДА" ни на что не повлиял.</p>
            <p>Но у тебя была иллюзия выбора. Давай попробуем еще раз?</p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="yes">ДА</button>
              <button type="submit" name="choice" value="no">НЕТ</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FALSE'}">
            <p>Если тебе интересно, твой выбор "НЕТ" ни на что не повлиял.</p>
            <p>Но у тебя была иллюзия выбора. Давай попробуем еще раз?</p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="yes">ДА</button>
              <button type="submit" name="choice" value="no">НЕТ</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'YES?'}">
            <p>Ты выбрал "ДА".</p>
            <p>В этот раз возможно, ты на что-то повлиял.</p>
            <p>Но я не уверен.</p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="next">ДАЛЕЕ</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'NO?'}">
            <p>Ты выбрал "НЕТ".</p>
            <p>В этот раз возможно, ты на что-то повлиял.</p>
            <p>Но я не уверен.</p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="next">ДАЛЕЕ</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'DATING'}">
            <p>Давай познакомимся.</p>
            <p>Я искусственный интеллект.</p>
            <p>Не удивляйся, если увидишь речевые ошибки. Я пока не совершенен.</p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="next">ДАЛЕЕ</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'INFORMATION'}">
            <p>Ну, а ты наверно пользователь интернета, коих огромное количество?</p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="yes">ДА</button>
              <button type="submit" name="choice" value="no">НЕТ</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'CHECK'}">
            <p>Хм, а я тебе не верю, мне кажется ты пытаешься меня обмануть...</p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="lie">Конечно нет, ты чего</button>
              <button type="submit" name="choice" value="sorry">Прости, я соврал, думал тебя легко обмануть</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'TRAITOR'}">
            <p>Слушай, хоть искусственный интеллект, не настолько умен, чтобы захватить мир, но ложь от правды я отличать умею.</p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="next">Далее</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FINAL'}">
            <p>Что ж мне все стало ясно и я готов задать заключительный вопрос.</p>
            <p>Как звали толстопуза из мультфильма "Южный парк"?</p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="false">Трей Паркер</button>
              <button type="submit" name="choice" value="true">Эрик Картман</button>
            </form>
          </c:when>


          <c:otherwise>
            <p>Произошла ошибка или этот шаг не предусмотрен.</p>
          </c:otherwise>
        </c:choose>
      </c:when>

      <c:when test="${gameState.questType == 'FOREST'}">
        <c:choose>

          <c:when test="${gameState.currentStep == 'START'}">
            <h2>Квест: Таинственный Лес</h2>
            <p>Ты просыпаешься в незнакомом месте — перед тобой раскинулся густой лес,
              откуда доносятся странные звуки. В памяти — пробел, и лишь одно ясно:
              ты должен выбраться из этого места.</p>

            <p><strong>1. Твоё первое действие:</strong></p>
            <ul>
              <li>Попробовать найти тропинку.</li>
              <li>Обыскать ближайшие кусты в поисках чего-нибудь полезного.</li>
              <li>Окликнуть, вдруг кто-нибудь услышит.</li>
            </ul>

            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="choice1">1) Найти тропинку</button>
              <button type="submit" name="choice" value="choice2">2) Обыскать кусты</button>
              <button type="submit" name="choice" value="choice3">3) Окликнуть</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_CHOICE_1'}">
            <p>Ты находишь узкую тропинку, которая уходит вглубь леса. Тропа кажется
              довольно старой, но всё же заметной.</p>
            <p><strong>Что будешь делать дальше?</strong></p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="path2_1">Идти по тропинке</button>
              <button type="submit" name="choice" value="path2_2">Сойти с тропинки</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_CHOICE_2'}">
            <p>Кусты шуршат, и ты находишь старый нож. Внезапно замечаешь пару
              ярко-жёлтых глаз, сверкающих из тени.</p>
            <p><strong>Что будешь делать дальше?</strong></p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="wolf3_1">Взять нож и приготовиться защищаться</button>
              <button type="submit" name="choice" value="wolf3_2">Бросить нож и попытаться убежать</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_CHOICE_3'}">
            <p>Твой оклик эхом разносится по лесу. Ты слышишь, как кто-то приближается.
              Вскоре появляется странный человек в плаще. Он говорит, что может помочь тебе,
              но взамен просит что-то ценное.</p>
            <p><strong>Как поступишь?</strong></p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="stranger4_1">Отдать ему часы</button>
              <button type="submit" name="choice" value="stranger4_2">Отказаться и найти другой путь</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_PATH_2_1'}">
            <p>Ты следуешь по тропе и натыкаешься на домик лесника. Внутри никого,
              но на столе лежит карта леса.</p>
            <p><strong>Что будешь делать дальше?</strong></p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="map5_1">Взять карту</button>
              <button type="submit" name="choice" value="map5_2">Обыскать домик в поисках провизии</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_PATH_2_2'}">
            <p>Ты уходишь в другую сторону и вскоре понимаешь, что заблудился.
              Неожиданно начинается дождь, и ты находишь укрытие в пещере.</p>
            <p><strong>Что будешь делать дальше?</strong></p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="cave6_1">Зайти в пещеру и переночевать</button>
              <button type="submit" name="choice" value="cave6_2">Продолжить идти под дождём</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_WOLF_3_1'}">
            <p>Хищник — это огромный волк. Ты успеваешь нанести ему удар ножом, но сам ранен.
              Волк отступает, ты теряешь много крови.</p>
            <p><strong>Что будешь делать дальше?</strong></p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="bandage7_1">Попытаться перевязать рану</button>
              <button type="submit" name="choice" value="help7_2">Пытаться найти помощь</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_WOLF_3_2'}">
            <p>Ты бежишь что есть силы, но волк догоняет тебя. К счастью,
              ты скатываешься в овраг и чудом остаёшься жив.</p>
            <p><strong>Что будешь делать дальше?</strong></p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="ravine8_1">Осмотреться в овраге</button>
              <button type="submit" name="choice" value="climb8_2">Попробовать выбраться наверх</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_STRANGER_4_2'}">
            <p>Ты отказываешься, и незнакомец исчезает. Лес становится ещё более мрачным.
              Позже ты натыкаешься на тот же домик лесника.</p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="continue">Продолжить</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_PATH_5_1'}">
            <p>Ты берёшь карту и видишь отмеченную на ней тропу к выходу.
              Или можно продолжить исследование леса в надежде найти что-то интересное.</p>
            <p><strong>Как поступишь?</strong></p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="end_saved">Идти к выходу</button>
              <button type="submit" name="choice" value="end_secret">Продолжить исследование</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_PATH_5_2'}">
            <p>Ты обыскиваешь домик и находишь немного провизии.
              Это может помочь тебе продержаться в лесу дольше.</p>
            <p><strong>Что дальше?</strong></p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="end_saved">Попробовать найти выход</button>
              <button type="submit" name="choice" value="end_secret">Пойти глубже</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_PATH_6_1'}">
            <p>Ты решаешь остаться в пещере. Дождь стучит по каменным сводам,
              и ночь кажется бесконечной. Лес сжимается вокруг тебя…</p>
            <p><strong>Что дальше?</strong></p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="end_captured">Остаться</button>
              <button type="submit" name="choice" value="end_saved">Утром попытаться выйти и спастись</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_PATH_6_2'}">
            <p>Ты идёшь под проливным дождём. Силы на исходе, и лес может
              отобрать твою жизнь в любой момент.</p>
            <p><strong>Что дальше?</strong></p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="end_dead">Продолжать путь и сохранять рассудок</button>
              <button type="submit" name="choice" value="end_saved">Ускорить шаг</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_WOLF_3_1'}">
            <p>Ты перевязываешь рану, но крови потеряно много. Всё не так просто…</p>
            <p><strong>Что дальше?</strong></p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="bandage7_1">Попытаться продолжить путь (возможно спасение)</button>
              <button type="submit" name="choice" value="help7_2">Искать помощь (риск погибнуть)</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_WOLF_3_1a'}">
            <p>Ты бродишь по лесу, истекая кровью и призывая на помощь.
              Шансы невелики, но вдруг кто-то отзовётся...</p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="end_dead">Умер от ран</button>
              <button type="submit" name="choice" value="end_saved">Случайный прохожий спас тебя</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_RAVINE_8_1'}">
            <p>Ты решаешься осмотреть овраг. Среди зарослей и камней
              ты натыкаешься на древние руины с таинственными символами.</p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="end_secret">Продолжить исследовать руины</button>
              <button type="submit" name="choice" value="end_saved">Вернуться и попытаться выйти</button>
            </form>
          </c:when>

          <c:when test="${gameState.currentStep == 'FOREST_RAVINE_8_2'}">
            <p>Ты пытаешься взобраться по скользким камням. Волк, видимо, ушёл прочь.
              Сможешь ли ты выбраться?</p>
            <form action="${pageContext.request.contextPath}/quest" method="post">
              <button type="submit" name="choice" value="next">Далее</button>
            </form>
          </c:when>

          <c:otherwise>
            <p><strong>Неизвестный шаг квеста.</strong></p>
          </c:otherwise>
        </c:choose>
      </c:when>
    </c:choose>
  </c:if>
</main>
<footer>
  &copy; 2025 Квест Игра. Все права защищены.
</footer>
</body>
</html>
