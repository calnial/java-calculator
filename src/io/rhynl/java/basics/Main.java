/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.rhynl.java.basics;

import java.util.Scanner; //importar clases y paquetes

/**
 *
 * @author Rhaynel Parra Aguiar <mail@rhynl.io>
 */
public class Main {
    // variable de clase, puede ser usada por todos los metodos de la clase.
    static Scanner teclado = new Scanner(System.in); //Scanner

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Tipos de datos        
        char tipoDeNumeros; //char
        
        //salida de datos
        System.out.println("El siguiente programa es una calculadora basica.");
        
        tipoDeNumeros = preguntarPorTipoDeNumeros();
        
        switch(tipoDeNumeros) {
            case 'e':
                rutinaParaEnteros();
                break;
            case 'd':
                rutinaParaDecimales();
                break;
            default:
                //no deberia llegar a caer en ningun caso, en el ciclo do-while se asegura la validez de tipoDeNumeros
                break;
        }

    }
    
    /**
     * 
     */
    public static void rutinaParaEnteros() {
        // declaraciones
        int resultado = 0;
        
        System.out.print("Ingrese los numeros con los que desea operar, separados por coma (ejemplo: 1,2,3,4): ");
        
        String cadena = teclado.next();
        
        int[] numeros = convertirNumerosEnteros(cadena);
        
        char operacion = preguntarPorOperacion();
        
        switch (operacion) {
            case 's':
                int suma = 0;
                for (int numero : numeros) {
                    suma += numero;
                }
                resultado = suma;
                break;
            case 'r':
                int resta = 0;
                for (int numero : numeros) {
                    resta -= numero;
                }
                resultado = resta;
                break;
            case 'm':
                int multi = 1;
                for (int numero : numeros) {
                    multi *= numero;
                }
                resultado = multi;
                break;
            case 'd':
                int div = numeros[0];
                for (int i = 1; i < numeros.length; i++) {
                    if (numeros[i] != 0) {
                        div /= numeros[i];
                    } else {
                        resultado = 0;
                        break;
                    }
                }
                resultado = div;
                break;
            case 'o':
                
                break;
            default:
                break;
        }
        
        System.out.println("Resultado: "+resultado);
    }
    
    /**
     * 
     */
    public static void rutinaParaDecimales() {
        //decalraciones
        double resultado = 0.0d;
        
        System.out.print("Ingrese los numeros con los que desea operar, separados por coma (ejemplo: 1,2,3,4): ");
        
        String cadena = teclado.next();
        
        double[] numeros = convertirNumerosDecimales(cadena);
        
        char operacion = preguntarPorOperacion();
        
        switch (operacion) {
            case 's':
                int suma = 0;
                for (double numero : numeros) {
                    suma += numero;
                }
                resultado = suma;
                break;
            case 'r':
                
                break;
            case 'm':
                
                break;
            case 'd':
                
                break;
            case 'o':
                
                break;
            default:
                break;
        }
        
        System.out.println("Resultado: "+resultado);
    
    }
    
    /**
     * 
     */
    static char preguntarPorTipoDeNumeros() {
        char tipoDeNumeros;
        //ciclo do-while
        do {
            System.out.print("Indique con tipo de numeros desea trabajar, (e)nteros o (d)ecimales, o puede (s)alir: ");
            //entrada de datos
            tipoDeNumeros = teclado.next().charAt(0);
            //condicional, comparacion logica
            if (tipoDeNumeros == 's') {
                System.out.println("Hasta la Proxima.");
                System.exit(0);
            } else if (tipoDeNumeros != 'e' && tipoDeNumeros != 'd') {
                System.err.println("Opción invalida.");
            } else {
                return tipoDeNumeros;
            }
        } while(true);
    }
    
    
    /**
     * 
     */
    static char preguntarPorOperacion() {
        while (true) {
            System.out.print("Que operación desea realizar? (s)uma, (r)esta, (m)ultiplicación, (d)ivisión, m(o)dulo: ");
            char operacion = teclado.next().charAt(0);
            if (operacion == 's' || operacion == 'r' || operacion == 'm' || operacion == 'd' || operacion == 'o') {
                return operacion;
            }
        }
    }
    
    /**
     * 
     * @param cadena recibe una cadena de caracteres
     * @return devuelve un arreglo de numeros enteros
     */
    static int[] convertirNumerosEnteros(String cadena) {
        String[] arreglo = cadena.split(",");
        int[] numeros = new int[arreglo.length];
        
        for (int i = 0; i < arreglo.length; i++) {
            numeros[i] = Integer.parseInt(arreglo[i]);
        }
        
        return numeros;        
    }
    
    /**
     * 
     * @param cadena cadena de caracteres
     * @return arreglo de numeros decimales
     */
    static double[] convertirNumerosDecimales(String cadena) {
        String[] arreglo = cadena.split(",");
        double[] numeros = new double[arreglo.length];
        
        for (int i = 0; i < arreglo.length; i++) {
            numeros[i] = Double.parseDouble(arreglo[i]);
        }
        
        return numeros;        
    }
}
