package employe_wage_;

public class Employee_Daily_Wage_UC2 {
    public static void main(String[] args) {
        int is_full_emp=1;
        double emp=Math.floor(Math.random()*10)%2;
        int emp_per_hour=20;
        int emp_hr=0;
        int emp_wage=0;
        if(emp==is_full_emp){
            emp_hr=1;
        }
        else{
            emp_hr=0;
        }
        emp_wage=emp_hr*emp_per_hour;
        System.out.println("Employee wage is : "+emp_wage);
    }
}
