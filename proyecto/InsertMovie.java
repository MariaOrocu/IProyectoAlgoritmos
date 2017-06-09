/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author mary_
 */
public class InsertMovie extends JInternalFrame implements ActionListener {

    private JTextField tittle;
    private JComboBox gender;
    private JTextField code;
    private JTextField total;
    private JComboBox subtitled;
    private JComboBox premier;
    private JLabel jltittle;
    private JLabel jlgender;
    private JLabel jlcode;
    private JLabel jltotal;
    private JLabel jlsubtitled;
    private JLabel jlpremier;
    private JButton insertar;
    private Window ventana;

    public InsertMovie(Window ventana) {

        super();
        this.ventana = ventana;
        this.setClosable(true);
        this.setSize(500, 500);
        this.setLayout(null);
        this.code = new JTextField();
        this.code.setBounds(110, 50, 200, 30);
        this.add(this.code);
        this.tittle = new JTextField();
        this.tittle.setBounds(110, 100, 200, 30);
        this.add(this.tittle);
        this.gender = new JComboBox();
        this.gender.addItem("Action");
        this.gender.addItem("Childish");
        this.gender.addItem("Comedy");
        this.gender.addItem("Drama");
        this.gender.addItem("Fiction");
        this.gender.addItem("Romance");
        this.gender.setBounds(110, 150, 200, 30);
        this.add(this.gender);
        this.total = new JTextField();
        this.total.setBounds(110, 200, 200, 30);
        this.add(this.total);
        this.subtitled = new JComboBox();
        this.subtitled.addItem("Yes");
        this.subtitled.addItem("No");
        this.subtitled.setBounds(110, 250, 200, 30);
        this.add(this.subtitled);
        this.premier = new JComboBox();
        this.premier.addItem("Yes");
        this.premier.addItem("No");
        this.premier.setBounds(110, 300, 200, 30);
        this.add(this.premier);
        this.jlcode = new JLabel("Code: ");
        this.jlcode.setBounds(30, 50, 75, 30);
        this.add(this.jlcode);
        this.jltittle = new JLabel("Title: ");
        this.jltittle.setBounds(30, 100, 75, 30);
        this.add(this.jltittle);
        this.jlgender = new JLabel("Gender: ");
        this.jlgender.setBounds(30, 150, 75, 30);
        this.add(this.jlgender);
        this.jltotal = new JLabel("Total: ");
        this.jltotal.setBounds(30, 200, 75, 30);
        this.add(this.jltotal);
        this.jlsubtitled = new JLabel("Subtitled: ");
        this.jlsubtitled.setBounds(30, 250, 75, 30);
        this.add(this.jlsubtitled);
        this.jlpremier = new JLabel("Premier: ");
        this.jlpremier.setBounds(30, 300, 75, 30);
        this.add(this.jlpremier);
        this.insertar = new JButton("Insert");
        this.insertar.setBounds(100, 400, 100, 30);
        this.insertar.addActionListener(this);
        this.add(this.insertar);

    } // constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertar) {
            if (!ventana.path.equals("")) {
                try {
                    Movie movie = new Movie();
                    movie.setCode(Integer.parseInt(code.getText()));
                    String genderT = gender.getSelectedItem().toString();
                    movie.setTotal(Integer.parseInt(total.getText()));
                    movie.setTittle(tittle.getText());
                    movie.setSubtitled((subtitled.getSelectedIndex() == 0) ? 1 : 0);
                    movie.setPremier((premier.getSelectedIndex() == 0) ? 1 : 0);
                    switch (genderT) {
                        case "Action":
                            movie.setGender("4000");
                            break;
                        case "Childish":
                            movie.setGender("3000");
                            break;
                        case "Drama":
                            movie.setGender("1000");
                            break;
                        case "Fiction":
                            movie.setGender("6000");
                            break;
                        case "Romance":
                            movie.setGender("5000");
                            break;
                        case "Comedy":
                            movie.setGender("2000");
                            break;

                    }
                    if (!existe(movie.getCode())) {
                        boolean insertada = false;
                        switch (movie.getGender()) {
                            case "4000":
                                insertada = this.ventana.listAction.writeInFile(ventana.path, movie);
                                break;
                            case "3000":
                                insertada = this.ventana.listChildish.writeInFile(ventana.path, movie);
                                break;
                            case "2000":
                                insertada = this.ventana.listComedy.writeInFile(ventana.path, movie);
                                break;
                            case "1000":
                                insertada = this.ventana.listDrama.writeInFile(ventana.path, movie);
                                break;
                            case "6000":
                                insertada = this.ventana.listFiction.writeInFile(ventana.path, movie);
                                break;
                            case "5000":
                                insertada = this.ventana.listRomantic.writeInFile(ventana.path, movie);
                                break;
                        }
                        if (insertada) {
                            JOptionPane.showMessageDialog(this, "Successfully inserted");
                            tittle.setText("");
                            code.setText("");
                            total.setText("");
                            gender.setSelectedIndex(0);
                            premier.setSelectedIndex(0);
                            subtitled.setSelectedIndex(0);
                        } else {
                            JOptionPane.showMessageDialog(this, "Couldn't insert, try again.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "The inserted code already exists.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "There is an error with the data entered. Try again.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Upload a file first.");
            }
        }
    }

    public boolean existe(int code) {
        boolean found = false;
        if (!this.ventana.listAction.exists(code)) {
            if (!this.ventana.listChildish.exists(code)) {
                if (!this.ventana.listComedy.exists(code)) {
                    if (!this.ventana.listComedy.exists(code)) {
                        if (!this.ventana.listDrama.exists(code)) {
                            if (!this.ventana.listFiction.exists(code)) {
                                if (this.ventana.listRomantic.exists(code)) {
                                    found = true;
                                }
                            } else {
                                found = true;
                            }
                        } else {
                            found = true;
                        }
                    } else {
                        found = true;
                    }
                } else {
                    found = true;
                }
            } else {
                found = true;
            }
        } else {
            found = true;
        }
        return found;
    }

}
