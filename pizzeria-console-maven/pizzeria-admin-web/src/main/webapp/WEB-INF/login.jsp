<%@ include file="entete.jsp" %>

  <div class="container">

    <form class="form-signin" method= "post">
      <h2 class="form-signin-heading">Please sign in</h2>
      <label for="email" class="sr-only">Email address</label>
      <input type="email" name="email" class="form-control" placeholder="Email address" required autofocus>
      <label for="password" class="sr-only">Password</label>
      <input type="password" name="password" class="form-control" placeholder="Password" required>
      <div class="checkbox">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Valider</button>
    </form>

  </div>
  <!-- /container -->



  <%@ include file="footer.jsp" %>