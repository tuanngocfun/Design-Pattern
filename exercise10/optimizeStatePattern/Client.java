package optimizeStatePattern;

public class Client {
    public static void main(String[] args) {
        Context ctx = new Context();

        InitialState initState = new InitialState();
        initState.tap(ctx, Key.q);
    }
}

enum Key {
    Q, CapsLock, q
}

enum Hold {
    ON, OFF
}

class Context {
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }
    public State getState(){
        return state;
    }
}

interface State {
    public void tap(Context ctx, Key key);
    public void hold(Context ctx, Hold hold);
}

class InitialState implements State{
    @Override public void tap(Context ctx, Key key){
        key=Key.q;
        ctx.setState(this);
    }
    @Override public void hold(Context ctx, Hold hold){
        hold=Hold.OFF;
        ctx.setState(this);
    }
    @Override public String toString(){
        return "q";
    }
}

class CapitalState implements State{
    @Override public void tap(Context ctx, Key key){
        key = Key.Q;
        ctx.setState(this);
    }
    @Override public void hold(Context ctx, Hold hold){
        hold = Hold.ON;
        ctx.setState(this);
    }
    @Override public String toString(){
        return "Q";
    }
}

class BlankStateWithoutHolding implements State{
    @Override public void tap(Context ctx, Key key){
        key = Key.CapsLock;
        ctx.setState(this);
    }
    @Override public void hold(Context ctx, Hold hold){
        hold = Hold.OFF;
        ctx.setState(this);
    }
    @Override public String toString(){
        return "";
    }
}

class BlankStateWithHolding implements State{
    @Override public void tap(Context ctx, Key key){
        key = Key.CapsLock;
        ctx.setState(this);
    }
    @Override public void hold(Context ctx, Hold hold){
        hold = Hold.ON;
        ctx.setState(this);
    }
    @Override public String toString(){
        return "";
    }
}
