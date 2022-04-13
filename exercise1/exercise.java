public class exercise {
    public static void main(String[] args) {
        PrinterFactory printerFactory = new PrinterFactory();

        Printer printer1 = printerFactory.createPrinter("Printer1");
        printer1.print();

        Printer printer2 = printerFactory.createPrinter("Printer2");
        printer2.print();

        Printer printer3 = printerFactory.createPrinter("Printer3");
        printer3.print();

        Printer printer4 = printerFactory.createPrinter("Printer4");
        printer4.print();

        Printer printer5 = printerFactory.createPrinter("Printer5");
        printer5.print();
    }
}
interface Printer {
    void print();
}
class Printer1 implements Printer {
    @Override public void print() {
        System.out.println("Hello world, you are using printer 1");
    }
}
class Printer2 implements Printer {
    @Override public void print() {
        System.out.println("Hello world, you are using printer 2");
    }
}
class Printer3 implements Printer {
    @Override public void print() {
        System.out.println("Hello world, you are using printer 3");
    }
}
class Printer4 implements Printer {
    @Override public void print() {
        System.out.println("Hello world, you are using printer 4");
    }
}
class Printer5 implements Printer {
    @Override public void print() {
        System.out.println("Hello world, you are using printer 5");
    }
}
class PrinterFactory {
    public Printer createPrinter(String whichPrinter) {
        if(whichPrinter == null) {
            return null;
        }
        if(whichPrinter.equalsIgnoreCase("Printer1")) {
            return new Printer1();
        } else if(whichPrinter.equalsIgnoreCase("Printer2")) {
            return new Printer2();
        } else if(whichPrinter.equalsIgnoreCase("Printer3")) {
            return new Printer3();
        } else if(whichPrinter.equalsIgnoreCase("Printer4")) {
            return new Printer4();
        } else if(whichPrinter.equalsIgnoreCase("Printer5")) {
            return new Printer5();
        }
        return null;
    }
}