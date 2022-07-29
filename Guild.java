import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Guild {

    private ArrayList<Character> members; 

    public Guild(){
        members = new ArrayList<Character>();
    }

    public void addMember(Character character){
        members.add(character);
    }

    public Collection<Character> getMembers(){
        return members; 
    }

    public Team getTeam(Team enemyTeam){
        ArrayList<Character> newTeamMembers  = (ArrayList<Character>)members.stream()
        .sorted(Comparator.comparing(Character::getPowerPoints))
        .collect(Collectors.toList());    
        Team team = null ;

        if(enemyTeam instanceof StudentTeam){
            team = new MonsterTeam("");
        }
        else if(enemyTeam instanceof MonsterTeam){
            team = new StudentTeam("");
        }

        for(int i = newTeamMembers.size() - 1; i >=  0; i++){
            if(newTeamMembers.get(i).isAlive()){
                team.addMember(newTeamMembers.get(i));
            }
            
            if(team.getMembersCount() >= 5){
                break;
            }
        }

        return team; 
    }




}