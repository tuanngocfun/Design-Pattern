package state2_design_pattern;

public class Speaker {
    private boolean muted;

    public Speaker(){
        muted = false;
    }

    public boolean isMuted(){
        return muted;
    }
    public void mute(){
        muted = true;
        System.out.println("Speaker muted");
    }
    public void unmute(){
        muted = false;
        System.out.println("Speaker unmuted");
    }
    public void increaseVolume(){
        System.out.println("Volume is increasing...");
    }
    public void decreaseVolume(){
        System.out.println("Volume is decreasing...");
    }
}
