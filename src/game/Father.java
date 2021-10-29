package game;

import java.util.Scanner;

public class Father {
    String mame;
    private int hp;
    private int attackprow;
    private int defenceprow;

    public void setMame(String name) {
        this.mame = name;
    }

    public String getMame() {
        return mame;
    }

    public void setHp(int hp) {
        while (true) {

            if (1 <= hp && hp <= 999) {
                this.hp = hp;
                break;
            } else {

                this.hp = reHp();
                break;
            }
        }
    }

    public int reHp() {
        int h=0;
        while (h<1||h>999) {
            System.out.println("你输入的血量应在1~999之间");
            Scanner sc = new Scanner(System.in);
            h = sc.nextInt();
        }
        return h;
    }

    public int getHp() {
        return hp;
    }

    public void setAttackprow(int attackprow) {
        while (true) {
            if (1 <= attackprow && attackprow <= 999) {
                this.attackprow = attackprow;
                break;
            } else {
                this.attackprow=reAttackprow();
                break;
            }
        }

    }


    public int reAttackprow() {
        int a=0;
        while (a<1||a>999){
            System.out.println("你输入的攻击力应该在1~999之间");
        Scanner sc = new Scanner(System.in);
         a = sc.nextInt();
        }
        return a;
    }

    public int getAttackprow() {
        return attackprow;
    }

    public void setDefenceprow(int defenceprow) {
        while (true) {
            if (1<=defenceprow&&defenceprow<=999){
            this.defenceprow = defenceprow;
            break;
        }else {
                this.attackprow=reDefenceprow();
                break;
            }
        }

    }
    public int reDefenceprow(){
        int d=0;
        while (d<1||d>999) {
            System.out.println("你输入的防御力应为1~999");
            Scanner sc = new Scanner(System.in);
            d = sc.nextInt();
        }
        return d;
    }


    public int getDefenceprow() {
        return defenceprow;
    }

    public void changeHp(int hp) {
        this.hp = hp;
    }


}
