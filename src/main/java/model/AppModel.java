package model;

import controller.PostController;
import controller.PostsController;
import view.PostByIdView;
import view.PostsView;

public class AppModel {

    public void readPosts() {
        PostModel model = new PostModel();
        PostsView view = new PostsView();
        PostsController controller = new PostsController(model, view);
        controller.getPosts();
    }

    public void readPostById() {
        PostModel model = new PostModel();
        PostByIdView view = new PostByIdView();
        PostController controller = new PostController(model, view);
        controller.getPostById();
    }

}
