public interface Triggerable {
    default void triggerSpecialAttack(Character enemy) throws Exception{

    }

    default void triggerSpecialAttack(Character friend, Character enemy) throws Exception{

    } 

    default void triggerSpecialAttack(Team enemyTeam) throws Exception{

    }
}
