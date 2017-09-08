/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor;

/**
 *
 * @author David
 */
import java.util.ArrayList;
import java.util.List;

public class Matriz {

    static ArrayList<ArrayList<Table>> mat;
    static int filas;
    static int columnas;

    public Matriz() {
        this.filas = 0;
        this.columnas = 0;
        this.mat = new ArrayList<>();
    }

    public Matriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.mat = new ArrayList<>();

        for (int i = 0; i < filas; i++) {
            ArrayList<Table> fila = new ArrayList<>(columnas);
            for (int j = 0; j < columnas; j++)
                fila.add(new Table());
            mat.add((ArrayList<Table>) fila);
        }
    }

    public ArrayList<ArrayList<Table>> getMat() {
        return this.mat;
    }

    public int getNumeroFilas() {
        return this.filas;
    }

    public int getNumeroColumnas() {
        return this.columnas;
    }


    public void agregarTabla(Table l, int fila, int columna) {
        ArrayList<Table> f = this.mat.get(fila);
        f.set(columna, l);
    }

    public Table getPosicion(int fila, int columna) {
        ArrayList<Table> f = this.mat.get(fila);
        return f.get(columna);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++)
                if (mat.get(i).get(j) != null)
                    sb.append((mat.get(i).get(j)).getName()).append(" ");
                else
                    sb.append("0").append(" ");
            sb.append("\n");
        }
        return sb.toString();
    }
   public ArrayList promedio(){
       ArrayList<Double> promedios = new ArrayList();
       double suma = 0;
       double promedio = 0;
       double diferencia = 0;
       for (int i = 0; i < columnas; i++){
            for (int j = 0; j < filas; j++){
                if(j+1 < filas){
                    diferencia = mat.get(i).get(j+1).getRegistros() - mat.get(i).get(j).getRegistros();
                    suma += diferencia;
                }
            }
            promedios.add((suma/filas));
            suma = 0;
        }
        return promedios;
    }
   
   public ArrayList diarias(){
   ArrayList transacciones = new ArrayList();
       double suma = 0;
       ArrayList promedios = promedio();
       double diferencia = 0;
       for (int i = 0; i < columnas; i++){
            for (int j = 0; j < filas; j++){
//                    suma = (mat.get(i).get(j).getSize()) * (promedios.get(i));
                    suma += diferencia;
                
            }
            transacciones.add(suma/filas);
            suma = 0;
        }
        return promedios;
   }

}
