
public class TrabalhoHeapSort {
	public static void main(String[] args) {
		//Estrutura ArvoreBinaria HeapSort para ordenar
		int[] vetor  = new int[10];
		
		//For para gerar números aleatórias preenchendo o vetor para o Heap Sort ordenar
		for(int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) Math.floor(Math.random() * vetor.length);
		}
		
		//N representando o tamanho do vetor
		int n = vetor.length;
		
		//For reponsalvel por pasar pela metade do vetor, a metade já é o suficiente para ordenado 
		//ultilizando o pai e os filhos da arvore
		for(int h = n / 2 - 1; h >= 0; h--) {
			//chamando a função por ter a estrutura do Heap Sort(Linha 43)
			//HeapSoirt sendo aplicada no vetor considerando a posição n(tamanho) e i(valor da arvore)
			AplHead(vetor, n, h);
		}
		
			//For reponsável por passar em cada registro da arvore 
			for(int s = n -1; s > 0; s--) {
				//Estrutura responsável por pegar o maior elemento e joga-lo no final
				// S seria o valor do final
				int auxiliar = vetor[0];
				vetor[0] = vetor[s];
				vetor[s] = auxiliar;
				
				//Depois que uma troca for feita e verificado se não á nenhum elemento maior a sua direita
				//Estura veto considerando o tamnho S e considerando a posição 0
				AplHead(vetor, s, 0);
			}
		
			System.out.println("Ordenado HEAP SORT");
			for(int i = 0; i< vetor.length; i++) {
				System.out.println(vetor[i] + ' ');
			}
			
	}
	
	public static void AplHead(int[] vetor, int n, int i) {
			//rais será o maior elemento de toda a estrutura da arvore
			int raiz = i;
			// 2 * i + 1 : para saber quem são os filhos da esquerda de uma determinada posição do vetor
			int esquerda = 2*i + 1;
			// 2 * i + 2 para saber quem são os filhos a direita de uma determinada posição do vetor
			int direita = 2*i + 2;
			
			
			//if responsável por verificar se o elemento da esquerda está no vetor
			// E também para saber o vetor na posição esqueda for maior que a raiz mudarem seus lugares
			if(esquerda < n && vetor[esquerda] > vetor[raiz]) {
				raiz = esquerda;
			}
			
			//If responsável por verificar se o elemento da direitat está no vetor
			//Responsável por verificar se a direita for maior que a raiz para trocarem seus lugares
			if(direita < n && vetor[direita] > vetor[raiz]) {
				raiz = direita;
			}
			
			
			//Se as condições acima foram executadas este será o if responsável por fazer a troca
			if(raiz != i) {
				int auxiliar = vetor [i];
				vetor[i] = vetor[raiz];
				vetor[raiz] = auxiliar;
			
				//Recursividade responsável por aplicar novamente no proximo registro da árvore
				AplHead(vetor, n, raiz);
			}
	}	
}
