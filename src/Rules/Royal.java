package Rules;

public class Royal implements Rule{
    @Override
    public String getName(){
        return "Royal";
    }
    @Override
    public int getScore(byte[] dice) {
        return RuleUtil.matches(dice, new byte[]{0,1,1,1,1,1,1})?30:0;
    }

}