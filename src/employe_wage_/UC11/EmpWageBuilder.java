package employe_wage_.UC11;

public class EmpWageBuilder implements IEmpWageBuilder{
    private static final int FULL_TIME = 1;
    private static final int PART_TIME = 2;

    private final CompanyEmpWage[] companyEmpWages;

    public EmpWageBuilder(int numOfCompanies) {
        companyEmpWages = new CompanyEmpWage[numOfCompanies];
    }

    private int checkAttendance() {
        return (int) Math.floor(Math.random() * 10) % 3;
    }

    private int calculateDailyWage(int empType, int wagePerHour) {
        int empHours = 0;
        switch (empType) {
            case FULL_TIME:
                empHours = 8;
                break;
            case PART_TIME:
                empHours = 4;
                break;
        }
        return empHours * wagePerHour;
    }

    private void calculateMonthlyWage(CompanyEmpWage company) {
        int totalWage = 0;
        for (int day = 1; day <= company.getWorkingDays(); day++) {
            int empType = checkAttendance();
            totalWage += calculateDailyWage(empType, company.getWagePerHour());
        }
        company.setTotalWage(totalWage);
    }

    private void calculateWagesWithCondition(CompanyEmpWage company) {
        int totalWage = 0;
        int totalEmpHours = 0;
        int totalWorkingDays = 0;

        while (totalEmpHours < company.getWorkingHours() && totalWorkingDays < company.getWorkingDays()) {
            int empType = checkAttendance();
            int empHours = 0;
            switch (empType) {
                case FULL_TIME:
                    empHours = 8;
                    break;
                case PART_TIME:
                    empHours = 4;
                    break;
            }
            totalEmpHours += empHours;
            totalWage += empHours * company.getWagePerHour();
            totalWorkingDays++;
        }
        company.setTotalWage(totalWage);
    }

    @Override
    public void addCompany(String companyName, int wagePerHour, int workingDays, int workingHours) {
        for (int i = 0; i < companyEmpWages.length; i++) {
            if (companyEmpWages[i] == null) {
                companyEmpWages[i] = new CompanyEmpWage(companyName, wagePerHour, workingDays, workingHours);
                break;
            }
        }
    }

    @Override
    public void computeEmployeeWage() {
        for (CompanyEmpWage company : companyEmpWages) {
            if (company != null) {
                calculateMonthlyWage(company);
                System.out.println("Total Employee Wage for " + company.getCompanyName() + ": " + company.getTotalWage());
            }
        }
    }

    @Override
    public void computeEmployeeWageForCompany() {
        for (CompanyEmpWage company : companyEmpWages) {
            if (company != null) {
                calculateWagesWithCondition(company);
                System.out.println("Total Employee Wage for " + company.getCompanyName() + ": " + company.getTotalWage());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        IEmpWageBuilder empWageBuilder = new EmpWageBuilder(2);

        empWageBuilder.addCompany("Company1", 22, 25, 120);
        empWageBuilder.addCompany("Company2", 25, 23, 100);

        empWageBuilder.computeEmployeeWage();
        empWageBuilder.computeEmployeeWageForCompany();
    }
}
