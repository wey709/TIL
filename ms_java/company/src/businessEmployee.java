public class businessEmployee extends Employee{
    double bonusBudget;
    public businessEmployee(String name){
        super(name,50000);
        bonusBudget = 0;
    }
    public double getBonusBudget(){
        return bonusBudget;
    };

    @Override
    public String employeeStatus() {
        return super.toString()+ " with a budget of "+ this.bonusBudget;
    }

}