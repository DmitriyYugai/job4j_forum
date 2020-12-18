<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script>
        function validate() {
            var s = '';
            var name = $('#name').val();
            var desc = $('#description').val();
            if (name == '') {
                s = s + ' ' + $('#nameLabel')[0].innerText;
            }
            if (desc == '') {
                s = s + ' ' + $('#descLabel')[0].innerText;
            }
            if (name == '' || desc == '') {
                alert('Заполните поля:' + s);
                return false;
            }
            return true;
        }
    </script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-8">
            <c:if test="${post.id == 0}">
                <h4>Создание поста</h4>
            </c:if>
            <c:if test="${post.id != 0}">
                <h4>Редактирование поста</h4>
            </c:if>
        </div>
        <div class="col-4">
            <a href="/logout" class='pull-right'>Выйти</a>
            <span class='pull-right'>${user.username} | </span><br>
            <a href="/reg" class='pull-right'>Регистрация</a>
        </div>
    </div>
    <form action="/post/save?id=${post.id}" method="post" onsubmit="return validate()">
        <div class="form-group">
            <label id="nameLabel" for="name">Название</label>
            <c:if test="${post.id == 0}">
                <input type="text" class="form-control" id="name" placeholder="Введите название" name="name">
            </c:if>
            <c:if test="${post.id != 0}">
                <input type="text" class="form-control" id="name" placeholder="Введите название" name="name" value="${post.name}" >
            </c:if>
        </div>
        <div class="form-group">
            <label id="descLabel" for="description">Описание</label>
            <c:if test="${post.id == 0}">
                <input type="text" class="form-control" id="description" placeholder="Добавьте описание" name="description">
            </c:if>
            <c:if test="${post.id != 0}">
                <input type="text" class="form-control" id="description" placeholder="Добавьте описание" name="description" value="${post.description}">
            </c:if>
        </div>
        <button type="submit" class="btn btn-default">Сохранить</button>
    </form>
</div>

</body>
</html>
