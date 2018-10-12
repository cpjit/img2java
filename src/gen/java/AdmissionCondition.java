/**
* 收治情况
*/
public interface AdmissionCondition { 
   /**
    * 无
    */
   String NOTHING = "00";
   /**
    * 羁押
    */
   String TAKE_INTO_CUSTODY = "01";
   /**
    * 抗病毒治疗
    */
   String ANTIVIRAL_THERAPY = "02";
   /**
    * 戒毒药物维持治疗
    */
   String DRUG_ADDICTION_MAINTENANCE_TREATMENT = "03";
   /**
    * 其他
    */
   String OTHER = "99";
 } 
