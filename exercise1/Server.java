public class Server {
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