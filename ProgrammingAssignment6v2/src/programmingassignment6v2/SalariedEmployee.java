/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingassignment6v2;

/**
 *
 * @author bent3
 */
public class SalariedEmployee extends Employee {
   private double weeklySalary;

   // constructor
   public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthdate, double weeklySalary) {
      super(firstName, lastName, socialSecurityNumber, birthdate); 

      if (weeklySalary < 0.0) {
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");
      }

      this.weeklySalary = weeklySalary;
   } 

   // set salary
   public void setWeeklySalary(double weeklySalary) {
      if (weeklySalary < 0.0) {
         throw new IllegalArgumentException(
            "Weekly salary must be >= 0.0");
      }

      this.weeklySalary = weeklySalary;
   } 

   // return salary
   public double getWeeklySalary() {return weeklySalary;}
   
   public int getBirthMonth() {
       Date employeeBirthDate = getBirthdate();
       
       return employeeBirthDate.getMonth();
   }

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings() {
       if(getBirthMonth() == 11){
            return getWeeklySalary() + 100;
       }
       else {
           return getWeeklySalary();
       }
   }                

   // return String representation of SalariedEmployee object  
   @Override                                                   
   public String toString() {                                  
      return String.format("salaried employee: %s%n%s: $%,.2f",
         super.toString(), "weekly salary", getWeeklySalary());
   }                                                           
}

