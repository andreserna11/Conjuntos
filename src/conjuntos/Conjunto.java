/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import co.com.interfaces.IConjunto;
import co.com.listas.entidades.ConjuntoLista;

public class Conjunto {

    public static void main(String[] args) throws Exception {
        ConjuntoLista conjunto1 = new ConjuntoLista();
        ConjuntoLista conjunto2 = new ConjuntoLista();
        ConjuntoLista conjunto3 = new ConjuntoLista();
        ConjuntoLista conjunto4 = new ConjuntoLista();
        ConjuntoLista conjunto5 = new ConjuntoLista();
        ConjuntoLista conjunto6 = new ConjuntoLista();
        for (int i = 5; i <= 10; i++) conjunto1.agregar(i);
        for (int i = 6; i <= 8; i++) conjunto2.agregar(i);
        for (int i = 3; i <= 18; i++) conjunto3.agregar(i);
        for (int i = 15; i <= 19; i++) conjunto5.agregar(i);
        for (int i = 15; i <= 19; i++) conjunto4.agregar(i);
        for (int i = 5; i <= 10; i++) conjunto6.agregar(i);
        
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
        
        System.out.println("\nSUBCONJUNTOS");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("conjunto 2:");
        conjunto2.mostrar();
        System.out.println("conjunto 3:");
        conjunto3.mostrar();
        System.out.println("conjunto 2 es subconjunto 1: " + conjunto1.subconjunto(conjunto2));
        System.out.println("conjunto 3 es subconjunto 1: " + conjunto1.subconjunto(conjunto3));
        
        System.out.println("\n");
        System.out.println("conjunto 1 es vacio: " + conjunto1.esVacio());
        
        System.out.println("\n");
        System.out.println("conjunto 4 es vacio: " + conjunto4.esVacio());
        conjunto4.vaciar();
        
        System.out.println("\n");
        System.out.println("conjunto 4 es vacio: " + conjunto4.esVacio());
        
        System.out.println("\nUNION");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("conjunto 5:");
        conjunto5.mostrar();
        System.out.println("Union conjuntos 1 y 5");
        ConjuntoLista conjuntoUnion = (ConjuntoLista) conjunto1.union(conjunto5);
        conjuntoUnion.mostrar();
        
        System.out.println("\nINTERSECCION");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("conjunto 5:");
        conjunto5.mostrar();
        System.out.println("Interseccion conjuntos 1 y 5");
        ConjuntoLista conjuntoInterseccion = (ConjuntoLista) conjunto1.interseccion(conjunto3);
        conjuntoInterseccion.mostrar();
        
        System.out.println("\nDIFERENCIA");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("conjunto 3:");
        conjunto3.mostrar();
        System.out.println("Diferencia conjuntos 3 y 1");
        ConjuntoLista conjuntoDiferencia = (ConjuntoLista) conjunto3.diferencia(conjunto1);
        conjuntoDiferencia.mostrar();
        
        System.out.println("\nIGUALDAD");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("conjunto 6:");
        conjunto6.mostrar();
        System.out.println("conjunto 3:");
        conjunto3.mostrar();
        System.out.println("Igualdad entre conjuntos 3 y 1: " + conjunto3.igualdad(conjunto1));
        System.out.println("Igualdad entre conjuntos 1 y 6: " + conjunto1.igualdad(conjunto6));
        
        System.out.println("\nDIFERENCIA SIMETRICA");
        System.out.println("conjunto 1:");
        conjunto1.mostrar();
        System.out.println("conjunto 3:");
        conjunto3.mostrar();
        ConjuntoLista diferenciaSimetrica13 = (ConjuntoLista) conjunto1.diferenciaSimetrica(conjunto3);
        System.out.println("Diferencia simetrica entre 1 y 3:");
        diferenciaSimetrica13.mostrar();
        
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
        System.out.println("Tamaño conjunto 1 es " + (comparacionTamanos13 == 0 ? "igual" : comparacionTamanos13 > 0 ? "mayor": "menor") + " que el del conjunto 3");
        System.out.println("Tamaño conjunto 1 es " + (comparacionTamanos12 == 0 ? "igual" : comparacionTamanos12 > 0 ? "mayor": "menor") + " que el del conjunto 2");
        System.out.println("Tamaño conjunto 2 es " + (comparacionTamanos12 == 0 ? "igual" : comparacionTamanos21 > 0 ? "mayor": "menor") + " que el del conjunto 1");
        
        System.out.println("\nELIMINAR");
        System.out.println("se elimina \"10\" del conjunto 3");
        System.out.println("antes:");
        conjunto3.mostrar();
        System.out.println("despues:");
        conjunto3.borrar(10);
        conjunto3.mostrar();
        
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
}
