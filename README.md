Запуск тестов
Чтобы запустить тесты в определенном браузере
необходимо написать в консоли следующие команды:
"mvn test -Dbrowser=yandex" - Яндекс.Браузер
"mvn test -Dbrowser=chrome" - Chrome
"mvn test -Dbrowser=firefox" - для Firefox

По умолчанию (без введения -Dbrowser=browser) запуск произойдет в Chrome