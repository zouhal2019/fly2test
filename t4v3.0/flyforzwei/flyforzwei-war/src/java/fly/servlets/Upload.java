package fly.servlets;


import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.oreilly.servlet.MultipartRequest;
import fly.dtos.allDTODTO;
import fly.interfaces.insertenLocal;
import fly.interfaces.umpaLocal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.annotation.MultipartConfig;

@MultipartConfig
public class Upload extends HttpServlet {
    @EJB
    private insertenLocal in;
    @EJB
    private umpaLocal umpa;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
          out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet1</title>");  
        out.println("</head>");
        out.println("<body style='background-color:#cccccc;'>");
        
        MultipartRequest m = new MultipartRequest(request, "c:\\new\\002", 7048576);
//        MultipartRequest m = new MultipartRequest(request, "T:\\Fachinformatiker\\FI17\\Iznogood\\uploadtest", 5048576);
        Enumeration fileNames = m.getFileNames();
        String upload = (String)fileNames.nextElement();
        String filename = m.getFilesystemName(upload);
       
        if (filename==null)
            out.print("<p style=\"text-align:center;\">KEINE DATEI AUSGEWÄHLT!</p>");
        else{
        out.print("<p style=\"text-align:center;\">Datei "+filename+" wurde erfolgreich Hochgeladen und wird in Datenbank übertragen!</br></p>");
         
         List<allDTODTO> l =new ArrayList();
         l=umpa.xls(filename); 
         for(allDTODTO a:l)
         {
             in.insertLand(a);
         } 
       
       out.println("<p style=\"text-align:center;\"><input type=\"button\" class=\"button_active\" value=\"Hauptmenü\" onclick=\"location.href='index.html';\" /></p>");
        }
       
        out.println("</body>");
        out.println("</html>");

        
        
       
        
        
        
    }

}
