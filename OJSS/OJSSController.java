import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Collections;

/**
 * Main controller class
 * 
 * @auther (Yiming, Moon, Troy, Bryan)
 */
public class OJSSController 
{
    private ArrayList<User> userList;
    private ArrayList<JobRecruiter> jobRecruiterList;
    private ArrayList<JobSeeker> jobSeekerList;
    private ArrayList<Job> jobList;
    private View menu;
    private Validation validation;
    private FileDataController fileDataController;
    
    public OJSSController()
    {
        fileDataController = new FileDataController();
        userList = new ArrayList<User>();
        jobRecruiterList = new ArrayList<JobRecruiter>();
        jobSeekerList = new ArrayList<JobSeeker>();
        jobList = new ArrayList<Job>();
        validation = new Validation();
        menu = new View();
    }
    
    /**
     * Check role
     * 
     * @param user user object
     * @return role number
     */
    public int checkRole(User user)
    {
        int result = 0;
        
        String role = user.getRole();
        
        if(role.equals("Job Recruiter"))
            result = 1;
        else
            if(role.equals("Job Seeker"))
                result = 2;
        
        return result;
            
    }
    
    /**
     * Get user object
     * 
     * @param username username
     * @return user object
     */
    public User getUser(String username)
    {
        int index = 0;
        User human = new User();
        
        for (User person : userList)
        {
            if (person.getUserName().equalsIgnoreCase(username))
            {
                human = userList.get(index);
                break;
            }
            index = index + 1;
        }
        
        return human;
    }
    
    /**
     * Get job seeker object
     * 
     * @param username username
     * @return job seeker object
     */
    public JobSeeker getJobSeeker(String username)
    {
        int index = 0;
        JobSeeker human = new JobSeeker();
        
        for (JobSeeker person : jobSeekerList)
        {
            if (person.getUserName().equalsIgnoreCase(username))
            {
                human = jobSeekerList.get(index);
                break;
            }
            index = index + 1;
        }
        
        return human;
    }
    
    /**
     * Get job recruiter object
     * 
     * @param username username
     * @return job recruiter object
     */
    public JobRecruiter getJobRecruiter(String username)
    {
        int index = 0;
        JobRecruiter human = new JobRecruiter();
        
        for (JobRecruiter person : jobRecruiterList)
        {
            if (person.getUserName().equalsIgnoreCase(username))
            {
                human = jobRecruiterList.get(index);
                break;
            }
            index = index + 1;
        }
        
        return human;
    }
    
    /**
     * Log in
     * 
     * @return username of log in user
     */
    public String logIn()
    {
        Scanner answer = new Scanner(System.in);
        String username = "";
        String password = "";
        boolean valid = false;
        int attemptName = 0;
        while (!valid)
        {
            System.out.println("\n\t\t**************LOG**IN******************");
            System.out.print("\t\t >> Please insert your username : ");
            username = answer.nextLine().trim();
            valid = validation.checkUserNameExistance(username, userList);
            if (valid == false)
            {
                System.out.println("\n\t\t !!Username is not exist, please input the correct username");
                attemptName++;
            }
            
            if(attemptName == 3)
            {
                System.out.println("\n\t\t >> You already failed 3 times, please check and try again");
                home();
            }
        }
        
        valid = false;
        int attempt = 0;
        while (!valid)
        {
            System.out.print("\t\t >> Please insert your password : ");
            password = answer.nextLine().trim();
            valid = validation.checkUserPassword(username, password, userList);
            
            if (valid == false)
            {
                System.out.println("\n\t\t !! Password is not correct");
                attempt = attempt + 1;
            }
            
            if (attempt == 3)
            {
                System.out.println("\n\t\t >> You already failed 3 times, please try to input your usename again ");
                home();
            }   
        }   
        
        return username;
    }
    
    /**
     * Log out
     */
    public void logOut()
    {
        String decision = "";
        Scanner console = new Scanner(System.in);
        do
        {
            boolean valid = false;
            while (!valid)
            {
                System.out.print("\t\t >> Are you sure you want to log out?(y/n) ");
                decision = console.nextLine().trim().toLowerCase();
                valid = validation.checkNoBlank(decision);
            }
            
            decision = decision.substring(0, 1);
            
            if (decision.equals("y"))
            {
                home();
            }    
            else
                if (decision.equals("n"))
                    return; 
            else
                 System.out.print("\t\t >> Please enter your answer again (y/n) ");         
        }while (!decision.equals("n") && !decision.equals("y"));
    }
    
