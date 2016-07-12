<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://dl.dropboxusercontent.com/u/31437201/homework/form.css" type="text/css" media="screen">
    <title>Form</title>
</head>
<body>
<form action="http://localhost/hello/post/" method="post">
    <label>Имя:<input name="name" type="text"></label>

    <div class="label">Пол:</div>
    <label class="radio"><input type="radio" name="sex" value="male">Мужской</label>
    <label class="radio"><input type="radio" name="sex" value="female">Женский</label>

    <label>Образование:
        <select name="education">
            <option value="low">Низшее</option>
            <option value="middle">Среднее</option>
            <option value="high">Высшее</option>
        </select>
    </label>

    <label>Комментарий:<textarea name="comment"></textarea></label>

    <div class="submit">
        <label><input name="spam" type="checkbox">Хочу получать спам</label>
        <button type="submit">Отправить</button>
    </div>
</form>
</body>
