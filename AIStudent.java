public class AIStudent extends Student implements Triggerable{

    public AIStudent(String name) {
        super(name, 6, 7, 7, 5, 3);
    }

    public void machineLearning(Character enemy) throws Exception {
        this.specialAttack();
        int damageAmount = 2 * (100 * this.getAttack()) / (100 + enemy.getDefence());
        enemy.decreaseHP(damageAmount);
        if(!enemy.isAlive()){
            this.increaseEP(4);
        }
    }

    public void naturalLanguageProcessing() throws Exception {
        this.specialAttack();
        
        this.increaseHP(this.getDefence());
    }

    @Override
    public void triggerSpecialAttack(Character enemy) throws Exception {
        if(this.getHP() < this.getMaxHP()/2){
            this.naturalLanguageProcessing();
        }
        else{
            this.machineLearning(enemy);
        }
    }
}