package exercise7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employee {
    private String name;
    private List<Employee> supervisor = new ArrayList<Employee>();

    public Employee(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public List<Employee> getEmployees(){
        return supervisor;
    }
    public void setEmployees(List<Employee> supervisee){
        this.supervisor = supervisee;
    }
    public void addEmployee(Employee e){
        supervisor.add(e);
    }
    public void remove(Employee e){
        supervisor.remove(e);
    }
    @Override public String toString(){
        String employeeName = name+"\n";
        Iterator  itr = supervisor.iterator();
        while(itr.hasNext()){
            Object element = itr.next();
            employeeName = employeeName+element.toString();
        }
        return employeeName;
    }
}
