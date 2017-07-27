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
        int num1, num2, resultado = 0;
        
        System.out.print("Ingrese primer numero: ");
        num1 = teclado.nextInt();
        System.out.print("Ingrese segundo numero: ");
        num2 = teclado.nextInt();
        
        char operacion = preguntarPorOperacion();
        
        switch (operacion) {
            case 's':
                resultado = num1 + num2;
                break;
            case 'r':
                resultado = num1 - num2;
                break;
            case 'm':
                resultado = num1 * num2;
                break;
            case 'd':
                resultado = num1 / num2;
                break;
            case 'o':
                resultado = num1 % num2;
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
        double num1, num2, resultado = 0.0d;
        
        System.out.print("Ingrese primer numero: ");
        num1 = teclado.nextDouble();
        System.out.print("Ingrese segundo numero: ");
        num2 = teclado.nextDouble();
        
        char operacion = preguntarPorOperacion();
        
        switch (operacion) {
            case 's':
                resultado = num1 + num2;
                break;
            case 'r':
                resultado = num1 - num2;
                break;
            case 'm':
                resultado = num1 * num2;
                break;
            case 'd':
                resultado = num1 / num2;
                break;
            case 'o':
                resultado = num1 % num2;
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
}
