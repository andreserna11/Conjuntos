package co.com.vector.entidades;

import co.com.interfaces.IConjunto;

import java.util.Arrays;

public class ConjuntoVector implements IConjunto {

    private Integer cantidad;
    private Integer[] vec;

    public ConjuntoVector() {
    }

    public ConjuntoVector(Integer cantidad, Integer[] vec) {
        this.cantidad = cantidad;
        this.vec = vec;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer[] getVec() {
        return vec;
    }

    public void setVec(Integer[] vec) {
        this.vec = vec;
    }

    public Integer getDato(Integer posicion){
        return getVec()[posicion];
    }

    public void setDato(Integer dato, Integer posicion){
        getVec()[posicion] = dato;
    }

    @Override
    public void pertenece(Integer dato) {
        try {
            getPosicion(dato);
            System.out.print("El dato pertenece al conjunto");
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }

    @Override
    public Boolean subconjunto(IConjunto conjunto) {
        return null;
    }

    @Override
    public Boolean esVacio() {
        if(getVec() != null && getCantidad() == 0)
            return true;
        return false;
    }

    @Override
    public IConjunto union(IConjunto conjunto) {
        return null;
    }

    @Override
    public IConjunto interseccion(IConjunto conjunto) {
        return null;
    }

    @Override
    public IConjunto igualdad(IConjunto conjunto) {
        return null;
    }

    @Override
    public IConjunto complemento() {
        return null;
    }

    @Override
    public void agregar(Integer dato) {

    }

    @Override
    public void borrar(Integer dato) {

    }

    @Override
    public void vaciar() {
        setVec(new Integer[0]);
        setCantidad(0);
    }

    @Override
    public IConjunto diferencia(IConjunto conjunto) {
        return null;
    }

    @Override
    public IConjunto diferenciaSimetrica(IConjunto conjunto) {
        return null;
    }

    private Integer getPosicion(Integer dato) throws Exception {
        Boolean existe = false;
        Integer posicion = 0;
        for (int i = 0; i < getCantidad(); i++) {
            Integer elemento = getVec()[i];
            posicion = i;
            if(!existe){
                if(elemento.equals(dato))
                    existe = true;
            }else{
                break;
            }
        }

        if(!existe)
            throw new Exception("No se encontró el elemento");
        return posicion;
    }
}
