package com.tt.mybatis2.json;

import net.sf.json.JSONArray;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author: TangTing
 * @date: 6.6.20 4:37 PM
 * @description: ${DESCRIPTION}
 * @version: v1.0
 */
public class CreateFileUtilTest {

    @Test
    public void createJsonFile() throws Exception {
        // 数据集合：
        List<Object> ffList = new ArrayList<Object>();

        Map<String, Object> ffMap = new HashMap<String, Object>();
        ffMap.put("ffName", "xfs_111");
        ffMap.put("latitude", "latitude");
        ffMap.put("longitude", "longitude");
        ffMap.put("status", (int)(Math.random() * 6 + 1));
        ffList.add(ffMap);
        // 将集合数据转换为json字符串(当然map集合亦可以)：
        JSONArray jsonObject = JSONArray.fromObject(ffList);
        String jsonString1 = jsonObject.toString();
        CreateFileUtil.createJsonFile(jsonString1, "/Users/tangting1013/IdeaProjects/mybatisDemo/src/main/java/com/tt/mybatis2/json", "ffList");
    }

}