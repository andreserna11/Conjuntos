/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import co.com.utilidades.Utilidades;
import co.com.vector.entidades.ConjuntoVector;
import co.com.listas.entidades.ConjuntoLista;
import co.com.vector.entidades.ConjuntoVectorUniversal;
import java.util.Arrays;

public class Conjunto {
    
    private static final ConjuntoVector CONJUNTO_A = crearConjunto(Utilidades.TAMANO_CONJUNTO);
    private static final ConjuntoVector CONJUNTO_B = crearConjunto(Utilidades.TAMANO_CONJUNTO);

    private static final ConjuntoLista conjunto1 = new ConjuntoLista();
    private static final ConjuntoLista conjunto2 = new ConjuntoLista();
    private static final ConjuntoLista conjunto3 = new ConjuntoLista();
    private static final ConjuntoLista conjunto4 = new ConjuntoLista();
    private static final ConjuntoLista conjunto5 = new ConjuntoLista();
    private static final ConjuntoLista conjunto6 = new ConjuntoLista();

    static {
        for (int i = 5; i <= 10; i++) {
            conjunto1.agregar(i);
        }
        for (int i = 6; i <= 8; i++) {
            conjunto2.agregar(i);
        }
        for (int i = 3; i <= 18; i++) {
            conjunto3.agregar(i);
        }
        for (int i = 15; i <= 19; i++) {
            conjunto5.agregar(i);
        }
        for (int i = 15; i <= 19; i++) {
            conjunto4.agregar(i);
        }
        for (int i = 5; i <= 10; i++) {
            conjunto6.agregar(i);
        }
    }
    
    public static void main(String[] args) throws Exception {   
        
        System.out.println("LISTAS");
        System.out.println("_______");
        mainListas(args);
        System.out.println("\n\n\n\n___________________________________\n\n\n\n");
        System.out.println("VECTORES");
        System.out.println("________");
        mainVectores(args);
    }

