/*
 *       Created by Alexander on 13/04/2020
 */

package Lesson5.Game;

abstract class Hero {

    protected int health;
    protected String name;
    protected int damage;
    protected int addHeal;

    public Hero( String typeHero, String name) {
        this.name = name;
        rnd(typeHero);
    }

    abstract void hit(Hero hero);

    abstract void healing(Hero hero);

    void causeDamage(int damage) {
        if(health < 0) {
            System.out.println("Герой уже мертвый!");
        } else {
            health -= damage;
        }

    }

    public int getHealth() {
        return health;
    }

    void addHealth(int health) {
        if (this.health > 0)
            this.health += health;
        else info();
    }

    void info() {
        System.out.println(name + " " + (health < 0 ? "Герой мертвый" : health) + " " + damage);
    }

    private void rnd(String typeHero)
    {
        int minType1 = 150;
        int maxType1 = 300;
        maxType1 -= minType1;//диапазон от 150 до 300
        int minType2 = 10;
        int maxType2 = 150;
        maxType2 -= minType2;//диапазон от 10 до 150
        int minType3 = 1;
        int maxType3 = 10;
        maxType3 -= minType3;//диапазон от 1 до 10
        switch (typeHero.toUpperCase()){
            case "WARRION":
                this.health = (int) (Math.random() * ++maxType1) + minType1;
                this.damage = (int) (Math.random() * ++maxType2) + minType2;
                this.addHeal = 0;
                break;
            case "ASSASIN":
                this.health = (int) (Math.random() * ++maxType2) + minType2;
                this.damage = (int) (Math.random() * ++maxType1) + minType1;
                this.addHeal = 0;
                break;
            case "DOCTOR":
                this.health = (int) (Math.random() * ++maxType2) + minType2;
                this.damage = (int) (Math.random() * ++maxType3) + minType3;
                this.addHeal = (int) (Math.random() * ++maxType2) + minType2;
                break;
        }
    }
}
