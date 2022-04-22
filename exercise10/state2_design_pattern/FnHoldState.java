package state2_design_pattern;

public class FnHoldState implements State{
    @Override public void hold(Keyboard keyboard, Key key){
        if(key.equals(Key.SHIFT)){
            keyboard.setState(new FnShiftHoldState());
        }
    }
    @Override public void unhold(Keyboard keyboard, Key key){
        if(key.equals(Key.FN)){
            keyboard.setState(new NormalState());
        }
    }
    @Override public void tap(Keyboard keyboard, Key key){
        if(key.getType() == Key.LETTER_KEY){
            System.out.println(key.toString().toLowerCase());
        } else if(key.getType() == Key.F_KEY){
            switch(key){
                case F1 -> {
                    Speaker speaker = keyboard.getSpeaker();
                    if(speaker.isMuted()){
                        speaker.unmute();
                    } else {
                        speaker.mute();
                    }
                }
                case F11 -> keyboard.getMonitor().decreaseLuminosity();
                case F12 -> keyboard.getMonitor().increaseLuminosity();
                default -> {}
            }
        } else if(key.equals(Key.CAPS_LOCK)){
            keyboard.setState(new CapsLockFnHoldState());
        } else {
            System.out.println();
        }
    }
}
