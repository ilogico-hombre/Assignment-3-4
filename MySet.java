package myset;
public class MySet<X> {
    MyLinkedList<X> LL1=new MyLinkedList();

     void addElement(X element)
    {
     LL1.add(element);
    }
     
     public void Insert (X o){
         if(!LL1.contains(o))
         LL1.add(o);
}
     
public MySet<X> Union(MySet<X> otherSet){
    MySet<X> heypotato = new MySet<X>() ; 
    for(int j=0;j<otherSet.LL1.size();j++) heypotato.LL1.add(otherSet.LL1.get(j)) ;
    for(int j=0;j<LL1.size();j++) if(!otherSet.LL1.contains(LL1.get(j))) heypotato.LL1.add(LL1.get(j)) ;
    return heypotato ;

}

public MySet<X> Intersection(MySet<X> otherSet)
{
    MySet<X> test  =new MySet<>() ;
    if(LL1.size()==0||otherSet.LL1.size()==0) return test ;
    for(int j=0;j<LL1.size();j++) if(otherSet.LL1.contains(LL1.get(j))) test.Insert(LL1.get(j)) ;
    return test;
}

    }

    
    