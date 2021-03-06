package Modelo.Logica;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Vuelo {

    private String idVuelo;
    private String dia;
    private String hora;
    private String duracion;
    private List<Fechavuelo> fechavueloList;
    private Avion avion;
    private Ciudad ciudad;
    private Ciudad ciudad1;

    public Vuelo() {
    }

    public Vuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Vuelo(String idVuelo, String dia, String hora, String duracion) {
        this.idVuelo = idVuelo;
        this.dia = dia;
        this.hora = hora;
        this.duracion = duracion;
    }

    public Vuelo(String idVuelo, String dia, String hora, String duracion, Avion avion, Ciudad ciudad, Ciudad ciudad1) {
        this.idVuelo = idVuelo;
        this.dia = dia;
        this.hora = hora;
        this.duracion = duracion;
        this.avion = avion;
        this.ciudad = ciudad;
        this.ciudad1 = ciudad1;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public String getHoraString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(hora);
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getDuracionString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(duracion);
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public List<Fechavuelo> getFechavueloList() {
        return fechavueloList;
    }

    public void setFechavueloList(List<Fechavuelo> fechavueloList) {
        this.fechavueloList = fechavueloList;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad getCiudad1() {
        return ciudad1;
    }

    public void setCiudad1(Ciudad ciudad1) {
        this.ciudad1 = ciudad1;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "idVuelo=" + idVuelo + ", dia=" + dia + ", hora=" + hora + ", duracion=" + duracion + ", fechavueloList=" + fechavueloList + ", avion=" + avion + ", ciudad=" + ciudad + ", ciudad1=" + ciudad1 + '}'+"////////////////////////////////////////////////////////////////";
    }
    

}
