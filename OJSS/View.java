import java.util.ArrayList;

/**
 * Class to control all the views during running the program
 * 
 * @auther (Yiming, Moon, Troy, Bryan)
 */
public class View 
{
    /**
     * Display role menu
     */
    public void displayRoles()
    {
        System.out.println("\n\t\t:::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t|      Choose your role below :   |");
        System.out.println("\t\t:::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t|       [1] Job Recruiter         |");
        System.out.println("\t\t|       [2] Job Seeker            |");
        System.out.println("\t\t|       [3] Cancel                |");
        System.out.println("\t\t===================================");
        System.out.print("\t\t Please input the option number : ");
    }
    
    /**
     * Display welcome new user information
     */
    public void welcomeNewUser()
    {
        System.out.println();
        System.out.println("\t\t#####################################################################################");
        System.out.println("\t\t::                     Thankyou for register to OJSS     ,                         ::");
        System.out.println("\t\t:: Please remember your USERNAME and PASSWORD from now on to access your account   ::");
        System.out.println("\t\t:: Just input your registered username and password for log in to your new account ::");
        System.out.println("\t\t#####################################################################################");
        System.out.println();
    }
    
    /**
     * Display welcome information
     */
    public void home()
    {
        System.out.println();
        System.out.println("\t**==*oo*==*oo*==*oo*==*oo*==*oo*==*oo*==*oo*==*oo*==*oo*==**");
        System.out.println("\t**==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==**");
        System.out.println("\t::   Welcome abroad to Online Job Seeking System (OJSS)   ::");                       
        System.out.println("\t::                        (`\\_/`)                         ::");
        System.out.println("\t::         At last, please enjoy OJSS! *( 0.0 )*          ::");
        System.out.println("\t::                         (___)                          ::");
        System.out.println("\t############################################################");
        System.out.println();
    }
    
    /**
     * Display exit information
     */
    public void exitRegards()
    {
        System.out.println("\n\t\tSystem exit...");
        System.out.println("\t\t========= Thank you, have a wonderful day! =========");
        System.exit(0);
    }
    
    /**
     * Display log in or register mennu
     */
    public void homeDisplay()
    {
        System.out.println("\n\t\t:::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t|     Welcome to Ojss             |");
        System.out.println("\t\t:::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t|Please choose the options below :|");
        System.out.println("\t\t===================================");
        System.out.println("\t\t|       [1] Register              |");
        System.out.println("\t\t|       [2] LogIn                 |");
        System.out.println("\t\t|       [3] Exit                  |");
        System.out.println("\t\t===================================");
        System.out.print("\t\t  Please input the option number : ");
    }
    
    /**
     * Display job seeker actions menu
     */
    public void jobSeekerDisplay(JobSeeker jobSeeker)
    {
        welcome();
        System.out.println("\t\t      Welcome Again Job Seeker " + jobSeeker.getUserName().toUpperCase()+"!"  );
        System.out.println("\t\t::::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t||  Please choose the options below : ||");
        System.out.println("\t\t::::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t|  [1] Search and apply the job        |");
        System.out.println("\t\t|  [2] View invitations                |");
        System.out.println("\t\t|  [3] View applied jobs               |");
        System.out.println("\t\t|  [4] Manage your profile             |");
        System.out.println("\t\t|  [5] Log Out                         |");
        System.out.println("\t\t========================================");
        System.out.print("\t\t  Please input the option number : ");
        
    }
    
    /**
     * Display job recruiter actions menu
     */
    public void jobRecruiterDisplay(JobRecruiter jobRecruiter)
    {
        welcome();
        System.out.println("\t\t      Welcome Again Job Recruter " + jobRecruiter.getUserName().toUpperCase()+"!"  );
        System.out.println("\t\t::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t|| Please choose the options below :||");
        System.out.println("\t\t::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t|   [1] Manage jobs                  |");
        System.out.println("\t\t|   [2] Search job applicants        |");
        System.out.println("\t\t|   [3] Manage your profile          |");
        System.out.println("\t\t|   [4] Log Out                      |");
        System.out.println("\t\t======================================");
        System.out.print("\t\t  Please input the option number : ");
    }
    
