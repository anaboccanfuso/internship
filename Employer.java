import java.util.ArrayList;
import java.util.UUID;

import javax.swing.ImageIcon;

public class Employer extends User {
    private String email;
    private double rating;
    private ArrayList<Review> reviews;
    private String location;
    private String mission;
    private ImageIcon logo;
    private ArrayList<InternshipPost> posts;
    private static UUID id;

    public Employer(String username, String password) {
        super(username, password, id);
    }

    public Employer(UUID id, String username, String password, String email, double rating, String location, String mission) {
        
    }

    public void addPost(InternshipPost post) {
        posts.add(post);
    }

    public void deletePost(InternshipPost post) {
        posts.remove(post);
    }

    public void addStudentReview(User student, int rating, String comment) {
        Review studentReview = new Review(student, rating, comment);
        reviews.add(studentReview);
    }
}
