package myset;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class SearchEngine {
    InvertedPageIndex IPI1=new InvertedPageIndex();
    
    String converttosingular(String plural){
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

void performAction(String actionMessage) throws FileNotFoundException{
    
    String String1="addPage";
    String String2="queryFindPagesWhichContainWord";
    String String3="queryFindPositionsOfWordInAPage";
    String String4="queryFindPagesWhichContainAllWords";
    String String5="queryFindPagesWhichContainAnyOfTheseWords";
    String String6="queryFindPagesWhichContainPhrase";
    
    int countspace=0;
    String a1="",a2="",a3="";
    String[] Actionmsg;
        Actionmsg = actionMessage.split(" ");
    int i=0;
    while(i<actionMessage.length())
    {
        if(actionMessage.charAt(i)==' '){
            countspace++;
        }
        else if(countspace==0)
        a1=a1+actionMessage.charAt(i);
        else if(countspace==1)
            a2=a2+actionMessage.charAt(i);
        else 
            a3=a3+actionMessage.charAt(i);
        
        i++;
    }
if(a1.equals(String1))
{
    try{
    PageEntry newpage=new PageEntry(a2);
    newpage.IPI=this.IPI1;
    IPI1.addPage(newpage);
    }catch(Exception e){
        System.out.println("404:Page not found");
    }
    
}
if(a1.equals(String2))
{
 a2=converttosingular(a2);
    a2=a2.toLowerCase();
   MySet<PageEntry> MS1=IPI1.getPagesWhichContainWord(a2);
   for(int k=0;k<MS1.LL1.size();k++)
   {
       System.out.print(MS1.LL1.get(k).pagename);
       if(k==MS1.LL1.size()-1)
           System.out.print("\n");
       else
           System.out.print(",");
   }
   
  
   
if(MS1.LL1.size()==0)
    System.out.println("No webpage contains word "+a2);
}

if(a1.equals(String3))
{
    a2=converttosingular(a2);
    
    a2=a2.toLowerCase();
    a3=a3.toLowerCase();
    PageEntry Pen1=null;
    for(int m=0;m<IPI1.PE1.LL1.size();m++)
    {
        if(IPI1.PE1.LL1.get(m).pagename.equals(a3))
           Pen1=IPI1.PE1.LL1.get(m);
    }
    int flag=0;
    if(Pen1==null)
    {
        System.out.println("Error");
        return;
    }
    for(int l=0;l<Pen1.Page1.PI1.size();l++)
    {
        if(Pen1.Page1.PI1.get(l).str.equals(a2)){
            
            for(int j=0;j<Pen1.Page1.PI1.get(l).List1.size();j++){
                flag++;
            System.out.print(Pen1.Page1.PI1.get(l).List1.get(j).wordIndex+",");
            
            }       
    }
    }
     if(flag==0)
            System.out.println("Webpage "+a3+"does not contain word "+a2);
    System.out.print("\n");
    if(!(IPI1.PE1.LL1.contains(Pen1)))
        System.out.println("No webpage "+a3+"found");
}

if(a1.equals(String4)){
  String[] query1 = new String[Actionmsg.length-1];
for(int p=0;p<Actionmsg.length-1;p++)
{
    Actionmsg[p+1]=converttosingular(Actionmsg[p+1]);
    Actionmsg[p+1]=Actionmsg[p+1].toLowerCase();
    query1[p]=Actionmsg[p+1];
}
//System.out.println(query1[1]+" "+query1.length);
    MySet<PageEntry> allwords=IPI1.getPagesWhichContainAllWords(query1);
    MySet<SearchResult> all=new MySet<>();
        for(int h=0;h<allwords.LL1.size();h++)
        {
           all.Insert(new SearchResult(allwords.LL1.get(h),allwords.LL1.get(h).getRelevanceOfPage(query1,false)));
        
}
        ArrayList<SearchResult> AL1=MySort.sortThisList(all);
        if(AL1 == null){
            System.out.println("ERROR");
            return;
        }
    if(!AL1.isEmpty())
    {
        for(int l=0;l<AL1.size();l++){
            System.out.print(AL1.
                get(l).
                pageentry.
                pagename+", ");
        }
        System.out.print("\n");
    }
  
}

if(a1.equals(String5)){
  String[] query1 =new String[Actionmsg.length-1];
for(int p=0;p<Actionmsg.length-1;p++)
{
    Actionmsg[p+1]=converttosingular(Actionmsg[p+1]);
    Actionmsg[p+1]=Actionmsg[p+1].toLowerCase();
    query1[p]=Actionmsg[p+1];
}
    MySet<PageEntry> anyword=IPI1.getPagesWhichContainAnyOfTheWords(query1);
    MySet<SearchResult> any=new MySet<>();
       for(int h=0;h<anyword.LL1.size();h++)
        {
           any.Insert(new SearchResult(anyword.LL1.get(h),anyword.LL1.get(h).getRelevanceOfPage(query1,false)));
        
}
        ArrayList<SearchResult> AL2=MySort.sortThisList(any);
        if(AL2 == null){
            System.out.println("ERROR");
            return;
        }
    if(!AL2.isEmpty())
    {
        for(int l=0;l<AL2.size();l++){
            System.out.print(AL2.
                get(l).
                pageentry.
                pagename+", ");
        }
        System.out.print("\n");
    }
}

if(a1.equals(String6)){
  String[] query1 = new String[Actionmsg.length-1];
for(int p=0;p<Actionmsg.length-1;p++)
{
    Actionmsg[p+1]=converttosingular(Actionmsg[p+1]);
    Actionmsg[p+1]=Actionmsg[p+1].toLowerCase();
    query1[p]=Actionmsg[p+1];
}
 MySet<PageEntry> phrasepages=IPI1.getPagesWhichContainPhrase(query1);
  MySet<SearchResult> use=new MySet<>();

   for(int w=0;w<phrasepages.LL1.size();w++)
        {
           use.Insert(new SearchResult(phrasepages.LL1.get(w),phrasepages.LL1.get(w).getRelevanceOfPage(query1,true)));
        
}
  
  if(phrasepages.LL1.size()==0)
{
    System.out.println("ERROR");
}
ArrayList<SearchResult> AL3=MySort.sortThisList(use);
        if(AL3 == null){
            System.out.println("ERROR");
            return;
        }
    if(!AL3.isEmpty())
    {
        for(int l=0;l<AL3.size();l++){
            System.out.print(AL3.
                get(l).
                pageentry.
                pagename+", ");
        }
        System.out.print("\n");
    }
}
}
}