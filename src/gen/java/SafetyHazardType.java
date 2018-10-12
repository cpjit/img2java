/**
* 安全隐患类型
*/
public interface SafetyHazardType { 
   /**
    * 无
    */
   String NOTHING = "00";
   /**
    * 治安隐患
    */
   String PUBLIC_SECURITY_HIDDEN_DANGER = "01";
   /**
    * 消防隐患
    */
   String FIRE_HAZARD = "02";
   /**
    * 矛盾纠纷隐患
    */
   String CONTRADICTIONS_DISPUTES = "03";
   /**
    * 劳资纠纷隐患
    */
   String HIDDEN_TROUBLE_IN_LABOR_DISPUTES = "04";
   /**
    * 其他
    */
   String OTHER = "99";
 } 
