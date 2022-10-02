package ChessMap;

import Chess.Chess;

public class ChessMap {

    public Object[][] map;
    public int size;

    /**
     * @return 返回一个二维数组为棋盘
     */
    public Object[][] getMap() {
        return map;
    }

    /**
     * 把map中的每一项设为0
     */
    public void setUpMap() {
        for (int line = 0; line < this.map.length; line++) {
            for (int row = 0; row < this.map.length; row++) {
                this.map[line][row] = 0;
            }
        }
    }

    /**
     * 以字符方阵输出棋盘 （可作为前期的交互界面）
     */
    public void mapOut() {
        for (Object[] objects : map) {
            for (Object object : objects) {
                System.out.print(object);
            }
            System.out.println();
        }
    }

    /**
     * @param size 地图大小
     */
    public ChessMap(int size) {
        this.size = size;
        this.map = new Object[size][size];
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

        int[] pos = { x, y };
        Chess newChess = new Chess(pos, who);
        map[y][x] = newChess;

        return true;
    }

}