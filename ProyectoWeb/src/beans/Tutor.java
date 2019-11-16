package beans;

public class Tutor {
	private String nombre;
    private String primerApellido;
    private String segundoApellido;
    
    public void setnombre (String name){nombre=name;}
    public void setprimerApellido (String fSecondName){primerApellido=fSecondName;}
    public void setsegundoApellido (String sSecondName){segundoApellido=sSecondName;}
    
    public String getnombre(){return nombre;}
    public String getprimerApellido(){return primerApellido;}
    public String getsegundoApellido(){return segundoApellido;}
    
    public Tutor (String nombre, String primerApellido, String segundoApellido)
    {
        this.nombre=nombre;
        this.primerApellido=primerApellido;
        this.segundoApellido=segundoApellido;
    }
    
    @Override
    public String toString(){
        return nombre+"/"+primerApellido+"/"+segundoApellido;
    }
}