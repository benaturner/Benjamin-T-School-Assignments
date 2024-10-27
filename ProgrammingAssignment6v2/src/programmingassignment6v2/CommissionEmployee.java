/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingassignment6v2;

/**
 *
 * @author bent3
 */
public class CommissionEmployee extends Employee {
   private double grossSales; // gross weekly sales
   double commissionRate; // commission percentage

   // constructor
   public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthdate, double grossSales, double commissionRate) {
      super(firstName, lastName, socialSecurityNumber, birthdate);

      if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate 
         throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");
      }

      if (grossSales < 0.0) { // validate
         throw new IllegalArgumentException("Gross sales must be >= 0.0");
      }

      this.grossSales = grossSales;
      this.commissionRate = commissionRate;
   } 

   // set gross sales amount
   public void setGrossSales(double grossSales) {
      if (grossSales < 0.0) { // validate
         throw new IllegalArgumentException("Gross sales must be >= 0.0");
      }

      this.grossSales = grossSales;
   } 

   // return gross sales amount
   public double getGrossSales() {return grossSales;}

   // set commission rate
   public void setCommissionRate(double commissionRate) {
      if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate
         throw new IllegalArgumentException(
            "Commission rate must be > 0.0 and < 1.0");
      }

      this.commissionRate = commissionRate;
   } 

   // return commission rate
   public double getCommissionRate() {return commissionRate;}
   
   public int getBirthMonth() {
       Date employeeBirthDate = getBirthdate();
       
       return employeeBirthDate.getMonth();
   }

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings() {    
       if(getBirthMonth() == 11){
            return getCommissionRate() * getGrossSales() + 100;
       }
       else {
           return getCommissionRate() * getGrossSales();
       }                   
   }                                                                   

   // return String representation of CommissionEmployee object
   @Override                                                   
   public String toString() {                                  
      return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",     
         "commission employee", super.toString(),              
         "gross sales", getGrossSales(),                       
         "commission rate", getCommissionRate());              
   } 
}

