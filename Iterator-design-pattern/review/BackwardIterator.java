public class BackwardIterator implements Iterator<String>{
    String[] array;
    int nxtPos;

    public BackwardIterator(String[] array, int nextPos){
        this.array = array;
        this.nxtPos = nextPos;
    }

    @Override public boolean hasNext(){
        return nxtPos >= 0;
    }
    @Override public String next(){
        if(this.hasNext()){
            return array[nxtPos--];
        }
        return null;
    }
    @Override public void remove(){
        if(nxtPos + 1 < 0 || nxtPos + 1 >= array.length){
            return;
        }
        array[nxtPos++] = null;
    }
}
