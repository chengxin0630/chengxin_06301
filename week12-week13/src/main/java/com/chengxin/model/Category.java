package com.chengxin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int categoryId;
    private String categoryName;
    private String description;
    private Boolean active;

    public  Category(){}


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }

    public static List<Category> findAllCategory(Connection con){
        List<Category> list=new ArrayList<Category>();
        String queryString="select * from Category";
        try {
            PreparedStatement statement=con.prepareStatement(queryString);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                Category category=new Category();
                category.setCategoryId(resultSet.getInt("categoryId"));
                category.setCategoryName(resultSet.getNString("CategoryName"));
                category.setDescription(resultSet.getNString("description"));
                category.setActive(resultSet.getBoolean("active"));
                list.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public static String findByCategoryId(Connection con,int categoryId){
        String categoryName=null;
        String sql="select CategoryName from Category where categoryId=?";
        try {
            PreparedStatement statement=con.prepareStatement(sql);
            statement.setInt(1,categoryId);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                categoryName=resultSet.getNString("categoryName");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryName;
    }

}
