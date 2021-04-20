package springcourse.examplewithcomments.post;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PostDaoService {

    private static List<Post> posts = new ArrayList<>();
    private static int postCount = 2;

    static{
        posts.add(new Post(1, 1, new Date(), "My first post."));
        posts.add(new Post(1, 2, new Date(), "My second post."));
    }

    public List<Post> findAllFromUser(Integer userId){
        List<Post> postsList = new ArrayList<>();
        for (Post post:posts) {
            if (post.getUserId() == userId)
                postsList.add(post);
        }
        return postsList;
    }

    public Post findUserPost(Integer userId, Integer postId){
        List<Post> postList = findAllFromUser(userId);
        Post found = null;

        for (Post post:postList) {
            if(post.getPostId() == postId)
                found = post;
        }
        return found;
    }

    public Post save (Post post){
        if(post.getPostId() == null)
            post.setPostId(++postCount);
            posts.add(post);
        return post;
    }
}
