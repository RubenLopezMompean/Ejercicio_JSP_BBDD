package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;

public final class error_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("      <title>Real Murcia C.F</title>\n");
      out.write("      <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("  </head>\n");
      out.write("  <body>");

      Class.forName("com.mysql.jdbc.Driver");
      Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/real_murcia","root", "root");
      Statement bd = conexion.createStatement();

      request.setCharacterEncoding("UTF-8");
      
      
      boolean hayError = false;
      
      // Comprueba la existencia del número de socio introducido
      String consultaCodJu = "SELECT * FROM Plantilla WHERE CodJu="
                                + Integer.valueOf(request.getParameter("numero"));      
      
      ResultSet numeroDeJugador = bd.executeQuery (consultaCodJu);
      numeroDeJugador.last(); 
      
      if (numeroDeJugador.getRow() != 0) {
        
      out.write("<div style=\"text-align:center\">");
 out.println("Lo siento, no se ha "
                + "podido dar de alta, ya existe un jugador con el dorsal número "
                    + request.getParameter("numero") + ".");
        hayError = true;
      }

      // Comprueba la existencia del DNI de socio introducido
      String consultaDNI = "SELECT * FROM Plantilla WHERE DNI="
                                + Integer.valueOf(request.getParameter("dni"));      
      
      ResultSet numeroDNI = bd.executeQuery (consultaDNI);
      numeroDNI.last(); 
      
      if (numeroDNI.getRow() != 0) {
        
      out.write("<div style=\"text-align:center\">");
 out.println("Lo siento, no se ha "
                + "podido dar de alta, ya existe un jugador con el DNI número "
                    + request.getParameter("dni") + ".");
        hayError = true;
      }


      if (!hayError) {
        String insert = "Insert INTO Plantilla Values ("
              + Integer.valueOf(request.getParameter("numero")) +  ", " +
              "'" + request.getParameter("nombre") + "', " +
              "'" + request.getParameter("apellidos") + "', " +
              "'" + request.getParameter("edad") + "', " +
              "'" + request.getParameter("dni") + "', " +
              "'" + request.getParameter("nacionalidad") + "', " +
              "'" + request.getParameter("posicion") + "')";
        bd.execute(insert);
  
      out.write("<div style=\"text-align:center\">Jugador dado de alta correctamente");

      }
      conexion.close();
    
      out.write("\n");
      out.write("    <br>\n");
      out.write("    <a href=\"index.jsp\" class=\"btn btn-primary\">Página principal</button></div>\n");
      out.write("   \n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
