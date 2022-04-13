package nodeIterator;
public class MyReverseIterator implements MyIterator<String> {
    int nextPos;
    String[] array;

    public MyReverseIterator(int nextPos, String[] array) {
        this.nextPos = nextPos;
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return nextPos >= 0;
    }

    @Override
    public void remove() {
        if(nextPos + 1 < 0 || nextPos + 1 >= array.length)
            return;

        array[nextPos + 1] = null;
    }

    @Override
    public String next() {
        if(nextPos < 0) {
            return null;
        }
        else {
            return array[nextPos--];
        }
    }
}
