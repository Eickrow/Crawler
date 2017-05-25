package com.plugins.crawler.framework.whois;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david.yun on 2017/5/24.
 */
public class WhoisResponse {
    private String domain_name;
    private String updated_date;
    private String creation_date;
    private String domain_status;
    private String dnssec;

    private String registry_domain_id;

    private String registry_admin_id;
    private String admin_name;
    private String admin_organization;
    private String admin_street;
    private String admin_city;
    private String admin_state;
    private String admin_province;
    private String admin_postal_code;
    private String admin_country;
    private String admin_phone;
    private String admin_fax;
    private String admin_email;

    private String registry_expiry_date;
    private String registry_tech_id;
    private String tech_name;
    private String tech_organization;
    private String tech_street;
    private String tech_city;
    private String tech_state;
    private String tech_province;
    private String tech_postal_code;
    private String tech_country;
    private String tech_phone;
    private String tech_fax;
    private String tech_email;

    private String registrar_whois_server;
    private String registrar_url;
    private String registrar;
    private String registrar_iana_id;
    private String registrar_abuse_contact_email;
    private String registrar_abuse_contact_phone;

    private String registry_registrant_id;
    private String registrant_name;
    private String registrant_organization;
    private String registrant_street;
    private String registrant_city;
    private String registrant_state;
    private String registrant_province;
    private String registrant_postal_code;
    private String registrant_country;
    private String registrant_phone;
    private String registrant_fax;
    private String registrant_email;

    private String registry_billing_id;
    private String billing_name;
    private String billing_organization;
    private String billing_street;
    private String billing_city;
    private String billing_state;
    private String billing_province;
    private String billing_postal_code;
    private String billing_country;
    private String billing_phone;
    private String billing_fax;
    private String billing_email;

    private List<String> name_servers = new ArrayList<>();

    public void addNameServers(String name_server) {
        name_servers.add(name_server);
    }

    public String getDomain_name() {
        return domain_name;
    }

