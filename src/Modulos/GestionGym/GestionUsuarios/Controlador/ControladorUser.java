/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionUsuarios.Controlador;

import Clases.fecha;
import Modulos.ClasesMadre.persona;
import Modulos.GestionGym.GestionClientes.Controlador.controladorgym;
import static Modulos.GestionGym.GestionClientes.Controlador.controladorgym.Alta;
import static Modulos.GestionGym.GestionClientes.Controlador.controladorgym.Login;
import static Modulos.GestionGym.GestionClientes.Controlador.controladorgym.Pagergym;
import static Modulos.GestionGym.GestionClientes.Controlador.controladorgym.modifica;
import Modulos.GestionGym.GestionClientes.Modelo.BLL.BLLBDGYM;
import Modulos.GestionGym.GestionClientes.Modelo.BLL.BLLGYM;
import Modulos.GestionGym.GestionClientes.Modelo.Clases.Arraylistgym;
import Modulos.GestionGym.GestionClientes.Vista.Altagym;
import Modulos.GestionGym.GestionClientes.Vista.Login.Login;
import Modulos.GestionGym.GestionClientes.Vista.Pager.PagerGym;
import Modulos.GestionGym.GestionClientes.Vista.Pager.modificagym;
import Modulos.GestionGym.GestionUsuarios.Modelo.BLL.BLLBDUs;
import Modulos.GestionGym.GestionUsuarios.Modelo.DAO.DAOUs;
import Modulos.GestionGym.GestionUsuarios.Vista.AltaUs;

import Modulos.GestionGym.GestionUsuarios.Vista.PagerUsuarios.STM;
import Modulos.GestionGym.GestionUsuarios.Vista.PagerUsuarios.pagina;
import Modulos.GestionGym.GestionUsuarios.Vista.RootMenu;
import Modulos.GestionGym.GestionUsuarios.Vista.VistaAdmin;
import Modulos.GestionGym.GestionUsuarios.Vista.modificauser;
import Utils.Menus;
import Utils.Validacion;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import static java.awt.Color.green;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;

import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Borja Alventosa
 */
public  class ControladorUser  implements ActionListener, KeyListener, MouseListener, FocusListener{
    
    public static VistaAdmin VAdmin =  new VistaAdmin();
    public static modificauser modifica = new modificauser();
    public static RootMenu rootmenu=new RootMenu();
    public static AltaUs Alta=new AltaUs();
            
    
    public static TableRowSorter<TableModel> sorter =new TableRowSorter<TableModel>(new STM());
    ImageIcon a = new ImageIcon("src/img/cancel.png");
    Image cancelar = a.getImage();
    ImageIcon cancel = new ImageIcon(cancelar);
    
    
    ImageIcon okey = new ImageIcon("src/img/ok.png");
    Image oke = okey.getImage();
    ImageIcon ok = new ImageIcon(oke);
    
    ImageIcon vacio = new ImageIcon("src/img/buit.png");
    Image vaci = vacio.getImage();
    ImageIcon buit = new ImageIcon(vaci);
    
