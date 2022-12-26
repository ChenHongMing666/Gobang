import java.util.Scanner;
import ChessMap.ChessMap;
import java.util.concurrent.TimeUnit;
import java.lang.Runtime;

import settings.AppSettings;

public class App {
    public static boolean Flag = true;
    public static ChessMap map = new ChessMap(AppSettings.mapSize);
    public static int Languane = 0 ;

    /**
     * @param args 用不着;
     * @throws Exception 也用不着
     * 程序的入口
     */
    public static void main(String[] args) throws Exception {
        Languane = input("Languae:(0-EN/1-CH)");

        //get runtime
        Runtime rt = Runtime.getRuntime();

        // 输出title
        print("===", AppSettings.title[Languane] , "===\n");

        // 等待3秒
        for (int i = 3; i >= 0; i--) {
            print(i, "\r");
            TimeUnit.SECONDS.sleep(1);
        }

        // 变量初始化
        char Iswin = map.isWin();
        long startTime, endTime, usedTime;

        // 主循环
        while (Flag) {

            Iswin = map.isWin();

            /** 获取当前系统时间 */
            startTime = System.currentTimeMillis();

            // 输出地图，输入棋子坐标 IO
            map.mapOut();
            getIn('r');

            // 判断是否获胜
            if (Iswin != 'n') {
                Flag = false;
                print(Iswin);
                print(AppSettings.winPrommpt[Languane]);
                Flag = input(AppSettings.countinuePrompt[Languane]) == 0;
                map.setUpMap();
                Iswin = map.isWin();
                continue;
            }

            // 结束计时
            endTime = System.currentTimeMillis();
            usedTime = (endTime - startTime) / 1000;
            print(AppSettings.timeUsedPrompt[Languane][0], usedTime, AppSettings.timeUsedPrompt[Languane][1],"\n");
            startTime = System.currentTimeMillis();

            // 输出地图，输入棋子坐标 IO
            map.mapOut();
            getIn('b');

            // 判断是否获胜
            if (Iswin != 'n') {
                Flag = false;
                print(Iswin);
                print(AppSettings.winPrommpt[Languane]);
                Flag = input(AppSettings.countinuePrompt[Languane]) == 0;
                map.setUpMap();
                Iswin = map.isWin();
                continue;
            }

            /** 获取当前的系统时间，与初始时间相减就是程序运行的毫秒数，除以1000就是秒数 */
            endTime = System.currentTimeMillis();
            usedTime = (endTime - startTime) / 1000;
            print(AppSettings.timeUsedPrompt[Languane][0], usedTime, AppSettings.timeUsedPrompt[Languane][1],"\n");

        }
        print(AppSettings.sayGoodBye[Languane]);

        Runtime.getRuntime().exec("clear");
    }

    /**
     * @param prompt 输出一个字符串为提示
     * @return 返回输入的Int数据
     * 类比 python 的 input
     */
    private static int input(String prompt) {

        // 临时变量
        int temp;

        // 打印提示语
        print(prompt, ":");

        // 新建扫描器，输入
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            temp = scanner.nextInt();
        } else {
            temp = -2147483647;
        }

        return temp;
    }

    /**
     * @param args 要打印的字符
     *             类比 python 的 print
     */
    private static void print(Object... args) {
        for (Object string : args) {
            System.out.print(string);
        }
    }

    /**
     * @param who 落子者
     *            用来输入 x , y 坐标
     */
    public static void getIn(char who) {

        if (!(map.downChess(input(AppSettings.getInPrompt[Languane][0]), input(AppSettings.getInPrompt[Languane][0]), who))) {
            print("\033[31m", AppSettings.getInErrorPrompt[Languane], "\n", "\033[m");
            getIn(who);
            return;
        }
        return;
    }

}