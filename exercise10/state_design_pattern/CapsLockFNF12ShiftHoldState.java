package state_design_pattern;

public class CapsLockFNF12ShiftHoldState implements State {

    @Override
    public void hold(Keyboard keyboard, Key key) {
        // DO NOTHING
    }

    @Override
    public void unhold(Keyboard keyboard, Key key) {
        if(key.equals(Key.SHIFT)){
            keyboard.setState(new CapsLockFNHoldF12State());
        }
    }

    @Override
    public void tap(Keyboard keyboard, Key key) {
        if(key.getType() == Key.VOLUME_KEY){
            System.out.println("+volume");
        } else if(key.equals(Key.CAPS_LOCK)){
            keyboard.setState(new PlusFNShiftHoldState());
        }
    }

}
