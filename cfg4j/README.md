# Testing CFG4j

Using cfg4j to load application properties.


## Dependencies

```
  <dependency>
    <groupId>org.cfg4j</groupId>
    <artifactId>cfg4j-core</artifactId>
    <version>4.4.0</version>
  </dependency>
  <dependency>
    <groupId>org.cfg4j</groupId>
    <artifactId>cfg4j-git</artifactId>
    <version>4.4.0</version>
  </dependency>
```

## Loading properties from Github

There are properties that could be loaded directly from Github repository.

We're loading from here: `https://github.com/cfg4j/cfg4j-git-sample-config.git`

### Default properties
The library will load `application.property` file from the root path automatically.
We can see this example on bean definition. 
```java
    @Bean
    public ConfigurationProvider defaultAppProperties() {
    }
```

### Multitenant properties
We can specify the property file to load.
There is an example on bean definition.
```java
    @Bean
    public GitDbProperties environmentAppProperties() {
    }
```

## Final thoughts

The library is lightweight, and it is very intuitive to use.

We can also specify a periodical reload strategy, so it is not necessary to reload the application to get new values from property configuration.

There are some limitations:
- It is not possible to bind the properties to records (java 17), only to interfaces.
- it is not possible to bind the properties into a multi hierarchy data structure, for example:
  - file `application.property`:
    - some.setting = some setting string value
    - some.other.setting = what do you know? :p
  - target interface:
  - ```java
    public interface GitDefaultProperties {
    
        String setting();
    
        other other();
    
        interface other {
            String setting();
        }
    }
    ```