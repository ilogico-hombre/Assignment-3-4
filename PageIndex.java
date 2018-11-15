package myset;
public class PageIndex {
    
    MyLinkedList<WordEntry> PI1=new MyLinkedList<>();
void addPositionForWord(String str, Position p){
    int i;
    for(i=0;i<PI1.size();i++)
    {
        if((PI1.get(i)).equals(str))
            break;
    }
    if(i<PI1.size()-1)
    PI1.get(i).addPosition(p);
    
    WordEntry WE1=new WordEntry(str);
    WE1.addPosition(p);
    
}   
MyLinkedList<WordEntry> getWordEntries(){
    
   return PI1;
}
}
