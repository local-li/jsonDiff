package me.codeleep.jsondiff.handle.array;

import com.alibaba.fastjson2.JSONArray;
import me.codeleep.jsondiff.handle.AbstractDiffHandle;
import me.codeleep.jsondiff.handle.RunTimeDataFactory;
import me.codeleep.jsondiff.model.Defects;
import me.codeleep.jsondiff.model.JsonCompareResult;

/**
 * @author: codeleep
 * @createTime: 2022/07/30 15:25
 * @description: 抽象数组处理器
 */
public abstract class AbstractArrayHandle extends AbstractDiffHandle implements ArrayHandle {


    @Override
    public JsonCompareResult handle(JSONArray expectArray, JSONArray actualArray) {
        int expectLen = expectArray.size();
        int actualLen = actualArray.size();

        if (actualLen != expectLen) {
            Defects defects = new Defects()
                    .setExpect(expectLen)
                    .setActual(actualLen)
                    .setIllustrate("Array length is inconsistent")
                    .setIndexPath(getCurrentPath());
            RunTimeDataFactory.getResultInstance().addDefects(defects);
            return RunTimeDataFactory.getResultInstance();
        }
        // 空数组
        if (actualLen == 0) {
            return RunTimeDataFactory.getResultInstance();
        }

        // 转化数组, 遍历加速
        Object[] expect = expectArray.toArray();
        Object[] actual = actualArray.toArray();

        if (RunTimeDataFactory.getOptionInstance().isIgnoreOrder()) {
            compareIgnoreOrder(expect, actual);
        }else {
            compareKeepOrder(expect, actual);
        }

        /**
         * 是否需要
         */
        return RunTimeDataFactory.getResultInstance();
    }

    protected abstract void compareKeepOrder(Object[] expect, Object[] actual);

    protected abstract void compareIgnoreOrder(Object[] expect, Object[] actual);

}
