import java.util.Scanner;
public class RPG {
           static class Unit {
            String name;
            int level;
            int hp;
            int hpmax;
            int mana;
            int manamax;
            int swordatk;
            int shielddef;
            int atk;
            int def;
            double speed;
            boolean Swords_on;
            boolean shields_on;
            Unit(String _name) {
                name= _name;
                level=1;
                atk=5;
                def=5;
                swordatk=15;
                shielddef=20;
                hpmax = 100 + 10 * level;
                manamax = 50 + 2 * level;
                hp=hpmax;
                mana=manamax;            }
            void calculate() {
                if (Swords_on == true) {
                    swordatk = 20 + level * 2;
                    atk = swordatk + atk;
                    speed = speed - (2 * level);
                }
                else if (shields_on == true) {
                    shielddef = 10 + level * 2;
                    def = shielddef + def;
                    speed = speed - (5 * level);
                }
                else {
                    atk = 5+2*level;
                    def = 5+1*level;
                    speed = 100 + 5 * level;
                }
            }
            void reset(){
                atk=5;
                def=5;
                speed=100;
            }
    void Showstatus(){
        System.out.printf("Name %s \n",name);
        System.out.printf("Level %d \n",level);
        System.out.printf("HP %d / %d\n",hp,hpmax);
        System.out.printf("Mana %d / %d\n",mana,manamax);
        System.out.printf("ATK %d \n",atk);
        System.out.printf("DEF %d \n",def);
        System.out.printf("SPEED %.2f \n ",speed);
    }
}
static class Enemy {
    String name;
    int hp;
    int hpmax;
    int atk;
    int def;
    Enemy (String _name,int _hpmax,int _atk,int _def){
        name=_name;
        hpmax=_hpmax;
        atk=_atk;
        def=_def;
        hp=_hpmax;
    }
    void Showstatus(){
        System.out.printf("Name %s \n",name);
        System.out.printf("HP %d / %d\n",hp,hpmax);
        System.out.printf("ATK %d \n",atk);
        System.out.printf("DEF %d \n",def);
    }
}
    public static void main (String[] args) {
        Unit hero = new Unit("Player");
        hero.Showstatus();
        Enemy koko = new Enemy("koko",200,6,10);
        koko.Showstatus();
        System.out.println("------------------Play--------------------------");
        while(hero.hp>0&&koko.hp>0){
            Scanner in = new Scanner(System.in);
            int order;
            System.out.print("Would you like to equip a sword or shield? 1.No 2.                    sword 3. shield 4.both : ");
            order = in.nextInt();
            if(order==1){
                hero. calculate();
                System.out.println("Hero ATK!!!!");
                if(hero.atk<koko.def){koko.hp= koko.hp;}else{
                    koko.hp= koko.hp-(hero.atk- koko.def);}
                hero.Showstatus();
                System.out.println("--------------------------------------------");
                koko.Showstatus();
            }
            else if(order==2){
                hero.Swords_on=true;
                System.out.println("Hero ATK!!!!");
                hero. calculate();
                if(hero.atk<koko.def){koko.hp= koko.hp;}else{
                    koko.hp= koko.hp-(hero.atk- koko.def);}
                hero.Showstatus();
                System.out.println("--------------------------------------------");
                koko.Showstatus();
            }else if(order==3){
                hero.shields_on=true;
                System.out.println("Hero ATK!!!!");
                hero. calculate();
                if(hero.atk<koko.def){koko.hp= koko.hp;}else{
                    koko.hp= koko.hp-(hero.atk- koko.def);}
                hero.Showstatus();
                System.out.println("--------------------------------------------");
                koko.Showstatus();
            }else if(order==4){
                System.out.println("Hero ATK!!!!");
                hero.Swords_on=true;
                hero.shields_on=true;
                hero. calculate();
                if(hero.atk<koko.def){koko.hp= koko.hp;}else{
                    koko.hp= koko.hp-(hero.atk- koko.def);}
                hero.Showstatus();
                System.out.println("--------------------------------------------");
                koko.Showstatus();
            }
            System.out.println("Enemy ATK!!!!");
            if(koko.atk<hero.def){hero.hp= hero.hp;}else{
                hero.hp= hero.hp-(koko.atk- hero.def);}
            hero.Showstatus();
            System.out.println("--------------------------------------------");
            koko.Showstatus();
            hero.reset();
            hero.Swords_on=false;
            hero.shields_on=false;
        }
        if(hero.hp<=0){
            System.out.print("KOKO win");
        }else{
            System.out.print("Hero win");
        }
    }
}