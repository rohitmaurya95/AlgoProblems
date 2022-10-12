package com.maurya.rohit.practise.karat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s: cpdomains){
            String[] a = s.split(" ");
            int n = Integer.parseInt(a[0]);
            String domain = a[1];
            for (int i=domain.length()-1; i>=0; i--){
                if(domain.charAt(i)=='.'){
                    String subDomain = domain.substring(i+1, domain.length());
                    int newCount = map.getOrDefault(subDomain, 0) + n;
                    map.put(subDomain, newCount);
                }
            }
            int newCount = map.getOrDefault(domain, 0) + n;
            map.put(domain, newCount);
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry:map.entrySet()){
            res.add(entry.getValue()+" "+entry.getKey());
        }
        return res;

    }
}
