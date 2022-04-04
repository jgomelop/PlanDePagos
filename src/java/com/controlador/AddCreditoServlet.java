/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.dao.CreditoDAOLocal;
import com.modelo.Credito;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Pablo
 */
public class AddCreditoServlet extends HttpServlet {

    @EJB
    private CreditoDAOLocal creditoDAO;

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

        String nombreCliente = request.getParameter("nombreCliente");

        String montoInicialStr = request.getParameter("montoInicial");
        double montoInicial = 0;
        if (montoInicialStr != null && !montoInicialStr.equals("")) {
            montoInicial = Double.parseDouble(montoInicialStr);
        }

        String plazoMesesStr = request.getParameter("plazoMeses");
        int plazoMeses = 0;
        if (plazoMesesStr != null && !plazoMesesStr.equals("")) {
            plazoMeses = Integer.parseInt(montoInicialStr);
        }

        String tasaInteresStr = request.getParameter("tasaInteres");
        float tasaInteres = 0;
        if (tasaInteresStr != null && !tasaInteresStr.equals("")) {
            tasaInteres = Float.parseFloat(tasaInteresStr);
        }
        
        Credito credito = new Credito(nombreCliente, montoInicial, plazoMeses, tasaInteres);
        String action=request.getParameter("action");
        if ("Add".equalsIgnoreCase(action)) {
            creditoDAO.addCredito(credito);

        } else if ("Edit".equalsIgnoreCase(action)) {
            creditoDAO.editCredito(credito); 

        } else if ("Delete".equalsIgnoreCase(action)) {
            creditoDAO.deleteCredito(credito.getIdCredito());

        } else if ("Search".equalsIgnoreCase(action)) {
            credito = creditoDAO.getCredito(credito.getIdCredito());
        }

        request.setAttribute("credito", credito);
        request.setAttribute("allCreditos", creditoDAO.getAllCreditos());
        request.getRequestDispatcher("index.jsp").forward(request, response);

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
