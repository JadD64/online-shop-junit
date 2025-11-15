import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }
    
    public void testDuplicateAuthorComment()
    {
        SalesItem item = new SalesItem("The Alchemist", 1200);
        assertEquals(true, item.addComment("Kathy", "A classic.", 5));
        assertEquals(false, item.addComment("Kathy", "The storytelling blew my mind!", 5));
    }
    
    @Test
    public void testRatingBoundaries()
    {
        SalesItem item = new SalesItem("Breakfast at Tiffany's", 1000);
        assertEquals(false, item.addComment("John", "Hated it", 0));
        assertEquals(false, item.addComment("Maria", "Loved it", 6));
    }
    
    @Test
    public void testFindMostHelpfulCommentNoComments()
    {
    SalesItem item = new SalesItem("Empty", 1000);
    assertEquals(null, item.findMostHelpfulComment());
    }
    
    @Test
    public void testFindMostHelpfulComment()
    {
        SalesItem item = new SalesItem("Helpful Book", 1500);

        item.addComment("Alice", "Nice.", 4);
        item.addComment("Bob", "Not good.", 2);
        item.addComment("Charlie", "Excellent!", 5);
        
        item.upvoteComment(0);
        item.downvoteComment(1);
        item.upvoteComment(2);
        item.upvoteComment(2);
        item.upvoteComment(2);

        Comment mostHelpful = item.findMostHelpfulComment();
        assertNotNull(mostHelpful);
        assertEquals("Charlie", mostHelpful.getAuthor());
    }
}
