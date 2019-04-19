import java.util.ArrayList;

/**
 * Class of job seeker object
 * 
 * @auther (Yiming, Moon, Troy, Bryan)
 */
public class JobSeeker extends User 
{
    private ArrayList<String> notification;
    private ArrayList<String> skillsets;
    
    public JobSeeker()
    {
        notification = new ArrayList<String>();
        skillsets = new ArrayList<String>();
    }
    
    public JobSeeker(ArrayList<String> skillsets)
    {
        notification = new ArrayList<String>();
        this.skillsets = skillsets;
    }

    /**
     * notification getter
     * 
     * @return notification
     */
    public ArrayList<String> getNotification() {
        return notification;
    }

    /**
     * notification setter
     * 
     * @param notification arraylist of notifications
     */
    public void setNotification(ArrayList<String> notification) {
        this.notification = notification;
    }
    
    /**
     * Add a notification to notification list
     * 
     * @param invitation invitation information
     */
    public void addNotification(String invitation){
        this.notification.add(invitation);
    }
    
    /**
     * Skillsets getter
     * 
     * @return all the skillsets
     */
    public ArrayList<String> getSkillsets() {
        return skillsets;
    }

    /**
     * skillsets setter
     * 
     * @param skillsets all the skillsets
     */
    public void setSkillsets(ArrayList<String> skillsets) {
        this.skillsets = skillsets;
    }
    
    /**
     * Add a new skill to skillsets list
     * 
     * @param newSkill name of new skill
     */
    public void addSkill(String newSkill)
    {
        this.skillsets.add(newSkill);
    }
    
    /**
     * Display all the information of job seeker
     */
    public void displayJobSeeker() {
       System.out.println("Username: " + getUserName());
        System.out.println("Name: " + getName());
       System.out.println("Email: " + getEmail());
       System.out.println("Gender: " + getGender());
       System.out.print("Skillsets: ");
       for(String skill : getSkillsets())
       {
           System.out.print(skill + "\t");
        }
        System.out.print("\n");
    }
}
