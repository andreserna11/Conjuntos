/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.listas.entidades;

import co.com.interfaces.IConjunto;
import co.com.vector.entidades.ConjuntoVectorUniversal;

/**
 *
 * @author EYELINE
 */
public class ConjuntoLista implements IConjunto {

    private Lista lista;

    public ConjuntoLista() {
        this.lista = new Lista();
    }

    private Lista getLista() {
        return this.lista;
    }

    private void setLista(Lista lista) {
        this.lista = lista;
    }

    @Override
    public Boolean pertenece(Integer dato) {
        return this.lista.buscarDato(dato) != null;
    }

    @Override
    public Boolean subconjunto(IConjunto conjuntoB) {
        boolean esSubconjunto = true;
        int tamanoConjuntoB = conjuntoB.obtenerTamano();
        if (tamanoConjuntoB <= this.lista.getCantidadElementos()) {
            for (int i = 0; i < tamanoConjuntoB; i++) {
                int dato = conjuntoB.obtenerDato(i);
                if (!this.pertenece(dato)) {
                    esSubconjunto = false;
                    break;
                }
            }
        } else {
            esSubconjunto = false;
        }
        return esSubconjunto;
    }

    @Override
    public Boolean esVacio() {
        return this.getLista().getPadre() == null;
    }

    @Override
    public IConjunto union(IConjunto conjuntoB) {
        ConjuntoLista conjuntoUnion = null;
        if (ConjuntoVectorUniversal.obtenerUniversal().subconjunto(conjuntoB)) {
            conjuntoUnion = new ConjuntoLista();
            unirConjuntos(conjuntoUnion, this);
            unirConjuntos(conjuntoUnion, conjuntoB);
        } else {
            System.out.println("no se puede realizar la operación");
        }
        return conjuntoUnion;
    }

    @Override
    public IConjunto interseccion(IConjunto conjuntoB) {
        ConjuntoLista conjuntoInterseccion = null;
        if (ConjuntoVectorUniversal.obtenerUniversal().subconjunto(conjuntoB)) {
            conjuntoInterseccion = new ConjuntoLista();
            Nodo aux = this.lista.getPadre();
            while (aux != null) {
                int dato = aux.getDato();
                if (conjuntoB.pertenece(dato)) {
                    conjuntoInterseccion.agregar(dato);
                }
                aux = aux.getLigaSiguiente();
            }
        } else {
            System.out.println("no se puede realizar la operación");
        }
        return conjuntoInterseccion;
    }

    @Override
    public Boolean igualdad(IConjunto conjuntoB) {
        boolean iguales = true;
        if (ConjuntoVectorUniversal.obtenerUniversal().subconjunto(conjuntoB)) {
            if (this.obtenerTamano().equals(conjuntoB.obtenerTamano())) {
                Nodo aux = this.lista.getPadre();
                while (aux != null && iguales) {
                    int dato = aux.getDato();
                    if (conjuntoB.pertenece(dato)) {
                        aux = aux.getLigaSiguiente();
                    } else {
                        iguales = false;
                    }
                }
            } else {
                iguales = false;
            }
        } else {
            System.out.println("no se puede realizar la operación");
        }
        return iguales;
    }

    @Override
    public IConjunto complemento() {
        ConjuntoLista conjuntoComplemento = new ConjuntoLista();
        IConjunto conjuntoUniversal = ConjuntoVectorUniversal.obtenerUniversal();
        for (int i = 0; i < conjuntoUniversal.obtenerTamano(); i++) {
            int dato = conjuntoUniversal.obtenerDato(i);
            if (!this.pertenece(dato)) {
                conjuntoComplemento.agregar(dato);
            }
        }
        return conjuntoComplemento;
    }

    @Override
    public void agregar(Integer dato) {
        if (ConjuntoVectorUniversal.obtenerUniversal().pertenece(dato) && !this.pertenece(dato)) {
            this.lista.insertarNodo(dato);
        } else {
            System.out.println("no se puede agregar el dato");
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
    public IConjunto diferencia(IConjunto conjuntoB) {
        ConjuntoLista conjuntoDiferencia = null;
        if (ConjuntoVectorUniversal.obtenerUniversal().subconjunto(conjuntoB)) {
            conjuntoDiferencia = new ConjuntoLista();
            Nodo aux = this.lista.getPadre();
            while (aux != null) {
                int dato = aux.getDato();
                if (!conjuntoB.pertenece(dato)) {
                    conjuntoDiferencia.agregar(dato);
                }
                aux = aux.getLigaSiguiente();
            }
        } else {
            System.out.println("no se puede realizar la operación");
        }
        return conjuntoDiferencia;
    }

    @Override
    public IConjunto diferenciaSimetrica(IConjunto conjuntoB) {
        IConjunto conjuntoDiferencia = null;
        if (ConjuntoVectorUniversal.obtenerUniversal().subconjunto(conjuntoB)) {
            IConjunto conjutoDiferenciaAB = (ConjuntoLista) this.diferencia(conjuntoB);
            IConjunto conjutoDiferenciaBA = conjuntoB.diferencia(this);
            conjuntoDiferencia = conjutoDiferenciaAB.union(conjutoDiferenciaBA);
        } else {
            System.out.println("no se puede realizar la operación");
        }
        return conjuntoDiferencia;
    }

    @Override
    public Integer compararDimensionConjuntos(IConjunto conjuntoB) {
        Integer valor = null;
        if (ConjuntoVectorUniversal.obtenerUniversal().subconjunto(conjuntoB)) {
            ConjuntoLista conjuntoListaB = (ConjuntoLista) conjuntoB;
            int tamañoConjuntoA = this.lista.getCantidadElementos();
            int tamañoConjuntoB = conjuntoListaB.getLista().getCantidadElementos();
            valor = Integer.compare(tamañoConjuntoA, tamañoConjuntoB);
        } else {
            System.out.println("no se puede realizar la operación");
        }
        return valor;
    }

    @Override
    public Integer posicion(Integer dato) {
        return this.lista.buscarPosicion(dato);
    }

    public String mostrar() {
        return this.lista.recorrerLista();
    }

    private void unirConjuntos(IConjunto conjuntoUnion, IConjunto conjunto) {
        for (int i = 0; i < conjunto.obtenerTamano(); i++) {
            int dato = conjunto.obtenerDato(i);
            if (!conjuntoUnion.pertenece(dato)) {
                conjuntoUnion.agregar(dato);
            }
        }
    }

    @Override
    public Integer obtenerDato(Integer posicion) {
        return this.lista.obtenerDato(posicion);
    }

    @Override
    public Integer obtenerTamano() {
        return this.lista.getCantidadElementos();
    }

    @Override
    public String toString() {
        return "[" + this.mostrar() + "]";
    }
    
    
}
