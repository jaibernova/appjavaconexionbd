package views;


import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import controller.Controller;



public class Panel extends JPanel implements ActionListener{
    
    public static final String BTN_REQ1= "Requerimiento1";
    public static final String BTN_REQ2= "Requerimiento2";
    public static final String BTN_REQ3= "Requerimiento3";


    private JButton requerimiento1;
    private JButton requerimiento2;
    private JButton requerimiento3;
    private Interfaz inter;
    private Controller contr;

    public Panel(Interfaz inter) {
        super();
        contr=new Controller("jdbc:mysql://localhost:3306/Proyectos");
        setLayout(new GridLayout(1,3));
        setBorder(new TitledBorder("Tipo"));
        this.inter=inter;
        requerimiento1= new JButton(BTN_REQ1);
        requerimiento2= new JButton(BTN_REQ2);
        requerimiento3= new JButton(BTN_REQ3);

        requerimiento1.setActionCommand(BTN_REQ1);
        requerimiento2.setActionCommand(BTN_REQ2);
        requerimiento3.setActionCommand(BTN_REQ3);

        requerimiento1.addActionListener(this);
        requerimiento2.addActionListener(this);
        requerimiento3.addActionListener(this);

        add(requerimiento1);
        add(requerimiento2);
        add(requerimiento3);

    }

    public void listarClientes(String tipo) {
        inter.updateListClientes(tipo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals(BTN_REQ1)) {
            listarClientes(BTN_REQ1);
            JOptionPane.showMessageDialog(inter,"Requerimiento ejecutado");
      }else if(e.getActionCommand().equals(BTN_REQ2)){
            listarClientes(BTN_REQ2);
            JOptionPane.showMessageDialog(inter,"Requerimiento ejecutado");
      }else if(e.getActionCommand().equals(BTN_REQ3)){
            listarClientes(BTN_REQ3);
            JOptionPane.showMessageDialog(inter,"Requerimiento ejecutado");
        }           
    }    
}