import Main.JavaApplication;
import static Main.JavaApplication.Map;
import static Main.JavaApplication.maxInt;
import Main.Window;
import junit.framework.TestCase;
import java.util.ArrayList;
import Main.Node;
public class JavaApplicationTest extends TestCase {
    protected void setUp() throws Exception {
        JavaApplication.dir = 10;
        JavaApplication.diag = 14;
    }

    protected void tearDown() throws Exception {

    }
   public void testAllJavaApp()
    {
        Window win=new Window();
        win.createGUI();
        win.spj2.setValue(2);
        JavaApplication.win=win;
        JavaApplication.prepare();
        ArrayList<Integer> ends=new ArrayList<>();
        win.spj2.setValue(2);
        JavaApplication.setEnds(win.getNumbers());
        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++){
                if(((i==0||i==1||i==2)&&j==1))
                    Map[i][j]=new Node(i,j,maxInt,(byte)1);
                else
                    Map[i][j]=new Node(i,j,maxInt,(byte)0);
            }
        JavaApplication.activate();
       ArrayList<Node> path = JavaApplication.path;
        int size = path.size();
        int len = 0;
        for (int i = 1; i < size; i++)
            if (path.get(i).isDiag(path.get(i - 1)))
                len += JavaApplication.diag;
            else
                len += JavaApplication.dir;
        int minLen = 58;
        assertEquals(len, minLen);
        win.frame.setVisible(false);
      
    }
    public void testPath3()//без ограничений
    {
        JavaApplication.prepare();
        ArrayList<Integer> ends = new ArrayList<>();
        ends.add(5);
        ends.add(2);
        ends.add(5);
        ends.add(8);
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                JavaApplication.Map[i][j] = new Node(i, j, JavaApplication.maxInt, (byte) 0);
            }
        JavaApplication.setEnds(ends);
        ArrayList<Node> path = JavaApplication.AStar();
        int size = path.size();
        int len = 0;
        for (int i = 1; i < size; i++)
            if (path.get(i).isDiag(path.get(i - 1)))
                len += JavaApplication.diag;
            else
                len += JavaApplication.dir;
        Node end = new Node(ends.get(2), ends.get(3), 0, (byte) 0);
        if (end.isDiag(path.get(0)))
            len += JavaApplication.diag;
        else
            len += JavaApplication.dir;
        int minLen = 60;
        assertEquals(len, minLen);
    }

    public void testPath4()//сложгый путь один проход
    {
       JavaApplication.prepare();
        ArrayList<Integer> ends = new ArrayList<>();
        ends.add(0);
        ends.add(0);
        ends.add(0);
        ends.add(2);
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                if ((((i == 0 || i == 1 || i == 2) && j == 1)) || (i == 1 && (j == 2 || j == 3)))
                    JavaApplication.Map[i][j] = new Node(i, j, JavaApplication.maxInt, (byte) 1);
                else
                    JavaApplication.Map[i][j] = new Node(i, j,JavaApplication.maxInt, (byte) 0);
            }
        JavaApplication.setEnds(ends);
        ArrayList<Node> path = JavaApplication.AStar();
        int size = path.size();
        int len = 0;
        for (int i = 1; i < size; i++)
            if (path.get(i).isDiag(path.get(i - 1)))
                len += JavaApplication.diag;
            else
                len += JavaApplication.dir;
        
        Node end = new Node(ends.get(2), ends.get(3), JavaApplication.maxInt, (byte) 0);
        if (end.isDiag(path.get(0)))
            len += JavaApplication.diag;
        else
            len += JavaApplication.dir;
        int minLen = 96;
        assertEquals(len, minLen);
    }

    public void testPath5()//равные пути
    {
       JavaApplication.prepare();
        ArrayList<Integer> ends = new ArrayList<>();
        ends.add(5);
        ends.add(0);
        ends.add(5);
        ends.add(5);
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                if ((i == 4 || i == 5 || i == 6) && j == 2)
                    JavaApplication.Map[i][j] = new Node(i, j, JavaApplication.maxInt, (byte) 1);
                else
                    JavaApplication.Map[i][j] = new Node(i, j, JavaApplication.maxInt, (byte) 0);
            }
        JavaApplication.setEnds(ends);
        ArrayList<Node> path = JavaApplication.AStar();
        int size = path.size();
        int len = 0;
        for (int i = 1; i < size; i++)
            if (path.get(i).isDiag(path.get(i - 1)))
                len += JavaApplication.diag;
            else
                len += JavaApplication.dir;
        Node end = new Node(ends.get(2), ends.get(3), 0, (byte) 0);
        if (end.isDiag(path.get(0)))
            len += JavaApplication.diag;
        else
            len += JavaApplication.dir;
        int minLen = 66;
        assertEquals(len, minLen);
    }

   public void testPath6() //нет решений
    {
        JavaApplication.prepare();
        ArrayList<Integer> ends = new ArrayList<>();
        ends.add(0);
        ends.add(0);
        ends.add(0);
        ends.add(2);
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                if ((((i == 0 || i == 1 || i == 2) && j == 1)) || (i == 1 && (j == 2 || j == 3))||(j==3&&i==0))
                    JavaApplication.Map[i][j] = new Node(i, j, JavaApplication.maxInt, (byte) 1);
                else
                    JavaApplication.Map[i][j] = new Node(i, j, JavaApplication.maxInt, (byte) 0);
            }
        JavaApplication.setEnds(ends);
        ArrayList<Node> path = JavaApplication.AStar();
        int size = path.size();
        assertEquals(size, 0);

    }
}