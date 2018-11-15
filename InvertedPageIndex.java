package myset;
public class InvertedPageIndex {
static MySet<PageEntry> PE1=new MySet<>(); 
    
    void addPage(PageEntry p){
   PE1.Insert(p);
}   
    
    
    static MySet<PageEntry> getPagesWhichContainWord(String str){
       
       MySet<PageEntry> PE2=new MySet<>();
       for(int i=0;i<PE1.LL1.size();i++)
       {
           for(int j=0;j<PE1.LL1.get(i).Page1.PI1.size();j++){
           if(PE1.LL1.get(i).Page1.PI1.get(j).str.equals(str)){
               PE2.Insert(PE1.LL1.get(i));
           //System.out.println(PE1.LL1.get(i).pagename);
             //  break;
                       }
           }
       }   
       return PE2;
    }
    static MySet<PageEntry> getPagesWhichContainAllWords(String str[])
    {
       MySet<PageEntry> PE3=(getPagesWhichContainWord(str[0]));
       //System.out.print(str[0]);
       for(int j=0;j<str.length;j++)
       {
           PE3=PE3.Intersection(getPagesWhichContainWord(str[j]));
           //System.out.println(getPagesWhichContainWord(str[j]).LL1.size);
           
       }
       return PE3;
       
    }
    
    static MySet<PageEntry> getPagesWhichContainAnyOfTheWords(String str[])
    {
        MySet<PageEntry> PE4=new MySet<>();
        for(int k=0;k<str.length;k++)
        {
            PE4=PE4.Union(getPagesWhichContainWord(str[k]));
        }
        return PE4;
    }
    
    static MySet<PageEntry> getPagesWhichContainPhrase(String str[]){
       MySet<PageEntry> PE5=new MySet<>();   
       MySet<PageEntry> PE6=getPagesWhichContainAllWords(str);
       int flag=0;
       for(int a=0;a<PE6.LL1.size();a++)
       { 
           //System.out.println("  dfsffd ");
           for(int b=0;b<PE6.LL1.get(a).Page1.PI1.size();b++)
           {flag=0;
           
               if(PE6.LL1.get(a).Page1.PI1.get(b).str.equals(str[0]))
               {
                   
               for(int c=0;c<str.length;c++)
               {
               if(!PE6.LL1.get(a).Page1.PI1.get(b+c).str.equals(str[c])){
               break;
               }else{
                   if(c==str.length-1){ 
               PE5.Insert(PE6.LL1.get(a));
           }
                   }
               }
               } 
              }
           
    }
    return PE5;
    }
}
    
    
