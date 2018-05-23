package spoj8;
import java.io.*;
import java.util.*;
import java.lang.String.*;

//Autor: Marcelo Alves
class BST {
    
    private No raiz;
    private int cont;
    /*Construtor da classe BST*/
    public BST(){
        cont = 0;
        raiz = null;
    }
    public int getContador(){
        return cont;
    }
    
    class No {
        private int conteudo;
        private No esq;
        private No dir;
	
        public No(){
            esq = null;
            dir = null;
    }
	
        public int getConteudo() {
            return conteudo;
	}
	public void setConteudo(int conteudo) {
            this.conteudo = conteudo;
	}
	
	public No getEsq() {
            return esq;
	}
	public void setEsq(No esq) {
            this.esq = esq;
	}
	
	public No getDir() {
            return dir;
	}
	
	public void setDir(No dir) {
            this.dir = dir;
	}
    }
	     
	/** O metodo insere um nó em uma árvore BST Retorna 1 se a insere for um sucesso.
	    Caso for false , o valor retornado é 0 **/
	public boolean insere(int valor){

		No novoNo = new No();
		novoNo.setConteudo(valor);
		novoNo.setEsq(null);
		novoNo.setDir(null);
                
                // Arvore vazia
		if (raiz == null){ 
	 		raiz = novoNo;
			return true;
		}

	    /* Busca a posicao correta para inserir o novo No */
	    No aux = raiz;
	    No p = null;
	    while (aux != null) {
	    		p = aux;
			if (valor < aux.getConteudo()){
                                cont++;
				aux = aux.getEsq();
                        }else{
                                cont++;
				aux = aux.getDir();
                        }
		}

		/* Encontra-se um nó folha para inserir */
		if (valor < p.getConteudo()){
			p.setEsq(novoNo);
                }else{
			p.setDir(novoNo);
                }
		return true;
	}
}


public class Spoj8 {
    
    public static void main(String[] args) throws IOException{
        
        try{
            int data;
            BufferedReader linha = new BufferedReader(new InputStreamReader(System.in));
            int s = Integer.parseInt(linha.readLine());
            if(s>300000)
                return;
            int arrayExit[] = new int[s];
            BST arvore = new BST();
            for(int i = 0; i < s; i++){
                data = Integer.parseInt(linha.readLine());
                arvore.insere(data);
                System.out.println(arvore.getContador());
            }
        }catch(Exception e){
                System.out.println(e.getMessage());
        }
        
    }
    
}
