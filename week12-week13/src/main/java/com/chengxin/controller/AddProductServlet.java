package com.chengxin.controller;

import com.chengxin.dao.ProductDao;
import com.chengxin.model.Category;
import com.chengxin.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProductServlet", value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        List<Category> categoryList=category.findAllCategory(con);
        request.setAttribute("categoryList",categoryList);
        request.getRequestDispatcher("/WEB-INF/views/admin/addProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName=request.getParameter("productName");
        Double price =request.getParameter("price") !=null? Double.parseDouble(request.getParameter("price")) : 0.0;



        int categoryId =request.getParameter("categoryId") !=null? Integer.parseInt(request.getParameter("categoryId")) : 0;
        String productDescription=request.getParameter("productDescription");

        InputStream inputStream=null;
        Part fillParts=request.getPart("picture");
        if(fillParts != null){
            System.out.println("file name :"+fillParts.getName()+" size"+fillParts.getSize()+" fill type"+fillParts.getSize());
            inputStream=fillParts.getInputStream();
        }
        Product product=new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setProductDescription(productDescription);
        product.setCategoryId(categoryId);
        product.setPicture(inputStream);

        ProductDao productDao=new ProductDao();
        int i=0;
        try {
            i=productDao.save(product,con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("productList");
    }
}
