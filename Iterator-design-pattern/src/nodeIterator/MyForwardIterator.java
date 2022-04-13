package nodeIterator;
public class MyForwardIterator implements MyIterator<String> {
    int nextPos;
    String[] array;
        
    public MyForwardIterator(int nextPos, String array[]) {
        this.nextPos = nextPos;
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return nextPos < array.length;
    }

    @Override
    public void remove() {
        if(nextPos - 1 < 0 || nextPos - 1 >= array.length)
            return;

        array[nextPos - 1] = null;
    }

    @Override
    public String next() {
        if(nextPos >= array.length) {
            return null;
        }
        else {
            return array[nextPos++];
        }
    }
}
