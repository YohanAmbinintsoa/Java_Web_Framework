/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ETU1795.framework.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import Utilitaires.*;
import ETU1795.framework.Mapping;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yohan
 */
public class FrontServlet extends HttpServlet {
    HashMap<String, Mapping> MappingUrl=new HashMap<>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response,String url)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        if (this.MappingUrl.isEmpty()) {
            try {
                Utils.Init(MappingUrl);
            } catch (Exception e) {
                out.println(e.getMessage());
            }
            
        }
        for (Map.Entry<String, Mapping> entry : MappingUrl.entrySet()) {
            out.println(entry.getKey());
        }
        out.println("djhjsdhjsdhjs");
        try {
            this.render(url, request, response,out);
        } catch (Exception e) {
            out.print(e.getMessage());
        }
        
    }
    
    public void render(String url,HttpServletRequest request,HttpServletResponse response,PrintWriter out) throws Exception{
            if (!this.MappingUrl.containsKey(url)) {
                throw new Exception("Url not found.");
            }
            out.println(this.MappingUrl.get(url).getClassName());
            Class mainClass=Class.forName(this.MappingUrl.get(url).getClassName());
            out.println("print2"+mainClass.getName());
            Constructor construct=mainClass.getConstructor();
            ModelView view=(ModelView)mainClass.getMethod(this.MappingUrl.get(url).getMethod()).invoke(construct.newInstance());
            for (Map.Entry<String, Object> entry : view.getData().entrySet()) {
                request.setAttribute(entry.getKey(),entry.getValue());
            }
            out.println("/"+view.getView());
            request.getRequestDispatcher("/"+view.getView()).forward(request, response);
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
        processRequest(request, response,request.getPathInfo());
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
        processRequest(request, response,request.getPathInfo());
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

