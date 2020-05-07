import java.lang.reflect.Array;
import java.util.ArrayList;

public class company {
    public static int id=0;

    public class Employee{
        public String name;
        public double baseSalary;
        public int employeeId;
        public Employee manager;
        public Employee(String name, double baseSalary){
            this.name = name;
            this.baseSalary = baseSalary;
            id++;
            this.employeeId = id;
            this.manager = new Employee("mng", 0);
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

        public void setManager(Employee mng){
            this.manager = mng;
        } // 이거 없이 manager 어떻게 지정...?

        public Employee getManager(){
            return this;
          }

        public String employeeStatus(){
            String str = "";
            return str;
        }

        public boolean equals(Employee other){
            if(this.getEmployeeID() == other.getEmployeeID()){
                return true;
            }
            else
                return false;
        }

        public String toString(){
            String str = this.employeeId +" "+ this.name;
            return str;
        }
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

        @Override
        public void setManager(Employee mng) {
            technicalLead tl= new technicalLead(mng.name);
            super.setManager(mng);
        }
    }

    public abstract class businessEmployee extends Employee{
        double managedBudget;
        public businessEmployee(String name){
            super(name,50000);
            managedBudget = 0;
        }
        public abstract double getBonusBudget();

        @Override
        public String employeeStatus() {
            return this.getEmployeeID()+" "+this.getName()+" with a budget of "+ this.managedBudget;
        }

        @Override
        public void setManager(Employee mng) {
            businessLead b= new businessLead(mng.name);
            super.setManager(mng);
        }
    }

    public class softwareEngineer extends technicalEmployee{
        boolean codeAccess;
        technicalLead manager;
        public softwareEngineer(String name){
            super(name);
            codeAccess = false;
        }
        public boolean getCodeAccess(){
            if(codeAccess){
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
            if(this.manager.approveCheckIn(this))
            //매니저가 허락하면 true w/ check-in count increased
            {return true;}
        }

        @Override
        public technicalLead getManager() {
            return this.manager;
        }

    }

    public class accountant extends businessEmployee{
        double bonusBudget; //약간 인센티브 같은 느낌?
        double managedBudget = super.managedBudget + bonusBudget;

        technicalLead tl = null; //실험적으로 써본 것

        public accountant(String name){
            super(name);
        }
        public technicalLead getTeamSupported(){
            return tl;
        }

        public void supportTeam(technicalLead tl){
            //팀 설정...
            int teamSize = tl.directReports.size();
            bonusBudget = teamSize*75000 + teamSize*7500;
        }

        public boolean approveBonus(double bonus){
            //remaining budget < bonus면 false
            if(bonusBudget>bonus){
                return true;
            }
            return false;
        }

        @Override
        public String employeeStatus() {
            return super.employeeStatus() + " is supporting " + tl;
        }

        @Override
        public double getBonusBudget() {
            return bonusBudget;
        }
    }



    public class technicalLead extends technicalEmployee{
        int headCount;
        ArrayList<Integer> directReports = new ArrayList<Integer>();


        public technicalLead(String name){
            super(name);
            this.headCount = 4;
        }

        @Override
        public boolean hasHeadCount() {
            if(headCount>directReports.size()){
                return true;
            }

            return false;        }


        @Override
        public boolean addReport(Employee e) {
            softwareEngineer s = new softwareEngineer(e.name);
            if(hasHeadCount()){
                directReports.add(s.employeeId);
                s.setManager(this);
                return true;
            }
            return false;
        }

        public boolean approveCheckIn(softwareEngineer e){
            if (e.getManager() == this && e.codeAccess ==true){
                return true;
            }
            return false;
        }

        public boolean requestBonus(Employee e, double bonus){
            //잘 모르겠음
            return true;
        }

        public String getTeamStatus(){
            String str=" ";
            //10 kasey has 5 successful check ins and no direct reports yet 뭐 이런식으로 팀원 전원
            return str;
        }
    }

    public class businessLead extends businessEmployee{
        int headCount;
        ArrayList<Integer> directReports = new ArrayList<Integer>();


        public businessLead(String name){
            super(name);
            this.baseSalary = 50000 * 2;
            this.headCount = 10;
        }


        public boolean addReport(accountant a) {
            if(hasHeadCount()){
                directReports.add(a.employeeId);
                a.setManager(this);
                return true;
            }
            return false;
        }

        @Override
        public double getBonusBudget() {
            return 0;
        }

        @Override
        public boolean hasHeadCount() {
            if(headCount>directReports.size()){
                return true;
            }

            return false;        }


        @Override
        public boolean addReport(Employee e) {
            accountant a = new accountant(e.name);
            if(hasHeadCount()){
                directReports.add(a.employeeId);
                a.setManager(this);
                return true;
            }
            return false;
        }
    }
}
