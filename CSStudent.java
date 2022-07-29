public class CSStudent extends Student implements Triggerable{

    public CSStudent(String name) {
        super(name, 7, 6, 6, 6, 4); 
    }
    
    public void pairWorking(Character friend , Character enemy) throws Exception {
        this.specialAttack();
        int damageAmount = (100 * this.getAttack()) / (100 + enemy.getDefence());
        enemy.decreaseHP(damageAmount);

        int damageAmountFriend = (100 * friend.getAttack()) / (100 + enemy.getDefence());
        enemy.decreaseHP(damageAmountFriend);
        
        if(enemy.getHP() == 0){
            this.increaseEP(4);
        }
    }

    public void support(Character friend) throws Exception {
        this.specialAttack();

        if(friend.isAlive()){
            friend.increaseHP(this.getDefence());
        }
    }

    @Override
    public void triggerSpecialAttack(Character enemy, Character friend) throws Exception {      
        if(friend.isAlive() && friend.getHP() < friend.getMaxHP()/3 ){
            this.support(friend);
        }
        else{
            this.pairWorking(friend, enemy);
        }
    }
}