package sample;

public class Client {
    public static void main(String[] args) {
        Keyboard keyboard = new Keyboard();
        System.out.println("Keyboard");
        System.out.println("=====================");
        
        System.out.println("Tap normally");
        keyboard.tap(Key.Q);
        System.out.println();
        
        System.out.println("Turn on caps lock");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println();
        
        System.out.println("Turn off caps lock and hold shift");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.hold(Key.SHIFT);
        keyboard.tap(Key.Q);
        System.out.println();
        
        System.out.println("Turn on caps lock while still holding shift");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println();
        
        System.out.println("Unhold shift but caps lock is still being turned on");
        keyboard.unhold(Key.SHIFT);
        keyboard.tap(Key.Q); 
        System.out.println();
        
        System.out.println("Turn off caps lock");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println();
    } 
}
enum Key {
    Q(Key.LETTER_KEY), 
    S(Key.LETTER_KEY), 
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

class Keyboard {
    private State state;
    private Key heldKey;
    
    public Keyboard() {
        state = new NormalState();
        heldKey = null;
    }
    
    void setState(State state) {
        this.state = state;
    }
    
    public Key getHeldKey() {
        return heldKey;
    }
    
    public void hold(Key key) {
        heldKey = key;
        state.hold(this, heldKey);
    }
    
    public void unhold(Key key) {
        if(heldKey.equals(key)) {
            state.unhold(this, key);
            heldKey = null;
        }
    }
    
    public void tap(Key key) {
        state.tap(this, key);
    }
}

interface State {
    public void hold(Keyboard keyboard, Key key);
    public void unhold(Keyboard keyboard, Key key);
    public void tap(Keyboard keyboard, Key key);
}

class NormalState implements State {
    @Override
    public void hold(Keyboard keyboard, Key key) {
        if(key.equals(Key.SHIFT)) {
            keyboard.setState(new ShiftHeldState());
        }
    }
    
    @Override
    public void unhold(Keyboard keyboard, Key key) {
        // DO NOTHINGShiftHeldState
    }
    
    @Override
    public void tap(Keyboard keyboard, Key key) {
        if(key.getType() == Key.LETTER_KEY) {
            System.out.println(key.toString().toLowerCase());
        }
        else if(key.equals(Key.CAPS_LOCK)) {
            keyboard.setState(new CapslockState());
        }
    }
}

class CapslockState implements State {
    @Override
    public void hold(Keyboard keyboard, Key key) {
        if(key.equals(Key.SHIFT)) {
            keyboard.setState(new CapslockShiftHeldState());
        }
    }
    
    @Override
    public void unhold(Keyboard keyboard, Key key) {
        // DO NOTHING
    }
    
    @Override
    public void tap(Keyboard keyboard, Key key) {
        if(key.getType() == Key.LETTER_KEY) {
            System.out.println(key.toString().toUpperCase());
        }
        else if(key.equals(Key.CAPS_LOCK)) {
            keyboard.setState(new NormalState());
        }
    }
}

class ShiftHeldState implements State {
    @Override
    public void hold(Keyboard keyboard, Key key) {
        // DO NOTHING
    }
    
    @Override
    public void unhold(Keyboard keyboard, Key key) {
        if(key.equals(Key.SHIFT)) {
            keyboard.setState(new NormalState());
        }
    }
    
    @Override
    public void tap(Keyboard keyboard, Key key) {
        if(key.getType() == Key.LETTER_KEY) {
            System.out.println(key.toString().toUpperCase());
        }
        else if(key.equals(Key.CAPS_LOCK)){
            keyboard.setState(new CapslockShiftHeldState());
        }
    }
}

class CapslockShiftHeldState implements State {
    @Override
    public void hold(Keyboard keyboard, Key key) {
        // DO NOTHING
    }
    
    @Override
    public void unhold(Keyboard keyboard, Key key) {
        if(key.equals(Key.SHIFT)) {
            keyboard.setState(new CapslockState());
        }
    }
    
    @Override
    public void tap(Keyboard keyboard, Key key) {
        if(key.getType() == Key.LETTER_KEY) {
            System.out.println(key.toString().toLowerCase());
        }
        else if(key.equals(Key.CAPS_LOCK)){
            keyboard.setState(new ShiftHeldState());
        }
    }
}
