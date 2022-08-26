package chapter11;

import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 还要完成对于重玩的选择
 * 悔棋
 */

public class Gobang {
    // 下面三个位图分别代表棋盘、黑子、白子
    BufferedImage table;
    BufferedImage black;
    BufferedImage white;
    // 当鼠标移动时的选择框
    BufferedImage selected;
    // 定义棋盘的大小
    private static int BOARD_SIZE = 15;
    // 定义棋盘的宽、高多少个像素
    private final int TABLE_WIDTH = 535;
    private final int TABLE_HEIGHT = 536;
    // 定义棋盘坐标的像素值和棋盘数组之间的比率,也就每个点实际上占几个像素位
    private final int RATE = TABLE_WIDTH / BOARD_SIZE;
    // 定义棋盘坐标的像素值和棋盘数组之间的偏移距离
    private final int X_OFFSET = 5;
    private final int Y_OFFSET = 6;
    // 定义一个二维数组来充当棋盘
    private String[][] board = new String[BOARD_SIZE][BOARD_SIZE];
    // 五子棋游戏的窗口
    JFrame f = new JFrame("五子棋游戏");
    // 五子棋游戏棋盘对应的Canvas组件
    ChessBoard chessBoard = new ChessBoard();
    // 设置放置表情、重来、悔棋按钮的panel
    JPanel p = new JPanel();
    // 设置重来、悔棋按钮
    JButton renew = new JButton("重来");
    JButton undo = new JButton("悔棋");
    // 设置选中皮肤按钮
    JButton player1Cover = new JButton("黑子玩家皮肤");
    JButton player2Cover = new JButton("白子玩家皮肤");
    JButton player1 = new JButton("玩家一");
    JButton player2 = new JButton("玩家二");
    // 设置玩家皮肤
    private ImageIcon icon1;
    private ImageIcon icon2;
    private int size = 50;
    // 判断是否退出游戏,true就是退出
    private static boolean quit = false;
    // 玩家选择棋子皮肤
    private String player1Str = "image/black1.png";
    private String player2Str = "image/white1.png";
    // 创建两个文件对话框
    FileDialog d = new FileDialog(f, "选择需要打开的文件", FileDialog.LOAD);

    // 记录上一次的棋子坐标，方便撤回
    int pre_x = -1;
    int pre_y = -1;

    // 当前选中点的坐标
    private int selectedX = -1;
    private int selectedY = -1;
    // 下棋顺序,true为黑，flase为白
    private boolean turn = true;

