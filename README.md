# starter-canal-copy
A copy of chenqian56131/spring-boot-starter-canal.

**源项目地址:[spring-boot-starter-canal](https://github.com/chenqian56131/spring-boot-starter-canal)**
> 个人学习使用，仅更改包名，修改pom文件，方便打包，保留原有所有注释与说明

[在Maven中使用](https://github.com/NewGr8Player/maven-repo)

# spring-boot-starter-canal
## canal starter

### eg(annotation):

-------------------------
```
@CanalEventListener
public class MyEventListener {

    @InsertListenPoint
    public void onEvent(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        //do something...
    }

    @UpdateListenPoint
    public void onEvent1(CanalEntry.RowData rowData) {
        //do something...
    }

    @DeleteListenPoint
    public void onEvent3(CanalEntry.EventType eventType) {
        //do something...
    }

    @ListenPoint(destination = "example", schema = "canal-test", table = {"t_user", "test_table"}, eventType = CanalEntry.EventType.UPDATE)
    public void onEvent4(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        //do something...
    }
}
```

### eg(interface):
-------------------------------
```
@Component
public class MyEventListener2 implements CanalEventListener {
    @Override
    public void onEvent(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        //do something...
    }
}

@Component
public class MyEventListener2 implements DmlCanalEventListener {
    @Override
    public void onInsert(CanalEntry.RowData rowData) {
        //do something...
    }

    @Override
    public void onUpdate(CanalEntry.RowData rowData) {
        //do something...
    }

    @Override
    public void onDelete(CanalEntry.RowData rowData) {
        //do something...
    }
}

```

## Config
| config      |    describe |
| :------- | :-------|
| canal.client.instances.{destination}.clusterEnabled | enable cluster mod |
| canal.client.instances.{destination}.zookeeperAddress | zookeeper address(required when clusterEnabled is true) |
| canal.client.instances.{destination}.host | canal server host(required when clusterEnabled is false) |
| canal.client.instances.{destination}.port  | canal server port (required when clusterEnabled is false)|
| canal.client.instances.{destination}.batchSize  | size when trying to get messages from server |
| canal.client.instances.{destination}.acquireInterval  | interval of acquiring the messages |
| canal.client.instances.{destination}.filter  | client's subscribe-filter |
| canal.client.instances.{destination}.userName  | user name |
| canal.client.instances.{destination}.password  | password |
| canal.client.instances.{destination}.retryCount  | retry count when error occurred such as IoException. |