    /**
     * Create a new user
     * 
     * @param chosen choose a role to create
     */
    public void createUser(String chosen)
    {
        String role = chosen;
        boolean valid = false;
        String name = "";
        String username = "";
        String email = "";
        String gender = "";
        String password = "";
        ArrayList<String> skillsets = new ArrayList<String>();
        
        Scanner answer = new Scanner(System.in);
        while(!valid)
        {
            System.out.println();
            System.out.print("\t\t >> Please insert your name : ");
            name = answer.nextLine().trim();
            valid = validation.checkNoBlank(name);
        }
        valid = false;
        while(!valid)
        {
            System.out.print("\t\t >> Please insert your username : ");
            username = answer.nextLine().trim();
            valid = validation.checkNoBlank(username);
            boolean existance = validation.checkUserNameExistance(username, userList);
            if (existance == true)
            {
                valid = false;
                System.out.println();
                System.out.println("\t\t !! This username is already exist, please choose another one");
                System.out.println();
            }
        }
        valid  = false;
        while(!valid)
        {
            System.out.print("\t\t >> Please insert your gender(male/female) : ");
            gender = answer.nextLine().trim();
            valid = validation.checkGenderAnswer(gender);
        }
        valid = false;
        while(!valid)
        {
            System.out.print("\t\t >> Please insert your email : ");
            email = answer.nextLine().trim();
            valid = validation.checkNoBlank(email);
        }
        
        valid  = false;
        while(!valid)
        {
            System.out.print("\t\t >> Please set your password : ");
            password = answer.nextLine().trim();
            valid = validation.checkNoBlank(password);
        }
        
        if(role.equals("2"))
        {
            String decision = "y";
            String tmpSkill = "";
            while(decision.equals("y"))
            {
                valid = false;
                while(!valid)
                {
                    System.out.print("\t\t >> Please set your skillsets: ");
                    tmpSkill = answer.nextLine().trim();
                    valid = validation.checkNoBlank(tmpSkill);
                    valid = validation.checkNoSkill(tmpSkill, skillsets);
                }
                skillsets.add(tmpSkill);
                System.out.print("\t\t >> Would you like to input another skill?(y/n)");
                decision = answer.nextLine().trim();
                decision = decision.substring(0, 1);
                while(!decision.equals("n") && !decision.equals("y"))
                {
                    System.out.print("\t\t >> Input wrong! Please input y for yes or n for no: ");;
                    decision = answer.nextLine().trim();
                    decision = decision.substring(0,1);
                }
            }
            createJobSeeker(name,username,gender,email,password,skillsets);
        }
        else
            if (role.equals("1"))
        {
            System.out.println("\t\t >> Please input your company name:");
            String companyName = answer.nextLine();
            System.out.println("\t\t >> Please input your location:");
            String location = answer.nextLine();
            createJobRecruiter(name, username, gender, email, password, companyName, location);
        }
        
    }
    
    /**
     * Create a new job
     * 
     * @param jobRecruiterUsername username of job recruiter
     * @param title job title
     * @param description job description
     * @param salary job salary
     * @param location job location
     * @param categoty job category
     * @param skillsets job skillsets needed
     */
    public void createJob(String jobRecruiterUsername, String title, String description, int salary, String location, ArrayList<String> category, ArrayList<String> skillsets)
    {
        Job job = new Job();
        job.setJobRecruiterUsername(jobRecruiterUsername);
        job.setTitle(title);
        job.setDescription(description);
        job.setSalary(salary);
        job.setLocation(location);
        job.setCategory(category);
        job.setSkillsets(skillsets);
        
        jobList.add(job);
    }
    
    /**
     * Create a new job seeker
     * 
     * @param name name of job seeker
     * @param username username of job seeker
     * @param gender gender of job seeker
     * @param email email address
     * @param password password
     * @param skillsets list of skills
     */
    public void createJobSeeker(String name, String username, String gender, String email, String password, ArrayList<String> skillsets)
    {
        JobSeeker jobSeeker = new JobSeeker();
        String jobSeekerName = name;
        String jobSeekerUsername = username;
        String role = "Job Seeker";
        String jobSeekerGender = gender;
        String jobSeekerEmail = email;
        String pass = password;
        ArrayList<String> jobSeekerSkillsets = skillsets;
        
        jobSeeker.setName(jobSeekerName);
        jobSeeker.setUserName(jobSeekerUsername);
        jobSeeker.setRole(role);
        jobSeeker.setGender(jobSeekerGender);
        jobSeeker.setEmail(jobSeekerEmail);
        jobSeeker.setPassword(pass);
        jobSeeker.setSkillsets(jobSeekerSkillsets);
        
        jobSeekerList.add(jobSeeker);
        userList.add(jobSeeker);
    }
    