    public static void mainVectores(String[] args) throws Exception {
        System.out.println("Conjunto Universal: " + ConjuntoVectorUniversal.obtenerUniversal().toString());
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

    private static ConjuntoVector crearConjunto(Integer cantidad) {
        Integer[] vector = new Integer[cantidad];
        for (int i = 0; i < cantidad; i++) {
            Utilidades.insertarElementoRandom(i, vector);
        }
        ConjuntoVector conjunto = new ConjuntoVector(cantidad, vector);
        return conjunto;
    }

    private static void verificarPertenece(Integer elemento) {
        System.out.println("PERTENECE: " + elemento);
        System.out.print("Conjunto A ");
        CONJUNTO_A.pertenece(elemento);
        System.out.print("Conjunto B ");
        CONJUNTO_B.pertenece(elemento);
    }

    private static void verificarEsVacio() {
        System.out.println("ES VACIO: ");
        System.out.println("Conjunto A " + (CONJUNTO_A.esVacio() ? "es vacio" : "NO es vacio"));
        System.out.println("Conjunto B " + (CONJUNTO_B.esVacio() ? "es vacio" : "NO es vacio"));
    }

    private static void verificarUnion() {
        ConjuntoVector unionAB = (ConjuntoVector) CONJUNTO_A.union(CONJUNTO_B);
        System.out.println("A UNIDO B: ");
        System.out.println("Conjunto AuB: " + Arrays.toString(unionAB.getVec()));
    }

    private static void verificarInterseccion() {
        ConjuntoVector interseccionAB = (ConjuntoVector) CONJUNTO_A.interseccion(CONJUNTO_B);
        System.out.println("A INTERCEPTADO B: ");
        System.out.println("Conjunto AiB: " + Arrays.toString(interseccionAB.getVec()));
    }

    private static void verificarDiferencia() {
        ConjuntoVector diferenciaAB = (ConjuntoVector) CONJUNTO_A.diferencia(CONJUNTO_B);
        System.out.println("A DIFERENCIA B: ");
        System.out.println("Conjunto AdB: " + Arrays.toString(diferenciaAB.getVec()));
    }

    private static void verificarDiferenciaSimetrica() {
        ConjuntoVector diferenciaSimetricaAB = (ConjuntoVector) CONJUNTO_A.diferenciaSimetrica(CONJUNTO_B);
        System.out.println("A DIFERENCIA SIMETRICA B: ");
        System.out.println("Conjunto AdsB: " + Arrays.toString(diferenciaSimetricaAB.getVec()));
    }

    private static void verificarIgualdad() {
        System.out.println("A IGUAL B: ");
        System.out.println("Conjunto A " + (CONJUNTO_A.igualdad(CONJUNTO_B) ? " Es igual" : " No es igual ") + " al Conjunto B");
    }

    private static void vectorComplemento() {
        ConjuntoVector complementoA = (ConjuntoVector) CONJUNTO_A.complemento();
        ConjuntoVector complementoB = (ConjuntoVector) CONJUNTO_B.complemento();
        System.out.println("A COMPLEMENTO: ");
        System.out.println("Conjunto complemento A: " + Arrays.toString(complementoA.getVec()));
        System.out.print("\n");
        System.out.println("B COMPLEMENTO: ");
        System.out.println("Conjunto complemento B: " + Arrays.toString(complementoB.getVec()));
    }

    public static void mainListas(String[] args) throws Exception {

        System.out.println("\n");
        conjunto1.pertenece(6);

        System.out.println("\n");
        conjunto1.pertenece(777);

        System.out.println("\n");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();

        System.out.println("\n");
        System.out.println("conjunto 2:");
        conjunto2.mostrar();

        System.out.println("\n");
        System.out.println("conjunto 3:");
        conjunto3.mostrar();

        complementos();
        subconjuntos();
        verificarVacio();
        uniones();
        intersecciones();
        diferencias();
        diferenciaSimetrica();
        compararTamanos();
        eliminarListas();
        agregarListas();
    }

    private static void complementos() {
        System.out.println("\nCOMPLEMENTO");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("complemento conjunto 1:");
        ConjuntoLista conjuntoComplemento1 = (ConjuntoLista) conjunto1.complemento();
        conjuntoComplemento1.mostrar();
        System.out.println("\nconjunto 2:");
        conjunto2.mostrar();
        System.out.println("complemento conjunto 2:");
        ConjuntoLista conjuntoComplemento2 = (ConjuntoLista) conjunto2.complemento();
        conjuntoComplemento2.mostrar();
    }

    private static void subconjuntos() {
        System.out.println("\nSUBCONJUNTOS");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("conjunto 2:");
        conjunto2.mostrar();
        System.out.println("conjunto 3:");
        conjunto3.mostrar();
        System.out.println("conjunto 2 es subconjunto 1: " + conjunto1.subconjunto(conjunto2));
        System.out.println("conjunto 3 es subconjunto 1: " + conjunto1.subconjunto(conjunto3));
    }

    private static void verificarVacio() {
        System.out.println("\n");
        System.out.println("conjunto 1 es vacio: " + conjunto1.esVacio());

        System.out.println("\n");
        System.out.println("conjunto 4 es vacio: " + conjunto4.esVacio());
        conjunto4.vaciar();

        System.out.println("\n");
        System.out.println("conjunto 4 es vacio: " + conjunto4.esVacio());
    }

    private static void uniones() {
        System.out.println("\nUNION");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("conjunto 5:");
        conjunto5.mostrar();
        System.out.println("Union conjuntos 1 y 5");
        ConjuntoLista conjuntoUnion = (ConjuntoLista) conjunto1.union(conjunto5);
        conjuntoUnion.mostrar();
    }

    private static void intersecciones() {
        System.out.println("\nINTERSECCION");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("conjunto 5:");
        conjunto5.mostrar();
        System.out.println("Interseccion conjuntos 1 y 5");
        ConjuntoLista conjuntoInterseccion = (ConjuntoLista) conjunto1.interseccion(conjunto3);
        conjuntoInterseccion.mostrar();
    }

    private static void diferencias() {
        System.out.println("\nDIFERENCIA");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("conjunto 3:");
        conjunto3.mostrar();
        System.out.println("Diferencia conjuntos 3 y 1");
        ConjuntoLista conjuntoDiferencia = (ConjuntoLista) conjunto3.diferencia(conjunto1);
        conjuntoDiferencia.mostrar();
    }

    private static void igualdades() {
        System.out.println("\nIGUALDAD");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("conjunto 6:");
        conjunto6.mostrar();
        System.out.println("conjunto 3:");
        conjunto3.mostrar();
        System.out.println("Igualdad entre conjuntos 3 y 1: " + conjunto3.igualdad(conjunto1));
        System.out.println("Igualdad entre conjuntos 1 y 6: " + conjunto1.igualdad(conjunto6));
    }

    private static void diferenciaSimetrica() {
        System.out.println("\nDIFERENCIA SIMETRICA");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("conjunto 3:");
        conjunto3.mostrar();
        ConjuntoLista diferenciaSimetrica13 = (ConjuntoLista) conjunto1.diferenciaSimetrica(conjunto3);
        System.out.println("Diferencia simetrica entre 1 y 3:");
        diferenciaSimetrica13.mostrar();
    }

    private static void compararTamanos() {
        System.out.println("\nTAMAÑOS");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("conjunto 2:");
        conjunto2.mostrar();
        System.out.println("conjunto 3:");
        conjunto3.mostrar();
        int comparacionTamanos13 = conjunto1.compararDimensionConjuntos(conjunto3);
        int comparacionTamanos12 = conjunto1.compararDimensionConjuntos(conjunto2);
        int comparacionTamanos21 = conjunto2.compararDimensionConjuntos(conjunto1);
        System.out.println("Tamaño conjunto 1 es " + (comparacionTamanos13 == 0 ? "igual" : comparacionTamanos13 > 0 ? "mayor" : "menor") + " que el del conjunto 3");
        System.out.println("Tamaño conjunto 1 es " + (comparacionTamanos12 == 0 ? "igual" : comparacionTamanos12 > 0 ? "mayor" : "menor") + " que el del conjunto 2");
        System.out.println("Tamaño conjunto 2 es " + (comparacionTamanos12 == 0 ? "igual" : comparacionTamanos21 > 0 ? "mayor" : "menor") + " que el del conjunto 1");
    }

    private static void agregarListas() {
        System.out.println("\nAGREGAR");
        System.out.println("se agrega \"2\" al conjunto 1");
        System.out.println("antes:");
        conjunto1.mostrar();
        System.out.println("despues:");
        conjunto1.agregar(2);
        conjunto1.mostrar();

        System.out.println("\n");
        System.out.println("se agrega \"51\" al conjunto 1");
        System.out.println("antes:");
        conjunto1.mostrar();
        System.out.println("despues:");
        conjunto1.agregar(2);
        conjunto1.mostrar();
    }

    private static void eliminarListas() {
        System.out.println("\nELIMINAR");
        System.out.println("se elimina \"10\" del conjunto 3");
        System.out.println("antes:");
        conjunto3.mostrar();
        System.out.println("despues:");
        conjunto3.borrar(10);
        conjunto3.mostrar();
    }
}
