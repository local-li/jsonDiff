package me.codeleep.jsondiff.test.dataFactory;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import me.codeleep.jsondiff.model.JsonComparedOption;
import me.codeleep.jsondiff.model.MetaData;
import me.codeleep.jsondiff.utils.ResourceUtils;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: fen
 * @createTime: 2022/08/17 23:20
 * @description: 数组类型测试用例数据工厂，用于初始化数据
 */
public class ArrayDataFactory {
    private static String path = "array/MultArrays.json";
    private static String[] loadDataName = {"err", "right","optionRight","optionErr"};
    private static Map<String, Integer> maxMap = new HashMap<>();
    public static Map<String, ArrayList<MetaData>> arrayData = new HashMap<>();

    static {
        FactoryUtil.load(path,loadDataName,maxMap,arrayData);
    }

    @DataProvider(name = "right")
    public Object[] rightData() {
        return arrayData.get("right").toArray(new MetaData[maxMap.get("right")]);
    }

    @DataProvider(name = "err")
    public Object[] errData() {
        Object[] a =  arrayData.get("err").toArray(new MetaData[maxMap.get("err")]);
        return arrayData.get("err").toArray(new MetaData[maxMap.get("err")]);
    }

    @DataProvider(name = "optionRight")
    public Object[] optionRightData(){
        return arrayData.get("optionRight").toArray(new MetaData[maxMap.get("optionRight")]);
    }
    @DataProvider(name = "optionErr")
    public Object[] optionErrData(){
        return arrayData.get("optionErr").toArray(new MetaData[maxMap.get("optionErr")]);
    }
}
