package beans;

public class Escuela {
	private String nombre;
    private String areaConocimiento;
    
    public void setnombre (String name){nombre=name;}
    public void setareaConocimiento (String knowledgeArea){areaConocimiento=knowledgeArea;}
    
    public String getnombre(){return nombre;}
    public String getareaConocimiento(){return areaConocimiento;}
    
    public Escuela (String nombre, String areaConocimiento)
    {
        this.nombre=nombre;
        this.areaConocimiento=areaConocimiento;
    }
    
    @Override
    public String toString(){
        return nombre+"/"+areaConocimiento;
    }
}