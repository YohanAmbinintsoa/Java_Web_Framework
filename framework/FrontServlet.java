/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ETU1795.framework.servlet;

import jakarta.servlet.*;
import java.io.*;
import jakarta.servlet.http.*;
import Utilitaires.*;
import ETU1795.framework.Mapping;
import ETU1795.framework.FileUpload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.MultipartConfig;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.lang.model.element.Element;

/**
 *
 * @author yohan
 */
@MultipartConfig
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
            Class mainClass=Class.forName(this.MappingUrl.get(url).getClassName());
            Constructor construct=mainClass.getConstructor();
            Object instance=construct.newInstance();
            out.println("Aonaaa");
            this.sendData(request, instance,out);
            out.println("Yeeeee");
            Method met=mainClass.getMethod(this.MappingUrl.get(url).getMethod(),this.MappingUrl.get(url).getParams());
            Object[] parameters=this.getArgs(request, met);
            ModelView view=(ModelView)met.invoke(instance,parameters);
            for (Map.Entry<String, Object> entry : view.getData().entrySet()) {
                request.setAttribute(entry.getKey(),entry.getValue());
            }
            request.getRequestDispatcher("/"+view.getView()).forward(request, response);
    }

    public void sendData(HttpServletRequest request,Object c,PrintWriter out) throws Exception{
            Field[] fields=c.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String element=field.getName();
                out.println(request.getParameter(element));
                if (!field.getType().equals(FileUpload.class)) {
                    if (request.getParameter(element)!=null) {
                        Method method=c.getClass().getDeclaredMethod("set"+Utils.capitalize(element),field.getType());
                        Object data=request.getParameter(element);
                        if (field.getType().equals(java.util.Date.class)) {
                            out.println(element);
                            SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd");
                            data=format.parse((String)data);
                        } else if(field.getType().equals(Date.class)){
                            SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd");
                            java.util.Date temp=format.parse((String)data);
                            data=new Date(temp.getTime());
                        }
                        method.invoke(c, field.getType().cast(data));
                        out.println("Not file Upload");
                    }
                } else {
                    out.println(request.getParameter(element));
                    // for(Part part : request.getParts()){
                    //     System.out.println("PN: "+ part.getName());
                    //     Collection<String> headers = part.getHeaders("content-disposition");
                    //     if (headers == null)
                    //         continue;
                    //     for(String header : headers){
                    //         out.println("CDH: " + header);                  
                    //     } 
                    // }
                    try {
                        Part filePart=request.getPart(element);
                        out.println(filePart);
                        FileUpload upload=new FileUpload();
                        upload.setNom(filePart.getSubmittedFileName()); 
                        InputStream inputStream = filePart.getInputStream();
                        upload.setData(inputStream.readAllBytes());
                        Method method=c.getClass().getDeclaredMethod("set"+Utils.capitalize(element),field.getType());
                        method.invoke(c, upload);
                        out.println("File upload");
                    } catch (Exception e) {
                        
                    }
                    
                }
        }        
    }
    public Object[] getArgs(HttpServletRequest req,Method met) throws Exception{
        Object[] args=new Object[met.getParameterCount()];
        if (req.getParameterNames().hasMoreElements()==true) {
            Parameter[] params=met.getParameters();
            for (Parameter parameter : params) {
                String name=parameter.getName();
                int i=0;
                if (req.getParameter(name)!=null) {
                    args[i]=parameter.getType().cast(req.getParameter(name));
                    i+=1;
                }
            }
        }
        return args;
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
}

