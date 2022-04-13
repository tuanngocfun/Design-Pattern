import java.util.Arrays;

public class exercise {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();
  
        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
           String name = (String)iter.next();
           System.out.println("Name : " + name);
        } 	

        Iterator it = namesRepository.getIterator();
        boolean contain = false;
        while(it.hasNext()){
            String name = (String) it.next();
            if(name.equalsIgnoreCase("Hoang")){
                contain = true;
            } else {
                contain = false;
            }
        }
        if(contain){
            System.out.println("the list has name Hoang ");
        } else {
            System.out.println("no it does not have it");
        }


        NameRepository myContainer = new NameRepository();
        print(myContainer);
        find(myContainer, "John");
     }

     public static void print(NameRepository nameRepository){
         for(Iterator iter = nameRepository.getIterator(); iter.hasNext();){
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        } 	  
     }

     public static void sortLexOrder(NameRepository nameRepository){
         String[] array;
         for(Iterator iter = nameRepository.getIterator(); iter.hasNext();){
            String name = (String) iter.next();
            array = name.split("");
            for(int i = 0; i < array.length; ++i){
                for(int j = i+1; j < array.length; j++){
                    if(array[i].compareToIgnoreCase(array[j])>0){
                        String tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;
                    }
                }
            }
         }
     }

    public static void findNext(NameRepository nameRepository, Object toFind){
        boolean found = false;
        Iterator iter = nameRepository.getIterator();
        String name="";
        while(iter.hasNext()){
            if(iter.next().equals(toFind)){
                found = true;
                break;
            }
        }
        name = (String) iter.next();
        if(found){
            System.out.println("the list has name: "+name);
        } else {
            System.out.println("no it does not have:"+name);
        }
    }

    public static void find(Container container, Object toFind){
        boolean found = false;

        Iterator iter = container.getIterator();
        while(iter.hasNext()){
            if(iter.next().equals(toFind)){
                found = true;
                break;
            }
        }
        if(found){
            System.out.println("the list has name: "+toFind);
        } else {
            System.out.println("no it does not have:"+toFind);
        }
    }
}
interface Container {
    public Iterator getIterator();
    public void sortName();
}
interface Iterator {
    public boolean hasNext();
    public Object next();
}
class NameRepository implements Container{
    public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    @Override public void sortName(){
        Arrays.sort(names);
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            Arrays.sort(names);
            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }		
    }
}