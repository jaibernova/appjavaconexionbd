package views;

import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;


public class PanelClientes extends JPanel {
    private Interfaz interfaz;
    private JList<String> listaclientes; 

    public PanelClientes(Interfaz i) {
        super();
        setLayout(new GridLayout());
        setBorder(new TitledBorder("Requerimiento"));
        interfaz =i;      
        listaclientes=new JList<>();
        add(listaclientes);              
    }

    public void updateListClientes(String[] listarMetodoDos) {
        listaclientes.setListData(listarMetodoDos);
    }
}
