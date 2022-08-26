package chapter8;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.Attributes.Name;

/**
 * 数字的顺序（大至小）为： A，K，Q，J，10，9，8，7，6，5，4，3，2。 [1]
 * （Ace可以当最大亦可当最小，例如说作为顺子时当拥有A K Q J 10时，A为最大，
 * 但在德州玩法中如果是5 4 3 2 A则这副牌中最大的是5，最小的则是A作为一点。） [1]
 * 花色的顺序（大至小）为： 花色 黑桃 > 红心 > 梅花 > 方块，
 * 有些地方大小顺序是黑桃 > 红心 > 方块 > 梅花 [台湾玩法，桥牌花色亦同]，各地略有不同,
 * 因此部份扑克游戏（如德州扑克）中花色是不分大小的。
 * 此类组合牌型也运用到另一种牌类游戏“大老二”上面，
 * 除了花色不同（黑桃>红心>方块>梅花）和大小不同（以二为最大，接下去大小为A、K、Q、J.....以此类推）之外，
 * 玩法几乎雷同。
 */

class MyComparator implements Comparator
{
    @Override
    public int compare(Object o1,Object o2){
        String str1 = (String) o1;
        String str2 = (String) o2;
        int num1 = 0;
        int num2 = 0;
       switch(str1.substring(2)){
        case "8":
            num1 +=100;
            break;
        case "9":
            num1 += 200;
            break;
        case "10":
            num1 += 300;
            break;
        case "J":
            num1 += 400;
            break;
        case "Q":
            num1+= 500;
            break;
        case "K":
            num1+=600;
            break;
        case "A":
            num1+=700;
            break;
       }
       switch(str2.substring(2)){
        case "8":
            num2 +=100;
            break;
        case "9":
            num2 += 200;
            break;
        case "10":
            num2 += 300;
            break;
        case "J":
            num2 += 400;
            break;
        case "Q":
            num2+= 500;
            break;
        case "K":
            num2+=600;
            break;
        case "A":
            num2+=700;
            break;
       }
       switch(str1.substring(0, 2)){
        case "方块" :
            num1 += 10;
            break;
        case "草花":
            num1 += 20;
            break;
        case "红桃":
            num1 += 30;
            break;
        case "黑桃":
            num1 += 40;
            break;
       }

       switch(str2.substring(0, 2)){
        case "方块" :
            num2 += 10;
            break;
        case "草花":
            num2 += 20;
            break;
        case "红桃":
            num2 += 30;
            break;
        case "黑桃":
            num2 += 40;
            break;
       }
       return num1-num2;
    }
}

public class ShowHand {
    // 定义该游戏最多支持几个玩家
    private final int PLAY_NUM = 5;
    // 定义扑克牌的所有花色和数值
    private String[] types = { "方块", "草花", "红心", "黑桃" };
    private String[] values = { "8", "9", "10", "J", "Q", "K", "A" };
    // cards是一局游戏中剩下的扑克牌
    private LinkedList<String> cards = new LinkedList<>();
    // 定义所有的玩家
    private Player[] players = new Player[PLAY_NUM];
    // 所有玩家手上的扑克牌
    private List<String>[] playersCards = new List[PLAY_NUM];

    /**
     * 创建一个玩家内部类，保存每个玩家信息
     */

    class Player {
        private String name;
        // 定义这个牌的等级
        private int level;
        private boolean status;
        private int cardNum;

        public Player(String name) {
            this.name = name;
            status = true;
            cardNum = 0;
        }

        public void cardNumAdd() {
            if (cardNum <= 5) {
                this.cardNum++;
                return;
            }
            System.out.println("已达手牌上限");
            return;

        }

        /**
         * 表示玩家退出下注
         */
        public void outStatus() {
            this.status = false;
        }
        public boolean getStatus(){
            return this.status;
        }
        public String getName() {
            return name;
        }

