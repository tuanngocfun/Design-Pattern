public class Exercise {
    public static void main(String[] args) {
        Function.tap(Key.Q);
    }
}
enum Key {
    Q,CapsLock
}
class Function {
    static int cnt = 0;
    public static void tap(Key key){
        if(key.compareTo(Key.Q)!=0){
            return;
        } else if(key.compareTo(Key.CapsLock)!=0){
            if(cnt%3==0){
                System.out.println("Q".toUpperCase());
            } else {
                System.out.println("Q".toUpperCase());
            }
            cnt++;
        } else {
            if(cnt%3==0){
                System.out.println("Q".toUpperCase());
            } else {
                System.out.println("Q".toLowerCase());
            }
            cnt++;
        }
    }
}
