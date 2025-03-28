public class LibraryMember {
    private String name;
    private int memberId;
    private int borrowedCount;
    private int borrowLimit;

    public LibraryMember(int borrowedCount, int memberId, String name ) throws InvalidMemberNameException{
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidMemberNameException("Member name cannot be null or empty.");
        }
        this.borrowedCount = borrowedCount;
        this.borrowLimit = 5;
        this.memberId = memberId;
        this.name = name;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public void setBorrowedCount(int borrowedCount){
        this.borrowedCount = borrowedCount;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }

    public void setBorrowLimit(int borrowLimit) {
        this.borrowLimit = borrowLimit;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidMemberNameException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidMemberNameException("Member name cannot be null or empty.");
        }
        this.name = name;
    }
    public void printInfo() {
        System.out.println(" ");
        System.out.println("*******************************");
        System.out.println("Member ID: " + memberId);
        System.out.println("Member Name: " + name);
        System.out.println("Member Borrowed Count: " + borrowedCount);
        System.out.println("Member Borrowed Limit: " + borrowLimit);
        System.out.println("*******************************");
        System.out.println(" ");
    }
}
