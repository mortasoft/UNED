package main;

import java.util.Date;

public class ListaEnlazada {

    private Nodo raiz;
    private int consecutivo;

    public ListaEnlazada() {
        raiz = null;
        consecutivo = 1;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }
    
    public int nextConsecutivo(){
       int consecutivoTmp = this.getConsecutivo();
       int nuevo = consecutivoTmp++;
       this.setConsecutivo(nuevo);
       return consecutivoTmp;
    }

    public void insertar(Date fecha, String hora, String localizacion, int profundidad, int magnitud) {
        Nodo nuevo;
        int conse = nextConsecutivo();
        Evento miEvento = new Evento(conse,fecha,hora,localizacion,profundidad,magnitud);
        nuevo = new Nodo(miEvento);

        if (raiz == null) {
            nuevo.setSiguiente(null);
            raiz = nuevo;
        } else {
            nuevo.setSiguiente(raiz);
            raiz = nuevo;
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    

}
