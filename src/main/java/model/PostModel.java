package model;

import entity.Post;
import network.ApiClient;
import network.ApiService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.Optional;

public class PostModel {

    public Optional<Response<Post>> fetchPosts() {
        ApiClient client = new ApiClient();
        ApiService service = client.getService();
        Call<Post> call = service.getPosts();
        Optional<Response<Post>> optional;

        try {
            optional = Optional.of(call.execute());
        } catch (Exception e) {
            optional = Optional.empty();
        }

        return optional;
    }

    public Optional<Response<Post>> fetchPostById(int id) {
        ApiClient client = new ApiClient();
        ApiService service = client.getService();
        Call<Post> call = service.getPostById(id);
        Optional<Response<Post>> optional;

        try {
            optional = Optional.of(call.execute());
        } catch (Exception e) {
            optional = Optional.empty();
        }

        return optional;
    }

}
