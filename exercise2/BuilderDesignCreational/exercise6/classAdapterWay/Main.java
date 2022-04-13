package exercise6.classAdapterWay;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Remind of charge your phone...");
        ClientPhone client = new ClientPhone();
        client.addTypeCharge(new Android());
        client.addTypeCharge(new IPhoneAdapter());
        client.addTypeCharge(new HueweiAdapter());

        System.out.println("Using micro usb...");
        client.useMicroUSB();
        System.out.println("Recharging...");
        client.recharge();
    }
}
interface MicroUSB{ // target
    void useMicroUSB();
    void recharge();
}
class Android implements MicroUSB {
    @Override public void useMicroUSB(){
        System.out.println("MicroUSB of Android...");
    }
    @Override public void recharge(){
        System.out.println("Android recharging...");
    }
}
interface Lighting{ // adaptee
    void useLighting();
    void recharge();
}
class IPhone implements Lighting{
    @Override public void useLighting(){
        System.out.println("You are using lighting on IPhone...");
    }
    @Override public void recharge(){
        System.out.println("Lighting recharged on IPhone...");
    }
}
class Huewei implements Lighting{

    @Override public void useLighting(){
        System.out.println("You are using lighting on Huewei...");
    }
    @Override public void recharge(){
        System.out.println("Lighting recharged on Huewei...");
    }
}

class IPhoneAdapter extends IPhone implements MicroUSB {
    public IPhoneAdapter(){
        super();
    }
    @Override public void useMicroUSB(){
        System.out.println("Here you can charge your iphone with micro usb...");
    }
    @Override public void recharge(){
        System.out.println("Now you use micro usb to recharge your iphone...");
    }
}
class HueweiAdapter extends IPhone implements MicroUSB {
    public HueweiAdapter(){
        super();
    }
    @Override public void useMicroUSB(){
        System.out.println("Here you can charge your huewei with micro usb...");
    }
    @Override public void recharge(){
        System.out.println("Now you use micro usb to recharge your iphone...");
    }
}
class ClientPhone {
    List<MicroUSB> microUSBs = new ArrayList<>();

    public ClientPhone(){
        super();
    }

    public void addTypeCharge(MicroUSB microusb){
        microUSBs.add(microusb);
    }
    public void useMicroUSB(){
        if (microUSBs.isEmpty()) {
            System.out.println("You have not charged your phone!");
        } else {
            microUSBs.stream().forEach(microusb -> microusb.useMicroUSB());
        }
    }
    public void recharge(){
        if (microUSBs.isEmpty()) {
            System.out.println("You have not recharged your phone!!");
        } else {
            microUSBs.stream().forEach(microusb -> microusb.recharge());
        }
    }
}