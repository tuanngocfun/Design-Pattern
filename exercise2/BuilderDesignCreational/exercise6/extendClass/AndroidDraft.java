package exercise6.extendClass;

public class AndroidDraft {
    public static void main(String[] args) {
        Lighting lighting = new LightingToMicroUSBAdapter(new MicroUSB());
        lighting.useLighting();
    }
}
class LightingToMicroUSBAdapter extends Lighting{
    private final MicroUSB microUSB;

    public LightingToMicroUSBAdapter(MicroUSB microUSB){
        this.microUSB = microUSB;
    }

    public void useLighting(){
        System.out.println("adaptee for the lighting..");
        microUSB.useMicroUSB();
    }
    public void recharge(){
        System.out.println("Recharging...");
    }
}
class MicroToLightingAdapter extends MicroUSB{
    private final Lighting lighting;

    public MicroToLightingAdapter(Lighting lighting){
        this.lighting = lighting;
    }

    @Override public void useMicroUSB(){
        System.out.println("MicroUSB is being used...");
        lighting.useLighting();
    }
    @Override public void recharge(){
        System.out.println("Recharging...");
    }
} 
class MicroUSB{ // adaptee
    void useMicroUSB(){
        System.out.println("MicroUSB is used...");
    }
    void recharge(){
        System.out.println("recharged by micro usb...");
    }
}
class Android extends MicroUSB{
    @Override public void useMicroUSB(){
        System.out.println("MicroUSB of Android...");
    }
    @Override public void recharge(){
        System.out.println("Android recharging...");
    }
}
class Lighting{ // adaptee
    void useLighting(){
        System.out.println("You are using lighting on phone...");
    }
    void recharge(){
        System.out.println("Lighting recharged on phone...");
    }
}
class IPhone extends Lighting{
    public void useLighting(){
        System.out.println("You are using lighting on IPhone...");
    }
    public void recharge(){
        System.out.println("Lighting recharged on IPhone...");
    }
}
class Huewei extends Lighting{
    public void useLighting(){
        System.out.println("You are using lighting on Huewei...");
    }
    public void recharge(){
        System.out.println("Lighting recharged on Huewei...");
    }
}