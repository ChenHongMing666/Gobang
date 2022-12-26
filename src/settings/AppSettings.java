package settings;

public class AppSettings {
    public static final int mapSize = 10;
    public static final String[] title = { "Wellcome to Gobang Game !" /* EN */, "欢迎来到五子棋游戏" /* CH */ };
    public static final String[] countinuePrompt = { "Exit(1/0)"/* EN */ , "退出(1/0)" /* CH */ };
    public static final String[] winPrommpt = { "win!" /* EN */ , "获胜了!" /* CH */ };
    public static final String[][] timeUsedPrompt = { { "you spent ", "seconds on this chess." }/* EN */,{"你花了", "s来下这颗棋" } /* CH */ };
    public static final String[][] getInPrompt = { { "your Chess's x", "your Chess's y" } /* EN */ , {"落子的横坐标"  , "落子的纵坐标"} /* CH */ };
    public static final String[] getInErrorPrompt = { "Seems like there's someting wrong ,Enter again" /* EN */ , "好像出错了,请重输入一个坐标" /* CH */ };
    public static final String[] sayGoodBye = {"Good Bye" /* EN */ , "再见" /* CH */};
}