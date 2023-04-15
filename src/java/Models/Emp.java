/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Utilitaires.*;

/**
 *
 * @author yohan
 */
public class Emp {
    @Url(url = "/get-all")
    public ModelView getAll(){
        ModelView view=new ModelView();
        view.setView("lasa.jsp");
        return view;
    }
    @Url(url = "/Rava io")
    public void Insert(){
        
    }
}