    /**
     * Create a new job recruiter
     * 
     * @param name name
     * @param username username
     * @param gender gender
     * @param email email address
     * @param companyName company name
     * @param location location
     */
    public void createJobRecruiter(String name, String username, String gender, String email, String password, String companyName, String location)
    {
        JobRecruiter jobRecruiter = new JobRecruiter();
        String jobRecruiterName = name;
        String jobRecruiterUsername = username;
        String role = "Job Recruiter";
        String jobRecruiterGender = gender;
        String jobRecruiterEmail = email;
        String pass = password;
        String company = companyName;
        String jobRecruiterLocation = location;
        
        jobRecruiter.setName(jobRecruiterName);
        jobRecruiter.setUserName(jobRecruiterUsername);
        jobRecruiter.setRole(role);
        jobRecruiter.setGender(jobRecruiterGender);
        jobRecruiter.setEmail(jobRecruiterEmail);
        jobRecruiter.setPassword(pass);
        jobRecruiter.setCompanyName(company);
        jobRecruiter.setLocation(jobRecruiterLocation);
        
        jobRecruiterList.add(jobRecruiter);
        userList.add(jobRecruiter);
    }
    
    /**
     * Store job seeker information into list of job seeker
     * 
     * @param jobSeekerDetails informtaion of job seeker
     */
    private void storeJobSeekersToJobSeekerList(String jobSeekerDetails)
    {
        String[] allJobSeeker = jobSeekerDetails.split(";");
        
        
        for (int line = 0; line < allJobSeeker.length ; line++)
        {
            String[] details = allJobSeeker[line].split(",");
            String seekerName = details[0];
            String seekerUsername = details[1];
            String role = details[2];
            String seekerGender = details[3];
            String seekerEmail = details[4];
            String pass = details[5];
            ArrayList<String> seekerSkills = new ArrayList<String>();
            for (int i = 6; i < details.length; i++)
            {
                seekerSkills.add(details[i]);
            }
            int totalUser = userList.size();
            int id = totalUser + 1; 
            
            JobSeeker seeker = new JobSeeker();
            seeker.setName(seekerName);
            seeker.setUserName(seekerUsername);
            seeker.setRole(role);
            seeker.setGender(seekerGender);
            seeker.setEmail(seekerEmail);
            seeker.setPassword(pass);
            seeker.setSkillsets(seekerSkills);
            
            jobSeekerList.add(seeker);
            userList.add(seeker);
        }
    }
    
    /**
     * Store job recruiter information into list of job recruiter
     * 
     * @param jobRecruiterDetails informtaion of job recruiter
     */
    private void storeJobRecruitersToJobRecruiterList(String jobRecruiterDetails)
    {
        String[] allJobRecruiter = jobRecruiterDetails.split(";");
        
        
        for (int line = 0; line < allJobRecruiter.length ; line++)
        {
            String[] details = allJobRecruiter[line].split(",");
            String recruiterName = details[0];
            String recruiterUsername = details[1];
            String role = details[2];
            String recruiterGender = details[3];
            String recruiterEmail = details[4];
            String pass = details[5];
            String recruiterCompanyName = details[6];
            String recruiterLocation = "";
            for (int i = 7; i < details.length; i++)
            {
                recruiterLocation = recruiterLocation + ", " + details[i];
            }
            recruiterLocation = recruiterLocation.substring(1, recruiterLocation.length() - 1).trim();
            
        
            JobRecruiter recruiter = new JobRecruiter();
            recruiter.setName(recruiterName);
            recruiter.setUserName(recruiterUsername);
            recruiter.setRole(role);
            recruiter.setGender(recruiterGender);
            recruiter.setEmail(recruiterEmail);
            recruiter.setPassword(pass);
            recruiter.setCompanyName(recruiterCompanyName);
            recruiter.setLocation(recruiterLocation);
            
            jobRecruiterList.add(recruiter);
            userList.add(recruiter);
        }
    }
    
    /**
     * Store job information into list of job
     * 
     * @param jobDetails informtaion of job
     */
    public void storeJobsToJobList(String jobDetails)
    {
        String[] allJob = jobDetails.split(";");
        
        
        for (int line = 0; line < allJob.length ; line++)
        {
            String[] details = allJob[line].split("///");
            String jobRecruiterUsername = details[0];
            String title = details[1];
            String description = details[2];
            int salary = Integer.parseInt(details[3].trim());
            String location = details[4];
            String[] categories = details[5].split(",");
            ArrayList<String> category = new ArrayList<String>();
            for (int i = 0; i < categories.length; i++)
            {
                category.add(categories[i]);
            }
            String[] skillset = details[6].split(",");
            ArrayList<String> skillsets = new ArrayList<String>();
            for (int i = 0; i < skillset.length; i++)
            {
                skillsets.add(skillset[i]);
            }
            String[] jobSeekerUsernames = details[7].split(",");
            ArrayList<String> jobSeekerUsername = new ArrayList<String>();
            for (int i = 0; i < jobSeekerUsernames.length; i++)
            {
                jobSeekerUsername.add(jobSeekerUsernames[i]);
            }
                        
            Job job = new Job(jobRecruiterUsername, title, description, salary, location, category, skillsets, jobSeekerUsername); 
            
            jobList.add(job);    
            
        }
    }

