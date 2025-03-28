import java.lang.reflect.Member;
import java.util.List;

public class LibrarySystem {
    private List<LibraryItem> items;
    private List<LibraryMember> members;

    public LibrarySystem(List<LibraryItem> items, List<LibraryMember> members) {
        this.items = items;
        this.members = members;
    }

    public void addNewItem(LibraryItem item) throws DuplicateItemException {
        for (LibraryItem i : items) {
            if (item.getItemId().equals(i.getItemId())) {
                throw new DuplicateItemException("Duplicate item");
            }
        }
        items.add(item);
    }

    public void registerMember(LibraryMember member) throws DuplicateMemberException {
        for (LibraryMember i : members) {
            if (member.getMemberId() == i.getMemberId()) {
                throw new DuplicateMemberException("Duplicate member");
            }
        }
        members.add(member);
    }

    public void removeItem(LibraryItem item) {
        items.remove(item);
    }

    public void removeMember(LibraryMember member) {
        members.remove(member);
    }

    public LibraryMember findMemberById(int memberId) {
        for (LibraryMember i : members) {
            if (memberId==i.getMemberId()) {
                return i;
            }
        } return null;
    }
    public LibraryItem findItemById(String itemId) {
        for (LibraryItem i : items) {
            if (itemId.equals(i.getItemId())) {
                return i;
            }
        } return null;
    }


    public void borrowItem(LibraryMember member , LibraryItem item) throws UserNotFoundException, ItemNotFoundException {
        if(!members.contains(member)) {
            throw new UserNotFoundException("User not found");
        }
        if (!items.contains(item)) {
            throw new ItemNotFoundException("Item not found");
        }
        if (member.getBorrowLimit()>=5){
            throw new OverLimitException("Over limit cant borrow more than 5 items");
        }
        if (item.getIsBorrowed()==true){
            System.out.println("Item is not available");
        }
        item.markBorrowed();
        member.setBorrowedCount(member.getBorrowedCount()+1);
    }


    public void returnItem(LibraryMember member, LibraryItem item) throws UserNotFoundException, ItemNotFoundException {
        if(!members.contains(member)) {
            throw new UserNotFoundException("User not found");
        }
        if (!items.contains(item)) {
            throw new ItemNotFoundException("Item not found");
        }
        item.markReturned();
        member.setBorrowedCount(member.getBorrowedCount()-1);
    }
    public void printAllMembers() {
        for (LibraryMember i : members) {
            System.out.println(i.getName());
        }
    }
    public void printAllItems() {
        for (LibraryItem i : items) {
            System.out.println(i.getTitle());
        }
    }
}
