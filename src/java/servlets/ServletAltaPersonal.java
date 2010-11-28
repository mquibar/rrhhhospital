/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import controllers.ctrlAltaPersonal;
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
public class ServletAltaPersonal extends HttpServlet {
   
    private ctrlAltaPersonal _control;
    private enum operaciones {
        LOAD,ESPECIFICA, ALTAEMPLEADO,ALTAPROFESIONAL
    }

    public ServletAltaPersonal() {
        _control = new ctrlAltaPersonal();
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
            String option = request.getParameter("operacion").toUpperCase();
            System.out.println(option);
            switch (operaciones.valueOf(option)) {
                //Inicia los tipos de empleados
                case LOAD:
                    System.out.println("entra al servlet");
                    out.println(_control.getModels("TIPO").toString());
                    break;
                case ESPECIFICA:
                    response.sendRedirect(_control.iniciar(request.getParameter("valor")));
                    break;

                //Le dice al controlador que guarde al empleado que estaba cargado en la pagina
                case ALTAEMPLEADO:
                    _control.iniciarAltaEmpleado(
                                    request.getParameter("nombre"),
                                    request.getParameter("apellido"),
                                    request.getParameter("dni"),
                                    request.getParameter("fechaNacimiento"),
                                    request.getParameter("telefono"),
                                    request.getParameter("barrio"),
                                    request.getParameter("calle"),
                                    request.getParameter("numero"),
                                    request.getParameter("piso"),
                                    request.getParameter("departamento"),
                                    request.getParameter("localidad"),
                                    request.getParameter("provincia"),
                                    request.getParameter("pais"),
                                    request.getParameter("sexo"),
                                    request.getParameter("cuil"),
                                    request.getParameter("tarjeta"));
                    break;
                //Le dice al controlador que guarde al profesional que estaba cargado en la pagina
                case ALTAPROFESIONAL:
                    _control.iniciarAltapRrofesional(
                                    request.getParameter("nombre"),
                                    request.getParameter("apellido"),
                                    request.getParameter("dni"),
                                    request.getParameter("fechaNacimiento"),
                                    request.getParameter("telefono"),
                                    request.getParameter("barrio"),
                                    request.getParameter("calle"),
                                    request.getParameter("numero"),
                                    request.getParameter("piso"),
                                    request.getParameter("departamento"),
                                    request.getParameter("localidad"),
                                    request.getParameter("provincia"),
                                    request.getParameter("pais"),
                                    request.getParameter("sexo"),
                                    request.getParameter("cuil"),
                                    request.getParameter("matricula"),
                                    request.getParameter("titulo"),
                                    request.getParameter("tarjeta"));
                    break;
                default:
                    out.println("algo");
                    break;

            }
        } catch(Exception e) {

              out.println("Error: " +e.getMessage());
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
