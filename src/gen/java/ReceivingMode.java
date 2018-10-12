/**
* 接收方式
*/
public interface ReceivingMode { 
   /**
    * 自行报到
    */
   String SELF_REPORTING = "01";
   /**
    * 狱所押送
    */
   String PRISON_ESCORT = "02";
   /**
    * 当庭交接
    */
   String HAND_OVER_IN_COURT = "03";
   /**
    * 其他
    */
   String OTHER = "99";
 } 
