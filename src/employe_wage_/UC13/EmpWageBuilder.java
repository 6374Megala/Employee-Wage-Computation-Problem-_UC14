package employe_wage_.UC13;

import employe_wage_.UC12.IEmpWageBuilder;

import java.util.ArrayList;
import java.util.List;

public class EmpWageBuilder implements IEmpWageBuilder {
    private static final int FULL_TIME = 1;
    private static final int PART_TIME = 2;

    private final List<CompanyEmpWage> companyEmpWages;

    public EmpWageBuilder() {
        companyEmpWages = new ArrayList<>();
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
            int dailyWage = calculateDailyWage(empType, company.getWagePerHour());
            totalWage += dailyWage;
            company.addDailyWage(dailyWage);
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
            int dailyWage = empHours * company.getWagePerHour();
            totalEmpHours += empHours;
            totalWage += dailyWage;
            company.addDailyWage(dailyWage);
            totalWorkingDays++;
        }
        company.setTotalWage(totalWage);
    }

    @Override
    public void addCompany(String companyName, int wagePerHour, int workingDays, int workingHours) {
        companyEmpWages.add(new CompanyEmpWage(companyName, wagePerHour, workingDays, workingHours));
    }

    @Override
    public void computeEmployeeWage() {
        for (CompanyEmpWage company : companyEmpWages) {
            calculateMonthlyWage(company);
            System.out.println("Total Employee Wage for " + company.getCompanyName() + ": " + company.getTotalWage());
            System.out.println("Daily Wages for " + company.getCompanyName() + ": " + company.getDailyWages());
        }
    }

    @Override
    public void computeEmployeeWageForCompany() {
        for (CompanyEmpWage company : companyEmpWages) {
            calculateWagesWithCondition(company);
            System.out.println("Total Employee Wage for " + company.getCompanyName() + ": " + company.getTotalWage());
            System.out.println("Daily Wages for " + company.getCompanyName() + ": " + company.getDailyWages());
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        IEmpWageBuilder empWageBuilder = new EmpWageBuilder();


        empWageBuilder.addCompany("Company1", 22, 25, 120);
        empWageBuilder.addCompany("Company2", 25, 23, 100);

        empWageBuilder.computeEmployeeWage();
        empWageBuilder.computeEmployeeWageForCompany();
    }

}
