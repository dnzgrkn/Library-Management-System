import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        LibrarySystem library = new LibrarySystem(new ArrayList<>(), new ArrayList<>());
        LibraryMember deniz = new LibraryMember(4, 1907, "Deniz");
        LibraryMember onur = new LibraryMember(0, 1881, "Onur");
        LibraryMember beste = new LibraryMember(0, 1903, "Beste");
        LibraryItem book1 = new LibraryItem("Lord of the Rings", "001");
        LibraryItem book2 = new LibraryItem("Harry Potter", "002");
        LibraryItem book3 = new LibraryItem("Game of Thrones", "003");
        LibraryItem book4 = new LibraryItem("Divergent", "004");
        LibraryItem book5 = new LibraryItem("Hunger Games", "005");


        try {
            library.addNewItem(book1);
            library.addNewItem(book2);
            library.addNewItem(book3);
            library.addNewItem(book4);
            library.addNewItem(book5);
            library.registerMember(deniz);
            library.registerMember(onur);
            library.registerMember(beste);
        } catch (DuplicateItemException e) {
            System.out.println(e.getMessage());
        } catch (DuplicateMemberException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(" ");
        System.out.println("****TEST 1****");
        System.out.println("/throwing DuplicateMemberException /");
        System.out.println(" ");
        try{
            library.registerMember(deniz);
        } catch (DuplicateMemberException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(" ");

        System.out.println("****TEST 2****");
        System.out.println("/throwing DuplicateItemException /");
        System.out.println(" ");
        try {
            library.addNewItem(book1);
        }catch (DuplicateItemException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(" ");

        System.out.println("****TEST 3****");
        System.out.println("/throwing OverLimitException /");
        System.out.println(" ");
        try {
            library.borrowItem(1907, "001");
            library.borrowItem(1907, "002");
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (OverLimitException e){
            System.out.println(e.getMessage());
        }
        System.out.println(" ");

        try {
            System.out.println("****TEST 4****");
            System.out.println("/ throwing the InvalidMemberNameException and InvalidItemTitleException /");
            System.out.println(" ");
            LibraryItem emptyItem = new LibraryItem("", "006");
            LibraryMember emptyMember = new LibraryMember(0, 1888, "");
            System.out.println(" ");
        }
        catch (InvalidItemTitleException e) {
            System.out.println(e.getMessage());
        } catch (InvalidMemberNameException e) {
            System.out.println(e.getMessage());
        }


        System.out.println(" ");
        System.out.println("********Final Printing********");
        System.out.println(" ");
        deniz.printInfo();
        book1.printInfo();
        System.out.println(" ");
        System.out.println("***All Items***");
        library.printAllItems();
        System.out.println("***********");
        System.out.println(" ");
        System.out.println("****All Members****");
        library.printAllMembers();
        System.out.println("********************");

    }
}