package state_design_pattern;

public class CapslockState implements State {
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
        } else if (key.equals(Key.CAPS_LOCK)){
            keyboard.setState(new NormalState());
        }
    }
}
