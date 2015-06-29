package tema6;


import Clases.Conf;


import Modulos.GestionGym.GestionClientes.Controlador.controladorgym;

import Modulos.GestionGym.GestionClientes.Vista.Login.Login;
import Modulos.GestionGym.GestionClientes.Vista.Pager.PagerGym;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Controlador.controladorfijos;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Modelo.BLL.BLLBD;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Modelo.DAO.DAOBD;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Vista.PagerFijos;
import javax.swing.JOptionPane;







public class Ppal{

	public static Conf F=null;
	public static void main(String[] args)  {
            Conf f=new Conf();
            Librerias.CLIENTES.xml.abrir_xmlOcultgym();
            //new controladorfijos(new PagerFijos(),0).iniciar(0);
            new controladorgym (new Login(),3).iniciar(3);
            
        }
  }

    
             
            
                    
            
                
                    
               
                    
                    

                    

            
            
       