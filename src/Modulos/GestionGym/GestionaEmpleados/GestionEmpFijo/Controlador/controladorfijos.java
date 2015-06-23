/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Controlador;

import Clases.fecha;
import Modulos.GestionGym.GestionClientes.Controlador.controladorgym;
import Modulos.GestionGym.GestionUsuarios.Vista.RootMenu;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.BLL.BLLBD;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.BLL.BLLEFgraf;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.STM;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.pagina;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Vista.CreaEmpFijoFrame;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Vista.PagerFijos;
import static Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Vista.PagerFijos.tablafijos;
import Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Vista.modificafijo;
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
public class controladorfijos implements ActionListener, KeyListener, MouseListener, FocusListener{
    

    public  static PagerFijos Pagerfijos = new PagerFijos();
    public static CreaEmpFijoFrame Crear=new CreaEmpFijoFrame();
    public static modificafijo modifica= new modificafijo();
    public static TableRowSorter<TableModel> sorter =new TableRowSorter<TableModel>(new STM());
    
    private EmpFijo ef = null;
    
       
    ImageIcon a = new ImageIcon("src/img/cancel.png");
    Image cancelar = a.getImage();
    ImageIcon cancel = new ImageIcon(cancelar);
    
    
    ImageIcon okey = new ImageIcon("src/img/ok.png");
    Image oke = okey.getImage();
    ImageIcon ok = new ImageIcon(oke);
    
    ImageIcon vacio = new ImageIcon("src/img/buit.png");
    Image vaci = vacio.getImage();
    ImageIcon buit = new ImageIcon(vaci);
    
    
    

    public controladorfijos(JFrame frm, int i) {

        switch (i) {
            case 0:
                Pagerfijos = (PagerFijos) frm;
                break;
            case 1:
                Crear = (CreaEmpFijoFrame) frm;
                
                break;
            case 2:
                modifica = (modificafijo) frm;
                break;
        }
    }

    private void siEditables() {
        Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Vista.modificafijo.etinom.setEditable(true);
        Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Vista.modificafijo.etinac.setEnabled(true);
        Modulos.GestionGym.GestionaEmpleados.GestionEmpFijo.Vista.modificafijo.eticon.setEnabled(true);
        //Modulos.GestionaEmpleados.GestionEmpFijo.Vista.modificafijo.txtSalariBase.setEditable(true);
    }

    public enum Accion {

        // Finestra FrmInterfaceEF
        _TXT_FILTRE,
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
        _TAULA,
        _VOLVER,
        // Finestra FrmAlta
        _BTN_GUARDAR1,
        _BTN_CANCELAR1,
        _BTN_TANCAR1,
        _TXT_NOM1,
        _TXT_DNI1,
        _TXT_SALARIBASE1,
        // Finestra FrmModi
        _BTN_GUARDAR2,
        _BTN_CANCELAR2,
        _BTN_TANCAR2,
        _TXT_NOM2,
        _TXT_DNI2,
        _TXT_SALARIBASE2,
        _DATA_NAIXEMENT2,
        _confirmar
        

    }

