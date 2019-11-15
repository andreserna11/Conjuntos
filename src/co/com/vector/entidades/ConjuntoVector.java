package co.com.vector.entidades;

import java.util.Arrays;
import co.com.interfaces.IConjunto;
public class ConjuntoVector implements IConjunto {
    
    public static final IConjunto CONJUNTO_UNIVERSAL = ConjuntoVectorUniversal.obtenerUniversal();
    private Integer[] vec;
    
    public ConjuntoVector(Integer[] vec) {
        this.vec = vec;
    }

    public Integer[] getVec() {
        return vec;
    }

    public void setVec(Integer[] vec) {
        this.vec = vec;
    }
    
    public void setDato(Integer dato, Integer posicion) {
        getVec()[posicion] = dato;
    }

    @Override
    public Boolean pertenece(Integer dato) {
        return elementoExiste(getVec(), dato);
    }

    @Override
    public Boolean subconjunto(IConjunto conjuntoB) {
        int tamanoConjuntoB = conjuntoB.obtenerTamano();
        boolean esSubconjunto = true;
        if (tamanoConjuntoB <= this.obtenerTamano()) {
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
        if (getVec() != null && obtenerTamano() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public IConjunto union(IConjunto conjuntoB) {
        Integer[] vectorResult = new Integer[0];
        ConjuntoVector result = new ConjuntoVector(vectorResult);

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
    public IConjunto interseccion(IConjunto conjuntoB) {
        Integer conjuntoMayor = this.compararDimensionConjuntos(conjuntoB);
        Integer[] vectorResult = new Integer[0];
        ConjuntoVector result = new ConjuntoVector(vectorResult);

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
                if (conjuntoB.pertenece(elementoB)) {
                    result.agregar(elementoB);
                }
            }
        }
        return result;
    }

    @Override
    public IConjunto complemento() {
        Integer[] vectorResult = new Integer[0];
        ConjuntoVector conjuntoComplemento = new ConjuntoVector(vectorResult);
        for (int i = 0; i < ConjuntoVectorUniversal.obtenerUniversal().obtenerTamano(); i++) {
            if (!elementoExiste(getVec(), ConjuntoVectorUniversal.obtenerUniversal().obtenerDato(i))) {
                conjuntoComplemento.agregar(ConjuntoVectorUniversal.obtenerUniversal().obtenerDato(i));       
            }
        }        
        return conjuntoComplemento;
    }

    @Override
    public void agregar(Integer dato) {
        if (!pertenece(dato)) {
            Integer[] newVector = new Integer[obtenerTamano() + 1];
            for (int i = 0; i <= obtenerTamano() - 1; i++) {
                newVector[i] = obtenerDato(i);
            }
            newVector[obtenerTamano()] = dato;
            setVec(newVector);
        }
    }

    @Override
    public void vaciar() {
        setVec(new Integer[0]);
    }

    @Override
    public IConjunto diferencia(IConjunto conjuntoB) {
        Integer[] vectorResult = new Integer[0];
        ConjuntoVector result = new ConjuntoVector(vectorResult);
        for (int i = 0; i < obtenerTamano(); i++) {
            Integer elemento = obtenerDato(i);
            if (!conjuntoB.pertenece(elemento)) {
                result.agregar(elemento);
            }
        }
        return result;
    }

    @Override
    public IConjunto diferenciaSimetrica(IConjunto conjuntoB) {
        IConjunto diferenciaAB = diferencia(conjuntoB);
        IConjunto diferenciaBA = conjuntoB.diferencia(this);
        IConjunto result = diferenciaAB.union(diferenciaBA);
        return result;
    }

    /**
     * @param conjuntoB Conjunto a comparar con el conjunto actual
     * @return 0 si el conjuntoA es mas grande que el conjuntoB, 1 en caso
     * contrario
     */
    @Override
    public Integer compararDimensionConjuntos(IConjunto conjuntoB) {
        return obtenerTamano() > conjuntoB.obtenerTamano()? 0 : 1;
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
        int nuevoTamano = obtenerTamano() - 1;
        Integer[] updateVector = new Integer[nuevoTamano];
        int indexInsert = 0;
        for (int i = 0; i < nuevoTamano; i++) {
            Integer datoVec = obtenerDato(indexInsert);
            if (datoVec.equals(datoVec)) {
                indexInsert++;
                datoVec = obtenerDato(indexInsert);
            }
            updateVector[i] = datoVec;
        }
        setVec(updateVector);
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
        return this.vec.length;
    }
    
    @Override 
    public String toString(){
        return Arrays.toString(this.getVec());
    }
}
