   <%@ include file="entete.jsp" %>

       
                <div class="container">
                    <form method="post" >
                        <fieldset>
                            <legend>Ajout de pizza</legend>
                            <p>Vous pouvez rentrer votre pizza.</p>

                            <label for="reference">Reference <span class="requis">*</span></label>
                            <input type="text" id="reference" class="form-control input-md" name="reference" value="" size="20" maxlength="60" />
                            <br />

                            <label for="Libelle">libelle <span class="requis">*</span></label>
                            <input type="text" id="libelle" name="libelle" value="" size="20" maxlength="60" class="form-control input-md"/>
                            <br />

                            <label for="prix">prix<span class="requis">*</span></label>
                            <input type="prix" id="prix" name="prix" value="" size="20" maxlength="20" class="form-control input-md"/>
                            <br />

                            <label for="categorie">categorie</label>
                            <input type="categorie" id="categorie" name="categorie" value="" size="20" maxlength="20" class="form-control input-md" />
                            <br />
                            <button type="submit" class="btn btn-default btn-lg ">AJOUT</button>
                            
                            <br />
                        </fieldset>
                    </form>
                    
                </div>

                
                
             <%@ include file="footer.jsp" %>