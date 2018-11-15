package myset;
public class Position 
{
PageEntry page;
int wordIndex;

  public Position(PageEntry p,int wordIndex){
page=p;
this.wordIndex=wordIndex;
  }  
PageEntry getPageEntry(){
return page;
}
int getWordIndex(){ 
return wordIndex;
}    
}


