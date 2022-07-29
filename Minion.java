import java.util.Random;
public class Minion extends Character implements Monster{

    public Minion(String name){
        super(name, 5, 5, 5, 5); 
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

        if (randomNumber < 75) { SyntaxError(enemy); }
        if (randomNumber >=75  && randomNumber < 90) { NullPointerException(); }
        if (randomNumber >= 90) { ArrayIndexOutOfBoundException(enemy); }
    }
}