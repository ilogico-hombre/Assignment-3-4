package myset;
public class WordEntry {
    String str;
    MyLinkedList<Position> List1=new MyLinkedList<>(); 

public WordEntry(String word)
{
    str=word;   
}
void addPosition(Position position)
{
    List1.add(position);
}
void addPositions(MyLinkedList<Position> positions){
    
    { 
    for(int j=0;;j++)
    {
        List1.add(positions.get(j));
    }
       
    }
}
public MyLinkedList<Position> getAllPositionsForThisWord(){
   
   return List1;
}

}
