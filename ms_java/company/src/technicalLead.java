import java.util.ArrayList;

public class technicalLead extends technicalEmployee{

    //technicalLead 클래스에 추가되어야하는 변수 몇 가지
    int headCount;
    accountant accountant;
    ArrayList<softwareEngineer> directReports = new ArrayList<softwareEngineer>();


    public technicalLead(String name){
        super(name);
        this.headCount = 4;
        this.baseSalary = super.baseSalary * 1.3;
    }


    public boolean hasHeadCount() {
        if(headCount>directReports.size()){
            return true;
        }

        return false;        }


    public boolean addReport(softwareEngineer s) {
        if(hasHeadCount()){
            directReports.add(s);
            s.manager = this;
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
        //accountant의 bonusbudget 확인한 후, setting e's bonus 해야..
        return true;
    }

    public String getTeamStatus(){
        int lens = directReports.size();
        String str = " ";
        if(lens == 0 ){
            return "no direct reports yet\n";
        }
        for(int i =0; i<lens; i++){
            str += directReports.get(i).employeeStatus();
        }

        if(lens!=4){
            str += " and no direct reports yet\n";
        }
        return str;
    }
}
