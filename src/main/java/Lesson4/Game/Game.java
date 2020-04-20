package Lesson4.Game;

import java.util.Random;

class Game {
    public static void main(String[] args) {

        Random randomStep = new Random();
        Random randomHealing = new Random();
        boolean gameOver = false;

        //Hero[] team1 = new Hero[]{new Warrior(250, "Тигрил", 50, 0)
        //        , new Assasin(150, "Акали", 70, 0)
        //        , new Doctor(120, "Жанна", 0, 60)};
        Hero[] team1 = new Hero[]{new Warrior("Тигрил")
                , new Assasin("Акали")
                , new Doctor("Жанна")};


        //Hero[] team2 = new Hero[]{new Warrior(290, "Минотавр", 60, 0)
        //        , new Assasin(160, "Джинкс", 90, 0)
        //        , new Doctor(110, "Зои", 0, 80)};
        Hero[] team2 = new Hero[]{new Warrior("Минотавр")
                , new Assasin("Джинкс")
                , new Doctor("Зои")};

        while (!gameOver){
            for (int i = 0; i < team1.length; i++) {
                if (randomStep.nextInt(3) == 0) {
                    if (team1[i] instanceof Doctor) {
                        if (randomStep.nextInt(2) == 0)
                            team1[i].healing(team1[randomHealing.nextInt(2)]);
                        else team1[i].hit(team2[i]);
                    } else {
                        team1[i].hit(team2[i]);
                    }
                } else {
                    if (team2[i] instanceof Doctor) {
                        if (randomStep.nextInt(2) == 0)
                            team2[i].healing(team2[randomHealing.nextInt(2)]);
                        else team2[i].hit(team1[i]);
                    } else {
                        team2[i].hit(team1[i]);
                    }
                }
            }
            if (winTeam(team1)){
                System.out.println("---------------");
                System.out.println("Win is Team2");
                gameOver = true;
            } else if (winTeam(team2)) {
                System.out.println("---------------");
                System.out.println("Win is Team1");
                gameOver = true;
            }
        }

        System.out.println("---------------");

        for (Hero t1: team1) {
            t1.info();
        }

        for (Hero t2: team2) {
            t2.info();
        }
    }

    public static boolean winTeam(Hero[] team){
        int countIsDied = 0;
        for (int i = 0; i < team.length; i++) {
            if (team[i].getHealth() <= 0)
                countIsDied ++;
        }
        return countIsDied == team.length;
    }
}