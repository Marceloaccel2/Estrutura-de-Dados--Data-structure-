package ListaSequencialSpoj1;
import java.util.Scanner;
//AUTOR : Marcelo Alves 

public class Spoj1 {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        //dados de cada array 
        int tamAtual1 = 0; /**começa com 0 pois o usuario nao digitou ainda a quatidade
                             de elementos dos arrays*/
        int tamAtual2 = 0;
        
       //vai servir para saber o tamanho todo do array1 , quem decidirá isso será o usuario
        //System.out.print("");
        tamAtual1 = ler.nextInt();
        
        //criação do array1
        int[] array1 = new int[tamAtual1];
        
       //adicionar as variaveis no array1 digitados pelo usuario
       for (int i = 0;i<tamAtual1; i++) {
            array1[i] = ler.nextInt();
        }
       
       //vai servir para saber o tamanho todo do array2 , quem decidirá isso será o usuario
        //System.out.print("");  
       tamAtual2 = ler.nextInt();
       
       //criação do array2
       int[] array2 = new int[tamAtual2];

       //adicionar as variaveis no array2 
       for (int j = 0;j<tamAtual2; j++) {
            array2[j] = ler.nextInt();
        }
       
       for(int i=0;i<tamAtual1;i++){
            /*a ideia desses for é comparar cada variavel do array1 com todas as
           variaveis do array2 , o numero de testes vai se dar pela formula 
           tamAtual1*(tamAtual2)*/
            
           // boolean aux =true; //variavel booleana de controle
            
            /*chama a função busca para vaculhar o dado
            do array1 em todo o array2 , se acha retorn False , logo nao printa*/
            Busca(array1[i],array2);
            if(Busca(array1[i],array2)){
              String s =""+array1[i]+" ";
              System.out.print(s);
            }  
           /*
            esse caso vai servir para saber que caso o numero do array1 seja
            igual ao do array2 , a variavel de controle vai fazer com que o loop continue , até
            que ache o caso que a variavel do array1 seja diferente da do array2
                                        
            for(int j=0;j<tamAtual2;j++){
               if(array1[i]==array2[j])
                   
                   aux = false;
           } 
          //se aux continuar true , então printa os valores dif. do array1 em relaçao ao array2
            if(aux){ 
              String s =""+array1[i]+" ";
              System.out.print(s);
           }*/ 
       }
 }
    public static boolean Busca(int dado,int lista[]) {
        int i;
        for(i=0;i<(lista.length);i++){
            if(lista[i]==dado){
            return false;
            }
        }         
        return true;
        
    }
   
}
