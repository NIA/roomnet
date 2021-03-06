RoomNet -- домашняя сеть
=========================

Это простенькое веб-приложение, которое удобно поставить
на обычный компьютер дома или в общаге, чтобы обмениваться
сообщениями и файлами **по локальной сети** -- быстро и не
засоряя свою почту и dropbox.

А если честно, это просто учебное приложение, главная цель
-- опробовать **Play Framework** и написание сайтов на **Java**,
равно как и сопутствующие технологии: JDBC, EBean,
javax.persistence...

Основные функции
----------------

- Лента сообщений *(в процессе)*
- Комментарии к сообщениям *(в планах)*
- Загрузка и скачивание файлов *(в планах)*

Как запустить у себя
--------------------

1. Установить [JDK], [Play Framework] и [MySQL].

2. Добавить папку, содержащую исполняемый файл javac в PATH.
> *(например, `C:\Program Files\Java\jdk1.7.0_07\bin`)*

2. Настроить MySQL, чтобы он слушал на порту 3333 (или поменять значение
   поля `db.default.url` в файле `conf/application.conf`), залогиниться в
   нём под `root`'ом и выполнить:

        CREATE DATABASE roomnet;
        CREATE USER roomnet@localhost;
        GRANT ALL PRIVILEGES ON roomnet.* TO roomnet@localhost;

3. В командной строке из папки с проектом выполнить

        play run

4. Дождаться, пока он установит зависимости и скажет

        (Server started, use Ctrl+D to stop and go back to the console...)

5. И открывать в браузере `localhost:9000`.

6. Разбить бутылку шампанского о корпус компьютера. Большого плавания!

Как запустить тесты
-------------------

В командной строке из папки с проектом выполнить

    play test

  [JDK]: http://www.oracle.com/technetwork/java/javase/downloads/index.html
  [Play Framework]: http://www.playframework.org/download
  [MySQL]: http://dev.mysql.com/downloads
