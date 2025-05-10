public interface IOrdenador<T extends Comparable<T>> {
    public T[] ordenar(T[]dados);
    public long getComparacoes();
    public int getMovimentacoes();
    public double geTempoOrdenacao();
    
}
