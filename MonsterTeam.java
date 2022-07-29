public class MonsterTeam extends Team{

    public MonsterTeam(String name) {
        super(name);
    }
    
    @Override
    public void move(Character member, Team enemyTeam) {
        ((Monster)member).strike(enemyTeam.getRandomAliveMember());
    }
}