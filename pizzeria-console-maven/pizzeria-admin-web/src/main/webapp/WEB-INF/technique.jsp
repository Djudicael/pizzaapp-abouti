<%@ include file="entete.jsp" %>
<%@page isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <div class="container">
  <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  
                  <th>Nombre de session</th>
                  <th>Temps d�'executions des requetes</th>
                  
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>${compteur_affichage}</td>
                  <td>${timer}</td>
                  
                </tr>
               
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  
    
  </div>

  <%@ include file="footer.jsp" %>