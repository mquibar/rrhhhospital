/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import controllers.ctrlAltaLicencia;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class ServletModificarLicencia extends HttpServlet {

    private ctrlAltaLicencia _control;
    private enum operaciones {LOADTH,MODIFICAR,ELIMINAR,GUARDAR}

    public ServletModificarLicencia()
    {
        _control = new ctrlAltaLicencia();
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
                //Función que carga en pantalla los empleado del hospital
                case LOADTH:
                    out.println(_control.getCombo().toString());
                    break;
                //Escribe en la pagina los datos del empleado seleccionado
                case MODIFICAR:
                    response.sendRedirect(_control.getUrlModificar(request.getParameter("valor")));
                    break;
                case ELIMINAR:
                    response.sendRedirect(_control.getUrlEliminar(request.getParameter("valor")));
                    break;
                //Le dice al controlador que actualice al empleado que estaba cargado en la pagina
                case GUARDAR:
                    String res = guardar(request);

                    if(res.toLowerCase().indexOf("error:") != -1)
                    {
                        System.out.println("Servlet: enviando error: " + res);
                        response.sendError(420, res);
                    }
                    else
                    {
                        response.setStatus(200);
                    }

                    break;

                default:
                    out.println("Operacion no valida");
                    break;

         }
        }finally {
            out.close();
        }
    }

    String guardar(HttpServletRequest request)
    {
        String idEntidad = getValue(request, "idEntidad");
        String empleado = getValue(request, "empleado");
        String tipoLicencia = getValue(request, "tipoLicencia");
        String fechaInicio = getValue(request, "fechaInicio");
        String fechaFin = getValue(request, "fechaFin");
        String motivo = getValue(request, "motivo");
        String eliminado = getValue(request, "eliminado");

        String res = _control.guardar(
        idEntidad,
        empleado,
        tipoLicencia,
        fechaInicio,
        fechaFin,
        motivo,
        eliminado);

        return res;
    }

    String getValue(HttpServletRequest request, String varName)
    {
        String varVal = request.getParameter(varName);
        return (varVal) == null ? "" : varVal;
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
