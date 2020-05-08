
public class Employee {
    private static int id=0;

    public String name;
    public double baseSalary;
    public double bonus;
    public int employeeId;
    public Employee manager;
    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        id++;
        this.employeeId = id;
    }
    public double getBaseSalary(){
        return this.baseSalary;
    }

    public String getName(){
        return this.name;
    }

    public int getEmployeeID(){
        return this.employeeId;
    }

    /*public void setManager(Employee mng){
        this.manager = mng;
    } */

    public Employee getManager(){
        return this.manager;
    }

    public String employeeStatus(){
        String str = "";
        return str;
    }

    public boolean equals(Employee other){
        if(this.getEmployeeID() == other.getEmployeeID()){
            return true;
        }
        return false;
    }

    public String toString(){
        String str = this.employeeId +" "+ this.name +" ";
        return str;
    }

}
