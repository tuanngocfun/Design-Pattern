package state_design_pattern;

public enum Key {
    Q(Key.LETTER_KEY),
    CAPS_LOCK(Key.CONTROL_KEY),
    SHIFT(Key.CONTROL_KEY),
    FN(Key.CONTROL_KEY),
    F11(Key.VOLUME_KEY),
    F12(Key.VOLUME_KEY)
    ;     

    public static final int LETTER_KEY = 1;
    public static final int CONTROL_KEY = 2;
    public static final int VOLUME_KEY = 3;
    public static final int LUMOSITY_KEY = 4;

    private final int type;

    private Key(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }
}
