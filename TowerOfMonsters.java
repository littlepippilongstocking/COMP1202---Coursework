import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TowerOfMonsters {

    public static void main(String[] args) {
        File inFile = null;
        if (args.length > 0) {
            inFile = new File(args[0]);

            BufferedReader objReader = null;
            try {
                String line;

                objReader = new BufferedReader(new FileReader(inFile));

                while ((line = objReader.readLine()) != null) {

                    System.out.println(line);
                    Team team = MonsterParser.Parse(line);
                    //TODO: pass team of monsters to battle
                    System.out.println(team.getAliveMembersCount());
                }

            } catch (IOException e) {

                e.printStackTrace();

            } finally {

                try {
                    if (objReader != null) {
                        objReader.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            System.err.println("Invalid arguments count:" + args.length);
        }
    }
}