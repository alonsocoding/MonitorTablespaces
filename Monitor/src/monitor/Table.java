/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor;

/**
 *
 * @author AndreyCh
 */
public class Table {

    String name;
    int size;
    int registros;

    public Table(String name, int size, int registros) {
        this.name = name;
        this.size = size;
        this.registros = registros;
    }

    public Table() {
        this.name = "";
        this.size = 0;
        this.registros = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRegistros() {
        return registros;
    }

    public void setRegistros(int registros) {
        this.registros = registros;
    }

    Object get(int j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
