package beans;

public class Enfermedad {
	private String nombre;
    private String indicacion;
    
    public void setnombre (String name){nombre=name;}
    public void setindicacion (String indication){indicacion=indication;}
    
    public String getnombre(){return nombre;}
    public String getindicacion(){return indicacion;}
    
    public Enfermedad (String nombre, String indicacion)
    {
        this.nombre=nombre;
        this.indicacion=indicacion;
    }
    
    @Override
    public String toString(){
        return nombre+"/"+indicacion;
    }
}