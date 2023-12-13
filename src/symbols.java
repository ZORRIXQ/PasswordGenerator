import javax.swing.*;

public class symbols {
    private static String upperL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String lowerL = "abcdefghijklmnopqrstuvwxyz";
    private static String numsArr = "1234567890";
    private static String symbArr = "!@#$%&*_?";
    private static String[] choosen = new String[4];

    public static void Upper(Boolean bool){
        choosen[0] = (bool ? upperL : null);
    }

    public static void Lower(Boolean bool){
        choosen[1] = (bool ? lowerL : null);
    }

    public static void Nums(Boolean bool){
        choosen[2] = (bool ? numsArr : null);
    }

    public static void Symbols(Boolean bool){
        choosen[3] = (bool ? symbArr : null);
    }

    public static String createPass(){
        StringBuilder temp = new StringBuilder();
        if(choosen[0] == null && choosen[1] == null && choosen[2] == null && choosen[3] == null){
            return "You haven't chosen any symbols!";
        }
        while(temp.length() != myUi.count){
            int randArrIndex = (int) (Math.random() * 4);
            if (choosen[randArrIndex] != null) {
                int randSymbIndex = (int) (Math.random() * choosen[randArrIndex].length());
                temp.append(choosen[randArrIndex].charAt(randSymbIndex));
            }
        }
        return temp.toString();
    }
}