    /**
     * Store notification information into list of notifications
     * 
     * @param notificationDetails informtaion of notification
     */
    public void storeNotificationsToNotificationList(String notificationDetails)
    {
        String[] allNoti = notificationDetails.split(";");
        
        
        for (int line = 0; line < allNoti.length ; line++)
        {
            String[] details = allNoti[line].split("///");
            String jobSeekerUsername = details[0];
            String[] notifications = details[1].split(",");
            ArrayList<String> notification = new ArrayList<String>();
            for (int i = 0; i < notifications.length; i++)
            {
                notification.add(notifications[i]);
            }
            getJobSeeker(jobSeekerUsername).setNotification(notification);
        }
    }
  
    /**
     * Get information from local files
     */
    public void uploadDataFromFile()
    {
        String jobSeekerFile = ("JobSeeker.txt");
        String jobRecruiterFile = ("JobRecruiter.txt");
        String jobFile = ("Job.txt");
        String notificationFile = ("Notification.txt");
        
        String jobSeekerLines = readFile(jobSeekerFile);
        String jobRecruiterLines = readFile(jobRecruiterFile);
        String jobLines = readFile(jobFile);
        String notificationLines = readFile(notificationFile);
        
        storeJobSeekersToJobSeekerList(jobSeekerLines);
        storeJobRecruitersToJobRecruiterList(jobRecruiterLines);
        storeJobsToJobList(jobLines);
        storeNotificationsToNotificationList(notificationLines);
        
    }
    
    /**
     * Start to run the program
     */
    public void start()
    {
        uploadDataFromFile();
        menu.home();
        home();
    }
    
    /**
     * Home menu of program, and to call other functions
     */
    public void home()
    {
        
        Scanner console = new Scanner(System.in);
        String answer = "";
        boolean valid = false;
        
        while(!valid)
        {
            menu.homeDisplay();
            answer = console.nextLine().trim();
            valid = validation.integerValidation(answer, 1, 3);
        }
        

        if (answer.equals("1"))
        {
            register();
            menu.welcomeNewUser();
            runOJSS();
        }
        
        else
            if(answer.equals("2"))
                runOJSS();
        
        else
            if(answer.equals("3"))
                exit();
    }
    
    /**
     * run main program
     */
    public void runOJSS()
    {
        String userName = logIn();
        
        User user = getUser(userName);
        int role = checkRole(user);
        
        if (role == 1)
        {
            JobRecruiter jobRecruiter = getJobRecruiter(userName);
            runOJSSJobRecruiter(jobRecruiter);
        }
        
        else
            if(role == 2)
        {
                JobSeeker jobSeeker = getJobSeeker(userName);
                runOJSSJobSeeker(jobSeeker);
        }
        
        
    }
    
    /**
     * run main functions of job recruiter user
     * 
     * @param jobRecruiter job recruiter to run the program
     */
    public void runOJSSJobRecruiter(JobRecruiter jobRecruiter)
    {
        int option;
        String answer = "";
        while(true)
        {
            Scanner respon = new Scanner(System.in);
            boolean valid = false;
                    
            while(!valid)
            {
                menu.jobRecruiterDisplay(jobRecruiter);
                answer = respon.nextLine().trim();
                valid = validation.integerMenuValidation(answer);
            }
            
            option = Integer.parseInt(answer);
            
            switch (option)
            {
                case 1:
                    manageJobs(jobRecruiter);break;
                
                case 2:
                    System.out.println("\t\t|      These are your jobs: ");
                    for(Job job: jobList)
                    {
                        if (jobRecruiter.getUserName().equals(job.getJobRecruiterUsername()))
                            System.out.println(job.getTitle());
                        
                    }
                    System.out.println("\t\t|      Please enter the title of the job you want to see: ");
                    String sTitle = respon.nextLine().trim();
                    System.out.println("\t\t|      These job seekers have applied for the job: ");
                    for(Job job : jobList)
                    {
                        if (jobRecruiter.getUserName().equalsIgnoreCase(job.getJobRecruiterUsername()) && sTitle.equalsIgnoreCase(job.getTitle()))
                            for (String seeker : job.getJobSeekerUsername())
                            {
                                getJobSeeker(seeker).displayJobSeeker();
                                System.out.println("\n");
                            }
                    }
                    System.out.println("\t\t|      Enter the job seeker's username to send an invitation for interview:");
                    System.out.println("\t\t|      Or just press enter to cancel. Input:");
                    String iUsername = respon.nextLine().trim();
                    for (JobSeeker seek : jobSeekerList)
                    {
                        if (iUsername.equalsIgnoreCase(seek.getUserName()))
                        {
                            String invitation = "Job recruiter: " + jobRecruiter.getUserName() + "invites you for the interview of the job: " + sTitle;
                            seek.addNotification(invitation);
                        }
                    }
                    break;
                
                case 3:
                    manageProfile(jobRecruiter.getUserName()); break;
                    
                case 4:
                    logOut();break;
                    
                default:
                    System.out.println("\n\t\tERROR : Invalid Input. Please enter a valid number (1-4) \n ");
            }
                
        }
    }
    
