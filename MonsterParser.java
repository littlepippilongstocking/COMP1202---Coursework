public class MonsterParser {
    public static Team Parse(String data){
        MonsterTeam result = new MonsterTeam("");
        String[] monstersData = data.split(";");
        for (String monsterInfo : monstersData) {
            String[] monsterDetails = monsterInfo.split(",|\\(|\\)");
            String monsterName = monsterDetails[0];
            String monsterType = monsterDetails[1];
            String monsterLevel = monsterDetails[2];

            if(monsterType=="Minion") {
                Minion minion = new Minion(monsterName);
                minion.setLevel(Integer.parseInt(monsterLevel));
                result.addMember(minion);
            } else if(monsterType=="Boss") {
                Boss boss = new Boss(monsterName);
                boss.setLevel(Integer.parseInt(monsterLevel));            
                result.addMember(boss);
            }  
        }
        return result;        
    }
}
