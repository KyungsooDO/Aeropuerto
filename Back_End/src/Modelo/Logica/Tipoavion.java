package Modelo.Logica;

import java.util.List;

public class Tipoavion {

    private String idTipoAvion;
    private String modelo;
    private String marca;
    private String ano;
    private int cantidadAsientos;
    private int cantidadFilas;
    private int cantidadColumnas;
//    private List<Avion> avionList;

    public Tipoavion() {
//        this.avionList = null;
        this.idTipoAvion = "";
        this.modelo = "";
        this.marca = "";
        this.ano = "";
        this.cantidadAsientos = 0;
        this.cantidadColumnas = 0;
        this.cantidadFilas = 0;
    }

    public Tipoavion(String idTipoAvion) {
        this.idTipoAvion = idTipoAvion;
    }

    public Tipoavion(String idTipoAvion, String modelo, String marca, String ano, int cantidadAsientos, int cantidadFilas, int cantidadColumnas) {
        this.idTipoAvion = idTipoAvion;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.cantidadAsientos = cantidadAsientos;
        this.cantidadFilas = cantidadFilas;
        this.cantidadColumnas = cantidadColumnas;
//        this.avionList = avionList;
    }


    public String getIdTipoAvion() {
        return idTipoAvion;
    }

    public void setIdTipoAvion(String idTipoAvion) {
        this.idTipoAvion = idTipoAvion;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public int getCantidadFilas() {
        return cantidadFilas;
    }

    public void setCantidadFilas(int cantidadFilas) {
        this.cantidadFilas = cantidadFilas;
    }

    public int getCantidadColumnas() {
        return cantidadColumnas;
    }

    public void setCantidadColumnas(int cantidadColumnas) {
        this.cantidadColumnas = cantidadColumnas;
    }

//    public List<Avion> getAvionList() {
//        return avionList;
//    }
//
//    public void setAvionList(List<Avion> avionList) {
//        this.avionList = avionList;
//    }

    @Override
    public String toString() {
        return this.getModelo();
    }

}
