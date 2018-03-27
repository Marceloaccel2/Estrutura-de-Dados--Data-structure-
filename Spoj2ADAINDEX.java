package spoj2;

import java.util.*;
import java.lang.String.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Marcelo
 */

//ADAINDEX

    public class Spoj2ADAINDEX{
        /* Implementação do Nó para ser utilizado na estrutura de dados */
	public static class No {
		private No ant;
		private String conteudo;
		private No prox;
		
		
                public No(){
			setProx(null);
		}

		public String getConteudo() {
			return conteudo;
		}

		public void setConteudo(String conteudo) {
			this.conteudo = conteudo;
		}

		public No getProx() {
			return prox;
		}

		public void setProx(No prox) {
			this.prox = prox;
		}

		public No getAnt() {
			return ant;
		}

		public void setAnt(No ant) {
			this.ant = ant;
		}
	}

        /* Implementação da estrutura de dados de LSE , só possui os metodos
        utilizados para resolver o problema*/
	public static class LSE {
            
		private No inicio;
		private No fim;
		private int tamanho;
		
		public LSE(){
			inicio = null;
			fim = null;		
			tamanho = 0;
		}
               
                /** Obtém o i-ésimo elemento de uma lista
	        Retorna o valor encontrado. */
                public String elemento (int pos) {
		    No aux = inicio;
		    int cont = 1;

		    // Percorre a lista do 1o elemento até pos 
		    while (cont < pos){
		        // modifica "aux" para apontar para o proximo elemento da lista 
		        aux = aux.getProx();
		        cont++;
		    }

		    return aux.getConteudo();
		}
                
                /** Obtém o tamanho da Lista*/
		public int tamanho() {
		    return tamanho;
		}
		
		/** Mostra se a Lista está vazia */
		public boolean vazia() {
		    if (tamanho == 0)
		        return true;
		    else
		        return false;
		}
		
                /** Insere nó em lista vazia */
		private boolean insereInicioLista(String valor) {
                    // Aloca memoria para novo Nó
		    No novoNo = new No();
		    
		    // Insere novo elemento na cabeca da lista
		    novoNo.setConteudo(valor);
		    novoNo.setProx(inicio);
		    
		    novoNo.setAnt(null);
		    if (vazia())
                        fim = novoNo; 
		    else
	    		inicio.setAnt(novoNo); 	    
		    
		    inicio = novoNo;
		    tamanho++;
		    return true;
		}
		
		/** Insere nó no fim da lista */
		private boolean insereFimLista(String dado){
		    // Aloca memoria para novo no 
		    No novoNo = new No();
		    novoNo.setConteudo(dado);

		    // Procura o final da lista 
		    No aux = inicio;
		    while(aux.getProx() != null){
		        aux = aux.getProx();
		    }

		    novoNo.setProx(null);
		    aux.setProx(novoNo);
		    
		    novoNo.setAnt(fim);  
		    fim.setProx(novoNo); 
		    fim = novoNo;       
		    
		    this.tamanho++;
		    return true;
		}
	}

    public static void main(String[] args) throws IOException{
        
        int Q,N; 
        //LSE = LISTA SIMPLESMENTE ENCADEADA
        
        //Aloca memoria para lista e lista2
        LSE lista= new LSE(); 
        LSE lista2= new LSE();
        
        //Serve para ler uma linha digitada retornando o valor de uma String
        BufferedReader linha = new BufferedReader(new InputStreamReader(System.in));
        
        /*Nesse caso , será digitada uma string em uma linha toda*/
        String S = linha.readLine();
        /*Metodo  Split quebra a string em substrings fazendo com que seja sepadas
          por um espaço ,no caso a primeira palavra antes do espaço vai ser armaze
          nada em N e a segunda palabra depois do espaço será armazenada em Q em
          forma de inteiro usando o metodo de conversão Integer.parseInt()*/
        
        /*
        =OBS=
        Foi testado o metodo scanner pelos jeito mas mesmo assim , ainda gerou
        exceção do tipo java.lang.NumberFormatException , para não ficar tão complexo
        , resolvi usar o metodo split, mais pratico e mais rapido.
        String s1;s2;
        s1=s1.nextLine();
        s2=s2.nextLine();
        N=Integer.parseInt(s1);
        Q=Integer.parseInt(s2);
        */
        
        String[] separador = S.split(" ");
        N = Integer.parseInt(separador[0]);
        Q = Integer.parseInt(separador[1]);
        
        for(int i=0;i<N;i++){
           /*Irá adicionar a primeira string na lista de banco de dados , entao a lista
            deixará de ser vazia e irá pular para o else até a condição 
            (i<=N) seja falsa*/
            if(lista.vazia()) 
		lista.insereInicioLista(linha.readLine());
            else
                lista.insereFimLista(linha.readLine());
		}
       
        /*Irá adicionar a primeira string na lista de prefixos , entao a lista
          deixará de ser vazia e irá pular para o else até a condição 
          (i<=N) seja falsa*/
        for(int i=0;i<Q;i++){
            if(lista2.vazia()) 
		lista2.insereInicioLista(linha.readLine());
            else
                lista2.insereFimLista(linha.readLine());
        }
     
        for(int i=1;i<=lista2.tamanho;i++) {
			int cont = 0;
                        //for de comparação
			for(int j=1;j<=lista.tamanho;j++) {
                        //Este método (startsWith) testa se uma cadeia começa com o prefixo especificado, com um índice especificado ou por padrão no início.
				if(lista.elemento(j).startsWith(lista2.elemento(i))) {
				//Se comparar e tiver o prefixo na palvra comparada , incrementa o contador	
                                    cont++;
				}
			}
			System.out.println(cont);
        }
    }
    
}
/** Outra forma que fiz sem utilizar Lista encadeada ,usei uma logica muito parecida
com a utilizada em FUN WITH SEQUENCES SPOJ 1                                     **/

/*public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int tamAtual1;                  
        int tamAtual2;
    
        tamAtual1 = ler.nextInt();
        tamAtual2 = ler.nextInt();
        
        //criação do array de palavras
        String [] arrayPlv = new String[tamAtual1];
        
       //adicionar as palavras digitados pelo usuario no arrayPlv
         for (int i=0;i<tamAtual1;i++) {
            arrayPlv[i] = ler.next();
         }
       
       //criação do array de prefixos
         String [] arrayPref = new String[tamAtual2];

       //adicionar os prefixos no arrayPref
         for (int j=0;j<tamAtual2;j++) {
            arrayPref[j] = ler.next();
        }
         
         for(int i=0;i<tamAtual2;i++){
             String prefixo = arrayPref[i];
             int cont =0;
             for(int j=0;j<tamAtual1;j++){
                 String lista = arrayPlv[j];
                 if(lista.startsWith(prefixo)){
                    cont++;
                }
            }
   
         System.out.println(cont);
        }

    }*/