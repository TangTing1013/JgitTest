package com.tt.mybatis2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: TangTing
 * @date: 13.6.20 12:35 AM
 * @description: ${DESCRIPTION}
 * @version: v1.0
 */

public class commentTest {

    public static void main(String[] args){
        String comment="Optional[/**\n" +
                " * 客户号\n" +
                " */\n" +
                "]";

        String javadoc="Optional[Javadoc{description=JavadocDescription{elements=[JavadocSnippet{text='行内客户号'}]}, blockTags=[]}]";
        /**
         * 匹配字符串
         * @param 获取参数信息
         * @return 获取返回信息
         */
        String res="Simple<String>";
        // "/\\*/[^\\n]*/g"
        //Pattern p = Pattern.compile("\\/\\*(\\s|.)*?\\*\\/",Pattern.DOTALL);
        Pattern p=Pattern.compile("text=\'(.*)\'");
        Matcher m = p.matcher(javadoc);
        while (m.find()) {
            System.out.println("the m.count:"+m.groupCount());
            System.out.println(m.group(1));
        }

    }

}
