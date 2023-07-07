/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Utilitaires.*;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Vector;
import ETU1795.framework.*;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author yohan
 */
@Session
@Scope(type="singleton")
public class Emp {
    String  nom;
    Date dateHeure;
    FileUpload file;
    HashMap<String,Object> session=new HashMap<>();

    @Url(url = "/get-all")
    public ModelView getAll(){
        ModelView view=new ModelView();
        view.setView("lasa.jsp");
        Vector<Emp> all=new Vector<>();
        all.add(new Emp("Rabe"));
        all.add(new Emp("Yohan"));
        view.addItem("list", all);
        return view;
    }
    
    @User(user = "admin")
    @Url(url = "/insertEmp")
    public ModelView save(String id){
        ModelView view=new ModelView();
        view.setView("index.jsp");
        view.addItem("nom", this.getNom());
        view.addItem("id", id);
        return view;
    }
    @Url(url = "/seeSession")
    public ModelView session(){
        ModelView view=new ModelView();
        view.setView("index.jsp");
        for (Map.Entry<String, Object> entry : this.session.entrySet()) {
            view.addItem(entry.getKey(), entry.getValue());
        }
        
        return view;
    }

    @Url(url = "/testJson")
    public ModelView testJson(){
        ModelView view=new ModelView();
        view.addItem("nom", "Yohx");
        view.addItem("prenom", "Yohan");
        view.setJson(true);
        return view;
    }
    
    public Emp(String nom){
        this.setNom(nom);
    }
    
    public Emp(){
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
      public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public FileUpload getFile() {
        return file;
    }

    public void setFile(FileUpload file) {
        this.file = file;
    }

    public HashMap<String, Object> getSession() {
        return session;
    }

    public void setSession(HashMap<String, Object> session) {
        this.session = session;
    }
    
}
