package com.example.repository;

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

    public void addUser(User user, Person person) throws Exception {
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
                resultset.getString(2),
                resultset.getString(3),
                resultset.getString(4));
    }

}





