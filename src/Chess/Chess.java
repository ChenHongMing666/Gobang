package Chess;

import java.util.Arrays;

public class Chess {

    public int[] posion;

    public char whoes;

    /**
     * @param pos   棋子坐标 [x , y]
     * @param whoes 落子者，r为红方（玩家a） b为蓝方（玩家b/电脑）
     */
    public Chess(int[] pos, char whoes) {
        this.posion = pos;
        this.whoes = whoes;
    }

    /**
     * @return 返回棋子坐标 [x , y]
     */
    public int[] getPosion() {
        return this.posion;
    }

    /**
     * @return 落子者，r为红方（玩家a） b为蓝方（玩家b/电脑）
     */
    public char getWhose() {
        return this.whoes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Chess [posion=" + Arrays.toString(posion) + ", whoes=" + whoes + "]";
    }

}
