package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    A website domain like "discuss.leetcode.com" consists of various subdomains.
    At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com".
    When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

    Now, call a "count-paired domain" to be a count (representing the number of visits this domain received),
    followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".

    We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains,
    (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
 */
public class SubdomainVisitCount {

    public static void main(String... args) {

        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        SubdomainVisitCount subdomainVisitCount = new SubdomainVisitCount();
        System.out.println(subdomainVisitCount.subdomainVisits(cpdomains));
    }

    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> m = new HashMap<>();

        for (String domain : cpdomains) {

            String[] s = domain.split(" ");
            int x = Integer.parseInt(s[0]);

            while (true) {

                Integer y = m.get(s[1]);
                m.put(s[1], y == null ? x : x + y);
                int z = s[1].indexOf('.');
                if (z == -1) break;
                s[1] = s[1].substring(1+z);
            }
        }

        return m.entrySet().stream().map(i -> i.getValue() + " " + i.getKey()).collect(Collectors.toList());
    }

}
