/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adts;

import java.util.Arrays;
import java.util.Scanner;

public class Queue {
        String expresion;

        class Nodo {
            char info[];
            Nodo sig;
        }

        private Nodo raiz,fondo;

        Queue() {
            raiz=null;
            fondo=null;
        }

        public boolean Colavacia (){
            return raiz == null;
        }

        void insertar (char[] info)
        {
            Nodo nuevo;
            nuevo = new Nodo ();
            nuevo.info = info;
            nuevo.sig = null;
            if (Colavacia()) {
                raiz = nuevo;
                fondo = nuevo;
            } else {
                fondo.sig = nuevo;
                fondo = nuevo;
            }
        }

        public String extraer () {

            if (!Colavacia ())
            {
                char []informacion = raiz.info;
                if (raiz == fondo){
                    raiz = null;
                    fondo = null;
                } else {
                    raiz = raiz.sig;
                }
            }
      return "salida";
        }

        public void imprimir() {

            Nodo reco=raiz;
            System.out.println("Listado de todos los elementos de la cola.");
            while (reco!=null) {
                System.out.print(reco.info+ " ");
                reco=reco.sig;
            }
            System.out.println();

        }



        public static void main(String[] ar) {

            Scanner in = new Scanner(System.in);
            String expresion= "";
            System.out.print("Ingrese la expresión: ");
            expresion = in.nextLine();


            char[] arrCh = expresion.toCharArray();
                String salida= Arrays.toString(arrCh);



            Queue cola1=new Queue();
            cola1.insertar(arrCh);
            cola1.imprimir();


            System.out.println("Extraemos uno de la cola:"+ cola1.extraer());
            cola1.imprimir();

        }
}
