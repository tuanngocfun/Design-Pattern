public interface Container<T> {
    Iterator<T> getIterator();
    default Iterator<T> getReverseIterator(){
        throw new UnsupportedOperationException();
    }
}
