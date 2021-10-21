import java.util.UUID;

public class StudentReview {
    private Employer writer;
    private int rating;
    private String comment;
    private EmployerList employerList;

    public StudentReview(Employer writer, int rating, String comment) {
        this.writer = writer;
        this.rating = rating;
        this.comment = comment;
    }

    public String toString() {
        return "\nWriter: " + writer.getTitle() + "\nReview Rating: " + rating + "\nComment: " + comment;
    }
}