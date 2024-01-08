package employe_wage_.UC11;

public interface IEmpWageBuilder {
    void addCompany(String companyName, int wagePerHour, int workingDays, int workingHours);

    void computeEmployeeWage();

    void computeEmployeeWageForCompany();
}
