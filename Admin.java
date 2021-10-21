import java.util.ArrayList;
import java.util.UUID;

public class Admin extends User {
    private static UUID id;
    
    public Admin(String username, String password) {
        super(username, password, id);
        this.id = id;
    }

    public UUID getID() {
        return this.id;
    }
    
    public void deletePost(InternshipPost post) {
        InternshipList internshipList = InternshipList.getInstance();
        for (InternshipPost internship : internshipList.getInternships()) {
            if (internship == post) {
                internshipList.remove(post);
            }
        }
        internshipList.save();
    }

    public void addPost(InternshipPost post) {

    }

    public void deleteReview(Review review) {

    }

    public void addReview(Review review) {

    }
}
