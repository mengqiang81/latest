* 先只用包名来区分CQRS的不同技术，比如对于command就是repository，对于query就是dao，对于ES就是search
* 因为技术实现非一等公民，所以这一层允许包名中存在技术术语，其他层包名中都不允许出现技术术语
* 怎么解决领域对象和JPA POJO的重复建设问题
  * 有一个思路是通过自定义注解+JSR380注解，在领域对象上定义它的持久化诉求，然后通过代码生成器生成JPA的POJO对象。再用MapStruct定义Mapper规则。
  * 短期内直接使用JPA的从table生成和MapStruct可能更务实一些，因为我们的表大部分已经存在了