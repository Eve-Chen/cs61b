import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {

    @Test
    public void testAddFirst() {
        OperationSequence fs = new OperationSequence();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i++) {
            int rnd = StdRandom.uniform(100);
            student.addFirst(rnd);
            solution.addFirst(rnd);
            DequeOperation dequeOp = new DequeOperation("addFirst", rnd);
            fs.addOperation(dequeOp);
        }
        for (int i = 0; i < 10;i++){
            assertEquals(fs.toString(),solution.get(i), student.get(i));
        }
    }

    @Test
    public void testAddLast(){
        OperationSequence fs = new OperationSequence();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        for(int i = 0;i<10; i++){
            int rnd = StdRandom.uniform(100);
            student.addLast(rnd);
            solution.addLast(rnd);
            DequeOperation dequeOp = new DequeOperation("addLast", rnd);
            fs.addOperation(dequeOp);
        }
        for (int i = 0; i < 10;i++){
            assertEquals(fs.toString(),solution.get(i), student.get(i));
        }
    }

    @Test
    public void testRemoveFirst() {
        OperationSequence fs = new OperationSequence();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i++) {
            int rnd = StdRandom.uniform(100);
            student.addFirst(rnd);
            solution.addFirst(rnd);
        }

        for (int i = 0; i < 10; i++) {
            Integer x = student.removeFirst();
            Integer y = solution.removeFirst();
            DequeOperation dequeOp = new DequeOperation("removeFirst");
            fs.addOperation(dequeOp);
            assertEquals(fs.toString(), y, x);
        }
    }

    @Test
    public void testRemoveLast() {
        OperationSequence fs = new OperationSequence();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i++) {
            int rnd = StdRandom.uniform(100);
            student.addLast(rnd);
            solution.addLast(rnd);
            DequeOperation dequeOp = new DequeOperation("addLast",rnd);
            fs.addOperation(dequeOp);
        }
        for (int i = 0; i < 10; i++) {
            Integer x = student.removeLast();
            Integer y = solution.removeLast();
            DequeOperation dequeOp = new DequeOperation("removeLast");
            fs.addOperation(dequeOp);
            assertEquals(fs.toString(),y, x);
        }

    }

}