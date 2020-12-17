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
    <h2>Создать пост</h2>
    <form action="" method="post" onsubmit="return validate()">
        <div class="form-group">
            <label id="nameLabel" for="name">Название</label>
            <input type="text" class="form-control" id="name" placeholder="Введите название" name="name">
        </div>
        <div class="form-group">
            <label id="descLabel" for="description">Описание</label>
            <input type="text" class="form-control" id="description" placeholder="Добавьте описание" name="description">
        </div>
        <button type="submit" class="btn btn-default">Создать</button>
    </form>
</div>

</body>
</html>
