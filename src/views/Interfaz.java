package views;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import controller.Controller;
import model.Req1;

public class Interfaz extends JFrame{

    private Panel panel;
    private PanelClientes panelClientes;
    private Controller control;

    public Interfaz() {
        super();
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("proyecto");
        setLayout(new BorderLayout());

        control=new Controller("jdbc:mysql://localhost:3306/Proyectos");
        control.req1();
        control.req2();
        control.req3();
        panel = new Panel(this);
        panelClientes=new PanelClientes(this);
        add(panel, BorderLayout.SOUTH);
        add(panelClientes, BorderLayout.CENTER);
    }

    public String listarMetodo() {
        control.getReq1s();
        String listado="";
        for (Req1 e : control.getReq1s()) {
            listado+=e+"\n";           
        }
        return listado;
    }

    public String[] listarMetodoDos(String tipo) {
        String[] listado={};               
        if (tipo=="Requerimiento1") {
            listado=new String[control.getReq1s().size()];          
        for (int i = 0; i < listado.length; i++) {
            listado[i]=control.getReq1s().get(i).toString();
        }
        } else if(tipo=="Requerimiento2"){
            listado=new String[control.getReq2s().size()];
        for (int i = 0; i < listado.length; i++) {
            listado[i]=control.getReq2s().get(i).toString();                
        }        
        } else if(tipo=="Requerimiento3"){
            listado=new String[control.getReq3s().size()];
        for (int i = 0; i < listado.length; i++) {
            listado[i]=control.getReq3s().get(i).toString();                
        }
    }              
        return listado;
    }
    
    public void updateListClientes(String tipo) {
        panelClientes.updateListClientes(listarMetodoDos(tipo));        
    }
 
}
