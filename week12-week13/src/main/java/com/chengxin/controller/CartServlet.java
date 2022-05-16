package com.chengxin.controller;

import com.chengxin.dao.ProductDao;
import com.chengxin.model.Item;
import com.chengxin.model.Product;
import org.omg.CosNaming.BindingIterator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session != null && session.getAttribute("user") != null){
            if (request.getParameter("action") == null){
                try {
                    displayCart(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(request.getParameter("action").equals("add")){
                try {
                    buy(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if (request.getParameter("action").equals("remove")){
                try {
                    remove(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void buy(HttpServletRequest request,HttpServletResponse response) throws  Exception{
        HttpSession session =request.getSession();
        int id =request.getParameter("productId") != null? Integer.parseInt(request.getParameter("productId")) : 0;
        int quantity=request.getParameter("quantity") != null ?Integer.parseInt(request.getParameter("quantity")) : 1;
        ProductDao productDao=new ProductDao();
        if(session.getAttribute("cart") == null){
            List<Item> cart=new ArrayList<Item>();

            Product product=productDao.findById(id,con);
            cart.add(new Item(product,quantity));
            session.setAttribute("cart",cart);

        }else{
            List<Item> cart=(List<Item>) session.getAttribute("cart");
            int index = isExisting(id,cart);
            if(index == -1){
                cart.add(new Item(productDao.findById(id,con),1));
            }else{
                int quantityTem =cart.get(index).getQuantity()+1;
                cart.get(index).setQuantity(quantityTem);
            }
            session.setAttribute("cart",cart);
        }

        response.sendRedirect(request.getContextPath()+"/cart");
    }
    private  void remove(HttpServletRequest request,HttpServletResponse response) throws Exception{
        HttpSession session=request.getSession();
        List<Item> cart=(List<Item>) session.getAttribute("cart");
        int id = 0;
        if(request.getParameter("productId") != null){
            id= Integer.parseInt(request.getParameter("productId"));
        }
        int index =isExisting(id,cart);
        cart.remove(index);
        session.setAttribute("cart",cart);
        response.sendRedirect(request.getContextPath()+"/cart");
    }
    private int isExisting(int id,List<Item> cart){
        for(int i=0;i < cart.size();i++){
            if(cart.get(i).getProduct().getProductId() == id){
                return i;
            }
        }
        return -1;
    }
    private void displayCart(HttpServletRequest request,HttpServletResponse response) throws  Exception{
        request.setAttribute("message","Your Cart");
        request.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request,response);
    }


}
