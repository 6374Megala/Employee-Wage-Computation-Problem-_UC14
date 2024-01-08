package employe_wage_;

public class Employee_Present_UC1 {
    public static void main(String[] args) {
        int is_full_emp=1;
        double emp=Math.floor(Math.random()*10)%2;
        if(emp==is_full_emp){
            System.out.println("Employee is present");
        }
        else{
            System.out.println("Employee is abscent");
        }
    }
}
