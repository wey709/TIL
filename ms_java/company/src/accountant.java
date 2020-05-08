public class accountant extends businessEmployee{
    technicalLead team; // 혹시 null 할당 되나?
    public accountant(String name){
        super(name);
    }

    public technicalLead getTeamSupported(){
        return team;
    }

    public void supportTeam(technicalLead lead){
        bonusBudget = team.directReports.size() * 75000 * 1.1;
    }

    public boolean approveBonus(double bonus){
        if(bonus<=bonusBudget){
            return true;
        }
        return false;
    }

    public String employeeStatus(){
        String str = super.employeeStatus() + " is supporting " + team.name + "\n";
        return str;
    }
}