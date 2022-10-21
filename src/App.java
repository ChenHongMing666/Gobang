import java.util.Scanner;
import ChessMap.ChessMap;
import java.util.concurrent.TimeUnit;

import Chess.Chess;

public class App {
    public static boolean Flag = true ;
    public static ChessMap map = new ChessMap(10);

    /**
     * @param args 用不着
     * @throws Exception 也用不着
     * 
     * 程序的入口
     */
    public static void main(String[] args) throws Exception {

        print("===Wellcome to Gobang Game !===\n");

        for (int i = 3 ; i >= 0 ; i -- ){
            print(  i , "\r");
            TimeUnit.SECONDS.sleep(1);
        }
        char Iswin = map.isWin();
        while( Flag ) {
            Iswin = map.isWin();

            map.mapOut();
            getIn('r');

            if ( Iswin != 'n'){
                Flag = false ;
                print(Iswin);
                Flag = input("Exit(1/0)") == 0;
                map.setUpMap();
                Iswin = map.isWin();
                continue ;
            }

            map.mapOut();
            getIn('b');           

            if ( Iswin != 'n'){
                Flag = false ;
                print(Iswin);
                print("win");
                Flag = input("Exit(1/0)") == 0;
                map.setUpMap();
                Iswin = map.isWin();
                continue ;
            }

        }
    }

    /**
     * @param prompt 输出一个字符串为提示
     * @return 返回输入的Int数据
     * 类比 python 的 input
     */
    private static int input(String prompt) {
        int temp;
        print(prompt , ":");

        Scanner scanner = new Scanner(System.in) ;
        if (scanner.hasNext()) {
            temp = scanner.nextInt();
        } else {
            temp = -2147483647;
        }

        return temp;
    }

    /**
     * @param args 要打印的字符
     * 类比 python 的 print
     */
    private static void print(Object...args){
        for (Object string : args) {
            System.out.print(string);
        }
    }

    /**
     * @param who 落子者
     * 用来输入 x , y 坐标
     */
    public static void getIn( char who){

        if (! (map.downChess(input("your Chess's x"), input("your Chess's y"), who))){
            print("\033[31m" , "Seems like there's someting wrong ,Enter again\n" , "\033[m");
            getIn( who );
            return ;
        }  
        return ;
    }
    
}