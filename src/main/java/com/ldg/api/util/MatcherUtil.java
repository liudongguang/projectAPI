package com.ldg.api.util;

/**
 * Created by LiuDongguang on 2017/7/20.
 */
public class MatcherUtil {
   // private final static Pattern JsORCsspattern = Pattern.compile("(/?\\w*)+(-?\\.?\\w+)*\\.{1}(css|js|png|jpg|gif|otf|eot|svg|ttf|woff)");
    //private final static Pattern JSPpattern = Pattern.compile("(/\\w*)+\\.{1}jsp");

    public final static boolean isstaticResource(String source) {
        if (source.endsWith(".js") || source.endsWith(".css") || source.endsWith(".png") || source.endsWith(".jpg") || source.endsWith(".gif")|| source.endsWith(".ico") || source.endsWith(".otf") || source.endsWith(".eot") || source.endsWith(".svg") || source.endsWith(".ttf") || source.endsWith(".woff")|| source.endsWith(".woff2")) {
            return true;
        }
        return false;
    }

    public final static boolean isJSP(String source) {
        if (source.endsWith(".jsp")){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isstaticResource("projectAPI/index-3.3.7.js"));
        System.out.println(isJSP("/projectAPI/pajaxapimain/index.jsp"));
        System.out.println(isJSP("/projectAPI/"));

    }
}
