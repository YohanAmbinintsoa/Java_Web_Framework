package Models;
import Utilitaires.*;

public class Login {
    String email;
    String mdp;

    @Url(url = "/check-user")
    public ModelView CheckUser(){
        ModelView mod=new ModelView();
        mod.getSession().put("admin",true);
        mod.setView("index.jsp");
        return mod;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }
    
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    
}
