/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import co.com.interfaces.IConjunto;
import co.com.listas.Lista;
import co.com.listas.ListaEstructura;
import co.com.vector.entidades.ConjuntoVector;

import java.util.Arrays;
import java.util.Scanner;

public class Conjunto {

    public static void main(String[] args) throws Exception {
        /*Lista lista = new ListaEstructura();
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Menú");
            System.out.println("1) Conjunto lista "
                    + "\n2) Conjunto vector"
                    + "\n3) Conjunto mixto"
                    + "\n4) Salir");

            switch (in.nextInt()) {
                case 1:
                    try {
                        Scanner opcion1 = new Scanner(System.in);
                        System.out.println("Menú listas");
                        System.out.println("1) Cantidad de elementos"
                                + "\n2) Pertenece a"
                                + "\n3) Subconjunto"
                                + "\n4) Es vacio"
                                + "\n5) Unión"
                                + "\n6) Intersección"
                                + "\n7) Igualdad"
                                + "\n8) Agregar"
                                + "\n9) Borrar"
                                + "\n10) Posición"
                                + "\n11) Diferencia"
                                + "\n12) Diferencia simétrica"
                                + "\n13) Vaciar"
                                + "\n14) Salir");
                        switch (opcion1.nextInt()) {
                            case 1:
                                try {
                                    lista.getCantidadElementos();
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 2:
                                try {
                                    lista.recorrerLista();
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 3:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 4:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 5:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 6:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 7:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 8:
                                try {
                                    Scanner nodo = new Scanner(System.in);
                                    System.out.println("Ingrese nodo");
                                    Character datoNodo = new Character(nodo.next().charAt(0));
                                    lista.insertarNodo(datoNodo);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 9:
                                try {
                                    Scanner nodo = new Scanner(System.in);
                                    System.out.println("Ingrese nodo");
                                    Character datoNodo = new Character(nodo.next().charAt(0));
                                    lista.eliminarNodo(datoNodo);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 10:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 11:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 12:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 13:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            default:
                                System.err.println("Opción no válida");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        Scanner opcion1 = new Scanner(System.in);
                        System.out.println("Menú vectores");
                        System.out.println("1) Cantidad de elementos"
                                + "\n2) Pertenece a"
                                + "\n3) Subconjunto"
                                + "\n4) Es vacio"
                                + "\n5) Unión"
                                + "\n6) Intersección"
                                + "\n7) Igualdad"
                                + "\n8) Agregar"
                                + "\n9) Borrar"
                                + "\n10) Posición"
                                + "\n11) Diferencia"
                                + "\n12) Diferencia simétrica"
                                + "\n13) Vaciar"
                                + "\n14) Salir");
                        switch (opcion1.nextInt()) {
                            case 1:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 2:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 3:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 4:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 5:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 6:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 7:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 8:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 9:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 10:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 11:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 12:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 13:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            default:
                                System.err.println("Opción no válida");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        Scanner opcion1 = new Scanner(System.in);
                        System.out.println("Menú mixto");
                        System.out.println("1) Cantidad de elementos"
                                + "\n2) Pertenece a"
                                + "\n3) Subconjunto"
                                + "\n4) Es vacio"
                                + "\n5) Unión"
                                + "\n6) Intersección"
                                + "\n7) Igualdad"
                                + "\n8) Agregar"
                                + "\n9) Borrar"
                                + "\n10) Posición"
                                + "\n11) Diferencia"
                                + "\n12) Diferencia simétrica"
                                + "\n13) Vaciar"
                                + "\n14) Salir");
                        switch (opcion1.nextInt()) {
                            case 1:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 2:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 3:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 4:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 5:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 6:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 7:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 8:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 9:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 10:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 11:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 12:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 13:
                                try {

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            default:
                                System.err.println("Opción no válida");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.err.println("Opción no válida");
                    break;
            }
        }*/
    }
}
