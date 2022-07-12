package Hosptial;

public class Doctor {
    private String Id,Name,Contact,Specialization;
    private int fees;


    public Doctor(String Id,String Name, String Contact, String Specialization,int fees){
        this.Id=Id;
        this.Name=Name;
        this.Contact=Contact;
        this.Specialization=Specialization;
        this.fees=fees;
    }

     public String getId(){
            return Id;
    }

    public void setId(String Id){
            this.Id=Id;

    }
    
    public String getName(){
            return Name;

    }

    public void setName(String Name){
            this.Name=Name;
    }

    
    public String getContact(){
        return Contact;
    }

    public void setContact(String Contact){
        this.Contact=Contact;

    }

    public String getSpecialization(){
        return Specialization;

    }

    public int getFees(){
        return fees;
        
    }

    public void setfees(int fees){
        this.fees=fees;

    }

    public String toString(){
        return "Doctor{"+"Id="+Id+",Name="+Name+",Contact="+Contact+",specialization="+Specialization+",fees="+fees+"}";
    }
    
}
