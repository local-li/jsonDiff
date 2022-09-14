<h1 style="text-align: center">JsonDiff 高性能json差异发现工具</h1>
<div style="text-align: center">

[![GitHub license](https://img.shields.io/github/license/local-li/jsonDiff)](https://github.com/local-li/jsonDiff/blob/master/LICENSE)
[![star](https://gitee.com/local-li/json-diff/badge/star.svg?theme=white)](https://gitee.com/local-li/json-diff/stargazers)
<a href='https://gitee.com/local-li/json-diff/members'><img src='https://gitee.com/local-li/json-diff/badge/fork.svg?theme=white' alt='fork'></img></a>
[![GitHub stars](https://img.shields.io/github/stars/local-li/jsonDiff)](https://github.com/local-li/jsonDiff/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/local-li/jsonDiff)](https://github.com/local-li/jsonDiff/network)
[![GitHub issues](https://img.shields.io/github/issues/local-li/jsonDiff)](https://github.com/local-li/jsonDiff/issues)

</div>

## 介绍

它几乎可以发现任何JSON结构的差异，并且将错误信息反馈给用户。

### 优点

- 高效的
- 精准定位差异
- 轻量级
- 依赖非常干净，只依赖fastJson





## 使用文档

### 快速开始

#### 依赖引入

该工具的依赖极其干净，只依赖于alibab的

```xml
<!-- 版本请以maven仓库最版为准 -->
<dependency>
    <groupId>cn.xiaoandcai</groupId>
    <artifactId>jsonDiff</artifactId>
    <version>1.2.0</version>
</dependency>
```



#### 简单使用

```java
class {
    public void diffKeepOrder() {
        String array1 = "[1, 2, 3, 4, 5]";
        String array2 = "[1, 6, 3, 4, 5]";
        // 构建配置对象
        JsonComparedOption jsonComparedOption = new JsonComparedOption().setIgnoreOrder(true);
        // 初始化工具
        JsonCompareResult jsonCompareResult = new DefaultJsonDifference()
        			.option(jsonComparedOption)
          		// 对比
        			.detectDiff(JSON.parseArray(array1), JSON.parseArray(array2));
        System.out.println(JSON.toJSONString(jsonCompareResult));
    }
}
```

输出结果

```json
{
  "defectsList": [
    {
      "actual": 6,
      "expect": 2,
      "illustrate": "The 1 element is inconsistent",
      "indexPath": "root[1]"
    }
  ],
  "match": false
}
```

工具可以准确发现不同之处，进行提示用户；



#### 配置介绍

| 配置        | 类型                    | 备注                                                         |
| ----------- | ----------------------- | ------------------------------------------------------------ |
| ignoreOrder | boolean                 | 是否比较过程中忽略数组顺序                                   |
| mapping     | Map<String, String>     | 将真实字段映射到期望字段，key是真实字段name，value是期望的字段name |
| ignorePath  | List                    | 忽略的path，当对比到对应的层级时，会被跳过。如果遇到数组请直接使用 `[] `来代替，并且不需要加 `.` 来分隔 |
| keyFunction | Function<String, Stack> | ignoreOrder=true时，数组是元素对象时, 指定根据哪些key联系对象。入参是当前的path |

工具提供了四个配置，来之对比过程中一些其他的要求。工具还在积极开发中，如果有新的需求，可以给作者提一个issuse。



#### 进阶

前面提到工具几乎可以支持所有json结果的对比校验，并且发现差异。那它到底可以支持哪些呢，不知道是否符合你的需求呢？

- 对象 ✅

  这是最简单的数据结构了，其中元素都以key-value构成，key是字符串，value可以是任何数据结构。



- 数组 ✅

  支持严格顺序对比和忽略顺序对比，可以细化数组元素的类型

    - 基本类型  ✅

    - 对象类型  ✅

      该类型在对比时，可以通过keyFunction参数进行元素是否进行比较

    - 数组类型 ✅

      元素也是数组，这样就形成了多维数组，工具理论上来说支持n维数组的对比

    - 元素类型不统一 ✅

      数组中，类型可能包含前面三种类型，这时工具会按照类型分类进行匹配，最后找不到的元素再反馈给用户。



由于json结构在单个看来，就只有对象和数组两种类型，该工具完美支持了所有类型。

交流群：710435809
![](http://typora.xiaoandcai.cn/typora-weidian-mac/20220914225028.png?me-host=weidian-mac)