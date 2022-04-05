/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.dao.CreditoDAOLocal;
import com.modelo.Credito;
import java.io.IOException;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Pablo
 */
public class CreditoServlet extends HttpServlet {

    @EJB
    private CreditoDAOLocal creditoDAO;

    String vistaEditarCredito = "vistas/editarCredito.jsp";
    String vistaPlanDePago = "vistas/planDePago.jsp";
    String vistaCrearCredito = "vistas/crearCredito.jsp";
    String index = "index.jsp";

    
    /**
     *
     * @param request
     * @param response
     * @return Instancia de la clase Credito
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Credito crearCreditoDesdeFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String nombreCliente = request.getParameter("nombreCliente");

        String montoInicialStr = request.getParameter("montoInicial");
        BigDecimal montoInicial = new BigDecimal(0);
        if (montoInicialStr != null && !montoInicialStr.equals("")) {
            montoInicial = new BigDecimal(montoInicialStr);
        }

        String plazoMesesStr = request.getParameter("plazoMeses");
        int plazoMeses = 0;
        if (plazoMesesStr != null && !plazoMesesStr.equals("")) {
            plazoMeses = Integer.parseInt(plazoMesesStr);
        }

        String tasaInteresStr = request.getParameter("tasaInteres");
        float tasaInteres = 0;
        if (tasaInteresStr != null && !tasaInteresStr.equals("")) {
            tasaInteres = Float.parseFloat(tasaInteresStr);
        }
        Credito credito = new Credito(nombreCliente, montoInicial, plazoMeses, tasaInteres);

        return credito;
    }

    private Credito editarCreditoDesdeFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String idCreditoStr = request.getParameter("idCredito");
        int idCredito = Integer.parseInt(idCreditoStr);

        String nombreCliente = request.getParameter("nombreCliente");
        String montoInicialStr = request.getParameter("montoInicial");
        BigDecimal montoInicial = new BigDecimal(0);
        if (montoInicialStr != null && !montoInicialStr.equals("")) {
            montoInicial = new BigDecimal(montoInicialStr);
        }

        String plazoMesesStr = request.getParameter("plazoMeses");
        int plazoMeses = 0;
        if (plazoMesesStr != null && !plazoMesesStr.equals("")) {
            plazoMeses = Integer.parseInt(plazoMesesStr);
        }

        String tasaInteresStr = request.getParameter("tasaInteres");
        float tasaInteres = 0;
        if (tasaInteresStr != null && !tasaInteresStr.equals("")) {
            tasaInteres = Float.parseFloat(tasaInteresStr);
        }

        Credito credito = new Credito(idCredito, nombreCliente, montoInicial, plazoMeses, tasaInteres);

        return credito;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String ruta = index;
        String action = request.getParameter("action");

        if ("Crear".equalsIgnoreCase(action)) {
            Credito credito = crearCreditoDesdeFormulario(request, response);
            creditoDAO.addCredito(credito);
            request.setAttribute("credito", credito);
            ruta = index; 
        } else if ("Agregar".equalsIgnoreCase(action)) {
            ruta = vistaCrearCredito;
        } else if ("Detalles".equalsIgnoreCase(action)) {
            String creditoIdStr = request.getParameter("credIdToDetail");
            int creditoId = Integer.parseInt(creditoIdStr);
            Credito credito = creditoDAO.getCredito(creditoId);
            request.setAttribute("credito", credito );
            ruta = vistaPlanDePago;
            
        } else if ("Editar".equalsIgnoreCase(action)) {
            String creditoIdStr = request.getParameter("credIdToEdit");
            int creditoId = Integer.parseInt(creditoIdStr);
            Credito credito = creditoDAO.getCredito(creditoId);
            request.setAttribute("credito", credito);
            ruta = vistaEditarCredito;
        } else if ("Actualizar".equalsIgnoreCase(action)) {
            Credito credito = editarCreditoDesdeFormulario(request, response);
            creditoDAO.editCredito(credito);
            ruta = index;
        } else if ("Eliminar".equalsIgnoreCase(action)) {
            String creditoIdStr = request.getParameter("credIdToDelete");
            int creditoId = Integer.parseInt(creditoIdStr);
            creditoDAO.deleteCredito(creditoId);
            ruta = index;

        } else if ("Regresar".equalsIgnoreCase(action)) {
            ruta = index;
        }

        if (ruta.equalsIgnoreCase(index)) {
            request.setAttribute("allCreditos", creditoDAO.getAllCreditos());
        }
        request.getRequestDispatcher(ruta).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
