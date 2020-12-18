<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Post</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
    <div class="card">
        <h5 class="card-header">
            <div class="row">
                <div class="col-8">Название</div>
                <div class="col-4">
                    <span class='pull-right'>${user.username} | </span>
                    <a href="/logout" class='pull-right'>Выйти</a><br>
                    <a href="/reg" class='pull-right'>Регистрация</a>
                </div>
            </div>
        </h5>
        <div class="card-body">
            <p class="card-text"><c:out value="${post.name}"/></p>
        </div>
    </div>
    <div class="card">
        <h5 class="card-header">Дата создания</h5>
        <div class="card-body">
            <p class="card-text">${post.created}</p>
        </div>
    </div>
    <div class="card">
        <h5 class="card-header">Описание</h5>
        <div class="card-body">
            <p class="card-text">${post.description}</p>
        </div>
    </div>
    <a class="btn btn-primary" href="/post/edit?id=${post.id}">Редактировать</a>   <a href="/">На главную</a>
</body>
