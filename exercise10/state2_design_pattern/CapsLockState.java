package state2_design_pattern;

public class CapsLockState implements State{
    @Override public void hold(Keyboard keyboard, Key key){
        if(key.equals(Key.SHIFT)){
            keyboard.setState(new CapsLockShiftHoldState());
        } else if(key.equals(Key.FN)){
            keyboard.setState(new CapsLockFnHoldState());
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
        } else {
            System.out.println();
        }
    }
}
