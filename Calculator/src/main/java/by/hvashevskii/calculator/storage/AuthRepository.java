package by.hvashevskii.calculator.storage;

import java.sql.*;

public class AuthRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/calculator";
    private static final String USER = "root";
    private static final String PASSWORD = "1111";

    private static final String CHECK_AUTH = "select * from users where login = ? and password = ?";

    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkAuth(String login, String password) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement(CHECK_AUTH);

            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) result = true;

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Сломались на аутентификации Пользователя!");
        }
        return result;
    }

}
