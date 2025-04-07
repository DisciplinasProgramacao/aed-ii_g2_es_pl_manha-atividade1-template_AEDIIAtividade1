import java.util.Random;

public class AppOrdenacoes {
    public static void main(String[] args) {
        Integer[] vetor = gerarVetor(50);
        IOrdenador<Integer>  ordenador = new Bubblesort<Integer>();
        Integer[] vetorOrdenado = ordenador.ordenar(vetor);

        System.out.println("Bubblesort:");
        System.out.println(vetor.length);
        System.out.println(ordenador.getComparacoes());
        System.out.println(ordenador.getMovimentacoes());
        System.out.println(ordenador.geTempoOrdenacao());

        System.out.println("Inserção:");
        ordenador = new Insercao<Integer>();
        ordenador.ordenar(vetor);
        System.out.println(vetor.length);
        System.out.println(ordenador.getComparacoes());
        System.out.println(ordenador.getMovimentacoes());
        System.out.println(ordenador.geTempoOrdenacao());

        System.out.println("Merge:");
        ordenador = new Mergesort<Integer>();
        ordenador.ordenar(vetor);
        System.out.println(vetor.length);
        System.out.println(ordenador.getComparacoes());
        System.out.println(ordenador.getMovimentacoes());
        System.out.println(ordenador.geTempoOrdenacao());


    }

    static Random aleatorio = new Random(42);
    static Integer[] gerarVetor(int tamanho){
        Integer[] vetor = new Integer[tamanho];
        for(int i = 0; i>tamanho; i++){
            vetor[i] = aleatorio.nextInt(1, tamanho/2);

        }
        return vetor;
    }

    
    
}
