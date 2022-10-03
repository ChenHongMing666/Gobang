import java.util.Scanner;
import ChessMap.ChessMap;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        ChessMap map = new ChessMap(10);
        boolean Flag = true ;

        print("===Wellcome to Gobang Game !===\n");

        for (int i = 3 ; i >= 0 ; i -- ){
            print( "\t" , i , "\r");
            TimeUnit.SECONDS.sleep(1);
        }

        while( Flag ) {

        }
    }

    /**
     * @param prompt 输出一个字符串为提示
     * @return 返回输入的Int数据
     */
    public static int input(String prompt) {
        int temp;
        System.out.print(prompt);

        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNext()) {
                temp = scanner.nextInt();
            } else {
                temp = -2147483648;
            }
        }

        return temp;
    }

    public static void print(Object...args){
        for (Object string : args) {
            System.out.print(string);
        }
    }

}