        public boolean equalsStr(String str) {
            if (this.name == str) {
                return true;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj.getClass() == Player.class) {
                Player op = (Player) obj;
                if (op.name == this.name) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 
         * @return 等级值
         */
        public int getLevel() {
            return level;
        }

        /**
         * 设置该牌的等级
         * 
         * @param level 牌的等级
         */
        public void addLevel(int add) {
            this.level += add;
        }
        

        /**
         * 输出玩家的所有手牌，包括他的底牌
         * @param i 是玩家在player中的位置
         */
        public void showPlayerAll(int i) {

            // 输出玩家
            System.out.println(this.getName() + ":");
            // 遍历输出玩家的所有手牌
            for (var card : playersCards[i]) {
                System.out.print(card + "\t");
            }

            System.out.println("\n");
        }

    }

    /**
     * 初始化扑克牌，放入52张扑克牌
     * 并且使用shuffle方法将它们按随机顺序排列
     */
    public void initCards() {
        for (var i = 0; i < types.length; i++) {
            for (var j = 0; j < values.length; j++) {
                cards.add(types[i] + values[j]);
            }
        }
        // 随机排列
        Collections.shuffle(cards);
    }

    /**
     * 初始化玩家，为每个玩家分派用户名
     */
    public void initPlayer(String... names) {
        if (names.length > PLAY_NUM || names.length < 2) {
            // 校验玩家数量，此处用异常机制更合理
            System.out.println("玩家数量不对");
            return;
        } else {
            // 初始化玩家姓名
            for (var i = 0; i < names.length; i++) {
                players[i] = new Player(names[i]);
            }
        }
    }

    /**
     * 初始化玩家手上的扑克牌，开始时每个玩家手上的扑克牌为空
     * 程序使用一个长度为0的LinkedList来表示
     */
    public void initPlayerCards() {
        for (var i = 0; i < players.length; i++) {
            if (players[i] != null) {
                playersCards[i] = new LinkedList<String>();
            }
        }
    }

    /**
     * 输出全部的扑克牌
     * 该方法没有实际作用，仅用作测试
     */
    public void showAllCards() {
        for (var card : cards) {
            System.out.println(card);
        }
    }

    /**
     * 派扑克牌
     * 
     * @param first 最先派给谁
     */
    public void deliverCard(String first) {
        // 调用ArrayUtils工具类的search方法
        // 查询出指定元素在数组中的索引
        int firstPos = ArrayUtils.search(players, first);
        // 依次给位于该指定玩家之后的每个玩家派扑克牌
        for (var i = firstPos; i < PLAY_NUM; i++) {
            if (players[i] != null) {
                // playersCards[i].add(cards.get(0));
                // cards.remove(0);
                playersCards[i].add(cards.pollFirst());
                players[i].cardNumAdd();
            }
        }
        // 依次给位于该玩家之前的每个玩家派扑克牌
        for (var i = 0; i < firstPos; i++) {
            if (players[i] != null) {
                // playersCards[i].add(cards.get(0));
                // cards.remove(0);
                playersCards[i].add(cards.pollFirst());
                players[i].cardNumAdd();// 手牌数量增加计数
            }
        }
    }

    /**
     * 输出玩家手上的扑克牌
     * 实现该方法时，应该控制每个玩家看不到别人的第一张牌，但此处没有增加该功能
     */
    /**
     * 现在增加该功能
     */
    public void showPlayerCards() {
        for (var i = 0; i < PLAY_NUM; i++) {
            // 当玩家不为空时
            if (players[i] != null) {
                // 输出玩家
                System.out.println(players[i].getName() + ":");
                // 遍历输出玩家手上的扑克牌
                // 但要跳过第一张牌
                Iterator<String> it = playersCards[i].iterator();
                // for(var card:playersCards[i]){
                // System.out.print(card+"\t");
                // }
                // 跳过第一个
                if (it.hasNext()) {
                    it.next();
                }
                while (it.hasNext()) {
                    System.out.println(it.next() + "\t");
                }
            }
            System.out.println("\n");
        }
    }

    public void showPlayerHide(String name){
        for(int i=0;i<PLAY_NUM;i++){
            if(players[i]!=null&&players[i].equalsStr(name)){
                players[i].showPlayerAll(i);
            }
        }
    }

    /**
     * 规则：
     * 2、先发给各家一张底牌，底牌除本人外，要到决胜负时才可翻开。
    3、从发第二张牌开始，每发一张牌，以牌面发展最佳者为优先，进行下注。
    4、有人下注，想继续玩下去的人，要按“跟注”键，跟注后会下注到和上家相同的筹码，或可选择加注。根据房间的设定，可以在特定的时间选择“梭”，梭哈是加入桌面允许的最大下注。
    5、各家如果觉得自己的牌况不妙，不想继续，可以按“放弃”键放弃下注，先前跟过的筹码，亦无法取回。
    6、牌面最大的人可赢得桌面所有的筹码。当多家放弃，已经下的注不能收回，并且赢家的底牌不掀开。
    7、纸牌种类：港式五张牌游戏用的是扑克牌，取各门花色的牌中的“8、9、10、J、Q、K、A”，共28张牌。
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * @return
     */

    

    // public int checkCards() {
    //     for(var i=0;i<PLAY_NUM;i++){
    //         if(players[i]!=null&&players[i].status){
    //             Collections.sort(playersCards[i],new MyComparator());
    //             // //先找顺子
    //             // Iterator<String> it = playersCards[i].iterator();
               
    //             // while(it.hasNext()){
    //             //     String now = it.next();
    //             //     if(now!=it.next()){
    //             //         players[i].addLevel(-80);
    //             //         break;
    //             //     }
    //             // }
    //             // players[i].addLevel(80);
    //             //再找对子
    //             int count = 0;
    //             Iterator<String> it = playersCards[i].iterator();
    //             while(it.hasNext()){
    //                 String now = it.next();
    //                 if(now==it.next()){
    //                     count++;
    //                 }
    //             }

    //         }
    //     }
    // }



    
    public static void main(String[] args) {
        var sh = new ShowHand();
        sh.initPlayer("电脑玩家", "孙悟空");
        sh.initCards();
        sh.initPlayerCards();
        // 下面测试所有扑克牌，没有实际作用
        sh.showAllCards();
        sh.showPlayerCards();
        System.out.println("-----------");
        // 下面从孙悟空开始派牌
        sh.deliverCard("孙悟空");
        sh.showPlayerCards();
        /**
         * 这个地方需要增加处理：
         * 1、牌面最大的玩家下注
         * 2、其它玩家是否跟注
         * 3、游戏是否只剩一个玩家？如果是，则他胜利了
         * 4、如果已经时最后一张扑克牌，则需要比较剩下玩家的牌面大小
         */
        // 再次从：电脑玩家开始派牌
        sh.deliverCard("电脑玩家");
        sh.showPlayerCards();
        sh.showPlayerHide("电脑玩家");
    }
}
