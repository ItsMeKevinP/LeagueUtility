package kmpleague.com.company;



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Main.class.getResource("/summonerStats.fxml"));
        SummonerStatsController.showJFX();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your summoner name");

        String name = scan.nextLine();

        System.out.println("Enter Your API Token");
        String token = scan.nextLine();
        String result = getJSON.getSummonerInfo(name, token);

        System.out.println(result);
    }
}
