package employe_wage_;

public class Employee_Wage_UC8 {
    private static final int FULL_TIME = 1;
    private static final int PART_TIME = 2;
    private static int checkAttendance() {
        return (int)Math.floor(Math.random()*10)%3;
    }
    private static int calculateDailyWage(int empType, int wagePerHour) {
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
    private static int calculateMonthlyWage(int wagePerHour, int workingDays) {
        int totalWage = 0;
        for (int day = 1; day <= workingDays; day++) {
            int empType = checkAttendance();
            totalWage += calculateDailyWage(empType, wagePerHour);
        }
        return totalWage;
    }
    private static int calculateWagesWithCondition(int wagePerHour, int maxWorkingHours, int maxWorkingDays) {
        int totalWage = 0;
        int totalEmpHours = 0;
        int totalWorkingDays = 0;

        while (totalEmpHours < maxWorkingHours && totalWorkingDays < maxWorkingDays) {
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
        return totalWage;
    }

    private static int computeEmployeeWage(int wagePerHour, int workingDays) {
        return calculateMonthlyWage(wagePerHour, workingDays);
    }
    private static int computeEmployeeWageForCompany(int wagePerHour, int workingDays, int workingHours) {
        return calculateWagesWithCondition(wagePerHour, workingHours, workingDays);
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");
        int totalWage = computeEmployeeWage(20, 20);
        System.out.println("Total Employee Wage for the Month: " + totalWage);
        int totalWageCompany1 = computeEmployeeWageForCompany(22, 25, 120);
        System.out.println("Total Employee Wage for Company 1: " + totalWageCompany1);
        int totalWageCompany2 = computeEmployeeWageForCompany(25, 23, 100);
        System.out.println("Total Employee Wage for Company 2: " + totalWageCompany2);
    }
}
