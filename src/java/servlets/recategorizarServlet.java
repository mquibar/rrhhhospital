/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import controllers.ctrlRecategorizacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan
 */
public class recategorizarServlet extends HttpServlet {
   
    private ctrlRecategorizacion _control;
    public recategorizarServlet(){
        _control = new ctrlRecategorizacion();
    }

    private enum operaciones{INICIAR, AGRUPAMIENTO, TRAMO, CATEGORIA_POSIBLE, CATEGORIA_TODO, CLASE, GUARDAR}

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
            String opera = request.getParameter("operacion").toUpperCase();
            switch( operaciones.valueOf(opera)){
                case INICIAR:
                    out.println(_control.iniciarCU().toString());
                    break;
                case AGRUPAMIENTO:
                    out.println(_control.listarAgrupamientos().toString());
                    break;
                case TRAMO:
                    out.println(_control.listarTramo(request.getParameter("agrupamiento")).toString());
                    break;
                case CATEGORIA_POSIBLE:
                    out.println(_control.listarCategorias(request.getParameter("tramo"), request.getParameter("empleado")).toString());
                    break;
                case CATEGORIA_TODO:
                    out.println(_control.listarCategorias(request.getParameter("tramo")).toString());
                    break;
                case CLASE:
                    out.println(_control.listarClases(request.getParameter("categoria")).toString());
                    break;
                case GUARDAR:
                    _control.guardarRecategorizar(request.getParameter("categoria"), request.getParameter("clase"));
                    break;
                default:
                    response.sendError(404);
            }
        } catch(Exception e) {
            response.sendError(409);
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
