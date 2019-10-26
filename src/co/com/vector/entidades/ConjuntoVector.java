package co.com.vector.entidades;

import co.com.interfaces.IConjunto;
public class ConjuntoVector implements IConjunto {
    
    public static final IConjunto CONJUNTO_UNIVERSAL = ConjuntoVectorUniversal.obtenerUniversal();
    private Integer[] vec;
    private Integer cantidad;

    public ConjuntoVector(Integer cantidad, Integer[] vec) {
        this.cantidad = cantidad;
        this.vec = vec;
    }

    public Integer[] getVec() {
        return vec;
    }

    public void setVec(Integer[] vec) {
        this.vec = vec;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public void setDato(Integer dato, Integer posicion) {
        getVec()[posicion] = dato;
    }

    @Override
    public Boolean pertenece(Integer dato) {
        if (elementoExiste(getVec(), dato)) {
            System.out.print("El elemento pertenece al conjunto \n");
            return true;
        } else {
            System.out.print("El elemento NO pertenece al conjunto \n");            
        }
        return false;
    }

    @Override
    public Boolean subconjunto(IConjunto conjunto) {
        return null;
    }

    @Override
    public Boolean esVacio() {
        if (getVec() != null && obtenerTamano() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public IConjunto union(IConjunto conjunto) {
        ConjuntoVector conjuntoB = (ConjuntoVector) conjunto;
        Integer[] vectorResult = new Integer[0];
        ConjuntoVector result = new ConjuntoVector(0, vectorResult);

        for (int i = 0; i < obtenerTamano(); i++) {
            Integer elemento = obtenerDato(i);
            Boolean existe = elementoExiste(result.getVec(), elemento);
            if (!existe) {
                result.agregar(elemento);
            }
        }

        for (int i = 0; i < conjuntoB.obtenerTamano(); i++) {
            Integer elemento = conjuntoB.obtenerDato(i);
            Boolean existe = elementoExiste(result.getVec(), elemento);
            if (!existe) {
                result.agregar(elemento);
            }
        }

        return result;
    }

    @Override
    public IConjunto interseccion(IConjunto conjunto) {
        ConjuntoVector conjuntoB = (ConjuntoVector) conjunto;
        Integer conjuntoMayor = this.compararDimensionConjuntos(conjuntoB);
        Integer[] vectorResult = new Integer[0];
        ConjuntoVector result = new ConjuntoVector(0, vectorResult);

        if (conjuntoMayor.equals(0)) {
            for (int i = 0; i < conjuntoB.obtenerTamano(); i++) {
                Integer elementoB = conjuntoB.obtenerDato(i);
                if (elementoExiste(getVec(), elementoB)) {
                    result.agregar(elementoB);
                }
            }
        } else {
            for (int i = 0; i < obtenerTamano(); i++) {
                Integer elementoB = obtenerDato(i);
                if (elementoExiste(conjuntoB.getVec(), elementoB)) {
                    result.agregar(elementoB);
                }
            }
        }
        return result;
    }

    @Override
    public IConjunto complemento() {
        Integer[] vectorResult = new Integer[0];
        ConjuntoVector conjuntoComplemento = new ConjuntoVector(0, vectorResult);
        for (int i = 0; i < ConjuntoVectorUniversal.obtenerUniversal().obtenerTamano()- 1; i++) {
            if (!elementoExiste(getVec(), ConjuntoVectorUniversal.obtenerUniversal().obtenerDato(i))) {
                conjuntoComplemento.agregar(ConjuntoVectorUniversal.obtenerUniversal().obtenerDato(i));       
            }
        }        
        return conjuntoComplemento;
    }

    @Override
    public void agregar(Integer dato) {
        Integer[] newVector = new Integer[obtenerTamano() + 1];
        for (int i = 0; i <= obtenerTamano() - 1; i++) {
            newVector[i] = obtenerDato(i);
        }
        newVector[obtenerTamano()] = dato;
        setVec(newVector);
        setCantidad(obtenerTamano() + 1);
    }

    @Override
    public void vaciar() {
        setVec(new Integer[0]);
        setCantidad(0);
    }

    @Override
    public IConjunto diferencia(IConjunto conjunto) {
        ConjuntoVector conjuntoB = (ConjuntoVector) conjunto;
        Integer[] vectorResult = new Integer[0];
        ConjuntoVector result = new ConjuntoVector(0, vectorResult);
        for (int i = 0; i < obtenerTamano() - 1; i++) {
            Integer elemento = obtenerDato(i);
            if (!elementoExiste(conjuntoB.getVec(), elemento)) {
                result.agregar(elemento);
            }
        }
        return result;
    }

    @Override
    public IConjunto diferenciaSimetrica(IConjunto conjunto) {
        ConjuntoVector conjuntoB = (ConjuntoVector) conjunto;
        ConjuntoVector result = (ConjuntoVector) diferencia(conjuntoB);

        for (int i = 0; i < conjuntoB.obtenerTamano(); i++) {
            Integer elemento = conjuntoB.obtenerDato(i);
            if (!elementoExiste(getVec(), elemento)) {
                result.agregar(elemento);
            }
        }
        return result;
    }

    /**
     * @param conjuntoB Conjunto a comparar con el conjunto actual
     * @return 0 si el conjuntoA es mas grande que el conjuntoB, 1 en caso
     * contrario
     */
    @Override
    public Integer compararDimensionConjuntos(IConjunto conjuntoB) {
        return obtenerTamano() > ((ConjuntoVector) conjuntoB).obtenerTamano() ? 0 : 1;
    }

    /**
     * @param vec Vector de enteros en el que se va a buscar
     * @param elemento Elemento que se va a buscar en el vector
     * @return true si el elemento existe en el vector, false en caso contrario
     */
    private Boolean elementoExiste(Integer[] vec, Integer elemento) {
        for (int i = 0; i < vec.length; i++) {
            if (vec[i] == elemento) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer posicion(Integer dato) throws Exception {
        if (elementoExiste(vec, dato)) {
            for (int i = 0; i < obtenerTamano() - 1; i++) {
                if (obtenerDato(i) == dato) {
                    return i;
                }
            }
        }
        throw new Exception("El elemento no existe");
    }

    @Override
    public void borrar(Integer dato) {
        Integer[] updateVector = new Integer[obtenerTamano() - 1];
        for (int i = 0; i < obtenerTamano() - 1; i++) {
            if (obtenerDato(i) != dato) {
                updateVector[i] = obtenerDato(i);
            }
        }
        setVec(updateVector);
        setCantidad(obtenerTamano() - 1);
    }

    @Override
    public Boolean igualdad(IConjunto conjunto) {
        if (obtenerTamano() == conjunto.obtenerTamano()) {
            for (int i = 0; i < obtenerTamano() - 1; i++) {
                if (conjunto.obtenerDato(i) != null) {
                    continue;
                } else {
                    return false;

                }
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public Integer obtenerDato(Integer posicion) {
        return getVec()[posicion];
    }

    @Override
    public Integer obtenerTamano() {
        return this.cantidad;
    }
}
