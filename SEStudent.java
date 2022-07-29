public class SEStudent extends Student implements Triggerable {

    public SEStudent(String name) {
        super(name, 8, 5, 8, 4, 10);
    }

    public void groupWork(Character enemy) throws Exception {
        this.specialAttack();
        for(Character member : this.getTeam().getMembers()){
            if(member.isAlive()){
                int damageAmount = (100 * member.getAttack()) / (100 + enemy.getDefence());
                enemy.decreaseHP(damageAmount);
            }
        }
    }

    public void groupDiscussion() throws Exception {
        this.specialAttack();

        for(Character member : this.getTeam().getMembers()){
            if(member.isAlive()){
                member.increaseHP((this.getDefence())/2);
            }
        }
    }

    private double getOwnTeamHP(){
        double result = 0;
        int aliveMembers = 0; 
        for(Character member : this.getTeam().getMembers()){
            if(member.isAlive()){
                result += member.getHP()/member.getMaxHP();
                aliveMembers++;
            }
        }
        return result/aliveMembers;
    }

    @Override
    public void triggerSpecialAttack(Character enemy) throws Exception {      
        if(this.getOwnTeamHP() < 0.33){
            this.groupDiscussion();
        }
        else{
            this.groupWork(enemy);
        }
    }
}