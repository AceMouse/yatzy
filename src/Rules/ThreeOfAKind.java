package Rules;

public class ThreeOfAKind implements Rule{
    @Override
    public String getName(){
        return "3 Ens";
    }
    @Override
    public int getScore(byte[] dice) {
        return RuleUtil.getMaxGroupScore(RuleUtil.count(dice),3, 3);
    }
}