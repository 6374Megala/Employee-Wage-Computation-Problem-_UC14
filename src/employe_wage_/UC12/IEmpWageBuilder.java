package employe_wage_.UC12;

public interface IEmpWageBuilder {
    void addCompany(String companyName, int wagePerHour, int workingDays, int workingHours);

    void computeEmployeeWage();

    void computeEmployeeWageForCompany();
}
