import java.lang.Math;

public class Character{

    private String name; 
    private int baseHP;
    private int baseAtk; 
    private int baseDef;
    private int baseSpd;

    private int maxHP;
    private int currentHP;
    private int currentEP;

    private int level = 1;

    private Team team; 

    public Character(String name, int baseHP, int baseAtk, int baseDef, int baseSpd){
        this.name = name;
        this.baseHP = baseHP;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpd = baseSpd;
        this.currentHP = getMaxHP();
        this.maxHP = getMaxHP();
    }

    public Character(String name, int baseHP, int baseAtk, int baseDef, int baseSpd, Team team){
        this(name, baseHP, baseAtk, baseDef, baseSpd);
        this.team = team; 
    }

    public String getName(){
        return name; 
    }

    public int getMaxHP(){
        return (int)Math.round(baseHP*Math.pow(level, 1.2));

    }

    public int getAttack(){
        return (int)Math.round(baseAtk*Math.pow(level, 1.2));
    }

    public int getDefence(){
        return (int)Math.round(baseDef*Math.pow(level, 1.2));

    }

    public void increaseDefence(int amount){
        baseDef += amount; 
    }

    public int getSpeed(){
        return (int)Math.round(baseSpd*Math.pow(level, 1.2));
    }

    //maxEP = 10;
    private int targetEP; 
    public int getTargetEP(){ 
        targetEP = (int)Math.round(10*Math.pow(level,1.5));
        return targetEP;
    }

    public int getHP(){
        return currentHP;
    }

    public int getEP(){
        return currentEP;
    }

    public void increaseHP(int amount){
        if(currentHP > 0){
            currentHP += amount;
            currentHP = Math.min(currentHP, this.getMaxHP());
        } 
    }

    public void decreaseHP(int amount){
        if(currentHP > 0){
            currentHP -= amount;
            currentHP = Math.max(currentHP , 0);
        } 
    }

    public void increaseEP(int amount){
        currentEP += amount;

        if(currentEP >= getTargetEP()){
            level += 1;
            currentEP = 0;

            if(this.isAlive()){
                currentHP = getMaxHP();
            }
        }
    }

    public Team getTeam(){
        return team;
    }

    public void setTeam(Team team){
        this.team = team;
    }

    public Boolean isAlive(){
        return this.currentHP > 0;
    }

    public double getPowerPoints(){
        return (this.getAttack() + this.getDefence())/2.0;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}