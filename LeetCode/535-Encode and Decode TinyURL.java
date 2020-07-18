import java.util.HashMap;
import java.util.Map;

/*
Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
*/

class Codec {
    Map<String, String> index = new HashMap<>();
    Map<String, String> revIndex = new HashMap<>();
    // Encodes a URL to a shortened URL.
    String tinyUrlPrefix = "http://tinyurl.com/";
    public String encode(String longUrl) {
        if(index.containsKey(longUrl)) return index.get(longUrl);
        String shortUrl = tinyUrlPrefix+longUrl.hashCode()+System.nanoTime();
        index.put(longUrl, shortUrl); revIndex.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return revIndex.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));