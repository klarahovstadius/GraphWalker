package springcourse.examplewithcomments.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springcourse.examplewithcomments.user.User;
import springcourse.examplewithcomments.user.UserDaoService;
import springcourse.examplewithcomments.user.UserNotFoundException;

import java.net.URI;
import java.util.List;

@RestController
public class PostResource {

    @Autowired
    private PostDaoService postService;

    @Autowired
    private UserDaoService userService;
    private UserNotFoundException UserNotFoundException;
    private Object PostNotFoundException;

    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePost(@PathVariable int id){
        List<Post> postList = postService.findAllFromUser(id);
        return postList;
    }

    @GetMapping("/users/{id}/posts/{postId}")
    public Post retrieveSinglePost(@PathVariable Integer id, @PathVariable Integer postId){
        User user = userService.findOne(id);
        Post post = null;
        if (user != null){
            post = postService.findUserPost(id, postId);
        }
        else
            throw new PostNotFoundException("Post id: " + postId + " not found.");
        return post;
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post){
        User user = userService.findOne(id);
        if (user == null)
        {
            throw UserNotFoundException;
        }
        Post posted = postService.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}/posts")
                .buildAndExpand(posted.getPostId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
