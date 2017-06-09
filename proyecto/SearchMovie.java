/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mary_
 */
public class SearchMovie extends JInternalFrame implements ActionListener {

    private JTextField jtfBuscar;
    private JLabel jlBuscar;
    private JButton buscar;
    private DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane scrollpane;
    private Window ventana;

    public SearchMovie(Window ventana) {
        super();
        this.ventana = ventana;
        this.setClosable(true);
        this.setSize(600, 600);
        this.setLayout(null);
        this.jtfBuscar = new JTextField();
        this.jtfBuscar.setBounds(140, 50, 240, 30);
        this.add(this.jtfBuscar);
        this.jlBuscar = new JLabel("Title: ");
        this.jlBuscar.setBounds(10, 50, 130, 30);
        this.add(this.jlBuscar);
        this.buscar = new JButton("Search");
        this.buscar.setBounds(140, 90, 100, 30);
        this.buscar.addActionListener(this);
        String col[] = {"Tittle", "Gender", "Code", "Total", "Subtitled", "Premier"};
        this.modelo = new DefaultTableModel(col, 0);
        this.tabla = new JTable(modelo);
        this.scrollpane = new JScrollPane(tabla);
        this.scrollpane.setBounds(20, 150, 560, 350);
        this.add(this.scrollpane);
        this.add(this.buscar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buscar) {
            if (!ventana.path.equals("")) {

                llenarTabla(jtfBuscar.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Upload a file first.");
            }
        }

    }

    public void llenarTabla(String title) {
        Movie movie;
        boolean encontrada = false;
        Object[] objs = new Object[6];
        int filas = this.tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            this.modelo.removeRow(0);
        }
        for (int i = 0; i < this.ventana.listAction.size(); i++) {
            movie = this.ventana.listAction.getAt(i);
            objs[0] = movie.getTittle();
            objs[1] = movie.getGender();
            objs[2] = movie.getCode();
            objs[3] = movie.getTotal();
            objs[4] = (movie.getSubtitled() == 1) ? "Yes" : "No";
            objs[5] = (movie.getPremier() == 1) ? "Yes" : "No";
            if (movie.getTittle().toLowerCase().contains(title.toLowerCase())) {
                this.modelo.addRow(objs);
                encontrada = true;
            }

        }

        for (int i = 0; i < this.ventana.listChildish.size(); i++) {
            movie = this.ventana.listChildish.getAt(i);
            objs[0] = movie.getTittle();
            objs[1] = movie.getGender();
            objs[2] = movie.getCode();
            objs[3] = movie.getTotal();
            objs[4] = (movie.getSubtitled() == 1) ? "Yes" : "No";
            objs[5] = (movie.getPremier() == 1) ? "Yes" : "No";
            if (movie.getTittle().toLowerCase().contains(title.toLowerCase())) {
                this.modelo.addRow(objs);
                encontrada = true;
            }
        }

        for (int i = 0; i < this.ventana.listComedy.size(); i++) {
            movie = this.ventana.listComedy.getAt(i);
            objs[0] = movie.getTittle();
            objs[1] = movie.getGender();
            objs[2] = movie.getCode();
            objs[3] = movie.getTotal();
            objs[4] = (movie.getSubtitled() == 1) ? "Yes" : "No";
            objs[5] = (movie.getPremier() == 1) ? "Yes" : "No";
            if (movie.getTittle().toLowerCase().contains(title.toLowerCase())) {
                this.modelo.addRow(objs);
                encontrada = true;
            }
        }

        for (int i = 0; i < this.ventana.listDrama.size(); i++) {
            movie = this.ventana.listDrama.getAt(i);
            objs[0] = movie.getTittle();
            objs[1] = movie.getGender();
            objs[2] = movie.getCode();
            objs[3] = movie.getTotal();
            objs[4] = (movie.getSubtitled() == 1) ? "Yes" : "No";
            objs[5] = (movie.getPremier() == 1) ? "Yes" : "No";
            if (movie.getTittle().toLowerCase().contains(title.toLowerCase())) {
                this.modelo.addRow(objs);
                encontrada = true;
            }
        }

        for (int i = 0; i < this.ventana.listFiction.size(); i++) {
            movie = this.ventana.listFiction.getAt(i);
            objs[0] = movie.getTittle();
            objs[1] = movie.getGender();
            objs[2] = movie.getCode();
            objs[3] = movie.getTotal();
            objs[4] = (movie.getSubtitled() == 1) ? "Yes" : "No";
            objs[5] = (movie.getPremier() == 1) ? "Yes" : "No";
            if (movie.getTittle().toLowerCase().contains(title.toLowerCase())) {
                this.modelo.addRow(objs);
                encontrada = true;
            }
        }

        for (int i = 0; i < this.ventana.listRomantic.size(); i++) {
            movie = this.ventana.listRomantic.getAt(i);
            objs[0] = movie.getTittle();
            objs[1] = movie.getGender();
            objs[2] = movie.getCode();
            objs[3] = movie.getTotal();
            objs[4] = (movie.getSubtitled() == 1) ? "Yes" : "No";
            objs[5] = (movie.getPremier() == 1) ? "Yes" : "No";
            if (movie.getTittle().toLowerCase().contains(title.toLowerCase())) {
                this.modelo.addRow(objs);
                encontrada = true;
            }
        }

        if (!encontrada) {
            JOptionPane.showMessageDialog(this, "Movie doesn't exist");
        } else {
            jtfBuscar.setText("");
        }

    }

}