    public  void iniciar(int i) {
       


        switch (i) {

            case 0: // Finestra FrmInterfaceEF

                Pagerfijos.setTitle("Empleat Fix");
                Pagerfijos.setVisible(true);
                Pagerfijos.setResizable(false);
                Pagerfijos.setLocationRelativeTo(null);

                Pagerfijos.tablafijos.setModel(new STM());
                ((STM) Pagerfijos.tablafijos.getModel()).cargar();
               Pagerfijos.tablafijos.setFillsViewportHeight(true);
                Pagerfijos.tablafijos.setRowSorter(sorter);
                
                //Pagerfijos.tablafijos.addRowSelectionInterval(0, 0); // seleccionem la primera fila 

                //setAmpleColumnes(); // personalitzem l'ample de les columnes

                pagina.inicializa();
                pagina.initLinkBox();

                // icono de la finestra
                //CreaEmpFijoFrame.setIconImage(imageicono);

                //Pagerfijos.cmbEntradesMostrades.setSelectedItem("" + itemsPerPage);
                // acció de tancar la finestra
                Pagerfijos.addWindowListener(new WindowAdapter() {
                   @Override
                    public void windowClosing(WindowEvent e) {
                       //frmMenu.setEnabled(true);
                       // CreaEmpFijoFrame.dispose();
                    }
                });

                //Pagerfijos.CAJA.setText(String.valueOf(ArrayListEmpFijo.efi.size()));
                

                

                

                // combo mostrar nombre d'entrades per pàgina
                Pagerfijos.cmbEntradesMostrades.setActionCommand("_CMB_ENTRADESMOSTRADES");
                Pagerfijos.cmbEntradesMostrades.setName("_CMB_ENTRADESMOSTRADES");
                Pagerfijos.cmbEntradesMostrades.addActionListener(this);
                // botó primer registre
                Pagerfijos.primero.setActionCommand("_BTN_PRIMER");
                Pagerfijos.primero.setName("_BTN_PRIMER");
                Pagerfijos.primero.addActionListener(this);
                // botó darrer registre
                Pagerfijos.ultimo.setActionCommand("_BTN_ULTIM");
                Pagerfijos.ultimo.setName("_BTN_ULTIM");
                Pagerfijos.ultimo.addActionListener(this);
                // botó següent registre
                Pagerfijos.SIGUIENTE.setActionCommand("_BTN_SEGUENT");
                Pagerfijos.SIGUIENTE.setName("_BTN_SEGUENT");
                Pagerfijos.SIGUIENTE.addActionListener(this);
                // botó anterior registre
                Pagerfijos.ANTERIOR.setActionCommand("_BTN_ANTERIOR");
                Pagerfijos.ANTERIOR.setName("_BTN_ANTERIOR");
                Pagerfijos.ANTERIOR.addActionListener(this);
                // botó tancar finestra
                /*Pagerfijos.btnTancar.setActionCommand("_BTN_TANCAR");
                Pagerfijos.btnTancar.setName("_BTN_TANCAR");
                Pagerfijos.btnTancar.addActionListener(this);
                
*/              //BOTO TORNAR AL MENU
                Pagerfijos.btnVolver.setActionCommand("_VOLVER");
                Pagerfijos.btnVolver.setName("_VOLVER");
                Pagerfijos.btnVolver.addActionListener(this);
                // botó afegir registre
                Pagerfijos.btnCrear.setActionCommand("_BTN_AFEGIR");
                Pagerfijos.btnCrear.setName("_BTN_AFEGIR");
                Pagerfijos.btnCrear.addMouseListener(this);
                // botó modificar registre
                Pagerfijos.btnModificar.setActionCommand("_BTN_MODIFICAR");
                Pagerfijos.btnModificar.setName("_BTN_MODIFICAR");
                Pagerfijos.btnModificar.addMouseListener(this);
                // botó eliminar registre
                Pagerfijos.btnEliminar.setActionCommand("_BTN_ELIMINAR");
                Pagerfijos.btnEliminar.setName("_BTN_ELIMINAR");
                Pagerfijos.btnEliminar.addMouseListener(this);
                // botó guardar TXT
                PagerFijos.btnTXT.setActionCommand("_BTN_TXT");
                PagerFijos.btnTXT.setName("_BTN_TXT");
                PagerFijos.btnTXT.addMouseListener(this);
                // botó guardar JSON
                PagerFijos.btnJSON.setActionCommand("_BTN_JSON");
                PagerFijos.btnJSON.setName("_BTN_JSON");
                PagerFijos.btnJSON.addMouseListener(this);
                // botó guardar XML
                PagerFijos.btnXML.setActionCommand("_BTN_XML");
                PagerFijos.btnXML.setName("_BTN_XML");
                PagerFijos.btnXML.addMouseListener(this);
                // Filtre
                //PagerFijos.txtFiltre.setActionCommand("_TXT_FILTRE");
                //PagerFijos.txtFiltre.setName("_TXT_FILTRE");
                //PagerFijos.txtFiltre.addKeyListener(this);

                PagerFijos.tablafijos.setName("_TAULA");
                PagerFijos.tablafijos.addMouseListener(this);
                
                break;

            case 1: // Finestra CreaEmpFijoFrame

                //CreaEmpFijoFrame.setTitle("Empleat Fix: AFEGIR");
                Crear.setVisible(true);
                Crear.setResizable(false);
                Crear.setLocationRelativeTo(null);
                Crear.falloFecha.setVisible(false);

                // icono de la finestra
               // CreaEmpFijoFrame.setIconImage(imageicono);

                // acció de tancar la finestra
                Crear.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        Crear.setEnabled(true);
                        Crear.dispose();
                    }
                });

                Crear.btnCancelar.setActionCommand("_BTN_CANCELAR1");
                Crear.btnCancelar.setName("_BTN_CANCELAR1");
                Crear.btnCancelar.addActionListener(this);

               Crear.btnAceptar.setActionCommand("_BTN_GUARDAR1");
               Crear.btnAceptar.setName("_BTN_GUARDAR1");
               Crear.btnAceptar.addActionListener(this);

                Crear.btnTancar.setActionCommand("_BTN_TANCAR1");
                Crear.btnTancar.setName("_BTN_TANCAR1");
                Crear.btnTancar.addActionListener(this);

                Crear.etinombre.setActionCommand("_TXT_NOM1");
                Crear.etinombre.setName("_TXT_NOM1");
                Crear.etinombre.addActionListener(this);
                Crear.etinombre.addKeyListener(this);
                Crear.etinombre.addFocusListener(this);

                Crear.etidni.setActionCommand("_TXT_DNI1");
                Crear.etidni.setName("_TXT_DNI1");
                Crear.etidni.addActionListener(this);
                Crear.etidni.addKeyListener(this);
                Crear.etidni.addFocusListener(this);

                
                break;

            case 2: // Finestra FrmModiEF

                modifica.setTitle("Empleat Fix: MODIFICAR");
                modifica.setVisible(true);
                modifica.setResizable(false);
                modifica.setLocationRelativeTo(null);
                BLLEFgraf.ObtenSeleccionadoCompleto();
                modifica.etisueldo.setEditable(false);
                 modifica.etifallodni.setVisible(false);
                 modifica.etiedad.setEditable(false);
                modifica.etifallodepar.setVisible(false);
             modifica.lblAntiguitat1.setEditable(false);
              modifica.etifallonom.setVisible(false);
        modifica.etifallofecha.setVisible(false);
        modifica.etidnirep.setVisible(false);
        //Carga los datos del empleado seleccionado en los campos para modificar
        modifica.etinom.setText(ArrayListEmpFijo.o.getNombre());
        modifica.etidepar.setText(ArrayListEmpFijo.o.getDepartamento());
        modifica.etidni.setText(ArrayListEmpFijo.o.getDNI());
        modifica.etiedad.setText(String.valueOf(ArrayListEmpFijo.o.getEdad()));
        modifica.etisueldo.setText(String.valueOf(ArrayListEmpFijo.o.getSueldo()));
        modifica.lblAntiguitat1.setText(String.valueOf(ArrayListEmpFijo.o.getAntiguedad()));
        ((JTextFieldDateEditor)modifica.etinac.getDateEditor()).setText(ArrayListEmpFijo.o.getFechaNac().toString());
        ((JTextFieldDateEditor)modifica.eticon.getDateEditor()).setText(ArrayListEmpFijo.o.getFechaCont().toString());

                // icono de la finestra
                //modifica.setIconImage(imageicono);

                // acció de tancar la finestra
                                
                modifica.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        Pagerfijos.setEnabled(true);
                        modifica.dispose();
                    }
                });

                modifica.etidni.setEditable(false);

               // this.omplirCampsM(EFBLL.cercarEmpleatFix());

                siEditables();

                modifica.btnCancelar.setActionCommand("_BTN_CANCELAR2");
                modifica.btnCancelar.setName("_BTN_CANCELAR2");
                modifica.btnCancelar.addActionListener(this);
                
                modifica.confirm.setActionCommand("_BTN_GUARDAR1");
                modifica.confirm.setName("_BTN_GUARDAR1");
                modifica.confirm.addActionListener(this);

                modifica.confirm.setActionCommand("_BTN_GUARDAR2");
                modifica.confirm.setName("_BTN_GUARDAR2");
                modifica.confirm.addActionListener(this);

                modifica.btnTancar.setActionCommand("_BTN_TANCAR2");
                modifica.btnTancar.setName("_BTN_TANCAR2");
                modifica.btnTancar.addActionListener(this);

                modifica.etinom.setActionCommand("_TXT_NOM2");
                modifica.etinom.setName("_TXT_NOM2");
                modifica.etinom.addActionListener(this);
                modifica.etinom.addKeyListener(this);
                modifica.etinom.addFocusListener(this);

                modifica.etidni.setActionCommand("_TXT_DNI2");
                modifica.etidni.setName("_TXT_DNI2");
                modifica.etidni.addActionListener(this);
                modifica.etidni.addKeyListener(this);
                modifica.etidni.addFocusListener(this);


                modifica.etinac.setName("_DATA_NAIXEMENT2");
                modifica.etinac.addKeyListener(this);
                break;
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (Accion.valueOf(ae.getActionCommand())) {
            // Finestra FrmInterfaceEF
            case _BTN_ANTERIOR:
                pagina.currentPageIndex -= 1;
                pagina.initLinkBox();
                //tablafijos.addRowSelectionInterval(0, 0);
                break;
            case _confirmar:
                BLLEFgraf.ModificaFijoPager();
                modifica.dispose();
                new controladorfijos(new PagerFijos(),1).iniciar(1);
                break;
            case _VOLVER:
                Pagerfijos.dispose();
                new controladorgym(new RootMenu(),4).iniciar(4);
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
               pagina.itemsPerPage = Integer.parseInt(Pagerfijos.cmbEntradesMostrades.getSelectedItem().toString());
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
               
                break;
            case _BTN_TANCAR:
                Pagerfijos.setEnabled(true);
                Crear.dispose();
                break;
            case _BTN_TANCAR1:
                Crear.setEnabled(true);
                Crear.dispose();
                break;
            case _BTN_TANCAR2:
                Crear.setEnabled(true);
                modifica.dispose();
                break;
            case _BTN_CANCELAR1:
                this.cancelarEFA();
                break;
            case _BTN_CANCELAR2:
                //this.omplirCampsM(EFBLL.cercarEmpleatFix());
                siEditables();
                break;
            case _BTN_GUARDAR1:
                //ef = this.guardarA();
                 {
                     {  BLLEFgraf.creaEmpFijo();
                        //Pagerfijos.tablafijos.setModel(new STM());
                ((STM) Pagerfijos.tablafijos.getModel()).cargar();
                        Pagerfijos.tablafijos.setFillsViewportHeight(true);
                        tablafijos.setRowSorter(sorter);
                        tablafijos.addRowSelectionInterval(0, 0); // seleccionem la primera fila 
                        Pagerfijos.lblContador.setText(String.valueOf(ArrayListEmpFijo.efi.size()));
                        //Crear.txtFiltre.setText(null);
                        Crear.setEnabled(true);
                        Crear.dispose();
                        new controladorfijos(new PagerFijos(),1).iniciar(1);
                        BLLBD.CreaEmpFijoNou();
                        BLLEFgraf.guardaOcultoTXT();
                        BLLEFgraf.guardaOcultoXML();
                    }
                }
                break;
            case _BTN_GUARDAR2:
                
                 {
                    
                        guardarM();
                    {   BLLEFgraf.ObtenSeleccionadoCompleto();
                        ((STM) tablafijos.getModel()).cargar();
                        tablafijos.setFillsViewportHeight(true);
                        tablafijos.setRowSorter(sorter);
                        tablafijos.addRowSelectionInterval(0, 0); // seleccionem la primera fila 
                        Pagerfijos.lblContador.setText(String.valueOf(ArrayListEmpFijo.efi.size()));
                        //Crear.txtFiltre.setText(null);
                        modifica.setEnabled(true);
                        modifica.dispose();
                        new controladorfijos(new PagerFijos(), 0).iniciar(0);
                        BLLBD.modificaEmpFijo();
                        BLLEFgraf.guardaOcultoTXT();
                        BLLEFgraf.guardaOcultoXML();
                        //JOptionPane.showMessageDialog(null,"Modificado con éxito");
                        
                        
                             //ef = this.guardarM();
                    }
                }
                break;
            case _TXT_NOM1:
                this.validarNomA();
                break;
            case _TXT_NOM2:
                this.validarNomM();
                break;
            case _TXT_DNI1:
                this.demanaDni();
                break;
            case _TXT_SALARIBASE1:
               // this.demanaSalariA();
                break;
            case _TXT_SALARIBASE2:
               // this.demanaSalariM();
                break;

        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int selec;
        switch (Accion.valueOf(me.getComponent().getName())) {
            // Finestra FrmInterfaceEF
            case _BTN_XML:
                
                BLLEFgraf.guardaOcultoXML();
                break;
            case _BTN_JSON:
                //guardarArxiuJSONEFBLL();
                break;
            case _BTN_TXT:
                BLLEFgraf.guardaOcultoTXT();
                break;
            case _BTN_AFEGIR:
                //selec = posicioAbsoluta();
                Pagerfijos.dispose();
                //if (selec == -1) {
                //} else {
                    Crear.setEnabled(false);
                    new controladorfijos(new CreaEmpFijoFrame(),1).iniciar(1);
                //}
                break;
            case _BTN_MODIFICAR:
                
                selec = posicioAbsoluta();
                
                if (selec == -1) {
                } else {
                    String dni = (String) tablafijos.getModel().getValueAt(selec, 0);
                    ArrayListEmpFijo.o = new EmpFijo(dni);
                    BLLEFgraf.ObtenSeleccionadoCompleto();
                    Pagerfijos.setEnabled(false);
                    new controladorfijos(new modificafijo(), 2).iniciar(2);
                    Pagerfijos.dispose();
                    Pagerfijos.setVisible(false);
                }
                break;
            case _BTN_ELIMINAR:
                BLLEFgraf.EliminaFijo();
                selec = posicioAbsoluta();
                if (selec == -1) {
                    // Menus.warning("Selecciona primer", "Atenció!");
                } else {
                    String dni = (String) tablafijos.getModel().getValueAt(selec, 0);
                    ArrayListEmpFijo.o= new EmpFijo(dni);
                    
                        ((STM) tablafijos.getModel()).cargar();
                        tablafijos.setFillsViewportHeight(true);
                        tablafijos.setRowSorter(sorter);
                        tablafijos.addRowSelectionInterval(0, 0); // seleccionem la primera fila 
                        //lblContador.setText(String.valueOf(efix.size()));
                        //Crear.txtFiltre.setText(null);
                    BLLBD.EliminafijoBD();
                }
                break;
            case _TAULA:
                tablafijos = (JTable) me.getSource();
                Point point = me.getPoint();
                int row = tablafijos.rowAtPoint(point);
                if (me.getClickCount() == 2) {
                    int sel = posicioAbsoluta();
                    String dni = (String) tablafijos.getModel().getValueAt(sel, 0);
                    ArrayListEmpFijo.o = new EmpFijo(dni);
                    Crear.setEnabled(false);
                    new controladorfijos(new modificafijo(), 2).iniciar(2);
                }
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
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
                //Crear.btnCrear.setIcon(afegir1);
                break;
            case _BTN_MODIFICAR:
                //Crear.btnModificar.setIcon(editar1);
                break;
            case _BTN_ELIMINAR:
                //Crear.btnEliminar.setIcon(eliminar1);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
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
        switch (Accion.valueOf(kt.getComponent().getName())) {
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
        switch (Accion.valueOf(kp.getComponent().getName())) {
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
        switch (Accion.valueOf(ke.getComponent().getName())) {
            case _TXT_FILTRE:
                try {
                    pagina.currentPageIndex = 1;
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
        switch (Accion.valueOf(evt.getComponent().getName())) {
            case _TXT_DNI1:
                Crear.etidni.setForeground(green);
                break;
            case _TXT_NOM1:
                Crear.etinombre.setForeground(green);
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
        switch (Accion.valueOf(evt.getComponent().getName())) {
            case _TXT_DNI1:
                Crear.etidni.setForeground(Color.BLACK);
                this.validarDni();
                break;
            case _TXT_NOM1:
                Crear.etinombre.setForeground(Color.BLACK);
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
        n = ((STM) tablafijos.getModel()).getRowCount();
        if (n != 0) {
            inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selection = tablafijos.getSelectedRow();
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
        JViewport scroll = (JViewport) tablafijos.getParent();
        int ample = scroll.getWidth();
        int ampleColumna = 0;
        TableColumnModel modelColumna = tablafijos.getColumnModel();
        TableColumn columnaTaula;
        for (int i = 0; i < tablafijos.getColumnCount(); i++) {
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
        
        if (Crear.etinombre.getText().isEmpty()) {
            Crear.lblbNom.setIcon(buit);
        } else {
            if (Validacion.validaNombre(Crear.etinombre.getText())) {
                CreaEmpFijoFrame.lblbNom.setIcon(ok);
                CreaEmpFijoFrame.etifalloNombre.setVisible(false);
            } else {
                CreaEmpFijoFrame.lblbNom.setIcon(cancel);
                CreaEmpFijoFrame.etifalloNombre.setVisible(true);
            }
        }
    }

    private void validarNomM() {
        if (modifica.etinom.getText().isEmpty()) {
            modifica.lblbNom.setIcon(buit);
        } else {
            if (Validacion.validaNombre(modifica.etinom.getText())) {
                modifica.lblbNom.setIcon(ok);
            } else {
                modifica.lblbNom.setIcon(cancel);
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
        if (Crear.etidni.getText().isEmpty()) {
            
            CreaEmpFijoFrame.lblbDni.setIcon(buit);
        } else {
            if (Validacion.DNI(Crear.etidni.getText())) { // valida si té un format de dni-nie
                CreaEmpFijoFrame.lblbDni.setIcon(ok);
                CreaEmpFijoFrame.etifalloDNI.setVisible(false);
            } else {
                //CreaEmpFijoFrame.txtDni.setText(Funcions.nifnie(CreaEmpFijoFrame.txtDni.getText())); // canvia la lletra de dni si és incorrecta
            CreaEmpFijoFrame.lblbDni.setIcon(cancel);
            CreaEmpFijoFrame.etifalloDNI.setVisible(true);
            }
        }
    }
   /*  if (Crear.etinombre.getText().isEmpty()) {
            Crear.lblbNom.setIcon(buit);
        } else {
            if (Validacion.validaNombre(Crear.etinombre.getText())) {
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
        
        int pos = BLLEFgraf.BuscaSoloPorDni(CreaEmpFijoFrame.etidni.getText()); // busca duplicats del dni
        if (pos != -1) {
            
            //CreaEmpFijoFrame.lblbDni.setIcon();
           // Menus.warning("DNI ja donat d'alta!", "Empleat Fix");
        } else {
            if (Validacion.DNI(CreaEmpFijoFrame.etidni.getText())) {
                CreaEmpFijoFrame.lblbDni.setIcon(ok);
                CreaEmpFijoFrame.etinombre.requestFocus();
            } else {
                CreaEmpFijoFrame.lblbDni.setIcon(cancel);
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
        CreaEmpFijoFrame.etinombre.setText(null);
        CreaEmpFijoFrame.etidni.setText(null);
        CreaEmpFijoFrame.etiNac.setCalendar(null);
        CreaEmpFijoFrame.etiCon.setCalendar(null);
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
        CreaEmpFijoFrame.etidni.requestFocus();
    }

    private EmpFijo guardarM() {
        EmpFijo ef = null;
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
            modifica.lblbNom.setIcon(cancel);
        }
        if (modifica.etinac.getDate() == null) {
            modifica.lblbNaixement.setIcon(cancel);
        }
        if (modifica.eticon.getDate() == null) {
            modifica.lblbContractacio.setIcon(cancel);
        }
        //if (FrmModiEF.txtSalariBase.getText().isEmpty()) {
          //  FrmModiEF.lblbSalariBase.setIcon(cancel);
        

        if (Validacion.validaNombre(modifica.etinom.getText())) {
            modifica.lblbNom.setIcon(ok);
        } else {
            modifica.lblbNom.setIcon(ok);
            nom = modifica.etinom.getText();
        }

        // Data naixement
        try {

            // si el JDateChooser torna un String
            String dn = ((JTextFieldDateEditor) modifica.etinac.getDateEditor()).getText();
            datanaixement = new fecha(dn);

            // si el JDateChooser torna un Date()   
           // datanaixement = new fecha((FrmConfig.DateDataNaixement.getDate()));
            edat = datanaixement.restafechas();
            
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
        }*/

        if ((modifica.lblbNom.getIcon().equals(ok))
                && //(FrmModiEF.lblbSalariBase.getIcon().equals(ok))
                 (modifica.lblbContractacio.getIcon().equals(ok))
                && (modifica.lblbNaixement.getIcon().equals(ok))) {
            dni = modifica.etidni.getText();
            //if (Menus.confirmar("Guardar les dades?", "Guardar")) {
                BLLEFgraf.ModificaFijoPager();
            //}
        }
        return ef;
    }

    /**
     * guarda l'objecte ef en el frm afegir
     *
     * @return un objecte EmpleatFix
     */
    private EmpFijo guardarA() {
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

        if (CreaEmpFijoFrame.etidni.getText().isEmpty()) {
            CreaEmpFijoFrame.lblbDni.setIcon(cancel);
        }
        if (CreaEmpFijoFrame.etinombre.getText().isEmpty()) {
            CreaEmpFijoFrame.lblbNom.setIcon(cancel);
        }
        if (CreaEmpFijoFrame.etiNac.getDate() == null) {
            CreaEmpFijoFrame.lblbNaixement.setIcon(cancel);
        }
        if (CreaEmpFijoFrame.etiCon.getDate() == null) {
            CreaEmpFijoFrame.lblbContractacio.setIcon(cancel);
        }
        //if (CreaEmpFijoFrame.txtSalariBase.getText().isEmpty()) {
          //  CreaEmpFijoFrame.lblbSalariBase.setIcon(cancel);
        //}

        if (Validacion.validaNombre(CreaEmpFijoFrame.etinombre.getText())) {
           CreaEmpFijoFrame.lblbNom.setIcon(cancel);
        } else {
            CreaEmpFijoFrame.lblbNom.setIcon(ok);
            nom = CreaEmpFijoFrame.etinombre.getText();
        }

        dni = CreaEmpFijoFrame.etidni.getText();
        if (Validacion.DNI(dni)) {
            CreaEmpFijoFrame.lblbDni.setIcon(cancel);
        } else {
            int pos = BLLEFgraf.BuscaSoloPorDni(dni);
            if (pos != -1) {
                CreaEmpFijoFrame.lblbDni.setIcon(cancel);
                Menus.warning("DNI ja donat d'alta!", "Empleat Fix");
            } else {
                CreaEmpFijoFrame.lblbDni.setIcon(ok);
                //CreaEmpFijoFrame.txtDni.setText(Funcions.nifnie(dni));
            }
        }

        // Data naixement
        try {

            // si el JDateChooser torna un String
            String dn = ((JTextFieldDateEditor) CreaEmpFijoFrame.etiNac.getDateEditor()).getText();
            datanaixement = new fecha(dn);

            // si el JDateChooser torna un Date()   
           // datanaixement = new fecha((FrmConfig.DateDataNaixement.getDate()));
            edat = datanaixement.restafechas();
            if (edat < 16) {
               // CreaEmpFijoFrame.lblbDnaixement.setIcon(cancel);
                Menus.warning("Ha de ser major de 16 anys", "Atenció");
            } else {
                CreaEmpFijoFrame.lblbNaixement.setIcon(ok);
                CreaEmpFijoFrame.lblEdad.setText("" + edat);
            }
        } catch (Exception ex) {
            Crear.lblbNaixement.setIcon(cancel);
        }

        // Data contratacio
        try {
            
            datacontratacio = new fecha(((JTextFieldDateEditor)CreaEmpFijoFrame.etiCon.getDateEditor()).getText());
            CreaEmpFijoFrame.lblbContractacio.setIcon(ok);
        } catch (Exception ex) {
            CreaEmpFijoFrame.lblbContractacio.setIcon(cancel);
        }
        try {
            difer = datanaixement.restafechas();
            if (difer >= 16) { // difer
                antiguitat = datacontratacio.restafechas();
                
                CreaEmpFijoFrame.lblbContractacio.setIcon(ok);
            }
        } catch (Exception ex) {
            CreaEmpFijoFrame.lblbContractacio.setIcon(cancel);
        }

        // Salari Base        
        /*try {
            soubase = Float.parseFloat(CreaEmpFijoFrame.txtSalariBase.getText());
            if (soubase >= 0) {
                sou = soubase * (1 + (percent / 100));
                CreaEmpFijoFrame.lblSalari.setText(Format.formatConfig(sou, Core.conf));
                CreaEmpFijoFrame.lblbSalariBase.setIcon(ok);
            } else {
                soubase = 1 / 0;
            }
        } catch (Exception ex) {
            CreaEmpFijoFrame.lblbSalariBase.setIcon(cancel);
            CreaEmpFijoFrame.lblSalari.setText(null);
        }
*/
        if ((CreaEmpFijoFrame.lblbDni.getIcon().equals(ok))
                && (CreaEmpFijoFrame.lblbNom.getIcon().equals(ok))
                && //(CreaEmpFijoFrame.lblbSalariBase.getIcon().equals(ok))
                 (CreaEmpFijoFrame.lblbContractacio.getIcon().equals(ok))
                && (CreaEmpFijoFrame.lblbNaixement.getIcon().equals(ok))) {

            if (dni != null) {
                int pos = BLLEFgraf.BuscaSoloPorDni(dni);
                if (pos != -1) {
                    CreaEmpFijoFrame.lblbDni.setIcon(cancel);
                    Menus.warning("DNI ja donat d'alta!", "Empleat Fix");
                } else {
                    if (Menus.confirmar("Guardar les dades?", "Guardar")) {
                        BLLEFgraf.creaEmpFijo();
                    }
                }
            }
        }
        return ef;
    }
    
}
