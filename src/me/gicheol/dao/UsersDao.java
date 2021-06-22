package me.gicheol.dao;

import me.gicheol.domain.Users;

import java.sql.*;
import java.time.LocalDateTime;

public class UsersDao {

    Connection connection = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public int signUp(Users users)  throws ClassNotFoundException, SQLException {

        int checked = 0;

        connection = getConnection();
        pstmt = connection.prepareStatement(
                "INSERT INTO USERS (email, username, password, createdAt) " +
                        "VALUES (?, ?, ?, now())"
        );

        pstmt.setString(1, users.getEmail());
        pstmt.setString(2, users.getUsername());
        pstmt.setString(3, users.getPassword());

        checked = pstmt.executeUpdate();

        finallyClose();

        return checked;
    }

    public Users get(String email) throws ClassNotFoundException, SQLException {
        connection = getConnection();

        pstmt = connection.prepareStatement(
                "SELECT * " +
                        "  FROM USERS " +
                        " WHERE EMAIL = ?");

        pstmt.setString(1, email);

        rs = pstmt.executeQuery();
        rs.next();

        Users user = new Users();
        user.setId(rs.getLong("id"));
        user.setEmail(rs.getString("email"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setCreatedAt(rs.getObject("createdAt", LocalDateTime.class));

        finallyClose();

        return user;
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost/console_project_exam?serverTimezone=Asia/Seoul",
                "examuser", "examuser");
    }

    private void finallyClose() {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
