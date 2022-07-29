import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class Team
{
    private String name;
    private ArrayList<Character> members;

    public Team(String name){
        this.name = name;
        this.members = new ArrayList<Character>();
    }

    public String getName(){
        return name;
    }

    public Character[] getMembers(){
        return members.toArray(new Character[members.size()]);

    }

    public int addMember(Character member){
        if(members.contains(member)){
            return -1; 
        }
        else if(members.size()>= 5){
            return -2;
        }
        else{
            members.add(member);
            return members.size();
        }
    }

    public ArrayList<Character> getAliveMembers() {
        ArrayList<Character> aliveMembers = (ArrayList<Character>) this.members
            .stream()
            .filter(m -> m.isAlive())
            .collect(Collectors.toList());
        return aliveMembers;
    }
        
    public Character getAliveMemberByLeastHP() {
        return Collections.min(this.getAliveMembers(), Comparator.comparing(m -> m.getHP()));
    }

    public Character getAliveMemberByHighestAttack(){
        return Collections.max(this.getAliveMembers(), Comparator.comparing(m -> m.getAttack()));
    }

    public int getAliveMembersCount(){
        int aliveMembers = (int)this.members
            .stream()
            .filter(m -> m.isAlive())
            .count();

        return aliveMembers;
    }

    public int getDeadMembersCount(){
        int deadMembers = this.members.size() - this.getAliveMembersCount(); 
        return deadMembers;       
    }

    public Character getRandomAliveMember(){
        ArrayList<Character> aliveMembers = this.getAliveMembers();
        Random random = new Random();
        int randomIndex = random.nextInt(aliveMembers.size());
        return aliveMembers.get(randomIndex);

    }

    public int getMembersCount(){
        return members.size();
    }

    public abstract void move(Character member, Team enemyTeam) throws Exception; 
}