package ch.bbw.th.urbandictionary;

public class DefinitionObject
{
    private String defid;

    private String[] sound_urls;

    private String thumbs_down;

    private String author;

    private String written_on;

    private String definition;

    private String permalink;

    private String thumbs_up;

    private String word;

    private String current_vote;

    private String example;

    public String getDefid ()
    {
        return defid;
    }

    public void setDefid (String defid)
    {
        this.defid = defid;
    }

    public String[] getSound_urls ()
    {
        return sound_urls;
    }

    public void setSound_urls (String[] sound_urls)
    {
        this.sound_urls = sound_urls;
    }

    public String getThumbs_down ()
    {
        return thumbs_down;
    }

    public void setThumbs_down (String thumbs_down)
    {
        this.thumbs_down = thumbs_down;
    }

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public String getWritten_on ()
    {
        return written_on;
    }

    public void setWritten_on (String written_on)
    {
        this.written_on = written_on;
    }

    public String getDefinition ()
    {
        return definition;
    }

    public void setDefinition (String definition)
    {
        this.definition = definition;
    }

    public String getPermalink ()
    {
        return permalink;
    }

    public void setPermalink (String permalink)
    {
        this.permalink = permalink;
    }

    public String getThumbs_up ()
    {
        return thumbs_up;
    }

    public void setThumbs_up (String thumbs_up)
    {
        this.thumbs_up = thumbs_up;
    }

    public String getWord ()
    {
        return word;
    }

    public void setWord (String word)
    {
        this.word = word;
    }

    public String getCurrent_vote ()
    {
        return current_vote;
    }

    public void setCurrent_vote (String current_vote)
    {
        this.current_vote = current_vote;
    }

    public String getExample ()
    {
        return example;
    }

    public void setExample (String example)
    {
        this.example = example;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [defid = "+defid+", sound_urls = "+sound_urls+", thumbs_down = "+thumbs_down+", author = "+author+", written_on = "+written_on+", definition = "+definition+", permalink = "+permalink+", thumbs_up = "+thumbs_up+", word = "+word+", current_vote = "+current_vote+", example = "+example+"]";
    }
}
