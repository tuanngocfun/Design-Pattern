package state2_design_pattern;

public enum Key {
    Q(Key.LETTER_KEY), S(Key.LETTER_KEY),
    CAPS_LOCK(Key.CONTROL_KEY), SHIFT(Key.CONTROL_KEY), FN(Key.CONTROL_KEY),
    F1(Key.F_KEY), F10(Key.F_KEY), F11(Key.F_KEY), F12(Key.F_KEY); 

    public static final int LETTER_KEY = 1;
    public static final int CONTROL_KEY = LETTER_KEY << 1;
    public static final int F_KEY = CONTROL_KEY << 1;

    private final int type;

    private Key(int type){
        this.type = type;
    }
    public int getType(){
        return type;
    }
}
