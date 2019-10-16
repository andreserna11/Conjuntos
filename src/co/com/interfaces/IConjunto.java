package co.com.interfaces;

public interface IConjunto {

    void pertenece(Integer dato);

    Boolean subconjunto(IConjunto conjunto);

    Boolean esVacio();

    IConjunto union(IConjunto conjunto);

    IConjunto interseccion(IConjunto conjunto);

    IConjunto igualdad(IConjunto conjunto);

    IConjunto complemento();

    void agregar(Integer dato);

    void borrar(Integer dato);

    void vaciar();

    IConjunto diferencia(IConjunto conjunto);

    IConjunto diferenciaSimetrica(IConjunto conjunto);
}
