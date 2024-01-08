package employe_wage_.UC14;

public interface IEmpWageBuilder {
    void addCompany(String companyName, int wagePerHour, int workingDays, int workingHours);

    void computeEmployeeWage();

    void computeEmployeeWageForCompany();

    int getTotalWageByCompany(String companyName);
}
