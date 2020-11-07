package com.maurya.rohit.Problems.Misc;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExtractGroup {
    public static void main(String[] args) {
        String stringToSearch = "Operation Completed Successfully. Record Uploaded - 1020, Record Rejected - 0";

        // specify that we want to search for two groups in the string
        Pattern p = Pattern.compile("(Record Uploaded\\s+-\\s+\\d+)");
        Matcher m = p.matcher(stringToSearch);

        // if our pattern matches the string, we can try to extract our groups
        if (m.find()) {
            // get the two groups we were looking for
            String group1 = m.group(1);

            // print the groups, with a wee bit of formatting
            System.out.println(Integer.parseInt(group1.split("-")[1].trim()));
        }

    }
}
