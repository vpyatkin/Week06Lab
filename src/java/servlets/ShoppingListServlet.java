/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vladik
 */
public class ShoppingListServlet extends HttpServlet {


    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username;
        
        ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
        if (items == null)
            items = new ArrayList<>();
        
        System.out.println(items.toString());
        
        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
        } else if (action != null && action.equals("register")) {
            username =  request.getParameter("username");
            session.setAttribute("username", username);
        } else if (action != null && action.equals("add") && !items.contains(request.getParameter("item")) ) {
            items.add(request.getParameter("item"));
            session.setAttribute("items", items);
        } else if (action != null && action.equals("delete")) {
            items.remove(request.getParameter("itemList"));
        }
        
        username = (String) session.getAttribute("username");
        
        System.out.println(username);
        
        if (username != null) {
            request.setAttribute("username", username);
            request.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response); 
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);            
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
