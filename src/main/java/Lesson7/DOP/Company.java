/*
 *       Created by Alexander on 22/04/2020
 */

package Lesson7.DOP;

import java.util.List;

public class Company {
    int id;
    String name;
    List<Do> subsidiary;

    public Company(int id, String name, List<Do> subsidiary) {
        this.id = id;
        this.name = name;
        this.subsidiary = subsidiary;
    }

    public void infoIndicators (){
        double rez = 0;
        for (Do list:subsidiary) {
            rez += (list.fact * 100) / list.prognoz;
        }
        System.out.println("Компания: " + name + " выполнила план на " + rez + "%");
    }
}

class Do {
    int id;
    int parentId;
    String name;
    double fact;
    double prognoz;

    public Do(int id, int parentId, String name, double fact, double prognoz) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.fact = fact;
        this.prognoz = prognoz;
    }
}
