import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to set all the validation during the program
 * 
 * @auther (Yiming, Moon, Troy, Bryan)
 */
public class Validation 
{
    /**
     * Check if number is positiva
     * 
     * @param salary job salary
     * @return true if salary is positive, false if negative
     */
    public boolean checkPositive(int salary)
    {
        boolean value = true;
        if(salary > 0)
        {
            value = true;
        }
        else
        {
            System.out.println("\n\t\t!!ERROR: Invalid Input. Salary should be positive number");
            value = false;
        }
        return value;
    }
    
    /**
     * Check if input is not blank
     * 
     * @param word input word
     * @return true if input is not blank, false if input is blank
     */
    public boolean checkNoBlank(String word)
    {
        boolean value = true;

        if (word.length() > 0)
            value = true;
        else 
            if (word.length() == 0)
        {
               System.out.println();
               System.out.println("\t\t!!ERROR : Invalid Input. Please do not enter a blank space");
               System.out.println();
               value = false;
        }
        
        return value;
    }
    
    /**
     * Check if input is number
     * 
     * @param input anything input
     * @return true if input is integer, false if input is not integer
     */
    public boolean integerMenuValidation(String input)
    {
        Scanner parser = new Scanner(input);
        boolean value = false;
        
        if (parser.hasNextInt())
            value = true;
        else
        {
            System.out.println();
            System.out.println("\t\t!!ERROR : Invalid Input.Please enter a valid number");
            System.out.println();
            value = false;
        }    
        
        return value;
    }
    
    /**
     * Check if input is in valid interval
     * 
     * @param input anything input
     * @param min minimum number allowed
     * @param max maximum number allowed
     * @return true if input number is in interval, false if input is not allowed
     */
     public boolean integerValidation(String input, int min, int max)
     {
            Scanner console = new Scanner(input);
            boolean value = false;
            int numberToCheck;
            
            if (console.hasNextInt())
            {
                numberToCheck = Integer.parseInt(input);
                if (numberToCheck <= max && numberToCheck > 0)
                    value = true;
                else
                {
                    System.out.println();
                    System.out.println("\t\t!!ERROR : Invalid Input.Please enter a valid number (" + min + "-" + max +")");
                    System.out.println();
                    value = false;
                }
            }        
            else
            {
                System.out.println();
                System.out.println("\t\t!!ERROR : Invalid Input.Please enter a valid number (" + min + "-" + max +")");
                System.out.println();
                value = false;
            }   
            
            return value;
        }

    /**
     * Check input is answer of (y/n)
     * 
     * @param input anything input
     * @return true if input is y or n, false if else
     */
     public boolean checkYNanswer(String input)
     {
         Scanner console = new Scanner(input);
         boolean value = false;
         
         if(input.equals("y"))
             value = true;
         
         else
             if(input.equals("n"))
                 value = true;
         
         else
         {
            System.out.println();
            System.out.println("\t\t!!ERROR : Invalid Input.Please enter a right answer (y/n)");
            System.out.println();
            value = false;
          }   
         
         return value;
     }
     
     /**
      * Check gender answer is male or female
      * 
      * @param input anything input
      * @return true if input is male or female, false if else
      */
     public boolean checkGenderAnswer(String input)
     {
         Scanner console = new Scanner(input);
         boolean value = false;
         
         if(input.equals("male"))
             value = true;
         
         else
             if(input.equals("female"))
                 value = true;
         
         else
         {
            System.out.println();
            System.out.println("\t\t!!ERROR : Invalid Input.Please enter a right answer (male/female)");
            System.out.println();
            value = false;
          }   
         
         return value;
       }
     
    /**
     * Check if username is exist in the list
     * 
     * @param username username of user
     * @param userList list of all users' usernames
     * @return true if username existing, false if username not existing
     */
    public boolean checkUserNameExistance(String username, ArrayList<User> userList)
    {
        boolean result = false;
        for (User person : userList)
        {
            String personUserName = person.getUserName();
            
            if(username.equals(personUserName))
            {
                result = true;
                break;
            }   
        }
        return result;
    }
    
    /**
     * Check if password is right
     * 
     * @param username username
     * @param password password
     * @param userList
     * @return true if username and password is the same as records in the list of users, false if else
     */
    public boolean checkUserPassword(String username, String password, ArrayList<User> userList)
    {
        boolean result = false;
        for (User person : userList)
        {
            if (person.getUserName().equals(username))
            {
                String personUserPassword = person.getPassword();
            
                if(password.equals(personUserPassword))
                {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
    
    /**
     * Check if skill exist in the list
     * 
     * @param skill skill
     * @param skillsets list of skills
     * @return true if skill exsits, false if else
     */
    public boolean checkNoSkill(String skill, ArrayList<String> skillsets)
    {
        boolean valid = true;
        for (String skills : skillsets)
        {
            if(skills.equals(skill))
            {
                valid = false;
                System.out.println("\n\t\t!!ERROR : " + skill + " is already entered");
                System.out.println("\t\t  >o Please insert another skill or exit ");
                break;
               }
           }
           return valid;
       }
    
    
    
}
