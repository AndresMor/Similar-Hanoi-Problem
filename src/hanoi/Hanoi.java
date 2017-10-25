/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author moralesea
 */
public class Hanoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList> Pegs = new ArrayList<>();
        ArrayList<Integer> Numbers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = br.read();
        Numbers.add(0);
        for (int i = 0; i < N; i++) {
            Pegs.add(Numbers);
        }
        int i = 1;
        int Cont = 0;//Contador de Pegs
        boolean SW = false;
        boolean SW2 = false;
        boolean SW3 = false;
        int R = 0;
        while (SW != true) {
            while (Cont <= N && SW2 != true) {
                ArrayList<Integer> Aux = Pegs.get(Cont);
                int G = Aux.get(Aux.size() - 1);
                //System.out.println("G: "+G);
                int Sum = G + i;
                double Pot = Math.sqrt(Sum);
                if (Math.floor(Pot) == Math.ceil(Pot)) {//Comprobar si es entero
                    Aux.add(i);
                    Pegs.add(Cont, Aux);
                    SW2=true;
                    //System.out.println("Entro Aqui ?");
                }else if(Cont==N && R!=0){
                     Aux = Pegs.get(R);
                     Aux.add(i);
                    Pegs.add(R,Aux);
                    SW2=true;
                    System.out.println("Entro Aqui ?");
                }else if(Cont==N && SW3!=true){
                   SW = true;
                }
                if (G==0 && SW3!=true && SW2 !=true) {//Posicion de Peg Vacia
                    R = Cont;
                    SW3=true;
                }
               /*System.out.println("i: "+i);
                System.out.println("Cont: "+Cont);*/
                Cont++;
            }
            Cont=0;
            SW2=false;
            SW3 = false;
            R=0;
            i++;
        }
        System.out.println("-> "+i);
    }

}