    /**
     * run main functions of job seeker user
     * 
     * @param jobSeeker job seeker to run the program
     */
    public void runOJSSJobSeeker(JobSeeker jobSeeker)
    {
        int option;
        String answer = "";
        while(true)
        {
            Scanner respon = new Scanner(System.in);
            boolean valid = false;
                    
            while(!valid)
            {
                menu.jobSeekerDisplay(jobSeeker);
                answer = respon.nextLine().trim();
                valid = validation.integerMenuValidation(answer);
            }
            
            option = Integer.parseInt(answer);
            
            switch (option)
            {
                case 1:
                    System.out.println("\t\t|      Please enter title keyword (or press enter for next):");
                    System.out.println("\t\t|      (e.g. Data Science Job, Java Programming Job or Law Job, so on)");
                    String kTitle = respon.nextLine();
                    valid = false;
                    String tkSalary = "";
                    int kSalary = 0;
                    boolean valid2 = false;
                    do
                    {
                        do
                        {
                                System.out.println("\t\t|      Please enter salary keyword (or press enter for next):");
                                System.out.println("\t\t|      (e.g. 100, 300, 500 or 5000, so on)");    
                                    tkSalary = respon.nextLine();
                                    valid = validation.integerMenuValidation(tkSalary);
                                }while(!valid);
                        kSalary = Integer.parseInt(tkSalary);
                                valid2 = validation.checkPositive(kSalary);
                }while(!valid2);
                    System.out.println("\t\t|      Please enter location keyword (or press enter for next):");
                    System.out.println("\t\t|      (e.g. Canberra, Sydney, Hawthorn, Caulfield or Melbourne, so on)");
                    String kLocation = respon.nextLine().trim();
                    System.out.println("\t\t|      Please enter job type keyword using ',' to split (or press enter for next):");
                    System.out.println("\t\t|      (e.g. IT, Marketing, Law, Business, Hospitality or Accounting, so on)");
                    String[] keyCategory = respon.nextLine().trim().split(",");
                    ArrayList<String> kCategory = new ArrayList<String>();
                    for (int i = 0; i < keyCategory.length; i++)
                    {
                        kCategory.add(keyCategory[i]);
                    }
                    System.out.println("\t\t|      Please enter skillsets keyword using ',' to split (or press enter for next):");
                    String[] keySkillsets = respon.nextLine().trim().split(",");
                    ArrayList<String> kSkillsets = new ArrayList<String>();
                    for (int i = 0; i < keySkillsets.length; i++)
                    {
                        kSkillsets.add(keySkillsets[i]);
                    }
                    matching(kTitle, kSalary, kLocation, kCategory, kSkillsets);
                    int exit = 0;
                    do
                    {
                        valid = false;
                        String choose = "";
                        while(!valid)
                        {
                            System.out.print("\t\t|      Would you like to apply for any job above? (y/n): ");
                            choose = respon.nextLine().trim();
                            valid = validation.checkNoBlank(choose);
                        }
                        choose.substring(0,1);
                        if( choose.equals("y"))
                        {
                            String recruiterName = "";
                            String aTitle = "";
                            valid = false;
                            while(!valid)
                            {
                                    System.out.println("\t\t|      Please enter the recuiter username of the job:");
                                    recruiterName = respon.nextLine().trim();
                                    valid = validation.checkNoBlank(recruiterName);
                            }
                            valid = false;
                            while(!valid)
                            {
                                System.out.println("\t\t|      Please enter the title of the job: ");
                                aTitle = respon.nextLine().trim();
                                valid = validation.checkNoBlank(aTitle);
                            }
                            int countS  = 0;
                            for(Job job : jobList)
                            {
                                if (recruiterName.equalsIgnoreCase(job.getJobRecruiterUsername()) && aTitle.equalsIgnoreCase(job.getTitle()))
                                {
                                    job.addJobSeeker(jobSeeker.getUserName());
                                    System.out.println("\t\t|      You have succssfully applied the job. Thanks!");
                                    countS++;
                                }
                            }
                            if(countS == 0)
                            {
                                System.out.println("Enter wrong! No such job, application failed.Please try again");
                            }
                            else
                            {
                                exit = 1;
                            }
                        }
                        else if(choose.equals("n"))
                        {
                            exit = 1;
                        }
                        else
                        {
                            System.out.println("Wrong input! Please input y for yes or n for no");
                        }
                    }while(exit == 0);
                    break;
                
                case 2:
                    for(String info : jobSeeker.getNotification())
                    {
                        System.out.println(info);
                    }
                    break;
                
                case 3:
                    int count = 0;
                    for(Job job : jobList)
                    {
                        for (String seeker : job.getJobSeekerUsername())
                        {
                            if(seeker.equals(jobSeeker.getUserName()))
                                job.display();
                        }
                        count ++;
                    }
                    if (count == 0)
                           System.out.println("Threr is no applied job");
                    break;
                    
                case 4:
                    manageProfile(jobSeeker.getUserName()); break;
                    
                case 5:
                    logOut();break;
                    
                default:
                    System.out.println("\n\t\tERROR : Invalid Input. Please enter a valid number (1-5) \n ");
            }
                
        }
        
    }
    
