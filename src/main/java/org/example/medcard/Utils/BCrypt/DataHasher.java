package org.example.medcard.Utils.BCrypt;

import org.mindrot.jbcrypt.BCrypt;

public class DataHasher {
    // Хешує пароль для зберігання в базі
    public static String hashData(String plainData) {
        return BCrypt.hashpw(plainData, BCrypt.gensalt(12));
    }

    // Перевіряє пароль користувача з хешем з бази
    public static boolean checkData(String plainData, String hashedData) {
        return BCrypt.checkpw(plainData, hashedData);
    }
}
