/**
 * Class of job recruiter object
 * 
 * @auther (Yiming, Moon, Troy, Bryan)
 */
public class JobRecruiter extends User
{
    private String companyName;
    private String location;
    
    public JobRecruiter()
    {
        companyName = "";
        location = "";
    }
    
    public JobRecruiter(String companyName, String location)
    {
        this.companyName = companyName;
        this.location = location;
    }
    
    /**
     * company name getter
     * @return name of company
     */
    public String getCompanyName()
    {
        return companyName;
    }
    
    /**
     * company name setter
     * 
     * @param companyName name of company
     */
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }
    
    /**
     * location getter
     * 
     * @return location
     */
    public String getLocation()
    {
        return location;
    }
    
    /**
     * location setter
     * 
     * @param location location
     */
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    /**
     * display all the information of job recruiter
     */
    public void displayJobRecruiter(){
       System.out.println("Name: " + getName());
       System.out.println("Email: " + getEmail());
       System.out.println("Gender: " + getGender());
       System.out.println("Company name: " + getCompanyName());
       System.out.println("Location: " + getLocation());
    }
}