package chapter11;

import java.awt.Canvas;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;
import javax.swing.Timer;

public class PinBall {
    // 球拍的速度
    private final int RACKET_SPEED = 40;
    // 桌面的宽带
    private final int TABLE_WIDTH = 600;
    // 桌面的高度
    private final int TABLE_HEIGHT = 1000;
    // 球拍的垂直位置,这里设置两个玩家
    private final int RACKET_Y = 600;
    private final int RACKET2_Y = 150;
    // 下面定义球拍的高度和宽度
    private final int RACKET_HEIGHT = 10;
    private final int RACKET_WIDTH = 100;
    // 小球的大小
    private final int BALL_SIZE = 15;
    private Frame f = new Frame("小球弹弹弹");
    Random rand = new Random();
    // 小球纵向的运行速度
    private int ySpeed = 20;
    // 返回一个-0.5~0.5的比率，用于控制小球的运行方向
    private double xyRate = rand.nextDouble() - 0.5;
    // 小球横向运行的速度
    private int xSpeed = (int) (ySpeed * xyRate * 2);
    // ballx和ballY代表小球额坐标
    private int ballX = rand.nextInt(200) + 20;
    private int ballY = rand.nextInt(10) + 200;
    // racketX代表球拍的水平位置,这里引入两个玩家
    private int racketX = rand.nextInt(400);
    private int racket2X = rand.nextInt(400);
    private MyCanvas tableArea = new MyCanvas();
    // 游戏是否结束的旗帜,0是正常，1是上面输，2是下面输
    private int isLose = 0;
    Timer timer;
    // // 设置开始按钮
    // Button begin = new Button("开始游戏");
    // // 设置重来按钮
    // Button renew = new Button("重新开始");

    public void init() {
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        tableArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        // renew.setPreferredSize(new Dimension(100, 100));
        // renew.addActionListener(e -> {
        //     // ballx和ballY代表小球的坐标
        //     ballX = rand.nextInt(200) + 20;
        //     ballY = rand.nextInt(10) + 200;
        //     isLose = 0;
        //     timer.stop();
        //     this.init();
        // });
        // 设置桌面区域的最佳大小
        f.add(tableArea, BorderLayout.CENTER);
        // f.add(renew, BorderLayout.SOUTH);
        // System.out.println("我加入了renew按钮哦");
         // 定义键盘监听器

         var keyProcessor = new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                // 按下向左、向右建时，球拍水平坐标分别减少、增加
                if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (racketX > 0) {
                        racketX -= RACKET_SPEED;

                    }
                }
                if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (racketX < TABLE_WIDTH - RACKET_WIDTH) {
                        racketX += RACKET_SPEED;
                    }
                }
                // 按下向A、向D建时，球拍水平坐标分别减少、增加
                if (ke.getKeyCode() == KeyEvent.VK_A) {
                    if (racket2X > 0) {
                        racket2X -= RACKET_SPEED;
                    }
                }
                if (ke.getKeyCode() == KeyEvent.VK_D) {
                    if (racket2X < TABLE_WIDTH - RACKET_WIDTH) {
                        racket2X += RACKET_SPEED;
                    }
                }
            }

        };

        // // 对于玩家2的监听
        // KeyListener keyProcessor2 = new KeyAdapter() {
        // public void keyPressed(KeyEvent ke) {
        // // 按下向A、向D建时，球拍水平坐标分别减少、增加
        // if (ke.getKeyCode() == KeyEvent.VK_1) {
        // if (racket2X > 0) {
        // racket2X -= 30;
        // }
        // }
        // if (ke.getKeyCode() == KeyEvent.VK_3) {
        // if (racket2X < TABLE_WIDTH - RACKET_WIDTH) {
        // racket2X += 30;
        // }
        // }
        // }

        // };
        // 为窗口和tableArea对象分别添加键盘监听器
        f.addKeyListener(keyProcessor);
        // f.addKeyListener(keyProcessor2);
        tableArea.addKeyListener(keyProcessor);
        // tableArea.addKeyListener(keyProcessor2);
        // 定义每0.05秒执行一次的事件监听器
        ActionListener taskPerformer = evt -> {
            // 如果小球碰到左右边边框
            if (ballX <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE) {
                xSpeed = -xSpeed;
            }
            // 如果小球超出了球拍位置，且横向不在球拍范围内，游戏结束，下面输
            if (ballY >= RACKET_Y - BALL_SIZE && (ballX < racketX - BALL_SIZE || ballX > racketX + RACKET_WIDTH)) {
                timer.stop();
                // 设置游戏是否结束的旗帜为true
                isLose = 2;
                tableArea.repaint();
            }
            // 如果小球位于球拍之内，且到达球拍位置，小球反弹
            if (ballY >= RACKET_Y - BALL_SIZE && ballX >= racketX - BALL_SIZE && ballX <= racketX + RACKET_WIDTH) {
                ySpeed = -ySpeed;
            }
            // 如果小球超出了球拍位置，且横向不在球拍范围内，游戏结束，上面输
            if (ballY <= RACKET2_Y + RACKET_HEIGHT
                    && (ballX < racket2X - BALL_SIZE || ballX > racket2X + RACKET_WIDTH)) {
                timer.stop();
                // 设置游戏是否结束的旗帜为true
                isLose = 1;
                tableArea.repaint();
            }
            // 如果小球位于球拍之内，且到达球拍位置，小球反弹
            if (ballY <= RACKET2_Y + RACKET_HEIGHT && ballX >= racket2X - BALL_SIZE
                    && ballX <= racket2X + RACKET_WIDTH) {
                ySpeed = -ySpeed;
            } // 小球坐标增加
            ballY += ySpeed;
            ballX += xSpeed;
            tableArea.repaint();
        };
        timer = new Timer(100, taskPerformer);
        timer.start();
        f.setBounds(30,30,1000,1000);
        f.setVisible(true);
    }

    class MyCanvas extends Canvas {
        // 重写Canvas的paint()方法,实现绘画
        public void paint(Graphics g) {
            // 如游戏已经结束
            if (isLose > 0) {
                g.setColor(new Color(255, 0, 0));
                g.setFont(new Font("Times", Font.BOLD, 30));
                if (isLose == 1) {
                    g.drawString("游戏结束,上面输", 50, 200);
                } else {
                    g.drawString("游戏结束,下面输", 50, 200);
                }
                timer.stop();
                // f.remove(tableArea);
            }
            // 如果游戏未结束
            else {
                // 设置颜色，并绘制小球
                g.setColor(new Color(240, 240, 80));
                g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
                // 设置颜色，并绘制球拍1
                g.setColor(new Color(80, 80, 200));
                g.fillRect(racketX, RACKET_Y, RACKET_WIDTH, RACKET_HEIGHT);
                // 设置颜色，并绘制球拍2
                g.setColor(new Color(100, 0, 0));
                g.fillRect(racket2X, RACKET2_Y, RACKET_WIDTH, RACKET_HEIGHT);
            }
        }
    }

    public static void main(String[] args) {
        new PinBall().init();;
    }

    // /*
    //  * 下面设置按钮进行开始和重来的设置
    //  */
    // public void GameBegin() {
        
       
    //     f.add(begin, BorderLayout.CENTER);
    //     f.setBounds(30, 30, 500, 500);
    //     f.setVisible(true);
    //     begin.addActionListener(e -> {
    //         f.remove(begin);
    //         this.init();
    //     });
    // }

}
