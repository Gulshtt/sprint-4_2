package db;

import models.Item;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5434/postgres",
                    "postgres",
                    "postgres"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM items"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                items.add(item);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public static void addItem(Item item) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO ITEMS(name, description, price) " +
                            "VALUES(?, ?, ?)"
            );
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addUser(String email, String password, String full_name) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users(email, password, full_name) " +
                            "VALUES(?, ?, ?)"
            );
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, full_name);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Long chekUser(String email, String password) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                        "SELECT id FROM users WHERE email = ? AND password = ?"
        );
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            return resultSet.getLong("id");
        }
        return null;
    }

    public static User getUser(Long id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM users WHERE id = ?"
        );
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return new User(resultSet.getLong("id"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            resultSet.getString("full_name"));
    }

    public static Item getItemById(Long id) {
        Item item = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM ITEMS WHERE id = ?"
            );
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    public static void editItem(Item item) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE ITEMS SET NAME = ?, DESCRIPTION = ?, PRICE =? " +
                            "WHERE ID = ?"
            );
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setLong(4, item.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
