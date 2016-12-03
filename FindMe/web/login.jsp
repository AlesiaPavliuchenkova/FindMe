<%--
  Created by IntelliJ IDEA.
  User: apavliuchenkova
  Date: 04/11/2016
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
    <link rel="stylesheet" href="stylesheets/style.css">
  </head>
  <body>
  <header class="mainHeader">
    <!--some content of main header -->
  </header>
  <content class="mainContent">
    <form id="login" action="login" method="POST">
      <table>
        <tr>
          <td>Login:</td>
          <td><input class="required" type="text" placeholder="login" name="userName"/> </td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><input type="password" placeholder="password" name="password"/></td>
        </tr>
        <tr>
          <td><input class="submit" type="submit" value="Submit" /></td>
          <td><font color="red"> ${errorMessage}</font></td>
        </tr>
      </table>
    </form>
    <form action="register">
      <input class="submit" type="submit" value="Register" />
    </form>
  </content>

  <aside class="mainSidebar">
    <article>
      <h2>Top sidebar</h2>
      <p>Sidebar</p>
    </article>
  </aside>

  <footer class="mainFooter">
    <p>Copyright &copy; 2016</p>
  </footer>
  </body>
</html>
