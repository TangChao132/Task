package game;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Operation {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        Hero h = new Hero();
        System.out.println("输入玩家姓名：");
        h.setMame(sc.nextLine());
        System.out.println("输入玩家HP(1~999)：");
        h.setHp(sc.nextInt());
        System.out.println("输入玩家攻击力(1~999)：");
        h.setAttackprow(sc.nextInt());
        System.out.println("输入玩家防御力(1~999):");
        h.setDefenceprow(sc.nextInt());
        System.out.println("----------------------------------");
        ArrayList<Soldier> arr = new ArrayList<>();
        Soldier s1 = new Soldier();
        printsoldier(s1);
        System.out.println("玩家信息：");
        h.show();
        System.out.println("小兵信息：");
        s1.show();
        int lim = h.getHp();//lim为玩家血量上线
        int t = 0;//t为玩家复活次数
        System.out.println("———————————————开始战斗———————————————");
        while (true) {
            if (t == 1) {
                Weapon w1 = new WeaponZi();
                System.out.println("恭喜你获得了复活奖励！");
                System.out.println("你获得了盾牌");
                w1.weapon1(h);

            } else if (t == 3) {
                Weapon w2 = new WeaponZi();
                System.out.println("玩家被杀死" + t + "次，获得成就：菜狗");
                System.out.println("玩家获得了彩虹猫之剑");
                System.out.println("—⊱═════> ");
                w2.weapon2(h);
            } else if (t == 6) {
                System.out.println("这都能输？退游吧。");
                System.out.println("因为玩家太菜，系统自动退出————————————-------");
                return;
            }
            System.out.println("玩家回合：");
            System.out.println("选择你的行动：");

            System.out.println("1.普通攻击 2.技能攻击 3.加血 4.逃跑");
            switch (sc.nextInt()) {
                case 1:
                    //把伤害看作整数，差了零点几不影响游戏体验
                    int i = r.nextInt(10) + 1;//随机1~10之间的整数
                    if (i <= 2) {
                        System.out.println(h.getMame() + "使用了普通攻击");
                        System.out.println(s1.getMame() + "躲避了攻击");
                    } else {
                        int playattack = h.getDefenceprow() * (h.getAttackprow() / s1.getDefenceprow());
                        s1.changeHp(s1.getHp() - playattack);
                        System.out.println(h.getMame() + "使用普通攻击对" + s1.getMame() + "造成了" + playattack + "点伤害");
                    }
                    break;
                case 2:
                    int plaryskill = h.getAttackprow() + h.getDefenceprow() * (h.getAttackprow() / s1.getDefenceprow());
                    s1.changeHp(s1.getHp() - plaryskill);
                    System.out.println(h.getMame() + "使用技能对" + s1.getMame() + "造成了" + plaryskill + "点伤害");
                    break;
                case 3:
                    int blood = h.getHp() / 5;
                    h.changeHp(h.getHp() + blood);
                    if (h.getHp() > lim) {
                        h.changeHp(lim);
                    }
                    System.out.println(h.getMame() + "对自己使用了治疗回复了" + blood + "点血");
                    break;
                case 4:
                    if (h.getHp() >= s1.getHp()) {
                        System.out.println("逃跑失败！");
                    } else {
                        System.out.println("逃跑成功！");
                        return;
                    }
                    break;
            }
            if (s1.getHp() <= 0) {
                System.out.println("玩家获胜");
                if (t > 0) {
                    System.out.println("复活了" + t + "次" + "(好菜哟)");
                    t = 0;
                }
                return;
            }
            System.out.println("开始小兵的回合：");
            int s = r.nextInt(10) + 1;
            if (s <= 2) {
                System.out.println(s1.getMame() + "使用了" + "普通攻击");
                System.out.println(h.getMame() + "躲避了攻击");
            } else if (s == 10) {
                int soldierattack1 = s1.getAttackprow() + s1.getDefenceprow() * (s1.getAttackprow() / h.getDefenceprow());
                h.changeHp(h.getHp() - soldierattack1);
                System.out.println(s1.getMame() + "打出了致命一击对" + h.getMame() + "造成" + soldierattack1 + "点伤害");
            } else {
                int soldierattack1 = s1.getDefenceprow() * (s1.getAttackprow() / h.getDefenceprow());
                h.changeHp(h.getHp() - soldierattack1);
                System.out.println(s1.getMame() + "使用普通攻击对" + h.getMame() + "造成" + soldierattack1 + "点伤害");
            }
            if (h.getHp()>0){
                Beatback bb=new BeatbackZi();
                bb.beatback(h,s1);
            }
            if (h.getHp() <= 0) {
                System.out.println("你(玩家)已经输了，是否复活？");
                System.out.println("yes  我要复活  /  no  我不活了");
                while (true) {
                    String S = sc.nextLine();
                    System.out.println("---------------");
                    if (S.equals("yes")) {
                        h.setHp(lim);
                        t++;
                        break;
                    } else if (S.equals("no")) {
                        System.out.println("小兵获胜");
                        t = 0;
                        return;
                    } else {
                        System.out.println("注：应输入 yes/no");
                    }

                }
            }
            h.show();
            System.out.println("---------------------");
            s1.show();
        }
    }

    public static void printsoldier(Soldier s) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入小兵的姓名");
        s.setMame(sc.nextLine());
        while (true) {
            System.out.println("是否自定义小兵的属性？yes/no");
            String r = sc.nextLine();
            if (r.equals("yes")) {
                System.out.println("输入小兵HP(1~999)：");
                s.setHp(sc.nextInt());
                System.out.println("输入小兵攻击力(1~999)：");
                s.setAttackprow(sc.nextInt());
                System.out.println("输入小兵防御力(1~999):");
                s.setDefenceprow(sc.nextInt());
                break;
            } else if (r.equals("no")) {
                Random ra = new Random();
                s.setHp(ra.nextInt(999) + 1);
                s.setAttackprow(ra.nextInt(999) + 1);
                s.setDefenceprow(ra.nextInt(999) + 1);
                break;
            } else {
                System.out.println("你输入错误，应输入yes/no");
            }

        }

    }
}

