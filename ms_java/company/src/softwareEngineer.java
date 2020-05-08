public class softwareEngineer extends technicalEmployee{
    boolean codeAccess;
    technicalLead manager;
    public softwareEngineer(String name){
        super(name);
        codeAccess = false;
        checkIns = 0;
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
        if(this.manager.approveCheckIn(this)){
            checkIns++;
            return true;
        }
        return false;
    }

    @Override
    public Employee getManager() {
        return this.manager;
    }

    //따로 set은 안하고 technical manager가 팀 멤버 받는 함수에서 얘의 매니저 같이 set






}
