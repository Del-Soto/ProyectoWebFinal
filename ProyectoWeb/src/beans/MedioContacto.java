package beans;

public class MedioContacto {
	private String telefono;
    private String correo;
    
    public void settelefono (String phone){telefono=phone;}
    public void setcorreo (String mail){correo=mail;}
    
    public String gettelefono(){return telefono;}
    public String getcorreo(){return correo;}
    
    public MedioContacto (String telefono, String correo)
    {
        this.telefono=telefono;
        this.correo=correo;
    }
    
    @Override
    public String toString(){
        return telefono+"/"+correo;
    }
}