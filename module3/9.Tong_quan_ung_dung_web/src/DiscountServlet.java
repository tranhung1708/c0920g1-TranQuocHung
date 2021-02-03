import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", urlPatterns = "/calculator")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("productDescription");
        float Price = Float.parseFloat(request.getParameter("price"));
        float Discount = Float.parseFloat(request.getParameter("discount"));
        float discountAmount = Price * Discount ;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Price: " + productDescription + "</h1>");
        writer.println("<h1>Percent: " + Price + "</h1>");
        writer.println("<h1>Discount: " + Discount + "</h1>");
        writer.println("<h1>VND: " + discountAmount + "</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
