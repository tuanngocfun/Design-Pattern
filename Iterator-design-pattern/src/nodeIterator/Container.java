package nodeIterator;

public interface Container<T> {
    public MyIterator<T> iterator();
    default public MyIterator<T> riterator() {
        throw new UnsupportedOperationException();
    }
}
