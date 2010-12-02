/*
 * Servlet encargado de la comunicacion con ajax, entre
 * los distintos controladores y la pantalla de modificar personal
 */

package servlets;


import controllers.ctrlModificarEmpleado;
import controllers.ctrlModificarPersona;
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
public class ServletModificarPersonal extends HttpServlet {
   
    private ctrlModificarPersona _control;
    private enum operaciones {
        LOAD,NUEVO,GUARDAREMP,GUARDARPROF
    }

    public ServletModificarPersonal() {
        _control = new ctrlModificarPersona();
    }

    /* Servlet que realiza toda la logica de la pantalla de modificar_personal
     * para la correcta modificacion del empleado
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String option = request.getParameter("operacion").toUpperCase();
            System.out.println(option);
            switch (operaciones.valueOf(option)) {
                //Función que carga en pantalla los empleado del hospital
                case LOAD:
                    out.println(_control.getEmpleados().toString());
                    break;
                //Escribe en la pagina los datos del empleado seleccionado
                case NUEVO:
                    response.sendRedirect(_control.recuperarDato(request.getParameter("valor")));
                    break;
                //Le dice al controlador que actualice al empleado que estaba cargado en la pagina
                case GUARDAREMP:
                    _control.guardarEmpleado(
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
                                    request.getParameter("cuil"));
                    break;
                //Le dice al controlador que actualice al profesional que estaba cargado en la pagina
                case GUARDARPROF:
                    _control.guardarProfesional(
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
                                    request.getParameter("titulo"));
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
