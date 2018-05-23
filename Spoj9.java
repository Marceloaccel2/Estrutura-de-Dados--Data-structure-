package spoj9;
import java.io.*;
import java.util.*;
import java.lang.String.*;

// Autor: Marcelo Alves

public class Spoj9 {

    public static void main(String[] args) throws IOException{
        try{
            /*s vai pegar a primeira linha de entrada que será o numero total de testes que
              serão feitos ,primeiramente será digitado uma string e depois convertido
              para int já que é um numero e consequentemente isso dará o tamanho do array*/
            int n,m,score;
            BufferedReader linha = new BufferedReader(new InputStreamReader(System.in));
            int s = Integer.parseInt(linha.readLine());
            /*Será usado um for para que a 2°linha de entrada seja efetivada, colocando
              os valores de n e m todos juntos em uma string , repartindo ela usando o 
              metodo split e armazenando o n e o m convertidos em int para ser usado 
              no score*/
            int arrayExit[] = new int[s];
             for(int i = 0; i < s; i++){
			String aux = linha.readLine();
                        String[] separador = aux.split(" ");
                        n = Integer.parseInt(separador[0]);
                        m = Integer.parseInt(separador[1]);
                        score = n*m*2-n-m;
                        System.out.println(score);
             }

        }catch(Exception e){
                System.out.println(e.getMessage());
        }
    }
    
}
