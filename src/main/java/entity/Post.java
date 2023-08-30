package entity;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("userId")
    private final int userId;

    @SerializedName("id")
    private final int id;

    @SerializedName("title")
    private final String title;

    @SerializedName("body")
    private final String body;

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "{\"userId\":" + userId
                + ",\"id\":" + id
                + ",\"title\":\"" + title
                + "\", \"body\":\"" + body + "\"}";
    }

    //    {
//        "userId": 1,
//            "id": 1,
//            "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
//            "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
//    },
}
