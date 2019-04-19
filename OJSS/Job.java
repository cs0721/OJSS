import java.util.ArrayList;

/**
 * Class of job object
 * 
 * @auther (Yiming, Moon, Troy, Bryan)
 */
public class Job
{
    private String jobRecruiterUsername;
    private String title;
    private String description;
    private int salary;
    private String location;
    private ArrayList<String> category;
    private ArrayList<String> skillsets;
    private ArrayList<String> jobSeekerUsername;
    
    public Job()
    {
       jobRecruiterUsername = "";
       title = "";
       description = "";
       salary = 0;
       location = "";
       category = new ArrayList<String>();
       skillsets = new ArrayList<String>();
       jobSeekerUsername = new ArrayList<String>();
    }
    
    public Job(String jobRecruiterUsername, String title, String description, int salary, String location, ArrayList<String> category, ArrayList<String> skillsets)
    {
        this.jobRecruiterUsername = jobRecruiterUsername;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.location = location;
        this.category = category;
        this.skillsets = skillsets;
        jobSeekerUsername = new ArrayList<String>();
    }
    
     public Job(String jobRecruiterUsername, String title, String description, int salary, String location, ArrayList<String> category, ArrayList<String> skillsets, ArrayList<String> jobSeekerUsername)
    {
        this.jobRecruiterUsername = jobRecruiterUsername;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.location = location;
        this.category = category;
        this.skillsets = skillsets;
        this.jobSeekerUsername = jobSeekerUsername;
    }
    
    /**
     * job recruiter username getter
     * 
     * @return username of job recruiter
     */
    public String getJobRecruiterUsername()
    {
        return jobRecruiterUsername;
    }
    
    /**
     * job recruiter username setter
     * 
     * @param jobRecruiterUsername username of job recruiter
     */
    public void setJobRecruiterUsername(String jobRecruiterUsername)
    {
        this.jobRecruiterUsername = jobRecruiterUsername;
    }
    
    /**
     * job title getter
     * 
     * @return job title
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * job title setter
     * 
     * @param title job title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * job description getter
     * 
     * @return job description
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * job description setter
     * 
     * @param description job description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * job salary getter
     * 
     * @return job salary
     */
    public int getSalary()
    {
        return salary;
    }
    
    /**
     * job salary setter
     * 
     * @param salary job salary
     */
    public void setSalary(int salary)
    {
        this.salary = salary;
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
     * job category getter
     * 
     * @return job category
     */
    public ArrayList<String> getCategory()
    {
        return category;
    }
    
    /**
     * job category setter
     * 
     * @param job category
     */
    public void setCategory(ArrayList<String> category)
    {
        this.category = category;
    }
    
    /**
     * job skillsets needed getter
     * 
     * @return skillsets needed
     */
    public ArrayList<String> getSkillsets()
    {
        return skillsets;
    }
    
    /**
     * job skillsets needed setter
     * 
     * @param skillsets skillsets needed
     */
    public void setSkillsets(ArrayList<String> skillsets)
    {
        this.skillsets = skillsets;
    }
    
    /**
     * job seeker username getter
     * 
     * @return job seeker username
     */
    public ArrayList<String> getJobSeekerUsername()
    {
        return jobSeekerUsername;
    }
    
    /**
     * job seeker username setter
     * 
     * @param jobSeekerUsername usernames of job seekers who applied for this job
     */
    public void setJobSeekerUsername(ArrayList<String> jobSeekerUsername)
    {
        this.jobSeekerUsername = jobSeekerUsername;
    }
    
    /**
     * add a job seeker to job seeker username list
     * 
     * @param jobSeeker username of job seeker
     */
    public void addJobSeeker(String jobSeeker)
    {
        this.jobSeekerUsername.add(jobSeeker);
    }
    
    /**
     * Display all the information of job
     */
    public void display()
    {
        System.out.println("Job recruiter username: " + getJobRecruiterUsername());
        System.out.println("Title: " + getTitle());
        System.out.println(getDescription());
        System.out.println("Salary: " + getSalary());
        System.out.println("Location: " + getLocation());
        System.out.println("Skills needed:");
        for(String s : getSkillsets())
        {
            System.out.print("   " + s);
        }
        System.out.println("/n");
    }
}
