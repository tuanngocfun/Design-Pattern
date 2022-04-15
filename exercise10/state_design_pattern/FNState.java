package state_design_pattern;

public class FNState implements State{

    @Override
    public void hold(Keyboard keyboard, Key key) {
        if(key.equals(Key.F11)){
            keyboard.setState(new F11State());
        } else if(key.equals(Key.F12)){
            keyboard.setState(new F12State());
        }
    }

    @Override
    public void unhold(Keyboard keyboard, Key key) {
        // DO NOTHING
    }

    @Override
    public void tap(Keyboard keyboard, Key key) {
        if(key.equals(Key.F11)){
            System.out.println("-volume");
        } else if(key.equals(Key.F12)){
            System.out.println("+volume");
        } 
    }
    
}
