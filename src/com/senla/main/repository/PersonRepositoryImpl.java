package com.senla.main.repository;

import com.senla.main.model.Person;
import com.senla.main.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {
    @Override
    public boolean create(Person person) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO person (username, password, role) VALUES (?,?,?)");
            statement.setString(1, person.getUsername());
            statement.setString(2, person.getPassword());
            statement.setString(3, person.getRole());
            statement.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean check(Person person) {
        int id;
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement =
                    connection.prepareStatement("SELECT id FROM person WHERE username = ? and password = ?");
            statement.setString(1, person.getUsername());
            statement.setString(2, person.getPassword());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
                if (id > 0) {
                    person.setId(id);
                    return true;
                }
            }

            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Person> getAllPersons() {
        return null;
    }

    @Override
    public Person getPerson(Integer id) {
        return null;
    }

    @Override
    public Person update(Person person, Integer id) {
        return null;
    }


}
