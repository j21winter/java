import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class SLLTest {
    
    public SLL sll;
    @Before
    public void setUp() throws Exception {
        sll = new SLL();
    }
    @Test
    public void testHeadForNull() {
    		System.out.println("testing Head for Null");
    		sll.printValues();
        assertNull(sll.head);
    }
    
    @Test
    public void testHeadForNode() {
		System.out.println("testing Head for 8");
        sll.add(8);
		sll.printValues();
        assertNotNull(sll.head);
    }
    
    @Test
    public void testHeadNextVal() {
		System.out.println("testing for head next value");

        sll.add(5);
        sll.add(10);
		sll.printValues();
        assertTrue(sll.head.next.value == 10);
    }
    
    @Test
    public void testHeadAfterRemove() {
		System.out.println("testing remove from front ");
        sll.add(10);
        sll.removeFront();
		sll.printValues();
		 assertNull(sll.head);
	}
    
};