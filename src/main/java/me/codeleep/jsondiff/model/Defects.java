package me.codeleep.jsondiff.model;


public class Defects {

    /**
     * 期望结果
     */
    private Object expect;

    /**
     * 实际结果
     */
    private Object actual;

    /**
     * 索引地址
     */
    private String indexPath;

    /**
     * 说明
     */
    private String illustrate;


    public Defects setExpect(Object expect) {
        this.expect = expect;
        return this;
    }

    public Defects setActual(Object actual) {
        this.actual = actual;
        return this;
    }

    public Defects setIndexPath(String indexPath) {
        this.indexPath = indexPath;
        return this;
    }

    public Defects setIllustrate(String illustrate) {
        this.illustrate = illustrate;
        return this;
    }

    public Object getExpect() {
        return expect;
    }

    public Object getActual() {
        return actual;
    }

    public String getIndexPath() {
        return indexPath;
    }

    public String getIllustrate() {
        return illustrate;
    }
}
