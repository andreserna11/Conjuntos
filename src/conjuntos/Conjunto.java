/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import co.com.interfaces.IConjunto;
import co.com.utilidades.Utilidades;
import co.com.vector.entidades.ConjuntoVector;
import co.com.listas.entidades.ConjuntoLista;
import co.com.vector.entidades.ConjuntoVectorUniversal;
import java.util.Arrays;

public class Conjunto {
    
    public static void main(String[] args) {
//        vectores();
        listas();
    }
    
    private static void vectores() {
        IConjunto conjuntoUniversal = ConjuntoVectorUniversal.obtenerUniversal();
        System.out.println("Universal: " +  conjuntoUniversal);
        IConjunto conjuntoVectorA = new ConjuntoVector(new Integer[0]);
        IConjunto conjuntoVectorB = new ConjuntoVector(new Integer[0]);
        IConjunto conjuntoVectorC = new ConjuntoVector(new Integer[0]);
        for (int i = 0; i < conjuntoUniversal.obtenerTamano() / 2; i++) {
            conjuntoVectorA.agregar(conjuntoUniversal.obtenerDato(i));
            conjuntoVectorB.agregar(conjuntoUniversal.obtenerDato(i+3));
        }
        for (int i = 0; i < conjuntoVectorA.obtenerTamano() - 1; i++) {
            conjuntoVectorC.agregar(conjuntoVectorA.obtenerDato(i));
        }
        int primerDatoA = conjuntoVectorA.obtenerDato(0);
        System.out.println("conjunto A: " + conjuntoVectorA);
        System.out.println("conjunto B: " + conjuntoVectorB);
        System.out.println("conjunto C: " + conjuntoVectorC);
        System.out.println("AUB: " +  conjuntoVectorA.union(conjuntoVectorB));
        System.out.println("BUA: " +  conjuntoVectorB.union(conjuntoVectorA));
        System.out.println("AUB == BUA: " + conjuntoVectorA.union(conjuntoVectorB).igualdad(conjuntoVectorB.union(conjuntoVectorA)));
        System.out.println("AnB: " +  conjuntoVectorA.interseccion(conjuntoVectorB));
        System.out.println("BnA: " +  conjuntoVectorB.interseccion(conjuntoVectorA));
        System.out.println("AnB == BnA: " + conjuntoVectorA.interseccion(conjuntoVectorB).igualdad(conjuntoVectorB.interseccion(conjuntoVectorA)));
        System.out.println("C es subconjunto de A: " + conjuntoVectorA.subconjunto(conjuntoVectorC));
        System.out.println("C es subconjunto de B: " + conjuntoVectorB.subconjunto(conjuntoVectorC));
        System.out.println("Complemento de A: " + conjuntoVectorA.complemento());
        System.out.println("Complemento de B: " + conjuntoVectorB.complemento());
        conjuntoVectorA.borrar(primerDatoA);
        System.out.println("Conjunto A despues de eliminar " + primerDatoA + ": " + conjuntoVectorA);
        System.out.println("Complemento de A: " + conjuntoVectorA.complemento());
        conjuntoVectorC.vaciar();
        System.out.println("Conjunto c despues de vaciar: " + conjuntoVectorC);
        System.out.println("A\\B: " + conjuntoVectorA.diferencia(conjuntoVectorB));
        System.out.println("B\\A: " + conjuntoVectorB.diferencia(conjuntoVectorA));
        System.out.println("AΔB: " + conjuntoVectorA.diferenciaSimetrica(conjuntoVectorB));
        System.out.println("BΔA: " + conjuntoVectorB.diferenciaSimetrica(conjuntoVectorA));
    }
    
