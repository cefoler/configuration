# Configuration

A Configuration wrapper for **YML**, **JSON** and **Properties**, it uses **Jackson** as it's mainly reader ensuring the
dependency is light-weight and performatic.

**______________________________**

## How to use

Want to take a look how easily you can create a new configuration? Take a look below:

```
final Configuration configuration = ConfigurationFactory.start(
    ConfigurationType.YOUR_DRIVER,
    "YOUR_PATH",
    "settings.yml",
    false
);
``` 

For the **YOUR_DRIVER** value, you can use the YML, JSON and PROPERTIES type from the ConfigurationType enum.
The ConfigurationFactory as well supports properties to create the Configuration.

**______________________________**

## Replaces

Want to use universal replaces to when you get or set a value at the configuration?
Our ReplaceValue is here to help you!

```
final ReplaceValue replace = ReplaceValue.builder()
    .value(VALUE_TO_BE_REPLACED)
    .type(ReplaceType.ALL)
    .build();

configuration.getReplacer().put(VALUE_TO_REPLACE, replace);
```

By adding this to your code, the **VALUE_TO_REPLACE** will be the value set at every **VALUE_TO_BE_REPLACED** that is used
on the configuration file.
The value is a ReplaceType enum that can use the **GET, SET or ALL** values.

Have more questions? Feel free to create a issue and help us out!
