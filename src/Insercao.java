import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;

public class Insercao <T extends Comparable<T>> implements IOrdenador<T> {
     
    private long comparacoes;
    private int movimentacoes;
    private LocalDate inicio, fim;



    @Override
    public T[] ordenar(T[] dados) {
        T[] copiaDados = Arrays.copyOf(dados, dados.length);
        int tamanho = copiaDados.length;
        inicio = LocalDate.now();
        for(int posReferencia = 1; posReferencia < tamanho-1; posReferencia++){
            T valorReferencia = copiaDados[posReferencia];
            int posicao = posReferencia - 1;
            while(posicao >= 0 && copiaDados[posicao].compareTo(valorReferencia) > 0){
                comparacoes++;
                posicao--;
            }
            copiaDados( posicao + 1, posReferencia, copiaDados);
            copiaDados[posicao + 1] = valorReferencia;
            movimentacoes +=2;
        }
        
        fim = LocalDate.now();
        return copiaDados;
    }

    private void copiaDados(int inicio, int fim, T[] dados){
        for(int i = fim; i > inicio; i--){
            movimentacoes++;
            dados[i] = dados[i-1];
        }
    }

    @Override
    public long getComparacoes() {
       return comparacoes;
    }

    @Override
    public int getMovimentacoes() {
        return movimentacoes;
    }

    @Override
    public double geTempoOrdenacao() {
        return Duration.between(inicio, fim).toMillis();
    }
    
}
