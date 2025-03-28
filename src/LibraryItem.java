public class LibraryItem {
    private String title;
    private String itemId;
    private Boolean isBorrowed;



    public LibraryItem(String title, String itemId)throws InvalidItemTitleException {
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidItemTitleException("Title cannot be null or empty.");
        } else {

            this.title = title;
            this.itemId = itemId;
            this.isBorrowed = false;
        }
    }
    public String getTitle() {
        return title;
    }
    public String getItemId() {
        return itemId;
    }
    public Boolean getIsBorrowed() {
        return isBorrowed;
    }
    public void setIsBorrowed(Boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
    public void setTitle(String title)throws InvalidItemTitleException {
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidItemTitleException("Title cannot be null or empty.");
        }
        this.title = title;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public void markBorrowed() {
        this.isBorrowed = true;
    }
    public void markReturned() {
        this.isBorrowed = false;
    }

    public void printInfo() {
        System.out.println(" ");
        System.out.println("*******************************");
        System.out.println("Title: " + this.title);
        System.out.println("ItemId: " + this.itemId);
        if (this.isBorrowed == true) {
            System.out.println("Situation: Borrowed to be returned");
        } else {
            System.out.println("Situation: Available to borrow" );
        }
        System.out.println("*******************************");
    }
}