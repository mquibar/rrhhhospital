/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manuel
 */
public class menuServlet extends HttpServlet {

    private enum optionsMenu {

        PERSONAL_MNU1, PERSONAL_MNU2, PERSONAL_MNU3,
        HORARIO_MNU1, HORARIO_MNU2, HORARIO_MNU3,
        SEGUIMIENTO_MNU1, SEGUIMIENTO_MNU2, SEGUIMIENTO_MNU3, SEGUIMIENTO_MNU4, SEGUIMIENTO_MNU5,
        REPORTE_MNU1, REPORTE_MNU2, REPORTE_MNU3, REPORTE_MNU4, REPORTE_MNU5,GOHOME
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
            String option = request.getParameter("opMenu").toUpperCase();
            String url = "underContruction.html";
            switch (optionsMenu.valueOf(option)) {
                case PERSONAL_MNU1:
                    url="gestionar_personal.html";
                    break;
                case PERSONAL_MNU2:
                    url="Consultar_Persona.html";
                    break;
                case PERSONAL_MNU3:
                case HORARIO_MNU1:
                    url="manejoHorarios/gestionar.jsp?nombreEntidad=tipo_horario";
                    break;
                case HORARIO_MNU2:
                case HORARIO_MNU3:
                    break;
                case SEGUIMIENTO_MNU1:
                    url="gestionar_categoria.html";
                    break;
                case SEGUIMIENTO_MNU2:
                    url="gestionar_departamento.html";
                    break;
                case SEGUIMIENTO_MNU3:
                    url="Recategorizacion_Final.jsp";
                    break;
                case SEGUIMIENTO_MNU4:
                case SEGUIMIENTO_MNU5:
                    break;
                case REPORTE_MNU1:
                    url="Reportes_Personal.html";
                    break;
                case REPORTE_MNU2:
                    url="Reportes_Horarios.html";
                    break;
                case REPORTE_MNU3:
                    url="Reportes_Seguimiento.html";
                    break;
                case REPORTE_MNU4:
                    url="Reportes_Departamento.html";
                    break;
                case REPORTE_MNU5:
                    url="Reportes_Usuarios.html";
                    break;
                case GOHOME:
                    System.out.println("ACa Entro");
                    url="undeContruction.html";
                    break;
                default:
                    url="underContruction.html";
            }
            out.println(url);
        } catch (Exception e) {
            response.sendRedirect("underContruction.jsp");
            out.close();
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
