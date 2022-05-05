package by.hvashevskii.calculator.entity;

import by.hvashevskii.calculator.storage.AuthRepository;

public class AuthService {

    public static boolean checkAuth(String username, String password) {
        return AuthRepository.checkAuth(username, password);
    }

}
