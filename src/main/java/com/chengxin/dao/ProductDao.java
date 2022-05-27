package com.chengxin.dao;

import com.chengxin.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());//inputStream
//            new ByteArrayInputStream(str.getBytes())
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) {
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) {
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException{
        Product product=new Product();
        String sql="select * from Product where productId=?";
        PreparedStatement statement=con.prepareStatement(sql);
        statement.setInt(1,productId);
        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
            product.setProductId(resultSet.getInt("ProductId"));
            product.setProductName(resultSet.getString("ProductName"));
            product.setProductDescription(resultSet.getString("ProductDescription"));
            product.setPrice(resultSet.getDouble("Price"));
            product.setCategoryId(resultSet.getInt("CategoryID"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException{

        List <Product> productList=new ArrayList<Product>();
        String sql="select * from Product where categoryId=?";
        PreparedStatement statement=con.prepareStatement(sql);
        statement.setInt(1,categoryId);
        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
            Product product=new Product();
            product.setProductId(resultSet.getInt("ProductId"));
            product.setProductName(resultSet.getString("ProductName"));
            product.setProductDescription(resultSet.getString("ProductDescription"));
            product.setPrice(resultSet.getDouble("Price"));
            product.setCategoryId(resultSet.getInt("CategoryID"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {

        List <Product> productList=new ArrayList<Product>();
        String sql="select * from Product";
        PreparedStatement statement=con.prepareStatement(sql);
        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
            Product product=new Product();
            product.setProductId(resultSet.getInt("ProductId"));
            product.setProductName(resultSet.getString("ProductName"));
            product.setProductDescription(resultSet.getString("ProductDescription"));
            product.setPrice(resultSet.getDouble("Price"));
            product.setCategoryId(resultSet.getInt("CategoryID"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
    return  null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }
    public  byte[] getPictureById(Integer productId,Connection con) throws  SQLException{
        byte[] imgByte=null;
        String sql="select picture from Product where ProductId=?";
        PreparedStatement statement=con.prepareStatement(sql);
        statement.setInt(1,productId);
        ResultSet rs=statement.executeQuery();
        while(rs.next()){
            Blob blob=rs.getBlob("picture");
            imgByte=blob.getBytes(1,(int)blob.length());
        }
        return imgByte;
    }
}
