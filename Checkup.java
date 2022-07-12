package Hosptial;

public class Checkup {
    public static final Checkup cu = null;
    Doctor Doctor;
    Patient Patient;
    int prirority;
    String Recommendation,Data;

    public Checkup(Doctor Doctor, Patient Patient,int prirority,String Recommendation,String Data) {
    this.Doctor=Doctor;
    this.Patient=Patient;
    this.prirority=prirority;
    this.Recommendation=Recommendation;
    this.Data=Data;
    }

    public Doctor getDoctor(){
        return Doctor;

    }
    
    public void setDoctor(Doctor Doctor) {
        this.Doctor=Doctor;
    }

    public Patient getPatient(){
        return Patient;
    }

    public void setPatient(Patient patient) {
        this.Patient=patient;
    }

    public int getPriority(){
        return prirority;
    }

    public void setPriority(int priority) {
        this.prirority=priority;
    }

    public String getRecommendation(){
        return Recommendation;
    }
    public void setRecommendation(String Recommendation) {
        this.Recommendation=Recommendation;
    }

    public String getData(){
        return Data;
    }

     public void setData(String Data){
        this.Data=Data;
    }

    public String toString(){
        return "checkup{"+"Doctor"+Doctor.toString()+",patient="+Patient.toString()+"+ Priority="+prirority+"Recommendation="+Recommendation.toString()+"Data"+Data+"}";
    }

    
}
