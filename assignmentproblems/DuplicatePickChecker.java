package assignmentproblems;

public class DuplicatePickChecker {

    public static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] test1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        String[] test2 = {"Kohli", "Bumrah", "Rohit"};

        System.out.println(findDuplicatePick(test1));
        System.out.println(findDuplicatePick(test2));
    }
}