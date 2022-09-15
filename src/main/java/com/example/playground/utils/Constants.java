package com.example.playground.utils;

import java.util.ArrayList;

public class Constants {
    public static final String CORRELATION_ID_FIELD = "Correlation-Id";
    public static final String APP_ID_FIELD = "app_id";
    public static final String APP_KEY_FIELD = "app_key";
    public static final String COUNTRY_CODE_FIELD = "Country-Code";
    public static final String BUSINESS_ID_FIELD = "Business-Id";
    public static final String BUSINESS_ID = "BRB";
    public static final String SYSTEM_ID_FIELD = "System-Id";
    public static final String SYSTEM_ID = "IB";
    public static final String SMS_SYSTEM_ID = "ACB";
    public static final String EMAIL_SYSTEM_ID = "COP";
    public static final String STAFF_ID = "IFE";
    public static final String PROSPECT_STAFF_ID = "ABAMADD";
    public static final String CONSUMER_UNIQUE_REF_ID_FIELD = "ConsumerUniqueReference-Id";
    public static final String STAFF_ID_FIELD = "Staff-Id";
    public static final String TANZANIA_CODE = "TZ";
    public static final String TANZANIA_ABT_CODE = "TZ-ABT";
    public static final String CREATE_CASE_PATH = ".amol-api.roanprd-openshift.intra.absa.co.za/v1/document-services/document-directory-entry/registration";
    public static final String DE_DUP_PATH=".amol-api.roanprd-openshift.intra.absa.co.za/v2/party-reference-data-directory/party-reference-data-directory-entry/reference/retail/retrieval?";
    public static final String PROSPECT_PATH = ".amol-api.roanprd-openshift.intra.absa.co.za/v2/party-reference-data-directory/party-reference-data-directory-entry/prospect/initiation";
    public static final String CREATE_CASE_TYPE = "280";
    public static final String TZ_CODE = "TZ";
    public static final String TZ_ABT_CODE = "TZ-ABT";
    public static final String CREATE_CASE_CREATED_BY = "WEB_PORTAL";
    public static final String CREATE_CASE_CREATED_BY_NAME = "Idx28";
    public static final String CREATE_CASE_CREATED_BY_DESCRIPTION = "CreateUser/DeviceID";
    public static final String CREATE_CASE_COUNTRY_CODE = "Idx32";
    public static final String CREATE_CASE_COUNTRY_CODE_DESCRIPTION = "CountryCode";

    public static final String MOBILE_CONTACT_TYPE = "8";
    public static final String EMAIL_CONTACT_TYPE = "7";
    public static final String EMAIL_DYNAMIC_TYPE = "CDATA";
    public static final String EMAIL_BODY = "BODY";
    public static final String EMAIL_SUBJECT = "SUBJECT";
    public static final String EMAIL_SUBJECT_TEXT = "Application for New Business Bank Account REF : ";
    public static final String EMAIL_REFERENCE = "TRXREFNUMER";
    public static final String EMAIL_REFERENCE_VALUE = "123456777";



    public static final String CUSTOMER_ID = "44556677";
    public static final String DELIVERY_MODE = "1";
    public static final String EMAIL_DELIVERY_MODE = "2";
    public static final String OPERATION_MODE = "";
    public static final String SMS_DESTINATION_TYPE = "SMS";
    public static final String EMAIL_DESTINATION_TYPE = "EMAIL_INTERNAL";
    public static final String SMS_EVENT_ID = "PAYMENT";
    public static final String EMAIL_EVENT_ID = "ADB001";
    public static final String EVENT_IDENTIFIER = "";

    public static final String SMS_CORRELATION_ID = "abcdabcd-abcd-abcd-abcd-Abcdabcdabcf";
    public static final String CONSUMER_UNIQUE_REFERENCE_ID = "334456677888";
    public static final String EMAIL_CONSUMER_UNIQUE_REFERENCE_ID = "212345671234";
    public static final String PRODUCT_NAME = "Current Account Personal";

    public static final String KENYA_COUNTRY_CODE = "KE";
    public static final String BOTSWANA_COUNTRY_CODE = "BW";
    public static final String SEYCHELLE_COUNTRY_CODE = "SC";
    public static final String GHANA_COUNTRY_CODE = "GH";
    public static final String TANZANIA_COUNTRY_CODE = "TZ";
    public static final String ZAMBIA_COUNTRY_CODE = "ZM";

    public static final String PRODUCT_OWNER_ABNUMBER = "CWP";

    public static final String[] ADDRESS_TYPE = new String[]{"002", "001", "004"};
    public static final String[] TRANSACTION_TYPE = new String[]{"1", "2", "4", "5", "6", "8"};

    public static final String[] FLEX_COUNTRIES = new String[]{"KE"};
    public static final String[] BRAIN_COUNTRIES = new String[]{"GH", "SC", "ZM", "BW", "TZ"};

    public static final String SERVICE_ID_SUBMIT_OPERATION = "SubmitOperation";
    public static final String SERVICE_ID_QUERY_ACCOUNT = "QueryApplicationStatus";
    public static final ArrayList<String> STP_RISK_STATUSES = new ArrayList<>() {{
        add("LOW");
        add("VERY LOW");
        add("MEDIUM");
    }};

    public static final String[] STP_RISK_STATUSES2 = new String[]{"LOW", "VERY LOW", "MEDIUM"};

    public static final String SANCTION_ACCEPT = "ACCEPT";
    public static final String PROFILING = "PROFILING";
    public static final String REFERRAL = "REFERRAL";
    public static final String PEND_EDD = "PEND_EDD";

    public static final int APPLICATION_PAGE_SIZE = 2;
    public static final String KYC_VERY_LOW = "Very low";
    public static final String KYC_VERY_LOW2 = "VLOW";
    public static final String KYC_LOW = "Low";
    public static final String KYC_MEDIUM = "Medium";
    public static final String KYC_MEDIUM2 = "Standard";
    public static final String KYC_HIGH = "High";
    public static final String KYC_VERY_HIGH = "Very High";
    public static final String KYC_VERY_HIGH2 = "VHIGH";
    public static final long DEFAULT_SLEEP = 30000;

    public static final String SALARIED_EMP_TYPE_ALL_COUNTRIES = "1";
    public static final String SALARIED_ON_CONTRACT_TYPE_ALL_COUNTRIES = "2";
    public static final String SELF_EMP_TYPE_ALL_COUNTRIES = "3";
    public static final String FREELANCER_EMP_TYPE_ALL_COUNTRIES = "4";

    public static final String OTHER_INCOME_CODE_ALL_COUNTRIES = "215";
    public static final String OTHER_FUNDS_CODE_ALL_COUNTRIES = "113";
    public static final String OTHER_WEALTH_CODE_ALL_COUNTRIES = "122";

    public static final String OTHER_INCOME_VALUE_ALL_COUNTRIES = "OTHER INCOME";
    public static final String OTHER_FUNDS_VALUE_ALL_COUNTRIES = "OTHER FUNDS";
    public static final String OTHER_WEALTH_VALUE_ALL_COUNTRIES = "OTHER WEALTH";

    public static final String CASE_PROCESS_PAGE_NUMBERS = "_CASE_PROCESS_PAGE_NUMBERS";
    public static final String LOCK_PROCESS = "_PROCESS_LOCK";
}
