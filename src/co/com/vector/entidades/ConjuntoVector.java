package co.com.vector.entidades;

import co.com.interfaces.IConjunto;

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

    public Integer getDato(Integer posicion) {
        return getVec()[posicion];
    }

    public void setDato(Integer dato, Integer posicion) {
        getVec()[posicion] = dato;
    }

    @Override
    public void pertenece(Integer dato) {
        if (elementoExiste(getVec(), dato)) {
            System.out.print("El elemento pertenece al conjunto");
        } else {
            System.out.print("El elemento NO pertenece al conjunto");
        }
    }

    @Override
    public Boolean subconjunto(IConjunto conjunto) {
        ConjuntoVector conjuntoB = (ConjuntoVector) conjunto;
        for (int i = 0; i < conjuntoB.getCantidad() - 1; i++) {
            if (!elementoExiste(vec, conjuntoB.getDato(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean esVacio() {
        if (getVec() != null && getCantidad() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public IConjunto union(IConjunto conjunto) {
        ConjuntoVector conjuntoB = (ConjuntoVector) conjunto;
        Integer[] vectorResult = new Integer[0];
        ConjuntoVector result = new ConjuntoVector(0, vectorResult);

        for (int i = 0; i < getCantidad(); i++) {
            Integer elemento = getVec()[i];
            Boolean existe = elementoExiste(result.getVec(), elemento);
            if (!existe) {
                result.agregar(elemento);
            }
        }

        for (int i = 0; i < conjuntoB.getCantidad(); i++) {
            Integer elemento = conjuntoB.getVec()[i];
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
            for (int i = 0; i < conjuntoB.getCantidad(); i++) {
                Integer elementoB = conjuntoB.getVec()[i];
                if (elementoExiste(getVec(), elementoB)) {
                    result.agregar(elementoB);
                }
            }
        } else {
            for (int i = 0; i < getCantidad(); i++) {
                Integer elementoB = getVec()[i];
                if (elementoExiste(conjuntoB.getVec(), elementoB)) {
                    result.agregar(elementoB);
                }
            }
        }
        return result;
    }

    @Override
    public IConjunto complemento() {
        return null;
    }

    @Override
    public void agregar(Integer dato) {
        Integer[] newVector = new Integer[getCantidad() + 1];
        for (int i = 0; i <= getCantidad() - 1; i++) {
            newVector[i] = getVec()[i];
        }
        newVector[getCantidad()] = dato;
        setVec(newVector);
        setCantidad(getCantidad() + 1);
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
        for (int i = 0; i < getCantidad() - 1; i++) {
            Integer elemento = getVec()[i];
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

        for (int i = 0; i < conjuntoB.getCantidad(); i++) {
            Integer elemento = conjuntoB.getVec()[i];
            if (!elementoExiste(getVec(), elemento)) {
                result.agregar(elemento);
            }
        }
        return result;
    }

    /**
     * @param conjuntoB Conjunto a comparar con el conjunto actual
     * @return 0 si el conjuntoA es mas grande que el conjuntoB, 1 en caso contrario
     */
    @Override
    public Integer compararDimensionConjuntos(IConjunto conjuntoB) {
        return getCantidad() > ((ConjuntoVector) conjuntoB).getCantidad() ? 0 : 1;
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
            for (int i = 0; i < getCantidad() - 1; i++) {
                if (getVec()[i] == dato) {
                    return i;
                }
            }
        }
        throw new Exception("El elemento no existe");
    }

    @Override
    public void borrar(Integer dato) {
        Integer[] updateVector = new Integer[getCantidad() - 1];
        for (int i = 0; i < getCantidad() - 1; i++) {
            if (getVec()[i] != dato) {
                updateVector[i] = getVec()[i];
            }
        }
        setVec(updateVector);
        setCantidad(getCantidad() - 1);
    }

    @Override
    public Boolean igualdad(IConjunto conjunto) {
        ConjuntoVector conjuntoB = (ConjuntoVector) conjunto;
        if (getCantidad() == conjuntoB.getCantidad()) {
            for (int i = 0; i < getCantidad() - 1; i++) {
                if (elementoExiste(conjuntoB.getVec(), getVec()[i])) {
                    continue;
                } else {
                    return false;

                }
            }
        }
        return true;
    }
}
