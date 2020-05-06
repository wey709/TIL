import java.lang.reflect.Array;
import java.util.ArrayList;

public class company {
    public static int id=0;
    public abstract class Employee{
        public String name;
        public double baseSalary;
        public int employeeId;
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
        public abstract Employee getManager(); // 직급마다 다를 것. overriding
        public abstract Employee setManager();

        public boolean equals(Employee other){
            if(this.getEmployeeID() == other.getEmployeeID()){
                return true;
            }
            else
                return false;
        };
        public String toString(){
            String str = this.employeeId +" "+ this.name;
            return str;
        }
        public abstract String employeeStatus();
    }
    public abstract class technicalEmployee extends Employee{
        int checkIns;

        public technicalEmployee(String name){
            super(name, 75000);
            checkIns = 0;
        }

        @Override
        public String employeeStatus() {
            return this.toString()+" has "+ this.checkIns +" successful check ins";
        }
    }

    public abstract class businessEmployee extends Employee{
        int bonusBudget;
        double managedBudget;
        public businessEmployee(String name){
            super(name,50000);
            bonusBudget = 0;
            managedBudget = 0;
        }
        public abstract double getBonusBudget();

        @Override
        public String employeeStatus() {
            return this.getEmployeeID()+" "+this.getName()+" with a budget of "+ this.managedBudget;
        }
    }

    public class softwareEngineer extends technicalEmployee{
        boolean codeAccess;
        Employee manager;
        public softwareEngineer(String name){
            super(name);
            codeAccess = false;
        }
        public boolean getCodeAccess(){
            if(codeAccess == true){
                return true;
            }
            else
                return false;
        }
        public void setCodeAccess(boolean access){
            codeAccess = access;

        }
        public int getSuccessfulCheckIns(){
            return checkIns;
        }
        public boolean checkInCode(){
            technicalLead tl;
            if(tl.approveCheckIn(this))
            //매니저가 허락하면 true w/ check-in count increased
            return true;
        }

        @Override
        public Employee getManager() {
            return null;
        }

        @Override
        public Employee setManager(Employee) {
            return null;
        }
    }

    public class technicalLead extends technicalEmployee{
        //double baseSalary;
        int headCount;
        ArrayList<Integer> directReports = new ArrayList<Integer>();

        public technicalLead(String name){
            super(name);
            baseSalary = super.baseSalary*1.3;
            headCount = 4;
        }
        public boolean hasHeadCount(){
            if(headCount>directReports.size()){
                return true;
            }
            else
                return false;

        }
        public boolean addReport(softwareEngineer e){
            if(hasHeadCount()){
                directReports.add(e.employeeId);
                e.setManager()
                return true;
            }
            else
                return false;
        }
        public boolean approveCheckIn(softwareEngineer e){
            //if the employee passed in does report to this manager && code access 둘 다 true면 true
            return false;
        }

        public boolean requestBonuse(Employee e, double bonus){
            //잘 모르겠음
            return true;
        }

        public String getTeamStatus(){
            String str=" ";
            //10 kasey has 5 successful check ins and no direct reports yet 뭐 이런식으로 팀원 전원
            return str;
        }
    }
}
