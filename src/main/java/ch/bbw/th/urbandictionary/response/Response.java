package ch.bbw.th.urbandictionary.response;

import ch.bbw.th.urbandictionary.definition.DefinitionList;
import ch.bbw.th.urbandictionary.gif.Gif;

public class Response {

    public String term = "";
    public DefinitionList definitionList;
    public Gif gif;


    public Response(String term) {
        this.term = term;
        this.definitionList = new DefinitionList(term);
        this.gif = new Gif(term);

    }

    public DefinitionList getDefinitionList() {
        return new DefinitionList(term);
    }

    public void setDefinitionList(DefinitionList definitionList) {
        this.definitionList = definitionList;
    }

    public Gif getGif() {
        return new Gif(term);
    }

    public void setGif(Gif gif) {
        this.gif = gif;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
