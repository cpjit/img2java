/**
* 管控情况
*/
public interface ControlControlSituation { 
   /**
    * 在控
    */
   String IN_CONTROL = "01";
   /**
    * 失控
    */
   String CONTROL_BE_OUT = "02";
   /**
    * 死亡
    */
   String DEATH = "03";
   /**
    * 出国(境)
    */
   String GO_ABROAD = "04";
   /**
    * 社会面戒断三年未复吸
    */
   String SOCIAL_WITHDRAWAL_THREE_YEARS = "05";
   /**
    * 社会面戒断不满三年
    */
   String SOCIAL_WITHDRAWAL_THREE_YEARS = "06";
 } 
