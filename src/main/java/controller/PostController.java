package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Post;
import entity.PostResponse;
import model.PostModel;
import retrofit2.Response;
import utils.AppStarter;
import utils.Constants;
import view.PostByIdView;
import view.PostsView;

import java.util.Optional;

public class PostController {
    PostModel model;
    PostByIdView view;

    public PostController(PostModel model, PostByIdView view) {
        this.model = model;
        this.view = view;
    }

    public void getPostById() {
        view.getOutput(readPostById(
                Integer.parseInt(view.getData())
        ));
        AppStarter.startApp();
    }

    private String readPostById(int id) {
        Optional<Response<Post>> optional = model.fetchPostById(id);

        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            Gson gson = new Gson();
            Post post = gson.fromJson(String.valueOf(optional.get().body()), new TypeToken<Post>() {}.getType());
            return "Post: id " + post.getId()
                    + ", userId " + post.getUserId()
                    + ";\n title: " + post.getTitle()
                    + ";\n body: " + post.getBody();
        }
    }

}
