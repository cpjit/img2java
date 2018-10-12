/**
* 控股情况
*/
public interface HoldingSituation { 
   /**
    * 国有控股
    */
   String STATE_OWNED_HOLDINGS = "110";
   /**
    * 集体控股
    */
   String COLLECTIVE_HOLDING = "120";
   /**
    * 私人控股
    */
   String PRIVATE_HOLDING = "210";
   /**
    * 港澳台控股
    */
   String HONG_KONG_MACAO_TAIWAN_HOLDING = "220";
   /**
    * 外商控股
    */
   String FOREIGN_HOLDINGS = "230";
 } 
