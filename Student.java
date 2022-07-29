public class Student extends Character{

    private int maxKP = 0; 
    private int currentKP = 0;

    public Student(String name, int baseHP, int baseAtk, int baseDef, int baseSpd, int maxKP){
        super(name, baseHP, baseAtk, baseDef, baseSpd);
        this.maxKP = maxKP; 
    }

    public int getMaxKP(){
        //return (int)Math.round(this.maxKP*Math.pow(level, 1.2));
        return maxKP;
    }

    public void increaseKP(int amount){
        currentKP += amount;
    }
    
    public void resetKP(){
        currentKP = 0; 
    }

    public void javaProgramming(Character enemy){
        this.increaseEP(3);
        this.increaseKP(1);
        int damageAmount = (100 * this.getAttack()) / (100 + enemy.getDefence());
        enemy.decreaseHP(damageAmount);
        enemy.increaseEP(2);

        if(enemy instanceof Student){
            ((Student)enemy).increaseKP(3);
        }

        if(enemy.getHP() == 0 ){
            this.increaseEP(4);
        }
    }
    
    public void selfStudy(){
        this.increaseHP(2);
        this.increaseEP(6);
        this.increaseKP(2);
    }  
    
    protected void specialAttack() throws Exception {
        if(currentKP >= maxKP){
            this.increaseEP(4);
            this.resetKP();
        }
        else{
            throw new Exception("");
        }
    }

    public boolean canUseSpecialAttack(){
        return currentKP >= maxKP;
    }
}