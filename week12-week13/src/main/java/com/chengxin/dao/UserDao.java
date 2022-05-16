package com.chengxin.dao;

import com.chengxin.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql="insert into userTable values(?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement("sql ");
        pstmt.setString(1,user.getUsername());
        pstmt.setString(2,user.getPassword());
        pstmt.setString(3,user.getGender());
        pstmt.setString(4,user.getEmail());
        pstmt.setDate(5,new java.sql.Date(user.getBirthdate().getTime()));
        pstmt.executeUpdate();
        return true;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete from userTable where id=?";
        PreparedStatement pstmt=con.prepareStatement("sql ");
        pstmt.setInt(1,user.getId());
        return pstmt.executeUpdate();
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql="update userTable set userName=?,password=?, gender=?, email=?,birthdate=? where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getGender());
        pstmt.setString(4, user.getEmail());
        pstmt.setDate(5, new java.sql.Date(user.getBirthdate().getTime()));
        pstmt.setInt(6,user.getId());

        return pstmt.executeUpdate();
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql="select * from userTable where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1, id.intValue());
        ResultSet rs=pstmt.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username").trim());
            user.setPassword(rs.getString("password").trim());
            user.setGender(rs.getString("gender").trim());
            user.setEmail(rs.getString("email").trim());
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select * from userTable where username=? and password=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs=pstmt.executeQuery();
            User user=null;
            if(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username").trim());
                user.setPassword(rs.getString("password").trim());
                user.setGender(rs.getString("gender").trim());
                user.setEmail(rs.getString("email").trim());
                user.setBirthdate(rs.getDate("birthdate"));
            }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="select * from userTable where username=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,username);
        ResultSet rs=pstmt.executeQuery();

        List<User> userTol=null;
        if(rs.next()){
            userTol=new ArrayList<>();
            User user=new User();
            user=null;
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username").trim());
            user.setPassword(rs.getString("password").trim());
            user.setGender(rs.getString("gender").trim());
            user.setEmail(rs.getString("email").trim());
            user.setBirthdate(rs.getDate("birthdate"));
            userTol.add(user);
        }
        return userTol;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="select * from userTable where password=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,password);
        ResultSet rs=pstmt.executeQuery();

        List<User> userTol=null;
        if(rs.next()){
            userTol=new ArrayList<>();
            User user=new User();
            user=null;
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username").trim());
            user.setPassword(rs.getString("password").trim());
            user.setGender(rs.getString("gender").trim());
            user.setEmail(rs.getString("email").trim());
            user.setBirthdate(rs.getDate("birthdate"));
            userTol.add(user);
        }
        return userTol;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="select * from userTable where email=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,email);
        ResultSet rs=pstmt.executeQuery();

        List<User> userTol=null;
        if(rs.next()){
            userTol=new ArrayList<>();
            User user=new User();
            user=null;
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username").trim());
            user.setPassword(rs.getString("password").trim());
            user.setGender(rs.getString("gender").trim());
            user.setEmail(rs.getString("email").trim());
            user.setBirthdate(rs.getDate("birthdate"));
            userTol.add(user);
        }
        return userTol;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="select * from userTable where gender=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,gender);
        ResultSet rs=pstmt.executeQuery();

        List<User> userTol=null;
        if(rs.next()){
            userTol=new ArrayList<>();
            User user=new User();
            user=null;
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username").trim());
            user.setPassword(rs.getString("password").trim());
            user.setGender(rs.getString("gender").trim());
            user.setEmail(rs.getString("email").trim());
            user.setBirthdate(rs.getDate("birthdate"));
            userTol.add(user);
        }
        return userTol;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql="select * from userTable where birthdate=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setDate(1, new java.sql.Date(birthDate.getTime()));
        ResultSet rs=pstmt.executeQuery();

        List<User> userTol=null;
        if(rs.next()){
            userTol=new ArrayList<>();
            User user=new User();
            user=null;
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username").trim());
            user.setPassword(rs.getString("password").trim());
            user.setGender(rs.getString("gender").trim());
            user.setEmail(rs.getString("email").trim());
            user.setBirthdate(rs.getDate("birthdate"));
            userTol.add(user);
        }
        return userTol;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="select * from userTable";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();

        List<User> userTol=null;
        if(rs.next()){
            userTol=new ArrayList<>();
            User user=new User();
            user=null;
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username").trim());
            user.setPassword(rs.getString("password").trim());
            user.setGender(rs.getString("gender").trim());
            user.setEmail(rs.getString("email").trim());
            user.setBirthdate(rs.getDate("birthdate"));
            userTol.add(user);
        }
        return userTol;
    }
}
