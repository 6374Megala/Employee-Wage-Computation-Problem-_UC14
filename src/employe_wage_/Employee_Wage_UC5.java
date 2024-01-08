package employe_wage_;

public class Employee_Wage_UC5 {
    final static int full_emp=2;
    final static int part_time=1;
    public static void main(String[] args) {


        int wrk_days=20;
        int emp_per_hour=20;
        int emp_hr=0;
        int emp_wage=0;
        int total_wage=0;
        for(int i=0;i<wrk_days;i++) {
            int emp = (int) Math.floor(Math.random() * 10) % 3;

            switch (emp) {
                case full_emp:
                    emp_hr = 8;
                    break;
                case part_time:
                    emp_hr = 4;
                    break;
                default:
                    emp_hr = 0;
                    break;

            }
            emp_wage=emp_hr*emp_per_hour;
            total_wage+=emp_wage;
            System.out.println("Employee wage is : "+emp_wage);
        }
        System.out.println(" total wage : "+total_wage);



    }

}
