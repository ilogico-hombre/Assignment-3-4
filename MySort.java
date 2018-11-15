package myset;
import java.util.*;
public class MySort {
static ArrayList<SearchResult> sortThisList(MySet<SearchResult> listOfSortableEntries){
ArrayList<SearchResult> sortedlist=new ArrayList<>();
for(int i=0;i<listOfSortableEntries.LL1.size();i++)
{
sortedlist.add(listOfSortableEntries.LL1.get(i));
}
Collections.sort(sortedlist);
return sortedlist;
}    
}
