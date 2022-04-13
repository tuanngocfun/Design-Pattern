package optimize2;

public class Client{
    public static void main(String[] args) {
        System.out.println("Keyboard");
        System.out.println("<<< -------------------------------------------------------------- >>>");
        Keyboard keyboard = new Keyboard();

        System.out.println("Tap only q:");
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Turn caps lock on");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Remain turning caps lock on and hold shift");
        keyboard.hold(Key.SHIFT);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Turn caps lock off and unhold shift");
        keyboard.unhold(Key.SHIFT);
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Holding shift");
        keyboard.hold(Key.SHIFT);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Remain holding turns caps lock on");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Remain turing caps lock on and unhold shift");
        keyboard.unhold(Key.SHIFT);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Turn caps lock off");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Holding shift");
        keyboard.hold(Key.SHIFT);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Remain holding turns caps lock on");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Remain holding shift and turn caps lock off");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");
        
        System.out.println("Holding shift");
        keyboard.hold(Key.SHIFT);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Remain holding shift and turns caps lock on");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Remain holding shift and turn caps lock off");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Unhold shift");
        keyboard.unhold(Key.SHIFT);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");
    }
}
enum Key{
    Q(Key.LETTER_KEY), 
    // S(Key.LETTER_KEY), 
    CAPS_LOCK(Key.CONTROL_KEY),
    SHIFT(Key.CONTROL_KEY);
    
    public static final int LETTER_KEY = 1;
    public static final int CONTROL_KEY = 2;
    
    private final int type;
    
    private Key(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}

class Keyboard{
    private State state;
    private Key key;
    
    public Keyboard() {
        state = new NormalState();
        this.key = null;
    }
    
    void setState(State state) {
        this.state = state;
    }  
    public Key getHoldKey() {
        return this.key;
    }
    public void hold(Key key) {
        this.key = key;
        state.hold(this, this.key);
    }
    public void unhold(Key key) {
        if(this.key.equals(key)) {
            state.unhold(this, key);
            this.key = null;
        }
    }
    public void tap(Key key) {
        state.tap(this, key);
    }
}

interface State{
    public void hold(Keyboard keyboard, Key key);
    public void unhold(Keyboard keyboard, Key key);
    public void tap(Keyboard keyboard, Key key);
}

class NormalState implements State{
    @Override public void hold(Keyboard keyboard, Key key) {
        if(key.equals(Key.SHIFT)) {
            keyboard.setState(new ShiftHoldState());
        }
    }
    @Override public void unhold(Keyboard keyboard, Key key) {
        // DO NOTHING
    }
    @Override public void tap(Keyboard keyboard, Key key) {
        if(key.getType() == Key.LETTER_KEY) {
            System.out.println(key.toString().toLowerCase());
        } else if(key.equals(Key.CAPS_LOCK)) {
            keyboard.setState(new CapslockState());
        }
    }
}

class ShiftHoldState implements State{
    @Override public void hold(Keyboard keyboard, Key key){
        // DO NOTHING
    }
    @Override public void unhold(Keyboard keyboard, Key key){
        if(key.equals(Key.SHIFT)){
            keyboard.setState(new NormalState());
        }
    }
    @Override public void tap(Keyboard keyboard, Key key){
        if(key.getType() == Key.LETTER_KEY){
            System.out.println(key.toString().toUpperCase());
        } else if(key.equals(Key.CAPS_LOCK)){
            keyboard.setState(new CapslockShiftHoldState());
        }
    }
}

class CapslockState implements State{
    @Override public void hold(Keyboard keyboard, Key key){
        if(key.equals(Key.SHIFT)){
            keyboard.setState(new CapslockShiftHoldState());
        }
    }
    @Override public void unhold(Keyboard keyboard, Key key){
        // DO NOTHING
    }
    @Override public void tap(Keyboard keyboard, Key key){
        if(key.getType() == Key.LETTER_KEY){
            System.out.println(key.toString().toUpperCase());
        } else if(key.equals(Key.CAPS_LOCK)){
            keyboard.setState(new NormalState());
        }
    }
}

class CapslockShiftHoldState implements State{
    @Override public void hold(Keyboard keyboard, Key key){
        // DO NOTHING
    }
    @Override public void unhold(Keyboard keyboard, Key key){
        if(key.equals(Key.SHIFT)){
            keyboard.setState(new CapslockState());
        }
    }
    @Override public void tap(Keyboard keyboard, Key key){
        if(key.getType() == Key.LETTER_KEY){
            System.out.println(key.toString().toUpperCase());
        } else if(key.equals(Key.CAPS_LOCK)){
            keyboard.setState(new ShiftHoldState());
        }
    }
}