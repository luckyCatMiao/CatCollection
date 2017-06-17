package Collection;

 import  org.junit.runner.RunWith;
 import  org.junit.runners.Suite;

import CatCollection.XArrayList;
import CatCollection.XQuene;

 @RunWith(Suite. class )
 @Suite.SuiteClasses( {
       
         SortTooltest.class,
         XArrayListTest.class,
         XQueneTest.class,
         XStackTest.class,
         XPriorityQueneTest.class,
         XLinkedListTest.class,
         ChartToolTest.class
         
         } )
 public   class  TestAll  {
 } 