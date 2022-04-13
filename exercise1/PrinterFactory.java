public class PrinterFactory {
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