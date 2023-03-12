/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilitaires;

/**
 *
 * @author yohan
 */
public class Utils {
    public static String[] retrieveURLPart(String url){
        if (url==null) {
            String[] part={"/"};
            return part;
        }
        return url.split("/");
    }
}

