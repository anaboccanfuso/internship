import java.util.ArrayList;
import java.util.Hashtable;
import java.util.UUID;

public class Student extends User {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private int gradYear;
    private double gpa;
    private boolean showGPA;
    private double rating;
    private ArrayList<StudentReview> reviews;
    private ArrayList<InternshipPost> favoritePosts;
    private UUID id;
    private EmployerList employerList;

    public Student(String username, String password) {
        super(username, password);
        firstName = "";
        lastName = "";
        email = "";
        phone = "";
        address = "";
        gradYear = 0;
        gpa = 0.0;
        showGPA = true;
        rating = 0.0;
        reviews = new ArrayList<StudentReview>();
        favoritePosts = new ArrayList<InternshipPost>();
        id = super.getUUID();
    }

    public Student(UUID id, String firstName, String lastName, String username, String password, int gradYear,
                    String email, String address, String phone, double gpa, boolean showGPA, double rating, ArrayList<StudentReview> reviews,
                    ArrayList<InternshipPost> favPosts) {
        super(username, password);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.gradYear = gradYear;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.gpa = gpa;
        this.showGPA = showGPA;
        this.rating = rating;
        this.reviews = reviews;
        this.employerList = EmployerList.getInstance();
        this.favoritePosts = favPosts;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getGradYear() {
        return gradYear;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return gpa;
    }

    public boolean getShowGPA() {
        return showGPA;
    }

    public double getRating() {
        return rating;
    }

    public ArrayList<StudentReview> getReviews() {
        return reviews;
    }

    public ArrayList<InternshipPost> getFavoritePosts() {
        return favoritePosts;
    }

    public UUID getUUID() {
        return id;
    }

    public EmployerList getEmployerList() {
        return employerList;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String toString() {
        String ret = "\nName: " + firstName + " " + lastName + "\nUsername: " + username + "\nPassword: " 
                    + password + "\nGrad Year: " + gradYear + "\nEmail: " + email + "\nPhone: "
                    + phone + "\nGPA: " + gpa + "\nRating: " + rating + "\nReviews: ";
        for (StudentReview review : reviews) {
            ret += review + "\n";
        }
        ret += "Favorite Posts: ";
        for (InternshipPost post : favoritePosts) {
            ret += "\n\tEmployer: " + post.getEmployerTitle() + "\n\tPosition Title: " + post.getPosTitle();
        }
        return ret;
    }

    public void addReview(UUID writerID, int rating, String comment) {
        Employer writer = employerList.getEmployerByID(writerID);
        StudentReview review = new StudentReview(writer, rating, comment);
        reviews.add(review);
    }

}
