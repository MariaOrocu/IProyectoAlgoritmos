/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mary_
 */
public class ListingMovie extends JInternalFrame {

    private DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane scrollpane;
    private Window ventana;

    public ListingMovie(Window ventana) {
        super();
        this.ventana = ventana;
        this.setClosable(true);
        this.setSize(600, 600);
        this.setLayout(null);
        String col[] = {"Tittle", "Gender", "Code", "Total", "Subtitled", "Premier"};
        this.modelo = new DefaultTableModel(col, 0);
        this.tabla = new JTable(modelo);
        this.scrollpane = new JScrollPane(tabla);
        this.scrollpane.setBounds(20, 20, 560, 530);
        this.add(this.scrollpane);
        llenarTabla();

    }

    public void llenarTabla() {
        Movie movie;
        Object[] objs = new Object[6];
        for (int i = 0; i < this.ventana.listAction.size(); i++) {
            movie = this.ventana.listAction.getAt(i);
            objs[0] = movie.getTittle();
            objs[1] = movie.getGender();
            objs[2] = movie.getCode();
            objs[3] = movie.getTotal();
            objs[4] = (movie.getSubtitled() == 1) ? "Yes" : "No";
            objs[5] = (movie.getPremier() == 1) ? "Yes" : "No";
            this.modelo.addRow(objs);
        }

        for (int i = 0; i < this.ventana.listChildish.size(); i++) {
            movie = this.ventana.listChildish.getAt(i);
            objs[0] = movie.getTittle();
            objs[1] = movie.getGender();
            objs[2] = movie.getCode();
            objs[3] = movie.getTotal();
            objs[4] = (movie.getSubtitled() == 1) ? "Yes" : "No";
            objs[5] = (movie.getPremier() == 1) ? "Yes" : "No";
            this.modelo.addRow(objs);
        }

        for (int i = 0; i < this.ventana.listComedy.size(); i++) {
            movie = this.ventana.listComedy.getAt(i);
            objs[0] = movie.getTittle();
            objs[1] = movie.getGender();
            objs[2] = movie.getCode();
            objs[3] = movie.getTotal();
            objs[4] = (movie.getSubtitled() == 1) ? "Yes" : "No";
            objs[5] = (movie.getPremier() == 1) ? "Yes" : "No";
            this.modelo.addRow(objs);
        }

        for (int i = 0; i < this.ventana.listDrama.size(); i++) {
            movie = this.ventana.listDrama.getAt(i);
            objs[0] = movie.getTittle();
            objs[1] = movie.getGender();
            objs[2] = movie.getCode();
            objs[3] = movie.getTotal();
            objs[4] = (movie.getSubtitled() == 1) ? "Yes" : "No";
            objs[5] = (movie.getPremier() == 1) ? "Yes" : "No";
            this.modelo.addRow(objs);
        }

        for (int i = 0; i < this.ventana.listFiction.size(); i++) {
            movie = this.ventana.listFiction.getAt(i);
            objs[0] = movie.getTittle();
            objs[1] = movie.getGender();
            objs[2] = movie.getCode();
            objs[3] = movie.getTotal();
            objs[4] = (movie.getSubtitled() == 1) ? "Yes" : "No";
            objs[5] = (movie.getPremier() == 1) ? "Yes" : "No";
            this.modelo.addRow(objs);
        }

        for (int i = 0; i < this.ventana.listRomantic.size(); i++) {
            movie = this.ventana.listRomantic.getAt(i);
            objs[0] = movie.getTittle();
            objs[1] = movie.getGender();
            objs[2] = movie.getCode();
            objs[3] = movie.getTotal();
            objs[4] = (movie.getSubtitled() == 1) ? "Yes" : "No";
            objs[5] = (movie.getPremier() == 1) ? "Yes" : "No";
            this.modelo.addRow(objs);
        }

    }
}
