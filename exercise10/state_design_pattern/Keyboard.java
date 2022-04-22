package state_design_pattern;

public class Keyboard {
    private State state;
    private Key key;

    public Keyboard(){
        this.state = new NormalState();
        this.key = null;
    }

    public Key getHoldKey(){
        return this.key;
    }
    public void setState(State state){
        this.state = state;
    }
    // WTF
    public void hold(Key key){
        this.key = key;
        if(key == Key.FN){
            this.state = new FNState();
            state.hold(this, key);
        }
        state.hold(this, key);
    }
    public void unhold(Key key){
        if(key.equals(this.key)){
            state.unhold(this, key);
            this.key = null;
        }
    }
    public void tap(Key key){
        state.tap(this, key);
    }
}