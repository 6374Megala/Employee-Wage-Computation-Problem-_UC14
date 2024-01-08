package employe_wage_;

public class Employee_Wage_UC7 {
    final static int full_emp=2;
    final static int part_time=1;
    private final String company;
    private final int empRate;
    private final int noofDays;
    private final int maxHrs;

    public Employee_Wage_UC7(String company, int empRate, int noofDays, int maxHrs) {
        this.company = company;
        this.empRate = empRate;
        this.noofDays = noofDays;
        this.maxHrs = maxHrs;
    }
    public static void main(String[] args) {
        Employee_Wage_UC7 dmart=new Employee_Wage_UC7("Dmart",20,20,100);

        int total_emp_hours=0;
        int total_working_days=0;
        int emp_hrs=0;
        while(total_emp_hours<=dmart.maxHrs && total_working_days<dmart.noofDays) {
            total_working_days++;
            int emp_check = (int) Math.floor(Math.random() * 10) % 3;

            switch (emp_check) {
                case full_emp:
                    emp_hrs = 8;
                    break;
                case part_time:
                    emp_hrs = 4;
                    break;
                default:
                    emp_hrs = 0;


            }
            total_emp_hours += emp_hrs;
            System.out.println("Days  #: " + total_working_days + " Employee hours : " + emp_hrs);
        }
            int total_wage=total_emp_hours*dmart.empRate;

            System.out.println(" total emp wage for company : "+dmart.company+" is "+total_wage);


    }

}
