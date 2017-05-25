package com.plugins.crawler.framework.whois;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.coyote.http11.Constants.a;

/**
 * Created by david.yun on 2017/5/24.
 */
public class ParsedWhoisResponse {

    public static WhoisResponse parse(String whois) {
        WhoisResponse whoisResponse = new WhoisResponse();
        StringReader dataReader = null;
        BufferedReader reader = null;
        try {
            dataReader = new StringReader(whois);
            reader = new BufferedReader(dataReader);
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                judge(line, whoisResponse);
                judge(line, whoisResponse, Admin_PREFIX);
                judge(line, whoisResponse, Registrant_PREFIX);
                judge(line, whoisResponse, Tech_PREFIX);
                judge(line, whoisResponse, Billing_PREFIX);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (dataReader != null) {
                    dataReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return whoisResponse;
    }

    private static final String regexCommonName = "Name:(.+)$";
    private static final String regexCommonOrganization = "Organization:(.*)$";
    private static final String regexCommonStreet = "Street:(.*)$";
    private static final String regexCommonCity = "City:(.*)$";
    private static final String regexCommonStateProvince = "State/Province:(.*)$";
    private static final String regexCommonPostalCode = "Postal Code:(.*)$";
    private static final String regexCommonCountry = "Country:(.*)$";
    private static final String regexCommonPhone = "Phone:(.*)$";
    private static final String regexCommonFax = "Fax:(.*)$";
    private static final String regexCommonEmail = "Email:(.*)$";

    private static final String Admin_PREFIX = "Admin ";
    private static final String Registrant_PREFIX = "Registrant ";
    private static final String Tech_PREFIX = "Tech ";
    private static final String Billing_PREFIX = "Billing ";

    private static boolean judge(String line, WhoisResponse whoisResponse) {
        Matcher match;
        if ((match = Pattern.compile("Domain Name:(.+)$").matcher(line)).matches()) {
            whoisResponse.setDomain_name(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Updated Date:(.+)$").matcher(line)).matches()) {
            whoisResponse.setUpdated_date(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Creation Date:(.+)$").matcher(line)).matches()) {
            whoisResponse.setCreation_date(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Domain Status:(.+)$").matcher(line)).matches()) {
            whoisResponse.setDomain_status(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("DNSSEC:(.+)$").matcher(line)).matches()) {
            whoisResponse.setDnssec(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Registry Domain ID:(.+)$").matcher(line)).matches()) {
            whoisResponse.setRegistry_domain_id(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Registrar WHOIS Server:(.+)$").matcher(line)).matches()) {
            whoisResponse.setRegistrar_whois_server(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Registrar URL:(.+)$").matcher(line)).matches()) {
            whoisResponse.setRegistrar_url(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Registry Admin ID:(.+)$").matcher(line)).matches()) {
            whoisResponse.setRegistry_admin_id(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Registry Expiry Date:(.+)$").matcher(line)).matches()) {
            whoisResponse.setRegistry_expiry_date(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Registry Tech ID:(.+)$").matcher(line)).matches()) {
            whoisResponse.setRegistry_tech_id(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Registrar IANA ID:(.+)$").matcher(line)).matches()) {
            whoisResponse.setRegistrar_iana_id(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Registrar Abuse Contact Email:(.+)$").matcher(line)).matches()) {
            whoisResponse.setRegistrar_abuse_contact_email(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Registrar Abuse Contact Phone:(.+)$").matcher(line)).matches()) {
            whoisResponse.setRegistrar_abuse_contact_phone(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Registry Registrant ID:(.+)$").matcher(line)).matches()) {
            whoisResponse.setRegistry_registrant_id(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Registry Billing ID:(.+)$").matcher(line)).matches()) {
            whoisResponse.setRegistry_billing_id(match.group(1).trim());
            return true;
        }
        if ((match = Pattern.compile("Name Server:(.+)$").matcher(line)).matches()) {
            whoisResponse.addNameServers(match.group(1).trim());
            return true;
        }
        return false;
    }

    private static boolean judge(String line, WhoisResponse whoisResponse, String prefix) {
        if (!line.startsWith(prefix)) {
            return false;
        }
        Matcher match;
        if ((match = Pattern.compile(prefix + regexCommonName).matcher(line)).matches()) {
            set(whoisResponse, prefix.trim().toLowerCase() + "_name", match.group(1));
            return true;
        }
        if ((match = Pattern.compile(prefix + regexCommonOrganization).matcher(line)).matches()) {
            set(whoisResponse, prefix.trim().toLowerCase() + "_organization", match.group(1));
            return true;
        }
        if ((match = Pattern.compile(prefix + regexCommonStreet).matcher(line)).matches()) {
            set(whoisResponse, prefix.trim().toLowerCase() + "_street", match.group(1));
            return true;
        }
        if ((match = Pattern.compile(prefix + regexCommonCity).matcher(line)).matches()) {
            set(whoisResponse, prefix.trim().toLowerCase() + "_city", match.group(1));
            return true;
        }
        if ((match = Pattern.compile(prefix + regexCommonStateProvince).matcher(line)).matches()) {
            set(whoisResponse, prefix.trim().toLowerCase() + "_state", match.group(1));
            set(whoisResponse, prefix.trim().toLowerCase() + "_province", match.group(1));
            return true;
        }
        if ((match = Pattern.compile(prefix + regexCommonPostalCode).matcher(line)).matches()) {
            set(whoisResponse, prefix.trim().toLowerCase() + "_postal_code", match.group(1));
            return true;
        }
        if ((match = Pattern.compile(prefix + regexCommonCountry).matcher(line)).matches()) {
            set(whoisResponse, prefix.trim().toLowerCase() + "_country", match.group(1));
            return true;
        }
        if ((match = Pattern.compile(prefix + regexCommonPhone).matcher(line)).matches()) {
            set(whoisResponse, prefix.trim().toLowerCase() + "_phone", match.group(1));
            return true;
        }
        if ((match = Pattern.compile(prefix + regexCommonFax).matcher(line)).matches()) {
            set(whoisResponse, prefix.trim().toLowerCase() + "_fax", match.group(1));
            return true;
        }
        if ((match = Pattern.compile(prefix + regexCommonEmail).matcher(line)).matches()) {
            set(whoisResponse, prefix.trim().toLowerCase() + "_email", match.group(1));
            return true;
        }
        return false;
    }

    private static void set(WhoisResponse whoisResponse, String name, String data) {
        try {
            Field field = whoisResponse.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(whoisResponse, data.trim());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
