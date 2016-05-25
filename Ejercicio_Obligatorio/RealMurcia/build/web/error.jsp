<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Real Murcia C.F</title>
      <link rel="stylesheet" href="style.css">
  </head>
  <body><%
      Class.forName("com.mysql.jdbc.Driver");
      Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/real_murcia","root", "root");
      Statement bd = conexion.createStatement();

      request.setCharacterEncoding("UTF-8");
      
      // Comprueba la existencia del número de socio introducido
      String consultaCodJu = "SELECT * FROM Plantilla WHERE CodJu="
                                + Integer.valueOf(request.getParameter("numero"));      
      
      ResultSet numeroDeJugador = bd.executeQuery (consultaCodJu);
      numeroDeJugador.last(); 
      
      if (numeroDeJugador.getRow() != 0) {
        %><div style="text-align:center"><% out.println("Lo siento, no se ha "
                + "podido dar de alta, ya existe un jugador con el dorsal número "
                    + request.getParameter("numero") + ".");
      } else {
        String insert = "Insert INTO Plantilla Values ("
              + Integer.valueOf(request.getParameter("numero")) +  ", " +
              "'" + request.getParameter("nombre") + "', " +
              "'" + request.getParameter("apellidos") + "', " +
              "'" + request.getParameter("edad") + "', " +
              "'" + request.getParameter("dni") + "', " +
              "'" + request.getParameter("nacionalidad") + "', " +
              "'" + request.getParameter("posicion") + "')";
        bd.execute(insert);
  %><div style="text-align:center">Jugador dado de alta correctamente<%
      }
      conexion.close();
    %>
    <br>
    <a href="index.jsp" class="btn btn-primary">Página principal</button></div>
   
  </body>
</html>
