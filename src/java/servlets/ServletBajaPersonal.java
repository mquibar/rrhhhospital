/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import controllers.ctrlBajaPersonal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MARIANO
 */
public class ServletBajaPersonal extends HttpServlet {
   
    private ctrlBajaPersonal _control;

    public ServletBajaPersonal() {
        _control = new ctrlBajaPersonal();
    }

    /* Servlet que realiza toda la logica de la pantalla de baja_personal.jsp
     * para la correcta eliminacion del empleado
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if (request.getParameter("darbaja") != null) {
                out.println(_control.darBaja(request.getParameter("darbaja")));
            }   else {
                    if(request.getParameter("mostrardatos")!=null){
                        out.println(_control.recuperarDato(request.getParameter("mostrardatos")));
                    }   else {
                           out.println(_control.getEmpleados().toString());
                        }
            }
        } catch(Exception e) {
            out.println("<option> algo no anda </option>");
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
