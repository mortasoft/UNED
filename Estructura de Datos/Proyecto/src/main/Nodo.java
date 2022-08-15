package main;

public class Nodo {

    private Evento dato;
    private Nodo siguiente;

    public Nodo() {
    }

    public Nodo(Evento dato) {
        this.dato = dato;
    }

    public Evento getDato() {
        return dato;
    }

    public void setDato(Evento dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
