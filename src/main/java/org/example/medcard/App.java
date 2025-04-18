package org.example.medcard;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.medcard.Models.Model;
import org.slf4j.Logger;

public class App extends Application {
    private static final Logger logger = LoggerService.getLogger(App.class);

    @Override
    public void start(Stage stage) {
        logger.info("Запуск застосунку");
        try {
            Model.getInstance().getViewFactory().showLoginWindow();
            logger.info("Інтерфейс завантажено успішно");
        } catch (Exception e) {
            logger.error("Помилка при запуску застосунку: {}", e.getMessage(), e);
        }
    }

    @Override
    public void stop() {
        logger.info("Застосунок завершив роботу");
    }
}