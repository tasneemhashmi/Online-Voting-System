import java.util.*;

class Candidate {
    private String candidateName;
    private int voteCount;

    // Constructor
    public Candidate(String candidateName) {
        this.candidateName = candidateName;
        this.voteCount = 0;
    }

    public void vote() {
        voteCount++;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getVoteCount() {
        return voteCount;
    }
}

public class VotingSystem {

    static ArrayList<Candidate> candidates = new ArrayList<>();

    static HashSet<Integer> votedVoters = new HashSet<>();

    public static void displayCandidates() {
        System.out.println("\nChoose Candidate:");

        for (int i = 0; i < candidates.size(); i++) {
            System.out.println((i + 1) + ". " +
                    candidates.get(i).getCandidateName());
        }
    }

    public static void castVote(Scanner sc) {

        System.out.print("Enter Voter ID: ");
        int voterId = sc.nextInt();

        if (votedVoters.contains(voterId)) {
            System.out.println("You have already voted!");
            return;
        }

        displayCandidates();

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice < 1 || choice > candidates.size()) {
            System.out.println("Invalid Candidate Choice!");
            return;
        }

        candidates.get(choice - 1).vote();

        votedVoters.add(voterId); 

        System.out.println("Vote Cast Successfully!");
    }

    public static void displayResults() {

        System.out.println("Final Results");

        Candidate winner = candidates.get(0);

        for (Candidate c : candidates) {
            System.out.println(c.getCandidateName() +
                    ": " + c.getVoteCount() + " votes");

            if (c.getVoteCount() > winner.getVoteCount()) {
                winner = c;
            }
        }

        System.out.println("\nWinner: " +
                winner.getCandidateName());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        candidates.add(new Candidate("Tasneem"));
        candidates.add(new Candidate("Sebastian"));
        candidates.add(new Candidate("Harshita"));

        int choice;

        do {
            System.out.println("\nOnline Voting System");
            System.out.println("1. Vote");
            System.out.println("2. View Results");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    castVote(sc);
                    break;

                case 2:
                    displayResults();
                    break;

                case 3:
                    System.out.println("Exiting Voting System...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}
