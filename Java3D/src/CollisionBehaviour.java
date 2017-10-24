import java.util.*;
import javax.media.j3d.*;


public class CollisionBehaviour extends Behavior {


   public Switch wallSwitch;
   public TransformGroup train; 

   public WakeupCriterion[] initialCriteria;
   public WakeupCriterion[] procStimCriteria;

   public WakeupOr initial_wakeUpCondition;
   public WakeupOr procStim_wakeUpCondition;

   /* BEGIN THE CONSTRUCTOR FOR THIS CLASS  --------------------------------- */
    public CollisionBehaviour(TransformGroup theTrain, Switch theSwitch, Bounds theBounds)
    {
       train = theTrain;
       wallSwitch = theSwitch;
       setSchedulingBounds(theBounds);
    }
   /* END THE CONSTRUCTOR FOR THIS CLASS  --------------------------------- */

  /* BEGIN INITIALISE BEHAVIOR  --------------------------------- */
   public void initialize()
   {
	//wakeup when the train enters or exits the bounds of the switch
     initialCriteria = new WakeupCriterion[2];
     initialCriteria[0] = new WakeupOnCollisionEntry(train);
     initialCriteria[1] = new WakeupOnCollisionExit(train);
     initial_wakeUpCondition = new WakeupOr(initialCriteria);
     wakeupOn(initial_wakeUpCondition); 
     procStimCriteria = new WakeupCriterion[2];
     procStimCriteria[0] = new WakeupOnCollisionEntry(train);
     procStimCriteria[1] = new WakeupOnCollisionExit(train);
   }
    
   public void processStimulus(Enumeration criteria)
   {

       while (criteria.hasMoreElements())

       {
         WakeupCriterion theCriterion = (WakeupCriterion) criteria.nextElement();
         if (theCriterion instanceof WakeupOnCollisionEntry) 
         {
        	 //brown to red
       	    if (wallSwitch.getWhichChild() == 0) {wallSwitch.setWhichChild(1);} 
       	    else     {
       	    //red to yellow
       		if (wallSwitch.getWhichChild() == 1){wallSwitch.setWhichChild(2);} 
       	    else{
       	    //yellow to red
       	    if (wallSwitch.getWhichChild() == 2){wallSwitch.setWhichChild(1);} 
       	    }
       		}
         } // end if entry 
         else
         {
       	    if (theCriterion instanceof WakeupOnCollisionExit) 
           {
       	   //red to yellow
       		if (wallSwitch.getWhichChild() == 1){wallSwitch.setWhichChild(2);}
       		else {
       		//yellow to red
       		if (wallSwitch.getWhichChild() == 2){wallSwitch.setWhichChild(2);}
       		}
       	  } // end if exit
         } // end else	
	 } // end while end complex process -- */ 

      procStim_wakeUpCondition = new WakeupOr(procStimCriteria);
      wakeupOn(procStim_wakeUpCondition); 

   } // end process stimulus 

   /* END PROCESS STIMULUS BEHAVIOR  --------------------------------- */
 
} 