
# MedCard

The application is designed to provide doctors and paramedics with a convenient and effective tool for keeping records of patients, prescribing treatment and diagnostics, and receiving their results. 

It is possible to view the list of patients, add new ones and change information about existing ones. The application contains several tabs for working with data. It is possible to view information about a patient, add and edit appointments, record diagnoses and vital signs. 


## Java Version
This project requires Java version 21 or higher. You can download it from the official [Java website](https://www.oracle.com/java/technologies/downloads/).

## JavaFX Version
This project requires JavaFX version 23 or higher. You can download it from the official [JavaFX website](https://openjfx.io/).

## Database
This project requires PostgreSQL version 42.7.3 or higher. You can download it from the official [PostgreSQL website](https://www.postgresql.org/download/).

The database connection is established using the following parameters:
- Host: localhost
- Port: 5432
- Database Name: medcardDB
- Username: postgres
- Password: PostgreXLLRNX

The information required to connect the database used is stored in variables that are included in the startup parameters. These variables are shown in the screenshot below

![DB connection variables](README images\DB_connection_variables.png)



## Кроки для запуску проєкту розробником
1. Клонування репозиторію
- git clone https://github.com/xllrnx/MedCard.git
- cd MedCard

2. Встановлення Java 21+
- Завантажити з https://jdk.java.net/21/
- Додати до PATH

3. Встановлення JavaFX 23+
- Завантажити з https://gluonhq.com/products/javafx/
- Розпакувати та прописати шлях до lib у IDE

4. Встановлення PostgreSQL 42.7.3+
- Завантажити з https://www.postgresql.org/download/
- Створити базу даних вручну: create database medcardDB;

5. Налаштування з'єднання з БД
У файлі src/.../DatabaseConnection.java перевірити:
- String url = "jdbc:postgresql://localhost:5432/medcardDB";
- String user = "postgres";
- String password = "PostgreXLLRNX";

6. Імпорт SQL-структури
Виконати SQL-скрипти з файлу init_db.sql або створити таблиці вручну

7. Запуск проєкту
- В IDE — налаштувати VM options для JavaFX: --module-path "path\to\javafx-sdk-23\lib" --add-modules javafx.controls,javafx.fxml
- Запустити головний клас App.java

## Authors

- [@xllrnx](https://www.github.com/xllrnx)


## License

[MIT](https://choosealicense.com/licenses/mit/)

