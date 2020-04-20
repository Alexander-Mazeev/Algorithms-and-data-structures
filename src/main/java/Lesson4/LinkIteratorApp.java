/*
 *       Created by Alexander on 13/04/2020
 */

package Lesson4;

public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        LinkInterator itr = new LinkInterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        itr.insertBefore("Oleg", 15);
        itr.insertBefore("Borya", 17);
        itr.insertAfter("Dima", 23);

        list.display();

        System.out.println(itr.deleteCurrent());
        itr.nextLink();
        System.out.println(itr.deleteCurrent());

        list.display();
    }
}
