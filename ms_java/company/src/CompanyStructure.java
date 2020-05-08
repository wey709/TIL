public class CompanyStructure {

    public static void main(String[] args){
        technicalLead CTO = new technicalLead("Satya Nadella");
        softwareEngineer seA = new softwareEngineer("Kasey");
        softwareEngineer seB = new softwareEngineer("Breana");
        softwareEngineer seC = new softwareEngineer("Eric");
        CTO.addReport(seA);
        CTO.addReport(seB);
        CTO.addReport(seC);
        System.out.println(CTO.getTeamStatus());

        technicalLead VPofENG = new technicalLead("Bill Gates");
        softwareEngineer seD = new softwareEngineer("Winter");
        softwareEngineer seE = new softwareEngineer("Libby");
        softwareEngineer seF = new softwareEngineer("Gizan");
        softwareEngineer seG = new softwareEngineer("Zaynah");
        VPofENG.addReport(seD);
        VPofENG.addReport(seE);
        VPofENG.addReport(seF);
        VPofENG.addReport(seG);
        System.out.println(VPofENG.getTeamStatus());

        businessLead CFO = new businessLead("Amy Hood");
        accountant actA = new accountant("Niky");
        accountant actB = new accountant("Andrew");
        CFO.addReport(actA, CTO);
        CFO.addReport(actB, VPofENG);
        System.out.println(CFO.getTeamStatus());
    }
}
