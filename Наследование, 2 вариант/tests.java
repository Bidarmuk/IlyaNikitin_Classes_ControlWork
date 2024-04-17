public class StackTest {

    @Test
    public void testPush() {
        Stack stack = new Stack();
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    @Test
    public void testPop() {
        Stack stack = new Stack();
        stack.push(1);
        int poppedElement = stack.pop();
        assertEquals(1, poppedElement);
        assertNull(stack.peek());
    }

    @Test
    public void testPeek() {
        Stack stack = new Stack();
        stack.push(1);
        assertEquals(1, stack.peek());
    }
}