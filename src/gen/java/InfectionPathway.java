/**
* 感染途径
*/
public interface InfectionPathway { 
   /**
    * 异性性传播
    */
   String HETEROSEXUAL_TRANSMISSION = "01";
   /**
    * 同性性传播
    */
   String HOMOSEXUAL_TRANSMISSION = "02";
   /**
    * 注射毒品传播
    */
   String INJECTION_DRUG_TRANSMISSION = "03";
   /**
    * 母婴传播
    */
   String MOTHER_TO_CHILD_TRANSMISSION = "04";
   /**
    * 输血及使用血制品传播
    */
   String BLOOD_TRANSFUSION_USE_OF_BLOOD_PRODUCTS_TRANSMISSION = "05";
   /**
    * 性接触加注射毒品传播
    */
   String SEXUAL_CONTACT_PLUS_INJECTION_DRUG_TRANSMISSION = "06";
   /**
    * 既往采血浆传播
    */
   String PAST_PLASMA_COLLECTION = "07";
   /**
    * 不详
    */
   String UNKNOWN = "99";
 } 
