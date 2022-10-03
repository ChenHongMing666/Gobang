package ChessMap;

import Chess.Chess;

public class ChessMap {

    public  static Chess[][] map;
    public int size;

    /**
     * @return 返回一个二维数组为棋盘
     */
    public Chess[][] getMap() {
        return map;
    }

    /**
     * 把map中的每一项设为0
     */
    public void setUpMap() {
        for (int line = 0; line < map.length; line++) {
            for (int row = 0; row < map.length; row++) {
                int temp[] = {row , line} ;
                map[line][row] = new Chess( temp , 'n');
            }
        }
    }

    /**
     * 以字符方阵输出棋盘 （可作为前期的交互界面）
     */
    public void mapOut() {
        for (Chess[] objects : map) {
            for (Chess object : objects) {
                System.out.print(toChess(object));
            }
            System.out.println();
        }
    }

    /**
     * @param size 地图大小
     */
    public ChessMap(int size) {
        this.size = size;
        map = new Chess[size][size];
        setUpMap();
    }

    /**
     * @param x   平面直角坐标系的x坐标
     * @param y   平面直角坐标系的y坐标
     * @param who 落子者，r为红方（玩家a） b为蓝方（玩家b/电脑）
     * @return 落子操作是否成功
     */
    public boolean downChess(int x, int y, char who) {
        if (!(x <= size - 1 && y <= size - 1)) {
            return false;
        }

        if (map[y][x].whoes != 'n' ){
            return false ;
        }

        int[] pos = { x, y };
        Chess newChess = new Chess(pos, who);
        map[y][x] = newChess;

        return true;
    }

    /**
     * @param aChess 当前位置的棋子
     * @return 返回棋子相应的样式
     */
    public static char toChess(Chess aChess){
        switch (aChess.whoes){
            case 'n' :
                return '□';
            case 'r' :
                return '●';
            case 'b' :
                return '○';
            
            default :
                return ' ' ;
        }
    }

    // public static boolean isRedWin(){
    //     for (Chess[] line : map ){
    //         for (Chess chess : line) {
    //             if(chess.whoes == 'n' && chess.whoes == 'b'){
    //                 continue ;
    //             }
    //         }
    //     }
    // }

    // public static int deepFirstSearch(char searchWho ){

    // }

}