/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.ctrlLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlets.strategy.StrategyHomeUser;

/**
 *
 * @author Manuel
 */
public class loadHomeServlet extends HttpServlet {

    private ctrlLogin _control;

    public loadHomeServlet() {
        _control = new ctrlLogin();
    }


    private enum option {

        LOGIN, LOGOFF, GETHOME
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String opt = request.getParameter("segurityOption").toUpperCase();
            switch (option.valueOf(opt)) {
                case LOGIN:
                    String userName = request.getParameter("userName");
                    String user = _control.login(userName, request.getParameter("pass"));
                    out.println(user);
                    return;
                case LOGOFF:
                    _control.logoff();
                    return;
                case GETHOME:
                    out.println(StrategyHomeUser.getHome(_control.getCurrentUserName()));
                    return;
            }
        } catch (Exception e) {
            response.sendError(401);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