    /**
     * Let user to choose the role to register
     */
    public void chooseRole()
    {
        Scanner answer = new Scanner(System.in);
        boolean valid = false;
        String role = "";
        
        while(!valid)
        {
            menu.displayRoles();
            role = answer.nextLine().trim();
            valid = validation.integerValidation(role, 1, 3);
        }
        
        if(role.equals("3"))
            home();
        else
            createUser(role);
    }
    
    /**
     * Main control to register a new user
     */
    public void register()
    {
        menu.registerDisplay();
        chooseRole();
    }
    
    /**
     * Change user's profile information
     * 
     * @param username user's username
     */
    public void manageProfile(String username)
    {
        User tmpUser = getUser(username);
        Scanner input = new Scanner(System.in);
        String option = "";
        if(tmpUser.getRole().equals("Job Seeker"))
        {
            JobSeeker tmpSeeker = getJobSeeker(username);
            tmpSeeker.displayJobSeeker();
            do
            {
                menu.manageSeekerProfile();
                option = input.nextLine();
                switch (option)
                {
                    case "1":
                        System.out.println("Please enter new name: ");
                        tmpSeeker.setName(input.nextLine().trim());break;
                    case "2":
                        System.out.println("Please enter new email: ");
                        tmpSeeker.setEmail(input.nextLine().trim());break;
                    case "3":
                        System.out.println("Please enter new gender: ");
                        tmpSeeker.setGender(input.nextLine().trim());break;
                    case "4":
                        System.out.println("Please add new skill: ");
                        String newSkill = input.nextLine().trim();
                        tmpSeeker.addSkill(newSkill);break;
                    case "5":
                        break;
                    default:
                        System.out.println("Wrong input. Please input valid number(1-5)");
                        break;
                }
            }while(!option.equals("5"));
            System.out.println("Your new profile is:");
            tmpSeeker.displayJobSeeker();
            runOJSSJobSeeker(tmpSeeker);
        }
        
        if(tmpUser.getRole().equals("Job Recruiter"))
        {
            JobRecruiter tmpRecruiter = getJobRecruiter(username);
            tmpRecruiter.displayJobRecruiter();
            do
            {
                menu.manageRecruiterProfile();
                option = input.nextLine();
                switch (option)
                {
                    case "1":
                        System.out.println("Please enter new name: ");
                        tmpRecruiter.setName(input.nextLine().trim());break;
                    case "2":
                        System.out.println("Please enter new email: ");
                        tmpRecruiter.setEmail(input.nextLine().trim());break;
                    case "3":
                        System.out.println("Please enter new gender: ");
                        tmpRecruiter.setGender(input.nextLine().trim());break;
                    case "4":
                        System.out.println("Please enter new company name: ");
                        tmpRecruiter.setCompanyName(input.nextLine().trim());break;
                    case "5":
                        System.out.println("Please enter new location: ");
                        tmpRecruiter.setLocation(input.nextLine().trim());break;
                    case "6":
                        break;
                    default:
                        System.out.println("Wrong input. Please input valid number(1-6)");
                        break;
                }
            }while(!option.equals("6"));
            System.out.println("Your new profile is:");
            tmpRecruiter.displayJobRecruiter();
            runOJSSJobRecruiter(tmpRecruiter);
        }
    }
    
