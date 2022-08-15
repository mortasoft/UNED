package arbolBB;

import java.util.LinkedList;
import javax.swing.JPanel;

public class ArbolBB {

    private Nodo raiz;
    int alt;

    public ArbolBB() {
        raiz = null;
    }

    public boolean agregar(char dato) {
        Nodo nuevo = new Nodo(dato, null, null);

        // Valida si es una letra y no un caracter especial o un numero
        if (Character.isLetter(dato)) {

            // Valida si ya existe en el arbol o no
            if (!existe(dato)) {
                insertar(nuevo, raiz);
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    //Metodo para insertar un dato en el arbol...no acepta repetidos :)
    public void insertar(Nodo nuevo, Nodo pivote) {
        if (this.raiz == null) {
            raiz = nuevo;
        } else {
            if (nuevo.getDato() <= pivote.getDato()) {
                if (pivote.getIzq() == null) {
                    pivote.setIzq(nuevo);
                } else {
                    insertar(nuevo, pivote.getIzq());
                }
            } else {
                if (pivote.getDer() == null) {
                    pivote.setDer(nuevo);
                } else {
                    insertar(nuevo, pivote.getDer());
                }
            }
        }

    }

    public Nodo borrar(char dato) {

        return delete(raiz, dato);

    }

    public Nodo delete(Nodo root, char key) {

        if (getAltura() == 1) {
            raiz = null;
            return raiz;
        }

        if (root == null) {
            return root;
        }
        if (key > root.getDato()) { //move right
            root.setDer(delete(root.getDer(), key));
        } else if (key < root.getDato()) { //move left
            root.setIzq(delete(root.getIzq(), key));
        } else { //oh yes, we finally found the target
            if (root.getIzq() == null && root.getDer() == null) { //hmm, its a leaf node; easy peasy
                root = null;
            } else if (root.getDer() != null) { // oh, it has a right child, don't make it an orphan or is it old enough to become a parent ? lets find out
                root.setDato(sucesor(root)); // my worthy successor
                root.setDer(delete(root.getDer(), root.getDato()));
            } else { //oh it seems that I do not have a worthy successor, fallback, fallback ...
                root.setDato(predecesor(root));
                root.setIzq(delete(root.getIzq(), root.getDato()));
            }
        }
        return root;
    }

    private char sucesor(Nodo root) {
        root = root.getDer();
        while (root.getIzq() != null) {
            root = root.getIzq();
        }
        return root.getDato();
    }

    private char predecesor(Nodo root) {
        root = root.getIzq();
        while (root.getDer() != null) {
            root = root.getDer();
        }
        return root.getDato();
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    //Recorrido preorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(raiz, rec);
        return rec;
    }

    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getDato());
            preorden(aux.getIzq(), recorrido);
            preorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(raiz, rec);
        return rec;
    }

    public void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getIzq(), recorrido);
            recorrido.add(aux.getDato());
            inorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido postorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(raiz, rec);
        return rec;
    }

    public void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getIzq(), recorrido);
            postorden(aux.getDer(), recorrido);
            recorrido.add(aux.getDato());
        }
    }

    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(char dato) {
        Nodo aux = raiz;
        while (aux != null) {
            if (dato == aux.getDato()) {
                return true;
            } else if (dato > aux.getDato()) {
                aux = aux.getDer();
            } else {
                aux = aux.getIzq();
            }
        }
        return false;
    }

    private void altura(Nodo aux, int nivel) {
        if (aux != null) {
            altura(aux.getIzq(), nivel + 1);
            alt = nivel;
            altura(aux.getDer(), nivel + 1);
        }
    }

    //Devuleve la altura del arbol
    public int getAltura() {
        altura(raiz, 1);
        return alt;
    }

    public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}
