import java.util.Comparator;

public interface IOrdenador<T extends Comparable<T>> {

    T[] ordenar(T[] dados);

    T[] ordenar(T[] dados, Comparator<T> comparator);

    long getTempoOrdenacao();
}
