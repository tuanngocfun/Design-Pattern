package state_design_pattern;

public interface State {
    void hold(Keyboard keyboard, Key key);
    void unhold(Keyboard keyboard, Key key);
    void tap(Keyboard keyboard, Key key);
}