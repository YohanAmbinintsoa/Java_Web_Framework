/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilitaires;
import java.util.HashMap;

/**
 *
 * @author yohan
 */
public class ModelView {
    String view;
    HashMap<String,Object> data=new HashMap<>();
    
    public void addItem(String key,Object value){
        this.data.put(key,value);
    }
    
    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
    
}
