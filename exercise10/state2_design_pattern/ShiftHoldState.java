package state2_design_pattern;

public class ShiftHoldState implements State{
    @Override public void hold(Keyboard keyboard, Key key){
        if(key.equals(Key.FN)){
            keyboard.setState(new FnShiftHoldState());
        }
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
            keyboard.setState(new CapsLockShiftHoldState());
        } else {
            System.out.println();
        }
    }
}
