package employe_wage_;

public class EmpWageBuilder {
    private static final int FULL_TIME = 1;
    private static final int PART_TIME = 2;

    private int wagePerHour;
    private int workingDays;
    private int workingHours;
    private int totalWage;

    public EmpWageBuilder(int wagePerHour, int workingDays, int workingHours) {
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.workingHours = workingHours;
    }

    private int checkAttendance() {
        return (int) Math.floor(Math.random() * 10) % 3;
    }

    private int calculateDailyWage(int empType) {
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

    private void calculateMonthlyWage() {
        for (int day = 1; day <= workingDays; day++) {
            int empType = checkAttendance();
            totalWage += calculateDailyWage(empType);
        }
    }

    private void calculateWagesWithCondition() {
        int totalEmpHours = 0;
        int totalWorkingDays = 0;

        while (totalEmpHours < workingHours && totalWorkingDays < workingDays) {
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
            totalWage += empHours * wagePerHour;
            totalWorkingDays++;
        }
    }

    public void computeEmployeeWage() {
        calculateMonthlyWage();
        System.out.println("Total Employee Wage for the Month: " + totalWage);
    }

    public void computeEmployeeWageForCompany() {
        calculateWagesWithCondition();
        System.out.println("Total Employee Wage for Company: " + totalWage);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        EmpWageBuilder company1 = new EmpWageBuilder(22, 25, 120);
        company1.computeEmployeeWageForCompany();

        EmpWageBuilder company2 = new EmpWageBuilder(25, 23, 100);
        company2.computeEmployeeWageForCompany();
    }
}
