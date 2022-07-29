public interface Monster{

    void strike(Character enemy);
    int getAttack();
    int getDefence();
    void increaseDefence(int amount);


    default void SyntaxError(Character enemy){
        int attack = (100 * this.getAttack()) / (100 + enemy.getDefence());
        enemy.decreaseHP(attack);
    }

    default void NullPointerException() {
        this.increaseDefence(this.getDefence());
    }

    default void ArrayIndexOutOfBoundException(Character enemy) {
        int attack = 2*((100 * this.getAttack()) / (100 + enemy.getDefence()));
        enemy.decreaseHP(attack);

    }
    
}