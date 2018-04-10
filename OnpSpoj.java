package onpspoj;
import java.io.*;
import java.util.*;

// @author: Marcelo

public class OnpSpoj {
    /**OBSERVAÇÕES IMPORTANTES
      Foi utilizado a classe STACK(Pilha) juntamente com os metodos:
      -push() = Insere um elemento na pilha
      -pop()= Remove um elemento da pilha
      -lastElement() = verifica o ultimo elemento da pilha
    **/
     
    public static void main(String[] args) throws IOException{
        try{
            //Serve para ler uma linha digitada retornando o valor de uma String
            BufferedReader linha = new BufferedReader(new InputStreamReader(System.in));
            
            //Converte a string para tipo Int , para saber o número de expressões
            int t = Integer.parseInt(linha.readLine());
            
            /*String s vai possuir o tamanho digitado em t
              Como na questão a entrada é 3 ,ou seja , o valor de t é 3 , logo
              s vai possuir 3 espressões armazenadas nela */
            String s [] = new String[t];
            
            
            for(int i = 0; i < t; i++){
                /*Alocando a variavel pilha
                  RPN = Reverse Polish Notation
                  Pilha rpn = new Pilha() , criei uma pilha de caracteres
                */
                Stack<Character> rpn = new Stack<Character>();
                
                
                /*s vai ser uma string que vai servir para juntar todos os char's de exp que satisfaçam
                  a proposta da questão , por isso vai ter que começar sem nada*/
                s[i] = "";
                
                //aux vai armazenar o que tem na linha
                String aux = linha.readLine();
                
                //Variavel tamanho vai ser igual ao tamanho total da string aux
                int tamanhoDeAux = aux.length();

                /*toCharArray pega uma String e constroi um array de Caracteres
                  ,ou seja, vai pegar o que foi digitado na string aux ,e separar em
                  um array de caracteres armazenando em exp(expressão) */
                char[] exp = aux.toCharArray(); 

                /*Vai pecorrer a String "quebrada" em char's da esquerda para direita em ordem*/
                for(int j = 0; j < tamanhoDeAux; j++){
                    
                    /*Sempre quando existir uma letra do alfabeto , irá adicionar a s
                      O método java Character.isAlphabetic (int codePoint) determina
                      se o caractere especificado é um alfabeto.
                    */
                    if(Character.isAlphabetic(exp[j])){
                        s[i] = s[i]+exp[j];
                    }
                    
                    //caso apareça um char em exp '(' , vai ser inserido na pilha 
                    else if(exp[j] == '('){
                        rpn.push('(');
                    }
                    
                    /*Quando existe ')' sem existir '(' inserido na pilha , quer dizer que
                     o topo da pilha tem operador , logo vai ter que ser retirado para ser
                     utilizado em s , lembrando que quando chama o rpn.pop, ele sempre
                     vai desempilhar, nao é obrigado a funçao rpn.pop ta sozinha pra poder
                     desempilhar como demonstrado na linha 77*/
                    else if(exp[j] == ')'){
                        while(rpn.lastElement() != '('){
                            s[i] = s[i]+rpn.pop();
                        }
                        rpn.pop();
                    }
                    
                    /*Essa parte vai ficar encarregada de adicionar os operadores nas saidas;
                      A ordem de precedencia dos operadores está de acordo com o simbolo '(' e ')'
                      o operador que tiver mais proximo de um ')' será empilhado por ultimo pra retornar
                      como primeiro em s ,mas quando existir um operador entre ')' e '(' 
                      terá que ser empilhado primeiro pra ser desempilhado por ultimo.
                    */
                    else if(exp[j] == '^' || exp[j] == '/' || exp[j] == '*' || exp[j] == '-'|| exp[j] == '+'){
                        rpn.push(exp[j]);
                    } 
                }
            }
            /*For que vai formmar as expressões de saida*/
            for(int i = 0; i < t; i++){
                System.out.println(s[i]);
            }
        /*Try e catch para tratar o erro do SPOJ de NZEC ERROR(runtime error) ou NullPointerException*/   
        }catch(Exception e){
        	System.out.println(e.toString());
        }

    }
    
}
