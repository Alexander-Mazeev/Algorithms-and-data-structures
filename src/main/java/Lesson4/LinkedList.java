/*
 *       Created by Alexander on 13/04/2020
 */

package Lesson4;

public class LinkedList {

    private Link first;
    private Link last;

    public LinkedList(){
        first = null;
        last = null;
    }

    public void insert(String name, int age){
        Link newLink = new Link(name, age);
        newLink.next = first;
        first = newLink;
    }

    public Link delete(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public String deleteStr(){
        Link temp = first;
        if (first.next == null)
            last = null;
        first = first.next;
        return temp.name;
    }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }

    public LinkInterator getIterator(){
        return new LinkInterator(this);
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void display(){
        Link current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }
}
