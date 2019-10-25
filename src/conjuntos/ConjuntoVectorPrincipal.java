/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import co.com.utilidades.Utilidades;
import co.com.vector.entidades.ConjuntoVector;
import co.com.vector.entidades.ConjuntoVectorUniversal;
import java.util.Arrays;

public class ConjuntoVectorPrincipal {
    
    public static final ConjuntoVectorUniversal CONJUNTO_UNIVERSAL = new ConjuntoVectorUniversal();
    private static final ConjuntoVector CONJUNTO_A = crearConjunto(Utilidades.TAMANO_CONJUNTO);
    private static final ConjuntoVector CONJUNTO_B = crearConjunto(Utilidades.TAMANO_CONJUNTO);

    public static void main(String[] args) throws Exception {                
        System.out.println("Conjunto Universal: " + Arrays.toString(CONJUNTO_UNIVERSAL.getVec()));
        System.out.println("Conjunto A: " + Arrays.toString(CONJUNTO_A.getVec()));
        System.out.println("Conjunto B: " + Arrays.toString(CONJUNTO_B.getVec()) + "\n");
        
        verificarPertenece(5);
        System.out.print("\n");
        verificarEsVacio();
        System.out.print("\n");
        verificarUnion();
        System.out.print("\n");
        verificarInterseccion();
        System.out.print("\n");
        verificarDiferencia();
        System.out.print("\n");
        verificarDiferenciaSimetrica();
        System.out.print("\n");
        verificarIgualdad();
        System.out.print("\n");
        vectorComplemento();
       
    }
    
    private static ConjuntoVector crearConjunto(Integer cantidad){
        Integer[] vector = new Integer[cantidad];
        for (int i = 0; i < cantidad; i++) {
            Utilidades.insertarElementoRandom(i, vector);
        }
        ConjuntoVector conjunto = new ConjuntoVector(cantidad, vector);
        return conjunto;
    }
    
    private static void verificarPertenece(Integer elemento){
        System.out.println("PERTENECE: " + elemento);
        System.out.print("Conjunto A ");
        CONJUNTO_A.pertenece(elemento);
        System.out.print("Conjunto B ");
        CONJUNTO_B.pertenece(elemento);
    }
    
    private static void verificarEsVacio(){
        System.out.println("ES VACIO: ");
        System.out.println("Conjunto A " + (CONJUNTO_A.esVacio() ? "es vacio" : "NO es vacio"));
        System.out.println("Conjunto B " + (CONJUNTO_B.esVacio() ? "es vacio" : "NO es vacio"));
    }
    
    private static void verificarUnion(){
        ConjuntoVector unionAB = (ConjuntoVector) CONJUNTO_A.union(CONJUNTO_B);
        System.out.println("A UNIDO B: ");
        System.out.println("Conjunto AuB: " + Arrays.toString(unionAB.getVec()));
    }
    
    private static void verificarInterseccion(){
        ConjuntoVector interseccionAB = (ConjuntoVector) CONJUNTO_A.interseccion(CONJUNTO_B);
        System.out.println("A INTERCEPTADO B: ");
        System.out.println("Conjunto AiB: " + Arrays.toString(interseccionAB.getVec()));
    }
    
    private static void verificarDiferencia(){
        ConjuntoVector diferenciaAB = (ConjuntoVector) CONJUNTO_A.diferencia(CONJUNTO_B);
        System.out.println("A DIFERENCIA B: ");
        System.out.println("Conjunto AdB: " + Arrays.toString(diferenciaAB.getVec()));
    }
    
    private static void verificarDiferenciaSimetrica(){
        ConjuntoVector diferenciaSimetricaAB = (ConjuntoVector) CONJUNTO_A.diferenciaSimetrica(CONJUNTO_B);
        System.out.println("A DIFERENCIA SIMETRICA B: ");
        System.out.println("Conjunto AdsB: " + Arrays.toString(diferenciaSimetricaAB.getVec()));
    }
    
    private static void verificarIgualdad(){
        System.out.println("A IGUAL B: ");
        System.out.println("Conjunto A " + (CONJUNTO_A.igualdad(CONJUNTO_B) ? " Es igual" : " No es igual ") + " al Conjunto B");
    }
    
    private static void vectorComplemento(){
        ConjuntoVector complementoA = (ConjuntoVector) CONJUNTO_A.complemento();
        ConjuntoVector complementoB = (ConjuntoVector) CONJUNTO_B.complemento();
        System.out.println("A COMPLEMENTO: ");
        System.out.println("Conjunto complemento A: " + Arrays.toString(complementoA.getVec()));
        System.out.print("\n");        
        System.out.println("B COMPLEMENTO: ");
        System.out.println("Conjunto complemento B: " + Arrays.toString(complementoB.getVec()));
    }
}
