package state2_design_pattern;

import java.util.EnumSet;
import java.util.Set;

public class Keyboard {
    private final Set<Key> holdKeys = EnumSet.allOf(Key.class);
    private State state = new NormalState();
    private Speaker speaker;
    private Monitor monitor;

    public Keyboard(){
        speaker = null;
        monitor = null;
    }
    public Keyboard(Speaker speaker, Monitor monitor){
        this.speaker = speaker;
        this.monitor = monitor;
    }

    public void setSpeaker(Speaker speaker){
        this.speaker = speaker;
    }
    public Speaker getSpeaker(){
        return speaker;
    }
    public void setMonitor(Monitor monitor){
        this.monitor = monitor;
    }
    public Monitor getMonitor(){
        return monitor;
    }
    public void setState(State state){
        this.state = state;
    }
    public void hold(Key key){
        holdKeys.add(key);
        state.hold(this, key);
    }
    public void unhold(Key key){
        if(holdKeys.contains(key)){
            holdKeys.remove(key);
            state.unhold(this, key);
        }
    }
    public void tap(Key key){
        state.tap(this, key);
    }
}
