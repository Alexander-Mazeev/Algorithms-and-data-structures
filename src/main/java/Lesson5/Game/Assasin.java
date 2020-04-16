/*
 *       Created by Alexander on 13/04/2020
 */

package Lesson5.Game;

import java.util.Random;

class Assasin extends Hero {

    int cricitalHit;
    Random random = new Random();

    public Assasin(String name) {
        super("Assasin", name);
        this.cricitalHit = random.nextInt(50);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(health < 0) {
                System.out.println("Герой погиб и бить не может!");
            } else {
                hero.causeDamage(damage + cricitalHit);
            }
            System.out.println(this.name + " нанес урон " + hero.name);
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
    }
}