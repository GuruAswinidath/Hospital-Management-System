package Hosptial;

public class Patient {
    
    private String Id,Name,Contact,B_Group,B_P;
    


    public Patient(){
        Id=" ";
        this.Name=" ";
        this.Contact=" "; 
        this.B_P=" ";
        this.B_Group=" ";
    
    }

    public Patient(String Id,String Name, String Contact,String B_Group,String B_P){
        this.Id=Id;
        this.Name=Name;
        this.Contact=Contact;
        this.B_Group=B_Group;
        this.B_P=B_P;
   
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

    public void setCount(String Contact){
        this.Contact=Contact;

    }
    
     public void setB_Group(String B_Group){
        this.B_Group=B_Group;
    }

    public void setB_P(String B_P){
        this.B_P=B_P;
    }

    public void setGender(String Gender){
        this.Gender=Gender;
    }

    public void Date_Birth(String Date_Birth){
        this.Date_Birth=Date_Birth;
    }

    public Object getId() {
        return Id;
    }

    public String toString(){
        return "{"+"paients("+"Id="+Id+", Name="+Name+", Contact="+Contact+",B_Group="+B_Group+", B_P="+B_P+")"+"}";
    }

}