    /**
     * Dsipaly welcome word
     */
    public void welcome()
    {
        System.out.println(" \n\n\t/////////////////////////////////////////////////////// ");
        System.out.println("\t                    **OJSS**                   ");
    }
    
    /**
     * Display menage job seeker profile menu
     */
    public void manageSeekerProfile()
    {
        System.out.println("\n\t\t::o::o::o::o::o::o::o::o::o::o::o::o::o::o");
        System.out.println("\t\t  Please choose the options below to change ");
        System.out.println("\t\t::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t        [1] Name");
        System.out.println("\t\t        [2] Email");
        System.out.println("\t\t        [3] Gender");
        System.out.println("\t\t        [4] Skillsets");
        System.out.println("\t\t        [5] Cancel");
        System.out.println("\t\t    ===================================== ");
        System.out.print("\t\t  Please input the option number : ");
    }
    
    /**
     * Display manage job recruiter profile menu
     */
    public void manageRecruiterProfile()
    {
        System.out.println("\n\t\t::o::o::o::o::o::o::o::o::o::o::o::o::o::o");
        System.out.println("\t\t  Please choose the options below to change ");
        System.out.println("\t\t::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t        [1] Name");
        System.out.println("\t\t        [2] Email");
        System.out.println("\t\t        [3] Gender");
        System.out.println("\t\t        [4] Company Name");
        System.out.println("\t\t        [5] Location");
        System.out.println("\t\t        [6] Cancel");
        System.out.println("\t\t    ===================================== ");
        System.out.print("\t\t  Please input the option number : ");
    }
    
    /**
     * Display manage job menu
     */
    public void manageJobs()
    {
        System.out.println("\n\t\t::o::o::o::o::o::o::o::o::o::o::o::o::o::o");
        System.out.println("\t\t  Please choose the options below           ");
        System.out.println("\t\t::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t        [1] View your jobs");
        System.out.println("\t\t        [2] Change job details");
        System.out.println("\t\t        [3] Remove a job");
        System.out.println("\t\t        [4] Add a new job");
        System.out.println("\t\t        [5] Cancel");
        System.out.println("\t\t    ===================================== ");
        System.out.print("\t\t  Please input the option number : ");
    }
    
    /**
     * Display change job details menu
     */
    public void changeJobDetails()
    {
        System.out.println("\n\t\t::o::o::o::o::o::o::o::o::o::o::o::o::o::o");
        System.out.println("\t\t  Please choose the options below to change ");
        System.out.println("\t\t::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t        [1] Title");
        System.out.println("\t\t        [2] Description");
        System.out.println("\t\t        [3] Salary");
        System.out.println("\t\t        [4] Location");
        System.out.println("\t\t        [5] Cancel");
        System.out.println("\t\t    ===================================== ");
        System.out.print("\t\t  Please input the option number : ");
    }    
    
    /**
     * Display job seeker information
     */
    public void displayJobSeeker(JobSeeker user)
    {
        System.out.println();
        System.out.println("\t\t:::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t     Hi Job seeker " + user.getUserName().toUpperCase() +"! Welcome to OJSS  ");
        System.out.println("\t\t::     Please read your details below          ::");
        System.out.println("\t\t=================================================");
        displayJobSeeker(user);
        System.out.println("\t\t=================================================");    
    }
    
    /**
     * Display job recruiter information
     */
    public void displayJobRecruiter(JobRecruiter user)
    {
        System.out.println();
        System.out.println("\t\t:::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t     Hi Job recruiter " + user.getUserName().toUpperCase() +"! Welcome to OJSS  ");
        System.out.println("\t\t::     Please read your details below          ::");
        System.out.println("\t\t=================================================");
        displayJobRecruiter(user);
        System.out.println("\t\t=================================================");    
    }
    
    /**
     * Display register words
     */
    public void registerDisplay()
    {
        System.out.println("\n\t||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\t\t      You choose to register as a new user");
        System.out.println("\t   Please read the following instructions for registration process");
    }
    
}
