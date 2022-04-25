package eg.draft;
// package example.src;

// import java.util.Iterator;
// import java.util.List;

// public class Client_Computer{
//     private Keyboard keyboard = new Keyboard();
//     private Monitor monitor = new Monitor();
//     private Mouse mouse = new Mouse();

//     private Boolean belongedTo = false;

//     final ComputerPart[] parts = {keyboard, monitor, mouse};

//     public void display(){
//         System.out.println("Inside Computer class:");
//         for(ComputerPart p : parts){
//             p.display();
//         }
//     }

//     public void count(List<ComputerPart> tools){
//         Iterator<ComputerPart> it = tools.iterator();
//         while(it.hasNext()){
//             for(int i = 0; i < 3; ++i){
//                 if(parts[i]==it.next()){
//                     belongedTo = true;
//                 }
//             }
//         }
//         if(belongedTo && tools.size()>3){
//             System.out.println("There are: "+3);
//         } else if(!belongedTo){
//             System.out.println("There are :"+tools.size());
//         } 
//     }
// }