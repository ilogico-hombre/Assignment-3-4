
package myset;
public class AVLtree {
    public Node root;
    public class Node{
        int height;
        Node leftchild;
        Node rightchild;
        Node parent;
        int Key;
    
    
    public Node(int key,Node parent){
    this.Key=key;
    this.parent=parent;
}
    }   
    
    public int height(Node a)
    {
        if(root==null)
            return -1;
        return a.height;
    }
    
    
    
    public Node rotateright(Node a) {
        Node b = a.leftchild;
        a.leftchild = b.rightchild;
        b.rightchild = a;
        a.height = 1 + Math.max(height(a.leftchild), height(a.rightchild));
        b.height = 1 + Math.max(height(b.leftchild), height(b.rightchild));
        return b;
    }
    
    public Node rotateleft(Node a) {
        Node b = a.rightchild;
        a.rightchild = b.leftchild;
        b.leftchild = a;
        a.height = 1 + Math.max(height(a.leftchild), height(a.rightchild));
        b.height = 1 + Math.max(height(b.leftchild), height(b.rightchild));
        return b;
    }
   
   private Node insert(Node a,int key) {
        if (a == null) return new Node(key,null);
        
           if (key<a.Key) 
            a.leftchild = insert(a.leftchild,key); 
        else if (key>a.Key) 
            a.rightchild = insert(a.rightchild,key);  
        
           a.height = 1 + Math.max(height(a.leftchild), height(a.rightchild));
        int difference;
        difference=height(a.leftchild)-height(a.rightchild);
       
        if (difference > 1 && key < a.leftchild.Key) 
            return rotateright(a); 
  
        
        if (difference < -1 && key > a.rightchild.Key) 
            return rotateleft(a); 
   
        if (difference > 1 && key > a.leftchild.Key) { 
            a.leftchild = rotateleft(a.leftchild); 
            return rotateright(a); 
        } 
        if (difference < -1 && key < a.rightchild.Key) { 
            a.rightchild = rotateright(a.rightchild); 
            return rotateleft(a); 
        }
        return a; 
    } 

   public Node findnode(Node a,int key){
       if(a==null)
           return null;
       if(key<a.Key)
           return findnode(a.leftchild,key);
       if(key>a.Key)
           return findnode(a.rightchild,key);
       else return a;  
   }
   
   
          
        }
      
      

