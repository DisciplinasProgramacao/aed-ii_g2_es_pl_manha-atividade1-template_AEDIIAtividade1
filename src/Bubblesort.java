import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;

public class Bubblesort<T extends Comparable <T>> implements IOrdenador<T> {

    private long comparacoes;
    private int movimentacoes;
    private LocalDate inicio, fim;



    @Override
    public T[] ordenar(T[] dados) {
        T[] copiaDados = Arrays.copyOf(dados, dados.length);
        int tamanho = copiaDados.length;
        inicio = LocalDate.now();
        for(int posReferencia = tamanho - 1; posReferencia > 0; posReferencia--){
            for( int posicao = 0; posicao < posReferencia; posicao++){
                comparacoes++;
                if(copiaDados[posicao].compareTo(copiaDados[posicao+1])>0){
                    trocar(posicao,posicao+1,copiaDados);
                }
            }
        }
        fim = LocalDate.now();
        return copiaDados;
    }

    private void trocar(int p1, int p2, T[]dados){
        movimentacoes+= 3;
        T temp = dados[p1];
        dados[p1]=dados[p2];
        dados[p2] = temp;
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
