import java.util.*;
import java.util.stream.Stream;

public class Main {

    static HashMap<String, Practice> practices = new HashMap<>();
    static HashMap<String, Competition> competitions = new HashMap<>();
    static HashMap<String, Setup> setups = new HashMap<>();
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args){
        String userChoice = "";
        while(true){
            System.out.println("\nWelcome to Archery Journal.\nSelect an option to continue:");
            System.out.println("1. View setups");
            System.out.println("2. View Practice Sessions");
            System.out.println("3. View Competitions");
            System.out.println("4. Quit");

            userChoice = scan.nextLine();

            switch (userChoice){
                case "1":
                    viewSetups();
                    break;
                case "2":
                    viewPracticeSessions();
                    break;
                case "3":
                    viewCompetitions();
                    break;
                case "4":
                    scan.close();
                    quit();
                    break;
                default:
                    System.out.println("Invalid Choice!");
                    continue;
            }
        }
    }

    private static void quit() {
        scan.close();
        System.out.println("Exiting program...");
        System.exit(0);
    }

    private static void viewCompetitions() {
        System.out.println("COMPETITIONS...");
        while(true) {
            for (Map.Entry<String, Competition> tempCompetitions : competitions.entrySet()) {
                System.out.println(tempCompetitions.getValue().getTitle());
            }

            System.out.println("" +
                    "Enter Competition Name for more details\n" +
                    "OR add to add a new competition\n" +
                    "OR edit to edit a competition\n" +
                    "OR return to return to previous screen: ");
            String competitionName;
            try {
                competitionName = scan.nextLine();
            } catch (Exception e) {
                System.out.println("Competition name invalid!");
                return;
            }
            switch (competitionName.toLowerCase(Locale.ROOT)) {
                case "add":
                    addCompetition();
                    continue;
                case "edit":
                    editCompetition();
                    continue;
                case "return":
                    return;
                default:
                    Competition competition = competitions.get(competitionName);
                    competition.printDetails();
                    continue;

            }

        }
    }

    private static void viewPracticeSessions() {
        while(true){
            for(Map.Entry<String, Practice> tempPractices : practices.entrySet()){
                System.out.println(tempPractices.getValue().getTitle());
            }
            System.out.println("" +
                    "Enter Practice Name for more details\n" +
                    "OR add to add a new practice\n" +
                    "OR edit to edit a practice session\n" +
                    "OR return to return to previous screen: ");
            String practiceName;
            try {
                practiceName = scan.nextLine();
            } catch (Exception e) {
                System.out.println("Competition name invalid!");
                return;
            }
            switch (practiceName.toLowerCase(Locale.ROOT)) {
                case "add":
                    addPractice();
                    continue;
                case "edit":
                    editPractice();
                    continue;
                case "return":
                    return;
                default:
                    Competition competition = competitions.get(practiceName);
                    competition.printDetails();
                    continue;

            }
        }
    }

    private static void viewSetups() {
        while(true){
            for(Map.Entry<String, Setup> tempSetups : setups.entrySet()){
                System.out.println(tempSetups.getValue().getId());
            }
            System.out.println("" +
                    "Enter Setup Name for more details\n" +
                    "OR add to add a new setup\n" +
                    "OR edit to edit a setup\n" +
                    "OR return to return to previous screen: ");
            String setupName;
            try {
                setupName = scan.nextLine();
            } catch (Exception e) {
                System.out.println("Competition name invalid!");
                return;
            }
            switch (setupName.toLowerCase(Locale.ROOT)) {
                case "add":
                    addSetup();
                    continue;
                case "edit":
                    editSetup();
                    continue;
                case "return":
                    return;
                default:
                    Competition competition = competitions.get(setupName);
                    competition.printDetails();
                    continue;

            }
        }
    }

    private static void addCompetition(){
        try {
            System.out.println("Enter competition Title: ");
            String title = scan.nextLine();
            System.out.println("Enter Number of Ends: ");
            Integer numEnds = Integer.valueOf(scan.nextLine());
            System.out.println("Enter Arrows per End: ");
            Integer arrowsPerEnds = Integer.valueOf(scan.nextLine());
            Competition competition = new Competition(title, numEnds, arrowsPerEnds);
            competitions.put(competition.title, competition);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Practice NOT added..\nReturning to previous screen!");
            return;
        }
    }

    private static void addPractice(){
        try{
            System.out.println("Enter a practice session name: ");
            String title = scan.nextLine();
            System.out.println("Enter number of ends: ");
            Integer numEnds = Integer.valueOf(scan.nextLine());
            System.out.println("Enter number of arrows per end: ");
            Integer numArrowsPerEnd = Integer.valueOf(scan.nextLine());
            Practice practice = new Practice(title, numEnds, numArrowsPerEnd);
            practices.put(practice.title, practice);
        } catch(Exception e){
            System.out.println(e);
            System.out.println("Practice NOT added...\nReturning to previous screen!");
        }

    }

    private static void addSetup(){
        try{
            System.out.println("Enter a setup name: ");
            String title = scan.nextLine();
            Setup setup = new Setup(title);
            setups.put(setup.id, setup);
        } catch(Exception e){
            System.out.println(e);
            System.out.println("Setup NOT added...\nReturning to previous screen!");
        }

    }
    private static void editCompetition(){
        System.out.println("Enter Competition Name to edit: ");
        String compName = scan.nextLine();
        Competition competition = competitions.get(compName);
        while (true){
            System.out.printf("Editing %s Competition!\n", compName);
            System.out.println("Select an option...");
            System.out.println("" +
                    "1. Add an end of scoring\n" +
                    "2. Set Competition Date\n" +
                    "3. Change competition title\n" +
                    "4. Set Ranking\n" +
                    "return to go back");
            String userChoice = scan.nextLine();
            switch(userChoice){
                case "1":
                    System.out.println("Enter end number: ");
                    Integer end = Integer.valueOf(scan.nextLine());

                    System.out.println("Enter each arrow score separated by a space");
                    String arrowInput = scan.nextLine();
                    String[] temp = arrowInput.split(" ");
                    Integer[] arrows = new Integer[temp.length];

                    for(int i = 0; i < temp.length; i++){
                        arrows[i] = Integer.valueOf(temp[i]);
                    }

                    competition.addEnd(end, arrows);
                    continue;
                case "2":
                    System.out.println("Still working on this feature!");
                    continue;
                case "3":
                    System.out.println("Enter new competition name: ");
                    String competitionName = scan.nextLine();
                    competition.changeTitle(competitionName);
                    continue;
                case "4":
                    System.out.println("Enter your ranking in the competition: ");
                    Integer rank = Integer.valueOf(scan.nextLine());
                    competition.setStanding(rank);
                    continue;
                case "return":
                    System.out.println("Returning to previous screen...");
                    return;
                default:
                    System.out.println("Invalid option. Try again!");
                    break;
            }
        }

    }

    private static void editPractice(){
        System.out.println("Enter practice name to edit: ");
        String practiceName = scan.nextLine();
        System.out.printf("Editing %s practice!\n");
        Practice practice = practices.get(practiceName);
        while(true){
            System.out.println("Enter an option below...");
            System.out.println("" +
                    "1. Add end of practice\n" +
                    "2. Set Date of practice\n" +
                    "3. Add a setup to practice\n" +
                    "4. type return to return to previous menu");
            String userChoice = scan.nextLine();
            switch(userChoice){
                case "1":
                    System.out.println("Enter the end number of practice: ");
                    Integer end = Integer.valueOf(scan.nextLine());

                    System.out.println("Enter each arrow score separated by a space");
                    String arrowInput = scan.nextLine();
                    String[] temp = arrowInput.split(" ");
                    Integer[] arrows = new Integer[temp.length];

                    practice.addEnd(end, arrows);
                    continue;
                case "2":
                    System.out.println("Working on Feature!");
                    break;
                case "3":
                    // Print all the Setups stored
                    for(Map.Entry<String, Setup> entry : setups.entrySet())
                        System.out.println(entry.getValue().getId());

                    System.out.println("Enter setup name to add to practice: ");
                    String name = scan.nextLine();
                    Setup setup = setups.get(name);

                    practice.setSetup(setup);
                    continue;
                case "return":
                    System.out.println("Returning to previous screen...");
                    return;
                case "quit":
                    quit();
                    break;
                default:
                    System.out.println("Invalid Input! Try Again!");
                    break;
            }
        }

    }

    private static void editSetup(){
        System.out.println("Enter setup name to edit: ");
        String name = scan.nextLine();
        System.out.printf("Editing %s Setup!\n", name);
        Setup setup = setups.get(name);

        while(true){
            System.out.println("Enter Option...");
            System.out.println("" +
                    "1. Add Bow Manufacturer\n" +
                    "2. Add Bow Model\n" +
                    "3. Set Poundage\n" +
                    "4. Set Draw Length\n" +
                    "return to return...");
            String userChoice = scan.nextLine();

            switch (userChoice){
                case "1":
                    System.out.println("Enter Bow Manufacturer Name: ");
                    String manufacturer = scan.nextLine();
                    setup.setManufacturer(manufacturer);
                    continue;
                case "2":
                    System.out.println("Enter Bow Model: ");
                    String model = scan.nextLine();
                    setup.setModel(model);
                    continue;
                case "3":
                    System.out.println("Enter Bow Poundage: ");
                    Double poundage = Double.valueOf(scan.nextLine());
                    setup.setPoundage(poundage);
                    continue;
                case "4":
                    System.out.println("Enter Draw Length: ");
                    Double drawLength = Double.valueOf(scan.nextLine());
                    setup.setDrawLength(drawLength);
                    continue;
                case "return":
                    System.out.println("Returning to previous screen...");
                    return;
                default:
                    System.out.println("Invalid input! Try Again!");
                    break;
            }
        }

    }
}
