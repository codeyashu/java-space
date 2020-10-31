package io.rsi.codespace.algo.array;

import java.util.Arrays;

public class MyArray {
    int length;
    int[] data;

    public MyArray() {
        this.length = 0;
        this.data = new int[10];
    }

    public int get(int index) {
        return this.data[index];
    }

    public int push(int data) {
        this.data[this.length] = data;
        this.length++;
        return this.length;
    }

    public void pop(){
        //
    }

    public static void main(String[] args) {
        /*MyArray myArray = new MyArray();
        myArray.push(1);
        myArray.push(2);
        myArray.push(3);

        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray.data[i]);
        }

        System.out.println(myArray.length);*/


            StringBuilder sb = new StringBuilder();

            sb.append("WITH CUSTOMER_IDENTIFIER_INFO AS ");
            sb.append(" (SELECT * ");
            sb.append(" FROM ");
            sb.append("   (SELECT ");
            sb.append("     C_PTR_PARTY_RL.HUB_STATE_IND, ");
            sb.append("     C_PTR_PARTY_RL.CREATOR, ");
            sb.append("     C_PTR_PARTY_RL.CREATE_DATE, ");
            sb.append("     C_PTR_PARTY_RL.PARTY_RL_NM TRADINGNAME, ");
            sb.append("     C_PTR_PARTY_RL.ISO_LANG_ROWID PREFLANGCD_ROWID, ");
            sb.append("     C_PTR_PARTY_RL.RL_TYP_CD PARTYROLETYPE, ");
            sb.append("     C_PTR_ALT_CODES.PTR_ROWID CUSTOMER_MDM_ID, ");
            sb.append("     C_PTR_ALT_CODES.TYP_TYPE_CD, ");
            sb.append("     CODE ");
            sb.append("   FROM  C_PTR_PARTY_RL ");
            sb.append("   INNER JOIN C_PTR_ALT_CODES ON C_PTR_ALT_CODES.PTR_ROWID = C_PTR_PARTY_RL.ROWID_OBJECT ");
            sb.append("   WHERE C_PTR_ALT_CODES.HUB_STATE_IND = 1 ");
            sb.append("   AND   C_PTR_PARTY_RL.HUB_STATE_IND  = 1 ");
            sb.append("   AND   C_PTR_PARTY_RL.RL_TYP_CD      = 'CUST' ");
            sb.append("   AND   C_PTR_ALT_CODES.TYP_TYPE_CD   IN ('PTR_ALT_CODES.CSTSCV','PTR_ALT_CODES.CSTFCT') ");
            sb.append("   AND EXISTS ");
            sb.append("     (SELECT 1 ");
            sb.append("     FROM C_PTR_ALT_CODES KK ");
            sb.append("     WHERE C_PTR_ALT_CODES.PTR_ROWID = KK.PTR_ROWID ");
            sb.append("     AND KK.CODE                     = (:CODE) ");
            sb.append("     ) ");
            sb.append("   ) PIVOT (MIN(CODE) FOR (TYP_TYPE_CD) IN ('PTR_ALT_CODES.CSTSCV' AS CUST_SCV_CODE, 'PTR_ALT_CODES.CSTFCT' AS CUST_FACT_CODE)) ");
            sb.append(" ), ");
            sb.append(" LEGAL_NAME_INFO AS ");
            sb.append(" (SELECT PTR_ROWID, ");
            sb.append("   ALIAS_NM, ");
            sb.append("   ISO_LANG_6391_CD LGL_NM_LANG_CD ");
            sb.append(" FROM C_PTR_NAME_ALIAS ");
            sb.append(" INNER JOIN CUSTOMER_IDENTIFIER_INFO ");
            sb.append(" ON CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID = C_PTR_NAME_ALIAS.PTR_ROWID ");
            sb.append(" LEFT OUTER JOIN C_LKP_CTRY_TMPL_REL ");
            sb.append(" ON C_PTR_NAME_ALIAS.ISO_LANG_ROWID = C_LKP_CTRY_TMPL_REL.ROWID_OBJECT ");
            sb.append(" LEFT OUTER JOIN C_LNG_ISO_LANG ");
            sb.append(" ON C_LKP_CTRY_TMPL_REL.ISO_LANG_6391_ROWID = C_LNG_ISO_LANG.ROWID_OBJECT ");
            sb.append(" WHERE C_PTR_NAME_ALIAS.TYP_TYPE_CD         = 'PTR_NM_ALIAS.LGL_NM' ");
            sb.append(" AND C_PTR_NAME_ALIAS.HUB_STATE_IND         = 1 ");
            sb.append(" ), ");
            sb.append(" ");
            sb.append(" LOCAL_NAME_INFO AS ");
            sb.append(" (SELECT PTR_ROWID, ");
            sb.append("   ALIAS_NM LOCAL_NM, ");
            sb.append("   ISO_LANG_6391_CD LCL_NM_LANG_CD ");
            sb.append(" FROM C_PTR_NAME_ALIAS ");
            sb.append(" INNER JOIN CUSTOMER_IDENTIFIER_INFO ");
            sb.append(" ON CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID = C_PTR_NAME_ALIAS.PTR_ROWID ");
            sb.append(" LEFT OUTER JOIN C_LKP_CTRY_TMPL_REL ");
            sb.append(" ON C_PTR_NAME_ALIAS.ISO_LANG_ROWID = C_LKP_CTRY_TMPL_REL.ROWID_OBJECT ");
            sb.append(" LEFT OUTER JOIN C_LNG_ISO_LANG ");
            sb.append(" ON C_LKP_CTRY_TMPL_REL.ISO_LANG_6391_ROWID = C_LNG_ISO_LANG.ROWID_OBJECT ");
            sb.append(" WHERE C_PTR_NAME_ALIAS.TYP_TYPE_CD         = 'PTR_NM_ALIAS.LNG_NM' ");
            sb.append(" AND C_PTR_NAME_ALIAS.HUB_STATE_IND         = 1 ");
            sb.append(" ), ");
            sb.append("COUNTRY_DETAILS AS ");
            sb.append(" (SELECT C_GDA_DFND_AREA.ROWID_OBJECT, ");
            sb.append("   C_GDA_DFND_AREA.NAME CNTRY_NM, ");
            sb.append("   C_ALT_CODE.CODE CNTRY_CD ");
            sb.append(" FROM C_ALT_CODE, ");
            sb.append("   C_GDA_DFND_AREA, ");
            sb.append("   C_TYP_TYPE ");
            sb.append(" WHERE C_ALT_CODE.GDA_DFND_AREA_ROWID = C_GDA_DFND_AREA.ROWID_OBJECT ");
            sb.append(" AND C_GDA_DFND_AREA.TYP_TYPE_CD      = 'GDA.COUNTRY' ");
            sb.append(" AND C_GDA_DFND_AREA.ACTIVE_FLAG      = 'Y' ");
            sb.append(" AND C_TYP_TYPE.CODE                  = 'ALT_CODE.RKST' ");
            sb.append(" AND C_ALT_CODE.TYP_TYPE_ROWID        = C_TYP_TYPE.ROWID_OBJECT ");
            sb.append(" AND C_ALT_CODE.HUB_STATE_IND         = 1 ");
            sb.append(" AND C_GDA_DFND_AREA.HUB_STATE_IND    = 1 ");
            sb.append(" AND C_GDA_DFND_AREA.ACTIVE_FLAG      = 'Y' ");
            sb.append(" AND C_TYP_TYPE.HUB_STATE_IND         = 1 ");
            sb.append(" ), ");
            sb.append(" REGION_INFO AS ");
            sb.append(" ( SELECT DISTINCT REGION.ROWID_OBJECT REGION_MDM_ID, ");
            sb.append("   C_ALT_CODE.CODE REGION_CODE, ");
            sb.append("   REGION.NAME REGION_NAME, ");
            sb.append("   REGION.ROWID_OBJECT ");
            sb.append(" FROM C_ALT_CODE, ");
            sb.append("   C_TYP_TYPE, ");
            sb.append("   C_GDA_DFND_AREA REGION ");
            sb.append(" WHERE C_ALT_CODE.TYP_TYPE_ROWID    = C_TYP_TYPE.ROWID_OBJECT ");
            sb.append(" AND C_ALT_CODE.GDA_DFND_AREA_ROWID = REGION.ROWID_OBJECT ");
            sb.append(" AND C_TYP_TYPE.CODE               IN ('ALT_CODE.ISO_TRTY') ");
            sb.append(" AND C_ALT_CODE.HUB_STATE_IND       = 1 ");
            sb.append(" AND REGION.HUB_STATE_IND           = 1 ");
            sb.append(" AND REGION.ACTIVE_FLAG             = 'Y' ");
            sb.append(" AND C_TYP_TYPE.HUB_STATE_IND       = 1 ");
            sb.append(" ), ");
            sb.append(" REF_NUM_INFO AS ");
            sb.append(" (SELECT PARTY_RL_ROWID, ");
            sb.append("   C_PTR_REF_NUM.REF_TYPE_CD, ");
            sb.append("   C_PTR_REF_TYP.REF_TYP_DESC, ");
            sb.append("   REF_NUM ");
            sb.append(" FROM C_PTR_REF_NUM ");
            sb.append(" INNER JOIN C_PTR_REF_TYP ");
            sb.append(" ON C_PTR_REF_TYP.REF_TYPE_CD = C_PTR_REF_NUM.REF_TYPE_CD ");
            sb.append(" INNER JOIN CUSTOMER_IDENTIFIER_INFO ");
            sb.append(" ON CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID = C_PTR_REF_NUM.PARTY_RL_ROWID ");
            sb.append(" WHERE C_PTR_REF_NUM.HUB_STATE_IND           = 1 ");
            sb.append(" ), ");
            sb.append(" TAX_NUM_INFO AS ");
            sb.append(" (SELECT C_TAX_NUM.PTR_ROWID, ");
            sb.append("   C_TAX_NUM.TAX_NUM_TYP_CD, ");
            sb.append("   C_TAX_NUM.TAX_NUM, ");
            sb.append("   COUNTRY_DETAILS.CNTRY_CD TAX_NUM_CTRY_CD, ");
            sb.append("   TAX_NUM_TYP_NM_LCL ");
            sb.append(" FROM C_TAX_NUM ");
            sb.append(" INNER JOIN COUNTRY_DETAILS ");
            sb.append(" ON COUNTRY_DETAILS.ROWID_OBJECT = C_TAX_NUM.CTRY_ROW_ID ");
            sb.append(" INNER JOIN CUSTOMER_IDENTIFIER_INFO ");
            sb.append(" ON CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID = C_TAX_NUM.PTR_ROWID ");
            sb.append(" LEFT OUTER JOIN C_TAX_NUM_TYP_CTRY_REL ");
            sb.append(" ON ( C_TAX_NUM_TYP_CTRY_REL.CTRY_ROWID    = C_TAX_NUM.CTRY_ROW_ID ");
            sb.append(" AND C_TAX_NUM_TYP_CTRY_REL.TAX_NUM_TYP_CD = C_TAX_NUM.TAX_NUM_TYP_CD ) ");
            sb.append(" WHERE C_TAX_NUM.HUB_STATE_IND             = 1 ");
            sb.append(" ), ");
            sb.append(" CUST_HQ_INFO AS ");
            sb.append(" ( SELECT DISTINCT REL.CHLD_RL_ROWID PARTY_RL_ROWID, ");
            sb.append("   CUST_CODE.CODE CUST_HQ_CODE, ");
            sb.append("   COALESCE(C_PTR_NAME_ALIAS.ALIAS_NM, CUSTOMER_IDENTIFIER_INFO.TRADINGNAME) CUST_HQ_LGL_NM, ");
            sb.append("   ISO_LANG_6391_CD CUST_HQ_LGL_NM_LANG_CD, ");
            sb.append("   ( ");
            sb.append("   CASE ");
            sb.append("     WHEN TRUNC( NVL(REL.VALID_THRU_DT,TO_DATE('31-12-3999','DD-MM-YYYY')),'DDD') < TRUNC(SYSDATE,'DDD') ");
            sb.append("     THEN 'Inactive' ");
            sb.append("     ELSE 'Active' ");
            sb.append("   END) CUST_HQ_STATUS ");
            sb.append(" FROM C_PTR_REL REL ");
            sb.append(" INNER JOIN C_PTR_ALT_CODES CUST_CODE ");
            sb.append(" ON CUST_CODE.PTR_ROWID = REL.PRNT_RL_ROWID ");
            sb.append(" INNER JOIN CUSTOMER_IDENTIFIER_INFO ");
            sb.append(" ON CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID = REL.CHLD_RL_ROWID ");
            sb.append(" LEFT OUTER JOIN C_PTR_NAME_ALIAS ");
            sb.append(" ON ( C_PTR_NAME_ALIAS.PTR_ROWID = REL.PRNT_RL_ROWID ");
            sb.append("           AND C_PTR_NAME_ALIAS.TYP_TYPE_CD           = 'PTR_NM_ALIAS.LGL_NM' ");
            sb.append("             AND C_PTR_NAME_ALIAS.HUB_STATE_IND         = 1 ");
            sb.append("     ) ");
            sb.append(" LEFT OUTER JOIN C_LKP_CTRY_TMPL_REL ");
            sb.append(" ON C_PTR_NAME_ALIAS.ISO_LANG_ROWID = C_LKP_CTRY_TMPL_REL.ROWID_OBJECT ");
            sb.append(" LEFT OUTER JOIN C_LNG_ISO_LANG ");
            sb.append(" ON C_LKP_CTRY_TMPL_REL.ISO_LANG_6391_ROWID = C_LNG_ISO_LANG.ROWID_OBJECT ");
            sb.append(" WHERE REL.HUB_STATE_IND                    = 1 ");
            sb.append(" AND CUST_CODE.HUB_STATE_IND                = 1 ");
            sb.append(" AND CUST_CODE.TYP_TYPE_CD                  = 'PTR_ALT_CODES.CSTFCT' ");
            sb.append(" AND REL.PARTY_RL_REL_TYP_CD               IN ('CUST_HQ_BVD') ");
            sb.append(" ), ");
            sb.append(" CUST_GUO_INFO AS ");
            sb.append(" ( SELECT DISTINCT REL.CHLD_RL_ROWID PARTY_RL_ROWID, ");
            sb.append("   CUST_CODE.CODE CUST_GUO_CODE, ");
            sb.append("   COALESCE(C_PTR_NAME_ALIAS.ALIAS_NM, CUSTOMER_IDENTIFIER_INFO.TRADINGNAME) CUST_GUO_LGL_NM, ");
            sb.append("   ISO_LANG_6391_CD CUST_GUO_LGL_NM_LANG_CD, ");
            sb.append("   ( ");
            sb.append("   CASE ");
            sb.append("     WHEN TRUNC(NVL(REL.VALID_THRU_DT,TO_DATE('31-12-3999','DD-MM-YYYY')),'DDD') < TRUNC(SYSDATE,'DDD') ");
            sb.append("     THEN 'Inactive' ");
            sb.append("     ELSE 'Active' ");
            sb.append("   END) CUST_GUO_STATUS ");
            sb.append(" FROM C_PTR_REL REL ");
            sb.append(" INNER JOIN CUSTOMER_IDENTIFIER_INFO ");
            sb.append(" ON CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID = REL.CHLD_RL_ROWID ");
            sb.append(" INNER JOIN C_PTR_ALT_CODES CUST_CODE ");
            sb.append(" ON CUST_CODE.PTR_ROWID = REL.PRNT_RL_ROWID ");
            sb.append(" LEFT OUTER JOIN C_PTR_NAME_ALIAS ");
            sb.append(" ON C_PTR_NAME_ALIAS.PTR_ROWID = REL.PRNT_RL_ROWID ");
            sb.append(" LEFT OUTER JOIN C_LKP_CTRY_TMPL_REL ");
            sb.append(" ON ( C_PTR_NAME_ALIAS.ISO_LANG_ROWID = C_LKP_CTRY_TMPL_REL.ROWID_OBJECT ");
            sb.append("         AND C_PTR_NAME_ALIAS.TYP_TYPE_CD           = 'PTR_NM_ALIAS.LGL_NM' ");
            sb.append("           AND C_PTR_NAME_ALIAS.HUB_STATE_IND         = 1 ");
            sb.append("    ) ");
            sb.append(" LEFT OUTER JOIN C_LNG_ISO_LANG ");
            sb.append(" ON C_LKP_CTRY_TMPL_REL.ISO_LANG_6391_ROWID = C_LNG_ISO_LANG.ROWID_OBJECT ");
            sb.append(" WHERE REL.HUB_STATE_IND                    = 1 ");
            sb.append(" AND CUST_CODE.HUB_STATE_IND                = 1 ");
            sb.append(" AND CUST_CODE.TYP_TYPE_CD                  = 'PTR_ALT_CODES.CSTFCT' ");
            sb.append(" ");
            sb.append(" AND REL.PARTY_RL_REL_TYP_CD               IN ('CUST_GUO_BVD') ");
            sb.append(" ), ");
            sb.append(" SEGMENT_INFO AS ");
            sb.append(" (SELECT C_PTR_REL_CLSSN.ROWID_OBJECT SEGMENT_VAL_MDM_ID, ");
            sb.append("   C_PTR_CLSSN_TYP.CODE SEGMENT_TYP_CD, ");
            sb.append("   C_PTR_CLSSN_TYP.NAME SEGMENT_TYP_NM, ");
            sb.append("   C_PTR_REL_CLSSN.CODE SEGMENT_VAL_CD, ");
            sb.append("   C_PTR_REL_CLSSN.NAME SEGMENT_VAL_NM, ");
            sb.append("   C_PTR_REL_CLSSN.DESCRIPTION SEGMENT_VAL_DESC ");
            sb.append(" FROM C_PTR_CLSSN_TYP ");
            sb.append(" INNER JOIN C_PTR_REL_CLSSN ");
            sb.append(" ON C_PTR_REL_CLSSN.CLSSN_TYPE_CD    = C_PTR_CLSSN_TYP.CODE ");
            sb.append(" WHERE C_PTR_CLSSN_TYP.IS_ACTIVE_IND = 'Y' ");
            sb.append(" AND C_PTR_REL_CLSSN.IS_ACTIVE_IND   = 'Y' ");
            sb.append(" ), ");
            sb.append(" BRAND_SEGMENT AS ");
            sb.append(" (SELECT C_PTR_PARTY_RL.ROWID_OBJECT BRAND_MDM_ID, ");
            sb.append("   C_PTR_REL_CLSSN_REL.ROWID_OBJECT BRAND_SEGMENT_MDM_ID, ");
            sb.append("   C_PTR_PARTY_RL.PARTY_RL_NM BRAND_NAME, ");
            sb.append("   C_PTR_ALT_CODES.CODE BRAND_CODE, ");
            sb.append("   SEGMENT_INFO.* ");
            sb.append(" FROM C_PTR_PARTY_RL ");
            sb.append(" INNER JOIN C_PTR_REL_CLSSN_REL ");
            sb.append(" ON C_PTR_REL_CLSSN_REL.PTR_RL_ROWID = C_PTR_PARTY_RL.ROWID_OBJECT ");
            sb.append(" INNER JOIN SEGMENT_INFO ");
            sb.append(" ON C_PTR_REL_CLSSN_REL.PTR_CLSSN_ROWID = SEGMENT_INFO.SEGMENT_VAL_MDM_ID ");
            sb.append(" INNER JOIN C_PTR_ALT_CODES ");
            sb.append(" ON C_PTR_PARTY_RL.ROWID_OBJECT          = C_PTR_ALT_CODES.PTR_ROWID ");
            sb.append(" WHERE C_PTR_REL_CLSSN_REL.IS_ACTIVE_IND = 'Y' ");
            sb.append(" AND C_PTR_PARTY_RL.RL_TYP_CD            = 'CARR' ");
            sb.append(" AND C_PTR_ALT_CODES.TYP_TYPE_CD         = 'PTR_ALT_CODES.LRA_CD' ");
            sb.append(" ), ");
            sb.append(" CUSTOMER_BRAND_REL AS ");
            sb.append(" (SELECT C_PTR_REL.ROWID_OBJECT CUST_BRAND_REL_ROWID, ");
            sb.append("   CUSTOMER.ROWID_OBJECT CUSTOMER_MDM_ID, ");
            sb.append("   C_PTR_ALT_CODES.CODE BRAND_CODE, ");
            sb.append("   BRAND.ROWID_OBJECT BRAND_MDM_ID, ");
            sb.append("   BRAND.PARTY_RL_NM BRAND_NAME ");
            sb.append(" FROM C_PTR_PARTY_RL CUSTOMER ");
            sb.append(" INNER JOIN C_PTR_REL ");
            sb.append(" ON C_PTR_REL.CHLD_RL_ROWID = CUSTOMER.ROWID_OBJECT ");
            sb.append(" INNER JOIN CUSTOMER_IDENTIFIER_INFO ");
            sb.append(" ON CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID = C_PTR_REL.CHLD_RL_ROWID ");
            sb.append(" INNER JOIN C_PTR_PARTY_RL BRAND ");
            sb.append(" ON C_PTR_REL.PRNT_RL_ROWID = BRAND.ROWID_OBJECT ");
            sb.append(" INNER JOIN C_PTR_ALT_CODES ");
            sb.append(" ON C_PTR_ALT_CODES.PTR_ROWID        = BRAND.ROWID_OBJECT ");
            sb.append(" WHERE C_PTR_REL.PARTY_RL_REL_TYP_CD = 'USED_BY_CARR' ");
            sb.append(" AND C_PTR_REL.HUB_STATE_IND         = 1 ");
            sb.append(" AND CUSTOMER.RL_TYP_CD              = 'CUST' ");
            sb.append(" AND BRAND.RL_TYP_CD                 = 'CARR' ");
            sb.append(" AND C_PTR_ALT_CODES.HUB_STATE_IND   = 1 ");
            sb.append(" AND CUSTOMER.HUB_STATE_IND          = 1 ");
            sb.append(" AND BRAND.HUB_STATE_IND             = 1 ");
            sb.append(" AND C_PTR_ALT_CODES.TYP_TYPE_CD     = 'PTR_ALT_CODES.LRA_CD' ");
            sb.append(" ), ");
            sb.append(" CUSTOMER_BRAND_SEGMENT_INFO AS ");
            sb.append(" (SELECT CUSTOMER_BRAND_REL.CUSTOMER_MDM_ID, ");
            sb.append("   BRAND_SEGMENT.*, ");
            sb.append("   C_PTR_SEG.IS_ACTIVE_IND CUST_SEGMENT_STATUS ");
            sb.append(" FROM CUSTOMER_BRAND_REL ");
            sb.append(" INNER JOIN C_PTR_SEG ");
            sb.append(" ON CUSTOMER_BRAND_REL.CUST_BRAND_REL_ROWID = C_PTR_SEG.PTR_REL_ROWID ");
            sb.append(" INNER JOIN BRAND_SEGMENT ");
            sb.append(" ON ( BRAND_SEGMENT.SEGMENT_VAL_CD = C_PTR_SEG.PTR_REL_CLSSN_CD ");
            sb.append(" AND BRAND_SEGMENT.BRAND_MDM_ID    = CUSTOMER_BRAND_REL.BRAND_MDM_ID ) ");
            sb.append(" ), ");
            sb.append(" DIALING_CODE_INFO AS ");
            sb.append(" (SELECT C_CTM_INTL_DIALNG_CD.ROWID_OBJECT DIALING_CODE_MDM_ID, ");
            sb.append("   DIALNG_CD, ");
            sb.append("   CTRY_ROWID, ");
            sb.append("   COUNTRY_DETAILS.CNTRY_CD PH_NUM_CTRY_CD ");
            sb.append(" FROM C_CTM_INTL_DIALNG_CD ");
            sb.append(" INNER JOIN COUNTRY_DETAILS ");
            sb.append(" ON C_CTM_INTL_DIALNG_CD.CTRY_ROWID = COUNTRY_DETAILS.ROWID_OBJECT ");
            sb.append(" ), ");
            sb.append(" INVOICING_LANG_DETAILS AS ");
            sb.append(" (SELECT C_LKP_CTRY_TMPL_REL.ROWID_OBJECT, ");
            sb.append("   LOWER(C_LNG_ISO_LANG.ISO_LANG_6391_CD) INVOICE_LANG_CD ");
            sb.append(" FROM C_LKP_CTRY_TMPL_REL ");
            sb.append(" INNER JOIN COUNTRY_DETAILS ");
            sb.append(" ON C_LKP_CTRY_TMPL_REL.GDA_CTRY_ROWID = COUNTRY_DETAILS.ROWID_OBJECT ");
            sb.append(" INNER JOIN C_LNG_ISO_LANG ");
            sb.append(" ON C_LNG_ISO_LANG.ROWID_OBJECT = C_LKP_CTRY_TMPL_REL.ISO_LANG_6391_ROWID ");
            sb.append(" ), ");
            sb.append(" PTR_CUSTOMER_DETAILS AS ");
            sb.append(" (SELECT CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID, ");
            sb.append("   C_PTR_CUST.UPDATED_BY, ");
            sb.append("   C_PTR_CUST.LAST_UPDATE_DATE, ");
            sb.append("   C_PTR_CUST.LAST_ROWID_SYSTEM CUST_LAST_MODIFIED_SYSTEM, ");
            sb.append("   C_PTR_CUST.ACC_GRP_CD, ");
            sb.append("   C_TAX_INFO.IS_NATUL_PRSN_TAX, ");
            sb.append("   C_PTR_CUST.COMM_TYP, ");
            sb.append("   C_PTR_CUST.PTR_CUST_STAT_CD, ");
            sb.append("   PTR_STS_RSN_NM STATUSREASON, ");
            sb.append("   C_PTR_CUST.PH_NUM, ");
            sb.append("   DIALING_CODE_INFO.DIALNG_CD, ");
            sb.append("   DIALING_CODE_INFO.PH_NUM_CTRY_CD, ");
            sb.append("   C_PTR_CUST.URL, ");
            sb.append("   C_PTR_CUST.BROK, ");
            sb.append("   C_PTR_CUST.FORCOM, ");
            sb.append("   C_PTR_CUST.PTR_STS_RSN_CD, ");
            //Added for SCP Change
            sb.append("   C_PTR_CUST.CUST_GRP_TYP, ");
            sb.append("   PTR_STS_RSN_DESC ");
            sb.append(" FROM C_PTR_CUST ");
            sb.append(" INNER JOIN CUSTOMER_IDENTIFIER_INFO ");
            sb.append(" ON CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID = C_PTR_CUST.PTR_CUST_ROWID ");
            sb.append(" LEFT OUTER JOIN C_TAX_INFO ");
            sb.append(" ON C_TAX_INFO.PTR_ROWID = C_PTR_CUST.PTR_CUST_ROWID ");
            sb.append(" LEFT OUTER JOIN C_PTR_STAT_RSN ");
            sb.append(" ON C_PTR_STAT_RSN.PTR_STS_RSN_CD = C_PTR_CUST.PTR_STS_RSN_CD ");
            sb.append(" LEFT OUTER JOIN DIALING_CODE_INFO ");
            sb.append(" ON C_PTR_CUST.INTL_DIALNG_ROWID_PH = DIALING_CODE_INFO.DIALING_CODE_MDM_ID ");
            sb.append(" ) ");
            sb.append("SELECT ");
            sb.append(" CUSTOMER_IDENTIFIER_INFO.HUB_STATE_IND, ");
            sb.append(" CUSTOMER_IDENTIFIER_INFO.CREATOR CREATOR, ");
            sb.append(" CUSTOMER_IDENTIFIER_INFO.CREATE_DATE CREATE_DATE, ");
            sb.append(" PTR_CUSTOMER_DETAILS.LAST_UPDATE_DATE LAST_UPDATE_DATE, ");
            sb.append(" PTR_CUSTOMER_DETAILS.UPDATED_BY UPDATED_BY, ");
            sb.append(" PTR_CUSTOMER_DETAILS.CUST_LAST_MODIFIED_SYSTEM, ");
            sb.append(" CUSTOMER_IDENTIFIER_INFO.PARTYROLETYPE, ");
            sb.append(" CUSTOMER_IDENTIFIER_INFO.CUST_FACT_CODE, ");
            sb.append(" CUSTOMER_IDENTIFIER_INFO.CUST_SCV_CODE, ");
            sb.append(" CUSTOMER_IDENTIFIER_INFO.TRADINGNAME, ");
            sb.append(" CUSTOMER_IDENTIFIER_INFO.PREFLANGCD_ROWID, ");
            sb.append(" INVOICING_LANG_DETAILS.INVOICE_LANG_CD, ");
            sb.append(" PTR_CUSTOMER_DETAILS.ACC_GRP_CD CUST_TYPE, ");
            sb.append(" PTR_CUSTOMER_DETAILS.IS_NATUL_PRSN_TAX SOLE_PROP_FLAG, ");
            sb.append(" PTR_CUSTOMER_DETAILS.COMM_TYP, ");
            sb.append(" PTR_CUSTOMER_DETAILS.PTR_CUST_STAT_CD CUSTOMERSTATUS, ");
            sb.append(" PTR_CUSTOMER_DETAILS.DIALNG_CD, ");
            sb.append(" PTR_CUSTOMER_DETAILS.PH_NUM_CTRY_CD, ");
            sb.append(" PTR_CUSTOMER_DETAILS.URL, ");
            sb.append(" PTR_CUSTOMER_DETAILS.BROK, ");
            sb.append(" PTR_CUSTOMER_DETAILS.FORCOM, ");
            sb.append(" PTR_CUSTOMER_DETAILS.PTR_STS_RSN_CD, ");
            sb.append(" PTR_CUSTOMER_DETAILS.CUST_GRP_TYP, ");
            sb.append(" PTR_CUSTOMER_DETAILS.PTR_STS_RSN_DESC, ");
            sb.append(" PTR_CUSTOMER_DETAILS.STATUSREASON, ");
            sb.append(" PTR_CUSTOMER_DETAILS.PH_NUM, ");
            sb.append(" C_CTM_PSTL_ADDR.CREATOR ADDR_CREATOR, ");
            sb.append(" C_CTM_PSTL_ADDR.UPDATED_BY ADDR_UPDATED_BY, ");
            sb.append(" C_CTM_PSTL_ADDR.CREATE_DATE ADDR_CREATE_DATE, ");
            sb.append(" C_CTM_PSTL_ADDR.LAST_UPDATE_DATE ADDR_LAST_UPDATE_DATE, ");
            sb.append(" C_CTM_PSTL_ADDR.LAST_ROWID_SYSTEM ADDR_LAST_MODIFIED_SYSTEM, ");
            sb.append(" C_CTM_PSTL_ADDR.HOUSE_NUM HOUSENUM, ");
            sb.append(" C_CTM_PSTL_ADDR.PO_BOX POBOX, ");
            sb.append(" C_CTM_PSTL_ADDR.STREET STREET, ");
            sb.append(" C_CTM_PSTL_ADDR.ADDR_LN_2 BUILDINGNUM, ");
            sb.append(" C_CTM_PSTL_ADDR.ADDR_LN_3 SUBURB, ");
            sb.append(" C_CTM_PSTL_ADDR.CITY CITY, ");
            sb.append(" C_CTM_PSTL_ADDR.DSTRCT DISTRICT, ");
            sb.append(" C_CTM_PSTL_ADDR.PSTCD POSTALCODE, ");
            sb.append(" C_CTM_PSTL_ADDR.TAX_JURN_CD, ");
            sb.append(" ");
            sb.append(" C_CTM_PSTL_ADDR_LCL.STREET LCL_STREET_NM, ");
            sb.append(" C_CTM_PSTL_ADDR_LCL.HOUSE_NUM LCL_HOUSE_NUM, ");
            sb.append(" C_CTM_PSTL_ADDR_LCL.ADDR_LN_2 LCL_BUILDING_NUM, ");
            sb.append("C_CTM_PSTL_ADDR_LCL.ADDR_LN_3 LCL_SUBURB, ");
            sb.append(" C_CTM_PSTL_ADDR_LCL.DSTRCT LCL_DISTRICT_NM, ");
            sb.append(" C_CTM_PSTL_ADDR_LCL.CITY_NM LCL_CITY_NM, ");
            sb.append("C_CTM_PSTL_ADDR_LCL.LNG_CHAR_SET_CD, ");
            sb.append("LOCAL_ADDR_CD.ISO_LANG_6391_CD LOCAL_ADDR_LNG_CD, ");
            sb.append(" ");
            sb.append(" ");
            sb.append(" REGION_INFO.REGION_CODE, ");
            sb.append(" REGION_INFO.REGION_NAME, ");
            sb.append(" COUNTRY_DETAILS.CNTRY_CD, ");
            sb.append(" COUNTRY_DETAILS.CNTRY_NM COUNTRY, ");
            sb.append(" TAX_NUM_INFO.TAX_NUM_TYP_CD TAXTYPE, ");
            sb.append(" TAX_NUM_INFO.TAX_NUM_TYP_NM_LCL, ");
            sb.append(" TAX_NUM_INFO.TAX_NUM TAXNUMBER, ");
            sb.append(" TAX_NUM_INFO.TAX_NUM_CTRY_CD TAXCOUNTRY, ");
            sb.append(" REF_NUM_INFO.REF_TYPE_CD REFTYPE, ");
            sb.append(" REF_NUM_INFO.REF_NUM REFNUMBER, ");
            sb.append(" REF_NUM_INFO.REF_TYP_DESC REFTYPDESC, ");
            sb.append(" LEGAL_NAME_INFO.ALIAS_NM LEGAL_NM, ");
            sb.append(" LEGAL_NAME_INFO.LGL_NM_LANG_CD, ");
            sb.append(" LOCAL_NAME_INFO.LOCAL_NM, ");
            sb.append(" LOCAL_NAME_INFO.LCL_NM_LANG_CD, ");
            sb.append("CUSTOMER_BRAND_SEGMENT_INFO.BRAND_CODE, ");
            sb.append(" CUSTOMER_BRAND_SEGMENT_INFO.BRAND_NAME, ");
            sb.append(" CUSTOMER_BRAND_SEGMENT_INFO.SEGMENT_TYP_CD, ");
            sb.append(" CUSTOMER_BRAND_SEGMENT_INFO.SEGMENT_TYP_NM, ");
            sb.append(" CUSTOMER_BRAND_SEGMENT_INFO.SEGMENT_VAL_CD, ");
            sb.append(" CUSTOMER_BRAND_SEGMENT_INFO.SEGMENT_VAL_NM, ");
            sb.append(" CUSTOMER_BRAND_SEGMENT_INFO.SEGMENT_VAL_DESC, ");
            sb.append(" CUSTOMER_BRAND_SEGMENT_INFO.CUST_SEGMENT_STATUS, ");
            sb.append(" C_PTR_FIN_INFO.BVD_MJR_SCTR, ");
            sb.append(" C_PTR_FIN_INFO.MKT_CPTL, ");
            sb.append(" C_PTR_FIN_INFO.RECMD_CR_LMT, ");
            sb.append(" C_PTR_FIN_INFO.CR_RTNG, ");
            sb.append(" C_PTR_FIN_INFO.PRFT_MRGN_PCT, ");
            sb.append(" C_PTR_FIN_INFO.DT_ACC, ");
            sb.append(" C_PTR_FIN_INFO.OPN_RVN_TRN_OVR, ");
            sb.append(" CUST_HQ_INFO.CUST_HQ_CODE, ");
            sb.append(" CUST_HQ_INFO.CUST_HQ_LGL_NM, ");
            sb.append(" CUST_HQ_INFO.CUST_HQ_LGL_NM_LANG_CD, ");
            sb.append(" CUST_HQ_INFO.CUST_HQ_STATUS, ");
            sb.append(" CUST_GUO_INFO.CUST_GUO_CODE, ");
            sb.append(" CUST_GUO_INFO.CUST_GUO_LGL_NM, ");
            sb.append(" CUST_GUO_INFO.CUST_GUO_LGL_NM_LANG_CD, ");
            sb.append(" CUST_GUO_INFO.CUST_GUO_STATUS, ");
            sb.append(" ( ");
            sb.append(" CASE ");
            sb.append("   WHEN EXISTS ");
            sb.append("     (SELECT 1 ");
            sb.append("     FROM C_PTR_PARTY_RL_XREF XREF ");
            sb.append("     INNER JOIN CUSTOMER_IDENTIFIER_INFO ");
            sb.append("     ON  CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID  = XREF.ROWID_OBJECT ");
            sb.append("     WHERE XREF.HUB_STATE_IND                             = 0 ");
            sb.append("     ) ");
            sb.append("   THEN 'Y' ");
            sb.append("   ELSE 'N' ");
            sb.append(" END ) PENDING_WORKFLOW_FLAG ");
            sb.append("FROM CUSTOMER_IDENTIFIER_INFO ");
            sb.append("INNER JOIN C_PTR_CONT_MECHM ");
            sb.append("ON C_PTR_CONT_MECHM.PARTY_RL_ROWID = CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID ");
            sb.append("INNER JOIN C_CTM_PSTL_ADDR ");
            sb.append("ON C_CTM_PSTL_ADDR.ROWID_OBJECT = C_PTR_CONT_MECHM.PSTL_ADDR_ROWID ");
            sb.append("INNER JOIN PTR_CUSTOMER_DETAILS ");
            sb.append("ON PTR_CUSTOMER_DETAILS.CUSTOMER_MDM_ID = CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID ");
            sb.append("INNER JOIN COUNTRY_DETAILS ");
            sb.append("ON COUNTRY_DETAILS.ROWID_OBJECT = C_CTM_PSTL_ADDR.CTRY_ROWID ");
            sb.append("LEFT OUTER JOIN REGION_INFO ");
            sb.append("ON REGION_INFO.REGION_MDM_ID = C_CTM_PSTL_ADDR.TRTY_ROWID ");
            sb.append("LEFT OUTER JOIN CUST_GUO_INFO ");
            sb.append("ON CUST_GUO_INFO.PARTY_RL_ROWID = CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID ");
            sb.append("LEFT OUTER JOIN CUST_HQ_INFO ");
            sb.append("ON CUST_HQ_INFO.PARTY_RL_ROWID = CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID ");
            sb.append("LEFT OUTER JOIN REF_NUM_INFO ");
            sb.append("ON REF_NUM_INFO.PARTY_RL_ROWID = CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID ");
            sb.append("LEFT OUTER JOIN TAX_NUM_INFO ");
            sb.append("ON TAX_NUM_INFO.PTR_ROWID = CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID ");
            sb.append("LEFT OUTER JOIN LEGAL_NAME_INFO ");
            sb.append("ON LEGAL_NAME_INFO.PTR_ROWID = CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID ");
            sb.append("LEFT OUTER JOIN INVOICING_LANG_DETAILS ");
            sb.append("ON INVOICING_LANG_DETAILS.ROWID_OBJECT = CUSTOMER_IDENTIFIER_INFO.PREFLANGCD_ROWID ");
            sb.append("LEFT OUTER JOIN CUSTOMER_BRAND_SEGMENT_INFO ");
            sb.append("ON CUSTOMER_BRAND_SEGMENT_INFO.CUSTOMER_MDM_ID = CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID ");
            sb.append("LEFT OUTER JOIN C_PTR_FIN_INFO ");
            sb.append("ON C_PTR_FIN_INFO.PTR_ROWID        = CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID ");
            sb.append("LEFT OUTER JOIN LOCAL_NAME_INFO ");
            sb.append("ON LOCAL_NAME_INFO.PTR_ROWID        = CUSTOMER_IDENTIFIER_INFO.CUSTOMER_MDM_ID ");
            sb.append("LEFT OUTER JOIN C_CTM_PSTL_ADDR_LCL ");
            sb.append("ON C_CTM_PSTL_ADDR_LCL.PSTL_ADDR_ROWID  = C_CTM_PSTL_ADDR.ROWID_OBJECT ");
            sb.append("LEFT OUTER JOIN C_LKP_CTRY_TMPL_REL ");
            sb.append("ON C_CTM_PSTL_ADDR_LCL.ISO_LANG_ROWID = C_LKP_CTRY_TMPL_REL.ROWID_OBJECT ");
            sb.append("LEFT OUTER JOIN C_LNG_ISO_LANG LOCAL_ADDR_CD ");
            sb.append("ON C_LKP_CTRY_TMPL_REL.ISO_LANG_6391_ROWID = LOCAL_ADDR_CD.ROWID_OBJECT ");
            sb.append("WHERE C_PTR_CONT_MECHM.HUB_STATE_IND = 1 ");
            sb.append("AND C_CTM_PSTL_ADDR.HUB_STATE_IND  = 1 ");

        System.out.println(sb.toString());
    }
}