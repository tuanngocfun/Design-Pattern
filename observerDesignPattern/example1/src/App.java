import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        LineSourceOptionA subjectA = new LineSourceOptionA();
        new LineLowerCase(subjectA);
        new LineUppercase(subjectA);
        new LineLength(subjectA);

        System.out.println("state change: hello");
        subjectA.setState("hello");
    }
}
class LineSourceOptionA{
    private List<IlineProcessing> listSource = new ArrayList<IlineProcessing>();
    private String line;
    private int state;

    public void attach(IlineProcessing lineProc){
        listSource.add(lineProc);
    }
    public void add(IlineProcessing iProcessing){
        listSource.add(iProcessing);
    }
    public void setState(String line){
        this.line = line;
        startProcess();
    }
    private void startProcess(){
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNextLine()){
            state++;
            String line = scanner.nextLine();
            for(IlineProcessing lineProc : listSource){
                this.line = line;
                lineProc.update();
            }
        }
        scanner.close();
    }
    public String getState(){
        return "#"+String.valueOf(state)+" "+this.line;
    }
}
abstract class IlineProcessing{
    protected LineSourceOptionA iLineSource;

    public abstract void update();
}
class LineUppercase extends IlineProcessing {

    public LineUppercase(LineSourceOptionA iLineSource){
        this.iLineSource = iLineSource; 
        this.iLineSource.add(this);
    }

    @Override public void update() {
        System.out.println("Line of character has been capitalized... "+iLineSource.getState().toUpperCase());
    }

}
class LineLowerCase extends IlineProcessing {

    public LineLowerCase(LineSourceOptionA iLineSource){
        this.iLineSource = iLineSource; 
        this.iLineSource.add(this);
    }

    @Override public void update() {
        System.out.println("Line of character has been lowercase... "+iLineSource.getState().toLowerCase());
    }
}
class LineLength extends IlineProcessing {

    public LineLength(LineSourceOptionA iLineSource){
        this.iLineSource = iLineSource; 
        this.iLineSource.add(this);
    }

    @Override public void update() {
        System.out.println("The length of line: "+iLineSource.getState().length());
    }
}