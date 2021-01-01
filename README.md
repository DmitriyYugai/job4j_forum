# Проект - Форум
[![Build Status](https://travis-ci.org/DmitriyYugai/job4j_forum.svg?branch=master)](https://travis-ci.org/DmitriyYugai/job4j_forum)

# Содержание
* [Использованные технологии](#Использованные-технологии)
* [О проекте](#О-проекте)
* [Сборка](#Сборка)
* [Использование](#Использование)
* [Контакты](#Контакты)
## Использованные технологии
* Spring Boot
* Spring MVC
* Spring Test
* Spring Data JPA
* Spring Security
* Liquibase
* PostgreSQL
* Collections Framework
* Apache Commons DBCP (Database Connection Pooling)
* JSP
* JSTL
* HTML, CSS, Bootstrap
* JS, JQuery
* Heroku
* Travis CI
## О проекте
* Данное Spring Boot приложение представляет собой систему публикации постов:<br><br>
![Главная страница](img/usage/index.PNG)<br><br>
* При добавлении поста необходимо указать название и описание поста:<br><br>
![Добавление поста 1](img/about/add1.PNG)<br><br>
![Добавление поста 2](img/about/add2.PNG)<br><br>
* После добавления поста можно просмотреть подробную информацию о посте:<br><br>
![Подробная информация о посте](img/about/info.PNG)<br><br>
* Есть возможность редактировать добавленные посты:<br><br>
![Редактирование поста 1](img/about/edit1.PNG)<br><br>
![Редактирование поста 2](img/about/edit2.PNG)<br><br>
![Редактирование поста 3](img/about/edit3.PNG)<br><br>
* Неавторизованные пользователи с приложением работать не могут<br><br>
* Авторизация построена на Spring Security. Все зарегистрированные пользователи хранятся в БД. 
Все пароли пользователей хранятся в БД в закодированном виде. Форма авторизации:<br><br>
![Авторизация пользователя 1](img/about/auth0.PNG)<br><br>
![Авторизация пользователя 2](img/about/auth1.PNG)<br><br>
![Авторизация пользователя 3](img/about/auth2.PNG)<br><br>
* Добавлена возможность регистрации новых пользователей. Регистрация основана на контроллере RegControl, 
который инициирует сохранение новых пользователей в БД. Форма регистрации:<br><br>
![Регистрация пользователя](img/about/reg.PNG)<br><br>
* По умолчанию в БД хранится пользователь с ролью администратора. Его логин - root, пароль - secret<br><br>
* Все формы приложения провалидированы с помощью JS и JQuery:<br><br>
![Валидация 1](img/about/valid1.PNG)<br><br>
![Валидация 2](img/about/valid2.PNG)<br><br>
![Валидация 3](img/about/valid3.PNG)<br><br>
* Приложение построено на трёх слоях: слой по работе с БД, слой контроллеров, слой сервисов<br><br>
* В качестве БД используется PostgreSQL<br><br>
* Работа с БД осуществляется через Spring Data JPA<br><br>
* Слой контроллеров использует Spring MVC<br><br>
* Слой сервисов содержит логику приложения<br><br>
* Проект построен по шаблону MVC. Все виды открываются через GET-методы контроллеров, 
что позволяет передавать на виды необходимые данные<br><br>
* В качестве видов используются JSP-страницы, реализованные с помощью HTML и Bootstrap<br><br>
* Для реализации логики отображения на видах используется JSTL<br><br>
* В качестве системы версионирования структуры БД используется Liquibase<br><br>
* На все контроллеры написаны тесты с помощью Spring Test<br><br>
* Приложение доступно на облачной платформе Heroku: 
[https://stark-reef-21545.herokuapp.com/login](https://stark-reef-21545.herokuapp.com/login) <br><br>
* Реализована интеграция Travis CI с Heroku.
## Сборка
1. Установить JDK 14.
2. Скачать Maven.
3. Создать переменные окружения JAVA_HOME и M2_HOME и прописать в переменную окружения Path 
пути до бинарных файлов для JDK и для Maven:<br><br>
![Java Maven installing](img/build/java_maven.PNG)<br><br>
4. Установить сервер БД PostgreSQL. При установке задать:<br>
    * имя пользователя - postgres 
    * пароль - root
    * порт - 5432<br>
Также при установке сервера БД PostgreSQL нужно установить программу pg_Admin.

5. Скачать исходный код проекта с GitHub.
6. Перейти в корень проекта, где лежит файл pom.xml:<br><br>
![Переход в корень проекта 1](img/build/cd.PNG)<br><br>
![Переход в корень проекта 2](img/build/cd1.PNG)<br><br>
7. С помощью Maven осуществить сборку проекта:<br><br>
![Сборка проекта](img/build/package.PNG)<br><br>
При успешной сборке должна появиться папка target, в которой располагается war-архив:<br><br>
![Сборка прошла успешно](img/build/package1.PNG)<br><br>
![Папка target](img/build/target.PNG)<br><br>
![war-архив](img/build/target1.PNG)<br><br>
8. Запустить сервер БД, указав путь до папки data:<br><br>
![Запуск сервера БД](img/build/server_start.PNG)<br><br>
9. Запустить программу pg_Admin, установленную вместе с сервером БД PostgreSQL:<br><br>
![Запуск pg_Admin](img/build/pg_admin.PNG)<br><br>
10. Создать БД с названием forum:<br><br>
![БД forum](img/build/forum_db.PNG)<br><br>
11. Открыть Query Tool для созданной БД и запустить SQL-скрипты schema.sql и security.schema.reg.sql, 
находящиеся в папке src/main/resources/db (папка src находится в корне скачанного проекта):<br><br>
![Скрипт schema.sql](img/build/script.PNG)<br><br>
![Запуск скрипта schema.sql](img/build/pg_admin_script1.PNG)<br><br>
![Запуск скрипта security.schema.reg.sql](img/build/pg_admin_script2.PNG)<br><br>
Сборка завершена. Теперь можно проверить работу приложения.
## Использование
Переходим в папку target, где располагается собранный war-архив и запускаем Spring boot приложение:<br><br>
![Запуск приложения 1](img/usage/start_app1.PNG)<br><br>
![Запуск приложения 2](img/usage/start_app2.PNG)<br><br>
Переходим на главную страницу приложения 
[http://localhost:8080/](http://localhost:8080/): <br><br>
![Вход под админом 1](img/usage/admin1.PNG)<br><br>
Как видно, мы были переведены на форму авторизации, что означает, что с приложением могут работать только авторизованные 
пользователи. По умолчанию в БД уже хранится один пользователь с ролью администратора. Поэтому мы можем войти через 
администратора (логин - root, пароль - secret):<br><br>
![Вход под админом 2](img/usage/admin2.PNG)<br><br>
![Главная страница](img/usage/index.PNG)<br><br>
Теперь осуществим выход и зарегистрируем нового пользователя:<br><br>
![Выход](img/usage/reg1.PNG)<br><br>
![Регистрация](img/usage/reg2.PNG)<br><br>
Авторизуемся под только что созданным пользователем при этом введём некорректный пароль:<br><br>
![Авторизация 1](img/usage/auth1.PNG)<br><br>
![Авторизация 2](img/usage/auth2.PNG)<br><br>
Как видно, мы получили предупреждение. Теперь введём корректные данные:<br><br>
![Авторизация 3](img/usage/auth3.PNG)<br><br>
![Авторизация 4](img/usage/auth4.PNG)<br><br>
Добавим новый пост:<br><br>
![Добавление поста 1](img/usage/add1.PNG)<br><br>
![Добавление поста 2](img/usage/add2.PNG)<br><br>
Для просмотра подробной информации о посте нужно кликнуть по названию поста:<br><br>
![Подробная информация о посте](img/usage/info.PNG)<br><br>
Отредактируем добавленный пост:<br><br>
![Редактирование поста 1](img/usage/edit1.PNG)<br><br>
![Редактирование поста 2](img/usage/edit2.PNG)<br><br>
![Редактирование поста 3](img/usage/edit3.PNG)<br><br>
![Редактирование поста 4](img/usage/edit4.PNG)<br><br>
Проверим валидацию. Для этого нажмём на кнопки отправки форм, при этом не заполнив все поля форм:<br><br>
![Проверка валидации 1](img/usage/valid1.PNG)<br><br>
![Проверка валидации 2](img/usage/valid2.PNG)<br><br>
![Проверка валидации 3](img/usage/valid3.PNG)<br><br>
## Контакты
Почта: studentnstu97@mail.ru<br>
Skype: live:.cid.9cdc925fb48220b4