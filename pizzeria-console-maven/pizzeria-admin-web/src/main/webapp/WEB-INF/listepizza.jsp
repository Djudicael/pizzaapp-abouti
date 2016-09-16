<%@ include file="entete.jsp" %>
<%@page isELIgnored="false"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

                    <div class="container">

                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>

                                        <th>References</th>
                                        <th>Libelle</th>
                                        <th>prix</th>
                                        <th>categorie</th>
                                        <th>Image de la pizza</th>
                                        <th>Edition</th>
                                        <th>Suprimer</th>
                                    </tr>
                                </thead>

                                <c:forEach var="pizzaCourante" items="${liste}">
                                    <tbody>
                                        <tr>
                                            <td>
                                                ${pizzaCourante.code}
                                            </td>
                                            <td>
                                                ${pizzaCourante.nom}

                                            </td>
                                            <td>
                                                ${pizzaCourante.prix}

                                            </td>
                                            <td>
                                                ${pizzaCourante.categorie}

                                            </td>
                                            <td>
                                                ${pizzaCourante.urlImage}

                                            </td>
                                            <td>

                                               
                                                <a class="btn" href=" <c:url value='update?code=${pizzaCourante.code}'/>"><span class="glyphicon glyphicon glyphicon-plus"
                                                    aria-hidden="true"></span></a>
                                            </td>
                                            <td>
                                            <form action="<c:url value='delete'/>" method="post">
                                                    <input type="hidden" name="codePizza" value="${pizzaCourante.code}">
                                                    <input type="image" class="btn" src="./boot/dist/img/delete.PNG"> </input>

                                                </form>
                                                

                                            </td>

                                        </tr>



                                     

                                </c:forEach>



                                    </tbody>
                            </table>
                        </div>

                    </div>
  <%@ include file="footer.jsp" %>
                  