    public ControladorUser(JFrame frm, int i) {

        switch (i) {
            case 0:
                VAdmin = (VistaAdmin) frm;
                break;
            case 1: 
                rootmenu=(RootMenu) frm;
                break;
            case 2: 
                modifica=(modificauser) frm;
                break;
            case 3: 
                Alta=(AltaUs) frm;
                
        }
    }

    

   


    
     public enum Accion {
         
         
         _BTN_TANCAR,
        _BTN_ANTERIOR,
        _BTN_SEGUENT,
        _BTN_PRIMER,
        _BTN_ULTIM,
        _CMB_ENTRADESMOSTRADES,
        _BTN_AFEGIR,
        _BTN_MODIFICAR,
        _BTN_ELIMINAR,
        _BTN_JSON,
        _BTN_TXT,
        _BTN_XML,
        _BTN_TORNAR,
        //ROOt MENU
        _BTN_ListaCli,
        _BTN_ListaUs,
        //MODIFICA USER
        _BTN_ACEPTARM,
        _BTN_VOLVERM,
        //ALTA USER
        _BTN_ACEPTARA,
        _BTN_VOLVERA
        
     }
      public  void iniciar(int i) {
          switch (i) {

            case 0: // Finestra Vista Administrador Usuarios

                VAdmin.setTitle("Gimnasio");
                VAdmin.setVisible(true);
                VAdmin.setResizable(false);
                VAdmin.setLocationRelativeTo(null);
               VAdmin.listaus.setModel(new STM());
                ((STM) VAdmin.listaus.getModel()).cargar();
               VAdmin.listaus.setFillsViewportHeight(true);
                VAdmin.listaus.setRowSorter(sorter);

                pagina.inicializa();
                pagina.initLinkBox();

                VAdmin.addWindowListener(new WindowAdapter() {
                   @Override
                    public void windowClosing(WindowEvent e) {
                    }
                });

                // combo mostrar nombre d'entrades per pàgina
                VAdmin.cmbEntradesMostrades.setActionCommand("_CMB_ENTRADESMOSTRADES");
                VAdmin.cmbEntradesMostrades.setName("_CMB_ENTRADESMOSTRADES");
                VAdmin.cmbEntradesMostrades.addActionListener(this);
                // botó primer registre
                VAdmin.primero.setActionCommand("_BTN_PRIMER");
                VAdmin.primero.setName("_BTN_PRIMER");
                VAdmin.primero.addActionListener(this);
                // botó darrer registre
                VAdmin.ultimo.setActionCommand("_BTN_ULTIM");
                VAdmin.ultimo.setName("_BTN_ULTIM");
                VAdmin.ultimo.addActionListener(this);
                // botó següent registre
                VAdmin.SIGUIENTE.setActionCommand("_BTN_SEGUENT");
                VAdmin.SIGUIENTE.setName("_BTN_SEGUENT");
                VAdmin.SIGUIENTE.addActionListener(this);
                // botó anterior registre
                VAdmin.ANTERIOR.setActionCommand("_BTN_ANTERIOR");
                VAdmin.ANTERIOR.setName("_BTN_ANTERIOR");
                VAdmin.ANTERIOR.addActionListener(this);
                // botó tancar finestra
                /*VAdmin.btnTancar.setActionCommand("_BTN_TANCAR");
                VAdmin.btnTancar.setName("_BTN_TANCAR");
                VAdmin.btnTancar.addActionListener(this);
*/
                // botó afegir registre
                VAdmin.btCrearUs.setActionCommand("_BTN_AFEGIR");
                VAdmin.btCrearUs.setName("_BTN_AFEGIR");
                VAdmin.btCrearUs.addMouseListener(this);
                // botó modificar registre
                VAdmin.modificarus.setActionCommand("_BTN_MODIFICAR");
                VAdmin.modificarus.setName("_BTN_MODIFICAR");
                VAdmin.modificarus.addMouseListener(this);
                // botó eliminar registre
                VAdmin.Eliminarus.setActionCommand("_BTN_ELIMINAR");
                VAdmin.Eliminarus.setName("_BTN_ELIMINAR");
                VAdmin.Eliminarus.addMouseListener(this);
                // botó guardar TXT
                VAdmin.btnTXT1.setActionCommand("_BTN_TXT");
                VAdmin.btnTXT1.setName("_BTN_TXT");
                VAdmin.btnTXT1.addMouseListener(this);
                // botó guardar JSON
                VAdmin.btnJSON1.setActionCommand("_BTN_JSON");
                VAdmin.btnJSON1.setName("_BTN_JSON");
                VAdmin.btnJSON1.addMouseListener(this);
                // botó guardar XML
                VAdmin.btnXML1.setActionCommand("_BTN_XML");
                VAdmin.btnXML1.setName("_BTN_XML");
                VAdmin.btnXML1.addMouseListener(this);
                
                // Filtre
                //VAdmin.txtFiltre.setActionCommand("_TXT_FILTRE");
                //VAdmin.txtFiltre.setName("_TXT_FILTRE");
                //VAdmin.txtFiltre.addKeyListener(this);
                //BOTO VOLVER
                VAdmin.btnvolverad.setActionCommand("_BTN_TORNAR");
                VAdmin.btnvolverad.setName("_BTN_TORNAR");
                VAdmin.btnvolverad.addMouseListener(this);
                //
                VAdmin.listaus.setName("_TAULA");
                VAdmin.listaus.addMouseListener(this);
                
                break;
            case 1:
                //Finestra de ROOT MENU
                rootmenu.setVisible(true);
                rootmenu.setResizable(false);
                rootmenu.setLocationRelativeTo(null);
                rootmenu.btListaCli.setActionCommand("_BTN_ListaCli");
                rootmenu.btListaCli.setName("_BTN_ListaCli");
                rootmenu.btListaCli.addActionListener(this);
                
                rootmenu.btListaUs.setActionCommand("_BTN_ListaUs");
                rootmenu.btListaUs.setName("_BTN_ListaUs");
                rootmenu.btListaUs.addActionListener(this);
                break;
            case 2 : //ModificaUSEr
                modifica.setVisible(true);
                modifica.setResizable(false);
                modifica.setLocationRelativeTo(null);
                
                modifica.btnAceptar.setActionCommand("_BTN_ACEPTARM");
                modifica.btnAceptar.setName("_BTN_ACEPTARM");
                modifica.btnAceptar.addActionListener(this);
                
                modifica.btnCancelar.setActionCommand("_BTN_TORNAR");
                modifica.btnCancelar.setName("_BTN_TORNAR");
                modifica.btnCancelar.addActionListener(this);
             break;
            case 3:
                //ALTA USER
                Alta.setVisible(true);
                Alta.setResizable(false);
                Alta.setLocationRelativeTo(null);
                Alta.btnAceptar.setActionCommand("_BTN_ACEPTARA");
                Alta.btnAceptar.setName("_BTN_ACEPTARA");
                Alta.btnAceptar.addActionListener(this);
                
                Alta.btnVolver.setActionCommand("_BTN_TORNAR");
                Alta.btnVolver.setName("_BTN_TORNAR");
                Alta.btnVolver.addActionListener(this);
                
      }
      }
    @Override
       public void actionPerformed(ActionEvent ae) {
        switch (Accion.valueOf(ae.getActionCommand())) {
            
            
            //FINESTRA MODIFCA USER
            case _BTN_ACEPTARM:
                DAOUs.ObtenUser();
                break;
            //Finestra ROOT MENU
            case _BTN_ListaCli:
                rootmenu.dispose();
                new controladorgym(new PagerGym(), 0).iniciar(0);
                break;
            case _BTN_ListaUs:
                new ControladorUser(new VistaAdmin(), 0).iniciar(0);
                rootmenu.dispose();
                break;
            // Finestra FrmInterfaceEF
            case _BTN_ANTERIOR:
                pagina.currentPageIndex -= 1;
                pagina.initLinkBox();
                //tablafijos.addRowSelectionInterval(0, 0);
                break;
            case _BTN_TORNAR:
                DAOUs.MiraTipo();
                VAdmin.dispose();
                Alta.dispose();
                modifica.dispose();
                new ControladorUser(new RootMenu(),1).iniciar(1);
                      //  modificauser.dispose();
               // new controladorgym(new RootMenu(),1).iniciar(1);
                     break;         
            case _BTN_SEGUENT:
                pagina.currentPageIndex += 1;
                pagina.initLinkBox();
                //tablafijos.addRowSelectionInterval(0, 0);
                break;
            case _BTN_ULTIM:
                pagina.currentPageIndex = pagina.maxPageIndex;
                pagina.initLinkBox();
                //tablafijos.addRowSelectionInterval(0, 0);
                break;
            case _BTN_PRIMER:
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                //tablafijos.addRowSelectionInterval(0, 0);
                break;
            case _CMB_ENTRADESMOSTRADES:
               pagina.itemsPerPage = Integer.parseInt(VistaAdmin.cmbEntradesMostrades.getSelectedItem().toString());
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
               
                break;
          /*  
            case _BTN_TANCAR1:
                Alta.setEnabled(true);
                Alta.dispose();
                break;
            case _BTN_TANCAR2:
                Alta.setEnabled(true);
                modifica.dispose();
                break;
            case _BTN_CANCELAR1:
                this.cancelarEFA();
                break;
            case _BTN_CANCELAR2:
      
    */
        }
        }
    @Override
         public void mouseClicked(MouseEvent me) {
        int selec;
        switch (controladorgym.Accion.valueOf(me.getComponent().getName())) {
            // Finestra FrmInterfaceEF
            case _BTN_XML:
                
                BLLGYM.guardaOcultoXML();
                break;
            case _BTN_JSON:
                //guardarArxiuJSONEFBLL();
                break;
            case _BTN_TXT:
                BLLGYM.guardaOcultoTXT();
                break;
            case _BTN_AFEGIR:
                //selec = posicioAbsoluta();
                Pagergym.dispose();
                //if (selec == -1) {
                //} else {
                    Alta.setEnabled(false);
                    if((Arraylistgym.tipo==1)||(Arraylistgym.tipo==2))
                            {
                    new ControladorUser(new AltaUs(),1).iniciar(1);
            }else {
                        JOptionPane.showMessageDialog(null,"No tiene permisos para acceder");
                    }
                //}
                break;
            case _BTN_MODIFICAR:
              if((Arraylistgym.tipo==1)||(Arraylistgym.tipo==2))
                            {  
                selec = posicioAbsoluta();
                
                if (selec == -1) {
                } else {
                   String dni = (String) Pagergym.tablagym.getModel().getValueAt(selec, 6);
                   Arraylistgym.o = new persona(dni,"");
                    BLLGYM.ObtenSeleccionadoCompleto();
                    Pagergym.setEnabled(false);
                    new controladorgym(new modificagym(), 2).iniciar(2);
                    Pagergym.dispose();
                    Pagergym.setVisible(false);
                }
                            }
              if(Arraylistgym.tipo==0){
                  
                  new controladorgym(new modificagym(),2).iniciar(2);
              }
              
                break;
            case _BTN_ELIMINAR:
                
                selec = posicioAbsoluta();
                if (selec == -1) {
                     Menus.warning("Selecciona primer", "Atenció!");
                     selec= ((Modulos.GestionGym.GestionUsuarios.Vista.Pager.STM)VAdmin.tablaus.getModel()).getRowCount();
                     JOptionPane.showMessageDialog(null,"POSICION:"+selec);
                } else {
                    //
                    String email = (String) VAdmin.tablaus.getModel().getValueAt(selec, 6);
                    Arraylistgym.o= new persona(email,"");
                    JOptionPane.showMessageDialog(null,email);
                    VAdmin.dispose();
                    BLLGYM.EliminaFijo();
                    BLLBDGYM.EliminaCliBD();
                    BLLGYM.guardaOcultoTXT();
                    BLLGYM.guardaOcultoXML();
                    BLLGYM.refrescatabla();
                     
                }
                break;
            case _TAULA:
                Pagergym.tablagym = (JTable) me.getSource();
                Point point = me.getPoint();
                int row = Pagergym.tablagym.rowAtPoint(point);
                if (me.getClickCount() == 2) {
                    int sel = posicioAbsoluta();
                    String dni = (String) Pagergym.tablagym.getModel().getValueAt(sel, 6);
                    Arraylistgym.o = new persona(dni,"");
                    Alta.setEnabled(false);
                    new controladorgym(new modificagym(), 2).iniciar(2);
                }
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        switch (controladorgym.Accion.valueOf(me.getComponent().getName())) {
            // Finestra FrmInterfaceEF 
            case _BTN_XML:
                //CreaEmpFijoFrame.btnXML.setText("<html><b><font color=green >XML</font><b></html>");
                break;
            case _BTN_JSON:
                //CreaEmpFijoFrame.btnJSON.setText("<html><b><font color=green >JSON</font><b></html>");
                break;
            case _BTN_TXT:
                //CreaEmpFijoFrame.btnTXT.setText("<html><b><font color=green >TXT</font><b></html>");
                break;
            case _BTN_AFEGIR:
                //Alta.btnAlta.setIcon(afegir1);
                break;
            case _BTN_MODIFICAR:
                //Alta.btnModificar.setIcon(editar1);
                break;
            case _BTN_ELIMINAR:
                //Alta.btnEliminar.setIcon(eliminar1);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        switch (controladorgym.Accion.valueOf(me.getComponent().getName())) {
            // Finestra FrmInterfaceEF
            case _BTN_XML:
                //CreaEmpFijoFrame.btnXML.setText("<html><b><font color=black>XML</font><b></html>");
                break;
            case _BTN_JSON:
                //CreaEmpFijoFrame.btnJSON.setText("<html><b><font color=black>JSON</font><b></html>");
                break;
            case _BTN_TXT:
                //CreaEmpFijoFrame.btnTXT.setText("<html><font color=black>TXT</font></html>");
                break;
            case _BTN_AFEGIR:
                //CreaEmpFijoFrame.btnAfegir.setIcon(afegir2);
                break;
            case _BTN_MODIFICAR:
                //CreaEmpFijoFrame.btnModificar.setIcon(editar2);
                break;
            case _BTN_ELIMINAR:
                //CreaEmpFijoFrame.btnEliminar.setIcon(eliminar2);
                break;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent kt) {
        switch (controladorgym.Accion.valueOf(kt.getComponent().getName())) {
            case _TXT_NOM1:
                this.validarNomA();
                break;
             case _TXT_DNI1:
                this.validarDni();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent kp) {
        switch (controladorgym.Accion.valueOf(kp.getComponent().getName())) {
            case _TXT_DNI1:
                this.validarDni();
                break;
            case _TXT_NOM1:
                this.validarNomA();
                break;
            case _TXT_SALARIBASE1:
               // this.validarSalariA();
                break;
            case _DATA_NAIXEMENT2:
                //modifica.btnGuardar.requestFocus();
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //mostrar rdos de filtrar empezando por botón primero, enlace 1
        switch (controladorgym.Accion.valueOf(ke.getComponent().getName())) {
            case _TXT_FILTRE:
                try {
                    Modulos.GestionGym.GestionClientes.Vista.Pager.pagina.currentPageIndex = 1;
                    //((STM) tablafijos.getModel()).filtrar();
                   // if (tablafijos.getRowCount() > 0) {
                       // tablafijos.addRowSelectionInterval(0, 0);
                    //}
                } catch (Exception e) {
                }
                break;
            case _TXT_DNI1:
                this.validarDni();
                break;
            case _TXT_NOM1:
                this.validarNomA();
                break;
            case _TXT_NOM2:
                this.validarNomM();
                break;
            case _TXT_SALARIBASE1:
               // this.validarSalariA();
                break;
            case _TXT_SALARIBASE2:
                //this.validarSalariM();
                break;
        }
    }

    @Override
    public void focusGained(FocusEvent evt) {
        switch (controladorgym.Accion.valueOf(evt.getComponent().getName())) {
            case _TXT_DNI1:
                Alta.etidni.setForeground(green);
                break;
            case _TXT_NOM1:
                Alta.etinombre.setForeground(green);
                break;
            case _TXT_SALARIBASE1:
                //CreaEmpFijoFrame.txtSalariBase.setForeground(verd);
                break;
            case _TXT_NOM2:
                modifica.etinom.setForeground(green);
                break;
            case _TXT_SALARIBASE2:
                //frmModiEF.txtSalariBase.setForeground(verd);
                break;
        }
    }

    @Override
    public void focusLost(FocusEvent evt) {
        switch (controladorgym.Accion.valueOf(evt.getComponent().getName())) {
            case _TXT_DNI1:
                Alta.etidni.setForeground(Color.BLACK);
                this.validarDni();
                break;
            case _TXT_NOM1:
                Alta.etinombre.setForeground(Color.BLACK);
                break;
            case _TXT_NOM2:
                modifica.etinom.setForeground(Color.BLACK);
                break;
            case _TXT_SALARIBASE1:
                //CreaEmpFijoFrame.txtSalariBase.setForeground(Color.BLACK);
                break;
            case _TXT_SALARIBASE2:
                //frmModiEF.txtSalariBase.setForeground(Color.BLACK);
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    private int posicioAbsoluta() {
        int n, selection, inicio, selection1 = 0;
        n = ((Modulos.GestionGym.GestionClientes.Vista.Pager.STM) Pagergym.tablagym.getModel()).getRowCount();
        if (n != 0) {
            inicio = (Modulos.GestionGym.GestionClientes.Vista.Pager.pagina.currentPageIndex ) * Modulos.GestionGym.GestionClientes.Vista.Pager.pagina.itemsPerPage;//Despues del currentPageIndex habia un -1; dins del parentesis
            selection = Pagergym.tablagym.getSelectedRow();
            selection1 = inicio + selection;
        } else {
            selection1 = -1;
        }
        return selection1;
    }

    /**
     * personalitzem l'ample de les columnes
     */
    private void setAmpleColumnes() {
        JViewport scroll = (JViewport) Pagergym.tablagym.getParent();
        int ample = scroll.getWidth();
        int ampleColumna = 0;
        TableColumnModel modelColumna = Pagergym.tablagym.getColumnModel();
        TableColumn columnaTaula;
        for (int i = 0; i < Pagergym.tablagym.getColumnCount(); i++) {
            columnaTaula = modelColumna.getColumn(i);
            switch (i) {
                case 0:
                    ampleColumna = (17 * ample) / 100;
                    break;
                case 1:
                    ampleColumna = (30 * ample) / 100;
                    break;
                case 2:
                    ampleColumna = (18 * ample) / 100;
                    break;
                case 3:
                    ampleColumna = (18 * ample) / 100;
                    break;
                case 4:
                    ampleColumna = (17 * ample) / 100;
                    break;
            }
            columnaTaula.setPreferredWidth(ampleColumna);
        }
    }

    private void validarNomA() {
        
        if (Alta.etinombre.getText().isEmpty()) {
            Alta.lblbApe.setIcon(buit);
        } else {
            if (Validacion.validaNombre(Alta.etinombre.getText())) {
                Altagym.lblbNom.setIcon(ok);
                //Altagym.etifalloNombre.setVisible(false);
            } else {
                Altagym.lblbNom.setIcon(cancel);
                //Altagym.etifalloNombre.setVisible(true);
            }
        }
    }

    private void validarNomM() {
        if (modifica.etinom.getText().isEmpty()) {
            modifica.lblNom.setIcon(buit);
            
        } else {
            if (Validacion.validaNombre(modifica.etinom.getText())) {
                modifica.lblNom.setIcon(ok);
            } else {
                modifica.lblNom.setIcon(cancel);
            }
        }
    }

   /* private boolean validarSalariA() {
        if (CreaEmpFijoFrame.txtSalariBase.getText().isEmpty()) {
            CreaEmpFijoFrame.lblbSalariBase.setIcon(buit);
        } else {
            if (!Validate.isValidFormatNombre(CreaEmpFijoFrame.txtSalariBase.getText())) {
                CreaEmpFijoFrame.lblbSalariBase.setIcon(cancel);
                CreaEmpFijoFrame.txtSalariBase.requestFocus();
            } else {
                CreaEmpFijoFrame.lblbSalariBase.setIcon(ok);
                return true;
            }
        }
        return false;
    }
*/
    /**
     * valida el dni en el frm afegir
     */
    private void validarDni() {
        if (Alta.etidni.getText().isEmpty()) {
            
            Altagym.lblbDni.setIcon(buit);
        } else {
            if (Validacion.DNI(Alta.etidni.getText())) { // valida si té un format de dni-nie
                Altagym.lblbDni.setIcon(ok);
                Altagym.etifalloDNI.setVisible(false);
            } else {
                //CreaEmpFijoFrame.txtDni.setText(Funcions.nifnie(CreaEmpFijoFrame.txtDni.getText())); // canvia la lletra de dni si és incorrecta
            Altagym.lblbDni.setIcon(cancel);
            Altagym.etifalloDNI.setVisible(true);
            }
        }
    }
   /*  if (Alta.etinombre.getText().isEmpty()) {
            Alta.lblbNom.setIcon(buit);
        } else {
            if (Validacion.validaNombre(Alta.etinombre.getText())) {
                CreaEmpFijoFrame.lblbNom.setIcon(ok);
                CreaEmpFijoFrame.etifalloNombre.setVisible(false);
            } else {
                CreaEmpFijoFrame.lblbNom.setIcon(cancel);
                CreaEmpFijoFrame.etifalloNombre.setVisible(true);
            }
        }*/
/*
    private void demanaSalariA() {
        // Salari Base
        if (CreaEmpFijoFrame.txtSalariBase.getText().isEmpty()) {
            CreaEmpFijoFrame.lblbSalariBase.setIcon(buit);
        } else {
            if (!Validate.isValidFormatNombre(CreaEmpFijoFrame.txtSalariBase.getText())) { // valida si té un format
                CreaEmpFijoFrame.lblbSalariBase.setIcon(cancel);
            } else {
                CreaEmpFijoFrame.lblbDni.setIcon(ok);
                CreaEmpFijoFrame.btnGuardar.requestFocus();
            }
        }
    }

    private void demanaSalariM() {
        // Salari Base
        if (FrmModiEF.txtSalariBase.getText().isEmpty()) {
            FrmModiEF.lblbSalariBase.setIcon(buit);
        } else {
            if (!Validate.isValidFormatNombre(FrmModiEF.txtSalariBase.getText())) { // valida si té un format
                FrmModiEF.lblbSalariBase.setIcon(cancel);
            } else {
                FrmModiEF.lblbDni.setIcon(ok);
                FrmModiEF.btnGuardar.requestFocus();
            }
        }
    }
*/
    /**
     * una vegada validat, busca si està o no repetit si no ho està, torna a
     * validar, abans de seguir, per si hem fet algun canvi
     */
    private void demanaDni() {
        
        int pos = BLLGYM.BuscaSoloPorDni(Altagym.etidni.getText()); // busca duplicats del dni
        if (pos != -1) {
            
            //CreaEmpFijoFrame.lblbDni.setIcon();
           // Menus.warning("DNI ja donat d'alta!", "Empleat Fix");
        } else {
            if (Validacion.DNI(Altagym.etidni.getText())) {
                Altagym.lblbDni.setIcon(ok);
                Altagym.etinombre.requestFocus();
            } else {
                Altagym.lblbDni.setIcon(cancel);
            }
        }
    }
/*
    private boolean validarSalariM() {
        if (FrmModiEF.txtSalariBase.getText().isEmpty()) {
            FrmModiEF.lblbSalariBase.setIcon(buit);
        } else {
            if (!Validate.isValidFormatNombre(FrmModiEF.txtSalariBase.getText())) {
                FrmModiEF.lblbSalariBase.setIcon(cancel);
            } else {
                FrmModiEF.lblbSalariBase.setIcon(ok);
                return true;
            }
        }
        return false;
    }
*/
    /**
     * ompli els camps en frm modificar
     *
     * @param ef
     */
    /*
    private void omplirCampsM(EmpleatFix ef) {
        float soubase1 = ef.getSoubase();
        float soubase2 = soubase1 * Core.conf.getFactorconv();
        float sou1 = ef.getSou();
        float sou2 = sou1 * Core.conf.getFactorconv();
        FrmModiEF.txtDni.setText(ef.getDni());
        FrmModiEF.txtNom.setText(ef.getNom());
        FrmModiEF.DateDataNaixement.setDate(Data.datatodate(ef.getDatanaixement()));
        FrmModiEF.DateDatacontratacio.setDate(Data.datatodate(ef.getDatacontratacio()));
        FrmModiEF.txtSalariBase.setText("" + soubase2);
        FrmModiEF.lblEdat.setText("" + ef.getEdat());
        FrmModiEF.lblAntiguitat1.setText("" + ef.getAntiguitat());
        FrmModiEF.lblAntiguitat2.setText("" + ef.getPercent());
        FrmModiEF.lblSalari.setText(Format.formatConfig(sou2, Core.conf));
        FrmModiEF.lblbDni.setIcon(buit);
        FrmModiEF.lblbNom.setIcon(buit);
        FrmModiEF.lblbDnaixement.setIcon(buit);
        FrmModiEF.lblbDcontratacio.setIcon(buit);
        FrmModiEF.lblbSalariBase.setIcon(buit);
    }
*/
    public static void cancelarEFA() {
        Altagym.etinombre.setText(null);
        Altagym.etidni.setText(null);
        Altagym.etinac.setCalendar(null);
        
        //CreaEmpFijoFrame.txtSalariBase.setText(null);
        //CreaEmpFijoFrame.etiedad.setText(null);
        //CreaEmpFijoFrame.lblSalari.setText(null);
       // CreaEmpFijoFrame.lblbDni.setIcon(buit);
        //CreaEmpFijoFrame.lblbNom.setIcon(buit);
        //CreaEmpFijoFrame.lblbSalariBase.setIcon(buit);
        //CreaEmpFijoFrame.lblbDnaixement.setIcon(buit);
        //CreaEmpFijoFrame.lblbDcontratacio.setIcon(buit);
        //CreaEmpFijoFrame.lblAntiguitat1.setText(null);
        //CreaEmpFijoFrame.lblAntiguitat2.setText(null);
        Altagym.etidni.requestFocus();
    }

    private persona guardarM() {
        persona ef = null;
        int difer = 0;
        int antiguitat = 0;
        int edat = 0;
        float soubase = 0.0f;
        float sou = 0.0f;
        float percent = 0.0f;
        String nom = "";
        String dni = "";
        fecha datanaixement = null;
        fecha datacontratacio = null;

        // si els camps no tenen dades
        if (modifica.etinom.getText().isEmpty()) {
            modificagym.lblNom.setIcon(cancel);
        }
        if (modifica.etinac.getDate() == null) {
            //modifica.lblbNaixement.setIcon(cancel);
        }
        //if (odifica.eticon.getDate() == null) {
           //modifica.lblbContractacio.setIcon(cancel);
        //}
        //if (FrmModiEF.txtSalariBase.getText().isEmpty()) {
          //  FrmModiEF.lblbSalariBase.setIcon(cancel);
        

        if (Validacion.validaNombre(modifica.etinom.getText())) {
            modifica.lblNom.setIcon(ok);
        } else {
            modifica.lblNom.setIcon(ok);
            nom = modifica.etinom.getText();
        }

        // Data naixement
        

            // si el JDateChooser torna un String
            String dn = ((JTextFieldDateEditor) modifica.etinac.getDateEditor()).getText();
            datanaixement = new fecha(dn);

            // si el JDateChooser torna un Date()   
           // datanaixement = new fecha((FrmConfig.DateDataNaixement.getDate()));
            
/*  
            if (edat < 16) {
                modifica.lblbNaixement.setIcon(cancel);
               // Menus.warning("Ha de ser major de 16 anys", "Atenció");
            } else {
               modifica.lblbNaixement.setIcon(ok);
               // FrmModiEF.lblEdat.setText("" + edat);
            }
        } catch (Exception ex) {
            //FrmModiEF.lblbDnaixement.setIcon(cancel);
        }

        // Data contratacio
        try {
            String contra=((JTextFieldDateEditor)modifica.eticon.getDateEditor()).getText();
            datacontratacio = new fecha(((JTextFieldDateEditor)modifica.eticon.getDateEditor()).getText());
            modifica.lblbContractacio.setIcon(ok);
        } catch (Exception ex) {
            modifica.lblbContractacio.setIcon(cancel);
        }
        try {
            difer = datanaixement.restafechas();
            if (difer >= 16) { // difer
                antiguitat = datacontratacio.restafechas();
                modifica.lblbNaixement.setIcon(ok);
                
                modifica.lblAntiguitat1.setText(Integer.toString(antiguitat));
                
                modifica.lblbContractacio.setIcon(ok);
            }
        } catch (Exception ex) {
            modifica.lblbContractacio.setIcon(cancel);
        }

        // Salari Base   
        /*
        try {
            soubase = Float.parseFloat(FrmModiEF.txtSalariBase.getText());
            if (soubase >= 0) {
                sou = soubase * (1 + (percent / 100));
                FrmModiEF.lblSalari.setText(Format.formatConfig(sou, Core.conf));
                FrmModiEF.lblbSalariBase.setIcon(ok);
            } else {
                soubase = 1 / 0;
            }
        } catch (Exception ex) {
            FrmModiEF.lblbSalariBase.setIcon(cancel);
            FrmModiEF.lblSalari.setText(null);
        }
*/
        if ((modifica.lblNom.getIcon().equals(ok)))
                //&& //(FrmModiEF.lblbSalariBase.getIcon().equals(ok))
                 //(modifica.lblbContractacio.getIcon().equals(ok))
               // && (modifica.lblbNaixement.getIcon().equals(ok))) {
            dni = modifica.etidni.getText();
            //if (Menus.confirmar("Guardar les dades?", "Guardar")) {
                BLLGYM.ModificaCliPager();
            //}
        
        return ef;
    }

    /**
     * guarda l'objecte ef en el frm afegir
     *
     * @return un objecte EmpleatFix
     */
    private persona guardarA() {
        int difer = 0;
        int antiguitat = 0;
        int edat = 0;
        float soubase = 0.0f;
        float sou = 0.0f;
        float percent = 0.0f;
        String nom = "";
        String dni = "";
        fecha datanaixement = null;
        fecha datacontratacio = null;

        if (Altagym.etidni.getText().isEmpty()) {
            Altagym.lblbDni.setIcon(cancel);
        }
        if (Altagym.etinombre.getText().isEmpty()) {
            Altagym.lblbApe.setIcon(cancel);
        }
        if (Altagym.etinac.getDate() == null) {
            Altagym.lblbNaixement.setIcon(cancel);
        }
       
        //if (Altagym.txtSalariBase.getText().isEmpty()) {
          //  Altagym.lblbSalariBase.setIcon(cancel);
        //}

        if (Validacion.validaNombre(Altagym.etinombre.getText())) {
           Altagym.lblbApe.setIcon(cancel);
        } else {
            Altagym.lblbApe.setIcon(ok);
            nom = Altagym.etinombre.getText();
        }

        dni = Altagym.etidni.getText();
        if (Validacion.DNI(dni)) {
            Altagym.lblbDni.setIcon(cancel);
        } else {
            int pos = BLLGYM.BuscaSoloPorDni(dni);
            if (pos != -1) {
                Altagym.lblbDni.setIcon(cancel);
                Menus.warning("DNI ja donat d'alta!", "Cliente");
            } else {
                Altagym.lblbDni.setIcon(ok);
                //Altagym.txtDni.setText(Funcions.nifnie(dni));
            }
        }

        // Data naixement
        try {

            // si el JDateChooser torna un String
            String dn = ((JTextFieldDateEditor) Altagym.etinac.getDateEditor()).getText();
            datanaixement = new fecha(dn);

            // si el JDateChooser torna un Date()   
           // datanaixement = new fecha((FrmConfig.DateDataNaixement.getDate()));
            edat = datanaixement.restafechas();
            if (edat < 16) {
               // Altagym.lblbDnaixement.setIcon(cancel);
                Menus.warning("Ha de ser major de 16 anys", "Atenció");
            } else {
                Altagym.lblbNaixement.setIcon(ok);
                //Altagym.lblEdad.setText("" + edat);
            }
        } catch (Exception ex) {
            Alta.lblbNaixement.setIcon(cancel);
        }

        // Data contratacio
       
        try {
            difer = datanaixement.restafechas();
            if (difer >= 16) { // difer
                antiguitat = datacontratacio.restafechas();
                
                //Altagym.lblbContractacio.setIcon(ok);
            }
        } catch (Exception ex) {
            //Altagym.lblbContractacio.setIcon(cancel);
        }

        // Salari Base        
        /*try {
            soubase = Float.parseFloat(Altagym.txtSalariBase.getText());
            if (soubase >= 0) {
                sou = soubase * (1 + (percent / 100));
                Altagym.lblSalari.setText(Format.formatConfig(sou, Core.conf));
                Altagym.lblbSalariBase.setIcon(ok);
            } else {
                soubase = 1 / 0;
            }
        } catch (Exception ex) {
            Altagym.lblbSalariBase.setIcon(cancel);
            Altagym.lblSalari.setText(null);
        }
*/
        if ((Altagym.lblbDni.getIcon().equals(ok))
                && (Altagym.lblbApe.getIcon().equals(ok))
                && //(Altagym.lblbSalariBase.getIcon().equals(ok))
                 //(Altagym.lblbContractacio.getIcon().equals(ok))
                 (Altagym.lblbNaixement.getIcon().equals(ok))) {

            if (dni != null) {
                int pos = BLLGYM.BuscaSoloPorDni(dni);
                if (pos != -1) {
                    Altagym.lblbDni.setIcon(cancel);
                    Menus.warning("DNI ja donat d'alta!", "Cliente");
                } else {
                    if (Menus.confirmar("Guardar les dades?", "Guardar")) {
                        BLLGYM.creaCli();
                    }
                }
            }
        }
        return ef;
    }
}

