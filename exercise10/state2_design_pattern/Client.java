package state2_design_pattern;

public class Client {
    public static void main(String[] args) {
        Keyboard keyboard = new Keyboard();
        Speaker speaker = new Speaker();
        Monitor monitor = new Monitor();
        keyboard.setSpeaker(speaker);
        keyboard.setMonitor(monitor);

        System.out.println("<<< ----------------------------------------------------------------- >>>");
        System.out.println("Keyboard");

        System.out.print("Tap Q"); System.out.print(": ");
        keyboard.tap(Key.Q); 
        System.out.println();

        System.out.println("<<< ----------------------------------------------------------------- >>>");
        System.out.println("Turn caps lock on");
        keyboard.tap(Key.CAPS_LOCK);
        System.out.print("Tap Q");System.out.print(": ");
        keyboard.tap(Key.Q); 
        System.out.println();

        System.out.println("<<< ----------------------------------------------------------------- >>>");
        System.out.println("Hold shift");
        keyboard.hold(Key.SHIFT);
        System.out.print("Tap Q");System.out.print(": ");
        keyboard.tap(Key.Q); 
        System.out.println();

        System.out.println("<<< ----------------------------------------------------------------- >>>");
        System.out.println("turn caps lock off");
        keyboard.tap(Key.CAPS_LOCK);
        System.out.print("Tap Q");System.out.print(": ");
        keyboard.tap(Key.Q); 
        System.out.println();

        System.out.println("<<< ----------------------------------------------------------------- >>>");
        System.out.println("Unhold shift");
        keyboard.unhold(Key.SHIFT);
        System.out.print("Tap Q");System.out.print(": ");
        keyboard.tap(Key.Q); 
        System.out.println();

        System.out.println("<<< ----------------------------------------------------------------- >>>");
        System.out.println("Turn caps lock on");
        keyboard.tap(Key.CAPS_LOCK);
        System.out.println("Hold FN");
        keyboard.hold(Key.FN);
        System.out.println("Hold shift");
        keyboard.hold(Key.SHIFT);
        System.out.print("Tap F11"); System.out.print(": ");
        keyboard.tap(Key.F11);
        System.out.println();

        System.out.println("<<< ----------------------------------------------------------------- >>>");
        System.out.println("Unhold FN");
        keyboard.unhold(Key.FN);
        System.out.print("Tap F12");System.out.print(": ");
        keyboard.tap(Key.F12);
        System.out.println();

        System.out.println("<<< ----------------------------------------------------------------- >>>");
        System.out.println("Hold FN");
        keyboard.hold(Key.FN);
        System.out.println("Unhold shift");
        keyboard.unhold(Key.SHIFT);
        System.out.print("Tap F11");System.out.print(": ");
        keyboard.tap(Key.F11);
        System.out.println();

        System.out.println("<<< ----------------------------------------------------------------- >>>");
        System.out.println("Turn caps lock off");
        keyboard.tap(Key.CAPS_LOCK);
        System.out.print("Tap F12");System.out.print(": ");
        keyboard.tap(Key.F12);
        System.out.println();

        System.out.println("<<< ----------------------------------------------------------------- >>>");
        System.out.println("Unhold FN");
        keyboard.unhold(Key.FN);
        System.out.print("Tap F11");System.out.print(": ");
        keyboard.tap(Key.F11); 
        System.out.println();

        System.out.println("<<< ----------------------------------------------------------------- >>>");
        System.out.println("Hold FN");
        keyboard.hold(Key.FN);
        System.out.print("Tap F1");System.out.print(": ");
        keyboard.tap(Key.F1); 
        System.out.println();

        System.out.println("<<< ----------------------------------------------------------------- >>>");
        System.out.print("Tap F1");System.out.print(": ");
        keyboard.tap(Key.F1); 
        System.out.println();

        System.out.println("<<< ----------------------------------------------------------------- >>>");
        System.out.println("Hold shift");
        keyboard.hold(Key.SHIFT);
        System.out.println("Unhold FN");
        keyboard.unhold(Key.FN);
        System.out.print("Tap F1"); System.out.print(": ");
        keyboard.tap(Key.F1);
        System.out.println();
    }
}
