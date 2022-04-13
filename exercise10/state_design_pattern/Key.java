package state_design_pattern;

public enum Key {
    Q(Key.LETTER_KEY),
    CAPS_LOCK(Key.CONTROL_KEY),
    SHIFT(Key.CONTROL_KEY);     

    public static final int LETTER_KEY = 1;
    public static final int CONTROL_KEY = 2;

    private final int type;

    private Key(int type){
        this.type = type;
    }
    
    public int getType(){
        return type;
    }
}
