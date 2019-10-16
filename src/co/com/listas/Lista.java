/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.listas;

import co.com.entidades.Nodo;

public class Lista {

    private Nodo padre;

    public Lista() {

    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public void recorrerLista() {
        Nodo aux = this.padre;
        Nodo ant = null;
        while (aux != null) {
            ant = aux;
            aux = aux.getLigaSiguiente();
            System.out.print(ant.getDato() +", ");
        }
    }

    public void insertarNodo(Character dato) {
        if (getPadre() == null) {
            Nodo nuevoNodo = new Nodo(null, Boolean.TRUE, dato, null);
            setPadre(nuevoNodo);
        } else {
            Nodo ant = encontrarUltimo();
            Nodo nuevoNodo = new Nodo(ant, Boolean.FALSE, dato, null);
            ant.setLigaSiguiente(nuevoNodo);
        }
        System.out.println("Se inserto el nodo correctamente.");
    }

    public void eliminarNodo(Character dato) {
        Nodo aux = this.padre;
        Nodo ant = null;
        while (aux != null) {
            if (aux.getDato().equals(dato)) {
                if (aux.getIsPadre() && aux.getLigaSiguiente() != null) {
                    setPadre(aux.getLigaSiguiente());
                } else if (aux.getIsPadre() && aux.getLigaSiguiente() == null) {
                    this.padre = null;
                } else {
                    ant.setLigaSiguiente(aux.getLigaSiguiente());
                    aux.getLigaSiguiente().setLigaAnterior(ant);
                }
            }
            ant = aux;
            aux = aux.getLigaSiguiente();
        }
    }

    public Integer getCantidadElementos() {
        int cant = 0;
        Nodo aux = this.padre;
        Nodo ant = aux;
        while (aux != null) {
            cant += 1;
            aux = aux.getLigaSiguiente();
        }
        System.out.println("La cantidad de elementos es: " + cant);
        return cant;
    }

    private Nodo encontrarUltimo() {
        Nodo aux = this.padre;
        Nodo ant = null;
        while (aux != null) {
            ant = aux;
            aux = aux.getLigaSiguiente();
            System.out.println("Nodos -> " + ant.getDato());
        }
        return ant;
    }

}
