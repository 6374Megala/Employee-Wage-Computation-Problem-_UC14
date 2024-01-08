package employe_wage_;

public class Employee_Cases_UC4 {
    final static int full_emp=2;
    final static int part_time=1;
    public static void main(String[] args) {

        int emp=(int)Math.floor(Math.random()*10)%3;
        int emp_per_hour=20;
        int emp_hr=0;
        int emp_wage=0;
        switch(emp){
            case full_emp :  emp_hr=8;
                break;
            case part_time :emp_hr=4;
                break;
            default: emp_hr=0;
                break;

        }
        emp_wage=emp_hr*emp_per_hour;
        System.out.println("Employee wage is : "+emp_wage);
    }
}
