package com.example.repository;

import com.example.domain.LunchBox;
import com.example.domain.User;
import com.example.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {

    @Autowired
    private DataSource dataSource;


    public String addUser(User user, Person person) throws Exception {
        System.out.println(person.getFirstName());

        String key = "";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement psPerson = conn.prepareStatement("INSERT INTO [dbo].[Person](FirstName, LastName, PhoneNumber) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
             PreparedStatement ps = conn.prepareStatement("INSERT INTO [dbo].[User](UserID, UserName, Password, Mail)VALUES (?,?,?,?)");
        ){

             psPerson.setString(1, person.getFirstName());
             psPerson.setString(2, person.getLastName());
             psPerson.setString(3, person.getPhoneNumber());

             psPerson.executeUpdate();

            ResultSet genKeys = psPerson.getGeneratedKeys();
            if (genKeys.next()) {
                key = genKeys.getString(1);
            }


            ps.setString(1, key);
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getMail());


            ps.executeUpdate();

            return key;

        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public List<User> getUsers() {
        try(Connection conn = dataSource.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [dbo].[User]")) {
            ArrayList<User> users = new ArrayList<>();
            while(resultSet.next()) {
                users.add(rsUser(resultSet));
            }
            return users;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return null;

    }



    public User rsUser (ResultSet resultset) throws SQLException {
        return new User(
                resultset.getInt(1),
                resultset.getString(2),
                resultset.getString(3),
                resultset.getString(4));
    }

    public List<Person> getPersons() {
        try(Connection conn = dataSource.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [dbo].[Person]")) {
            ArrayList<Person> persons = new ArrayList<>();
            while(resultSet.next()) {
                persons.add(rsPerson(resultSet));
            }
            return persons;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    private Person rsPerson(ResultSet resultSet) throws SQLException {
        return new Person(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4));
    }

    public List<LunchBox> getLunchBoxes() {
        try(Connection conn = dataSource.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [dbo].[LunchBox]")) {
            ArrayList<LunchBox> lunchBoxes = new ArrayList<>();
            while(resultSet.next()) {
                lunchBoxes.add(rsLunchBox(resultSet));
            }
            return lunchBoxes;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private LunchBox rsLunchBox(ResultSet resultSet) throws SQLException {
        return new LunchBox(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getLong(4),
                resultSet.getLong(5),
                resultSet.getBoolean(6),
                resultSet.getBoolean(7),
                resultSet.getBoolean(8),
                resultSet.getBoolean(9),
                resultSet.getBoolean(10),
                resultSet.getBoolean(11),
                resultSet.getBoolean(12),
                resultSet.getBoolean(13),
                resultSet.getInt(14),
                resultSet.getInt(15)
        );

    }
}





