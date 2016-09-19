
<%@page isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ include file="entete.jsp" %>

        


                <div class="container">
                    <form method="post">



                        <fieldset>
                            <legend>Editer pizza</legend>
                            <p>Vous pouvez rentrer votre pizza.</p>

                            <label for="oldref">Ancienne reference suprimer <span class="requis">*</span></label>
                            <input type="text" id="oldref" class="form-control input-md" name="oldref" value="${pizza.code}" size="20" maxlength="60"
                            />
                            <br />

                            <label for="reference">Reference <span class="requis">*</span></label>
                            <input type="text" id="reference" class="form-control input-md" name="reference" value="" size="20" maxlength="60" />
                            <br />

                            <label for="Libelle">libelle <span class="requis">*</span></label>
                            <input type="text" id="libelle" name="libelle" value="${pizza.nom}" size="20" maxlength="60" class="form-control input-md"
                            />
                            <br />

                            <label for="prix">prix<span class="requis">*</span></label>
                            <input type="prix" id="prix" name="prix" value="${pizza.prix}" size="20" maxlength="20" class="form-control input-md" />
                            <br />

                            <label for="categorie">categorie</label>
                            <input type="categorie" id="categorie" name="categorie" value="${pizza.categorie}" size="20" maxlength="20" class="form-control input-md"
                            />
                            <br />
                            <button type="submit" class="btn btn-default btn-lg ">Editer</button>

                            <br />
                        </fieldset>
                    </form>

                </div>


  <%@ include file="footer.jsp" %>