    /**
     * Manage job information
     * 
     * @param jobRecruiter job recruiter to do the funtion
     */
    public void manageJobs(JobRecruiter jobRecruiter)
    {
        Scanner input = new Scanner(System.in);
        String option = "";
        do
        {
            menu.manageJobs();
            option = input.nextLine();
            switch(option)
            {
                case "1":
                    for(Job job : jobList)
                    {
                        if(job.getJobRecruiterUsername().equals(jobRecruiter.getUserName()))
                        {
                            job.display();
                            System.out.print("\n");
                        }
                    }
                    break;
                case "2":
                    String option2 = "";
                    System.out.println("\t\t|      Please enter a job title that you want to change: ");
                    String title = input.nextLine().trim();
                    validation.checkNoBlank(title);
                    int count = 0;
                    int index = 0;
                    int goal = 0;
                    for(Job job : jobList)
                    {
                        if(job.getTitle().equalsIgnoreCase(title) && job.getJobRecruiterUsername().equalsIgnoreCase(jobRecruiter.getUserName()))
                        {
                            count ++;
                            goal = index;
                        }
                        index++;
                    }
                    if(count == 0)
                    {
                        System.out.println("\t\t|      No such a job");
                        break;
                    }
                    Job tmpJob = jobList.get(goal);
                    do
                    {
                        menu.changeJobDetails();
                        option2 = input.nextLine();
                        switch (option2)
                        {
                            case "1":
                                System.out.println("\t\t|      Please enter new Title: ");
                                tmpJob.setTitle(input.nextLine().trim());break;
                            case "2":
                                System.out.println("\t\t|      Please enter new Description: ");
                                tmpJob.setDescription(input.nextLine().trim());break;
                            case "3":
                                int newSalary = 0;
                                boolean validSalary;
                                do
                                {
                                System.out.println("\t\t|      Please enter new Salary: ");
                                newSalary = input.nextInt();
                                input.nextLine();
                                validSalary = validation.checkPositive(newSalary);
                            }while(!validSalary);
                                tmpJob.setSalary(newSalary);break;
                            case "4":
                                System.out.println("\t\t|      Please enter new Location: ");
                                tmpJob.setLocation(input.nextLine().trim());break;
                            case "5":
                                break;
                            default:
                                System.out.println("\t\t|      Wrong input. Please input valid number(1-5)");
                                break;
                        }
                    }while(!option2.equals("5"));
                    break;
                case "3":
                    System.out.println("\t\t|      Please input title of job needed to be removed:");
                    String remove = input.nextLine();
                    Iterator<Job> it = jobList.iterator();
                    while(it.hasNext())
                    { 
                        Job testJob = it.next();
                        if (testJob.getJobRecruiterUsername().equalsIgnoreCase(jobRecruiter.getUserName()) && testJob.getTitle().equalsIgnoreCase(remove))
                        {
                            it.remove();
                        }
                    }
                    break;
                case "4":
                    System.out.println("\t\t|      Please input the title:");
                    String newTitle = input.nextLine().trim();
                    System.out.println("\t\t|      Please input the description:");
                    String description = input.nextLine().trim();
                    boolean validSalary;
                    int salary = 0;
                    do
                    {
                        System.out.println("\t\t|      Please input the salary:");
                        salary = input.nextInt();
                        input.nextLine();
                        validSalary = validation.checkPositive(salary);
                    }while(!validSalary);
                    System.out.println("\t\t|      Please input the location:");
                    String location = input.nextLine().trim();
                    String option3 = "";
                    ArrayList<String> category = new ArrayList<String>();
                    do
                    {
                        System.out.println("\t\t|      Please input a job category:");
                        category.add(input.nextLine().trim());
                        System.out.print("\t\t|      Would you like to add more job categories?(y for yes, others for no):");
                        option3 = input.nextLine().trim();
                        option3 = option3.substring(0,1);
                    }while(option3.equals("y"));
                    String option4 = "";
                    ArrayList<String> skillsets = new ArrayList<String>();
                    do
                    {
                        System.out.println("\t\t|      Please input a skill the job needed:");
                        skillsets.add(input.nextLine().trim());
                        System.out.print("\t\t|      Would you like to add a more skills required?(y for yes, others for no):");
                        option4 = input.nextLine().trim();
                        option4 = option4.substring(0,1);
                    }while(option4.equals("y"));
                    createJob(jobRecruiter.getUserName(), newTitle, description, salary, location, category, skillsets);
                    break;
                case "5":
                    runOJSSJobRecruiter(jobRecruiter);
                    break;
                default:
                        System.out.println("\t\t|      Wrong input. Please input valid number(1-5)");
                        break;
            }
        }while(!option.equals("5"));
        runOJSSJobRecruiter(jobRecruiter);
    }
    
    /**
     * Matching function
     * 
     * @param title job title
     * @param salary job salary
     * @param location job location
     * @param skillsets job skillsets needed
     */
    public void matching(String title, int salary, String location, ArrayList<String> category, ArrayList<String> skillsets)
    {
        int score = 0;
        System.out.println("\t\t|      Matching results:");
        ArrayList<Job> result = new ArrayList<Job>();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        
        for (Job job : jobList)
        {
            score = 0;
            if(job.getTitle().contains(title))
            {
                score += 1;
            }
            if(job.getSalary() >= salary)
                score += 1;
            if(job.getLocation().contains(location))
                score += 1;
            for (String cate : job.getCategory())
            {
                for (String c : category)
                {
                    if (c.equalsIgnoreCase(cate))
                        score += 1;
                }
            }
            for (String skill : job.getSkillsets())
            {
                for (String s : skillsets)
                {
                    if (skill.equalsIgnoreCase(s))
                        score += 1;
                }
            }
            if(score >= 1)
            {
                result.add(job);
                scores.add(score);
            }
        }
        if(result.size() == 0)
            System.out.println("No related job");
        else
        {
            for(int i = 0; i < result.size() - 1; i++)
            {
                for(int j = result.size() -1; j > i; j--)
                {
                    if(scores.get(j) > scores.get(j-1))
                    {
                        Collections.swap(scores,j-1,j);
                        Collections.swap(result,j-1,j);
                    }
                }
            }
        }
        for(int i = 0; i < result.size(); i++)
        {
            result.get(i).display();
            System.out.println("Score: " + scores.get(i) + "\n");
        }
    }
    
