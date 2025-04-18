## Підготовка до оновлення
- Повне резервне копіювання бази
- Перевірка сумісності нової версії
- Повідомлення користувачів

## Резервне копіювання
- Створити резервну копію БД: pg_dump -U meduser -F c medcard > medcard_backup.bak

## Планування простою
- Очікувана зупинка: ~5-10 хвилин

## Процес оновлення
- Зупинити застосунок
- Змінити/оновити .jar файл
- Застосувати оновлення до БД, якщо є (ALTER TABLE, INSERT, ...)
- Оновити конфігурації
- Перезапустити застосунок

## Перевірка після оновлення
- Запуск без помилок
- Перевірка основних функцій (авторизація, перегляд даних, додавання записів, редагування записів)

## Відкат (rollback)
- Зупинити застосунок
- Відновити попередню версію коду
- Відновити БД з резервної копії: pg_restore -U meduser -d medcard medcard_backup.bak