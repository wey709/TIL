import java.util.ArrayList;

public class businessLead extends businessEmployee{
    int headCount;
    ArrayList<accountant> directReports = new ArrayList<accountant>();
    public businessLead(String name){
        super(name);
        headCount = 10;
        baseSalary = super.baseSalary * 2;
    }

    public boolean hasHeadCount(){
        if(directReports.size()<headCount){
            return true;
        }
        return false;
    }

    public boolean addReport(accountant e, technicalLead supportTeam){
        if(hasHeadCount()){
            directReports.add(e);
            e.team = supportTeam;
            supportTeam.accountant = e;
            bonusBudget += super.baseSalary*1.1;
            return true;
        }

        return false;
    }

    public boolean requestBonus(Employee e, double bonus){
        //accountant의 보너스
        if(bonus<=bonusBudget){
            e.bonus += bonus;
            bonusBudget -= bonus;
            return true;
        }
        return false;
    }

    public boolean approveBonus(accountant a, double bonus){
        if(bonus<=a.bonusBudget){
            return true;
        }
        return false;
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

        if(lens!=10){
            str += " and no direct reports yet\n";
        }
        return str;
    }


}