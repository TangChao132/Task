package game;

public class WeaponZi implements Weapon{


    @Override
    public void weapon1(Hero h) {
        h.setDefenceprow(h.getDefenceprow()+50);
        h.setHp(h.getHp()+100);
        System.out.println("生命+100  防御力+50");
    }
    @Override
    public void weapon2(Hero h) {
        h.setAttackprow(h.getAttackprow()+200);
        System.out.println("攻击力+200  你已经变强了，快上吧");
    }


}
