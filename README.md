# Configuration

A Configuration wrapper for **Json**, **Yaml**, **Toml** and **Properties**, it uses **Jackson** as 
it's mainly reader ensuring the dependency is light-weight and performance.

## How to use

Want to take a look how easily you can create a new configuration? Take a look below:

```
final Configuration configuration = ConfigurationFactory.start(
    ConfigurationType.DRIVER,
    "PATH",
    "RESOURCE",
    false
);
``` 

For the **DRIVER** value, you must use the **JSON**, **YAML**, **TOML** and **PROPERTIES** type
from the ConfigurationType enum.</br>
For the **PATH** value, you must use the file's destination path.</br>
For the **RESOURCE** value, you must use the path of the internal configuration file.</br>

## Replace

Want to use universal replaces to when you get or set a value at the configuration?</br>
Our ReplaceValue is here to help you!

```
final ReplaceValue replace = ReplaceValue.builder()
    .value(VALUE_TO_BE_REPLACED)
    .type(ReplaceType.TYPE_OF_SUBSTITUTE)
    .build();

configuration.addReplacer(VALUE_TO_REPLACE, replace);
```

For the **VALUE_TO_BE_REPLACED** value, you must use the value that will be replaced.</br>
For the **TYPE_OF_SUBSTITUTE** value, you can use the **ALL**, **GET** and **SET** type
from the ReplaceType enum.</br>
For the **VALUE_TO_REPLACE** value, you must use the value that will be the replacement.</br>

Have more questions? Feel free to create a issue and help us out!

## How to install

### Maven

```
<dependency>
    <groupId>com.cefoler.configuration</groupId>
    <artifactId>configuration</artifactId>
    <version>VERSION</version>
</dependency>
```

### Gradle

```
dependencies {
   implementation "com.cefoler.configuration:configuration:VERSION"
}
```
