# starter-canal-copy

[在Maven中使用](https://github.com/NewGr8Player/maven-repo)

# spring-boot-starter-canal
## canal starter

### 注解使用Demo:

-------------------------

```java
@CanalEventListener
public class MyEventListener {

    @InsertListenPoint
    public void onEvent(String tableName,CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        //do something...
    }

    @UpdateListenPoint
    public void onEvent1(String tableName,CanalEntry.RowData rowData) {
        //do something...
    }

    @DeleteListenPoint
    public void onEvent3(String tableName,CanalEntry.EventType eventType) {
        //do something...
    }

    @ListenPoint(destination = "example", schema = "canal-test", table = {"t_user", "test_table"}, eventType = CanalEntry.EventType.UPDATE)
    public void onEvent4(String tableName,CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        //do something...
    }
}
```

### 实现接口Demo:

-------------------------------

```java
@Component
public class MyEventListener2 implements CanalEventListener {
    @Override
    public void onEvent(String tableName,CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        //do something...
    }
}

@Component
public class MyEventListener2 implements DmlCanalEventListener {
    @Override
    public void onInsert(String tableName,CanalEntry.RowData rowData) {
        //do something...
    }

    @Override
    public void onUpdate(String tableName,CanalEntry.RowData rowData) {
        //do something...
    }

    @Override
    public void onDelete(String tableName,CanalEntry.RowData rowData) {
        //do something...
    }
}
```

## Config
```yaml
canal:
  client:
    instances:
      example: # 实例名，可配置多个该节点 String
        host: 127.0.0.1 # ip或域名 String
        port: 11111 # 端口 Integer
        batch-size: 1000 # 最大并发消息数量 Integer
        cluster-enabled: false # 集群模式 boolean
        zookeeper-address: # 当集群模式开启时，需要填写该地址,多个使用逗号分隔
```
