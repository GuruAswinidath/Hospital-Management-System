package Hosptial;

class PNode{
    Patient patient;
    PNode next,prev;

    public PNode(){

    } 

    public PNode(Patient patient){
        this.patient=patient;
        next=null;
        prev=null;
    }

    public static class Patientlist {
     PNode head,tail;

    public Patientlist(){
        head=null;
        tail=null;
    }

    public void Insert(Patient patient){
        PNode node=new PNode(patient);

        if(head==null||tail==null){
            head=node;
            tail=node;

        }
        else{
            head.next=node;
            node.prev=head;
            head=node;

        }

    }
    public Patient searchByID(String id){
         PNode temp=head;
        while(temp!=null){
            if(temp.patient.getId().equals(id)){
                return temp.patient;
            }
            temp=temp.prev;
        }
        return null;
    }
    public Patient searchbyContanct(String Contact){
        PNode temp=head;
        while(temp!=null){
            if(temp.patient.getContact().equals(Contact)){
                return temp.patient;
            }
            temp=temp.prev;
        }
        return null;
    }
    
    public void PrintData(){
        PNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            System.out.println(count+":   "+temp.patient.toString());
            temp=temp.prev;
        }
    }
    
}
}