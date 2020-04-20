/*
 *       Created by Alexander on 13/04/2020
 */

package Lesson5.Game;

class Warrior extends Hero {

    public Warrior(String name) {
        super("Warrion", name);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(health < 0) {
                System.out.println("Герой погиб и бить не может!");

            } else {
                hero.causeDamage(damage);
            }
            System.out.println(this.name + " нанес урон " + hero.name);
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Войны не умеют лечить!");
    }
}
