<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Приветствие</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css" />
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #333;
        }

        .container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            max-width: 400px;
            width: 100%;
            text-align: center;
        }

        .title {
            font-size: 1.8em;
            margin-bottom: 20px;
            color: #0078d7;
        }

        .quest-form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .form-group {
            text-align: left;
        }

        .input-field {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        .submit-button {
            background-color: #0078d7;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1em;
        }

        .submit-button:hover {
            background-color: #005a9e;
        }
    </style>


</head>
<body>
<div class="container">
    <h1 class="title">Добро пожаловать в наш текстовый квест!</h1>

    <form action="${pageContext.request.contextPath}/start" method="post" class="quest-form">
        <div class="form-group">
            <label for="playerName">Введите ваше имя (необязательно):</label>
            <input type="text" name="playerName" id="playerName" class="input-field"/>
        </div>

        <div class="form-group">
            <label>Выберите квест:</label><br/>
            <div class="quest-option">
                <label>
                    <input type="radio" name="questType" value="ARTIFICIAL INTELLIGENCE" checked />
                    <span>Странный интеллект</span>
                </label>
            </div>
            <div class="quest-option">
                <label>
                    <input type="radio" name="questType" value="FOREST" />
                    <span>Загадочный лес</span>
                </label>
            </div>
        </div>

        <div class="form-group">
            <input type="submit" value="Начать игру" class="submit-button" />
        </div>
    </form>
</div>
</body>
</html>
