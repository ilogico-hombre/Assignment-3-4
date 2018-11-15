package myset;
  class Node1<X>
{
    protected X data;
    protected Node1<X> link;
 
    /*  Constructor  */
    public Node1()
    {
        link = null;
        
    }    
    /*  Constructor  */
    public Node1(X d,Node1 n)
    {
        data = d;
        link = n;
    }    
    /*  Function to set link to next Node1  */
    public void setLink(Node1 n)
    {
        link = n;
    }    
    /*  Function to set data to current Node1  */
    public void setData(X d)
    {
        data = d;
    }    
    /*  Function to get link to next Node11  */
    public Node1 getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node1  */
    public X getData()
    {
        return data;
    }
  }

  public class MyLinkedList<X>
{
    protected Node1 start;
    protected Node1 end ;
    public int size ;
 
    /*  Constructor  */
    public MyLinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return start == null;
    }
    /*  Function to get size of list  */
    public int size()
    {
        return size;
    }    
    /*  Function to insert an element at end  */
    public boolean add(X val)
    {
        Node1 nptr = new Node1(val,null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            end.setLink(nptr);
            end = nptr;
        }
        return true;
    }
    /*  Function to insert an element at position  */
    public void add(int pos, X val )
    {
        Node1 nptr = new Node1(val, null);                
        Node1 ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++) 
        {
            if (i == pos) 
            {
                Node1 tmp = ptr.getLink() ;
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size++ ;
    }
    public boolean remove(X val) {
    	 Node1 ptr = start;
    	 int test=0;
    	 if(ptr.getData()==val) {
    		 start=start.getLink();
    		 test=1;}
    	 else {
    	 while(ptr.getLink()!=null) {
    		 Node1 temp=ptr;
    		 temp=temp.getLink();
    		 if(temp.getData()==val) {
    			 ptr.setLink(temp.getLink());
    			 test=1;
    			 break;
    		 }
    		 ptr=ptr.getLink();
    	  }
    	 }
    	 if(test==1) {
    		 size--;
    		 return true;
    	 }
    	 else return false;
    }
    public boolean contains(X val) {
    	Node1 ptr=start;
    	int test=0;
    	while(ptr!=null) {
    		if(ptr.getData()==val) {
    			test=1;
    			break;}
    		ptr=ptr.getLink();
    	}
        return test==1;
    }
    public X get(int i) {
    	Node1 ptr= start;
    	int count;
    	if(i<0||i>=size)
    		return null;
    	for(count=0;count<i && ptr.getLink()!=null;count++) {
    		ptr=ptr.getLink();
    	}
        if(ptr==null) return null;
    	return (X) ptr.getData();
    }
}
  

  

