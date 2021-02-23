package model;

import lombok.Data;

@Data
public class Address {

    private String firstName;
    private String lastName;
    private String companyName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String additionalInfo;
    private String homePhone;
    private String mobilePhone;
    private String addressAlias;
}
