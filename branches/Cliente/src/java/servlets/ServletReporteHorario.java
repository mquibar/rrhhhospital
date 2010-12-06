/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import controllers.ctrlReporte;
import controllers.ctrlReporteHorario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Administrador
 */
public class ServletReporteHorario extends HttpServlet {

    private enum operaciones {
        Cronograma_Asignado_por_Empleado,MODIFICAR,ELIMINAR,GUARDAR}

    ctrlReporteHorario _control;

    public ServletReporteHorario()
    {
        _control = new ctrlReporteHorario();
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
            String option = request.getParameter("operacion");
            System.out.println(option);

            JasperPrint jp = _control.getReporteHorario(
                    getValue(request, "empleado"),
                    getValue(request, "fechaInicio"),
                    getValue(request, "fechaFin"),
                    getValue(request, "operacion"));

            ctrlReporte d = new ctrlReporte();

            byte[] b = d.armarReporte(jp);
            response.setContentType("application/pdf");
            response.setContentLength(b.length);

            ServletOutputStream sos = response.getOutputStream();
            sos.write(b, 0, b.length);
            sos.flush();
            sos.close();
        }finally {
            out.close();
        }
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
