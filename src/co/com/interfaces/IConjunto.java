package co.com.interfaces;

import co.com.vector.entidades.ConjuntoVector;

public interface IConjunto {

    void pertenece(Integer dato);

    Boolean subconjunto(IConjunto conjunto);

    Boolean esVacio();

    IConjunto union(IConjunto conjunto) throws Exception;

    IConjunto interseccion(IConjunto conjunto);

    Boolean igualdad(IConjunto conjunto);

    IConjunto complemento();

    void agregar(Integer dato) throws Exception;

    void borrar(Integer dato);

    void vaciar();

    IConjunto diferencia(IConjunto conjunto);

    IConjunto diferenciaSimetrica(IConjunto conjunto);

    Integer compararDimensionConjuntos(IConjunto conjuntoB);

    Integer posicion(Integer dato) throws Exception;
    
    Integer obtenerDato(Integer posicion);

}