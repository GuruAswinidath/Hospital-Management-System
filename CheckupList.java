package Hosptial;

class CNode{
    Checkup cu;
    CNode next,prev;
   public CNode(Checkup cu){
        next=prev=null;
        this.cu=cu;
    }
}

public class CheckupList {
    CNode head,tail;
    public CheckupList(){
        head=null;
        tail=null;
    }

    public void Enqueue(Checkup cu){
        CNode node=new CNode(cu);
        if(head==null||tail==null){
            head=node;
            tail=node;
        }
            
        else if(head.cu.getPriority()<cu.getPriority()){
            head.next=node;
            node.prev=head;
            head=node;
        }

        else if(tail.cu.getPriority()>=cu.getPriority()){
            head.next=node;
            node.prev=head;
           head=node;
        }
        
        else{
            CNode temp=tail;
            while(temp!=null){
                if(temp.cu.getPriority()>=cu.getPriority()){
                    break;
                }
             temp=temp.next;
            }
         node.next=temp;
         node.prev=temp.prev;
          temp.prev.next=node;
          temp.prev=node;
            
        }
    }

    public Checkup  Deqeue(){
        if(head==null){
            return null;
        }
        CNode Checkup=head;
        head=head.next;
        return Checkup.cu;
    }

    public void addrecommendation(int index,String rec){
        CNode temp=head;
        int i=0;
        while(temp!=null){
            if(index==i){
                temp.cu.setRecommendation(rec);
                break;
            }
            i++;
            temp=temp.prev;
        }
    }
    public Patient getpatient(int index){
        CNode temp=head;
        int i=0;
        while(temp!=null){
            if(index==i){
                break;
            }
            i++;
            temp=temp.prev;
        }
            return temp.cu.getPatient();
    }

    public void print(){
        CNode temp=head;
        while(temp!=null){
            System.out.println(temp.cu.getPriority()+"  "+temp.cu.getRecommendation());
            temp=temp.prev;
        }
    }
}
