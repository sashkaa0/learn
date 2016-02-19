/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlle.SearchController;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */

public class SavePdf extends HttpServlet {

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
            throws ServletException {
        OutputStream out=null;
        try{
            response.setContentType("application/pdf");
            out = response.getOutputStream();
            try{
               int id=Integer.valueOf(request.getParameter("id_book"));
                Boolean save=Boolean.valueOf(request.getParameter("save"));
                String filename=request.getParameter("filename");
                SearchController sc=(SearchController) request.getSession(false).getAttribute("searchController");
                byte[]content=sc.getContent(id);
                response.setContentLength(content.length);
                System.out.println("Save        "+save);
                if(save){
                      response.setHeader("Content-Disposition", "attachment:filename="+URLEncoder.encode(filename,"UTF-8")+".pdf");
                }
                out.write(content);
            }catch(Exception ex){
                ex.printStackTrace();
            }finally{
                out.close();
            }
        }catch(IOException ex){
            Logger.getLogger(SavePdf.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(SavePdf.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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