    public void setDomain_name(String domain_name) {
        this.domain_name = domain_name;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getDomain_status() {
        return domain_status;
    }

    public void setDomain_status(String domain_status) {
        this.domain_status = domain_status;
    }

    public String getDnssec() {
        return dnssec;
    }

    public void setDnssec(String dnssec) {
        this.dnssec = dnssec;
    }

    public String getRegistry_domain_id() {
        return registry_domain_id;
    }

    public void setRegistry_domain_id(String registry_domain_id) {
        this.registry_domain_id = registry_domain_id;
    }

    public String getRegistry_admin_id() {
        return registry_admin_id;
    }

    public void setRegistry_admin_id(String registry_admin_id) {
        this.registry_admin_id = registry_admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_organization() {
        return admin_organization;
    }

    public void setAdmin_organization(String admin_organization) {
        this.admin_organization = admin_organization;
    }

    public String getAdmin_street() {
        return admin_street;
    }

    public void setAdmin_street(String admin_street) {
        this.admin_street = admin_street;
    }

    public String getAdmin_city() {
        return admin_city;
    }

    public void setAdmin_city(String admin_city) {
        this.admin_city = admin_city;
    }

    public String getAdmin_state() {
        return admin_state;
    }

    public void setAdmin_state(String admin_state) {
        this.admin_state = admin_state;
    }

    public String getAdmin_province() {
        return admin_province;
    }

    public void setAdmin_province(String admin_province) {
        this.admin_province = admin_province;
    }

    public String getAdmin_postal_code() {
        return admin_postal_code;
    }

    public void setAdmin_postal_code(String admin_postal_code) {
        this.admin_postal_code = admin_postal_code;
    }

    public String getAdmin_country() {
        return admin_country;
    }

    public void setAdmin_country(String admin_country) {
        this.admin_country = admin_country;
    }

    public String getAdmin_phone() {
        return admin_phone;
    }

    public void setAdmin_phone(String admin_phone) {
        this.admin_phone = admin_phone;
    }

    public String getAdmin_fax() {
        return admin_fax;
    }

    public void setAdmin_fax(String admin_fax) {
        this.admin_fax = admin_fax;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getRegistry_expiry_date() {
        return registry_expiry_date;
    }

    public void setRegistry_expiry_date(String registry_expiry_date) {
        this.registry_expiry_date = registry_expiry_date;
    }

    public String getRegistry_tech_id() {
        return registry_tech_id;
    }

    public void setRegistry_tech_id(String registry_tech_id) {
        this.registry_tech_id = registry_tech_id;
    }

    public String getTech_name() {
        return tech_name;
    }

    public void setTech_name(String tech_name) {
        this.tech_name = tech_name;
    }

    public String getTech_organization() {
        return tech_organization;
    }

    public void setTech_organization(String tech_organization) {
        this.tech_organization = tech_organization;
    }

    public String getTech_street() {
        return tech_street;
    }

    public void setTech_street(String tech_street) {
        this.tech_street = tech_street;
    }

    public String getTech_city() {
        return tech_city;
    }

    public void setTech_city(String tech_city) {
        this.tech_city = tech_city;
    }

    public String getTech_state() {
        return tech_state;
    }

    public void setTech_state(String tech_state) {
        this.tech_state = tech_state;
    }

    public String getTech_province() {
        return tech_province;
    }

    public void setTech_province(String tech_province) {
        this.tech_province = tech_province;
    }

    public String getTech_postal_code() {
        return tech_postal_code;
    }

    public void setTech_postal_code(String tech_postal_code) {
        this.tech_postal_code = tech_postal_code;
    }

    public String getTech_country() {
        return tech_country;
    }

    public void setTech_country(String tech_country) {
        this.tech_country = tech_country;
    }

    public String getTech_phone() {
        return tech_phone;
    }

    public void setTech_phone(String tech_phone) {
        this.tech_phone = tech_phone;
    }

    public String getTech_fax() {
        return tech_fax;
    }

    public void setTech_fax(String tech_fax) {
        this.tech_fax = tech_fax;
    }

    public String getTech_email() {
        return tech_email;
    }

    public void setTech_email(String tech_email) {
        this.tech_email = tech_email;
    }

    public String getRegistrar_whois_server() {
        return registrar_whois_server;
    }

    public void setRegistrar_whois_server(String registrar_whois_server) {
        this.registrar_whois_server = registrar_whois_server;
    }

    public String getRegistrar_url() {
        return registrar_url;
    }

    public void setRegistrar_url(String registrar_url) {
        this.registrar_url = registrar_url;
    }

    public String getRegistrar() {
        return registrar;
    }

    public void setRegistrar(String registrar) {
        this.registrar = registrar;
    }

    public String getRegistrar_iana_id() {
        return registrar_iana_id;
    }

    public void setRegistrar_iana_id(String registrar_iana_id) {
        this.registrar_iana_id = registrar_iana_id;
    }

    public String getRegistrar_abuse_contact_email() {
        return registrar_abuse_contact_email;
    }

    public void setRegistrar_abuse_contact_email(String registrar_abuse_contact_email) {
        this.registrar_abuse_contact_email = registrar_abuse_contact_email;
    }

    public String getRegistrar_abuse_contact_phone() {
        return registrar_abuse_contact_phone;
    }

    public void setRegistrar_abuse_contact_phone(String registrar_abuse_contact_phone) {
        this.registrar_abuse_contact_phone = registrar_abuse_contact_phone;
    }

    public String getRegistry_registrant_id() {
        return registry_registrant_id;
    }

    public void setRegistry_registrant_id(String registry_registrant_id) {
        this.registry_registrant_id = registry_registrant_id;
    }

    public String getRegistrant_name() {
        return registrant_name;
    }

    public void setRegistrant_name(String registrant_name) {
        this.registrant_name = registrant_name;
    }

    public String getRegistrant_organization() {
        return registrant_organization;
    }

    public void setRegistrant_organization(String registrant_organization) {
        this.registrant_organization = registrant_organization;
    }

    public String getRegistrant_street() {
        return registrant_street;
    }

    public void setRegistrant_street(String registrant_street) {
        this.registrant_street = registrant_street;
    }

    public String getRegistrant_city() {
        return registrant_city;
    }

    public void setRegistrant_city(String registrant_city) {
        this.registrant_city = registrant_city;
    }

    public String getRegistrant_state() {
        return registrant_state;
    }

    public void setRegistrant_state(String registrant_state) {
        this.registrant_state = registrant_state;
    }

    public String getRegistrant_province() {
        return registrant_province;
    }

    public void setRegistrant_province(String registrant_province) {
        this.registrant_province = registrant_province;
    }

    public String getRegistrant_postal_code() {
        return registrant_postal_code;
    }

    public void setRegistrant_postal_code(String registrant_postal_code) {
        this.registrant_postal_code = registrant_postal_code;
    }

    public String getRegistrant_country() {
        return registrant_country;
    }

    public void setRegistrant_country(String registrant_country) {
        this.registrant_country = registrant_country;
    }

    public String getRegistrant_phone() {
        return registrant_phone;
    }

    public void setRegistrant_phone(String registrant_phone) {
        this.registrant_phone = registrant_phone;
    }

    public String getRegistrant_fax() {
        return registrant_fax;
    }

    public void setRegistrant_fax(String registrant_fax) {
        this.registrant_fax = registrant_fax;
    }

    public String getRegistrant_email() {
        return registrant_email;
    }

    public void setRegistrant_email(String registrant_email) {
        this.registrant_email = registrant_email;
    }

    public String getRegistry_billing_id() {
        return registry_billing_id;
    }

    public void setRegistry_billing_id(String registry_billing_id) {
        this.registry_billing_id = registry_billing_id;
    }

    public String getBilling_name() {
        return billing_name;
    }

    public void setBilling_name(String billing_name) {
        this.billing_name = billing_name;
    }

    public String getBilling_organization() {
        return billing_organization;
    }

    public void setBilling_organization(String billing_organization) {
        this.billing_organization = billing_organization;
    }

    public String getBilling_street() {
        return billing_street;
    }

    public void setBilling_street(String billing_street) {
        this.billing_street = billing_street;
    }

    public String getBilling_city() {
        return billing_city;
    }

    public void setBilling_city(String billing_city) {
        this.billing_city = billing_city;
    }

    public String getBilling_state() {
        return billing_state;
    }

    public void setBilling_state(String billing_state) {
        this.billing_state = billing_state;
    }

    public String getBilling_province() {
        return billing_province;
    }

    public void setBilling_province(String billing_province) {
        this.billing_province = billing_province;
    }

    public String getBilling_postal_code() {
        return billing_postal_code;
    }

    public void setBilling_postal_code(String billing_postal_code) {
        this.billing_postal_code = billing_postal_code;
    }

    public String getBilling_country() {
        return billing_country;
    }

    public void setBilling_country(String billing_country) {
        this.billing_country = billing_country;
    }

    public String getBilling_phone() {
        return billing_phone;
    }

    public void setBilling_phone(String billing_phone) {
        this.billing_phone = billing_phone;
    }

    public String getBilling_fax() {
        return billing_fax;
    }

    public void setBilling_fax(String billing_fax) {
        this.billing_fax = billing_fax;
    }

    public String getBilling_email() {
        return billing_email;
    }

    public void setBilling_email(String billing_email) {
        this.billing_email = billing_email;
    }

    public List<String> getName_servers() {
        return name_servers;
    }

    public void setName_servers(List<String> name_servers) {
        this.name_servers = name_servers;
    }
}
