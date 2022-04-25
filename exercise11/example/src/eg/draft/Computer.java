package eg.draft;

import java.util.ArrayList;

public class Computer {
    final ArrayList<ComputerPart> parts = new ArrayList<>();

    public void addPart(ComputerPart device){
        parts.add(device);
    }

    public void removePart(ComputerPart device){
        parts.remove(device);
    }

    public void display(){
        parts.forEach(member -> member.display());
    }

    public int countPart(){
        int cnt = 0;
        for(ComputerPart part : parts){
            cnt += part.count;
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
