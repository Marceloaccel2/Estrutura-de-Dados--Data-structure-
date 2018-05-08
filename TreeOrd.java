package treeord;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

/**
 * @author Marcelo
 */
public class TreeOrd {

    public static void main(String[] args) throws IOException{
        try{
            
            Scanner ler = new Scanner(System.in);
            /*Número de colunas da entrada*/
            int x =  ler.nextInt(); 
            /*A arvore será um array bidimensional com 3 linhas e x colunas 
              ,definida pelo usuario*/
            int[][] arvore = new int[3][x];
            /*For para setar os valores de entrada no array bidimensional*/
            for(int i=0;i<3;i++)
                for(int j=0;j<x;j++)
                    arvore[i][j] = ler.nextInt();
            /*
              Preorder: parent, left subtree, right subtree
              Postorder: left subtree, right subtree, parent
              Inorder: left subtree, parent, right subtree  
            
              Como na questão ele especifica as formas pecorridas na arvore,podemos
              tirar uma conclusão de que na Preorder o primeiro elemento a ser pecorrido
              será equivalente ao ultimo elemento pecorrido na PostOrder , e que o ultimo
              elemento a ser pecorrido na Preorder será o ultimo a ser pecorrido igualmente
              na Inorder , trazendo assim uma ideia universal a ser aplicada na questão.
              
              Ao invés de comparar elemento por elemento, a ideia principal foi pegar os
              casos diferentes e semelhantes de entrada e trabalhar em cima deles baseado 
              nos algoritmos dados na questão,com isso foi utilizado o if nos elementos do
              inicio e do fim , pois serão os unicos que vamos ter certeza dos seus valores.
              
            */
            if(arvore[0][0]== arvore[1][x-1] && arvore[0][x-1]== arvore[2][x-1])
                System.out.println("yes\n");
            else
                System.out.println("no\n");
        }catch(Exception e){
        	System.out.println(e.toString());
        }

    }
    
}
