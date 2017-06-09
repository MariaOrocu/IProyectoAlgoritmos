/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author mary_
 */
public class List {

    private Node headNode;
    private String gender;

    public List() {
    }

    public void printList() {
        Node tempNode = this.headNode;
        boolean recorrer = true;
        boolean completa = false;
        if (tempNode != null) {
            while (recorrer) {
                if (tempNode.movie.getCode() == this.headNode.movie.getCode()) {
                    if (completa) {
                        recorrer = false;
                    } else {
                        completa = true;
                        System.out.println(tempNode.movie.getTittle());
                    }
                } else {
                    System.out.println(tempNode.movie.getTittle());
                }
                tempNode = tempNode.siguiente;
            }

        } else {
            System.out.println("The list is empty.\n\n");
        }
        System.out.println("END");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void insertInOrder(Movie movie) {

        Node newPtr, tempPtr, headNodePrev;

        newPtr = new Node();
        newPtr.movie = movie;
        tempPtr = this.headNode;

        if (tempPtr == null) {
            this.headNode = newPtr;
            newPtr.siguiente = this.headNode;
            newPtr.anterior = this.headNode;
        } else if (newPtr.movie.getTittle().compareTo(this.headNode.movie.getTittle()) < 0) {

            headNodePrev = this.headNode;
            this.headNode = newPtr;
            this.headNode.siguiente = tempPtr;
            tempPtr.anterior = headNode;
            boolean recorrer = true;
            while (recorrer) {
                if (tempPtr.siguiente.movie.getCode() == headNodePrev.movie.getCode()) {
                    recorrer = false;
                    tempPtr.siguiente = this.headNode;
                    headNode.anterior = tempPtr;
                }

                tempPtr = tempPtr.siguiente;
            }
        } else {
            boolean recorrer = true;
            while (recorrer) {
                if (tempPtr.siguiente.movie.getCode() == this.headNode.movie.getCode()) {
                    recorrer = false;
                    tempPtr.siguiente = newPtr;
                    newPtr.anterior = tempPtr;
                    newPtr.siguiente = this.headNode;
                    this.headNode.anterior = newPtr;
                } else {
                    if (tempPtr.siguiente.movie.getTittle().compareTo(newPtr.movie.getTittle()) > 0) {
                        recorrer = false;
                        Node tempSiguiente;
                        tempSiguiente = tempPtr.siguiente;
                        newPtr.siguiente = tempPtr.siguiente;
                        tempSiguiente.anterior = newPtr;
                        tempPtr.siguiente = newPtr;
                        newPtr.anterior = tempPtr;
                    }
                }
                tempPtr = tempPtr.siguiente;
            }
        }
    }

    public Movie search(String title) {
        Node tempNode = this.headNode;
        boolean recorrer = true;
        boolean completa = false;
        if (tempNode != null) {
            while (recorrer) {
                if (tempNode.movie.getCode() == this.headNode.movie.getCode()) {
                    if (completa) {
                        recorrer = false;
                    } else {
                        completa = true;
                    }
                }
                if (tempNode.movie.getTittle().equalsIgnoreCase(title)) {
                    return tempNode.movie;
                }
                tempNode = tempNode.siguiente;
            }
        }
        return null;
    }

    public boolean exists(int code) {
        Node tempNode = this.headNode;
        boolean recorrer = true;
        boolean completa = false;
        if (tempNode != null) {
            while (recorrer) {
                if (tempNode.movie.getCode() == this.headNode.movie.getCode()) {
                    if (completa) {
                        recorrer = false;
                    } else {
                        completa = true;
                    }
                }
                if (tempNode.movie.getCode() == code) {
                    return true;
                }
                tempNode = tempNode.siguiente;
            }
        }
        return false;
    }

    public int size() {

        Node tempNode = this.headNode;
        boolean recorrer = true;
        int size = 0;
        boolean completa = false;
        if (tempNode != null) {
            while (recorrer) {
                if (tempNode.movie.getCode() == this.headNode.movie.getCode()) {
                    if (completa) {
                        recorrer = false;
                    } else {
                        completa = true;

                    }
                }
                size++;
                tempNode = tempNode.siguiente;

            }

        }
        return size - 1;
    }

    public Movie getAt(int pos) {

        Node tempNode = this.headNode;
        boolean recorrer = true;
        int size = 0;
        Movie movie = null;
        boolean completa = false;
        if (tempNode != null) {
            while (recorrer) {
                if (tempNode.movie.getCode() == this.headNode.movie.getCode()) {
                    if (completa) {
                        recorrer = false;
                    } else {
                        completa = true;

                    }
                }
                if (size == pos) {
                    movie = tempNode.movie;
                }
                size++;
                tempNode = tempNode.siguiente;

            }

        }
        if (pos >= size - 1) {
            return null;
        } else {
            return movie;
        }

    }

    public void construct(String path) {

        BufferedReader br;
        boolean primera = true;
        try {

            br = new BufferedReader(new FileReader(path));
            String linea = br.readLine();

            while (null != linea) {
                Movie movie = new Movie();
                String[] atributos = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (!primera) {
                    movie.setCode(Integer.parseInt(atributos[0]));
                    movie.setTittle(atributos[1].replace("\"", ""));
                    movie.setGender(atributos[2]);
                    movie.setTotal(Integer.parseInt(atributos[3]));
                    movie.setSubtitled(Integer.parseInt(atributos[4]));
                    movie.setPremier(Integer.parseInt(atributos[5]));

                    switch (atributos[2]) {
                        case "1000":
                            movie.setGender("Drama");
                            break;
                        case "2000":
                            movie.setGender("Comedy");
                            break;
                        case "3000":
                            movie.setGender("Childish");
                            break;
                        case "4000":
                            movie.setGender("Action");
                            break;
                        case "5000":
                            movie.setGender("Romance");
                            break;
                        case "6000":
                            movie.setGender("Fiction");
                            break;
                    }
                    if (movie.getGender().equalsIgnoreCase(gender)) {
                        insertInOrder(movie);
                    }

                } else {
                    primera = false;
                }

                linea = br.readLine();
            }
            br.close();
        } catch (Exception e) {

        }

    }

    public List(String gender) {
        this.gender = gender;
    }

    public boolean writeInFile(String path, Movie movie) {
        boolean insertada = false;
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(path, true));
            pw.println(movie.getCode() + "," + movie.getTittle() + "," + movie.getGender() + "," + movie.getTotal() + "," + movie.getSubtitled() + "," + movie.getPremier());
            pw.close();
            switch (movie.getGender()) {
                case "4000":
                    movie.setGender("Action");
                    break;
                case "3000":
                    movie.setGender("Childish");
                    break;
                case "2000":
                    movie.setGender("Comedy");
                    break;
                case "1000":
                    movie.setGender("Drama");
                    break;
                case "6000":
                    movie.setGender("Fiction");
                    break;
                case "5000":
                    movie.setGender("Romance");
                    break;
            }
            insertInOrder(movie);
            insertada = true;
        } catch (Exception e) {

        }
        return insertada;
    }

}
