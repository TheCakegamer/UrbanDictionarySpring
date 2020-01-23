package ch.bbw.th.urbandictionary;

public class DefinitionList
{
    private DefinitionObject[] list;

    public DefinitionObject[] getList ()
    {
        return list;
    }

    public void setList (DefinitionObject[] list)
    {
        this.list = list;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [list = "+list+"]";
    }
}
