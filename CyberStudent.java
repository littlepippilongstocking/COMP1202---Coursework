public class CyberStudent extends Student implements Triggerable{

    public CyberStudent(String name) {
        super(name, 7, 7, 5, 6, 6);
    }
   
    public void cyberAttack(Team enemyTeam) throws Exception {
        this.specialAttack();

        for(Character enemy : enemyTeam.getMembers()){
            if(enemy.isAlive()){
                int damageAmount = (100 * this.getAttack()) / (100 + enemy.getDefence());
                enemy.decreaseHP(damageAmount);
                if(!enemy.isAlive()){
                    this.increaseEP(4);
                }
            }
        }
    }

    @Override
    public void triggerSpecialAttack(Team enemyTeam) throws Exception {      
        this.cyberAttack(enemyTeam);
    }
}