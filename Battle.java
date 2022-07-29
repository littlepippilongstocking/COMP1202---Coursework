import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Battle{
    private Team team1;
    private Team team2;  


    public Team fight(Team team1, Team team2) throws Exception {
        int currentRound = 0;
        while(currentRound <= 30) {
            ArrayList<Character> team1Members  = 
                (ArrayList<Character>)team1
                .getAliveMembers()
                .stream()
                .sorted(Comparator.comparing(Character::getSpeed).reversed())
                .collect(Collectors.toList());   

            ArrayList<Character> team2Members  = 
                (ArrayList<Character>)team2
                .getAliveMembers()
                .stream()
                .sorted(Comparator.comparing(Character::getSpeed).reversed())
                .collect(Collectors.toList());    

            for(Character member : team1Members) {
                team1.move(member, team2);
            }

            for(Character member : team2Members) {
                team2.move(member, team1);
            }
   
            currentRound++;

            if(team1.getAliveMembersCount()==0) {
                return team2;
            }
            
            if(team2.getAliveMembersCount()==0) {
                return team1;
            }
            
            System.out.println("Alive members in team 1: "+team1.getAliveMembersCount());

            
            System.out.println("Alive members in team 2: "+team2.getAliveMembersCount()); 
        }

        return null;
    }

    /*Sorting the alive members of both teams in the descending order 
    according to their speeds. This will be the order for the member to move in the round.
    When a character has the turn, if the character is still alive, 
    call the method on the character’s team for the character to attack the enemy 
    team, i.e., move(Character member, Team enemyTeam) of the Team class.*/



}