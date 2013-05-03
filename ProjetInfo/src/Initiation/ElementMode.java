package Initiation;



public class ElementMode {
    private String Theme;
    private String Question;
    private String Reponse;
    private String Explication;
    public ElementMode(String n,String q,String p,String r) {
        Theme=n;
        Question=q;
        Reponse=p;
        Explication=r;
       
    }
    public String getTheme(){
      return Theme;
    }
    public String getQuestion(){
      return Question;
    }
    public String getReponse(){
      return Question;
    }
    public String getExplication(){
      return Explication;
    }
    public void setReponse(String Reponse){
     this.Reponse=Reponse;
    
    }
    public String toString(){
      return Question+"voila la reponse: "+Reponse+Explication;
    }
}
    
    

