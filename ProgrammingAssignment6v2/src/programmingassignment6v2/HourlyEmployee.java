/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingassignment6v2;

/**
 *
 * @author bent3
 */
public class HourlyEmployee extends Employee {
   private double wage; // wage per hour
   private double hours; // hours worked for week

   // constructor
   public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, Date birthdate, double wage, double hours) {
      super(firstName, lastName, socialSecurityNumber, birthdate);

      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Hourly wage must be >= 0.0");
      }

      if ((hours < 0.0) || (hours > 168.0)) { // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");
      }

      this.wage = wage;
      this.hours = hours;
   } 

   // set wage
   public void setWage(double wage) {
      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Hourly wage must be >= 0.0");
      }

      this.wage = wage;
   } 

   // return wage
   public double getWage() {return wage;}

   // set hours worked
   public void setHours(double hours) {
      if ((hours < 0.0) || (hours > 168.0)) { // validate hours
         throw new IllegalArgumentException(
            "Hours worked must be >= 0.0 and <= 168.0");
      }

      this.hours = hours;
   } 

   // return hours worked
   public double getHours() {return hours;}
   
   public int getBirthMonth() {
       Date employeeBirthDate = getBirthdate();
       
       return employeeBirthDate.getMonth();
   }

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings() { 
      if(getBirthMonth() == 11){
            if (getHours() <= 40) { // no overtime                           
                return getWage() * getHours() + 100;                                
            }                                                                
            else {                                                           
                return 40 * getWage() + (getHours() - 40) * getWage() * 1.5 + 100;  
            }
       }
       else {
           if (getHours() <= 40) { // no overtime                           
                return getWage() * getHours();                                
            }                                                                
            else {                                                           
                return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;  
            }
        }                                                            
    }                                                                   

   // return String representation of HourlyEmployee object              
   @Override                                                             
   public String toString() {                                            
      return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f", 
         super.toString(), "hourly wage", getWage(),                     
         "hours worked", getHours());                                    
   }                                                                     
} 

