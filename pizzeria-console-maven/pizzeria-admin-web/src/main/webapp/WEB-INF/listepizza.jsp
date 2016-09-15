<!DOCTYPE html>
<%@page import="java.util.Map"%>
    <%@page import="fr.pizzeria.model.Pizza"%>
        <html lang="en">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
            <meta name="description" content="">
            <meta name="author" content="">


            <title>Starter Template for Bootstrap</title>

            <!-- Bootstrap core CSS -->
            <link href="./boot/dist/css/bootstrap.min.css" rel="stylesheet">

            <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
            <link href="./boot/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

            <!-- Custom styles for this template -->
            <link href="./boot/style.css" rel="stylesheet">

            <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
            <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
            <script src="./boot/js/ie-emulation-modes-warning.js"></script>

            <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
            <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
        </head>

        <body>

            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
                            aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
                        <a class="navbar-brand" href="#">Project name</a>
                    </div>

                    <!--/.nav-collapse -->
                </div>
            </nav>

            <div class="container">

                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                            <tr>

                                <th>Reference</th>
                                <th>Libelle</th>
                                <th>prix</th>
                                <th>categorie</th>
                                <th>Image de la pizza</th>
                                <th>Edition</th>
                                <th>Suprimer</th>
                            </tr>
                        </thead>
                        <% 
            Map<String, Pizza> pizzas = (Map<String,Pizza>)request.getAttribute("liste");
            for(Pizza pizzaindi : pizzas.values()){
            	
            
         
            %>
                            <tbody>
                                <tr>
                                    <td>
                                        <%=pizzaindi.getCode() %>
                                    </td>
                                    <td>
                                        <%=pizzaindi.getNom() %>
                                    </td>
                                    <td>
                                        <%=pizzaindi.getPrix() %>
                                    </td>
                                    <td>
                                        <%=pizzaindi.getCategorie() %>
                                    </td>
                                    <td>
                                        <%=pizzaindi.getUrlImage() %>
                                    </td>
                                    <td>

                                        <a class="btn" href="<%=request.getContextPath()%>/update?code=<%= pizzaindi.getCode()%>"><span class="glyphicon glyphicon glyphicon-plus" aria-hidden="true"></span></a>
                                    </td>
                                    <td>
                                        <form action="<%=request.getContextPath()%>/delete" method="post">
                                            <input type="hidden" name="codePizza" value="<%=pizzaindi.getCode()%>">
                                            <input type="image" class="btn" src="./boot/dist/img/delete.PNG"> </input>
                                           
                                        </form>

                                    </td>

                                </tr>

                                <%
            }
            %>


                            </tbody>
                    </table>
                </div>

            </div>
            </div>
            </div>

            </div>
            <!-- /.container -->


            <!-- Bootstrap core JavaScript
    ================================================== -->
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
            <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
            <script src="./boot/dist/js/bootstrap.min.js"></script>
            <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
            <script src="./boot/dist/js/ie10-viewport-bug-workaround.js"></script>
        </body>

        </html>