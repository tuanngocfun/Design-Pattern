package exercise7;

public class Client {
    public static void main(String[] args) {
        Employee CEO = new Employee("Elon");
        Employee CTO = new Employee("Suchai");

        Employee TechLead = new Employee("Nope");
        Employee HeadMarketer = new Employee("Gamma");

        Employee SWE = new Employee("Joma");
        Employee MLE = new Employee("Ng");

        CEO.addEmployee(TechLead);
        CEO.addEmployee(HeadMarketer);

        CTO.addEmployee(TechLead);
        CTO.addEmployee(HeadMarketer);

        TechLead.addEmployee(SWE);
        TechLead.addEmployee(MLE);

        HeadMarketer.addEmployee(SWE);
        HeadMarketer.addEmployee(MLE);

        System.out.println("hierarchy structure of the tech company:");
        System.out.println(CEO);
    }
}
