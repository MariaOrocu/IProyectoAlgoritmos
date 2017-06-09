/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mary_
 */
public class Window extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem jmicargarLista;
    private JMenuItem jmibuscar;
    private JMenuItem jmilistado;
    private JMenuItem jmiinsertar;
    private JDesktopPane desktopPane;
    private LoadList cargar;
    public List listAction;
    public List listFiction;
    public List listComedy;
    public List listDrama;
    public List listRomantic;
    public List listChildish;
    public String path;

    public Window() {

        super();
        this.setSize(new Dimension(800, 700));
        this.setLocation(300, 10);
        this.desktopPane = new JDesktopPane();
        this.desktopPane.setLayout(null);
        this.getContentPane().add(desktopPane);
        this.menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        this.menu = new JMenu("Menu ");
        this.menuBar.add(this.menu);
        this.jmicargarLista = new JMenuItem("Load File");
        this.menu.add(this.jmicargarLista);
        this.jmicargarLista.addActionListener(this);
        this.jmibuscar = new JMenuItem("Search Movie");
        this.menu.add(this.jmibuscar);
        this.jmibuscar.addActionListener(this);
        this.jmilistado = new JMenuItem("List General");
        this.menu.add(this.jmilistado);
        this.jmilistado.addActionListener(this);
        this.jmiinsertar = new JMenuItem("Insert Movie");
        this.menu.add(this.jmiinsertar);
        this.jmiinsertar.addActionListener(this);
        this.listAction = new List("Action");
        this.listChildish = new List("Childish");
        this.listComedy = new List("Comedy");
        this.listDrama = new List("Drama");
        this.listFiction = new List("Fiction");
        this.listRomantic = new List("Romance");
        this.path = "";

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jmicargarLista) {
            LoadList load = new LoadList(this);
            load.setVisible(true);
            this.desktopPane.add(load);
        }//if(e.getSource()==jmicargarLista)
        else if (e.getSource() == this.jmibuscar) {
            SearchMovie search = new SearchMovie(this);
            search.setVisible(true);
            this.desktopPane.add(search);
        } else if (e.getSource() == this.jmiinsertar) {
            InsertMovie insert = new InsertMovie(this);
            insert.setVisible(true);
            this.desktopPane.add(insert);
        } else if (e.getSource() == this.jmilistado) {
            ListingMovie listing = new ListingMovie(this);
            listing.setVisible(true);
            this.desktopPane.add(listing);
        }
    }

}
