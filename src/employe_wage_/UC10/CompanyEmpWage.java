package employe_wage_.UC10;

public class CompanyEmpWage {
    private final String companyName;
    private final int wagePerHour;
    private final int workingDays;
    private final int workingHours;
    private int totalWage;

    public CompanyEmpWage(String companyName, int wagePerHour, int workingDays, int workingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.workingHours = workingHours;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getWagePerHour() {
        return wagePerHour;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public int getTotalWage() {
        return totalWage;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }
}

