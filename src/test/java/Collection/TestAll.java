package Collection;

 import  org.junit.runner.RunWith;
 import  org.junit.runners.Suite;

import CatCollection.XArrayList;
import CatCollection.XQuene;
import CatCollection.Tree.XTreeList;

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
         XTreeList.class
         
         } )
 public   class  TestAll  {
 } 