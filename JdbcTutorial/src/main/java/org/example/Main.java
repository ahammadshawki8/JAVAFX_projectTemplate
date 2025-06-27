package org.example;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = createDataSource();

        try {
//            Connection connection = DriverManager.getConnection("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:users.sql';");
            Connection connection = dataSource.getConnection();
            System.out.println("Connected to database successfully: " + connection.isValid(0));

            // CRUD
            // select
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM USERS WHERE NAME = ?");
            ps.setString(1, "Macro");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " - " + resultSet.getString("NAME"));
            }

            // insert
            PreparedStatement insertPs = connection.prepareStatement("INSERT INTO USERS (name) VALUES (?);");
            insertPs.setString(1, "John");
            int insertCount = insertPs.executeUpdate();
            System.out.println("Inserted " + insertCount + " records into USERS");

            // update
            PreparedStatement updatePs = connection.prepareStatement("UPDATE USERS SET name = ? WHERE name = ?");
            updatePs.setString(1, "Johnny");
            updatePs.setString(2, "John");
            int updateCount = updatePs.executeUpdate();
            System.out.println("Updated " + updateCount + " records of USERS");

            // delete
            PreparedStatement deletePs = connection.prepareStatement("DELETE FROM USERS WHERE name = ?");
            deletePs.setString(1, "Johnny");
            int deleteCount = deletePs.executeUpdate();
            System.out.println("Deleted " + deleteCount + " records of USERS");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DataSource createDataSource() {
        // HikaryCP
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:users.sql'");
        return ds;

    }
}