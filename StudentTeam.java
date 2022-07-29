public class StudentTeam extends Team{

    public StudentTeam(String name) {
        super(name);
    }
    
    @Override
    public void move(Character member, Team enemyTeam) throws Exception {
        if(member instanceof Student){
            //we should have only members that are Students
            Student student = (Student)member; 
            if(student.canUseSpecialAttack()){
                if(student instanceof AIStudent){
                    Character weakestEnemy = enemyTeam.getAliveMemberByLeastHP();
                    ((AIStudent)student).triggerSpecialAttack(weakestEnemy);
                }
                else if(student instanceof CSStudent){
                    Character weakestFriend = member.getTeam().getAliveMemberByLeastHP();
                    if(weakestFriend.getHP() < weakestFriend.getMaxHP()/3){
                        ((CSStudent)student).triggerSpecialAttack(weakestFriend);
                    }
                    else{
                        Character strongestFriend = member.getTeam().getAliveMemberByHighestAttack();
                        ((CSStudent)student).triggerSpecialAttack(strongestFriend);
                    }
                }
                else if(student instanceof CyberStudent){
                    ((CyberStudent)student).triggerSpecialAttack(enemyTeam);
                }
                else if(student instanceof SEStudent){
                    Character weakestEnemy = enemyTeam.getAliveMemberByLeastHP();
                    ((SEStudent)student).triggerSpecialAttack(weakestEnemy);
                }
            }
        }
        else{
            
        }
    }
}