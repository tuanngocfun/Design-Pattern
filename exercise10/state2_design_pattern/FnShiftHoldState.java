package state2_design_pattern;

public class FnShiftHoldState implements State{
    @Override public void hold(Keyboard keyboard, Key key){
        // DO NOTHING
    }
    @Override public void unhold(Keyboard keyboard, Key key){
        if(key.equals(Key.SHIFT)){
            keyboard.setState(new FnHoldState());
        } else if(key.equals(Key.FN)){
            keyboard.setState(new ShiftHoldState());
        }
    }
    @Override public void tap(Keyboard keyboard, Key key){
        if(key.getType() == Key.LETTER_KEY){
            System.out.println(key.toString().toUpperCase());
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
            keyboard.setState(new CapsLockFnShiftHoldState());
        } else {
            System.out.println();
        }
    }
}
