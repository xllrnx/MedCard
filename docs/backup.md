## Стратегія резервного копіювання
- Повне копіювання щодня
- Зберігання останніх 7 копій
- Автоматизація через .bat або .sh скрипт

## Типи копій
- Повне: pg_dump -F c

## Частота
- Щоденне о 02:00 (Автоматизовано за допомогою планувальника завдань Windows)

## Що копіювати
- База даних
- Конфігураційні файли: config.properties, *.env
- Лог-файли (за потреби)

## Приклад скрипту резервного копіювання (Windows)
@echo off 

set PGUSER = postgres

set PGPASSWORD = PostgreXLLRNX

set BACKUP_DIR = C:\MedCardBackups

set DATESTAMP = %DATE:~6,4%%DATE:~3,2%%DATE:~0,2%

set BACKUP_FILE = medcard_%DATESTAMP%.bak

pg_dump -U %PGUSER% -F c medcard > %BACKUP_DIR%\%BACKUP_FILE%

## Перевірка цілісності
- Тестове відновлення на окремому сервері
- Ручна перевірка коректності записів

## Відновлення з резервної копії
pg_restore -U meduser -d medcard medcard_20250417.bak