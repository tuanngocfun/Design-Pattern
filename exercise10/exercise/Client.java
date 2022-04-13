package exercise;


public class Client {
    public static void main(String args[]) {
        System.out.println("Keyboard");
        System.out.println("===============");
        
        Keyboard keyboard = new Keyboard();    
        keyboard.tap(Key.Q);
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);


        System.out.println("Refactor code:");
        System.out.println("================");
        Context ctx = new Context();

        CapitalState capState = new CapitalState();
        capState.tap(ctx, Key.Q, Hold.ON);

        System.out.println(ctx.getState().toString());

        InitialState lowState = new InitialState();
        lowState.tap(ctx, Key.Q, Hold.OFF);

        System.out.println(ctx.getState().toString());
    }

}
enum Hold {
    ON, OFF
}

enum Key {
    Q, CAPS_LOCK
}

class Context {
    private State state;

    public Context(){
        state = null;
    }
    
    public void tap(Key key, Hold hold){
        state.tap(this, key, hold);
    }
    public void setState(State state) {
        this.state = state;
    }

    public State getState(){
        return state;
    }
}

class CapitalState implements State {
    public void tap(Context ctx, Key key, Hold hold) {
        System.out.println("Input from the keyboard:");
        if(key.compareTo(Key.CAPS_LOCK)==0 && hold.compareTo(Hold.ON)==0){
            System.out.println("");
        } else if(key.compareTo(Key.Q)==0 && hold.compareTo(Hold.ON)==0){
            System.out.println("Q".toUpperCase());
        } else if(key.compareTo(Key.Q)==0){
            System.out.println("Q".toUpperCase());
        } 
        
        ctx.setState(this);
    }
    @Override public String toString(){
        return "uppercase state";
    }
}

class InitialState implements State {
    public void tap(Context ctx, Key key, Hold hold) {
        System.out.println("Output from the keyboard:");
        if(key.compareTo(Key.Q)==0&&hold.compareTo(Hold.OFF)==0){
            System.out.println("Q".toLowerCase());
        } else if(hold.compareTo(Hold.OFF)==0) {
            System.out.println("");
        }
        ctx.setState(this); 
    }
    @Override public String toString(){
        return "lowercase state";
    }
}
interface State{
    void tap(Context ctx, Key key, Hold hold);
}
 
class Keyboard {
    private Hold capsLock = Hold.OFF;
    
    private Hold toggle(Hold p) {
        Hold result;
        switch (p) {
        case ON: {
            result = Hold.OFF;
            break;
        }
        case OFF: {
            result = Hold.ON;
            break;
        }
        default : {
            result = p;
            }
        }
        return result;
    }
    
    public void tap(Key k) {
        switch(k) {
        case Q : {
            switch (capsLock) {
            case ON : {
                System.out.println("Q");
                break;
            }
            case OFF : {
                System.out.println("q");
                break;
            }
            default : {
                System.out.println("UNEXPECTED");
                }
            }
            break;
            
        }
        case CAPS_LOCK : {
            capsLock = toggle(capsLock);
            break;
        }
        default : {
            System.out.println("UNKNOWN KEY");
            }
        }
        
    }
 
}
 
 
