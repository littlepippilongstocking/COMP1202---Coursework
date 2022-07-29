import java.util.Random; 
public class Boss extends Character implements Monster{

    public Boss(String name){
        super(name, 8, 7, 8, 7); 
    }

    public void NoneTermination(Character enemy){
        for(Character member : this.getTeam().getMembers()){
            if(!member.isAlive()){
                member.increaseHP(member.getMaxHP());
            }
        }
    }

    public void ConcurrentModificationException(Character enemy){
        for(Character member : enemy.getTeam().getMembers()){
            if(member.isAlive()){
                int attack = (100 * this.getAttack()) / (100 + enemy.getDefence());
                enemy.decreaseHP(attack);
            }
        }
    }

    public void strike(Character enemy){
        this.increaseEP(3);        
        if(!enemy.isAlive()){
            this.increaseEP(4);        
        }

        if(enemy instanceof Student){
            ((Student)enemy).increaseKP(3);        
        }
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        if (randomNumber < 50) { SyntaxError(enemy); }
        else if (randomNumber >=50  && randomNumber < 65) { NullPointerException(); }
        else if (randomNumber >= 65 && randomNumber < 80) { ArrayIndexOutOfBoundException(enemy);}
        else if (randomNumber >=80 && randomNumber < 90) { NoneTermination(enemy);}
        else if (randomNumber >= 90) { ConcurrentModificationException(enemy);}
    }
}