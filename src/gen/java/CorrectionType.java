/**
* 矫正解除类型
*/
public interface CorrectionType { 
   /**
    * 期满解除
    */
   String EXPIRY = "01";
   /**
    * 收监执行
    */
   String CARRY_OUT_SUPERVISION = "02";
   /**
    * 死亡
    */
   String DEATH = "03";
   /**
    * 居住地变更
    */
   String RESIDENCE_CHANGE = "04";
   /**
    * 其他
    */
   String OTHER = "99";
 } 
