/*
 *       Created by Alexander on 03/04/2020
 */

package Lesson2.DOP;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private Integer id;
    private Integer parentId;

    public Company(Integer id, Integer parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    private ArrayList<Company> children = new ArrayList<Company>();

    public ArrayList<Company> getChildren() {
        return children;
    }

    public Integer getId() {
        return id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public boolean hasParent(){
        if(this.parentId != 0){
            return true;
        }
        return false;
    }

    public void setChild(Company child) {
        this.children.add(child);
    }

}

class CompanyMain{
    static List<Company> list = new ArrayList<Company>();
    static List<Company> resultList = new ArrayList<Company>();

    static void add(Company obj) {
        if (!obj.hasParent()) {
            resultList.add(obj);
        } else {
            for (int i = 0; i < resultList.size(); i++) {
                if (resultList.get(i).getId() == obj.getParentId()) {
                    resultList.get(i).setChild(obj);
                    if (!obj.hasParent()) {
                        add(resultList.get(i));
                    } else {
                        break;
                    }
                }
                addChild(obj, i);
            }
        }
    }

    static void addChild(Company obj, int i) {
        if (resultList.get(i).getChildren().size() != 0) {
            for (int j = 0; j < resultList.get(i).getChildren().size(); j++) {
                if (resultList.get(i).getChildren().get(j).getId() == obj.getParentId()) {
                    resultList.get(i).getChildren().get(j).setChild(obj);
                } else if (resultList.get(i).getChildren().get(i).getChildren().size() != 0){
                    for (int k = 0; k < resultList.get(i).getChildren().get(j).getChildren().size(); k++) {
                        if (resultList.get(i).getChildren().get(j).getChildren().get(0).getId() == obj.getParentId()) {
                            resultList.get(i).getChildren().get(j).getChildren().get(k).setChild(obj);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        list.add(new Company(1, 0));
        list.add(new Company(2, 1));
        list.add(new Company(3, 2));
        list.add(new Company(4, 1));
        list.add(new Company(5, 0));
        list.add(new Company(6, 5));

        for (Company obj: list) {
            add(obj);
        }
    }
}
