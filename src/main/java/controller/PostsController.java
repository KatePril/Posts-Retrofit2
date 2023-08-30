package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Post;
import entity.PostsResponse;
import model.PostModel;
import retrofit2.Response;
import utils.AppStarter;
import utils.Constants;
import view.PostsView;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class PostsController {
    PostModel model;
    PostsView view;

    public PostsController(PostModel model, PostsView view) {
        this.model = model;
        this.view = view;
    }


    public void getPosts() {
        view.getOutput(readPosts());
        AppStarter.startApp();
    }

    private String readPosts() {
        Optional<Response<Post>> optional = model.fetchPosts();

        if (optional.isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {

            Gson gson = new Gson();
            List<Post> posts = gson.fromJson(String.valueOf(optional.get().body()),
                    new TypeToken<List<Post>>() {}.getType());
            StringBuilder stringBuilder = new StringBuilder();
            AtomicInteger cnt = new AtomicInteger(0);
            String str;

            for (Post post : posts) {
                str = cnt.getAndIncrement() + ") Post: id " + post.getId()
                        + ", userId " + post.getUserId()
                        + ";\n title: " + post.getTitle()
                        + ";\n body: " + post.getBody();
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        }
    }
}
