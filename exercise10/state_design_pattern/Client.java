package state_design_pattern;
public class Client {
    public static void main(String[] args) {
        System.out.println("Keyboard");
        System.out.println("<<< -------------------------------------------------------------- >>>");
        Keyboard keyboard = new Keyboard();

        System.out.println("Tap only q:");
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Turn caps lock on");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Remain turning caps lock on and hold shift");
        keyboard.hold(Key.SHIFT);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Turn caps lock off and unhold shift");
        keyboard.unhold(Key.SHIFT);
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Holding shift");
        keyboard.hold(Key.SHIFT);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Remain holding turns caps lock on");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Remain turing caps lock on and unhold shift");
        keyboard.unhold(Key.SHIFT);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Turn caps lock off");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Holding shift");
        keyboard.hold(Key.SHIFT);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Remain holding turns caps lock on");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Remain holding shift and turn caps lock off");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");
        
        System.out.println("Holding shift");
        keyboard.hold(Key.SHIFT);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Remain holding shift and turns caps lock on");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Remain holding shift and turn caps lock off");
        keyboard.tap(Key.CAPS_LOCK);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");

        System.out.println("Unhold shift");
        keyboard.unhold(Key.SHIFT);
        keyboard.tap(Key.Q);
        System.out.println("< ---------------------------------------------------------------- >");
    }
}