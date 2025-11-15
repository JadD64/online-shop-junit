import static org.junit.Assert.*;
import org.junit.Test;

public class CommentTest
{
    @Test
    public void testAuthorAndRating()
    {
        Comment comment = new Comment("Alice", "Great!", 4);
        assertEquals("Alice", comment.getAuthor());
        assertEquals(4, comment.getRating());
    }

    @Test
    public void testUpvote()
    {
        Comment comment = new Comment("Bob", "Nice!", 5);  
        comment.upvote();
        comment.upvote();
        assertEquals(2, comment.getVoteCount());
    }

    @Test
    public void testDownvote()
    {
        Comment comment = new Comment("Charlie", "Not great", 2); 
        comment.downvote();
        assertEquals(-1, comment.getVoteCount());
    }
    
    @Test
    public void testUpvoteAndDownvoteBalance()
    {
        Comment comment = new Comment("Jane", "Average", 3);
        comment.upvote();
        comment.upvote();
        comment.downvote();
        assertEquals(1, comment.getVoteCount());
    }
}