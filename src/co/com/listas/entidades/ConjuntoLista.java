/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.listas.entidades;

import co.com.interfaces.IConjunto;

/**
 *
 * @author EYELINE
 */
public class ConjuntoLista implements IConjunto {

    private ConjuntoLista universal;
    private Lista lista;

    public ConjuntoLista() {
        this.lista = new Lista();
    }

    public ConjuntoLista(ConjuntoLista universal) {
        this();
        this.universal = universal;
    }

    private Lista getLista() {
        return this.lista;
    }

    private void setLista(Lista lista) {
        this.lista = lista;
    }

    @Override
    public void pertenece(Integer dato) {
        if (this.lista.buscarDato(dato) != null) {
            System.out.println("el elemento pertenece al conjunto");
        } else {
            System.out.println("el elemento no pertenece al conjunto");
        }
    }

    @Override
    public Boolean subconjunto(IConjunto conjunto) {
        boolean esSubconjunto = true;
        if (!this.validarTipoConjunto(conjunto)) {
            esSubconjunto = false;
        } else {
            ConjuntoLista subconjunto = (ConjuntoLista) conjunto;
            Lista listaSubconjunto = subconjunto.getLista();
            Nodo aux = listaSubconjunto.getPadre();
            if (listaSubconjunto.getCantidadElementos() <= this.lista.getCantidadElementos()) {
                while (aux != null && esSubconjunto) {
                    esSubconjunto = this.lista.buscarDato(aux.getDato()) != null;
                    aux = aux.getLigaSiguiente();
                }
            } else {
                esSubconjunto = false;
            }
        }
        return esSubconjunto;
    }

    @Override
    public Boolean esVacio() {
        return this.getLista().getPadre() == null;
    }

    @Override
    public IConjunto union(IConjunto conjunto) {
        ConjuntoLista conjuntoUnion = null;
        if (validarTipoConjunto(conjunto)) {
            conjuntoUnion = new ConjuntoLista();
            unirConjuntos(conjuntoUnion, this);
            unirConjuntos(conjuntoUnion, (ConjuntoLista) conjunto);
        }
        return conjuntoUnion;
    }

    @Override
    public IConjunto interseccion(IConjunto conjunto) {
        ConjuntoLista conjuntoInterseccion = null;
        if (validarTipoConjunto(conjunto)) {
            conjuntoInterseccion = new ConjuntoLista();
            Lista listaConjuntoB = ((ConjuntoLista) conjunto).getLista();
            Nodo aux = this.lista.getPadre();
            while (aux != null) {
                int dato = aux.getDato();
                if (listaConjuntoB.buscarDato(dato) != null) {
                    conjuntoInterseccion.agregar(dato);
                }
                aux = aux.getLigaSiguiente();
            }
        }
        return conjuntoInterseccion;
    }

    @Override
    public Boolean igualdad(IConjunto conjunto) {
        boolean iguales = true;
        if (validarTipoConjunto(conjunto)) {
            ConjuntoLista conjuntoB = (ConjuntoLista) conjunto;
            Lista listaConjuntoB = conjuntoB.getLista();
            if (this.lista.getCantidadElementos() == listaConjuntoB.getCantidadElementos()) {
                Nodo aux = this.lista.getPadre();
                while (aux != null && iguales) {
                    int dato = aux.getDato();
                    iguales = listaConjuntoB.buscarDato(dato) != null;
                    if (iguales) {
                        aux = aux.getLigaSiguiente();
                    }
                }
            } else {
                iguales = false;
            }
        }
        return iguales;
    }

    @Override
    public IConjunto complemento() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void agregar(Integer dato) {
        if (this.lista.buscarDato(dato) == null) {
            this.lista.insertarNodo(dato);
        }
    }

    @Override
    public void borrar(Integer dato) {
        this.lista.eliminarNodo(dato);
    }

    @Override
    public void vaciar() {
        this.setLista(new Lista());
    }

    @Override
    public IConjunto diferencia(IConjunto conjunto) {
        ConjuntoLista conjuntoDiferencia = null;
        if (validarTipoConjunto(conjunto)) {
            conjuntoDiferencia = new ConjuntoLista();
            ConjuntoLista conjuntoB = (ConjuntoLista) conjunto;
            Lista listaConjuntoB = conjuntoB.getLista();
            Nodo aux = this.lista.getPadre();
            while (aux != null) {
                int dato = aux.getDato();
                if (listaConjuntoB.buscarDato(dato) == null) {
                    conjuntoDiferencia.agregar(dato);
                }
                aux = aux.getLigaSiguiente();
            }
        }
        return conjuntoDiferencia;
    }

    @Override
    public IConjunto diferenciaSimetrica(IConjunto conjunto) {
        IConjunto conjuntoDiferencia = null;
        if (validarTipoConjunto(conjunto)) {
            ConjuntoLista conjuntoB = (ConjuntoLista) conjunto;
            ConjuntoLista conjutoDiferenciaAB = (ConjuntoLista) this.diferencia(conjuntoB);
            ConjuntoLista conjutoDiferenciaBA = (ConjuntoLista) conjuntoB.diferencia(this);
            conjuntoDiferencia = (ConjuntoLista) conjutoDiferenciaAB.union(conjutoDiferenciaBA);
        }
        return conjuntoDiferencia;
    }

    @Override
    public Integer compararDimensionConjuntos(IConjunto conjuntoB) {
        Integer valor = null;
        if (validarTipoConjunto(conjuntoB)) {
            ConjuntoLista conjuntoListaB = (ConjuntoLista) conjuntoB;
            int tamañoConjuntoA = this.lista.getCantidadElementos();
            int tamañoConjuntoB = conjuntoListaB.getLista().getCantidadElementos();
            valor = Integer.compare(tamañoConjuntoA, tamañoConjuntoB);
        }
        return valor;
    }

    @Override
    public Integer posicion(Integer dato) {
        return this.lista.buscarPosicion(dato);
    }

    private boolean validarTipoConjunto(IConjunto conjunto) {
        boolean esLista = conjunto instanceof ConjuntoLista;
        if (!esLista) {
            System.out.println("El conjunto no es una lista");
        }
        return esLista;
    }

    public void mostrar() {
        this.lista.recorrerLista();
    }

    private void unirConjuntos(ConjuntoLista conjuntoUnion, ConjuntoLista conjunto) {
        Lista listaConjunto = conjunto.getLista();
        Nodo aux = listaConjunto.getPadre();
        while (aux != null) {
            int dato = aux.getDato();
            conjuntoUnion.agregar(dato);
            aux = aux.getLigaSiguiente();
        }
    }
}
