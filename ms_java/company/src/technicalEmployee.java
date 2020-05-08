public class technicalEmployee extends Employee{
    int checkIns;

    public technicalEmployee(String name){
        super(name, 75000);
    }

    @Override
    public String employeeStatus() {
        return this.toString()+" has "+ this.checkIns +" successful check ins\n";
    }

}