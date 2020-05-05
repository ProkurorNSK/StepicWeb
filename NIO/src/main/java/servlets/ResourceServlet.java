package servlets;

import resources.ResourceServer;
import resources.TestResource;
import sax.ReadXMLFileSAX;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResourceServlet extends HttpServlet {
    public static final String PAGE_URL = "/resources";
    private final ResourceServer resourceServer;


    public ResourceServlet(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String path = req.getParameter("path");
        resp.setContentType("text/html;charset=utf-8");
        if (path == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            resourceServer.setTestResource((TestResource) ReadXMLFileSAX.readXML(path));
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
