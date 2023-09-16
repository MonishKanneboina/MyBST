import java.util.*;
public class MyBST
{
  private BSTNode root;
  private class BSTNode 
  {
    public Integer val;
    public BSTNode left, right;
   
    public BSTNode(Integer val) 
    {
      this.val = val;
      left = right = null;
    }
   
    @Override
    public String toString() 
    { 
      return "" + this.val;
    }
  }
   public int size()
   {
     return size(root);
   } 
   public int size(BSTNode subroot)
   {
     if(subroot == null)
       return 0;

     return 1 + size(subroot.right) + size(subroot.left);
   }
   
   public void insert(Integer n)
   {
     root = iHelper(root, n);
   }
   
   public BSTNode iHelper(BSTNode subroot, Integer n)
   {
     if(subroot == null)
     {
       subroot = new BSTNode(n);
       return subroot;
     }
     
     else if (n < subroot.val)
       subroot.left = iHelper(subroot.left, n);

     else if(n > subroot.val)
       subroot.right = iHelper(subroot.right, n);
     
     return subroot; 
   } 
   
   public boolean contains(Integer n)
   {
     return cHelper(root, n);
   }
   
   public boolean cHelper(BSTNode subroot, Integer n)
   {
     if(subroot == null)
       return false;

     else if(subroot.val == n)
       return true;

     else if(subroot.val < n)
       return cHelper(subroot.right, n);

     else if(subroot.val > n)
      return cHelper(subroot.left, n);

     return cHelper(subroot, n);
   }
   
   public Integer getMax()
   {
    return maxHelper(root);
   }
   
   public Integer maxHelper(BSTNode subroot)
   {
     if(subroot == null)
       return null;
     
     else if(subroot.right != null)
       return maxHelper(subroot.right);
  
     return subroot.val;    
   }
   
   public Integer getMin()
   {
    return minHelper(root);
   }
   
   public Integer minHelper(BSTNode subroot)
   {
     if(subroot == null)
       return null;
       
     else if(subroot.left != null)
       return minHelper(subroot.left);
    
     return subroot.val;    
   }
   
     public void delete(Integer n)
  {
    dHelper(root, n);
  }
  
  public BSTNode dHelper(BSTNode subroot, Integer n)
  {
    if(subroot == null)
       return subroot;
            
     else if(subroot.val < n)
       subroot.right = dHelper(subroot.right, n);
     
     else if(subroot.val > n)
      subroot.left =  dHelper(subroot.left, n);
     
     else if(subroot.val == n)
     {
     
        if(subroot.right != null && subroot.left != null)
                  {
                     subroot.val = minHelper(subroot.right);
                     subroot.right = dHelper(subroot.right, subroot.val);
                  }
                else if (subroot.right == null && subroot.left == null)
                     return null;
                     
                else if (subroot.right == null)
                        return subroot.left;
                        
                  else if (subroot.left == null)
                        return subroot.right;
     }
     return subroot; 
   }
   public void inOrder()
   {
     oHelper(root);
   }
   public void oHelper(BSTNode subroot)
   {
     if(subroot == null)
      return;
     oHelper(subroot.left);
     System.out.print(subroot.val + " ");
     oHelper(subroot.right);
   }
   
   public void print()
   {
     pHelper(root, 0, 1);
   }
   
   public void pHelper(BSTNode subroot, int spaces, int depth)
   {
     if (subroot == null)
        return;
     spaces = 4 * depth; //4 spaces distance
     pHelper(subroot.right, spaces, depth + 1);
     for (int i = 1; i < spaces; i++)
     {
       System.out.print(" ");
     } 
     System.out.print(subroot.val);
     System.out.print("\n");
     pHelper(subroot.left, spaces, depth + 1);          
   }
}