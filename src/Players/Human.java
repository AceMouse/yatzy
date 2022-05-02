package Players;

import Rules.Rule;

import java.util.Scanner;

public class Human implements Player{
    private String name;
    public Human(String name){
        this.name = name;
    }
    @Override
    public boolean show() {
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean keep(boolean[] keep, Rule[] rules, int[][] board, boolean[][] used, byte[] dice, int player) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which do you want to keep?");
        var nextLine = sc.nextLine();
        if ("d".equals(nextLine))
            return true;
        for (var die : nextLine.split("")){
            if (die.length() > 0 && '1' <= die.charAt(0) && die.charAt(0) <= '6')
                keep[Integer.parseUnsignedInt(die)-1] = true;
        }
        return false;
    }

    @Override
    public void rule(Rule[] rules, int[][] board, boolean[][] used, byte[] dice, int player) {
        Scanner sc = new Scanner(System.in);
        outer:
        while (true) {
            System.out.println("Which rule do you want to use?");
            var nextLine = sc.nextLine();
            if ("q".equals(nextLine))
                break;
            for (int i = 0; i < rules.length; i++) {
                if (rules[i].getName().equalsIgnoreCase(nextLine) && !used[i][player]) {
                    board[i][player] = rules[i].getScore(dice);
                    used[i][player] = true;
                    break outer;
                }
            }
        }
    }
}
