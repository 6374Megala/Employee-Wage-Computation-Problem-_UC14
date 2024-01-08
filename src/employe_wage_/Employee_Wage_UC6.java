package employe_wage_;

public class Employee_Wage_UC6 {
    final static int full_emp=2;
    final static int part_time=1;
    final static int emp_rate_per_hour=20;
    final static int max_hrs_in_month=100;
    final static int number_of_working_days=20;
    public static void main(String[] args) {


        int total_wage=0;
        int total_emp_hours=0;
        int total_working_days=0;

        while(total_emp_hours<=max_hrs_in_month && total_working_days<number_of_working_days){
            total_working_days++;
            int emp_check= (int) Math.floor(Math.random() * 10) % 3;
            int emp_hrs=0;
            switch (emp_check) {
                case full_emp:
                    emp_hrs = 8;
                    break;
                case part_time:
                    emp_hrs = 4;
                    break;
                default:
                    emp_hrs = 0;
                    break;

            }
            total_emp_hours+= emp_hrs;
            int emp_wage=emp_hrs*emp_rate_per_hour;
            total_wage+=emp_wage;
            System.out.println("Total Employee hours is : "+emp_wage);
        }
        System.out.println(" total wage : "+total_wage);
    }

}
