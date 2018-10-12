/**
* 隐患类型
*/
public interface HiddenDangerType { 
   /**
    * 无
    */
   String NOTHING = "00";
   /**
    * 火灾隐患
    */
   String FIRE_HAZARD = "01";
   /**
    * 治安隐患
    */
   String PUBLIC_SECURITY_HIDDEN_DANGER = "02";
   /**
    * 矛盾纠纷隐患
    */
   String CONTRADICTIONS_DISPUTES = "03";
   /**
    * 危化物品隐患
    */
   String HAZARDOUS_CHEMICALS_HIDDEN_DANGER = "04";
   /**
    * 疾病传染隐患
    */
   String INFECTIOUS_DISEASES_RISK = "05";
   /**
    * 其他
    */
   String OTHER = "99";
 } 
