import java.util.Random;

/**
 * Created by tearsyu on 14/01/17.
 */
public class GuessColor {
    enum Color{RED, BLACK, WHITE, GREEN};
    Random random;
    int pick, i ;
    String[] toGuess = {null, null, null, null};

    public GuessColor(){
        i = 0;
        random = new Random();
        initColor();

    }

    public void initColor(){
        System.out.println("Init game....");
        while(i < 4){
            pick = random.nextInt(4);
            toGuess[i] = Color.values()[pick].toString();
            i++;
        }
        System.out.println(toString());
    }

    public String toString(){
        if (toGuess[0] != null && toGuess[1] != null && toGuess[2] != null & toGuess[3] != null){
            String str = "[0 : " + toGuess[0] + "] [1 : " + toGuess[1]
                        + "] [2 : " + toGuess[2] + "] [3 : " + toGuess[3] + "]";
            return  str;
        } else {
            return "init unsuccessful, there is at least a null value.";
        }
    }

    public boolean equals(String[] getResp){
        boolean bool = false;
        if (getResp[0].equals(toGuess[0]) && getResp[1].equals(toGuess[1])
                && getResp[2].equals(toGuess[2])& getResp[3].equals(toGuess[3])){
            bool = true;
        }
        return bool;
    }

    public int equalsInt(String[] getResp){
        int cmp = 0;
        for(int j = 0; j < toGuess.length; ++j){
            if(!getResp[j].equals(toGuess[j])){
                cmp++;
            }
        }
        return  cmp;
    }
}
