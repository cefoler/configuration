package com.celeste.configuration.bukkit;

import com.celeste.configuration.model.provider.Configuration;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public final class MessageFormatter {

  private final Configuration config;

  public List<String> getList(final String path) {
    return config.getStringList(path).stream()
        .map(s -> s.replace("&", "§"))
        .collect(Collectors.toList());
  }

  public String getMessage(final String path) {
    return config.getString(path).replace("&", "§");
  }

}
