/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mary_
 */
public class LoadList extends JInternalFrame implements ActionListener {

    private JButton load;
    private JButton action;
    private JButton drama;
    private JButton comedy;
    private JButton childish;
    private JButton fiction;
    private JButton romance;
    private DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane scrollpane;
    private Window ventana;
    public String path;

    public LoadList(Window ventana) {

        super();
        this.ventana = ventana;
        this.setClosable(true);
        this.setSize(600, 600);
        this.setLayout(null);
        this.path = "";
        String col[] = {"Tittle", "Gender", "Code", "Total", "Subtitled", "Premier"};
        this.modelo = new DefaultTableModel(col, 0);
        this.tabla = new JTable(modelo);
        this.scrollpane = new JScrollPane(tabla);
        this.scrollpane.setBounds(20, 10, 560, 350);
        this.add(this.scrollpane);
        this.load = new JButton("Load File");
        this.load.setBounds(240, 520, 100, 30);
        this.load.addActionListener(this);
        this.add(this.load);
        this.action = new JButton("Action");
        this.action.setBounds(70, 385, 100, 30);
        this.action.addActionListener(this);
        this.add(this.action);
        this.childish = new JButton("Childish");
        this.childish.setBounds(240, 385, 100, 30);
        this.childish.addActionListener(this);
        this.add(this.childish);
        this.comedy = new JButton("Comedy");
        this.comedy.setBounds(430, 385, 100, 30);
        this.comedy.addActionListener(this);
        this.add(this.comedy);
        this.drama = new JButton("Drama");
        this.drama.setBounds(70, 450, 100, 30);
        this.drama.addActionListener(this);
        this.add(this.drama);
        this.fiction = new JButton("Fiction");
        this.fiction.setBounds(240, 450, 100, 30);
        this.fiction.addActionListener(this);
        this.add(this.fiction);
        this.romance = new JButton("Romance");
        this.romance.setBounds(430, 450, 100, 30);
        this.romance.addActionListener(this);
        this.add(this.romance);

    }

    public void llenarTabla(String gender) {
        Movie movie;
        Object[] objs = new Object[6];
        int filas = this.tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            this.modelo.removeRow(0);
        }
        switch (gender) {
            case "Action":
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
                break;
            case "Childish":
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
                break;
            case "Comedy":
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
                break;
            case "Drama":
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
                break;
            case "Fiction":
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
                break;
            case "Romance":
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
                break;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == load) {

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("CSV FILES", "csv", "csv");
            fileChooser.setFileFilter(filtro);
            int seleccion = fileChooser.showOpenDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {

                File fichero = fileChooser.getSelectedFile();
                this.path = fichero.getPath();
                ventana.path = this.path;
                JOptionPane.showMessageDialog(this, "File Uploaded Correctly");
            }
        }
        if (!this.path.equals("")) {
            if (e.getSource() == action) {
                if (this.ventana.listAction.size() == -1) {
                    this.ventana.listAction.construct(this.path);
                    llenarTabla("Action");
                    JOptionPane.showMessageDialog(this, "Movies uploaded successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Movies were already loaded");
                }
            }
            if (e.getSource() == drama) {
                if (this.ventana.listDrama.size() == -1) {
                    this.ventana.listDrama.construct(this.path);
                    llenarTabla("Drama");
                    JOptionPane.showMessageDialog(this, "Movies uploaded successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Movies were already loaded");
                }
            }
            if (e.getSource() == comedy) {
                if (this.ventana.listComedy.size() == -1) {
                    this.ventana.listComedy.construct(this.path);
                    llenarTabla("Comedy");
                    JOptionPane.showMessageDialog(this, "Movies uploaded successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Movies were already loaded");
                }
            }
            if (e.getSource() == childish) {
                if (this.ventana.listChildish.size() == -1) {
                    this.ventana.listChildish.construct(this.path);
                    llenarTabla("Childish");
                    JOptionPane.showMessageDialog(this, "Movies uploaded successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Movies were already loaded");
                }
            }
            if (e.getSource() == romance) {
                if (this.ventana.listRomantic.size() == -1) {
                    this.ventana.listRomantic.construct(this.path);
                    llenarTabla("Romance");
                    JOptionPane.showMessageDialog(this, "Movies uploaded successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Movies were already loaded");
                }
            }
            if (e.getSource() == fiction) {
                if (this.ventana.listFiction.size() == -1) {
                    this.ventana.listFiction.construct(this.path);
                    llenarTabla("Fiction");
                    JOptionPane.showMessageDialog(this, "Movies uploaded successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Movies were already loaded");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Upload a file first.");
        }
    }

}
