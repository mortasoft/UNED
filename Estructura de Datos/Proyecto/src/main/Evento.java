package main;

import java.util.Date;

public class Evento {

    private int id;
    private Date fecha;
    private String hora;
    private String localizacion;
    private int profundidad;
    private int magnitud;

    public Evento(int id, Date fecha, String hora, String localizacion, int profundidad, int magnitud) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.localizacion = localizacion;
        this.profundidad = profundidad;
        this.magnitud = magnitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public int getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(int magnitud) {
        this.magnitud = magnitud;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", localizacion=" + localizacion + ", profundidad=" + profundidad + ", magnitud=" + magnitud + '}';
    }

}
