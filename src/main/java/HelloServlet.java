import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    private static int ticketId = 0;
    private static int getTicketID(){
        return ++ticketId;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<form action='support' method='post'>");
        out.print("<p>Name: <input type='text' name='name'></p>");
        out.print("<p>Email address: <input type='text' name='email'></p>");
        out.print("<p>Problem: <input type='text' name='problem'></p>");
        out.print("<p>Problem description: <textarea rows=4 cols=20> Type your description here</textarea></p>");
        out.print("<p><input type='submit' value='Help'/></p>");
        out.print("</form>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ServletContext sc = this.getServletContext();
        out.print("<html><head><title>CS Tech support:</title></head><body>");
        out.printf("<p>Thank you! %s for contacting us. </p>" +
                "<p>You should receive reply from us with in 24 hrs in your email address %s. </p>" +
                "<p>Let us know in our support email %s if you don’t receive reply within 24 hrs. </p>" +
                "<p>Please be sure to attach your reference %s in your email. </p>"
                ,req.getParameter("name")
                ,req.getParameter("email")
                ,sc.getInitParameter("support-email")
                ,getTicketID());
        out.print("</body></html>");
    }
}
