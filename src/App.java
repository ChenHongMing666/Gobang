import java.util.Scanner;
import ChessMap.ChessMap;

public class App {
    public static void main(String[] args) throws Exception {
        int a = input("your age:");
        System.out.print(a);
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

}