    private static void listas() {
        IConjunto conjuntoUniversal = ConjuntoVectorUniversal.obtenerUniversal();
        System.out.println("Universal: " +  conjuntoUniversal);
        IConjunto conjuntoVectorA = new ConjuntoVector(new Integer[0]);
        IConjunto conjuntoVectorB = new ConjuntoVector(new Integer[0]);
        IConjunto conjuntoVectorC = new ConjuntoVector(new Integer[0]);
        IConjunto conjuntoListaA = new ConjuntoLista();
        IConjunto conjuntoListaB = new ConjuntoLista();
        IConjunto conjuntoListaC = new ConjuntoLista();
        for (int i = 0; i < conjuntoUniversal.obtenerTamano() / 2; i++) {
            conjuntoVectorA.agregar(conjuntoUniversal.obtenerDato(i));
            conjuntoListaA.agregar(conjuntoUniversal.obtenerDato(i));
            conjuntoVectorB.agregar(conjuntoUniversal.obtenerDato(i+3));
            conjuntoListaB.agregar(conjuntoUniversal.obtenerDato(i+3));
        }
        for (int i = 0; i < conjuntoVectorA.obtenerTamano() - 1; i++) {
            conjuntoVectorC.agregar(conjuntoVectorA.obtenerDato(i));
            conjuntoListaC.agregar(conjuntoListaA.obtenerDato(i));
        }
        int primerDatoAV = conjuntoVectorA.obtenerDato(0);
        int primerDatoAL = conjuntoListaA.obtenerDato(0);
        System.out.println("conjunto AV: " + conjuntoVectorA);
        System.out.println("conjunto BV: " + conjuntoVectorB);
        System.out.println("conjunto CV: " + conjuntoVectorC);
        System.out.println("conjunto AL: " + conjuntoListaA);
        System.out.println("conjunto BL: " + conjuntoListaB);
        System.out.println("conjunto CL: " + conjuntoListaC);
        System.out.println("AL == AV " + conjuntoListaA.igualdad(conjuntoVectorA));
        System.out.println("BL == BV " + conjuntoListaB.igualdad(conjuntoVectorB));
        System.out.println("");
        System.out.println("AV U BV: " +  conjuntoVectorA.union(conjuntoVectorB));
        System.out.println("AL U BL: " +  conjuntoListaA.union(conjuntoListaB));
        System.out.println("AV U BL: " +  conjuntoVectorA.union(conjuntoListaB));
        System.out.println("AL U BV: " +  conjuntoListaA.union(conjuntoVectorB));
        System.out.println("(AL U BL) == (AV U BV): " +  conjuntoListaA.union(conjuntoListaB).igualdad(conjuntoVectorA.union(conjuntoVectorB)));
        System.out.println("(AV U BL) == (AL U BV): " +  conjuntoVectorA.union(conjuntoListaB).igualdad(conjuntoListaA.union(conjuntoVectorB)));
        System.out.println("");
        System.out.println("AV n BV: " +  conjuntoVectorA.interseccion(conjuntoVectorB));
        System.out.println("AL n BL: " +  conjuntoListaA.interseccion(conjuntoListaB));
        System.out.println("AV n BL: " +  conjuntoVectorA.interseccion(conjuntoListaB));
        System.out.println("AL n BV: " +  conjuntoListaA.interseccion(conjuntoVectorB));
        System.out.println("(AL n BL) == (AV n BV): " + conjuntoListaA.interseccion(conjuntoListaB).igualdad(conjuntoVectorA.interseccion(conjuntoVectorB)));
        System.out.println("(AV n BL) == (AL n BV): " + conjuntoVectorA.interseccion(conjuntoListaB).igualdad(conjuntoListaA.interseccion(conjuntoVectorB)));
        System.out.println("");
        System.out.println("CV es subconjunto de AV: " + conjuntoVectorA.subconjunto(conjuntoVectorC));
        System.out.println("CV es subconjunto de AL: " + conjuntoListaA.subconjunto(conjuntoVectorC));
        System.out.println("CL es subconjunto de AL: " + conjuntoListaA.subconjunto(conjuntoListaC));
        System.out.println("CL es subconjunto de AV: " + conjuntoVectorA.subconjunto(conjuntoListaC));
        System.out.println("CV es subconjunto de BV: " + conjuntoVectorB.subconjunto(conjuntoVectorC));
        System.out.println("CV es subconjunto de BL: " + conjuntoListaB.subconjunto(conjuntoVectorC));
        System.out.println("CL es subconjunto de BL: " + conjuntoListaB.subconjunto(conjuntoListaC));
        System.out.println("CL es subconjunto de BV: " + conjuntoVectorB.subconjunto(conjuntoListaC));
        System.out.println("");
        System.out.println("Complemento de AV: " + conjuntoVectorA.complemento());
        System.out.println("Complemento de AL: " + conjuntoListaA.complemento());
        System.out.println("Complemento de BV: " + conjuntoVectorB.complemento());
        System.out.println("Complemento de BL: " + conjuntoListaB.complemento());
        System.out.println("");
         conjuntoVectorA.borrar(primerDatoAV);
        conjuntoListaA.borrar(primerDatoAL);
        System.out.println("Conjunto AV despues de eliminar " + primerDatoAV + ": " + conjuntoVectorA);
        System.out.println("Conjunto AL despues de eliminar " + primerDatoAL + ": " + conjuntoListaA);
        System.out.println("");
        System.out.println("Complemento de AV: " + conjuntoVectorA.complemento());
        System.out.println("Complemento de AL: " + conjuntoVectorA.complemento());
        conjuntoVectorC.vaciar();
        conjuntoListaC.vaciar();
        System.out.println("Conjunto CV despues de vaciarse: " + conjuntoVectorC);
        System.out.println("Conjunto CL despues de vaciarse: " + conjuntoListaC);
        System.out.println("");
        System.out.println("AV \\ BV: " + conjuntoVectorA.diferencia(conjuntoVectorB));
        System.out.println("AL \\ BL: " + conjuntoListaA.diferencia(conjuntoListaB));
        System.out.println("AV \\ BL: " + conjuntoVectorA.diferencia(conjuntoListaB));
        System.out.println("AL \\ BV: " + conjuntoListaA.diferencia(conjuntoVectorB));
        System.out.println("(AV \\ BV) == (AL \\ BL): " + conjuntoVectorA.diferencia(conjuntoVectorB).igualdad(conjuntoListaA.diferencia(conjuntoListaB)));
        System.out.println("");
        System.out.println("(AV \\ BL) == (AL \\ BV): " + conjuntoVectorA.diferencia(conjuntoListaB).igualdad(conjuntoListaA.diferencia(conjuntoVectorB)));
        System.out.println("BV \\ AV: " + conjuntoVectorB.diferencia(conjuntoVectorA));
        System.out.println("BL \\ AL: " + conjuntoListaB.diferencia(conjuntoListaA));
        System.out.println("BV \\ AL: " + conjuntoVectorB.diferencia(conjuntoListaA));
        System.out.println("BL \\ AV: " + conjuntoListaB.diferencia(conjuntoVectorA));
        System.out.println("(BV \\ AV) == (BL \\ AL): " + conjuntoVectorB.diferencia(conjuntoVectorA).igualdad(conjuntoListaB.diferencia(conjuntoListaA)));
        System.out.println("(BV \\ AL) == (BL \\ AV): " + conjuntoVectorB.diferencia(conjuntoListaA).igualdad(conjuntoListaB.diferencia(conjuntoVectorA)));
        System.out.println("");
        System.out.println("AV Δ BV: " + conjuntoVectorA.diferenciaSimetrica(conjuntoVectorB));
        System.out.println("AL Δ BL: " + conjuntoListaA.diferenciaSimetrica(conjuntoListaB));
        System.out.println("AL Δ BV: " + conjuntoListaA.diferenciaSimetrica(conjuntoVectorB));
        System.out.println("AV Δ BL: " + conjuntoVectorA.diferenciaSimetrica(conjuntoListaB));
        System.out.println("(AV Δ BV) == (AL Δ BL):" + conjuntoVectorA.diferenciaSimetrica(conjuntoVectorB).igualdad(conjuntoListaA.diferenciaSimetrica(conjuntoListaB)));
        System.out.println("(AL Δ BV) == (AV Δ BL):" + conjuntoListaA.diferenciaSimetrica(conjuntoVectorB).igualdad(conjuntoVectorA.diferenciaSimetrica(conjuntoListaB)));
    }
}
