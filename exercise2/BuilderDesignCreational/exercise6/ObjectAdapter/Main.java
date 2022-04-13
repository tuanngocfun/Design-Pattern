package exercise6.ObjectAdapter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Remind of charge your phone...");
        ClientPhone client = new ClientPhone();
        client.addTypeCharge(new Android());
        client.addTypeCharge(new LightingObjectAdapter(new IPhone()));
        client.addTypeCharge(new LightingObjectAdapter(new Huewei()));

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
class LightingObjectAdapter implements MicroUSB{
    private final Lighting adaptee;

    public LightingObjectAdapter(Lighting adaptee){
        super();
        this.adaptee = adaptee;
    }
    @Override public void useMicroUSB(){
        if (adaptee instanceof IPhone) {
            System.out.println("IPhone is used of micro usb for charging"); 
        } else if (adaptee instanceof Huewei) {
            System.out.println("Huewei is used of micro usb for charging"); 
        } else {
            System.out.println("Invalid type of phone...");
        }
    }
    @Override public void recharge(){
        if (adaptee instanceof IPhone) {
            System.out.println("IPhone is used of micro usb for recharging"); 
        } else if (adaptee instanceof Huewei) {
            System.out.println("Huewei is used of micro usb for recharging"); 
        } else {
            System.out.println("Invalid type of phone->recharge incompatible type port...");
        }
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