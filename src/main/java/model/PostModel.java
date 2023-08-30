package model;

import entity.PostResponse;
import entity.PostsResponse;
import network.ApiClient;
import network.ApiService;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Optional;

public class PostModel {

    public Optional<Response<PostsResponse>> fetchPosts() {
        ApiClient client = new ApiClient();
        ApiService service = client.getService();
        Call<PostsResponse> call = service.getPosts();
        Optional<Response<PostsResponse>> optional;

        try {
            optional = Optional.of(call.execute());
        } catch (Exception e) {
            optional = Optional.empty();
        }

        return optional;
    }

    public Optional<Response<PostResponse>> fetchPostById(int id) {
        ApiClient client = new ApiClient();
        ApiService service = client.getService();
        Call<PostResponse> call = service.getPostById(id);
        Optional<Response<PostResponse>> optional;

        try {
            optional = Optional.of(call.execute());
        } catch (Exception e) {
            optional = Optional.empty();
        }

        return optional;
    }

}
