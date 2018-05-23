package nicebtre;
import java.io.*;


 // Autor: Marcelo Alves

public class NICEBTRE {
    /****                      CODIGO PRINCIPAL                  ****/
    
    
    public static void main(String[] args) throws IOException{
		/* Try para tratar o NZEC(Non-Zero Exit Code)ERROR do SPOJ */
                try{
                    //Serve para ler uma linha digitada retornando o valor de uma String
                    BufferedReader linha = new BufferedReader(new InputStreamReader(System.in));
                    
                   //Converte a string para tipo Int , para saber o número de expressões
                    int s = Integer.parseInt(linha.readLine());
                    
                  /*O arrayExit vai possuir o tamanho digitado em s
                    Como na questão a entrada é 3 ,ou seja , o valor de s é 3 , logo
                    arrayExit vai possuir 3 espressões armazenadas nela*/          
                    int arrayExit[] = new int[s];
                    
                  /*Seguindo o exemplo da questão ,como o arrayExit vai ter tamanho 3
                    ,isso vai fazer com que o usuario coloque as 3 entradas linha por linha,
                    depois disso o programa vai pegar as espressoes e "quebrar" em um array
                    de char e armazenar em arrayExit , com isso cria-se uma arvore para que char
                    por char seja estudado na funçao profundidade e exibindo na saida a profundidade
                    total de cada expressão*/
                    for(int i = 0; i < s; i++) {
			String aux = linha.readLine();
                        
                        /*O metodo toCharArray basicamente transforma uma String em um array de char*/
			char charArray[] = aux.toCharArray();
			Arvore t = new Arvore();
			t.inserir(charArray);
			arrayExit[i] = t.getProfundidade(t.raiz);
                      	System.out.println(arrayExit[i]);
                    }
         
                }catch(Exception e) {
                    System.out.println(e.getMessage());
		}
    }
   
    
    
    /****                      CLASSES                   ****/
    
    
    /*Classe No de uma arvore binaria*/
    static class No {
	private char conteudo;
	private No esq;
	private No dir;
        
    /*Construtor No de uma arvore binaria*/
	public No(char conteudo){
            this.conteudo = conteudo;
            esq = null;
            dir = null;
	}
    }
    /*Classe Arvore para criar uma Binary Tree*/
    static class Arvore{
	private No raiz;
	private No aux;
	private int index = 0;
		
	public Arvore() {
            raiz = null;
	}
        
        //Métodos da Arvore - add e profundidade     
	public No addFolha(char conteudo, char c[]) {
            No aux = new No(conteudo);
			
            if(conteudo == 'n') {
		aux.esq = addFolha(c[++index], c);
		aux.dir = addFolha(c[++index], c);

            }
            return aux;
        }
	/*Metodo esse que diz a profundidade baseado se for 1 ou n*/	
	public int getProfundidade(No n) {
            /*Na questão diz que A profundidade de uma árvore é 
              definida como o comprimento do caminho mais longo com uma 
              extremidade na raiz e que nós são rotulados pela letra n , ou seja
              dependendo da quantidade de n's que estiver na entrada ,induzimos
              que o tamanho da arvore será maior ,pois como consequencia de mais
              nos , tem-se maior quantidade de filhos e de folhas*/	
            if(n.conteudo == 'l') {
		return 0;
            }
            
            /*Recursão
            Commpara a profundidade da esquerda da arvore com a da direita da arvore,em uma maneira recursiva*/
            int esqProfundidade = getProfundidade(n.esq);
            int dirProfundidade = getProfundidade(n.dir);
            
            return esqProfundidade > dirProfundidade ? esqProfundidade + 1 : dirProfundidade + 1;     
	}
        
        //Insere uma raiz
        public void inserir(char c[]) {
            No novoNo = new No(c[index]);
            raiz = novoNo;
			
            if(c[index] == 'n') {
                novoNo.esq = addFolha(c[++index], c);
                novoNo.dir = addFolha(c[++index], c);
            }
			
	}
    }
    
}
