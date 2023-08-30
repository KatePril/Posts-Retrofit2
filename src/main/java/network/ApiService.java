package network;

import entity.Post;
import entity.PostResponse;
import entity.PostsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @GET("posts")
    Call<Post> getPosts();

    @GET("posts/{id}")
    Call<Post> getPostById(@Path("id") int id);

}
