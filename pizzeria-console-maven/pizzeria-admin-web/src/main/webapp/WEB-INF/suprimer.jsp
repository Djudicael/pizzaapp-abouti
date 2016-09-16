<%@ include file="entete.jsp" %>


    <div class="container">
        <form method="post">
            <fieldset>
                <legend>supression de pizzas</legend>
                <p>Vous pouvez rentrer votre pizza à suprimer.</p>
                
                <label for="oldref">Ancienne reference à suprimer <span class="requis">*</span></label>
                <input type="text" id="oldref" class="form-control input-md" name="oldref" value="" size="20" maxlength="60" />
                <br />

                <button type="submit" class="btn btn-default btn-lg ">Suprimer</button>

                <br />
            </fieldset>
        </form>

    </div>



     <%@ include file="footer.jsp" %>