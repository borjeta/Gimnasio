/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionUsuarios.Modelo.DAO;

import Modulos.ClasesMadre.persona;
import Modulos.GestionGym.GestionClientes.Controlador.controladorgym;
import static Modulos.GestionGym.GestionClientes.Controlador.controladorgym.Login;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Arraylistgym;
import Modulos.GestionGym.GestionClientes.Modelo.DAO.DAOGYM;
import Modulos.GestionGym.GestionClientes.Vista.Login.Login;
import Modulos.GestionGym.GestionClientes.Vista.Pager.PagerGym;
import Modulos.GestionGym.GestionClientes.Vista.Pager.pagina;
import Modulos.GestionGym.GestionUsuarios.Modelo.Clases.user;
import Modulos.GestionGym.GestionUsuarios.Vista.AltaUs;
import Modulos.GestionGym.GestionUsuarios.Vista.RootMenu;
import Modulos.GestionGym.GestionUsuarios.Vista.VistaAdmin;
import javax.swing.JOptionPane;

/**
 *
 * @author Borja Alventosa
 */
public class DAOUs {
    public static boolean ValidapassLogin(user a){
        boolean val=false;
        
       String pass=a.getPassword();
       String pass1=Login.etiPass.getText();
       JOptionPane.showMessageDialog(null,"Esto es lo que has escrito:"+pass1+"\n Esto es lo que recoge del singleton:"+pass);
       if(pass.equalsIgnoreCase(pass1)==true){
           val=true;
       }
        return val;
    }
    public static void MiraTipo(){
        String email=Login.etiLogin.getText();
        user o =new user(email,"");
        int pos=DAOUs.BuscaUser(o);
            if(pos!=-1){
                JOptionPane.showMessageDialog(null,"Se ha encontrado el usuario en la base de datos");
            }
            /*
        if(Arraylistgym.gym.get(pos).getTipo().equalsIgnoreCase("user"));
        {
        JOptionPane.showMessageDialog(null,"USUARIO CLIENTE");
                    new controladorgym(new PagerGym(), 0).iniciar(0);
                    Arraylistgym.tipo=0;
                    Login.dispose();
        }      
         if(Arraylistgym.gym.get(pos).getTipo().equalsIgnoreCase("Admin")){
                    JOptionPane.showMessageDialog(null,"Administrador");
                   // new ControladorUs(new RootMenu(),0).iniciar(0);
                    Arraylistgym.tipo=1;
                    Login.dispose();
                }
            else {
                    //JOptionPane.showMessageDialog(null,"USUARIO ADMINISTRADOR");
                    Arraylistgym.tipo=2;
                    Login.dispose();
                }
                
                
                 */
            Login.dispose();
        
        
    }
    public static int BuscaUser(user ef){
        //Buscar
		int aux=-1;
		
		for (int i = 0; i<=(Arraylistgym.us.size()-1); i++){
			if((Arraylistgym.us.get(i)).equals(ef))//buclea hasta que encuentra un email que concuadre con el comparator de la madre y lo devuelve como aux
				aux=i;
		}
		return aux;//retorna aux, si lo ha encontrado dara la posicion, si no devolvera -1 lo cual significa que no hay email que concuadre
	
    }
    public static void cargarEnVolver(){
        if(VistaAdmin.btnvolverad.isSelected()==true){
            
        };
    }
    public static void ObtenSelecionado(){
        if (PagerGym.tablagym.getModel().getRowCount() != 0) {
           
             int inicio=(pagina.currentPageIndex-1)*pagina.itemsPerPage;
              int selec = PagerGym.tablagym.getSelectedRow();
              JOptionPane.showMessageDialog(null,selec);
                int selection1=inicio+selec;
                
    
            if (selec == -1) {
                //
            } else {
                String dni = (String) PagerGym.tablagym.getModel().getValueAt(selec, 6);
                
                JOptionPane.showMessageDialog(null,dni);
                Arraylistgym.o = new persona(dni,"");
                
            }
    }
  }
    public static void CargaSingletonEliminar(){
        DAOGYM.ObtenSelecionado();
        DAOUs.BuscaUser()
    }
    public static user ObtenUser(){
        String login=Modulos.GestionGym.GestionClientes.Vista.Login.Login.etiLogin.getText();
        String pass=Modulos.GestionGym.GestionClientes.Vista.Login.Login.etiPass.getText();
        return new user(login,pass);
    }
    public static user ObtenUserSignin(){
        String nom=AltaUs.etinom.getText();
        String dni=AltaUs.etidni.getText();
        String Login=AltaUs.etilogin.getText();
        String tipo=AltaUs.etitipo.getText();
        user o=new user(nom,Login,dni,tipo,"1234");
                //String nombre, String Login, String DNI, String tipo,String password)
    return o;
    }
    
}
