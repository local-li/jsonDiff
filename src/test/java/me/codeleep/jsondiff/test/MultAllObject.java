package me.codeleep.jsondiff.test;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import me.codeleep.jsondiff.DefaultJsonDifference;
import me.codeleep.jsondiff.model.JsonCompareResult;
import me.codeleep.jsondiff.model.MetaData;
import me.codeleep.jsondiff.test.dataFactory.ObjectDataFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * @author: fen
 * @createTime: 2022/08/017 23:20
 * @description: 字典类型的测试类
 */
public class MultAllObject {

    @Test(dataProvider = "right",dataProviderClass = ObjectDataFactory.class)
    public void noOptionRightTest(MetaData metaData){
        DefaultJsonDifference defaultJsonDifference = new DefaultJsonDifference();
        JsonCompareResult jsonCompareResult = defaultJsonDifference
                .detectDiff((JSONObject) metaData.getExpect(), (JSONObject) metaData.getActual());
        System.out.println(JSON.toJSONString(metaData.getRet()) + "\n" + JSON.toJSONString(jsonCompareResult));
        if (metaData.getRet() != null)
            Assert.assertEquals(JSON.toJSONString(metaData.getRet()), JSON.toJSONString(jsonCompareResult));
        else
            Assert.assertEquals("{\"match\":true}", JSON.toJSONString(jsonCompareResult));
    }
    @Test(dataProvider = "err",dataProviderClass = ObjectDataFactory.class)
    public void noOptionErrTest(MetaData metaData){
        DefaultJsonDifference defaultJsonDifference = new DefaultJsonDifference();
        JsonCompareResult jsonCompareResult = defaultJsonDifference
                .detectDiff((JSONObject) metaData.getExpect(), (JSONObject) metaData.getActual());
        System.out.println(JSON.toJSONString(metaData.getRet()) + "\n" + JSON.toJSONString(jsonCompareResult));
        Assert.assertEquals(JSON.toJSONString(metaData.getRet()), JSON.toJSONString(jsonCompareResult));
    }
    @Test(dataProvider = "optionRight",dataProviderClass = ObjectDataFactory.class)
    public void optionRight(MetaData metaData){
        DefaultJsonDifference defaultJsonDifference = new DefaultJsonDifference();
        JsonCompareResult jsonCompareResult = defaultJsonDifference
                .option(metaData.getOption())
                .detectDiff((JSONObject) metaData.getExpect(), (JSONObject) metaData.getActual());
        System.out.println(JSON.toJSONString(metaData.getRet()) + "\n" + JSON.toJSONString(jsonCompareResult));
        if (metaData.getRet() != null)
            Assert.assertEquals(JSON.toJSONString(metaData.getRet()), JSON.toJSONString(jsonCompareResult));
        else
            Assert.assertEquals("{\"match\":true}", JSON.toJSONString(jsonCompareResult));
    }
    @Test(dataProvider = "optionErr",dataProviderClass = ObjectDataFactory.class)
    public void optionErr(MetaData metaData){
        DefaultJsonDifference defaultJsonDifference = new DefaultJsonDifference();
        JsonCompareResult jsonCompareResult = defaultJsonDifference
                .option(metaData.getOption())
                .detectDiff((JSONObject) metaData.getExpect(), (JSONObject) metaData.getActual());
        System.out.println(JSON.toJSONString(metaData.getRet()) + "\n" + JSON.toJSONString(jsonCompareResult));
        Assert.assertEquals(JSON.toJSONString(metaData.getRet()), JSON.toJSONString(jsonCompareResult));
    }
}
