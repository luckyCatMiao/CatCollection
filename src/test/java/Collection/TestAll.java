package Collection;

 import  org.junit.runner.RunWith;
 import  org.junit.runners.Suite;

import CatCollection.XArrayList;
import CatCollection.XQuene;
import CatCollection.Map.XHashMap;
import CatCollection.Tree.XBinaryTree;

 @RunWith(Suite. class )
 @Suite.SuiteClasses( {
       
         SortTooltest.class,
         XArrayListTest.class,
         XQueneTest.class,
         XStackTest.class,
         XPriorityQueneTest.class,
         XLinkedListTest.class,
         ChartToolTest.class,
         XChartTest.class,
         XBinaryTreeTest.class,
         XHashMapTest.class
         
         } )
 public   class  TestAll  {
 } 