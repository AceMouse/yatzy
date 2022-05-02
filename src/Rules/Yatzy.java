package Rules;

public class Yatzy implements Rule{
    @Override
    public String getName(){
        return "Yatzy";
    }
    @Override
    public int getScore(byte[] dice) {
        int score = RuleUtil.getMaxGroupScore(RuleUtil.count(dice), 6,6);
        return score == 0? 0 : score + 50;
    }
}