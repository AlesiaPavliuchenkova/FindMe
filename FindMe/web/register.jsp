<%--
  Created by IntelliJ IDEA.
  User: apavliuchenkova
  Date: 04/11/2016
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="stylesheets/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="script/script.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!--??????-->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css">
</head>
<body class="body">

    <header class="mainHeader">
        <!--some content of main header -->
    </header>

    <content class="mainContent">
        <!--onsubmit="validateRequiredFormElements();"-->
            <form id="registerForm" action="register" method="post">
                <table class="registerForm">
                    <tr>
                        <td>User Name:<text style="color: red">*</text></td>
                        <td><input class="required" type="text" placeholder="Enter UserName" name="userName"/></td>
                    </tr>
                    <tr>
                        <td>Password:<text style="color: red">*</text></td>
                        <td><input type="password" placeholder="Enter Password" name="password"/></td>
                    </tr>
                    <tr>
                        <td>First Name:</td>
                        <td><input type="text" placeholder="Alesia" name="firstName"/></td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td><input type="text" placeholder="Pavliuchenkova" name="lastName"/></td>
                    </tr>
                    <tr>
                        <td>Gender:</td>
                        <td><input class="radio" type="radio" name="gender" value="male" checked>Male
                            <input class="radio" type="radio" name="gender" value="female" uncheked>Female
                        </td>
                    </tr>
                    <tr>
                        <td>Date of Birth:</td>
                        <td><input id="dateOfBirth" type="date" name="dateOfBirth" placeholder="11/11/1988"/></td>
                    </tr>
                    <tr>
                        <td>Country:</td>
                        <td>
                            <select id="country" name="country" minlength="1"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>City:</td>
                        <td>
                            <select id="city" name="city" minlength="1" disabled="disabled"></select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input class="submit" type="submit" value="Register Now"/></td>
                    </tr>
                </table>
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
