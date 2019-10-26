/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.listas.entidades;

import java.util.Arrays;

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

    public String recorrerLista() {
        Nodo aux = this.padre;
        Nodo ant = null;
        StringBuilder sb = new StringBuilder();
        int tope = 0;
        while (aux != null) {
            ant = aux;
            sb.append(ant.getDato());
            if (aux.getLigaSiguiente() != null)
                sb.append(",");
            aux = aux.getLigaSiguiente();
        }
        return sb.toString();
    }

    public void insertarNodo(Integer dato) {
        if (getPadre() == null) {
            Nodo nuevoNodo = new Nodo(dato, null);
            setPadre(nuevoNodo);
        } else {
            Nodo ant = encontrarUltimo();
            Nodo nuevoNodo = new Nodo(dato, null);
            ant.setLigaSiguiente(nuevoNodo);
        }
    }

    public void eliminarNodo(Integer dato) {
        Nodo aux = this.padre;
        Nodo ant = null;
        while (aux != null) {
            if (aux.getDato().equals(dato)) {
                if (aux == this.padre) {
                    setPadre(aux.getLigaSiguiente());
                } else {
                    ant.setLigaSiguiente(aux.getLigaSiguiente());
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
        // System.out.println("La cantidad de elementos es: " + cant);
        return cant;
    }

    private Nodo encontrarUltimo() {
        Nodo aux = this.padre;
        Nodo ant = null;
        while (aux != null) {
            ant = aux;
            aux = aux.getLigaSiguiente();
            // System.out.println("Nodos -> " + ant.getDato());
        }
        return ant;
    }

    public Nodo buscarDato(int dato) {
        Nodo aux = this.padre;
        Nodo resultado = null;
        while (aux != null && resultado == null) {
            if (aux.getDato() == dato) {
                resultado = aux;
            } else {
                aux = aux.getLigaSiguiente();
            }
        }
        return resultado;
    }

    public Integer buscarPosicion(int dato) {
        Nodo aux = this.padre;
        int resultado = -1;
        int index = 0;
        while (aux != null && resultado == -1) {
            if (aux.getDato() == dato) {
                resultado = index;
            } else {
                aux = aux.getLigaSiguiente();
                index++;
            }
        }
        return resultado;
    }

}
