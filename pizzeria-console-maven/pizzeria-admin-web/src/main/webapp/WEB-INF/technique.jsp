<%@ include file="entete.jsp" %>
<%@page isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <div class="container">
  <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  
                  <th>Nombre de session</th>
                   <th>chemin de la requette</th>
                  <th>Temps d'eexecutions des requetes</th>
                  
                </tr>
              </thead>
              <tbody>
              <c:forEach var="mapcourante" items="${mapping}">
                <tr>
               	<td>${compteur_affichage}</td>
                  <td>${mapcourante.key}</td>
                  <td>${mapcourante.value}</td>
                  
                </tr>
                </c:forEach>
               
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  
    
  </div>

  <%@ include file="footer.jsp" %>