    public void init() throws Exception {
        // 设置Jframe的窗口监听器
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // 设置按钮布局
        p.setLayout(new GridLayout(3, 2, 10, 10));
        // 为重来、悔棋设置事件监听器
        renew.addActionListener(e -> {
            try {
                new Gobang().init();
            } catch (Exception e1) {
                return;
            }
        });
        undo.addActionListener(e -> {
            if (pre_x >= 0 && pre_y >= 0) {
                board[pre_x][pre_y] = "十";
                turn = !turn;
                chessBoard.repaint();
            }
        });
        // 选玩家一皮肤的事件监听器
        player1Cover.addActionListener(e -> {
            d.setVisible(true);
            // 将地址给到玩家1黑子
            var str = d.getDirectory() + d.getFile();
            if (str.matches(".+\\.(jpg|png|gif)$")) {
                player1Str = str;
                try {
                    black = ImageIO.read(new File(player1Str));
                    icon1 = new ImageIcon(player1Str);
                    Image temp1 = icon1.getImage().getScaledInstance(size, size,
                            Image.SCALE_DEFAULT);
                    icon1 = new ImageIcon(temp1);
                    player1.setIcon(icon1);
                    chessBoard.repaint();
                } catch (Exception e1) {

                }
                System.out.println("匹配上了");
            }
        });
        // 选玩家二皮肤的事件监听器
        player2Cover.addActionListener(e -> {
            d.setVisible(true);
            // 将地址给到玩家2白子
            var str = d.getDirectory() + d.getFile();
            if (str.matches(".+\\.(jpg|png|gif)$")) {
                player2Str = str;
                try {
                    white = ImageIO.read(new File(player2Str));
                    icon2 = new ImageIcon(player2Str);
                    Image temp2 = icon2.getImage().getScaledInstance(size, size,
                            Image.SCALE_DEFAULT);
                    icon2 = new ImageIcon(temp2);
                    player2.setIcon(icon2);
                    chessBoard.repaint();
                } catch (Exception e1) {

                }
                System.out.println("匹配上了");
            }
        });
        // // player1.setPreferredSize(new Dimension(50,50));
        // // player2.setPreferredSize(new Dimension(50,50));
        // player1.setSize(100, 100);
        // player2.setSize(100, 100);
        // 初始化Icon
        icon1 = new ImageIcon(player1Str);
        icon2 = new ImageIcon(player2Str);
        Image temp1 = icon1.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT);
        Image temp2 = icon2.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT);
        icon1 = new ImageIcon(temp1);
        icon2 = new ImageIcon(temp2);
        player1.setIcon(icon1);
        player2.setIcon(icon2);

        // 加入按钮
        p.add(undo);
        p.add(renew);
        p.add(player1Cover);
        p.add(player2Cover);
        p.add(player1);
        p.add(player2);

        table = ImageIO.read(new File("image/board.jpg"));
        black = ImageIO.read(new File(player1Str));
        white = ImageIO.read(new File(player2Str));
        selected = ImageIO.read(new File("image/selected.gif"));

        // 把每个元素赋为“十”，“十”代表没有棋子
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = "十";
            }
        }
        chessBoard.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        chessBoard.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                var xPos = (int) ((e.getX() - X_OFFSET) / RATE);
                var yPos = (int) ((e.getY() - Y_OFFSET) / RATE);
                if (xPos <= BOARD_SIZE && yPos <= BOARD_SIZE && board[xPos][yPos].equals("十")) {

                    if (turn) {
                        // 将用户鼠标事件的坐标转换成棋子数组的坐标
                        board[xPos][yPos] = "黑";
                        pre_x = xPos;
                        pre_y = yPos;
                        turn = false;
                    } else {
                        board[xPos][yPos] = "白";
                        pre_x = xPos;
                        pre_y = yPos;
                        turn = true;

                    }

                    chessBoard.repaint();
                }
            }

            // 当鼠标退出棋盘区后，复位选中点坐标
            public void mouseExited(MouseEvent e) {
                selectedX = -1;
                selectedY = -1;
                chessBoard.repaint();
            }
        });
        chessBoard.addMouseMotionListener(new MouseMotionAdapter() {
            // 当鼠标移动时，改变选中点的坐标
            public void mouseMoved(MouseEvent e) {
                selectedX = (e.getX() - X_OFFSET) / RATE;
                selectedY = (e.getY() - Y_OFFSET) / RATE;
                chessBoard.repaint();
            }
        });
        f.add(chessBoard);
        f.add(p, BorderLayout.EAST);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        do {
            new Gobang().init();
        } while (quit);
        System.out.println("结束了");
    }

    // 检测有无一方获胜
    /**
     * 思路：
     * 对每一行进行遍历，遇到有子的就开始比较判断,从四个方向判断：横、竖、左斜、右斜
     * 
     * @return 是否获胜
     * @param chess:是去判断哪类棋子是否获胜了
     * @param wz:对应的棋盘
     */
    public boolean Check_board(String chess) {
        // 记录有几个连子
        int count = 1;
        // 先遍历找有这个chess的
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                // 说明找到了一个棋子，开始要进入判断了
                if (board[i][j] == chess) {
                    // 不能改变j、i的值，去向右查找时要用temp1、向下temp2
                    // 而且每次使用temp时都要归位
                    int temp1 = j;
                    int temp2 = i;

                    // 横方向，因为我是从左到右从上到下去遍历的，所以只用向右边去检测就可以
                    // 首先此时j要离边界有5格，然后再去横向索引判断
                    if ((BOARD_SIZE - 1) - j + 1 >= 5) {
                        while (board[i][++temp1] == chess) {
                            count++;
                            // count代表了有多少是连着的
                            if (count >= 5) {
                                return true;
                            }
                        }
                    }
                    // count 归零,temp归位
                    count = 1;
                    temp1 = j;
                    temp2 = i;

                    // 竖方向，与横类似
                    // 首先此时i要离边界有5格，然后向下去检测
                    if ((BOARD_SIZE - 1) - i + 1 >= 5) {
                        while (board[++temp2][j] == chess) {
                            count++;
                            if (count >= 5) {
                                return true;
                            }
                        }
                    }
                    count = 1;
                    temp1 = j;
                    temp2 = i;
                    // 左斜方向
                    // 应该是向右下去探索，即i++,j++往右下走
                    // 同样首先一定有往下能有5格，往右能有5格
                    if ((BOARD_SIZE - 1) - j + 1 >= 5 && (BOARD_SIZE - 1) - i + 1 >= 5) {
                        while (board[++temp2][++temp1] == chess) {
                            count++;
                            if (count >= 5) {
                                return true;
                            }
                        }
                    }
                    count = 1;
                    temp1 = j;
                    temp2 = i;
                    // 右斜方向
                    // 应该是向左探向下探，即i++,j--往左下走
                    if ((BOARD_SIZE - 1) - i + 1 >= 5 && j + 1 >= 5) {
                        while (board[++temp2][--temp1] == chess) {
                            count++;
                            if (count >= 5) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    class ChessBoard extends JPanel {
        // 重写JPanel的paint方法，实现绘画
        public void paint(Graphics g) {
            // try {
            // black = ImageIO.read(new File(player1Str));
            // white = ImageIO.read(new File(player2Str));
            // } catch (Exception e) {
            // return;
            // }
            // 绘制五子棋棋盘
            g.drawImage(table, 0, 0, null);
            // //
            // // 落完子判断胜负
            // if (Check_board("白")) {
            // g.setColor(new Color(255,0,0));
            // g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            // g.drawString("白色赢了", 100, 250);
            // }
            // else if(Check_board("黑")){
            // g.setColor(new Color(255,0,0));
            // g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            // g.drawString("黑色赢了", 100, 250);
            // }

            // 绘制选中点的红框
            if (selectedX >= 0 && selectedY >= 0) {
                g.drawImage(selected, selectedX * RATE + X_OFFSET, selectedY * RATE + Y_OFFSET, null);
            }
            // 遍历数组，绘制棋子
            for (var i = 0; i < BOARD_SIZE; i++) {
                // 绘制黑棋
                for (var j = 0; j < BOARD_SIZE; j++) {
                    // 绘制黑棋
                    if (board[i][j].equals("黑")) {
                        g.drawImage(black, i * RATE + X_OFFSET, j * RATE + Y_OFFSET, 30, 30, null);
                    }
                    // 绘制白棋
                    if (board[i][j].equals("白")) {
                        g.drawImage(white, i * RATE + X_OFFSET, j * RATE + Y_OFFSET, 30, 30, null);
                    }
                }
            }
            //
            // 落完子判断胜负
            if (Check_board("白")) {
                g.setColor(new Color(255, 0, 0));
                g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                g.drawString("白色赢了", 100, 250);
            } else if (Check_board("黑")) {
                g.setColor(new Color(255, 0, 0));
                g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                g.drawString("黑色赢了", 100, 250);
            }

        }
    }

}
