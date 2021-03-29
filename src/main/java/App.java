import dao.*;
import model.*;

public class App {

    public static void main(String[] args) {
        UserDaoClass userDaoClass = new UserDaoClass();
//
//        User user = new User();
//        user.setFullName("Carulus XII");
//        user.setLogin("Carulus12");
//        user.setEmail("Carulus@XII");
//        user.setAge(19);
//        user.setAuthor(false);
//        user.setModerator(true);
//
//        userDaoClass.create(user);
//
//        user.setFullName("Petr the Greate");
//        user.setLogin("Greatest");
//        user.setEmail("Greate@greate");
//        user.setAge(25);
//        user.setAuthor(false);
//        user.setModerator(true);
//
//        userDaoClass.create(user);
//
//        User user = userDaoClass.findById(1);
//        System.out.println(user);


//        Post post = new Post();
//        post.setTitle("secondPost");
//        post.setContent("secondPostContent");
//        post.setAuthor(userDaoClass.findById(1));
//        post.setModerator(userDaoClass.findById(2));
//        post.setRating(0);
//        System.out.println();
//        PostDaoClass postDaoClass = new PostDaoClass();
//        postDaoClass.create(post);

        Follovers connection = new Follovers();
        connection.setMaster(userDaoClass.findById(3));
        connection.setSlave(userDaoClass.findById(2));

        ConnectionDaoClass connectionDaoClass = new ConnectionDaoClass();
        connectionDaoClass.create(connection);

        connection.setSlave(userDaoClass.findById(1));
        connectionDaoClass.create(connection);

        connection.setMaster(userDaoClass.findById(2));
        connection.setSlave(userDaoClass.findById(1));
        connectionDaoClass.create(connection);


    }
}
