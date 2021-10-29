package game;

public class BeatbackZi implements Beatback{
    @Override
    public void beatback(Hero h, Soldier s1) {
        System.out.println(h.getMame()+"进行了反击，对"+s1.getMame()+"造成"
                +h.getAttackprow()* (s1.getDefenceprow()+100)/s1.getDefenceprow()+"点伤害");

    }
}
