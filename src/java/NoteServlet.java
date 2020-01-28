
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 798419
 */
public class NoteServlet extends HttpServlet {

    private int counter;//

    @Override
    public void init() throws ServletException {
        counter = 0;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        counter++;

        
        Note note = new Note();
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line1 = br.readLine();
        String line2 = br.readLine();
        note.setTitle(line1);
        note.setContents(line2);
        request.setAttribute("note", note);

        String edit = request.getParameter("edit");
        if (edit != null) {
            System.out.println("edit");
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        } else {
            System.out.println("view");
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        System.out.println("POST");
        counter++;
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        String edit = request.getParameter("edit");
        if (edit != null) {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
            pw.write(title+"\n");
            pw.write(contents);
            pw.flush();//!!!!
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line1 = br.readLine();
            String line2 = br.readLine();
            Note note = new Note(line1, line2);
            request.setAttribute("note", note);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
