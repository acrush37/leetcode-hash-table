package medium;

import java.util.HashMap;
import java.util.Map;

/*
    Design the encode and decode methods for the TinyURL service.
    There is no restriction on how your encode/decode algorithm should work.
    You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class EncodeAndDecodeTinyURL {

    private Map<String, String> f = new HashMap<>();

    public static void main(String... args) {

        EncodeAndDecodeTinyURL encodeAndDecodeTinyURL = new EncodeAndDecodeTinyURL();
        String s = "http://www.baidu.com";
        System.out.println(s = encodeAndDecodeTinyURL.encode(s));
        System.out.println(encodeAndDecodeTinyURL.decode(s));
    }

    public String encode(String longUrl) {

        String shortUrl = longUrl.substring(0, longUrl.length()-5);
        f.put(shortUrl, longUrl);
        return shortUrl;
    }

    public String decode(String shortUrl) {
        return f.get(shortUrl);
    }

}