    /**
     * Write information into files
     * 
     * @param filename name of file
     * @param output content to write
     */
    public void writeFile(String filename, ArrayList<String> output)
    {
        try
        {
            PrintWriter write = new PrintWriter(filename);
            for(String out : output)
            {
                write.println(out);
               }
            write.close();
           }
        catch(FileNotFoundException exception) 
        {
            String error = filename + " not found";
            System.out.println(error);
        }
        
        catch(IOException exception) 
        {
            String error = "Unexpected I/O error occured";
            System.out.println(error); 
        }    
    }
    
    /**
     * Read information from file
     * 
     * @param filename name of file
     * @return information recorded in file
     */
    public String readFile(String filename)
    {
        StringBuilder texts = new StringBuilder();
        
        try 
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            
            while (parser.hasNextLine())
            {
                String line = parser.nextLine();
                texts.append(line + ";");
            }
            
            inputFile.close();
            parser.close();
            return texts.toString();
            
        }
        
        catch(FileNotFoundException exception) 
        {
            String error = filename + " not found";
            System.out.println(error);
            return error;
        }
        
        catch(IOException exception) 
        {
            String error = "Unexpected I/O error occured";
            System.out.println(error); 
            return error;
        }    
    }
    
    /**
     * Close file record information into files
     */
    public void closeFile()
    {
        ArrayList<String> jobs = new ArrayList<String>();
        ArrayList<String> jobRecruiters = new ArrayList<String>();
        ArrayList<String> jobSeekers = new ArrayList<String>();
        ArrayList<String> notifications = new ArrayList<String>();
        for (Job job : jobList)
        {
            String jobinfo = job.getJobRecruiterUsername() + "///" + job.getTitle() + "///" + job.getDescription() + "/// " + job.getSalary();
            jobinfo = jobinfo + "///" + job.getLocation() + "///";
            for (String cate: job.getCategory())
            {
                jobinfo = jobinfo + cate + ",";
            }
            jobinfo = jobinfo.substring(0,jobinfo.length()-1) + "///";
            for (String seek : job.getJobSeekerUsername())
            {
                jobinfo = jobinfo + seek + ",";
            }
            jobinfo = jobinfo.substring(0,jobinfo.length()-1);
            jobs.add(jobinfo);
        }
        writeFile("Job.txt", jobs);
        for (JobRecruiter recruiter : jobRecruiterList)
        {
            String recinfo = recruiter.getName() + "," + recruiter.getUserName() + "," + recruiter.getRole() + "," + recruiter.getGender() + ",";
            recinfo = recinfo + recruiter.getEmail() + "," + recruiter.getPassword() + "," + recruiter.getCompanyName() + "," + recruiter.getLocation();
            jobRecruiters.add(recinfo);
        }
        writeFile("JobRecruiter.txt", jobRecruiters);
        for (JobSeeker seeker : jobSeekerList)
        {
            String seekinfo = seeker.getName() + "," + seeker.getUserName() + "," + seeker.getRole() + "," + seeker.getGender() + ",";
            seekinfo = seekinfo + seeker.getEmail() + "," + seeker.getPassword() + ",";
            for(String skill : seeker.getSkillsets())
            {
                seekinfo = seekinfo + skill + ",";
            }
            seekinfo = seekinfo.substring(0,seekinfo.length()-1);
            String notinfo = seeker.getUserName() + "///";
            for (String noti : seeker.getNotification())
            {
                notinfo = notinfo + noti + ",";
            }
            notinfo = notinfo.substring(0,notinfo.length()-1);
            jobSeekers.add(seekinfo);
            notifications.add(notinfo);
        }
        writeFile("JobSeeker.txt", jobSeekers);
        writeFile("Notification.txt", notifications);
    }

    /**
     * exit the user
     */
    private void exit()
    {
        String reply = "";
        Scanner console = new Scanner(System.in);
        
        do
        {
            boolean valid = false;
            while (!valid)
            {
                System.out.print("\n\t\t >> So, you want to exit from OJSS?(y/n) ");
                reply = console.nextLine().trim().toLowerCase();
                valid = validation.checkNoBlank(reply);
            }
            reply = reply.substring(0, 1);
            if (reply.equals("y"))
            {
                menu.exitRegards();
                closeFile();
            }
            else
                if (reply.equals("n"))
                    home(); 
            else
                 System.out.println("\t\tPlease enter your answer again (y/n) ");
        }while (!reply.equals("n") && !reply.equals("y"));       
    }
}
