package state_design_pattern;

public class NormalState implements State{
    @Override public void hold(Keyboard keyboard, Key key){
        if(key.equals(Key.SHIFT)){
            keyboard.setState(new ShiftHoldState());
        }
    }
    @Override public void unhold(Keyboard keyboard, Key key){
        // DO NOTHING
    }
    @Override public void tap(Keyboard keyboard, Key key){
        if(key.getType() == Key.LETTER_KEY){
            System.out.println(key.toString().toLowerCase());
        } else if(key.equals(Key.CAPS_LOCK)) {
            keyboard.setState(new CapslockState());
        }
    }
}