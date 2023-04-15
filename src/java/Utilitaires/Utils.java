/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilitaires;

import ETU1795.framework.Mapping;
import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Vector;

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
    
    public static Vector<Class> getClassInside(String packageName,String packName) throws Exception{
        
        File file=new File(packageName);
        File[] files=file.listFiles();
        Vector<Class> allclass=new Vector<>();
        for (File file1 : files) {          
            if (file1.isDirectory()) {
                Vector<Class> c=getClassInside(packageName+"/"+file1.getName(),packName);
                for (Class class1 : c) {
                    allclass.add(class1);
                }
            } else {
                if (file1.getName().endsWith(".class")) {
                    String path=packName;
                    if (!packageName.substring(packageName.lastIndexOf("/")+1).equals(packName)) {
                        path=packageName.substring(packageName.indexOf(packName));
                        path=path.replace("/", ".");
                    }
                    Class c=Class.forName(path+"."+file1.getName().substring(0, file1.getName().lastIndexOf(".class")));
                    allclass.add(c);
                }
            }
        }
        return allclass;
    }
    
    public static void Init(HashMap<String,Mapping> map) throws Exception{
        String path=Utils.class.getClassLoader().getResource("").getPath();
        File files=new File(path);
        File[] dir=files.listFiles();
        for (File aPackage : dir) {
            if (aPackage.isDirectory()) {
                 Vector<Class> allclass=Utils.getClassInside(path+aPackage.getName(),aPackage.getName());
                 for (Class allclas : allclass) {
                     Method[] methods=allclas.getDeclaredMethods();
                     for (Method method : methods) {
                         if (method.isAnnotationPresent(Url.class)) {
                             Url u=(Url)method.getAnnotation(Url.class);
                             Mapping mapper=new Mapping();
                             mapper.setClassName(allclas.getName());
                             mapper.setMethod(method.getName());
                             map.put(u.url(),mapper);
                          }
                     }
                 }
            }   
        }
    }
    
}
