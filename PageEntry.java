package myset;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class PageEntry {
    
    private String converttosingular(String plural){
        String ss1=plural.toLowerCase();
        if(ss1.equals("stacks"))
        {
            ss1="stack";
        }
        if(ss1.equals("applications"))
        {
            ss1="application";
        }if(ss1.equals("structures"))
        {
            ss1="structure";
        }
        return ss1;
        
    }
    PageIndex Page1=new PageIndex();
    String pagename;
    InvertedPageIndex IPI;
    PageEntry(String pageName) throws FileNotFoundException{
        
        FileInputStream Scanned;
        pagename=pageName;
        Scanned = new FileInputStream("./webpages/"+pageName);
        Scanner s1=new Scanner(Scanned);
        int count=1;
        while(s1.hasNext())
        {
         
          String input= s1.nextLine();
          input=input.toLowerCase();
          String[]Array1=input.split("\\s++|\\{|}|<|>|\\(|\\)|\\.|,|;|'|\"|\\?|#|!|-|:");
          String[] Array2={"a","an","the","they","this","these","for","is","are","was","of","or","and","does","will","whose"};
          for(int i=0;i<Array1.length;i++)
        {
            int fl=0;
        if(!Array1[i].equals(""))
        {
            for(int j=0;j<Array2.length;j++)
            {
                if(Array1[i].equals(Array2[j]))
                   fl=1;  
            }
            if(fl==0){
                WordEntry we = new WordEntry(this.converttosingular(Array1[i]));
                we.addPosition(new Position(this,count));
            Page1.PI1.add(we);
            
            }    
            count++;
        }
        }          
    }
    }
            PageIndex getPageIndex(){
                return Page1;
            }
      
            int phraseoccurencefrequency(String str[]){
                int m=0,flag=0;
                for(int b=0;b<this.Page1.PI1.size();b++)
           {flag=0;
               if(this.Page1.PI1.get(b).str.equals(str[0]))
               {
                   
               for(int c=0;c<str.length;c++)
               {
                   
               if(this.Page1.PI1.get(b+c).str.equals(str[c])){
                   if(c==str.length-1){
                       m++;
                   }
                   //System.out.println(c);
               }
                   else break;
               }
               } 
              }
            return m;
            }
    float getinversedocumentfrequency(String str[])
    {
        float idf;
        MySet<PageEntry> temp=new MySet<>();
        temp=IPI.getPagesWhichContainPhrase(str);
        int size=temp.LL1.size();
        int size2=IPI.PE1.LL1.size();
        //System.out.println(temp.LL1.size());
        if(size==0) return 0 ;
        idf=(float)Math.log((float)size2/(float)size);
        return idf;
    }
           
            float getRelevanceOfPage(String str[ ], boolean doTheseWordsRepresentAPhrase){
             int k=str.length-1;
             int Wp=0;
             float rel=0;
             int m=phraseoccurencefrequency(str);
             for(int i=0;i<Page1.PI1.size;i++){
                 Wp+=Page1.PI1.get(i).List1.size;
                 
             }
            float tw=(float)m/((float)Wp+(float)k*(float)m);
            
             float idf1=getinversedocumentfrequency(str);
             
             if(doTheseWordsRepresentAPhrase==false){
                 for(int i=0;i<str.length;i++){
                     String[] s = new String[1];
                     s[0]=str[i];
                     idf1=getinversedocumentfrequency(s);
                     float mw=getTermFrequency(str[i]);
                     rel+=mw*idf1;
                     
                 }
                 
                 
             }
             if(doTheseWordsRepresentAPhrase==true){
                // System.out.println(idf1+" "+tw+" "+m+" "+Wp);
             rel=tw*idf1;
             }
             
             return rel;
            }
           public float getTermFrequency(String word){
                float tf;
                int count=0;
                for(int i=0;i<Page1.PI1.size();i++)
                {
                    if(Page1.PI1.get(i).str.equals(word))
                        count++;
                }
                //System.out.println(count);
                int frequencyofword=count;
                int allwordsnumber=Page1.PI1.size();
                tf=(float)frequencyofword/(float)allwordsnumber;
                return tf;
    
            }
            
    
}
