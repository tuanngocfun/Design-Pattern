package state_design_pattern;

public class CapsLockFNHoldF11State implements State{

    @Override
    public void hold(Keyboard keyboard, Key key) {
        if(key.equals(Key.SHIFT)){
            keyboard.setState(new CapsLockFNF11ShiftHoldState());
        }
    }

    @Override
    public void unhold(Keyboard keyboard, Key key) {
        // DO NOTHING
    }

    @Override
    public void tap(Keyboard keyboard, Key key) {
        if(key.getType() == Key.VOLUME_KEY){
            System.out.println("-luminosity");
        } else if(key.equals(Key.CAPS_LOCK)){
            keyboard.setState(new FNF11HoldState());
        }
    }

}
