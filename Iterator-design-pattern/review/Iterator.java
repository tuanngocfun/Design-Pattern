public interface Iterator<T> {
    boolean hasNext(); // must have this method
    T next(); // must have this method
    void remove(); // supplement method 
}
